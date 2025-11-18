package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class VibraniumBE extends BuddingBE {

    public VibraniumBE(BlockPos pos, BlockState state) {
        this(initGeOre.VIBRANIUM.blockentity().get(), pos, state);
    }


    public VibraniumBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.VIBRANIUM_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.VIBRANIUM_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.VIBRANIUM_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.VIBRANIUM_GEORE.getCluster().get();
    }

}
