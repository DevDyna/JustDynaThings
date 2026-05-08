package com.devdyna.justdynathings.init.builder.goo.energy.blazebloom;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.goo.energy_goo.BaseFEGooBlock;

public class BlazebloomEnergyGooBlock extends BaseFEGooBlock {

   public BlazebloomEnergyGooBlock(Properties p) {
      super(p);
   }

   @Override
   public int getConfigTier() {
      return Config.GOO_T2_TIER.get();
   }

}
