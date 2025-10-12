package com.devdyna.justdynathings.recipetypes.serializer;

import com.devdyna.justdynathings.recipetypes.type.FluidTankRecipe;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.fluids.FluidStack;

public class FluidTankRecipeSerializer implements RecipeSerializer<FluidTankRecipe> {

    public static final MapCodec<FluidTankRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            FluidStack.CODEC.fieldOf("input").forGetter(FluidTankRecipe::getInput),
            Ingredient.CODEC.fieldOf("catalyst").forGetter(FluidTankRecipe::getCatalyst),
            FluidStack.CODEC.fieldOf("output").forGetter(FluidTankRecipe::getOutput))

            .apply(inst, FluidTankRecipe::new));

   public static final StreamCodec<RegistryFriendlyByteBuf, FluidTankRecipe> STREAM_CODEC = StreamCodec.composite(
            FluidStack.STREAM_CODEC, FluidTankRecipe::getInput,
            Ingredient.CONTENTS_STREAM_CODEC, FluidTankRecipe::getCatalyst,
            FluidStack.STREAM_CODEC, FluidTankRecipe::getOutput,
            FluidTankRecipe::new);

    @Override
    public MapCodec<FluidTankRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, FluidTankRecipe> streamCodec() {
        return STREAM_CODEC;
    }


}
