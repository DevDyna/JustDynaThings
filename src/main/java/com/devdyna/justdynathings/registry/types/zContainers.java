package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.client.builder.blackhole.BlackHoleGUI;
import com.devdyna.justdynathings.client.builder.blazingAnvil.BlazingAnvilGUI;
import com.devdyna.justdynathings.client.builder.clock.ClockGUI;
import com.devdyna.justdynathings.client.builder.reforger.ReforgerGUI;
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

        public static final DeferredHolder<MenuType<?>, MenuType<BlazingAnvilGUI>> BLAZING_ANVIL = zCTNR
                        .register(Constants.Blocks.BlazingAnvil,
                                        () -> IMenuTypeExtension.create(BlazingAnvilGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<ClockGUI>> FERRITECORE_CLOCK = zCTNR
                        .register(Constants.Blocks.FerritecoreClock,
                                        () -> IMenuTypeExtension.create(ClockGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<ThermoGUI>> THERMOGEN = zCTNR
                        .register(Constants.Blocks.ThermoGen,
                                        () -> IMenuTypeExtension.create(ThermoGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<BlackHoleGUI>> BLACKHOLE = zCTNR
                        .register(Constants.Blocks.BlackHole,
                                        () -> IMenuTypeExtension.create(BlackHoleGUI::new));
}
