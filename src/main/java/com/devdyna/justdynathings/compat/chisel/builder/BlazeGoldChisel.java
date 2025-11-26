package com.devdyna.justdynathings.compat.chisel.builder;

import com.devdyna.justdynathings.compat.chisel.builder.base.BaseAbilityChisel;
import com.direwolf20.justdirethings.common.items.interfaces.Ability;

public class BlazeGoldChisel extends BaseAbilityChisel {

    public BlazeGoldChisel(Properties p) {
        super(ChiselType.IRON, p, 1);
        registerAbility(Ability.LAVAREPAIR);
    }

    @Override
    protected boolean enableToolAbilityTip() {
        return true;
    }

}
