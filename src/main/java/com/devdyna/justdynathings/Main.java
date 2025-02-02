package com.devdyna.justdynathings;

import com.devdyna.justdynathings.init.Material;
import com.devdyna.justdynathings.init.builder.goo.GooRender;
import com.devdyna.justdynathings.init.builder.reforger.ReforgerScreen;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;
import com.direwolf20.justdirethings.setup.Registration;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@Mod(Main.ID)
public class Main {
    public static final String ID = "justdynathings";

    public Main(IEventBus modEventBus, ModContainer modContainer) {
        Material.register(modEventBus);
        modEventBus.addListener(this::regCap);

        // if (Dist.CLIENT.isClient())
            // NeoForge.EVENT_BUS.register(this);
    }

    private void regCap(RegisterCapabilitiesEvent event) {
        event.registerBlock(Capabilities.ItemHandler.BLOCK, (level, pos, state, be, side) -> {
            return be instanceof BaseMachineBE ? be.getData(Registration.MACHINE_HANDLER) : null;
        }, Material.REFORGER_BLOCK.get());

        event.registerBlock(Capabilities.EnergyStorage.BLOCK, (level, pos, state, be, side) -> {
            return be instanceof PoweredMachineBE ? be.getData(Registration.ENERGYSTORAGE_MACHINES) : null;
        }, Material.GooT4_BLOCK_ENERGY.get());

    }

    public void registerScreens(RegisterMenuScreensEvent event) {
        event.register(Material.GEN_GUI.get(), ReforgerScreen::new);
    }

    public void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(Material.GOO_BE.get(), GooRender::new);
    }
}
