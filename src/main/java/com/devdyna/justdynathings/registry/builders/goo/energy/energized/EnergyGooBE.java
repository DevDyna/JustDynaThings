package com.devdyna.justdynathings.registry.builders.goo.energy.energized;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.registry.builders.goo.energy.FEGoo;
import com.devdyna.justdynathings.registry.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class EnergyGooBE extends FEGoo {


    public EnergyGooBE(BlockPos pos, BlockState state) {
        super(zBlockEntities.ENERGIZED_GOO.get(), pos,state);
    }

    public int getTier() {
        return Config.GOO_ENERGY_TIER.get();
    }

    public int counterReducer() {
        return Config.GOO_ENERGY_COUNTER_REDUCER.get();
    }

}
