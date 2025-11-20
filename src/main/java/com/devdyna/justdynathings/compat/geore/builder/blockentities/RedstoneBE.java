package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class RedstoneBE extends BuddingBE {

    public RedstoneBE(BlockPos pos, BlockState state) {
        this(initGeOre.REDSTONE.blockentity().get(), pos, state);
    }


    public RedstoneBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.REDSTONE_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.REDSTONE_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.REDSTONE_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.REDSTONE_GEORE.getCluster().get();
    }

}
