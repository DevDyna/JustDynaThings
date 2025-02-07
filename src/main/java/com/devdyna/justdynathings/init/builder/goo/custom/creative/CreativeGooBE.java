package com.devdyna.justdynathings.init.builder.goo.custom.creative;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import com.devdyna.justdynathings.init.Material;
import com.devdyna.justdynathings.init.builder.goo.custom.type.FEGoo;

public class CreativeGooBE extends FEGoo {

    private int tier;
    private int reducer;

    public CreativeGooBE(BlockPos pos, BlockState state, int tier, int reducer) {
        super(Material.ENERGY_GOO_BE.get(), pos, state);
        this.tier = tier;
        this.reducer = reducer;
    }

    public CreativeGooBE(BlockPos pos, BlockState state) {
        this(pos, state, 0, 1);
    }

    public int getTier() {
        return tier;
    }

    public int counterReducer() {
        return reducer;
    }

}
