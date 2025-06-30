package com.devdyna.justdynathings.registry.builders;

import static com.devdyna.justdynathings.Main.ID;

import java.util.List;

import com.devdyna.justdynathings.registry.types.zBlockTags;
import com.devdyna.justdynathings.registry.types.zComponents;
import com.devdyna.justdynathings.registry.types.zProperties;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("null")
public class PickerWand extends Item {

    public PickerWand() {
        super(zProperties.iProp
                .component(zComponents.STATE, null)
                .stacksTo(1).durability(256));
    }

    @Override
    public InteractionResult useOn(UseOnContext c) {

        var level = c.getLevel();
        var pos = c.getClickedPos();
        var face = c.getClickedFace();
        var item = c.getItemInHand();
        var player = c.getPlayer();

        if (c.getHand() != InteractionHand.OFF_HAND) {

            var state = item.get(zComponents.STATE);

            if (state == null) {
                if (level.getBlockEntity(pos) == null && !level.getBlockState(pos).is(zBlockTags.PICKER_DENY))
                    pickupBlock(item, pos, level, player, face);
                else
                    pickUpFail(player);
            } else if (level.getBlockState(pos).isAir())
                failPlace(player);
            else
                placeBlock(item, pos, level, player, state, face);

            return InteractionResult.SUCCESS;
        }

        return super.useOn(c);
    }

    private void pickupBlock(ItemStack item, BlockPos pos, Level level, Player player, Direction face) {
        item.set(zComponents.STATE, level.getBlockState(pos));
        level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
        player.playSound(SoundEvents.ITEM_FRAME_ADD_ITEM);
    }

    private void placeBlock(ItemStack item, BlockPos pos, Level level, Player player, BlockState state,
            Direction face) {
        level.setBlockAndUpdate(pos.relative(face), state);
        item.set(zComponents.STATE, null);
        player.playSound(SoundEvents.ITEM_FRAME_REMOVE_ITEM);
        consumeDurability(player, item);
    }

    private void failPlace(Player player) {
        player.playSound(SoundEvents.ITEM_FRAME_ROTATE_ITEM);
    }

    private void pickUpFail(Player player) {
        player.displayClientMessage(Component.translatable(ID + ".invalid_block"), true);
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
        if (i.get(zComponents.STATE) != null) {
            t.add(Component.translatable(ID + ".wand.blockstate")
                    .append(Component
                            .literal(i.get(zComponents.STATE).getBlock().getName().getString())
                            .withStyle(ChatFormatting.GREEN)));
        }
    }
}
