package com.devdyna.justdynathings.compat.extendedae.builder;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EntroBlock extends BuddingBlock {

    public EntroBlock(Properties p) {

    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EntroBE(pos, state);
    }

}
