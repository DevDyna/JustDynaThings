package com.devdyna.justdynathings.compat.geore.builder.blocks;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.compat.geore.builder.blockentities.OsmiumBE;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class OsmiumBlock extends BuddingBlock {

    public OsmiumBlock(Properties p) {}

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new OsmiumBE(pos, state);
    }
}
