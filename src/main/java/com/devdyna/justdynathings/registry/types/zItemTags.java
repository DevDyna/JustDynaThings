package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.registry.Material;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;

public class zItemTags {
        public static void register(IEventBus bus) {

        }

        public static final TagKey<Item> REFORGER_CATALYST = Material.tagItem("reforger_catalyst");
        public static final TagKey<Item> CREATIVE_GOO_WRENCHES = Material.tagItem(Constants.Goo.Creative + "_wrenches");

        public static final TagKey<Item> UNIVERSAL_WRENCH = Material.tagItem("universal_wrench");

        public static final TagKey<Item> FERRICORE_ANVIL_ALLOW = Material
                        .tagItem(Constants.AnvilType + "s/" + Constants.Tiers.ferricore + "/allow");
        public static final TagKey<Item> FERRICORE_ANVIL_REPAIR = Material
                        .tagItem(Constants.AnvilType + "s/" + Constants.Tiers.ferricore + "/catalyst");
        public static final TagKey<Item> BLAZEGOLD_ANVIL_DENY = Material
                        .tagItem(Constants.AnvilType + "s/" + Constants.Tiers.blazegold + "/deny");
        public static final TagKey<Item> CELESTIGEM_DENY = Material
                        .tagItem(Constants.AnvilType + "s/" + Constants.Tiers.celestigem + "/deny");
        public static final TagKey<Item> ECLIPSE_ALLOY_ANVIL_DENY = Material
                        .tagItem(Constants.AnvilType + "s/" + Constants.Tiers.eclipsealloy + "/deny");

        public static final TagKey<Item> TIME_BUDDING = Material.tagItem("time_buddings");
        public static final TagKey<Item> AE2_COMPAT = Material.tagItem("compat/ae2/buddings");
        public static final TagKey<Item> EXT_COMPAT = Material.tagItem("compat/extendedae/buddings");
        public static final TagKey<Item> PHA_COMPAT = Material.tagItem("compat/phasoritenetworks/buddings");

}
