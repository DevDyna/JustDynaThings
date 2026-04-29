package com.devdyna.justdynathings.init.types;


import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.cakesticklib.api.RegistryUtils;
import com.devdyna.justdynathings.Constants;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;

public class zItemTags {
        public static void register(IEventBus bus) {
        }

        public static final TagKey<Item> CREATIVE_GOO_WRENCHES = RegistryUtils.tagItem(MODULE_ID,Constants.Goo.Creative + "_wrenches");

        public static final TagKey<Item> UNIVERSAL_WRENCH = RegistryUtils.tagItem(MODULE_ID,"universal_wrench");

        public static final TagKey<Item> FERRICORE_ANVIL_DENY = RegistryUtils
                        .tagItem(MODULE_ID,Constants.AnvilType + "s/" + Constants.Tiers.ferricore + "/deny");

        public static final TagKey<Item> BLAZEGOLD_ANVIL_DENY = RegistryUtils
                        .tagItem(MODULE_ID,Constants.AnvilType + "s/" + Constants.Tiers.blazegold + "/deny");

        public static final TagKey<Item> CELESTIGEM_DENY = RegistryUtils
                        .tagItem(MODULE_ID,Constants.AnvilType + "s/" + Constants.Tiers.celestigem + "/deny");

        public static final TagKey<Item> ECLIPSE_ALLOY_ANVIL_DENY = RegistryUtils
                        .tagItem(MODULE_ID,Constants.AnvilType + "s/" + Constants.Tiers.eclipsealloy + "/deny");

        public static final TagKey<Item> TIME_BUDDING = RegistryUtils.tagItem(MODULE_ID,"time_buddings");

        public static final TagKey<Item> AE2_COMPAT = RegistryUtils.tagItem(MODULE_ID,"compat/ae2/buddings");

        public static final TagKey<Item> EXT_COMPAT = RegistryUtils.tagItem(MODULE_ID,"compat/extendedae/buddings");

        public static final TagKey<Item> PHA_COMPAT = RegistryUtils.tagItem(MODULE_ID,"compat/phasoritenetworks/buddings");

        public static final TagKey<Item> COPPER_BULBS = RegistryUtils.tagItem("minecraft", "copper_bulbs");
        public static final TagKey<Item> AMETHYST_BLOCKS = RegistryUtils.tagItem("minecraft", "amethyst_blocks");

        public static final TagKey<Item> T2_SPREAD = RegistryUtils.tagItem(MODULE_ID,"t2_spread");
        public static final TagKey<Item> T3_SPREAD = RegistryUtils.tagItem(MODULE_ID,"t3_spread");
        public static final TagKey<Item> T4_SPREAD = RegistryUtils.tagItem(MODULE_ID,"t4_spread");

        public static final TagKey<Item> T1_GOO_TYPE = RegistryUtils.tagItem(MODULE_ID,"t1_goo_type");
        public static final TagKey<Item> T2_GOO_TYPE = RegistryUtils.tagItem(MODULE_ID,"t2_goo_type");
        public static final TagKey<Item> T3_GOO_TYPE = RegistryUtils.tagItem(MODULE_ID,"t3_goo_type");
        public static final TagKey<Item> T4_GOO_TYPE = RegistryUtils.tagItem(MODULE_ID,"t4_goo_type");

        public static final TagKey<Item> INTERACTIVE = RegistryUtils.tagItem(MODULE_ID,"interactive");
        
        public static final TagKey<Item> TIME_WANDS = RegistryUtils.tagItem(MODULE_ID,"time_wands");


}