package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Main;
import net.neoforged.bus.api.IEventBus;
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

        // public static final DeferredHolder<Item, ?> BIO_FUEL = Material.DireStuff.FuelItemDW(Constants.Fuel.BIOFUEL,
        //                 3);

        // public static final DeferredHolder<Item, ?> REDSTONE_FUEL = Material.DireStuff.FuelItemDW(
        //                 Constants.Fuel.REDSTONE,
        //                 15);

        // public static final DeferredHolder<Item, ?> LAPIS_LAZULI_FUEL = Material.DireStuff.FuelItemDW(
        //                 Constants.Fuel.LAPIS_LAZULI,
        //                 5);

        // public static DeferredHolder<Item, BucketItem> REDSTONE_JUICE_BUCKET = zBucketItem.register(
        //                 Constants.Fluids.RedstoneJuice.Bucket,
        //                 () -> new BucketItem(zFluids.REDSTONE_JUICE_SOURCE.get(),
        //                                 new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

        // public static DeferredHolder<Item, BucketItem> LAPIS_LAZULI_JUICE_BUCKET = zBucketItem.register(
        //                 Constants.Fluids.LapisLazuliJuice.Bucket,
        //                 () -> new BucketItem(zFluids.LAPIS_LAZULI_JUICE_SOURCE.get(),
        //                                 new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

        // ---------------------------------------------------------------------------------------//

        public static void registerLists() {

        }

}
