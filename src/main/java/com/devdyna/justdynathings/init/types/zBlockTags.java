package com.devdyna.justdynathings.init.types;


import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.cakesticklib.api.RegistryUtils;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;

public class zBlockTags {
    public static void register(IEventBus bus) {

    }   
    
    public static final TagKey<Block> TICKER_DENY = RegistryUtils.tagBlock(MODULE_ID,"ticker_deny");

    @Deprecated
    public static final TagKey<Block> STABILIZER_BELOW = RegistryUtils.tagBlock(MODULE_ID,"stabilizer_below");

    public static final TagKey<Block> PICKER_DENY = RegistryUtils.tagBlock(MODULE_ID,"picker_deny");
    public static final TagKey<Block> SWAPPER_DENY = RegistryUtils.tagBlock(MODULE_ID,"swapper_deny");

    public static final TagKey<Block> COAL_BLOCKS = RegistryUtils.tagBlock(MODULE_ID,"storage_blocks/unified_coals");

    public static final TagKey<Block> T2_SPREAD = RegistryUtils.tagBlock(MODULE_ID,"t2_spread");
    public static final TagKey<Block> T3_SPREAD = RegistryUtils.tagBlock(MODULE_ID,"t3_spread");
    public static final TagKey<Block> T4_SPREAD = RegistryUtils.tagBlock(MODULE_ID,"t4_spread");

    public static final TagKey<Block> T1_GOO_TYPE = RegistryUtils.tagBlock(MODULE_ID,"t1_goo_type");
    public static final TagKey<Block> T2_GOO_TYPE = RegistryUtils.tagBlock(MODULE_ID,"t2_goo_type");
    public static final TagKey<Block> T3_GOO_TYPE = RegistryUtils.tagBlock(MODULE_ID,"t3_goo_type");
    public static final TagKey<Block> T4_GOO_TYPE = RegistryUtils.tagBlock(MODULE_ID,"t4_goo_type");

    public static final TagKey<Block> ADVANCED_TIME_DENY = RegistryUtils.tagBlock(MODULE_ID,"advanced_time_deny");


}