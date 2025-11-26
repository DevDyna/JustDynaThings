package com.devdyna.justdynathings.registry.builders.goo.energy.diregoo;

import com.devdyna.justdynathings.ConfigCommon;
import com.devdyna.justdynathings.registry.builders.goo.energy.FEGoo;
import com.devdyna.justdynathings.registry.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class EnergyT3BE extends FEGoo {


    public EnergyT3BE(BlockPos pos, BlockState state) {
        super(zBlockEntities.T3_GOO.get(), pos,state);
    }

    public int getTier() {
        return ConfigCommon.GOO_T3_TIER.get();
    }

    public int counterReducer() {
        return ConfigCommon.GOO_T3_COUNTER_REDUCER.get();
    }

}
