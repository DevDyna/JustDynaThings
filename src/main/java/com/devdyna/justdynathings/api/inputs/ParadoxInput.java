package com.devdyna.justdynathings.api.inputs;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
@Deprecated
public record ParadoxInput(ItemStack input,int range) implements RecipeInput{

    @Override
    public ItemStack getItem(int arg0) {
        return input;
    }

    @Override
    public int size() {
        return 1;
    }
    
}
