package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class AncientDebrisBE extends BuddingBE {

    public AncientDebrisBE(BlockPos pos, BlockState state) {
        this(initGeOre.ANCIENT_DEBRIS.blockentity().get(), pos, state);
    }


    public AncientDebrisBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.ANCIENT_DEBRIS_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.ANCIENT_DEBRIS_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.ANCIENT_DEBRIS_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.ANCIENT_DEBRIS_GEORE.getCluster().get();
    }

}
