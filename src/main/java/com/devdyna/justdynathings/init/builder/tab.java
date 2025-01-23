package com.devdyna.justdynathings.init.builder;

import com.devdyna.justdynathings.Main;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class tab {
    public static void register(IEventBus bus) {
        zCTBS.register(bus);
    }

    public static final DeferredRegister<CreativeModeTab> zCTBS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, Main.ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CreativeTab = zCTBS
            .register(Main.ID, () -> CreativeModeTab.builder()
                    .title(Component.translatable(Main.ID + ".tab"))

                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> material.GooT5_ITEM.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {

                        material.zITM.getEntries().forEach(e -> {
                            output.accept((Item) e.get());
                        });

                    }).build());
}
