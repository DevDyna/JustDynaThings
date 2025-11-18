package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class GoldBE extends BuddingBE {

    public GoldBE(BlockPos pos, BlockState state) {
        this(initGeOre.GOLD.blockentity().get(), pos, state);
    }


    public GoldBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.GOLD_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.GOLD_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.GOLD_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.GOLD_GEORE.getCluster().get();
    }

}
