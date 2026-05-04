package com.devdyna.justdynathings.api.repair_anvils;

import java.util.Optional;

import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;

public interface AnvilRecipeHandler<T extends BaseAnvilRecipe<? extends RecipeInput>> {

    default void processRecipe() {
        Optional<RecipeHolder<T>> r = getRecipe();

        if (r.isEmpty())
            return;

        var recipe = r.get().value();

        setDurabilityBatch(recipe.getDurability());

        onRecipeValid(recipe);
    }

    public abstract Optional<RecipeHolder<T>> getRecipe();

    public abstract void onRecipeValid(T recipe);

    public abstract void setDurabilityBatch(int totalToRepair);

}
