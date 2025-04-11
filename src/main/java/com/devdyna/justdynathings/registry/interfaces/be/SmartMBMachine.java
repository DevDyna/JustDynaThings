package com.devdyna.justdynathings.registry.interfaces.be;

import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidMachineBE;

import net.minecraft.world.level.Level;

public interface SmartMBMachine extends FluidMachineBE {

    int getMaxMB();

    int getStandardFluidCost();

    default void extractMBWhenPossible() {
        setAmountStored(
                getAmountStored() <= getStandardFluidCost() ? getAmountStored() : getStandardFluidCost());
    }

    default boolean validFluid() {
        return getAmountStored() > getStandardFluidCost();
    }

    default void extractMBChance(int chance, Level level) {
        if (LevelUtil.chance(chance, level))
            extractMBWhenPossible();
    }

}
