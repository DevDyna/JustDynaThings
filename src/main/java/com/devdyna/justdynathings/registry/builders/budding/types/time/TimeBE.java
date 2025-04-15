package com.devdyna.justdynathings.registry.builders.budding.types.time;

import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class TimeBE extends BuddingBE {

    public TimeBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = Registration.TimeCrystalCluster_Small.get();
        this.mediumCluster = Registration.TimeCrystalCluster_Medium.get();
        this.largeCluster = Registration.TimeCrystalCluster_Large.get();
        this.finalCluster = Registration.TimeCrystalCluster.get();
    }

    public TimeBE(BlockPos pos, BlockState state) {
        this(zBlockEntities.BUDDING_TIME.get(), pos, state);
    }

}
