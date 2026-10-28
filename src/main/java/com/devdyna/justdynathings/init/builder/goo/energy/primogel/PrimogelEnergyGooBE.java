package com.devdyna.justdynathings.init.builder.goo.energy.primogel;

import com.devdyna.justdynathings.api.goo.energy_goo.BaseFEGooBE;
import com.devdyna.justdynathings.config.ServerConfig;
import com.devdyna.justdynathings.init.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class PrimogelEnergyGooBE extends BaseFEGooBE {

    public PrimogelEnergyGooBE(BlockPos pos, BlockState state) {
        super(zBlockEntities.T1_GOO.get(), pos, state);
    }

    public int getTier() {
        return ServerConfig.GOO_T1_TIER.get();
    }

    public int counterReducer() {
        return ServerConfig.GOO_T1_COUNTER_REDUCER.get();
    }

}
