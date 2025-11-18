package com.devdyna.justdynathings.registry.builders.budding.types.amethyst;

import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.devdyna.justdynathings.registry.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class AmethystBE extends BuddingBE {

    public AmethystBE(BlockPos pos, BlockState state) {
        super(zBlockEntities.ECHOING_BUDDING_AMETHYST.get(), pos, state);
        this.smallCluster = Blocks.SMALL_AMETHYST_BUD;
        this.mediumCluster = Blocks.MEDIUM_AMETHYST_BUD;
        this.largeCluster = Blocks.LARGE_AMETHYST_BUD;
        this.finalCluster = Blocks.AMETHYST_CLUSTER;
    }

}
