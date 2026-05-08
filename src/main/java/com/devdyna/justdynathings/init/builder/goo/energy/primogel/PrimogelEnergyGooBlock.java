package com.devdyna.justdynathings.init.builder.goo.energy.primogel;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.goo.energy_goo.BaseFEGooBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PrimogelEnergyGooBlock extends BaseFEGooBlock {

   public PrimogelEnergyGooBlock(Properties p) {
      super(p);
   }

   @SuppressWarnings("null")
   @Nullable
   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new PrimogelEnergyGooBE(pos, state);
   }

   @Override
   public int getConfigTier() {
      return Config.GOO_T1_TIER.get();
   }

}
