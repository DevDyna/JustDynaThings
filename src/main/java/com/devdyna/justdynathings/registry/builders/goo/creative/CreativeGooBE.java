package com.devdyna.justdynathings.registry.builders.goo.creative;

import com.devdyna.justdynathings.config.ServerConfig;
import com.devdyna.justdynathings.registry.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class CreativeGooBE extends NoDieGooLogic {

    public CreativeGooBE(BlockPos pos, BlockState state) {
        super(zBlockEntities.CREATIVE_GOO.get(), pos, state);
    }

    public int getTier() {
        return ServerConfig.GOO_CREATIVE_TIER.get();
    }

    public int counterReducer() {
        return ServerConfig.GOO_CREATIVE_COUNTER_REDUCER.get();
    }

}
