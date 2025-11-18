package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CoalBE extends BuddingBE {

    public CoalBE(BlockPos pos, BlockState state) {
        this(initGeOre.COAL.blockentity().get(), pos, state);
    }


    public CoalBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.COAL_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.COAL_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.COAL_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.COAL_GEORE.getCluster().get();
    }

}
