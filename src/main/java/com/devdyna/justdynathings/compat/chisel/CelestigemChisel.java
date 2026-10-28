package com.devdyna.justdynathings.compat.chisel;

import com.devdyna.justdynathings.compat.chisel.api.BasePoweredChisel;
import com.devdyna.justdynathings.config.Config;

public class CelestigemChisel extends BasePoweredChisel {

    public CelestigemChisel(Properties p) {
        super(p);
    }

    @Override
    protected int getFECostAtUse() {
        return Config.CELESTIGEM_CHISEL_FE_COST.get();
    }

    @Override
    public int getMaxEnergy() {
        return Config.CELESTIGEM_CHISEL_FE_CAPACITY.get();
    }

}
