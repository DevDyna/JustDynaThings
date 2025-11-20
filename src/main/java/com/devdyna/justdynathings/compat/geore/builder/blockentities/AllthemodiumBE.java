package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class AllthemodiumBE extends BuddingBE {

    public AllthemodiumBE(BlockPos pos, BlockState state) {
        this(initGeOre.ALLTHEMODIUM.blockentity().get(), pos, state);
    }


    public AllthemodiumBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.ALLTHEMODIUM_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.ALLTHEMODIUM_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.ALLTHEMODIUM_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.ALLTHEMODIUM_GEORE.getCluster().get();
    }

}
