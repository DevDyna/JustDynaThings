package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class TungstenBE extends BuddingBE {

    public TungstenBE(BlockPos pos, BlockState state) {
        this(initGeOre.TUNGSTEN.blockentity().get(), pos, state);
    }


    public TungstenBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.TUNGSTEN_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.TUNGSTEN_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.TUNGSTEN_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.TUNGSTEN_GEORE.getCluster().get();
    }

}
