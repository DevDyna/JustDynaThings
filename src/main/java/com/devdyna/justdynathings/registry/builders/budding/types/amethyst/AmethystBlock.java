package com.devdyna.justdynathings.registry.builders.budding.types.amethyst;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.registry.builders.budding.BuddingBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AmethystBlock extends BuddingBlock {

    public AmethystBlock() {

    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AmethystBE(pos, state);
    }

}
