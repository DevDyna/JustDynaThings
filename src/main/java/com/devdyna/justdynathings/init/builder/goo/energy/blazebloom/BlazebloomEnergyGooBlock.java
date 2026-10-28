package com.devdyna.justdynathings.init.builder.goo.energy.blazebloom;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.api.goo.energy_goo.BaseFEGooBlock;
import com.devdyna.justdynathings.config.ServerConfig;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BlazebloomEnergyGooBlock extends BaseFEGooBlock {

   public BlazebloomEnergyGooBlock(Properties p) {
      super(p);
   }

   @Override
   @Nullable
   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new BlazebloomEnergyGooBE(pos, state);
   }

   @Override
   public int getConfigTier() {
      return ServerConfig.GOO_T2_TIER.get();
   }

}
