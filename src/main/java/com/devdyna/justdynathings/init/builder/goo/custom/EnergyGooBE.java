package com.devdyna.justdynathings.init.builder.goo.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import com.devdyna.justdynathings.init.Material;
import com.devdyna.justdynathings.init.builder.goo.custom.core.EnergyGooBase;

public class EnergyGooBE extends EnergyGooBase {

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
