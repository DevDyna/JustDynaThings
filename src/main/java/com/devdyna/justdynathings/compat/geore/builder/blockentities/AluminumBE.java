package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class AluminumBE extends BuddingBE {

    public AluminumBE(BlockPos pos, BlockState state) {
        this(initGeOre.ALUMINUM.blockentity().get(), pos, state);
    }


    public AluminumBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.ALUMINUM_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.ALUMINUM_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.ALUMINUM_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.ALUMINUM_GEORE.getCluster().get();
    }

}
