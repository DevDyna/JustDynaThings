package com.devdyna.justdynathings.init.builder.advanced_energy_transmitter;

import com.devdyna.cakesticklib.api.aspect.logic.BucketInteraction;
import com.direwolf20.justdirethings.common.blocks.EnergyTransmitter;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class AdvEnergyTransmitterBlock extends EnergyTransmitter implements BucketInteraction {

    public AdvEnergyTransmitterBlock(Properties properties) {
        super(properties);
    }

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AdvEnergyTransmitterBE(pos, state);
    }

    public void openMenu(Player player, BlockPos blockPos) {
        player.openMenu(new SimpleMenuProvider((windowId, playerInventory, playerEntity) -> {
            return new AdvEnergyTransmitterGUI(windowId, playerInventory, blockPos);
        }, Component.translatable("")), (buf) -> {
            buf.writeBlockPos(blockPos);
        });
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
            Player player, InteractionHand hand, BlockHitResult hitResult) {
        return bucketAction(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    public InteractionResult executeWhenEmpty(ItemStack stack, BlockState state, Level level, BlockPos pos,
            Player player, InteractionHand hand, BlockHitResult hitResult) {
        this.openMenu(player, pos);
        return InteractionResult.SUCCESS;
    }

    @Override
    public InteractionResult executeWhenNotBucket(ItemStack stack, BlockState state, Level level, BlockPos pos,
            Player player, InteractionHand hand, BlockHitResult hitResult) {
        this.openMenu(player, pos);
        return InteractionResult.SUCCESS;
    }

}
