package com.devdyna.justdynathings.registry.interfaces.be;

import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;

public interface EnergyMachine extends PoweredMachineBE {

    @Deprecated
    int FErate = 100;
    @Deprecated
    int FEsize = 10000;

    /**
     * FE / tick
     * DONT use to set FE gen
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