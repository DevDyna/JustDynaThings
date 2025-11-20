package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class SapphireBE extends BuddingBE {

    public SapphireBE(BlockPos pos, BlockState state) {
        this(initGeOre.SAPPHIRE.blockentity().get(), pos, state);
    }


    public SapphireBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.SAPPHIRE_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.SAPPHIRE_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.SAPPHIRE_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.SAPPHIRE_GEORE.getCluster().get();
    }

}
