package com.devdyna.justdynathings.init.builder.goo.energy.blazebloom;

import com.devdyna.justdynathings.api.goo.energy_goo.BaseFEGooBE;
import com.devdyna.justdynathings.config.ServerConfig;
import com.devdyna.justdynathings.init.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class BlazebloomEnergyGooBE extends BaseFEGooBE {

    public BlazebloomEnergyGooBE(BlockPos pos, BlockState state) {
        super(zBlockEntities.T2_GOO.get(), pos, state);
    }

    public int getTier() {
        return ServerConfig.GOO_T2_TIER.get();
    }

    public int counterReducer() {
        return ServerConfig.GOO_T2_COUNTER_REDUCER.get();
    }

}
