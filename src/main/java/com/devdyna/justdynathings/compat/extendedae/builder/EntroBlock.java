package com.devdyna.justdynathings.compat.extendedae.builder;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.registry.builders.budding.BuddingBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EntroBlock extends BuddingBlock {

    public EntroBlock() {

    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EntroBE(pos, state);
    }

}
