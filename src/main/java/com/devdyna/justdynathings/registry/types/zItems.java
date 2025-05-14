package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.Material;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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

        //TODO add more fuels and add to CTab
        public static final DeferredHolder<Item, ?> BIOFUEL = Material.DireStuff.FuelItemDW(Constants.Fuel.Biofuel(1),
                        3);

        public static DeferredHolder<Item, ?> REDSTONE_JUICE_BUCKET = zBucketItem.register(Constants.Fluids.RedstoneJuice.Bucket,
                        () -> new BucketItem(zFluids.REDSTONE_JUICE_SOURCE.get(),
                                        new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

        // ---------------------------------------------------------------------------------------//

        public static void registerLists() {

        }

}
