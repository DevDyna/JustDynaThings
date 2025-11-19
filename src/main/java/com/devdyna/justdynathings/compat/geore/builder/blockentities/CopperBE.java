package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CopperBE extends BuddingBE {

    public CopperBE(BlockPos pos, BlockState state) {
        this(initGeOre.COPPER.blockentity().get(), pos, state);
    }


    public CopperBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.COPPER_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.COPPER_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.COPPER_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.COPPER_GEORE.getCluster().get();
    }

}
