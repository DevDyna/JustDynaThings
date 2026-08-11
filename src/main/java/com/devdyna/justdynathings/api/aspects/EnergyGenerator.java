package com.devdyna.justdynathings.api.aspects;

public interface EnergyGenerator extends EnergyMachine {

    /**
     * FE++
     * when not full.
     *
     * @return the actual amount of FE inserted
     */
    default int increaseFEWhenPossible(int value) {
        if (!canRecieveFE() || value <= 0)
            return 0;

        var energyAccepted = Math.min(value, getMaxEnergy() - getEnergyStored());

        setEnergyStored(getEnergyStored() + energyAccepted);

        return energyAccepted;
    }

    /**
     * FE -> Machine | Generate
     * when not full
     */
    default boolean canRecieveFE() {
        return getEnergyStored() < getMaxEnergy();
    }

}
