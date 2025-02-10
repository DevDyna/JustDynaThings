package com.devdyna.justdynathings.utils;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.common.Material;
import com.devdyna.justdynathings.common.core.BlockBase;
import com.devdyna.justdynathings.common.core.ItemBase;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

public class RegUtil {

    public static TagKey<Item> tagItem(String name) {
        return TagKey.create(BuiltInRegistries.ITEM.key(),
                ResourceLocation.fromNamespaceAndPath(Main.ID, name));
    }

    public static TagKey<Block> tagBlock(String name) {
        return TagKey.create(BuiltInRegistries.BLOCK.key(),
                ResourceLocation.fromNamespaceAndPath(Main.ID, name));
    }

    public static DeferredHolder<Item, ?> ezItem(String name) {
        return Material.zITM.register(name,
                ItemBase::new);
    }

    public static DeferredHolder<Block, ?> ezBlock(String name) {
        return Material.zBLK.register(name,
                BlockBase::new);
    }


    public static DeferredHolder<Block, ?> ezBlockItem(String name) {
        ezItem(name);
        return Material.zBLK.register(name,
                BlockBase::new);
    }
}
