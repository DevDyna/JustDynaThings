package com.devdyna.justdynathings.registry.builders._core.item;

import com.devdyna.justdynathings.registry.types.zProperties;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class ItemBlock extends BlockItem{

    public ItemBlock(Block block) {
        super(block, zProperties.iProp);
    }
    
}
