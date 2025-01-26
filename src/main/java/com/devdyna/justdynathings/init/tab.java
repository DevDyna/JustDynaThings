package com.devdyna.justdynathings.init;

import com.devdyna.justdynathings.Main;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;

public class Tab {

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CreativeTab = DefType.zCTBS
            .register(Main.ID, () -> CreativeModeTab.builder()
                    .title(Component.translatable(Main.ID + ".tabname"))

                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> Material.GooT5_BLOCK.get().asItem().getDefaultInstance())
                    .displayItems((parameters, output) -> {

                        DefType.zITM.getEntries().forEach(e -> {
                            output.accept((Item) e.get());
                        });

                    }).build());
}
