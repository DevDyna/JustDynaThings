package com.devdyna.justdynathings.registry.builders.ticker;

import com.devdyna.justdynathings.registry.builders._core.block.BlockBaseBE;
import com.devdyna.justdynathings.registry.types.zProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import javax.annotation.Nullable;

@SuppressWarnings("null")
public class TickerBlock extends BlockBaseBE {
    

    public TickerBlock() {
        super(zProperties.MachineProp);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TickerBE(pos, state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState()
                .setValue(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite())
                .setValue(zProperties.ACTIVE, true);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder
                .add(BlockStateProperties.FACING)
                .add(zProperties.ACTIVE);
    }
}