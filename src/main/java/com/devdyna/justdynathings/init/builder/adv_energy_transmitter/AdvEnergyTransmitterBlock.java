package com.devdyna.justdynathings.init.builder.adv_energy_transmitter;

import com.devdyna.cakesticklib.api.aspect.logic.BucketInteraction;
import com.direwolf20.justdirethings.common.blocks.EnergyTransmitter;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AdvEnergyTransmitterBlock extends EnergyTransmitter implements BucketInteraction {

    public AdvEnergyTransmitterBlock(Properties properties) {
        super(properties.sound(SoundType.METAL).strength(2.0F).noOcclusion().forceSolidOn()
                .isRedstoneConductor(BaseMachineBlock::never));
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

    @Override
    public net.minecraft.world.phys.shapes.VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos,
            CollisionContext context) {
        VoxelShape shape = Shapes.empty();

        switch (state.getValue(FACING)) {
            case NORTH -> {
                shape = Shapes.empty();
                shape = Shapes.join(shape, Shapes.box(0.4375, 0.4375, 0.5625, 0.5625, 0.5625, 0.6875), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.3125, 0.3125, 0.125, 0.6875, 0.6875, 0.5625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.375, 0.25, 0.125, 0.625, 0.3125, 0.1875), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.25, 0.375, 0.125, 0.3125, 0.625, 0.1875), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.6875, 0.375, 0.125, 0.75, 0.625, 0.1875), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.375, 0.6875, 0.125, 0.625, 0.75, 0.1875), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.6875, 0.375, 0.25, 0.75, 0.625, 0.5), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.25, 0.375, 0.25, 0.3125, 0.625, 0.5), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.375, 0.25, 0.25, 0.625, 0.3125, 0.5), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.375, 0.6875, 0.25, 0.625, 0.75, 0.5), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.1875, 0.1875, 0.1875, 0.8125, 0.8125, 0.25), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.1875, 0.1875, 0.0625, 0.8125, 0.8125, 0.125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.25, 0.25, 0, 0.75, 0.75, 0.0625), BooleanOp.OR);
            }
            case SOUTH -> {
                shape = Shapes.empty();
                shape = Shapes.join(shape, Shapes.box(0.4375, 0.4375, 0.3125, 0.5625, 0.5625, 0.4375), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.3125, 0.3125, 0.4375, 0.6875, 0.6875, 0.875), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.375, 0.25, 0.8125, 0.625, 0.3125, 0.875), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.6875, 0.375, 0.8125, 0.75, 0.625, 0.875), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.25, 0.375, 0.8125, 0.3125, 0.625, 0.875), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.375, 0.6875, 0.8125, 0.625, 0.75, 0.875), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.25, 0.375, 0.5, 0.3125, 0.625, 0.75), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.6875, 0.375, 0.5, 0.75, 0.625, 0.75), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.375, 0.25, 0.5, 0.625, 0.3125, 0.75), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.375, 0.6875, 0.5, 0.625, 0.75, 0.75), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.1875, 0.1875, 0.75, 0.8125, 0.8125, 0.8125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.1875, 0.1875, 0.875, 0.8125, 0.8125, 0.9375), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.25, 0.25, 0.9375, 0.75, 0.75, 1), BooleanOp.OR);
            }
            case WEST -> {
                shape = Shapes.empty();
                shape = Shapes.join(shape, Shapes.box(0.5625, 0.4375, 0.4375, 0.6875, 0.5625, 0.5625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.125, 0.3125, 0.3125, 0.5625, 0.6875, 0.6875), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.125, 0.25, 0.375, 0.1875, 0.3125, 0.625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.125, 0.375, 0.6875, 0.1875, 0.625, 0.75), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.125, 0.375, 0.25, 0.1875, 0.625, 0.3125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.125, 0.6875, 0.375, 0.1875, 0.75, 0.625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.25, 0.375, 0.25, 0.5, 0.625, 0.3125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.25, 0.375, 0.6875, 0.5, 0.625, 0.75), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.25, 0.25, 0.375, 0.5, 0.3125, 0.625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.25, 0.6875, 0.375, 0.5, 0.75, 0.625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.1875, 0.1875, 0.1875, 0.25, 0.8125, 0.8125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.0625, 0.1875, 0.1875, 0.125, 0.8125, 0.8125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0, 0.25, 0.25, 0.0625, 0.75, 0.75), BooleanOp.OR);
            }
            case EAST -> {
                shape = Shapes.empty();
                shape = Shapes.join(shape, Shapes.box(0.3125, 0.4375, 0.4375, 0.4375, 0.5625, 0.5625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.4375, 0.3125, 0.3125, 0.875, 0.6875, 0.6875), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.8125, 0.25, 0.375, 0.875, 0.3125, 0.625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.8125, 0.375, 0.25, 0.875, 0.625, 0.3125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.8125, 0.375, 0.6875, 0.875, 0.625, 0.75), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.8125, 0.6875, 0.375, 0.875, 0.75, 0.625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.5, 0.375, 0.6875, 0.75, 0.625, 0.75), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.5, 0.375, 0.25, 0.75, 0.625, 0.3125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.5, 0.25, 0.375, 0.75, 0.3125, 0.625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.5, 0.6875, 0.375, 0.75, 0.75, 0.625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.75, 0.1875, 0.1875, 0.8125, 0.8125, 0.8125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.875, 0.1875, 0.1875, 0.9375, 0.8125, 0.8125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.9375, 0.25, 0.25, 1, 0.75, 0.75), BooleanOp.OR);
            }
            case DOWN -> {
                shape = Shapes.empty();
                shape = Shapes.join(shape, Shapes.box(0.4375, 0.5625, 0.4375, 0.5625, 0.6875, 0.5625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.3125, 0.125, 0.3125, 0.6875, 0.5625, 0.6875), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.375, 0.125, 0.25, 0.625, 0.1875, 0.3125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.6875, 0.125, 0.375, 0.75, 0.1875, 0.625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.25, 0.125, 0.375, 0.3125, 0.1875, 0.625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.375, 0.125, 0.6875, 0.625, 0.1875, 0.75), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.25, 0.25, 0.375, 0.3125, 0.5, 0.625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.6875, 0.25, 0.375, 0.75, 0.5, 0.625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.375, 0.25, 0.25, 0.625, 0.5, 0.3125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.375, 0.25, 0.6875, 0.625, 0.5, 0.75), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.1875, 0.1875, 0.1875, 0.8125, 0.25, 0.8125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.1875, 0.0625, 0.1875, 0.8125, 0.125, 0.8125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.25, 0, 0.25, 0.75, 0.0625, 0.75), BooleanOp.OR);
            }
            case UP -> {
                shape = Shapes.empty();
                shape = Shapes.join(shape, Shapes.box(0.4375, 0.3125, 0.4375, 0.5625, 0.4375, 0.5625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.3125, 0.4375, 0.3125, 0.6875, 0.875, 0.6875), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.375, 0.8125, 0.25, 0.625, 0.875, 0.3125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.25, 0.8125, 0.375, 0.3125, 0.875, 0.625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.6875, 0.8125, 0.375, 0.75, 0.875, 0.625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.375, 0.8125, 0.6875, 0.625, 0.875, 0.75), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.6875, 0.5, 0.375, 0.75, 0.75, 0.625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.25, 0.5, 0.375, 0.3125, 0.75, 0.625), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.375, 0.5, 0.25, 0.625, 0.75, 0.3125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.375, 0.5, 0.6875, 0.625, 0.75, 0.75), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.1875, 0.75, 0.1875, 0.8125, 0.8125, 0.8125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.1875, 0.875, 0.1875, 0.8125, 0.9375, 0.8125), BooleanOp.OR);
                shape = Shapes.join(shape, Shapes.box(0.25, 0.9375, 0.25, 0.75, 1, 0.75), BooleanOp.OR);
            }
        }

        return shape;
    }

}
