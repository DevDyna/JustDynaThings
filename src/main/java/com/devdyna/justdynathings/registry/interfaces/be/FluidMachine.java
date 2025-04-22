package com.devdyna.justdynathings.registry.interfaces.be;

import com.direwolf20.justdirethings.common.blockentities.basebe.FluidMachineBE;

public interface FluidMachine extends FluidMachineBE {

    int FLrate = 100;
    int FLsize = 10000;

    /**
     * MB / tick
     */
    int getStandardFluidCost();

    /**
     * MB Capacity
     */
    int getMaxMB();

    /**
     * MB--
     * when not empty
     */
    default void extractMBWhenPossible() {
        setAmountStored(
                canExtractMB() ? getAmountStored() - getStandardFluidCost() : 0);
    }

    /**
     * MB++
     * when not full
     */
    default void increaseMBWhenPossible() {
        setAmountStored(canRecieveMB() ? getAmountStored() + getStandardFluidCost() : getMaxMB());
    }

    /**
     * MB <- Machine | Consume
     */
    default boolean canExtractMB() {
        return getAmountStored() >= getStandardFluidCost();
    }

    /**
     * MB -> Machine | Generate
     */
    default boolean canRecieveMB() {
        return !isFull();
    }

}
