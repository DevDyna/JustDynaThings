package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class NickelBE extends BuddingBE {

    public NickelBE(BlockPos pos, BlockState state) {
        this(initGeOre.NICKEL.blockentity().get(), pos, state);
    }


    public NickelBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.NICKEL_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.NICKEL_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.NICKEL_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.NICKEL_GEORE.getCluster().get();
    }

}
