package com.devdyna.justdynathings.init.builder.goo.energy.voidshimmer;


import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.goo.energy_goo.BaseFEGooBE;
import com.devdyna.justdynathings.init.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class VoidshimmerEnergyGooBE extends BaseFEGooBE {


    public VoidshimmerEnergyGooBE(BlockPos pos, BlockState state) {
        super(zBlockEntities.T3_GOO.get(), pos,state);
    }

    public int getTier() {
        return Config.GOO_T3_TIER.get();
    }

    public int counterReducer() {
        return Config.GOO_T3_COUNTER_REDUCER.get();
    }

}
