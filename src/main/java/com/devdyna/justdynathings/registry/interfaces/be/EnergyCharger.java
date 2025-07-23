package com.devdyna.justdynathings.registry.interfaces.be;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;

public interface EnergyCharger {

    default void charge(ItemStack item , IEnergyStorage block){

        // var item = getMachineHandler().getStackInSlot(0);

        if (block.canExtract() && item != null ) {
            var cap = item.getCapability(Capabilities.EnergyStorage.ITEM);

            if (cap == null)
                return;

            if (!cap.canReceive() || !block.canExtract())
                return;

            cap.receiveEnergy(
                    block.extractEnergy(cap.getMaxEnergyStored() - cap.getEnergyStored(),
                            false),
                    false);

        }



    }

}
