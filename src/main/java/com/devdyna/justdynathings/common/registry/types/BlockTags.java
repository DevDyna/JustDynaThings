package com.devdyna.justdynathings.common.registry.types;

import com.devdyna.justdynathings.common.registry.Material;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;

public class BlockTags {
    public static void register(IEventBus bus) {

    }

    public static final TagKey<Block> REFORGER_REPLACE = Material.tagBlock("reforger_replace");

    public static final TagKey<Block> REFORGER_RESULT = Material.tagBlock("reforger_result");

    public static final TagKey<Block> REVITALIZER_GOO = Material.tagBlock("revitalizer_goo");

    public static final TagKey<Block> TICKER_DENY = Material.tagBlock("ticker_deny");

}