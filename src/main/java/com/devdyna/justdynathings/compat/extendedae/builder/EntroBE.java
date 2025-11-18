package com.devdyna.justdynathings.compat.extendedae.builder;

import com.devdyna.justdynathings.compat.extendedae.initExtend;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.glodblock.github.extendedae.common.EAESingletons;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class EntroBE extends BuddingBE {

    public EntroBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = EAESingletons.ENTRO_BUD_SMALL;
        this.mediumCluster = EAESingletons.ENTRO_BUD_MEDIUM;
        this.largeCluster = EAESingletons.ENTRO_BUD_LARGE;
        this.finalCluster = EAESingletons.ENTRO_CLUSTER;
    }

    public EntroBE(BlockPos pos, BlockState state) {
        this(initExtend.ENTRO.blockentity().get(), pos, state);
    }

}
