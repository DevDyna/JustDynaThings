package com.devdyna.justdynathings.recipetypes.serializer;

import com.devdyna.justdynathings.recipetypes.type.ReforgerMTORecipe;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.crafting.BlockTagIngredient;

public class ReforgerMTORecipeSerializer implements RecipeSerializer<ReforgerMTORecipe> {

    public static final MapCodec<ReforgerMTORecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            BlockTagIngredient.CODEC.fieldOf("input").forGetter(ReforgerMTORecipe::getInputState),
            Ingredient.CODEC.fieldOf("catalyst").forGetter(ReforgerMTORecipe::getCatalyst),
            Codec.intRange(0, 100).fieldOf("chanceToUse").forGetter(ReforgerMTORecipe::getChanceToUse),
            BlockState.CODEC.fieldOf("output").forGetter(ReforgerMTORecipe::getOutputState))

            .apply(inst, ReforgerMTORecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, ReforgerMTORecipe> STREAM_CODEC = StreamCodec.of(
            ReforgerMTORecipeSerializer::toNetwork, ReforgerMTORecipeSerializer::fromNetwork);

    public static ReforgerMTORecipe fromNetwork(RegistryFriendlyByteBuf buf) {
        BlockTagIngredient inputState = new BlockTagIngredient(
                TagKey.create(Registries.BLOCK, buf.readResourceLocation()));
        Ingredient catalyst = Ingredient.CONTENTS_STREAM_CODEC.decode(buf);
        BlockState outputState = Block.stateById(buf.readInt());
        int chanceToUse = buf.readInt();
        return new ReforgerMTORecipe(inputState, catalyst, chanceToUse, outputState);
    }

    public static void toNetwork(RegistryFriendlyByteBuf buf, ReforgerMTORecipe recipe) {
        buf.writeResourceLocation(recipe.getInputState().getTag().location());
        Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.getCatalyst());
        buf.writeInt(Block.getId(recipe.getOutputState()));
        buf.writeInt(recipe.getChanceToUse());
    }

    @Override
    public MapCodec<ReforgerMTORecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, ReforgerMTORecipe> streamCodec() {
        return STREAM_CODEC;
    }

}
