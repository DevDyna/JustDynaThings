package com.devdyna.justdynathings.registry.interfaces.be;

import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;

public interface EnergyMachine extends PoweredMachineBE {

    int FErate = 100;
    int FEsize = 10000;

    /**
     * FE / tick
     */
    int getStandardEnergyCost();

    /**
     * FE Capacity
     */
    int getMaxEnergy();

    /**
     * FE--
     * when not empty
     */
    default void extractFEWhenPossible() {
        if (canExtractFE())
            extractEnergy(getStandardEnergyCost(), false);
    }

    /**
     * FE <- Machine | Consume
     * when not empty
     */
    default boolean canExtractFE() {
        return getEnergyStored() > 0;
    }

}