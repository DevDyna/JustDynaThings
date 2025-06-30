package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.builders.PickerWand;
import com.devdyna.justdynathings.registry.builders.SwapperWand;

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
                zItemHanded.register(bus);
        }

        // ---------------------------------------------------------------------------------------//
        public static final DeferredRegister.Items zItemHanded = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister.Items zItem = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister.Items zItemTinted = DeferredRegister.createItems(Main.ID);
        // DONT USE IT , ONLY FUNCTIONAL
        public static final DeferredRegister.Items zBucketItem = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister.Items zBlockItem = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister.Items zCoals = DeferredRegister.createItems(Main.ID);
        // ---------------------------------------------------------------------------------------//

        //TODO FUELS
        // public static final DeferredHolder<Item, ?> BIO_FUEL =
        // Material.DireStuff.FuelItemDW(Constants.Fuel.BIOFUEL,
        // 3);

        // public static final DeferredHolder<Item, ?> REDSTONE_FUEL =
        // Material.DireStuff.FuelItemDW(
        // Constants.Fuel.REDSTONE,
        // 15);

        // public static final DeferredHolder<Item, ?> LAPIS_LAZULI_FUEL =
        // Material.DireStuff.FuelItemDW(
        // Constants.Fuel.LAPIS_LAZULI,
        // 5);

        // ---------------------------------------------------------------------------------------//

        public static final DeferredHolder<Item, ?> SWAP_STAFF =
        zItemHanded.register(Constants.Items.Swapper,()-> new SwapperWand());

        public static final DeferredHolder<Item, ?> PICKER_STAFF =
        zItemHanded.register(Constants.Items.Picker,()-> new PickerWand());

        public static void registerLists() {

        }

}
