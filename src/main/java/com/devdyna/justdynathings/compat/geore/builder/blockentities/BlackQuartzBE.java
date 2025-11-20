package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BlackQuartzBE extends BuddingBE {

    public BlackQuartzBE(BlockPos pos, BlockState state) {
        this(initGeOre.BLACK_QUARTZ.blockentity().get(), pos, state);
    }


    public BlackQuartzBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.BLACK_QUARTZ_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.BLACK_QUARTZ_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.BLACK_QUARTZ_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.BLACK_QUARTZ_GEORE.getCluster().get();
    }

}
