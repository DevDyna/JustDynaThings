package com.devdyna.justdynathings;

import com.devdyna.justdynathings.common.registry.Material;
import com.devdyna.justdynathings.common.registry.core.interfaces.be.SmartFEMachine;
import com.devdyna.justdynathings.common.registry.core.interfaces.be.SmartMBMachine;
import com.devdyna.justdynathings.common.registry.types.Blocks;
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
                                Blocks.REFORGER_BLOCK.get(), Blocks.BLAZINGANVIL_BLOCK.get());

        // energyhandler
        event.registerBlock(EnergyStorage.BLOCK, (level, pos, state, be,
                side) -> (be instanceof PoweredMachineBE || be instanceof SmartFEMachine)
                        ? be.getData(Registration.ENERGYSTORAGE_MACHINES)
                        : null,
                        Blocks.BLAZINGANVIL_BLOCK.get(), Blocks.REVITALIZER_BLOCK.get(),
                        Blocks.TICKER_BLOCK.get());

        // goo energystorage
        event.registerBlock(EnergyStorage.BLOCK, (level, pos, state, be,
                side) -> (be instanceof PoweredMachineBE || be instanceof SmartFEMachine)
                        ? be.getData(Registration.ENERGYSTORAGE_MACHINES)
                        : null,
                Blocks.GooT6_ENERGY_BLOCK.get(), Blocks.T0_ENERGY.get(), Blocks.T1_ENERGY.get(),
                Blocks.T2_ENERGY.get(), Blocks.T3_ENERGY.get(), Blocks.T4_ENERGY.get(),
                Blocks.T5_ENERGY.get());

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
                                Blocks.TICKER_BLOCK.get(),Blocks.SCULK_BLOCK.get());

    }

}
