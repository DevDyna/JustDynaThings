package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class ZincBE extends BuddingBE {

    public ZincBE(BlockPos pos, BlockState state) {
        this(initGeOre.ZINC.blockentity().get(), pos, state);
    }


    public ZincBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.ZINC_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.ZINC_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.ZINC_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.ZINC_GEORE.getCluster().get();
    }

}
