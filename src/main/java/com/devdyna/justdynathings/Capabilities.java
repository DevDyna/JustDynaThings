package com.devdyna.justdynathings;

import com.devdyna.justdynathings.registry.Material;
import com.devdyna.justdynathings.registry.interfaces.be.EnergyMachine;
import com.devdyna.justdynathings.registry.interfaces.be.FluidMachine;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.capabilities.Capabilities.EnergyStorage;
import net.neoforged.neoforge.capabilities.Capabilities.FluidHandler;
import net.neoforged.neoforge.capabilities.Capabilities.ItemHandler;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

public class Capabilities {

        public static void regCap(RegisterCapabilitiesEvent event) {

                Block[] EnergyMachineBase = {
                                zBlocks.CELESTIGEM_ANVIL.get(), zBlocks.ECLIPSEALLOY_ANVIL.get(),
                                zBlocks.REVITALIZER.get(),
                                zBlocks.ENERGIZED_GOO.get(),
                                zBlocks.T1_GOO.get(), zBlocks.T2_GOO.get(),
                                zBlocks.T3_GOO.get(), zBlocks.T4_GOO.get(), zBlocks.BLACKHOLE.get()
                };

                Block[] FluidMachineBase = {
                                zBlocks.BLACKHOLE.get(),
                                zBlocks.THERMOGEN.get(),
                                zBlocks.BLAZEGOLD_ANVIL.get(),
                                zBlocks.ECLIPSEALLOY_ANVIL.get() };

                Block[] ItemStacMachineBase = { zBlocks.REFORGER.get(),
                                zBlocks.FERRICORE_ANVIL.get(),
                                zBlocks.BLAZEGOLD_ANVIL.get(),
                                zBlocks.CELESTIGEM_ANVIL.get(),
                                zBlocks.BLACKHOLE.get() };

                // ---------------------------------------------------------------------------------------//
                // generic itemhandler
                event.registerBlock(
                                ItemHandler.BLOCK, (level, pos, state, be,
                                                side) -> be instanceof BaseMachineBE
                                                                ? be.getData(Registration.MACHINE_HANDLER)
                                                                : null,
                                ItemStacMachineBase);

                // generic energyhandler
                event.registerBlock(EnergyStorage.BLOCK, (level, pos, state, be,
                                side) -> (be instanceof PoweredMachineBE || be instanceof EnergyMachine)
                                                ? be.getData(Registration.ENERGYSTORAGE_MACHINES)
                                                : null,
                                EnergyMachineBase);

                // generic fluidhandler
                event.registerBlock(FluidHandler.BLOCK, (level, pos, state, be,
                                side) -> (be instanceof FluidMachineBE || be instanceof FluidMachine)
                                                ? be.getData(Registration.MACHINE_FLUID_HANDLER)
                                                : null,
                                FluidMachineBase);

                // ---------------------------------------------------------------------------------------//

                // generic energyhandler - buddings
                event.registerBlock(EnergyStorage.BLOCK, (level, pos, state, be,
                                side) -> (be instanceof PoweredMachineBE || be instanceof EnergyMachine)
                                                ? be.getData(Registration.ENERGYSTORAGE_MACHINES)
                                                : null,
                                Material.getBuddingAvailable());

                // fluidhandler time storage - buddings
                event.registerBlock(FluidHandler.BLOCK,
                                (level, pos, state, be,
                                                side) -> (be instanceof FluidMachineBE || be instanceof FluidMachine)
                                                                ? be.getData(Registration.PARADOX_FLUID_HANDLER)
                                                                : null,
                                Material.getBuddingAvailable());

                // energy handler generators (no recieve)
                event.registerBlock(EnergyStorage.BLOCK, (level, pos, state, be,
                                side) -> (be instanceof PoweredMachineBE || be instanceof EnergyMachine)
                                                ? be.getData(Registration.ENERGYSTORAGE_GENERATORS)
                                                : null,
                                zBlocks.THERMOGEN.get(),
                                zBlocks.FERRICORE_SOLARGEN.get(), zBlocks.BLAZEGOLD_SOLARGEN.get(),
                                zBlocks.CELESTIGEM_SOLARGEN.get(), zBlocks.ECLIPSEALLOY_SOLARGEN.get());

        }

}
