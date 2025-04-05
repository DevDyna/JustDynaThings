package com.devdyna.justdynathings.common.registry.core.builders.revitalizer;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.common.registry.core.builder.block.BlockBaseBE;
import com.devdyna.justdynathings.common.registry.types.BlockEntities;
import com.devdyna.justdynathings.utils.DirectionUtil;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("null")

public class RevitalizerBlock extends BlockBaseBE {

    public static VoxelShape[] shapes = {
            Shapes.box(0, 0, 0, 1, 0.5, 1), // down
            Shapes.box(0, 0.5, 0, 1, 1, 1), // south
            Shapes.box(0, 0, 0, 1, 1, 0.5), // up
            Shapes.box(0, 0, 0.5, 1, 1, 1), // north
            Shapes.box(0, 0, 0, 0.5, 1, 1), // west
            Shapes.box(0.5, 0, 0, 1, 1, 1), // east
    };

    public static BooleanProperty ACTIVE = BooleanProperty.create("active");

    public static BooleanProperty GOO_FOUND = BooleanProperty.create("goo_found");


    public RevitalizerBlock() {
        super(Properties.of()
                .requiresCorrectToolForDrops()
                .strength(5.0F, 6.0F)
                .sound(SoundType.METAL)
                .isRedstoneConductor(BaseMachineBlock::never));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState s, BlockGetter w, BlockPos p, CollisionContext c) {
        return shapes[DirectionUtil.indexByStateFacing(s)];
    }

    @Override
    protected VoxelShape getShape(BlockState s, BlockGetter l, BlockPos p, CollisionContext c) {
        return shapes[DirectionUtil.indexByStateFacing(s)];
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
        return new RevitalizerBE(BlockEntities.REVITALIZER_BE.get(), p, s);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext c) {
        return defaultBlockState()
                .setValue(ACTIVE, false)
                .setValue(GOO_FOUND, false)
                .setValue(BlockStateProperties.FACING, c.getNearestLookingDirection());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
        b
                .add(ACTIVE)
                .add(GOO_FOUND)
                .add(BlockStateProperties.FACING);
    }

}
