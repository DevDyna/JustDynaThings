package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.Material;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zItems {
        public static void register(IEventBus bus) {
                registerLists();
                zItem.register(bus);
                zItemTinted.register(bus);
                zBucketItem.register(bus);
                zBlockItem.register(bus);
                zCoals.register(bus);
        }

        // ---------------------------------------------------------------------------------------//
        public static final DeferredRegister.Items zItem = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister.Items zItemTinted = DeferredRegister.createItems(Main.ID);
        // DONT USE IT , ONLY FUNCTIONAL
        public static final DeferredRegister.Items zBucketItem = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister.Items zBlockItem = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister.Items zCoals = DeferredRegister.createItems(Main.ID);
        // ---------------------------------------------------------------------------------------//

        // public static final DeferredHolder<Item, Item> CHAOTIC_DUST = zItem
        //                 .registerSimpleItem(Constants.Ores.Chaotic.dust);

        // public static final DeferredHolder<Item, Item> REDSTONIC_GEM = zItemTinted
        //                 .registerSimpleItem(Constants.Ores.Redstonic.gem);

        // public static final DeferredHolder<Item, Item> RAW_COPRINIUM = zItem
        //                 .registerSimpleItem(Constants.Ores.Coprinium.raw);

        // public static final DeferredHolder<Item, Item> COPRINIUM_INGOT = zItem
        //                 .registerSimpleItem(Constants.Ores.Coprinium.ingot);

        //TODO add more fuels and add to CTab
        public static final DeferredHolder<Item, ?> BIOFUEL = Material.DireStuff.FuelItemDW(Constants.Fuel.Biofuel(1),
                        3);

        // public static DeferredHolder<Item, ?> CRYSTALLINE_BUCKET = zBucketItem.register(Constants.Fluids.Crystalline.Bucket,
        //                 () -> new BucketItem(zFluids.CRYSTALLINE_SOURCE.get(),
        //                                 new Item.Properties().craftRemainder(BUCKET).stacksTo(1)));

        // ---------------------------------------------------------------------------------------//

        public static void registerLists() {

        }

}
