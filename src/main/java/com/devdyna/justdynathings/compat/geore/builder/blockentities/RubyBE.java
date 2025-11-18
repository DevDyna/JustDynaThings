package com.devdyna.justdynathings.compat.geore.builder.blockentities;

import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.registry.builders.budding.BuddingBE;
import com.shynieke.geore.registry.GeOreRegistry;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class RubyBE extends BuddingBE {

    public RubyBE(BlockPos pos, BlockState state) {
        this(initGeOre.RUBY.blockentity().get(), pos, state);
    }


    public RubyBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.smallCluster = GeOreRegistry.RUBY_GEORE.getSmallBud().get();
        this.mediumCluster = GeOreRegistry.RUBY_GEORE.getMediumBud().get();
        this.largeCluster = GeOreRegistry.RUBY_GEORE.getLargeBud().get();
        this.finalCluster = GeOreRegistry.RUBY_GEORE.getCluster().get();
    }

}
