package com.devdyna.justdynathings.common.registry.core.interfaces.be;

import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;

import net.minecraft.world.level.Level;

public interface SmartFEMachine extends PoweredMachineBE {

    int getMaxEnergy();

    default void extractFEWhenPossible() {
            extractEnergy(
                    getEnergyStored() <= getStandardEnergyCost() ? getEnergyStored() : getStandardEnergyCost(),
                    false);
        }

    default boolean validEnergy() {
        return getEnergyStored() > getStandardEnergyCost();
    }

    default void extractFEChance(int chance,Level level){
        if(LevelUtil.chance(chance, level))
        extractFEWhenPossible();
    }
}