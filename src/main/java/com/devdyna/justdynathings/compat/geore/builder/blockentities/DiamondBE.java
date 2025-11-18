package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class DiamondBE extends BuddingBE {

    public DiamondBE(BlockPos pos, BlockState state) {
        this(initGeOre.DIAMOND.blockentity().get(), pos, state);
    }


    public DiamondBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.DIAMOND_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.DIAMOND_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.DIAMOND_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.DIAMOND_GEORE.getCluster().get();
    }

}
