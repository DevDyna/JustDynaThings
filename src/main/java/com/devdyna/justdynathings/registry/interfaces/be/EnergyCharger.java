package com.devdyna.justdynathings.registry.interfaces.be;

import com.devdyna.justdynathings.utils.LogUtil;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.items.ItemStackHandler;

public interface EnergyCharger {

    default void chargeFEtoItemStack(Level level, BlockPos pos, ItemStackHandler item, IEnergyStorage block) {
        try {
            if (block.canExtract() && item != null) {
                var cap = item.getStackInSlot(0).getCapability(Capabilities.EnergyStorage.ITEM);

                if (cap == null)
                    return;

                if (!cap.canReceive() || !block.canExtract())
                    return;

                cap.receiveEnergy(
                        block.extractEnergy(cap.getMaxEnergyStored() - cap.getEnergyStored(),
                                false),
                        false);

            }

        } catch (Exception e) {

            var be = level.getBlockEntity(pos);

            if (be == null)
                return;

            LogUtil.error("Corrupted Block Entity Storage at " + pos.toString() + "-> Formatted to prevent crash and bugs");

            be.setData(Registration.MACHINE_HANDLER, new ItemStackHandler(1));
        }

    }

}
