package com.devdyna.justdynathings.registry.interfaces.block;

import java.util.List;

import com.devdyna.justdynathings.registry.types.zItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemHandlerHelper;

public interface Harvestable {

    /**
     * use
     * <br/>
     * <br/>
     * Block.getDrops(BlockState, ServerLevel, BlockPos,
     * BlockEntity, Entity, ItemStack)
     * <br/>
     * <br/>
     * to get default loot table
     */
    List<ItemStack> getResult(BlockState state, Player player, BlockPos pos,
            Level level);

    boolean requireWrench();

    boolean requireCrouching();

    default boolean canHarvest(ItemStack item, BlockState state, Player player, InteractionHand hand, BlockPos pos,
            Level level) {

        if (requireWrench() ? !item.is(zItemTags.UNIVERSAL_WRENCH) : false)
            return false;

        if (requireCrouching() ? !player.isCrouching() : false)
            return false;

        player.playSound(SoundEvents.ITEM_FRAME_REMOVE_ITEM);

        player.swing(hand);
        level.removeBlock(pos, false);

        if (!player.isCreative())
            getResult(state, player, pos, level).forEach(it -> ItemHandlerHelper.giveItemToPlayer(player, item));

        return true;

    }

}
