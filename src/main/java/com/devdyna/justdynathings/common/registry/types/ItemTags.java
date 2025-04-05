package com.devdyna.justdynathings.common.registry.types;

import com.devdyna.justdynathings.common.registry.Material;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;

public class ItemTags {
    public static void register(IEventBus bus) {

    }

    public static final TagKey<Item> GOO_REVIVE_TIER_0 = Material.tagItem("goo_revive_tier_0");

    public static final TagKey<Item> GOO_REVIVE_TIER_5 = Material.tagItem("goo_revive_tier_5");

    public static final TagKey<Item> REFORGER_CATALYST = Material.tagItem("reforger_catalyst");

    public static final TagKey<Item> FLAWED_REVITALIZER = Material.tagItem("flawed_revitalizer");

    public static final TagKey<Item> BLAZINGANVIL_DENY = Material.tagItem("deny_repair");

    public static final TagKey<Item> CREATIVE_GOO_WRENCHES = Material.tagItem("creativegoo_wrenches");

}
