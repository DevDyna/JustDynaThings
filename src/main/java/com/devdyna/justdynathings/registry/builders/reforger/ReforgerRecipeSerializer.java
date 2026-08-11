package com.devdyna.justdynathings.registry.builders.reforger;

import com.devdyna.justdynathings.recipetypes.BlockOrTag;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ReforgerRecipeSerializer implements RecipeSerializer<ReforgerRecipe> {

        public static final MapCodec<ReforgerRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                        BlockOrTag.CODEC
                                        .fieldOf("input")
                                        .forGetter(ReforgerRecipe::getInput),

                        Ingredient.CODEC
                                        .fieldOf("catalyst")
                                        .forGetter(ReforgerRecipe::getCatalyst),

                        Codec.intRange(0, 100)
                                        .fieldOf("chanceToUse")
                                        .forGetter(ReforgerRecipe::getChanceToUse),

                        BlockOrTag.CODEC
                                        .fieldOf("output")
                                        .forGetter(ReforgerRecipe::getOutput)

        ).apply(instance, ReforgerRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, ReforgerRecipe> STREAM_CODEC = StreamCodec.composite(

                        BlockOrTag.STREAM_CODEC,
                        ReforgerRecipe::getInput,

                        Ingredient.CONTENTS_STREAM_CODEC,
                        ReforgerRecipe::getCatalyst,

                        ByteBufCodecs.INT,
                        ReforgerRecipe::getChanceToUse,

                        BlockOrTag.STREAM_CODEC,
                        ReforgerRecipe::getOutput,

                        ReforgerRecipe::new);

        @Override
        public MapCodec<ReforgerRecipe> codec() {
                return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ReforgerRecipe> streamCodec() {
                return STREAM_CODEC;
        }
}