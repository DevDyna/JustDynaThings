package com.devdyna.justdynathings.recipetypes.serializer;

import com.devdyna.justdynathings.recipetypes.BetterThanBlockStates;
import com.devdyna.justdynathings.recipetypes.type.ReforgerOTORecipe;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.state.BlockState;

public class ReforgerOTORecipeSerializer implements RecipeSerializer<ReforgerOTORecipe> {

    public static final MapCodec<ReforgerOTORecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            BlockState.CODEC.fieldOf("input").forGetter(ReforgerOTORecipe::getInputState),
            Ingredient.CODEC.fieldOf("catalyst").forGetter(ReforgerOTORecipe::getCatalyst),
            Codec.intRange(0, 100).fieldOf("chanceToUse").forGetter(ReforgerOTORecipe::getChanceToUse),
            BlockState.CODEC.fieldOf("output").forGetter(ReforgerOTORecipe::getOutputState))

            .apply(inst, ReforgerOTORecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, ReforgerOTORecipe> STREAM_CODEC = StreamCodec.composite(
            BetterThanBlockStates.STREAM_CODEC, ReforgerOTORecipe::getInputState,
            Ingredient.CONTENTS_STREAM_CODEC, ReforgerOTORecipe::getCatalyst,
            ByteBufCodecs.INT, ReforgerOTORecipe::getChanceToUse,
            BetterThanBlockStates.STREAM_CODEC, ReforgerOTORecipe::getOutputState,
            ReforgerOTORecipe::new);

    @Override
    public MapCodec<ReforgerOTORecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, ReforgerOTORecipe> streamCodec() {
        return STREAM_CODEC;
    }

}
