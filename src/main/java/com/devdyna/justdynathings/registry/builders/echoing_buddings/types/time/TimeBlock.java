package com.devdyna.justdynathings.registry.builders.echoing_buddings.types.time;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class TimeBlock extends BuddingBlock {

    public TimeBlock() {

    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TimeBE(pos, state);
    }

}
