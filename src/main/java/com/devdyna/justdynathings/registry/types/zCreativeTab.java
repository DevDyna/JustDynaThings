package com.devdyna.justdynathings.registry.types;

import java.util.Arrays;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.Material;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import com.devdyna.justdynathings.compat.chisel.initChisel;

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

                                                // tools
                                                zItems.zItemHanded.getEntries()
                                                                .forEach(e -> output.accept((Item) e.get()));

                                                // fuels
                                                zItems.zCoals.getEntries()
                                                                .forEach(e -> output.accept((Item) e.get()));

                                                // blocks
                                                zItems.zBlockItem.getEntries()
                                                                .forEach(e -> output.accept((Item) e.get()));
                                                // fluids
                                                zItems.zBucketItem.getEntries()
                                                                .forEach(e -> output.accept((Item) e.get()));

                                                zItems.zGooUpgraders.getEntries()
                                                                .forEach(e -> output.accept((Item) e.get()));

                                                // compat items
                                                Arrays.asList(Material.getBuddingAvailable())
                                                                .stream()
                                                                .forEach(e -> output.accept((Item) e.asItem()));

                                                // compat chisel
                                                if (Constants.ModAddonCheck.Chisel){
                                                        output.accept(initChisel.FERRICORE_CHISEL.get());
                                                        output.accept(initChisel.BLAZEGOLD_CHISEL.get());
                                                        output.accept(initChisel.CELESTIGEM_CHISEL.get());
                                                        output.accept(initChisel.ECLIPSE_ALLOY_CHISEL.get());
                                                }

                                        }).build());

}
