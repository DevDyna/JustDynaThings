package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.registry.Material;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;

public class zItemTags {
    public static void register(IEventBus bus) {

    }

    // public static final TagKey<Item> GOO_REVIVE_TIER_0 =
    // Material.tagItem("goo_revive_tier_0");

    // public static final TagKey<Item> GOO_REVIVE_TIER_5 =
    // Material.tagItem("goo_revive_tier_5");

    public static final TagKey<Item> REFORGER_CATALYST = Material.tagItem("reforger_catalyst");
    // public static final TagKey<Item> FLAWED_REVITALIZER =
    // Material.tagItem("flawed_revitalizer");
    public static final TagKey<Item> CREATIVE_GOO_WRENCHES = Material.tagItem(Constants.Goo.Creative + "_wrenches");
    public static final TagKey<Item> FERRICORE_ANVIL_ALLOW = Material
            .tagItem("anvils/" + Constants.Anvil.metallic + "/allow");
    public static final TagKey<Item> FERRICORE_ANVIL_REPAIR = Material
            .tagItem("anvils/" + Constants.Anvil.metallic + "/catalyst");
    public static final TagKey<Item> BLAZING_ANVIL_DENY = Material
            .tagItem("anvils/" + Constants.Anvil.magmatic + "/deny");
    public static final TagKey<Item> CELESTIGEM_DENY = Material.tagItem("anvils/" + Constants.Anvil.powered + "/deny");
    public static final TagKey<Item> TIME_ANVIL_DENY = Material.tagItem("anvils/" + Constants.Anvil.time + "/deny");

    // public static final TagKey<Item> DUSTS_CHAOTIC =
    // Material.tagItem("c","dusts/chaotic");
    // public static final TagKey<Item> GEMS_REDSTONIC =
    // Material.tagItem("c","gems/redstonic");
    // public static final TagKey<Item> RAW_MATERIALS_COPRINIUM =
    // Material.tagItem("c","raw_materials/coprinium");
    // public static final TagKey<Item> INGOTS_COPRINIUM =
    // Material.tagItem("c","ingots/coprinium");

}
