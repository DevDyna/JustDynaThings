package com.devdyna.justdynathings.common.recipes.paradox;

import com.devdyna.cakesticklib.api.recipe.recipeType.BaseRecipeType;
import com.devdyna.justdynathings.api.inputs.ParadoxInput;
import com.devdyna.justdynathings.init.types.zItems;
import com.devdyna.justdynathings.init.types.zRecipeTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

@SuppressWarnings("null")
public class ParadoxInfusionRecipe extends BaseRecipeType<ParadoxInput> {

    private final int radius;
    private final Ingredient input;
    private final ItemStackTemplate output;

    public ParadoxInfusionRecipe(Ingredient input, int radius, ItemStackTemplate output) {
        this.input = input;
        this.radius = radius;
        this.output = output;
    }

    public static ParadoxInfusionRecipe of(Ingredient input, int radius, ItemStackTemplate output) {
        return new ParadoxInfusionRecipe(input, radius, output);
    }

    public boolean matches(ParadoxInput r, Level l) {
        return this.input.test(r.input()) && r.range() >= this.radius;
    }

    @Override
    public ItemStack assemble(ParadoxInput r) {
        return this.output.create();
    }

    public Ingredient getInput() {
        return input;
    }

    public int getRadius() {
        return radius;
    }

    public ItemStackTemplate getOutput() {
        return output;
    }

    @Override
    public RecipeType<? extends Recipe<ParadoxInput>> getType() {
        return zRecipeTypes.PARADOX_INFUSION.getType();
    }

    @Override
    public RecipeSerializer<? extends Recipe<ParadoxInput>> getSerializer() {
        return zRecipeTypes.PARADOX_INFUSION.getSerializer();
    }

    @Override
    public String group() {
        return "paradox_infusion";
    }

    @Override
    public Item getToastIcon() {
        return zItems.ABSTRACT_PARADOX.get();
    }

    public static final RecipeSerializer<ParadoxInfusionRecipe> serializer() {
        return new RecipeSerializer<>(CODEC, STREAM_CODEC);
    }

    public static final MapCodec<ParadoxInfusionRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("ingredient").forGetter(ParadoxInfusionRecipe::getInput),
            Codec.intRange(1, Integer.MAX_VALUE).fieldOf("radius").forGetter(ParadoxInfusionRecipe::getRadius),
            ItemStackTemplate.CODEC.fieldOf("output").forGetter(ParadoxInfusionRecipe::getOutput))
            .apply(inst, ParadoxInfusionRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, ParadoxInfusionRecipe> STREAM_CODEC = StreamCodec
            .composite(
                    Ingredient.CONTENTS_STREAM_CODEC, ParadoxInfusionRecipe::getInput,
                    ByteBufCodecs.INT, ParadoxInfusionRecipe::getRadius,
                    ItemStackTemplate.STREAM_CODEC, ParadoxInfusionRecipe::getOutput,
                    ParadoxInfusionRecipe::new);

}