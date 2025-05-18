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

        // TODO rename to match ids

        public static final TagKey<Item> FERRICORE_ANVIL_ALLOW = Material
                        .tagItem("anvils/" + Constants.TieredStuff.Anvils.t1 + "/allow");
        public static final TagKey<Item> FERRICORE_ANVIL_REPAIR = Material
                        .tagItem("anvils/" + Constants.TieredStuff.Anvils.t1 + "/catalyst");
        public static final TagKey<Item> BLAZING_ANVIL_DENY = Material
                        .tagItem("anvils/" + Constants.TieredStuff.Anvils.t2 + "/deny");
        public static final TagKey<Item> CELESTIGEM_DENY = Material
                        .tagItem("anvils/" + Constants.TieredStuff.Anvils.t3 + "/deny");
        public static final TagKey<Item> TIME_ANVIL_DENY = Material
                        .tagItem("anvils/" + Constants.TieredStuff.Anvils.t4 + "/deny");

        public static final TagKey<Item> TIME_BUDDING = Material.tagItem("time_buddings");
        public static final TagKey<Item> AE2_COMPAT = Material.tagItem("compat/ae2/buddings");
        public static final TagKey<Item> EXT_COMPAT = Material.tagItem("compat/extendedae/buddings");
        public static final TagKey<Item> PHA_COMPAT = Material.tagItem("compat/phasoritenetworks/buddings");

}
