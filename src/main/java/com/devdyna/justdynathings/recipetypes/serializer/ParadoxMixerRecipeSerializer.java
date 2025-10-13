package com.devdyna.justdynathings.recipetypes.serializer;

import com.devdyna.justdynathings.recipetypes.type.ParadoxMixerRecipe;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.fluids.FluidStack;

public class ParadoxMixerRecipeSerializer implements RecipeSerializer<ParadoxMixerRecipe> {

    public static final MapCodec<ParadoxMixerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            FluidStack.CODEC.fieldOf("input").forGetter(ParadoxMixerRecipe::getInput),
            Ingredient.CODEC.fieldOf("catalyst").forGetter(ParadoxMixerRecipe::getCatalyst),
            FluidStack.CODEC.fieldOf("output").forGetter(ParadoxMixerRecipe::getOutput))

            .apply(inst, ParadoxMixerRecipe::new));

   public static final StreamCodec<RegistryFriendlyByteBuf, ParadoxMixerRecipe> STREAM_CODEC = StreamCodec.composite(
            FluidStack.STREAM_CODEC, ParadoxMixerRecipe::getInput,
            Ingredient.CONTENTS_STREAM_CODEC, ParadoxMixerRecipe::getCatalyst,
            FluidStack.STREAM_CODEC, ParadoxMixerRecipe::getOutput,
            ParadoxMixerRecipe::new);

    @Override
    public MapCodec<ParadoxMixerRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, ParadoxMixerRecipe> streamCodec() {
        return STREAM_CODEC;
    }


}
