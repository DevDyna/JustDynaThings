package com.devdyna.justdynathings;

import com.devdyna.justdynathings.client.builder.blackhole.BlackHoleScreen;
import com.devdyna.justdynathings.client.builder.blazingAnvil.BlazingAnvilScreen;
import com.devdyna.justdynathings.client.builder.clock.ClockScreen;
import com.devdyna.justdynathings.client.builder.reforger.ReforgerScreen;
import com.devdyna.justdynathings.client.builder.thermoGen.ThermoScreen;
import com.devdyna.justdynathings.registry.builders.goo.creative.CreativeGooRender;
import com.devdyna.justdynathings.registry.builders.goo.energy.EnergyGooRender;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zContainers;

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
        event.register(zContainers.REFORGER.get(), ReforgerScreen::new);
        event.register(zContainers.BLAZING_ANVIL.get(), BlazingAnvilScreen::new);
        event.register(zContainers.FERRITECORE_CLOCK.get(), ClockScreen::new);
        event.register(zContainers.THERMOGEN.get(), ThermoScreen::new);
        event.register(zContainers.BLACKHOLE.get(), BlackHoleScreen::new);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(zBlockEntities.CREATIVE_GOO.get(), CreativeGooRender::new);
        event.registerBlockEntityRenderer(zBlockEntities.ENERGIZED_GOO.get(), EnergyGooRender::new);

        event.registerBlockEntityRenderer(zBlockEntities.T1_GOO.get(), EnergyGooRender::new);
        event.registerBlockEntityRenderer(zBlockEntities.T2_GOO.get(), EnergyGooRender::new);
        event.registerBlockEntityRenderer(zBlockEntities.T3_GOO.get(), EnergyGooRender::new);
        event.registerBlockEntityRenderer(zBlockEntities.T4_GOO.get(), EnergyGooRender::new);

    }
}
