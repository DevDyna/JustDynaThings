package com.devdyna.justdynathings.recipetypes;

import java.util.function.Supplier;

import com.devdyna.justdynathings.registry.types.zRecipeTypes;

import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredHolder;
/**
 * Utility class to create recipes and recipe serializers at once
 */
@SuppressWarnings("unused")
public class zRecipe<T extends Recipe<?>> {

    private final String id;
    private final Supplier<? extends RecipeSerializer<T>> finalserializer;
    private final Supplier<? extends RecipeType<T>> finaltype;

    public zRecipe(String id,
            Supplier<? extends RecipeSerializer<T>> serializer,
            Supplier<? extends RecipeType<T>> type) {
        this.id = id;
        this.finalserializer = zRecipeTypes.SERIALIZERS.register(id, serializer);
        this.finaltype = zRecipeTypes.TYPES.register(id, type);
    }

    public String getId() {
        return id;
    }

    public RecipeSerializer<T> getSerializer() {
        return finalserializer.get();
    }

    public RecipeType<T> getType() {
        return finaltype.get();
    }
}
