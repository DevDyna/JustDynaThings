package com.devdyna.justdynathings.registry.types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.builders.*;
import com.devdyna.justdynathings.registry.builders.lightwand.AdvancedLightWand;
import com.devdyna.justdynathings.registry.builders.lightwand.LightWandItem;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zItems {
        public static void register(IEventBus bus) {
                zItem.register(bus);
                zItemTinted.register(bus);
                zBucketItem.register(bus);
                zBlockItem.register(bus);
                zCoals.register(bus);
                zItemHanded.register(bus);
                zDisabled.register(bus);
                zGooUpgraders.register(bus);
                registerGuideMeDummyItems();
        }

        // TODO clean up some unused stuff
        // ---------------------------------------------------------------------------------------//
        public static final DeferredRegister.Items zItemHanded = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister.Items zItem = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister.Items zItemTinted = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister.Items zGooUpgraders = DeferredRegister.createItems(Main.ID);

        // DONT USE IT , ONLY FUNCTIONAL
        public static final DeferredRegister.Items zDisabled = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister.Items zBucketItem = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister.Items zBlockItem = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister.Items zCoals = DeferredRegister.createItems(Main.ID);
        // ---------------------------------------------------------------------------------------//

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

        public static final DeferredHolder<Item, ?> SWAP_STAFF = zItemHanded.register(Constants.Wands.Swapper,
                        () -> new SwapperWand());

        public static final DeferredHolder<Item, ?> PICKER_STAFF = zItemHanded.register(Constants.Wands.Picker,
                        () -> new PickerWand());

        public static final DeferredHolder<Item, ?> GOO_UPGRADER_T1 = zGooUpgraders.register(Constants.GooUpgraders.T1,
                        () -> new GooUpgrader(
                                        new ArrayList<>(Arrays.asList(Registration.GooBlock_Tier1.get(),
                                                        zBlocks.T1_GOO.get())),
                                        new ArrayList<>(Arrays.asList(Registration.GooBlock_Tier2.get(),
                                                        zBlocks.T2_GOO.get())),
                                        false));

        public static final DeferredHolder<Item, ?> GOO_UPGRADER_T2 = zGooUpgraders.register(Constants.GooUpgraders.T2,
                        () -> new GooUpgrader(
                                        new ArrayList<>(Arrays.asList(Registration.GooBlock_Tier2.get(),
                                                        zBlocks.T2_GOO.get())),
                                        new ArrayList<>(Arrays.asList(Registration.GooBlock_Tier3.get(),
                                                        zBlocks.T3_GOO.get())),
                                        false

                        ));

        public static final DeferredHolder<Item, ?> GOO_UPGRADER_T3 = zGooUpgraders.register(Constants.GooUpgraders.T3,
                        () -> new GooUpgrader(
                                        new ArrayList<>(Arrays.asList(Registration.GooBlock_Tier3.get(),
                                                        zBlocks.T3_GOO.get())),
                                        new ArrayList<>(Arrays.asList(Registration.GooBlock_Tier4.get(),
                                                        zBlocks.T4_GOO.get())),
                                        false

                        ));

        public static final DeferredHolder<Item, ?> GOO_UPGRADER_T4 = zGooUpgraders.register(Constants.GooUpgraders.T4,
                        () -> new GooUpgrader(
                                        new ArrayList<>(Arrays.asList(Registration.GooBlock_Tier4.get(),
                                                        zBlocks.T4_GOO.get())),
                                        new ArrayList<>(Arrays.asList(zBlocks.ENERGIZED_GOO.get())), true

                        ));

        public static final DeferredHolder<Item, ?> ADVANCED_TIME_WAND = zItemHanded.register(
                        Constants.Wands.AdvancedTime,
                        () -> new AdvancedTimeWand());

        public static final DeferredHolder<Item, ?> STUPEFY_WAND = zItemHanded.register(Constants.Wands.Stupefy,
                        () -> new StupefyWand());

        public static final DeferredHolder<Item, ?> LIGHT_WAND = zItemHanded.register(Constants.Wands.Light,
                        () -> new LightWandItem());

        public static final DeferredHolder<Item, ?> ADVANCED_LIGHT_WAND = zItemHanded.register(
                        Constants.Wands.AdvancedLight,
                        () -> new AdvancedLightWand());

        public static void registerGuideMeDummyItems() {

                List<String> list = new ArrayList<>();

                if (!Constants.ModAddonCheck.AppliedEnergistics2)
                        list.add("echoing_budding_certus");

                if (!Constants.ModAddonCheck.ExtendedAE)
                        list.add("echoing_budding_entro");

                if (!Constants.ModAddonCheck.PhasoriteNetworks)
                        list.add("echoing_budding_phasorite");

                if (!Constants.ModAddonCheck.GeOre)
                        list.addAll(List.of(
                                        "echoing_budding_allthemodium",
                                        "echoing_budding_aluminum",
                                        "echoing_budding_ancient_debris",
                                        "echoing_budding_black_quartz",
                                        "echoing_budding_coal",
                                        "echoing_budding_copper",
                                        "echoing_budding_diamond",
                                        "echoing_budding_emerald",
                                        "echoing_budding_gold",
                                        "echoing_budding_iron",
                                        "echoing_budding_lapis",
                                        "echoing_budding_lead",
                                        "echoing_budding_monazite",
                                        "echoing_budding_nickel",
                                        "echoing_budding_osmium",
                                        "echoing_budding_platinum",
                                        "echoing_budding_quartz",
                                        "echoing_budding_redstone",
                                        "echoing_budding_ruby",
                                        "echoing_budding_sapphire",
                                        "echoing_budding_silver",
                                        "echoing_budding_tin",
                                        "echoing_budding_topaz",
                                        "echoing_budding_tungsten",
                                        "echoing_budding_unobtainium",
                                        "echoing_budding_uraninite",
                                        "echoing_budding_uranium",
                                        "echoing_budding_vibranium",
                                        "echoing_budding_zinc"));

                if (!list.isEmpty())
                        list.forEach(i -> zDisabled.register(i, () -> new DisabledItem()));
        }

}
