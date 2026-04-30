package com.devdyna.justdynathings.init.builder.goo.energy.diregoo;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.init.builder.goo.energy.EnergyGoo;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EnergyT4 extends GooBlock_Base implements EnergyGoo{

   public EnergyT4(Properties p) {
      super(p);
   }

   @SuppressWarnings("null")
   @Nullable
   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new EnergyT4BE(pos, state);
   }

   protected boolean validRevivalItem(ItemStack itemStack) {
      return false;
   }

   @Override
   public int getConfigTier() {
     return Config.GOO_T4_TIER.get();
   }

}
