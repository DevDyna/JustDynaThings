package com.devdyna.justdynathings.compat.ae2.builder;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CertusBlock extends BuddingBlock {
        public CertusBlock(Properties p) {

    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CertusBE(pos, state);
    }
}
