package com.devdyna.justdynathings.init;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.init.builder.goo.GooT0Render;
import com.devdyna.justdynathings.init.builder.goo.GooT5Render;
import com.devdyna.justdynathings.init.builder.reforger.ReforgerScreen;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(modid = Main.ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class Client {

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(Material.GEN_GUI.get(), ReforgerScreen::new);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(Material.GooT0_BE.get(), GooT0Render::new);
        event.registerBlockEntityRenderer(Material.GooT5_BE.get(), GooT5Render::new);
    }
}
