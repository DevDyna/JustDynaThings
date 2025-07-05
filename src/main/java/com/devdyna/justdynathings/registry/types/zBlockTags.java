package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.registry.Material;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;

public class zBlockTags {
    public static void register(IEventBus bus) {

    }

    // public static final TagKey<Block> REFORGER_REPLACE = Material.tagBlock("reforger_replace");
    // public static final TagKey<Block> REFORGER_RESULT = Material.tagBlock("reforger_result");
    
    public static final TagKey<Block> REVITALIZER_GOO = Material.tagBlock("revitalizer_goo");

    public static final TagKey<Block> PICKER_DENY = Material.tagBlock("picker_deny");
    public static final TagKey<Block> SWAPPER_DENY = Material.tagBlock("swapper_deny");


        public static final TagKey<Block> COAL_BLOCKS = Material.tagBlock("coal_blocks");


}