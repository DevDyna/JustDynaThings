package com.devdyna.justdynathings.compat.phasorite.builder;

import com.devdyna.justdynathings.compat.phasorite.initPhaso;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import xyz.milosworks.phasoritenetworks.init.PNBlocks;

public class PhasoriteBE extends BuddingBE {

    public PhasoriteBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = PNBlocks.INSTANCE.getSMALL_PHASORITE_BUD();
        this.mediumCluster = PNBlocks.INSTANCE.getMEDIUM_PHASORITE_BUD();
        this.largeCluster = PNBlocks.INSTANCE.getLARGE_PHASORITE_BUD();
        this.finalCluster = PNBlocks.INSTANCE.getPHASORITE_CLUSTER();
    }

    public PhasoriteBE(BlockPos pos, BlockState state) {
        this(initPhaso.PHASORITE.blockentity().get(), pos, state);
    }

}
