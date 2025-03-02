package com.devdyna.justdynathings.common.registry.builder.sculk;

import com.devdyna.justdynathings.common.registry.core.builder.block.BlockBaseBE;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import javax.annotation.Nullable;

@SuppressWarnings("null")
public class SculkBlock extends BlockBaseBE {
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    private int cost;
    private int capacity;

    public SculkBlock(int capacity,int cost) {
        super(Properties.of()
                .sound(SoundType.METAL)
                .strength(2.0f)
                .isRedstoneConductor(BaseMachineBlock::never));
        this.cost = cost;
        this.capacity = capacity;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SculkBE(pos, state,capacity,cost);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState()
                .setValue(ACTIVE, true);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder
                .add(ACTIVE);
    }
}