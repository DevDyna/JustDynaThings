package com.devdyna.justdynathings.compat.chisel.builder;

import com.devdyna.justdynathings.ConfigCommon;
import com.devdyna.justdynathings.compat.chisel.builder.base.BasePoweredChisel;

public class EclipseAlloyChisel extends BasePoweredChisel {

    public EclipseAlloyChisel( Properties p) {
        super(ChiselType.HITECH, p);
    }

    @Override
    public int getMaxEnergy() {
        return ConfigCommon.ECLIPSE_ALLOY_CHISEL_FE_CAPACITY.get();
    }

    public int getFECostAtUse() {
        return ConfigCommon.ECLIPSE_ALLOY_CHISEL_FE_COST.get();
    }

}
