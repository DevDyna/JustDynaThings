package com.devdyna.justdynathings.init.builder.goo.custom.energy;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import com.devdyna.justdynathings.init.Material;
import com.devdyna.justdynathings.init.builder.goo.custom.type.FEGoo;

public class EnergyGooBE extends FEGoo {

    private int tier;
    private int reducer;

    public EnergyGooBE(BlockPos pos, BlockState state, int tier, int reducer,int cost) {
        super(Material.ENERGY_GOO_BE.get(), pos, state,cost);
        this.tier = tier;
        this.reducer = reducer;
    }

    public EnergyGooBE(BlockPos pos, BlockState state) {
        this(pos, state, 0, 1,200);
    }

    public int getTier() {
        return tier;
    }

    public int counterReducer() {
        return reducer;
    }

}
