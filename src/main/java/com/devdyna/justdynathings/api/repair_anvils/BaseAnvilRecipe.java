package com.devdyna.justdynathings.api.repair_anvils;

import com.devdyna.cakesticklib.api.recipe.recipeType.BaseRecipeType;

import net.minecraft.world.item.crafting.RecipeInput;

public abstract class BaseAnvilRecipe<I extends RecipeInput> extends BaseRecipeType<I> {

    protected final int durability;

    public BaseAnvilRecipe(int durability) {
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

}
