package com.devdyna.justdynathings;

import com.devdyna.justdynathings.client.builder.anvil.blazegold.BlazeGoldAnvilScreen;
import com.devdyna.justdynathings.client.builder.anvil.celestigem.CelestiGemAnvilScreen;
import com.devdyna.justdynathings.client.builder.anvil.eclipsealloy.EclipseAlloyAnvilScreen;
import com.devdyna.justdynathings.client.builder.anvil.ferricore.FerricoreAnvilScreen;
import com.devdyna.justdynathings.client.builder.blackhole.BlackHoleScreen;
import com.devdyna.justdynathings.client.builder.clock.ClockScreen;
import com.devdyna.justdynathings.client.builder.paradoxMixer.ParadoxMixerRender;
import com.devdyna.justdynathings.client.builder.paradoxMixer.ParadoxMixerScreen;
import com.devdyna.justdynathings.client.builder.reforger.ReforgerScreen;
import com.devdyna.justdynathings.client.builder.solarGen.blazegold.BlazegoldSolarPanelScreen;
import com.devdyna.justdynathings.client.builder.solarGen.celestigem.CelestigemSolarPanelScreen;
import com.devdyna.justdynathings.client.builder.solarGen.eclipsealloy.EclipseAlloySolarPanelScreen;
import com.devdyna.justdynathings.client.builder.solarGen.ferricore.FerricoreSolarPanelScreen;
import com.devdyna.justdynathings.client.builder.thermoGen.ThermoScreen;
import com.devdyna.justdynathings.registry.builders.goo.creative.CreativeGooRender;
import com.devdyna.justdynathings.registry.builders.goo.energy.EnergyGooRender;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zContainers;
import com.devdyna.justdynathings.registry.types.zItems;
import com.direwolf20.justdirethings.client.itemcustomrenders.FluidbarDecorator;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterItemDecorationsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

//IT WORK , DONT TOUCH IT
@EventBusSubscriber(modid = Main.ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class Client {
    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(zContainers.REFORGER.get(), ReforgerScreen::new);
        event.register(zContainers.FERRICORE_CLOCK.get(), ClockScreen::new);
        event.register(zContainers.THERMOGEN.get(), ThermoScreen::new);
        event.register(zContainers.BLACKHOLE.get(), BlackHoleScreen::new);
        event.register(zContainers.FERRICORE_ANVIL.get(), FerricoreAnvilScreen::new);
        event.register(zContainers.BLAZEGOLD_ANVIL.get(), BlazeGoldAnvilScreen::new);
        event.register(zContainers.CELESTIGEM_ANVIL.get(), CelestiGemAnvilScreen::new);
        event.register(zContainers.ECLIPSEALLOY_ANVIL.get(), EclipseAlloyAnvilScreen::new);

        event.register(zContainers.FERRICORE_SOLAR_PANEL.get(), FerricoreSolarPanelScreen::new);
        event.register(zContainers.BLAZEGOLD_SOLAR_PANEL.get(), BlazegoldSolarPanelScreen::new);
        event.register(zContainers.CELESTIGEM_SOLAR_PANEL.get(), CelestigemSolarPanelScreen::new);
        event.register(zContainers.ECLIPSEALLOY_SOLAR_PANEL.get(), EclipseAlloySolarPanelScreen::new);
      
        event.register(zContainers.PARADOX_MIXER.get(), ParadoxMixerScreen::new);

    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(zBlockEntities.CREATIVE_GOO.get(), CreativeGooRender::new);
        event.registerBlockEntityRenderer(zBlockEntities.ENERGIZED_GOO.get(), EnergyGooRender::new);

        event.registerBlockEntityRenderer(zBlockEntities.T1_GOO.get(), EnergyGooRender::new);
        event.registerBlockEntityRenderer(zBlockEntities.T2_GOO.get(), EnergyGooRender::new);
        event.registerBlockEntityRenderer(zBlockEntities.T3_GOO.get(), EnergyGooRender::new);
        event.registerBlockEntityRenderer(zBlockEntities.T4_GOO.get(), EnergyGooRender::new);

        event.registerBlockEntityRenderer(zBlockEntities.PARADOX_MIXER.get(), ParadoxMixerRender::new);

    }

    @SubscribeEvent
    public static void renderDecorators(RegisterItemDecorationsEvent event) {
        event.register(zItems.ADVANCED_TIME_WAND.get(), new FluidbarDecorator());
    }

}
