package com.devdyna.justdynathings.common.registry.builder.revitalizer;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.common.registry.Material;
import com.devdyna.justdynathings.common.registry.core.builder.block.BlockBaseBE;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("null")

public class RevitalizerBlock extends BlockBaseBE {

    public static VoxelShape shape = Block.box(0, 0, 0, 16, 8, 16);

    public static BooleanProperty ACTIVE = BooleanProperty.create("active");

    public static BooleanProperty GOO_ON_TOP = BooleanProperty.create("goo_on_top");

    private int cost;
    private int capacity;

    public RevitalizerBlock(int cost, int capacity) {
        super(Properties.of());
        this.capacity = capacity;
        this.cost = cost;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState s, BlockGetter w, BlockPos p, CollisionContext c) {
        return shape;
    }

    @Override
    protected VoxelShape getShape(BlockState s, BlockGetter l, BlockPos p, CollisionContext c) {
        return shape;
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
        return new RevitalizerBE(Material.REVITALIZER_BE.get(), p, s, cost, capacity);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext c) {
        return defaultBlockState().setValue(ACTIVE, false).setValue(GOO_ON_TOP, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
        b.add(ACTIVE).add(GOO_ON_TOP);
    }

}
