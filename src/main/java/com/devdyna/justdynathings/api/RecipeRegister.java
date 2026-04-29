package com.devdyna.justdynathings.api;

import java.util.function.Supplier;

import com.devdyna.justdynathings.init.types.zRecipeTypes;

import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Utility class to create recipes and recipe serializers at once
 */
public class RecipeRegister<T extends Recipe<?>> {

    private final String id;
    private final Supplier<? extends RecipeSerializer<T>> serializer;
    private final Supplier<? extends RecipeType<T>> type;

    private DeferredRegister<RecipeSerializer<?>> SERIALIZER_TYPE;
    private DeferredRegister<RecipeType<?>> RECIPE_TYPE;

    public RecipeRegister(String id,
            Supplier<? extends RecipeSerializer<T>> serializer,
            Supplier<? extends RecipeType<T>> type,
            DeferredRegister<RecipeSerializer<?>> serializer_type,
            DeferredRegister<RecipeType<?>> recipetype_type) {
        this.id = id;
        this.SERIALIZER_TYPE = serializer_type;
        this.RECIPE_TYPE = recipetype_type;
        this.serializer = SERIALIZER_TYPE.register(id, serializer);
        this.type = RECIPE_TYPE.register(id, type);

    }

    public RecipeRegister(String id,
            Supplier<? extends RecipeSerializer<T>> serializer,
            Supplier<? extends RecipeType<T>> type) {
        this(id, serializer, type, zRecipeTypes.SERIALIZERS, zRecipeTypes.TYPES);
    }

    public String getId() {
        return id;
    }

    public RecipeSerializer<T> getSerializer() {
        return serializer.get();
    }

    public RecipeType<T> getType() {
        return type.get();
    }

    public static <T extends Recipe<?>> RecipeRegister<T> of(String id,
            Supplier<? extends RecipeSerializer<T>> serializer, DeferredRegister<RecipeSerializer<?>> serializer_type,
            DeferredRegister<RecipeType<?>> recipetype_type) {
        return new RecipeRegister<>(id, serializer, () -> new RecipeType<T>() {
            @Override
            public String toString() {
                return id;
            }
        }, serializer_type, recipetype_type);
    }

    public static <T extends Recipe<?>> RecipeRegister<T> of(String id,
            Supplier<? extends RecipeSerializer<T>> serializer) {
        return new RecipeRegister<>(id, serializer, () -> new RecipeType<T>() {
            @Override
            public String toString() {
                return id;
            }
        });
    }

}
