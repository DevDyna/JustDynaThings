package com.devdyna.justdynathings.registry.builders.fuels.block;

import com.direwolf20.justdirethings.common.blocks.resources.CoalBlock_T1;

public class BaseFuel extends CoalBlock_T1 {
   private int fuelvalue;

   public BaseFuel(int value) {
      fuelvalue = value;
   }

   public int getBurnSpeedMultiplier() {
      return fuelvalue;
   }
}
