package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class OsmiumBE extends BuddingBE {

    public OsmiumBE(BlockPos pos, BlockState state) {
        this(initGeOre.OSMIUM.blockentity().get(), pos, state);
    }


    public OsmiumBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.OSMIUM_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.OSMIUM_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.OSMIUM_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.OSMIUM_GEORE.getCluster().get();
    }

}
