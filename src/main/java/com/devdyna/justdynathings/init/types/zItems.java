package com.devdyna.justdynathings.init.types;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import java.util.ArrayList;
import java.util.Arrays;

import com.devdyna.justdynathings.Constants;

import com.devdyna.justdynathings.init.builder.*;
import com.devdyna.justdynathings.init.builder.light_wands.*;
import com.direwolf20.justdirethings.setup.JDTRegistration;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zItems {
        public static void register(IEventBus bus) {
                zItem.register(bus);
                zBlockItem.register(bus);
                zWands.register(bus);
                zGooUpgraders.register(bus);
                zSpecial.register(bus);
        }

        //
        public static final DeferredRegister.Items zItem = DeferredRegister.createItems(MODULE_ID);
        public static final DeferredRegister.Items zSpecial = DeferredRegister.createItems(MODULE_ID);
        public static final DeferredRegister.Items zWands = DeferredRegister.createItems(MODULE_ID);
        public static final DeferredRegister.Items zGooUpgraders = DeferredRegister.createItems(MODULE_ID);
        public static final DeferredRegister.Items zBlockItem = DeferredRegister.createItems(MODULE_ID);

        // ---------------------------------------------------------------------------------------//

        public static final DeferredHolder<Item, ?> SWAP_STAFF = zWands.registerItem(Constants.Wands.Swapper,
                        p -> new SwapperWand(p));

        public static final DeferredHolder<Item, ?> PICKER_STAFF = zWands.registerItem(Constants.Wands.Picker,
                        p -> new PickerWand(p));

        public static final DeferredHolder<Item, ?> GOO_UPGRADER_T1 = zGooUpgraders.registerItem(
                        Constants.GooUpgraders.T1,
                        p -> new GooUpgrader(p,
                                        new ArrayList<>(Arrays.asList(JDTRegistration.GooBlock_Tier1.get(),
                                                        zBlocks.T1_GOO.get())),
                                        new ArrayList<>(Arrays.asList(JDTRegistration.GooBlock_Tier2.get(),
                                                        zBlocks.T2_GOO.get())),
                                        false));

        public static final DeferredHolder<Item, ?> GOO_UPGRADER_T2 = zGooUpgraders.registerItem(
                        Constants.GooUpgraders.T2,
                        p -> new GooUpgrader(p,
                                        new ArrayList<>(Arrays.asList(JDTRegistration.GooBlock_Tier2.get(),
                                                        zBlocks.T2_GOO.get())),
                                        new ArrayList<>(Arrays.asList(JDTRegistration.GooBlock_Tier3.get(),
                                                        zBlocks.T3_GOO.get())),
                                        false

                        ));

        public static final DeferredHolder<Item, ?> GOO_UPGRADER_T3 = zGooUpgraders.registerItem(
                        Constants.GooUpgraders.T3,
                        p -> new GooUpgrader(p,
                                        new ArrayList<>(Arrays.asList(JDTRegistration.GooBlock_Tier3.get(),
                                                        zBlocks.T3_GOO.get())),
                                        new ArrayList<>(Arrays.asList(JDTRegistration.GooBlock_Tier4.get(),
                                                        zBlocks.T4_GOO.get())),
                                        false

                        ));

        public static final DeferredHolder<Item, ?> ADVANCED_TIME_WAND = zWands.registerItem(
                        Constants.Wands.AdvancedTime,
                        p -> new AdvancedTimeWand(p));

        public static final DeferredHolder<Item, ?> STUPEFY_WAND = zWands.registerItem(Constants.Wands.Stupefy,
                        p -> new StupefyWand(p));

        public static final DeferredHolder<Item, ?> LIGHT_WAND = zWands.registerItem(Constants.Wands.Light,
                        p -> new LightWandItem(p));

        public static final DeferredHolder<Item, ?> ADVANCED_LIGHT_WAND = zWands.registerItem(
                        Constants.Wands.AdvancedLight,
                        p -> new AdvancedLightWand(p));

        public static final DeferredHolder<Item, ?> ABSTRACT_PARADOX = zWands.registerSimpleItem("abstract_paradox");

        public static final DeferredHolder<Item, ?> DESTRUCTION_WAND = zWands.registerSimpleItem("destruction_wand");

}
