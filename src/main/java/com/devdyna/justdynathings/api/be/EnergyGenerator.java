package com.devdyna.justdynathings.api.be;

public interface EnergyGenerator extends EnergyMachine {

    /**
     * FE++
     * when not full
     */
    default void increaseFEWhenPossible(int value) {

        if (canRecieveFE())
            setEnergyStored(Math.min(getEnergyStored() + value, getMaxEnergy()));
        // insertEnergy dont work with generators

    }

    /**
     * FE -> Machine | Generate
     * when not full
     */
    default boolean canRecieveFE() {
        return getEnergyStored() < getMaxEnergy();
    }

}
