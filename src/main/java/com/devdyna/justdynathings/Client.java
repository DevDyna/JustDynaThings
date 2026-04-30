package com.devdyna.justdynathings;

import com.devdyna.justdynathings.api.solar_panels.SolarPanelScreen;
import com.devdyna.justdynathings.init.builder.black_hole.BlackHoleScreen;
import com.devdyna.justdynathings.init.builder.ferricore_clock.FerricoreClockScreen;
import com.devdyna.justdynathings.init.builder.goo.creative.CreativeGooRender;
import com.devdyna.justdynathings.init.builder.goo.energy.EnergyGooRender;
import com.devdyna.justdynathings.init.builder.paradox_mixer.ParadoxMixerScreen;
import com.devdyna.justdynathings.init.builder.repair_anvils.blazegold.BlazeGoldAnvilScreen;
import com.devdyna.justdynathings.init.builder.repair_anvils.celestigem.CelestiGemAnvilScreen;
import com.devdyna.justdynathings.init.builder.repair_anvils.eclipsealloy.EclipseAlloyAnvilScreen;
import com.devdyna.justdynathings.init.builder.repair_anvils.ferricore.FerricoreAnvilScreen;
import com.devdyna.justdynathings.init.builder.solar_panels.blazegold.BlazegoldSolarPanelGUI;
import com.devdyna.justdynathings.init.builder.solar_panels.celestigem.CelestigemSolarPanelGUI;
import com.devdyna.justdynathings.init.builder.solar_panels.eclipsealloy.EclipseAlloySolarPanelGUI;
import com.devdyna.justdynathings.init.builder.solar_panels.ferricore.FerricoreSolarPanelGUI;
import com.devdyna.justdynathings.init.builder.ticker.TickerScreen;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import com.devdyna.justdynathings.init.types.zContainers;
import com.devdyna.justdynathings.init.types.zItems;
import com.direwolf20.justdirethings.client.itemcustomrenders.FluidbarDecorator;

import net.minecraft.world.item.crafting.RecipeMap;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RecipesReceivedEvent;
import net.neoforged.neoforge.client.event.RegisterItemDecorationsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = JustDynaThings.MODULE_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = JustDynaThings.MODULE_ID, value = Dist.CLIENT)
public class Client {

    public Client(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(zContainers.TICKER.get(), TickerScreen::new);
        event.register(zContainers.FERRICORE_CLOCK.get(), FerricoreClockScreen::new);
        event.register(zContainers.BLACKHOLE.get(), BlackHoleScreen::new);

        event.register(zContainers.FERRICORE_ANVIL.get(), FerricoreAnvilScreen::new);
        event.register(zContainers.BLAZEGOLD_ANVIL.get(), BlazeGoldAnvilScreen::new);
        event.register(zContainers.CELESTIGEM_ANVIL.get(), CelestiGemAnvilScreen::new);
        event.register(zContainers.ECLIPSEALLOY_ANVIL.get(), EclipseAlloyAnvilScreen::new);

        event.register(zContainers.FERRICORE_SOLAR_PANEL.get(), SolarPanelScreen<FerricoreSolarPanelGUI>::new);
        event.register(zContainers.BLAZEGOLD_SOLAR_PANEL.get(), SolarPanelScreen<BlazegoldSolarPanelGUI>::new);
        event.register(zContainers.CELESTIGEM_SOLAR_PANEL.get(), SolarPanelScreen<CelestigemSolarPanelGUI>::new);
        event.register(zContainers.ECLIPSEALLOY_SOLAR_PANEL.get(), SolarPanelScreen<EclipseAlloySolarPanelGUI>::new);

        event.register(zContainers.PARADOX_MIXER.get(), ParadoxMixerScreen::new);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(zBlockEntities.CREATIVE_GOO.get(), CreativeGooRender::new);

        event.registerBlockEntityRenderer(zBlockEntities.T1_GOO.get(), EnergyGooRender::new);
        event.registerBlockEntityRenderer(zBlockEntities.T2_GOO.get(), EnergyGooRender::new);
        event.registerBlockEntityRenderer(zBlockEntities.T3_GOO.get(), EnergyGooRender::new);
        event.registerBlockEntityRenderer(zBlockEntities.T4_GOO.get(), EnergyGooRender::new);

    }

    @SubscribeEvent
    public static void renderDecorators(RegisterItemDecorationsEvent event) {
        event.register(zItems.ADVANCED_TIME_WAND.get(), new FluidbarDecorator());
    }

    // Recipe collector client-side

    private static RecipeMap recipeCollector = RecipeMap.EMPTY;

    @SubscribeEvent
    public static void onRecipesSynced(RecipesReceivedEvent event) {
        if (ModList.get().isLoaded("jei"))
            recipeCollector = event.getRecipeMap();
    }

    @SubscribeEvent
    public static void onClientLogout(ClientPlayerNetworkEvent.LoggingOut event) {
        recipeCollector = RecipeMap.EMPTY;
    }

    public static RecipeMap getRecipeCollector() {
        return recipeCollector;
    }

}
