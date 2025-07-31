package com.devdyna.justdynathings.utils;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class ItemUtil {

    public static List<ItemStack> blocksToItems(TagKey<Block> blocks) {
        ArrayList<ItemStack> items = new ArrayList<>();
        var holder = BuiltInRegistries.BLOCK.getOrCreateTag(blocks).stream().toList();

        for (Holder<Block> h : holder) {
            items.add(new ItemStack(h.value()));
        }
        return items;
    }

}
