package com.devdyna.justdynathings.registry.builders._core.block;

import com.direwolf20.justdirethings.common.blocks.resources.CoalBlock_T1;

public class BlockFuel extends CoalBlock_T1 {
   private int fuelvalue;

   public BlockFuel(int value) {
      fuelvalue = value;
   }

   public int getBurnSpeedMultiplier() {
      return fuelvalue;
   }
}
