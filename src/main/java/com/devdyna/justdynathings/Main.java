package com.devdyna.justdynathings;

import com.devdyna.justdynathings.init.Material;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;
import com.direwolf20.justdirethings.setup.Registration;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.capabilities.Capabilities.EnergyStorage;
import net.neoforged.neoforge.capabilities.Capabilities.ItemHandler;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

@Mod(Main.ID)
public class Main {
    public static final String ID = "justdynathings";

    public static final Logger LOGGER = LogUtils.getLogger();

    public Main(IEventBus modEventBus, ModContainer modContainer) {
        Material.register(modEventBus);
        modEventBus.addListener(this::regCap);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @SubscribeEvent
    private void regCap(RegisterCapabilitiesEvent event) {
        event.registerBlock(ItemHandler.BLOCK, (level, pos, state, be, side) -> {
            return be instanceof BaseMachineBE ? be.getData(Registration.MACHINE_HANDLER) : null;
        }, Material.REFORGER_BLOCK.get());

        event.registerBlock(EnergyStorage.BLOCK, (level, pos, state, be, side) -> {
            return be instanceof PoweredMachineBE ? be.getData(Registration.ENERGYSTORAGE_MACHINES) : null;
        }, Material.GooT4_ENERGY_BLOCK.get());

    }

}
