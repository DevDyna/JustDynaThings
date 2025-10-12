package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.client.builder.anvil.blazegold.BlazeGoldAnvilGUI;
import com.devdyna.justdynathings.client.builder.anvil.celestigem.CelestiGemAnvilGUI;
import com.devdyna.justdynathings.client.builder.anvil.eclipsealloy.EclipseAlloyAnvilGUI;
import com.devdyna.justdynathings.client.builder.anvil.ferricore.FerricoreAnvilGUI;
import com.devdyna.justdynathings.client.builder.blackhole.BlackHoleGUI;
import com.devdyna.justdynathings.client.builder.clock.ClockGUI;
import com.devdyna.justdynathings.client.builder.fluidtank.FluidTankGUI;
import com.devdyna.justdynathings.client.builder.reforger.ReforgerGUI;
import com.devdyna.justdynathings.client.builder.solarGen.blazegold.BlazegoldSolarPanelGUI;
import com.devdyna.justdynathings.client.builder.solarGen.celestigem.CelestigemSolarPanelGUI;
import com.devdyna.justdynathings.client.builder.solarGen.eclipsealloy.EclipseAlloySolarPanelGUI;
import com.devdyna.justdynathings.client.builder.solarGen.ferricore.FerricoreSolarPanelGUI;
import com.devdyna.justdynathings.client.builder.thermoGen.ThermoGUI;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zContainers {
        public static void register(IEventBus bus) {
                zCTNR.register(bus);
        }

        public static final DeferredRegister<MenuType<?>> zCTNR = DeferredRegister.create(Registries.MENU, Main.ID);

        public static final DeferredHolder<MenuType<?>, MenuType<ReforgerGUI>> REFORGER = zCTNR
                        .register(Constants.Blocks.Reforger,
                                        () -> IMenuTypeExtension.create(ReforgerGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<ClockGUI>> FERRICORE_CLOCK = zCTNR
                        .register(Constants.Blocks.FerricoreClock,
                                        () -> IMenuTypeExtension.create(ClockGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<ThermoGUI>> THERMOGEN = zCTNR
                        .register(Constants.Blocks.ThermoGen,
                                        () -> IMenuTypeExtension.create(ThermoGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<BlackHoleGUI>> BLACKHOLE = zCTNR
                        .register(Constants.Blocks.BlackHole,
                                        () -> IMenuTypeExtension.create(BlackHoleGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<FerricoreAnvilGUI>> FERRICORE_ANVIL = zCTNR
                        .register(Constants.Anvils.t1,
                                        () -> IMenuTypeExtension.create(FerricoreAnvilGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<BlazeGoldAnvilGUI>> BLAZEGOLD_ANVIL = zCTNR
                        .register(Constants.Anvils.t2,
                                        () -> IMenuTypeExtension.create(BlazeGoldAnvilGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<CelestiGemAnvilGUI>> CELESTIGEM_ANVIL = zCTNR
                        .register(Constants.Anvils.t3,
                                        () -> IMenuTypeExtension.create(CelestiGemAnvilGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<EclipseAlloyAnvilGUI>> ECLIPSEALLOY_ANVIL = zCTNR
                        .register(Constants.Anvils.t4,
                                        () -> IMenuTypeExtension.create(EclipseAlloyAnvilGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<FerricoreSolarPanelGUI>> FERRICORE_SOLAR_PANEL = zCTNR
                        .register(Constants.SolarPanel.t1,
                                        () -> IMenuTypeExtension.create(FerricoreSolarPanelGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<BlazegoldSolarPanelGUI>> BLAZEGOLD_SOLAR_PANEL = zCTNR
                        .register(Constants.SolarPanel.t2,
                                        () -> IMenuTypeExtension.create(BlazegoldSolarPanelGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<CelestigemSolarPanelGUI>> CELESTIGEM_SOLAR_PANEL = zCTNR
                        .register(Constants.SolarPanel.t3,
                                        () -> IMenuTypeExtension.create(CelestigemSolarPanelGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<EclipseAlloySolarPanelGUI>> ECLIPSEALLOY_SOLAR_PANEL = zCTNR
                        .register(Constants.SolarPanel.t4,
                                        () -> IMenuTypeExtension.create(EclipseAlloySolarPanelGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<FluidTankGUI>> FLUID_TANK = zCTNR
                        .register(Constants.Blocks.FluidTank,
                                        () -> IMenuTypeExtension.create(FluidTankGUI::new));

}