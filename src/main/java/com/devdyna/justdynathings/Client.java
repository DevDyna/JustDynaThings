package com.devdyna.justdynathings;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

import com.devdyna.justdynathings.init.Material;
import com.devdyna.justdynathings.init.builder.goo.GooRender;
import com.devdyna.justdynathings.init.builder.reforger.ReforgerScreen;


//IT WORK , DONT TOUCH IT
@EventBusSubscriber(modid = Main.ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class Client {
    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(Material.REFORGER_GUI.get(), ReforgerScreen::new);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(Material.GOO_BE.get(), GooRender::new);
    }
}
