package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zCreativeTab {
        public static void register(IEventBus bus) {
                zCreative.register(bus);
        }

        // ---------------------------------------------------------------------------------------//

        public static final DeferredRegister<CreativeModeTab> zCreative = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, Main.ID);
        // ---------------------------------------------------------------------------------------//

        public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVETAB = zCreative
                        .register(Main.ID, () -> CreativeModeTab.builder()
                                        .title(Component.translatable(Main.ID + "." + Constants.CreativeTab))
                                        .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                                        .icon(() -> zBlocks.REFORGER.get().asItem().getDefaultInstance())
                                        .displayItems((parameters, output) -> {

                                                // generic items
                                                zItems.zItem.getEntries().forEach(e -> output.accept((Item) e.get()));

                                                // blocks
                                                zItems.zBlockItem.getEntries()
                                                                .forEach(e -> output.accept((Item) e.get()));
                                                // fluids
                                                zItems.zBucketItem.getEntries()
                                                                .forEach(e -> output.accept((Item) e.get()));

                                                // compat items
                                                // if (Constants.ModAddonCheck.AppliedEnergistics2)
                                                //         com.devdyna.justdynathings.compat.ae2.init.zAE_ITM.getEntries()
                                                //                         .forEach(e -> {
                                                //                                 output.accept((Item) e.get());
                                                //                         });
                                                // if (Constants.ModAddonCheck.ExtendedAE)
                                                //         com.devdyna.justdynathings.compat.extendedae.init.zEXTAE_ITM
                                                //                         .getEntries().forEach(e -> {
                                                //                                 output.accept((Item) e.get());
                                                //                         });
                                                // if (Constants.ModAddonCheck.PhasoriteNetworks)
                                                //         com.devdyna.justdynathings.compat.phasorite.init.zPHASO_ITM
                                                //                         .getEntries().forEach(e -> {
                                                //                                 output.accept((Item) e.get());
                                                //                         });

                                        }).build());

}
