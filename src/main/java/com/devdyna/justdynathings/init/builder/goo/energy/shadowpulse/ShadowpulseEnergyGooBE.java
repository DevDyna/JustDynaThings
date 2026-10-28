package com.devdyna.justdynathings.init.builder.goo.energy.shadowpulse;



import com.devdyna.justdynathings.api.goo.energy_goo.BaseFEGooBE;
import com.devdyna.justdynathings.config.ServerConfig;
import com.devdyna.justdynathings.init.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class ShadowpulseEnergyGooBE extends BaseFEGooBE {


    public ShadowpulseEnergyGooBE(BlockPos pos, BlockState state) {
        super(zBlockEntities.T4_GOO.get(), pos,state);
    }

    public int getTier() {
        return ServerConfig.GOO_T4_TIER.get();
    }

    public int counterReducer() {
        return ServerConfig.GOO_T4_COUNTER_REDUCER.get();
    }

}
