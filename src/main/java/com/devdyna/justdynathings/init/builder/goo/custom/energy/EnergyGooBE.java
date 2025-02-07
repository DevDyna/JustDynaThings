package com.devdyna.justdynathings.init.builder.goo.custom.energy;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import com.devdyna.justdynathings.init.Material;
import com.devdyna.justdynathings.init.builder.goo.custom.type.FEGoo;

public class EnergyGooBE extends FEGoo {

    private int tier;
    private int reducer;

    /**
     * @param cost FE / block converted
     * @param maxsize Max energy stored
     */
    public EnergyGooBE(BlockPos pos, BlockState state, int tier, int reducer,int cost,int maxsize) {
        super(Material.ENERGY_GOO_BE.get(), pos, state,cost,maxsize);
        this.tier = tier;
        this.reducer = reducer;
    }

    public EnergyGooBE(BlockPos pos, BlockState state) {
        this(pos, state, 0, 1,200,10000);
    }

    public int getTier() {
        return tier;
    }

    public int counterReducer() {
        return reducer;
    }

}
