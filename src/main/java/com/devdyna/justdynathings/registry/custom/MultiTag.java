package com.devdyna.justdynathings.registry.custom;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.registry.Material;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class MultiTag {

    private TagKey<Item> item;
    private TagKey<Block> block;

    public MultiTag(String modname, String name) {
        this.block = Material.tagBlock(modname, name);
        this.item = Material.tagItem(modname, name);
    }

    public MultiTag(String name) {
        this(ID, name);
    }

    public TagKey<Item> item() {
        return item;
    }

    public TagKey<Block> block() {
        return block;
    }

}
