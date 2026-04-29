package com.devdyna.justdynathings.api;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public interface BlockTipped {
    abstract String execute(ItemStack i, List<Component> t);
}
