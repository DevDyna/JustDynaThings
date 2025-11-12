package com.devdyna.justdynathings.recipetypes.input;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeInput;

public record ItemInput(Ingredient ingredient) implements RecipeInput {

    @Override
    public ItemStack getItem(int i) {
        return ingredient.getItems()[0];
    }

    @Override
    public int size() {
        return 1;
    }

}