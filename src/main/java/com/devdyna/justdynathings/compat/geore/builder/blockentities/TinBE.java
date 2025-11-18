package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class TinBE extends BuddingBE {

    public TinBE(BlockPos pos, BlockState state) {
        this(initGeOre.TIN.blockentity().get(), pos, state);
    }


    public TinBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.TIN_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.TIN_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.TIN_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.TIN_GEORE.getCluster().get();
    }

}
