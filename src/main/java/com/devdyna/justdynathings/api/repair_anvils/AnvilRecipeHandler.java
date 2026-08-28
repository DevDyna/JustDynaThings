package com.devdyna.justdynathings.api.repair_anvils;

import java.util.Optional;

import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;

public interface AnvilRecipeHandler<T extends BaseAnvilRecipe<? extends RecipeInput>> {

    default void processRecipe() {
        Optional<RecipeHolder<T>> r = getRecipe();

        if (r.isEmpty())
            return;

        onRecipeValid(r.get().value());
    }

    Optional<RecipeHolder<T>> getRecipe();

    void onRecipeValid(T r);
}