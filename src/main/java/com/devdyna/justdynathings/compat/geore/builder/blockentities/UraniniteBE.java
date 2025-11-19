package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class UraniniteBE extends BuddingBE {

    public UraniniteBE(BlockPos pos, BlockState state) {
        this(initGeOre.URANINITE.blockentity().get(), pos, state);
    }


    public UraniniteBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.URANINITE_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.URANINITE_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.URANINITE_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.URANINITE_GEORE.getCluster().get();
    }

}
