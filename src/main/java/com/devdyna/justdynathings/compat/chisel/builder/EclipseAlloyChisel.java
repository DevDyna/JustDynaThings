package com.devdyna.justdynathings.compat.chisel.builder;

import com.devdyna.justdynathings.compat.chisel.builder.base.BasePoweredChisel;
import com.devdyna.justdynathings.config.ServerConfig;

public class EclipseAlloyChisel extends BasePoweredChisel {

    public EclipseAlloyChisel( Properties p) {
        super(ChiselType.HITECH, p);
    }

    @Override
    public int getMaxEnergy() {
        return ServerConfig.ECLIPSE_ALLOY_CHISEL_FE_CAPACITY.get();
    }

    public int getFECostAtUse() {
        return ServerConfig.ECLIPSE_ALLOY_CHISEL_FE_COST.get();
    }

}
