package com.devdyna.justdynathings.config;

import java.util.List;

import com.devdyna.justdynathings.utils.DataGenUtil;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

// public class startup {
//     private static final ModConfigSpec.Builder qSTARTUP = new ModConfigSpec.Builder();

//     public static ModConfigSpec.ConfigValue<List<? extends String>> ITEMS;

//     public static void register(ModContainer c) {
//         regStartup();
//         c.registerConfig(ModConfig.Type.STARTUP, qSTARTUP.build());
//     }

//     private static void regStartup() {

//         ITEMS = qSTARTUP
//                 .comment("List of all generated Raw ores")
//                 .defineListAllowEmpty("items", List.of(DataGenUtil.getName(Blocks.DIAMOND_ORE)), () -> "",
//                         startup::checkItem);
//     }

//     private static boolean checkItem(final Object obj) {
//         return obj instanceof String name && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(name));
//     }

// }
