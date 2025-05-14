package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.client.builder.anvil.magmatic.MagmaticAnvilGUI;
import com.devdyna.justdynathings.client.builder.anvil.metallic.MetallicAnvilGUI;
import com.devdyna.justdynathings.client.builder.anvil.powered.PoweredAnvilGUI;
import com.devdyna.justdynathings.client.builder.blackhole.BlackHoleGUI;
import com.devdyna.justdynathings.client.builder.clock.ClockGUI;
import com.devdyna.justdynathings.client.builder.reforger.ReforgerGUI;
import com.devdyna.justdynathings.client.builder.solarGen.SolarGUI;
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

        public static final DeferredHolder<MenuType<?>, MenuType<SolarGUI>> SOLAR_PANEL = zCTNR
                        .register(Constants.Blocks.SolarGen,
                                        () -> IMenuTypeExtension.create(SolarGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<MetallicAnvilGUI>> METALLIC_ANVIL = zCTNR
                        .register(Constants.Anvil.metallic,
                                        () -> IMenuTypeExtension.create(MetallicAnvilGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<MagmaticAnvilGUI>> MAGMATIC_ANVIL = zCTNR
                        .register(Constants.Anvil.magmatic,
                                        () -> IMenuTypeExtension.create(MagmaticAnvilGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<PoweredAnvilGUI>> POWERED_ANVIL = zCTNR
                        .register(Constants.Anvil.powered,
                                        () -> IMenuTypeExtension.create(PoweredAnvilGUI::new));

}
