package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class IronBE extends BuddingBE {

    public IronBE(BlockPos pos, BlockState state) {
        this(initGeOre.IRON.blockentity().get(), pos, state);
    }


    public IronBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.IRON_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.IRON_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.IRON_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.IRON_GEORE.getCluster().get();
    }

}
