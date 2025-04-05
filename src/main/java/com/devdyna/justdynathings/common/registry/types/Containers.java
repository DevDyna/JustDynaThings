package com.devdyna.justdynathings.common.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.client.builder.blazingAnvil.BlazingAnvilGUI;
import com.devdyna.justdynathings.client.builder.clock.ClockGUI;
import com.devdyna.justdynathings.client.builder.reforger.ReforgerGUI;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Containers {
        public static void register(IEventBus bus) {
                zCTNR.register(bus);
        }

        public static final DeferredRegister<MenuType<?>> zCTNR = DeferredRegister.create(Registries.MENU, Main.ID);

        public static final DeferredHolder<MenuType<?>, MenuType<ReforgerGUI>> REFORGER_GUI = zCTNR
                        .register(Constants.Material.Reforger.id + "_" + Constants.GUI.id,
                                        () -> IMenuTypeExtension.create(ReforgerGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<BlazingAnvilGUI>> BLAZINGANVIL_GUI = zCTNR
                        .register(Constants.Material.BlazingAnvil.id + "_" + Constants.GUI.id,
                                        () -> IMenuTypeExtension.create(BlazingAnvilGUI::new));

        public static final DeferredHolder<MenuType<?>, MenuType<ClockGUI>> CLOCK_GUI = zCTNR
                        .register(Constants.Material.Clock.id + "_" + Constants.GUI.id,
                                        () -> IMenuTypeExtension.create(ClockGUI::new));
}
