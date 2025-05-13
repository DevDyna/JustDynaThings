package com.devdyna.justdynathings.registry.builders.budding;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.registry.builders._core.block.BlockBaseBE;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

@SuppressWarnings("null")
public class BuddingBlock extends BlockBaseBE {


    public BuddingBlock() {
        super(zProperties.MachineProp.sound(SoundType.AMETHYST));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BuddingBE(null,pos, state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(zProperties.GOO_ALIVE, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(zProperties.GOO_ALIVE);
    }

}
