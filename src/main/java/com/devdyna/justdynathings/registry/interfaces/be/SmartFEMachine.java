package com.devdyna.justdynathings.registry.interfaces.be;

import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;

import net.minecraft.world.level.Level;

public interface SmartFEMachine extends PoweredMachineBE {

    int FErate = 100;
    int FEsize = 10000;

    int getStandardEnergyCost();

    int getMaxEnergy();

    default void extractFEWhenPossible() {
        extractEnergy(
                getEnergyStored() <= getStandardEnergyCost() ? getEnergyStored() : getStandardEnergyCost(),
                false);
    }

    default void increaseFEWhenPossible(int rate) {
        insertEnergy(isFEfull() ? getEnergyStored() + rate : getMaxEnergy(), false);
    }

    default boolean validEnergy() {
        return getEnergyStored() > getStandardEnergyCost();
    }

    default void extractFEChance(int chance, Level level) {
        if (LevelUtil.chance(chance, level))
            extractFEWhenPossible();
    }

    default boolean isFEfull() {
        return getMaxEnergy() >= getEnergyStored();
    }
}