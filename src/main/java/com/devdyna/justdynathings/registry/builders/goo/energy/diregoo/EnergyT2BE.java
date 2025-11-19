package com.devdyna.justdynathings.registry.builders.goo.energy.diregoo;

import com.devdyna.justdynathings.Config.CommonConfig;
import com.devdyna.justdynathings.registry.builders.goo.energy.FEGoo;
import com.devdyna.justdynathings.registry.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class EnergyT2BE extends FEGoo {


    public EnergyT2BE(BlockPos pos, BlockState state) {
        super(zBlockEntities.T2_GOO.get(), pos,state);
    }

    public int getTier() {
        return CommonConfig.GOO_T2_TIER.get();
    }

    public int counterReducer() {
        return CommonConfig.GOO_T2_COUNTER_REDUCER.get();
    }

}
