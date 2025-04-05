package com.devdyna.justdynathings.common.registry.core.builders.ticker;

import com.devdyna.justdynathings.common.registry.core.builder.block.BlockBaseBE;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import javax.annotation.Nullable;

@SuppressWarnings("null")
public class TickerBlock extends BlockBaseBE {
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    private int FEcost;
    private int FEcapacity;
    private int MBcost;
    private int MBcapacity;

    public TickerBlock(int FEcapacity, int FEcost,int MBcapacity,int MBcost) {
        super(Properties.of()
                .sound(SoundType.METAL)
                .strength(2.0f)
                .isRedstoneConductor(BaseMachineBlock::never));
        this.FEcost = FEcost;
        this.FEcapacity = FEcapacity;
        this.MBcost = MBcost;
        this.MBcapacity = MBcapacity;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TickerBE(pos, state, FEcapacity, FEcost,MBcapacity,MBcost);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState()
                .setValue(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite())
                .setValue(ACTIVE, true);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder
                .add(BlockStateProperties.FACING)
                .add(ACTIVE);
    }
}