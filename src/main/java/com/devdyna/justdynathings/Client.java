package com.devdyna.justdynathings;

import com.devdyna.justdynathings.client.builder.blazingAnvil.BlazingAnvilScreen;
import com.devdyna.justdynathings.client.builder.clock.ClockScreen;
import com.devdyna.justdynathings.client.builder.reforger.ReforgerScreen;
import com.devdyna.justdynathings.registry.builders.goo.creative.CreativeGooRender;
import com.devdyna.justdynathings.registry.builders.goo.energy.EnergyGooRender;
import com.devdyna.justdynathings.registry.types.BlockEntities;
import com.devdyna.justdynathings.registry.types.Containers;

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
        event.register(Containers.REFORGER.get(), ReforgerScreen::new);
        event.register(Containers.BLAZING_ANVIL.get(), BlazingAnvilScreen::new);
        event.register(Containers.FERRITECORE_CLOCK.get(), ClockScreen::new);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(BlockEntities.CREATIVE_GOO.get(), CreativeGooRender::new);
        event.registerBlockEntityRenderer(BlockEntities.ENERGIZED_GOO.get(), EnergyGooRender::new);
    }
}
