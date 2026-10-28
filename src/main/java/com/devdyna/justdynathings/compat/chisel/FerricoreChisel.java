package com.devdyna.justdynathings.compat.chisel;

import com.devdyna.justdynathings.compat.chisel.api.BaseAbilityChisel;
import com.devdyna.justdynathings.config.StartupConfig;

public class FerricoreChisel extends BaseAbilityChisel {

    public FerricoreChisel(Properties p) {
        super(p.durability(StartupConfig.FERRICORE_CHISEL_DURABILITY.get()));
    }

}
