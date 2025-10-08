package com.devdyna.justdynathings.registry.builders;

import static com.devdyna.justdynathings.Main.ID;

import java.util.List;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.registry.types.zBlockTags;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.direwolf20.justdirethings.common.blockentities.BlockSwapperT1BE;
import com.direwolf20.justdirethings.common.items.datacomponents.JustDireDataComponents;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.GlobalPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("null")
public class SwapperWand extends Item {

    public SwapperWand() {
        super(zProperties.iProp
                .component(JustDireDataComponents.BOUND_GLOBAL_POS, null)
                .stacksTo(1).durability(256));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        var item = player.getItemInHand(hand);
        if (item.get(JustDireDataComponents.BOUND_GLOBAL_POS) != null) {
            item.set(JustDireDataComponents.BOUND_GLOBAL_POS, null);
            player.displayClientMessage(Component.translatable(ID + ".clear_pos"), true);
            player.playSound(SoundEvents.ITEM_FRAME_REMOVE_ITEM, 1.0F, 1.0F);
            return InteractionResultHolder.success(item);
        } else
            return super.use(level, player, hand);
    }

    @Override
    public InteractionResult useOn(UseOnContext c) {

        var level = c.getLevel();
        var pos = c.getClickedPos();
        // var face = c.getClickedFace();
        var item = c.getItemInHand();
        var player = c.getPlayer();
        var state = level.getBlockState(pos);

        if (c.getHand() != InteractionHand.OFF_HAND) {

            var globalPos = item.get(JustDireDataComponents.BOUND_GLOBAL_POS);

            if (level.getBlockEntity(pos) == null && !level.getBlockState(pos).is(zBlockTags.SWAPPER_DENY))
                if (globalPos == null)
                    bindGPos(item, player, level, pos);
                else
                    swapBlocks(player, item, level, state, pos);
            else
                pickUpFail(player);

            return InteractionResult.SUCCESS;
        }

        return super.useOn(c);
    }

    private void bindGPos(ItemStack item, Player player, Level level, BlockPos pos) {
        item.set(JustDireDataComponents.BOUND_GLOBAL_POS, new GlobalPos(level.dimension(), pos));
        player.playSound(SoundEvents.END_PORTAL_FRAME_FILL, 1.0F, 1.0F);
    }

    private void swapBlocks(Player player, ItemStack item, Level level, BlockState state, BlockPos pos) {

        var wandPos = item.get(JustDireDataComponents.BOUND_GLOBAL_POS).pos();

        if (level.getBlockEntity(wandPos) != null || level.getBlockState(wandPos).is(zBlockTags.SWAPPER_DENY)) {
            swapFail(player);
            return;
        }

        var transmit = level.getBlockState(item.get(JustDireDataComponents.BOUND_GLOBAL_POS).pos());
        var recieve = state;

        if (!level.isClientSide()) {

            level.setBlockAndUpdate(wandPos, recieve);
            level.setBlockAndUpdate(pos, transmit);
            BlockSwapperT1BE.teleportParticles((ServerLevel) level,
                    wandPos);
            BlockSwapperT1BE.teleportParticles((ServerLevel) level, pos);
            level.markAndNotifyBlock(pos, level.getChunkAt(pos), state, state, 3, 512);
            level.markAndNotifyBlock(wandPos,
                    level.getChunkAt(wandPos), state, state, 3, 512);
        }

        player.playSound(SoundEvents.END_PORTAL_FRAME_FILL, 3.0F, 0.25F);
        item.set(JustDireDataComponents.BOUND_GLOBAL_POS, null);

        consumeDurability(player, item);
    }

    private void failPlace(Player player) {
        player.playSound(SoundEvents.ITEM_FRAME_ROTATE_ITEM);
    }

    private void pickUpFail(Player player) {
        player.displayClientMessage(Component.translatable(ID + ".invalid_block"), true);
        failPlace(player);
    }

    private void swapFail(Player player) {
        player.displayClientMessage(Component.translatable(ID + ".init_invalid"), true);
        failPlace(player);
    }

    private void consumeDurability(Player player, ItemStack item) {
        if (!player.isCreative()) {
            if (item.getMaxDamage() - item.getDamageValue() == 1) {
                item.shrink(1);
                player.playSound(SoundEvents.ITEM_BREAK);
            } else
                item.setDamageValue(item.getDamageValue() + 1);
        }
    }

    @Override
    public void appendHoverText(ItemStack i, TooltipContext c, List<Component> t,
            TooltipFlag f) {

        t.add(Component.translatable(ID + "." + Constants.Wands.Swapper));

        if (i.get(JustDireDataComponents.BOUND_GLOBAL_POS) != null) {
            t.add(Component.translatable(ID + ".wand.dimension")
                    .append(Component
                            .literal(i.get(JustDireDataComponents.BOUND_GLOBAL_POS).dimension().registry().toString())
                            .withStyle(ChatFormatting.GREEN)));
            t.add(Component.translatable(ID + ".wand.pos")

                    .append(Component
                            .literal("" + i.get(JustDireDataComponents.BOUND_GLOBAL_POS).pos().getX())
                            .withStyle(ChatFormatting.AQUA))

                    .append(Component
                            .literal(" " + i.get(JustDireDataComponents.BOUND_GLOBAL_POS).pos().getY())
                            .withStyle(ChatFormatting.AQUA))

                    .append(Component
                            .literal(" " + i.get(JustDireDataComponents.BOUND_GLOBAL_POS).pos().getZ())
                            .withStyle(ChatFormatting.AQUA)));
        }
    }
}
