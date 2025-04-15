package com.devdyna.justdynathings;

import com.devdyna.justdynathings.registry.Material;
import com.devdyna.justdynathings.registry.interfaces.be.SmartFEMachine;
import com.devdyna.justdynathings.registry.interfaces.be.SmartMBMachine;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zHandlers;
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
                                zBlocks.REFORGER.get(), zBlocks.BLAZING_ANVIL.get());

                // energyhandler
                event.registerBlock(EnergyStorage.BLOCK, (level, pos, state, be,
                                side) -> (be instanceof PoweredMachineBE || be instanceof SmartFEMachine)
                                                ? be.getData(Registration.ENERGYSTORAGE_MACHINES)
                                                : null,
                                zBlocks.BLAZING_ANVIL.get(), zBlocks.REVITALIZER.get(),
                                zBlocks.TICKER.get(), zBlocks.THERMOGEN.get());

                // goo energystorage
                event.registerBlock(EnergyStorage.BLOCK, (level, pos, state, be,
                                side) -> (be instanceof PoweredMachineBE || be instanceof SmartFEMachine)
                                                ? be.getData(Registration.ENERGYSTORAGE_MACHINES)
                                                : null,
                                zBlocks.ENERGIZED_GOO.get());

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
                                zBlocks.TICKER.get());

                // fluidhandler thermo coolers
                event.registerBlock(FluidHandler.BLOCK,
                                (level, pos, state, be,
                                                side) -> (be instanceof FluidMachineBE || be instanceof SmartMBMachine)
                                                                ? be.getData(zHandlers.THERMO_FUELS)
                                                                : null,
                                zBlocks.THERMOGEN.get());

        }

}
