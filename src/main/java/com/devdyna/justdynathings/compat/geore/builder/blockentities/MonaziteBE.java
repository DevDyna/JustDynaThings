package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class MonaziteBE extends BuddingBE {

    public MonaziteBE(BlockPos pos, BlockState state) {
        this(initGeOre.MONAZITE.blockentity().get(), pos, state);
    }


    public MonaziteBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.MONAZITE_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.MONAZITE_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.MONAZITE_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.MONAZITE_GEORE.getCluster().get();
    }

}
