package com.devdyna.justdynathings.compat.phasorite.builder;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.registry.builders.budding.BuddingBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PhasoriteBlock extends BuddingBlock {

    public PhasoriteBlock() {

    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PhasoriteBE(pos, state);
    }

}
