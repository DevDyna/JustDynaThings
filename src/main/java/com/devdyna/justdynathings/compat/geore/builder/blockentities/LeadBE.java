package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class LeadBE extends BuddingBE {

    public LeadBE(BlockPos pos, BlockState state) {
        this(initGeOre.LEAD.blockentity().get(), pos, state);
    }


    public LeadBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.LEAD_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.LEAD_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.LEAD_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.LEAD_GEORE.getCluster().get();
    }

}
