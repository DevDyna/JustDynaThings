package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class UraniumBE extends BuddingBE {

    public UraniumBE(BlockPos pos, BlockState state) {
        this(initGeOre.URANIUM.blockentity().get(), pos, state);
    }


    public UraniumBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.URANIUM_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.URANIUM_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.URANIUM_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.URANIUM_GEORE.getCluster().get();
    }

}
