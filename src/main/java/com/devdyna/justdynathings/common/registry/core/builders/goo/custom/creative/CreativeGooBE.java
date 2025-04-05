package com.devdyna.justdynathings.common.registry.core.builders.goo.custom.creative;

import com.devdyna.justdynathings.common.registry.core.builders.goo.custom.type.NoDieGoo;
import com.devdyna.justdynathings.common.registry.types.BlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class CreativeGooBE extends NoDieGoo {

    private int tier;
    private int reducer;

    public CreativeGooBE(BlockPos pos, BlockState state, int tier, int reducer) {
        super(BlockEntities.CREATIVE_GOO_BE.get(), pos, state);
        this.tier = tier;
        this.reducer = reducer;
    }

    public CreativeGooBE(BlockPos pos, BlockState state) {
        this(pos, state, 0, 1);
    }

    public int getTier() {
        return tier;
    }

    public int counterReducer() {
        return reducer;
    }

}
