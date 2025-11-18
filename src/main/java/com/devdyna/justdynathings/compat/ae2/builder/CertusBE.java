package com.devdyna.justdynathings.compat.ae2.builder;

import com.devdyna.justdynathings.compat.ae2.initApp;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import appeng.core.definitions.AEBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CertusBE extends BuddingBE {

    public CertusBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = AEBlocks.SMALL_QUARTZ_BUD.block();
        this.mediumCluster = AEBlocks.MEDIUM_QUARTZ_BUD.block();
        this.largeCluster = AEBlocks.LARGE_QUARTZ_BUD.block();
        this.finalCluster = AEBlocks.QUARTZ_CLUSTER.block();

    }

    public CertusBE(BlockPos pos, BlockState state) {
        this(initApp.CERTUS.blockentity().get(), pos, state);
    }

}
