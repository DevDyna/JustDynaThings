package com.devdyna.justdynathings.common;

import com.direwolf20.justdirethings.common.capabilities.FluidHandlerItemStack;
import com.devdyna.justdynathings.api.be.EnergyMachine;
import com.devdyna.justdynathings.api.be.FluidMachine;
import com.devdyna.justdynathings.init.types.zBlocks;
import com.devdyna.justdynathings.init.types.zItems;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;
import com.direwolf20.justdirethings.common.capabilities.EnergyStorageItemstack;
import com.direwolf20.justdirethings.common.items.TimeWand;
import com.direwolf20.justdirethings.common.items.datacomponents.JustDireDataComponents;
import com.direwolf20.justdirethings.common.items.interfaces.PoweredItem;
import com.direwolf20.justdirethings.setup.JDTRegistration;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.fluid.FluidResource;

public class Capability {

    @SubscribeEvent
    public static void register(RegisterCapabilitiesEvent event) {

        Block[] TimeFluidMachines = {
                zBlocks.TICKER.get(),
                zBlocks.STABILIZER.get()
        };

        Block[] EnergyMachineBase = {

                zBlocks.CELESTIGEM_ANVIL.get(),
                zBlocks.ECLIPSEALLOY_ANVIL.get(),

                zBlocks.STABILIZER.get(),

                zBlocks.TICKER.get(),

                zBlocks.T1_GOO.get(),
                zBlocks.T2_GOO.get(),
                zBlocks.T3_GOO.get(),
                zBlocks.T4_GOO.get(),

                zBlocks.BLACKHOLE.get()
        };

        Block[] FluidMachineBase = {

                zBlocks.BLACKHOLE.get(),

                zBlocks.STABILIZER.get(),

                zBlocks.BLAZEGOLD_ANVIL.get(),
                zBlocks.ECLIPSEALLOY_ANVIL.get(),

                zBlocks.PARADOX_MIXER.get()
        };

        Block[] ItemStackMachineBase = {

                zBlocks.FERRICORE_ANVIL.get(),
                zBlocks.BLAZEGOLD_ANVIL.get(),
                zBlocks.CELESTIGEM_ANVIL.get(),
                zBlocks.ECLIPSEALLOY_ANVIL.get(),

                zBlocks.BLACKHOLE.get(),

                zBlocks.FERRICORE_SOLARGEN.get(),
                zBlocks.BLAZEGOLD_SOLARGEN.get(),
                zBlocks.CELESTIGEM_SOLARGEN.get(),
                zBlocks.ECLIPSEALLOY_SOLARGEN.get(),

                zBlocks.PARADOX_MIXER.get()

        };

        Item[] PoweredItems = {
                zItems.ADVANCED_TIME_WAND.get(), zItems.ADVANCED_LIGHT_WAND.get()
        };

        // ---------------------------------------------------------------------------------------//
        // generic itemhandler
        event.registerBlock(
                Capabilities.Item.BLOCK, (level, pos, state, be,
                        side) -> be instanceof BaseMachineBE
                                ? be.getData(JDTRegistration.MACHINE_HANDLER)
                                : null,
                ItemStackMachineBase);

        // generic energyhandler
        event.registerBlock(Capabilities.Energy.BLOCK, (level, pos, state, be,
                side) -> (be instanceof PoweredMachineBE || be instanceof EnergyMachine)
                        ? be.getData(JDTRegistration.ENERGYSTORAGE_MACHINES)
                        : null,
                EnergyMachineBase);

        // generic fluidhandler
        event.registerBlock(Capabilities.Fluid.BLOCK, (level, pos, state, be,
                side) -> (be instanceof FluidMachineBE || be instanceof FluidMachine)
                        ? be.getData(JDTRegistration.MACHINE_FLUID_HANDLER)
                        : null,
                FluidMachineBase);

        // ---------------------------------------------------------------------------------------//

        // energy handler generators (no recieve)
        event.registerBlock(Capabilities.Energy.BLOCK, (level, pos, state, be,
                side) -> (be instanceof PoweredMachineBE || be instanceof EnergyMachine)
                        ? be.getData(JDTRegistration.ENERGYSTORAGE_GENERATORS)
                        : null,
                zBlocks.FERRICORE_SOLARGEN.get(), zBlocks.BLAZEGOLD_SOLARGEN.get(),
                zBlocks.CELESTIGEM_SOLARGEN.get(), zBlocks.ECLIPSEALLOY_SOLARGEN.get());

        event.registerItem(Capabilities.Energy.ITEM,
                (s, a) -> {

                    if (s.getItem() instanceof PoweredItem poweredItem)

                        return new EnergyStorageItemstack(a != null ? a : ItemAccess.forStack(s),
                                poweredItem.getMaxEnergy());
                    else
                        return null;

                }, PoweredItems);

        event.registerItem(Capabilities.Fluid.ITEM, (s, a) -> {

            if (s.getItem() instanceof TimeWand wand) {
                return new FluidHandlerItemStack(a != null ? a : ItemAccess.forStack(s),
                        JustDireDataComponents.FLUID_CONTAINER.get(),
                        wand.getMaxMB()) {

                    @Override
                    public boolean isFluidValid(FluidResource r) {
                        return r.is(JDTRegistration.TIME_FLUID_TYPE.get());
                    }
                };
            }

            return null;
        },
                zItems.ADVANCED_TIME_WAND.get());

        event.registerBlock(Capabilities.Fluid.BLOCK,
                (level, pos, state, be,
                        side) -> (be instanceof FluidMachineBE || be instanceof FluidMachine)
                                ? be.getData(JDTRegistration.PARADOX_FLUID_HANDLER)
                                : null,
                TimeFluidMachines);

    }
}
