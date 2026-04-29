package com.devdyna.justdynathings.init.builder.goo.energy.diregoo;



import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.init.builder.goo.energy.FEGoo;
import com.devdyna.justdynathings.init.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class EnergyT4BE extends FEGoo {


    public EnergyT4BE(BlockPos pos, BlockState state) {
        super(zBlockEntities.T4_GOO.get(), pos,state);
    }

    public int getTier() {
        return Config.GOO_T4_TIER.get();
    }

    public int counterReducer() {
        return Config.GOO_T4_COUNTER_REDUCER.get();
    }

}
