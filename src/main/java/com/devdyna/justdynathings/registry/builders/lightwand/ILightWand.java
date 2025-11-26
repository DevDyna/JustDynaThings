package com.devdyna.justdynathings.registry.builders.lightwand;

import com.devdyna.justdynathings.ConfigCommon;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zEntityTags;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LightBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.util.FakePlayer;

@SuppressWarnings("null")
public interface ILightWand {

    boolean condToRun(ItemStack stack);

    void consume(Player player, ItemStack stack, InteractionHand hand);

    int glowingDuration();

    default InteractionResult entityGlowing(ItemStack itemStack, Player player, LivingEntity entity,
            InteractionHand hand) {

        if (checkFakePlayers(player))
            if (condToRun(itemStack) && ConfigCommon.LIGHT_WAND_ENTITY_GLOWING.get())
                if (checkEntity(entity)) {
                    entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, glowingDuration()));

                    if (ConfigCommon.LIGHT_WAND_SOUND.get())
                        player.level().playSound(player, player.getOnPos(), SoundEvents.ALLAY_ITEM_GIVEN,
                                SoundSource.PLAYERS,
                                0.25F, 1F);

                    consume(player, itemStack, hand);

                    return InteractionResult.SUCCESS;
                }
        return InteractionResult.FAIL;
    }

    private boolean checkEntity(LivingEntity entity) {
        return !entity.hasEffect(MobEffects.GLOWING)
                && !entity.getType().is(zEntityTags.LIGHT_WAND_GLOWING_DENY)
                && !(entity instanceof Player)
                && !(entity instanceof FakePlayer)
                && !entity.isMultipartEntity();
    }

    default InteractionResult itemUse(UseOnContext c) {
        var level = c.getLevel();
        var pos = c.getClickedPos();
        var dir = c.getClickedFace();
        var player = c.getPlayer();
        var item = c.getItemInHand();
        var offset = pos.relative(dir);
        var hand = c.getHand();
        var state = level.getBlockState(pos);
        var ofstate = level.getBlockState(offset);

        if (checkFakePlayers(player)) {
            if (player.isCrouching() && state.is(zBlocks.LIGHT_WAND_BLOCK.get())
                    && ConfigCommon.LIGHT_WAND_CHANGE.get())
                return changeLight(level, pos, hand, player, state);

            if (ofstate.canBeReplaced() && !ofstate.is(zBlocks.LIGHT_WAND_BLOCK.get())
                    && ConfigCommon.LIGHT_WAND_PLACING.get())
                return createLight(player, item, hand, level, offset);
        }

        return InteractionResult.FAIL;
    }

    /**
     * place a light block at specific pos including waterlogging
     */
    private InteractionResult createLight(Player player, ItemStack item, InteractionHand hand, Level level,
            BlockPos pos) {
        if (!player.isCreative())
            consume(player, item, hand);

        var fluid = level.getFluidState(pos);

        level.setBlockAndUpdate(pos, zBlocks.LIGHT_WAND_BLOCK.get().defaultBlockState()
                .setValue(BlockStateProperties.WATERLOGGED,
                        !fluid.isEmpty() && fluid.isSource() && fluid.is(Fluids.WATER)));

        if (ConfigCommon.LIGHT_WAND_SOUND.get())
            player.level().playSound(player, player.getOnPos(), SoundEvents.ALLAY_ITEM_GIVEN,
                    SoundSource.PLAYERS,
                    0.25F, 1F);

        return InteractionResult.SUCCESS;
    }

    /**
     * shrink light level of light block (cycle reverse)
     */
    private InteractionResult changeLight(Level level, BlockPos pos, InteractionHand hand, Player player,
            BlockState state) {
        level.setBlock(pos,
                state.setValue(LightBlock.LEVEL,
                        state.getValue(LightBlock.LEVEL) == 0 ? 15
                                : state.getValue(LightBlock.LEVEL) - 1),
                2);
        player.swing(hand);

        if (ConfigCommon.LIGHT_WAND_SOUND.get())
            player.level().playSound(player, player.getOnPos(), SoundEvents.ALLAY_ITEM_GIVEN,
                    SoundSource.PLAYERS,
                    0.25F, 1F);

        return InteractionResult.SUCCESS;
    }

    private boolean checkFakePlayers(Player player){
        return ConfigCommon.FAKEPLAYER_LIGHT_WAND.get() ?  true : player instanceof FakePlayer;
    }

}
