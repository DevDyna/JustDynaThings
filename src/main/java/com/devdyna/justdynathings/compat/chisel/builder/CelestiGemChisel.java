package com.devdyna.justdynathings.compat.chisel.builder;

import com.devdyna.justdynathings.ConfigCommon;
import com.devdyna.justdynathings.compat.chisel.builder.base.BasePoweredChisel;

public class CelestiGemChisel extends BasePoweredChisel {

    public CelestiGemChisel(Properties p) {
        super(ChiselType.DIAMOND, p);
    }

    @Override
    public int getMaxEnergy() {
        return ConfigCommon.CELESTIGEM_CHISEL_FE_CAPACITY.get();
    }

    public int getFECostAtUse() {
        return ConfigCommon.CELESTIGEM_CHISEL_FE_COST.get();
    }

}
