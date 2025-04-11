package com.devdyna.justdynathings.registry.builders.goo.energy;

import com.devdyna.justdynathings.registry.types.BlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class EnergyGooBE extends FEGooLogic {


    public EnergyGooBE(BlockPos pos, BlockState state) {
        super(BlockEntities.ENERGIZED_GOO.get(), pos,state);
    }

    public int getTier() {
        return 5;
    }

    public int counterReducer() {
        return 15;
    }

}
