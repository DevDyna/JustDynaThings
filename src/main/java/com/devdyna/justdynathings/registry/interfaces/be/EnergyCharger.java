package com.devdyna.justdynathings.registry.interfaces.be;

import com.devdyna.justdynathings.utils.LogUtil;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.items.ItemStackHandler;

@SuppressWarnings("null")
public interface EnergyCharger {

    default void chargeFEtoItemStack(Level level, BlockPos pos, ItemStack item, IEnergyStorage block) {
            if (block.canExtract() && item != null) {
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

}
