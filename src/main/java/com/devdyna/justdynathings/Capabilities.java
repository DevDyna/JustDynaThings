package com.devdyna.justdynathings;

import com.devdyna.justdynathings.common.registry.Material;
import com.devdyna.justdynathings.common.registry.core.interfaces.be.SmartFEMachine;
import com.devdyna.justdynathings.common.registry.core.interfaces.be.SmartMBMachine;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;
import com.direwolf20.justdirethings.setup.Registration;

import net.neoforged.neoforge.capabilities.Capabilities.EnergyStorage;
import net.neoforged.neoforge.capabilities.Capabilities.FluidHandler;
import net.neoforged.neoforge.capabilities.Capabilities.ItemHandler;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class Capabilities {

    public static void regCap(RegisterCapabilitiesEvent event) {

        // itemhandler
        event.registerBlock(
                ItemHandler.BLOCK, (level, pos, state, be,
                        side) -> be instanceof BaseMachineBE
                                ? be.getData(Registration.MACHINE_HANDLER)
                                : null,
                Material.REFORGER_BLOCK.get(), Material.BLAZINGANVIL_BLOCK.get());

        // energyhandler
        event.registerBlock(EnergyStorage.BLOCK, (level, pos, state, be,
                side) -> (be instanceof PoweredMachineBE || be instanceof SmartFEMachine)
                        ? be.getData(Registration.ENERGYSTORAGE_MACHINES)
                        : null,
                Material.BLAZINGANVIL_BLOCK.get(), Material.REVITALIZER_BLOCK.get(),
                Material.TICKER_BLOCK.get());

        // goo energystorage
        event.registerBlock(EnergyStorage.BLOCK, (level, pos, state, be,
                side) -> (be instanceof PoweredMachineBE || be instanceof SmartFEMachine)
                        ? be.getData(Registration.ENERGYSTORAGE_MACHINES)
                        : null,
                Material.GooT6_ENERGY_BLOCK.get(), Material.T0_ENERGY.get(), Material.T1_ENERGY.get(),
                Material.T2_ENERGY.get(), Material.T3_ENERGY.get(), Material.T4_ENERGY.get(),
                Material.T5_ENERGY.get());

        // budding time storage
        event.registerBlock(FluidHandler.BLOCK,
                (level, pos, state, be,
                        side) -> (be instanceof FluidMachineBE || be instanceof SmartMBMachine)
                                ? be.getData(Registration.PARADOX_FLUID_HANDLER)
                                : null,
                Material.getBuddingAvailable());

        // budding energy storage
        event.registerBlock(EnergyStorage.BLOCK, (level, pos, state, be,
                side) -> (be instanceof PoweredMachineBE || be instanceof SmartFEMachine)
                        ? be.getData(Registration.ENERGYSTORAGE_MACHINES)
                        : null,
                Material.getBuddingAvailable());

        // fluidhandler time storage
        event.registerBlock(FluidHandler.BLOCK,
                (level, pos, state, be,
                        side) -> (be instanceof FluidMachineBE || be instanceof SmartMBMachine)
                                ? be.getData(Registration.PARADOX_FLUID_HANDLER)
                                : null,
                Material.TICKER_BLOCK.get());

    }

}
