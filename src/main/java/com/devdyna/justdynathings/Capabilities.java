package com.devdyna.justdynathings;

import com.devdyna.justdynathings.registry.Material;
import com.devdyna.justdynathings.registry.builders.AdvancedTimeWand;
import com.devdyna.justdynathings.registry.interfaces.be.EnergyMachine;
import com.devdyna.justdynathings.registry.interfaces.be.FluidMachine;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zItems;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;
import com.direwolf20.justdirethings.common.capabilities.EnergyStorageItemstack;
import com.direwolf20.justdirethings.common.items.datacomponents.JustDireDataComponents;
import com.direwolf20.justdirethings.common.items.interfaces.PoweredItem;
import com.direwolf20.justdirethings.setup.Registration;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.capabilities.Capabilities.EnergyStorage;
import net.neoforged.neoforge.capabilities.Capabilities.FluidHandler;
import net.neoforged.neoforge.capabilities.Capabilities.ItemHandler;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.templates.FluidHandlerItemStack;

@SuppressWarnings("null")
public class Capabilities {

        public static void regCap(RegisterCapabilitiesEvent event) {

                Block[] TimeFluidMachines = {
                                zBlocks.TICKER.get(),
                                zBlocks.STABILIZER.get()
                };

                Block[] EnergyMachineBase = {

                                zBlocks.CELESTIGEM_ANVIL.get(),
                                zBlocks.ECLIPSEALLOY_ANVIL.get(),

                                zBlocks.STABILIZER.get(),

                                zBlocks.TICKER.get(),

                                zBlocks.ENERGIZED_GOO.get(),
                                zBlocks.T1_GOO.get(), zBlocks.T2_GOO.get(),
                                zBlocks.T3_GOO.get(), zBlocks.T4_GOO.get(),

                                zBlocks.BLACKHOLE.get()
                };

                Block[] FluidMachineBase = {

                                zBlocks.BLACKHOLE.get(),
                                zBlocks.THERMOGEN.get(),

                                zBlocks.STABILIZER.get(),

                                zBlocks.BLAZEGOLD_ANVIL.get(),
                                zBlocks.ECLIPSEALLOY_ANVIL.get(),

                                zBlocks.PARADOX_MIXER.get()
                };

                Block[] ItemStackMachineBase = {

                                zBlocks.REFORGER.get(),

                                zBlocks.FERRICORE_ANVIL.get(),
                                zBlocks.BLAZEGOLD_ANVIL.get(),
                                zBlocks.CELESTIGEM_ANVIL.get(),
                                zBlocks.ECLIPSEALLOY_ANVIL.get(),

                                zBlocks.BLACKHOLE.get(),
                                zBlocks.THERMOGEN.get(),

                                zBlocks.FERRICORE_SOLARGEN.get(),
                                zBlocks.BLAZEGOLD_SOLARGEN.get(),
                                zBlocks.CELESTIGEM_SOLARGEN.get(),
                                zBlocks.ECLIPSEALLOY_SOLARGEN.get(),

                                zBlocks.PARADOX_MIXER.get()

                };

                // ---------------------------------------------------------------------------------------//
                // generic itemhandler
                event.registerBlock(
                                ItemHandler.BLOCK, (level, pos, state, be,
                                                side) -> be instanceof BaseMachineBE
                                                                ? be.getData(Registration.MACHINE_HANDLER)
                                                                : null,
                                ItemStackMachineBase);

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

                event.registerItem(EnergyStorage.ITEM,
                                (i, c) -> {
                                        if (i.getItem() instanceof PoweredItem poweredItem)

                                                return new EnergyStorageItemstack(poweredItem.getMaxEnergy(), i);
                                        else
                                                return null;

                                }, zItems.ADVANCED_TIME_WAND.get());

                event.registerItem(FluidHandler.ITEM, (i, c) -> {

                        if (i.getItem() instanceof AdvancedTimeWand w) {
                                return new FluidHandlerItemStack(JustDireDataComponents.FLUID_CONTAINER, i,
                                                w.getMaxMB()) {
                                        @Override
                                        public boolean isFluidValid(int tank, FluidStack stack) {
                                                return stack.is(Registration.TIME_FLUID_TYPE.get());
                                        }

                                        @Override
                                        public boolean canFillFluidType(FluidStack fluid) {
                                                return fluid.is(Registration.TIME_FLUID_TYPE.get());
                                        }

                                };
                        } else
                                return null;
                },

                                zItems.ADVANCED_TIME_WAND.get());

                event.registerBlock(FluidHandler.BLOCK,
                                (level, pos, state, be,
                                                side) -> (be instanceof FluidMachineBE || be instanceof FluidMachine)
                                                                ? be.getData(Registration.PARADOX_FLUID_HANDLER)
                                                                : null,
                                TimeFluidMachines);

        }

}
