package com.devdyna.justdynathings.recipetypes.input;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.common.crafting.BlockTagIngredient;

public record BlockTagItemInput(BlockTagIngredient block,ItemStack input) implements RecipeInput {

    @Override
    public ItemStack getItem(int i) {
        return input;
    }

    @Override
    public int size() {
        return 1;
    }

}