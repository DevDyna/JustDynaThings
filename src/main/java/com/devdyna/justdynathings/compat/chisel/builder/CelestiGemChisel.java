package com.devdyna.justdynathings.compat.chisel.builder;

import com.devdyna.justdynathings.compat.chisel.builder.base.BasePoweredChisel;
import com.devdyna.justdynathings.config.ServerConfig;

public class CelestiGemChisel extends BasePoweredChisel {

    public CelestiGemChisel(Properties p) {
        super(ChiselType.DIAMOND, p);
    }

    @Override
    public int getMaxEnergy() {
        return ServerConfig.CELESTIGEM_CHISEL_FE_CAPACITY.get();
    }

    public int getFECostAtUse() {
        return ServerConfig.CELESTIGEM_CHISEL_FE_COST.get();
    }

}
