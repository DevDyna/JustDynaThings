package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PlatinumBE extends BuddingBE {

    public PlatinumBE(BlockPos pos, BlockState state) {
        this(initGeOre.PLATINUM.blockentity().get(), pos, state);
    }


    public PlatinumBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.PLATINUM_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.PLATINUM_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.PLATINUM_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.PLATINUM_GEORE.getCluster().get();
    }

}
