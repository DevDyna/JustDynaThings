package com.devdyna.justdynathings.registry.builders._core.item;

import com.direwolf20.justdirethings.common.items.resources.Coal_T1;

public class ItemFuel extends Coal_T1 {
    private int fuelvalue;

    public ItemFuel(int value) {
        fuelvalue = value;
    }

    public int getBurnSpeedMultiplier() {
        return fuelvalue;
    }
}
