package com.devdyna.justdynathings.init.builder.goo.energy.diregoo;

import javax.annotation.Nullable;

import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EnergyT3 extends GooBlock_Base {

   public EnergyT3(Properties p) {
      super(p);
   }

   @Nullable
   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new EnergyT3BE(pos, state);
   }

   protected boolean validRevivalItem(ItemStack itemStack) {
      return false;
   }

}
