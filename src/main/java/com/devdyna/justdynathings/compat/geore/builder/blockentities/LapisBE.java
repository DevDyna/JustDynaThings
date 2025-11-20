package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class LapisBE extends BuddingBE {

    public LapisBE(BlockPos pos, BlockState state) {
        this(initGeOre.LAPIS.blockentity().get(), pos, state);
    }


    public LapisBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.LAPIS_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.LAPIS_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.LAPIS_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.LAPIS_GEORE.getCluster().get();
    }

}
