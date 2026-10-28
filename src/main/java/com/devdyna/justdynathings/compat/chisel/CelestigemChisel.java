package com.devdyna.justdynathings.compat.chisel;

import com.devdyna.justdynathings.compat.chisel.api.BasePoweredChisel;
import com.devdyna.justdynathings.config.ServerConfig;

public class CelestigemChisel extends BasePoweredChisel {

    public CelestigemChisel(Properties p) {
        super(p);
    }

    @Override
    protected int getFECostAtUse() {
        return ServerConfig.CELESTIGEM_CHISEL_FE_COST.get();
    }

    @Override
    public int getMaxEnergy() {
        return ServerConfig.CELESTIGEM_CHISEL_FE_CAPACITY.get();
    }

}
