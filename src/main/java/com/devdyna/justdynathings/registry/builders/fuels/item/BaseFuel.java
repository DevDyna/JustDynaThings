package com.devdyna.justdynathings.registry.builders.fuels.item;

import com.direwolf20.justdirethings.common.items.resources.Coal_T1;

public class BaseFuel extends Coal_T1 {
    private int fuelvalue;

    public BaseFuel(int value) {
        fuelvalue = value;
    }

    public int getBurnSpeedMultiplier() {
        return fuelvalue;
    }
}
