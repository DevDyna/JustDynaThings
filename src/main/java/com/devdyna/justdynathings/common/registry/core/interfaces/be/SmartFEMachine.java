package com.devdyna.justdynathings.common.registry.core.interfaces.be;

import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;

public interface SmartFEMachine extends PoweredMachineBE {

    default void extractFEWhenPossible() {
        extractEnergy(
                getEnergyStored() <= getStandardEnergyCost() ? getEnergyStored() : getStandardEnergyCost(),
                false);
    }

    default boolean validEnergy() {
        return getEnergyStored() > getStandardEnergyCost();
    }
}