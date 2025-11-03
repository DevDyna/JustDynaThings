package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.registry.Material;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;

public class zBlockTags {
    public static void register(IEventBus bus) {

    }


    public static final TagKey<Block> STABILIZER_BELOW = Material.tagBlock("stabilizer_below");

    public static final TagKey<Block> PICKER_DENY = Material.tagBlock("picker_deny");
    public static final TagKey<Block> SWAPPER_DENY = Material.tagBlock("swapper_deny");

    public static final TagKey<Block> COAL_BLOCKS = Material.tagBlock("storage_blocks/unified_coals");

    public static final TagKey<Block> T2_SPREAD = Material.tagBlock("t2_spread");
    public static final TagKey<Block> T3_SPREAD = Material.tagBlock("t3_spread");
    public static final TagKey<Block> T4_SPREAD = Material.tagBlock("t4_spread");

    public static final TagKey<Block> T1_GOO_TYPE = Material.tagBlock("t1_goo_type");
    public static final TagKey<Block> T2_GOO_TYPE = Material.tagBlock("t2_goo_type");
    public static final TagKey<Block> T3_GOO_TYPE = Material.tagBlock("t3_goo_type");
    public static final TagKey<Block> T4_GOO_TYPE = Material.tagBlock("t4_goo_type");

    public static final TagKey<Block> ADVANCED_TIME_DENY = Material.tagBlock("advanced_time_deny");


}