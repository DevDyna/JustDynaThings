package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class UnobtainiumBE extends BuddingBE {

    public UnobtainiumBE(BlockPos pos, BlockState state) {
        this(initGeOre.UNOBTAINIUM.blockentity().get(), pos, state);
    }


    public UnobtainiumBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.UNOBTAINIUM_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.UNOBTAINIUM_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.UNOBTAINIUM_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.UNOBTAINIUM_GEORE.getCluster().get();
    }

}
