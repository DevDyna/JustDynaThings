package com.devdyna.justdynathings;

import com.devdyna.justdynathings.common.registry.Material;
import com.devdyna.justdynathings.compat.core;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.capabilities.Capabilities.EnergyStorage;
import net.neoforged.neoforge.capabilities.Capabilities.FluidHandler;
import net.neoforged.neoforge.capabilities.Capabilities.ItemHandler;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

import com.mojang.logging.LogUtils;

import guideme.Guide;

import org.slf4j.Logger;

@Mod(Main.ID)
public class Main {
        public static final String ID = "justdynathings";

        public static final Logger LOG = LogUtils.getLogger();

        public Main(IEventBus modEventBus, ModContainer modContainer) {

                Material.register(modEventBus);

                modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

                modEventBus.addListener(this::regCap);

                // compats
                core.ae2_compat(modEventBus);
                core.extendedae_compat(modEventBus);
                core.phasorite_compat(modEventBus);

                Guide.builder(ResourceLocation.parse("justdynathings:guide")).build();
        }

        private void regCap(RegisterCapabilitiesEvent event) {

                event.registerBlock(
                                ItemHandler.BLOCK, (level, pos, state, be,
                                                side) -> be instanceof BaseMachineBE
                                                                ? be.getData(Registration.MACHINE_HANDLER)
                                                                : null,
                                Material.REFORGER_BLOCK.get());

                event.registerBlock(EnergyStorage.BLOCK, (level, pos, state, be,
                                side) -> be instanceof PoweredMachineBE
                                                ? be.getData(Registration.ENERGYSTORAGE_MACHINES)
                                                : null,
                                Material.GooT6_ENERGY_BLOCK.get(), Material.T0_ENERGY.get(), Material.T1_ENERGY.get(),
                                Material.T2_ENERGY.get(), Material.T3_ENERGY.get(), Material.T4_ENERGY.get(),
                                Material.T5_ENERGY.get());

                event.registerBlock(FluidHandler.BLOCK,
                                (level, pos, state, be, side) -> be instanceof FluidMachineBE
                                                ? be.getData(Registration.PARADOX_FLUID_HANDLER)
                                                : null,
                                Material.getBuddingAvailable());

                event.registerBlock(EnergyStorage.BLOCK, (level, pos, state, be,
                                side) -> be instanceof PoweredMachineBE
                                                ? be.getData(Registration.ENERGYSTORAGE_MACHINES)
                                                : null,
                                Material.getBuddingAvailable());

        }

}
