package com.devdyna.justdynathings.compat.geore.builder.blocks;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.compat.geore.builder.blockentities.CopperBE;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CopperBlock extends BuddingBlock {

    public CopperBlock(Properties p) {}

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CopperBE(pos, state);
    }
}
