package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class TopazBE extends BuddingBE {

    public TopazBE(BlockPos pos, BlockState state) {
        this(initGeOre.TOPAZ.blockentity().get(), pos, state);
    }


    public TopazBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.TOPAZ_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.TOPAZ_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.TOPAZ_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.TOPAZ_GEORE.getCluster().get();
    }

}
