package com.devdyna.justdynathings.compat.chisel;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.compat.chisel.api.BasePoweredChisel;

public class EclipseAlloyChisel extends BasePoweredChisel {

    public EclipseAlloyChisel(Properties p) {
        super(p);
    }

    @Override
    protected int getFECostAtUse() {
        return Config.ECLIPSE_ALLOY_CHISEL_FE_COST.get();
    }

    @Override
    public int getMaxEnergy() {
        return Config.ECLIPSE_ALLOY_CHISEL_FE_CAPACITY.get();
    }

}
