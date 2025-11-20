package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class QuartzBE extends BuddingBE {

    public QuartzBE(BlockPos pos, BlockState state) {
        this(initGeOre.QUARTZ.blockentity().get(), pos, state);
    }


    public QuartzBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.QUARTZ_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.QUARTZ_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.QUARTZ_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.QUARTZ_GEORE.getCluster().get();
    }

}
