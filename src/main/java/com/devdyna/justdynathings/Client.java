package com.devdyna.justdynathings;

import com.devdyna.justdynathings.common.registry.Material;
import com.devdyna.justdynathings.common.registry.builder.clock.ClockScreen;
import com.devdyna.justdynathings.common.registry.builder.goo.GooRender;
import com.devdyna.justdynathings.common.registry.builder.reforger.ReforgerScreen;
import com.devdyna.justdynathings.common.registry.builder.repairer.BlazingAnvilScreen;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

//IT WORK , DONT TOUCH IT
@EventBusSubscriber(modid = Main.ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class Client {
    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(Material.REFORGER_GUI.get(), ReforgerScreen::new);
        event.register(Material.BLAZINGANVIL_GUI.get(), BlazingAnvilScreen::new);
        event.register(Material.CLOCK_GUI.get(), ClockScreen::new);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(Material.GOO_BE.get(), GooRender::new);
    }
}
