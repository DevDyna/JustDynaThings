package com.devdyna.justdynathings.common.registry.types;



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

public class CreativeTab {
        public static void register(IEventBus bus) {
                zCreative.register(bus);
        }

        // ---------------------------------------------------------------------------------------//

        public static final DeferredRegister<CreativeModeTab> zCreative = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, Main.ID);
        // ---------------------------------------------------------------------------------------//

        public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVETAB = zCreative
                        .register(Main.ID, () -> CreativeModeTab.builder()
                                        .title(Component.translatable(Main.ID + "." + Constants.CreativeTab.id))
                                        .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                                        .icon(() -> Blocks.REFORGER_BLOCK.get().asItem().getDefaultInstance())
                                        .displayItems((parameters, output) -> {
                                                Items.zItem.getEntries().forEach(e -> {
                                                        output.accept((Item) e.get());
                                                });

                                                if (Constants.Mods.AE2.check)
                                                        com.devdyna.justdynathings.compat.ae2.init.zAE_ITM.getEntries()
                                                                        .forEach(e -> {
                                                                                output.accept((Item) e.get());
                                                                        });
                                                if (Constants.Mods.ExtendedAE.check)
                                                        com.devdyna.justdynathings.compat.extendedae.init.zEXTAE_ITM
                                                                        .getEntries().forEach(e -> {
                                                                                output.accept((Item) e.get());
                                                                        });
                                                if (Constants.Mods.PhasoriteNetworks.check)
                                                        com.devdyna.justdynathings.compat.phasorite.init.zPHASO_ITM
                                                                        .getEntries().forEach(e -> {
                                                                                output.accept((Item) e.get());
                                                                        });

                                        }).build());

}
