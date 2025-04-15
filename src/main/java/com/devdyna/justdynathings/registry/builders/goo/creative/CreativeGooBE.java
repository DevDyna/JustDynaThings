package com.devdyna.justdynathings.registry.builders.goo.creative;

import com.devdyna.justdynathings.registry.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class CreativeGooBE extends NoDieGooLogic {

    public CreativeGooBE(BlockPos pos, BlockState state) {
        super(zBlockEntities.CREATIVE_GOO.get(), pos, state);
    }

    public int getTier() {
        return Integer.MAX_VALUE;
    }

    public int counterReducer() {
        return Integer.MAX_VALUE;
    }

}
