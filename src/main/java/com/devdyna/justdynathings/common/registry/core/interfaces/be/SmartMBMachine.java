package com.devdyna.justdynathings.common.registry.core.interfaces.be;

import com.direwolf20.justdirethings.common.blockentities.basebe.FluidMachineBE;

public interface SmartMBMachine extends FluidMachineBE {

    int getStandardFluidCost();

    default void extractMBWhenPossible() {
        setAmountStored(
                getAmountStored() <= getStandardFluidCost() ? getAmountStored() : getStandardFluidCost());
    }

    default boolean validFluid() {
        return getAmountStored() > getStandardFluidCost();
    }

}
