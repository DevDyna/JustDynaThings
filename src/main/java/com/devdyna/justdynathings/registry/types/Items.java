package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.Material;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {
        public static void register(IEventBus bus) {
                registerLists();
                zItem.register(bus);
                zBucketItem.register(bus);
                zBlockItem.register(bus);
                zCoals.register(bus);
        }

        // ---------------------------------------------------------------------------------------//
        public static final DeferredRegister.Items zItem = DeferredRegister.createItems(Main.ID);
        // DONT USE IT , ONLY FUNCTIONAL
        public static final DeferredRegister.Items zBucketItem = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister.Items zBlockItem = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister.Items zCoals = DeferredRegister.createItems(Main.ID);
        // ---------------------------------------------------------------------------------------//

        public static final DeferredHolder<Item, ?> CHAOTIC_DUST = zItem
                        .registerSimpleItem(Constants.Ores.Chaotic.dust);

        public static final DeferredHolder<Item, ?> REDSTONIC_GEM = zItem
                        .registerSimpleItem(Constants.Ores.Redstonic.gem);

        public static final DeferredHolder<Item, ?> RAW_COPRINIUM = zItem
                        .registerSimpleItem(Constants.Ores.Coprinium.raw);

        public static final DeferredHolder<Item, ?> COPRINIUM_INGOT = zItem
                        .registerSimpleItem(Constants.Ores.Coprinium.ingot);

        public static final DeferredHolder<Item, ?> BIOFUEL = Material.DireStuff.FuelItemDW(Constants.Fuel.Biofuel(1),
                        3);

        public static final DeferredHolder<Item, BucketItem> CRYSTALLINE_FLUID_BUCKET = zBucketItem
                        .register(Constants.Fluids.Crystalline.Bucket, () -> new BucketItem(Fluids.CRYSTALLINE_SOURCE.get(),
                                        Material.iPropBucket));
        // ---------------------------------------------------------------------------------------//

        public static void registerLists() {

        }

}
