package com.devdyna.justdynathings.common.registry.core.builders.goo.custom.energy;

import com.devdyna.justdynathings.common.registry.core.builders.goo.custom.type.FEGoo;
import com.devdyna.justdynathings.common.registry.types.BlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class EnergyGooBE extends FEGoo {

    private int tier;
    private int reducer;

    /**
     * @param cost FE / block converted
     * @param maxsize Max energy stored
     */
    public EnergyGooBE(BlockPos pos, BlockState state, int tier, int reducer,int cost,int maxsize) {
        super(BlockEntities.ENERGY_GOO_BE.get(), pos, state,cost,maxsize);
        this.tier = tier;
        this.reducer = reducer;
    }

    public EnergyGooBE(BlockPos pos, BlockState state) {
        this(pos, state, 0, 1,200,10000);
    }

    public int getTier() {
        return tier;
    }

    public int counterReducer() {
        return reducer;
    }

}
