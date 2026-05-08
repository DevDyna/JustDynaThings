package com.devdyna.justdynathings.init.builder.goo.energy.blazebloom;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.goo.energy_goo.BaseFEGooBE;
import com.devdyna.justdynathings.init.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BlazebloomEnergyGooBE extends BaseFEGooBE {

    public BlazebloomEnergyGooBE(BlockPos pos, BlockState state) {
        super(zBlockEntities.T2_GOO.get(), pos, state);
    }

    public int getTier() {
        return Config.GOO_T2_TIER.get();
    }

    public int counterReducer() {
        return Config.GOO_T2_COUNTER_REDUCER.get();
    }

}
