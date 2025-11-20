package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class SilverBE extends BuddingBE {

    public SilverBE(BlockPos pos, BlockState state) {
        this(initGeOre.SILVER.blockentity().get(), pos, state);
    }


    public SilverBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.SILVER_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.SILVER_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.SILVER_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.SILVER_GEORE.getCluster().get();
    }

}
