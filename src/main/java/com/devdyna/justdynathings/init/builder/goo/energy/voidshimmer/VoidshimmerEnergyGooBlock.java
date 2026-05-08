package com.devdyna.justdynathings.init.builder.goo.energy.voidshimmer;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.goo.energy_goo.BaseFEGooBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class VoidshimmerEnergyGooBlock extends BaseFEGooBlock {

   public VoidshimmerEnergyGooBlock(Properties p) {
      super(p);
   }

   @Nullable
   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new VoidshimmerEnergyGooBE(pos, state);
   }

   @Override
   public int getConfigTier() {
      return Config.GOO_T3_TIER.get();
   }

}
