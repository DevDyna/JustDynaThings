package com.devdyna.justdynathings.recipetypes.serializer;

import com.devdyna.justdynathings.recipetypes.type.ReforgerOTMRecipe;
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

public class ReforgerOTMRecipeSerializer implements RecipeSerializer<ReforgerOTMRecipe> {

    public static final MapCodec<ReforgerOTMRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            BlockState.CODEC.fieldOf("input").forGetter(ReforgerOTMRecipe::getInputState),
            Ingredient.CODEC.fieldOf("catalyst").forGetter(ReforgerOTMRecipe::getCatalyst),
            Codec.intRange(0, 100).fieldOf("chanceToUse").forGetter(ReforgerOTMRecipe::getChanceToUse),
            BlockTagIngredient.CODEC.fieldOf("output").forGetter(ReforgerOTMRecipe::getOutputState))

            .apply(inst, ReforgerOTMRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, ReforgerOTMRecipe> STREAM_CODEC = StreamCodec.of(
            ReforgerOTMRecipeSerializer::toNetwork, ReforgerOTMRecipeSerializer::fromNetwork);

    public static ReforgerOTMRecipe fromNetwork(RegistryFriendlyByteBuf buf) {
        BlockTagIngredient outputState = new BlockTagIngredient(
                TagKey.create(Registries.BLOCK, buf.readResourceLocation()));
        Ingredient catalyst = Ingredient.CONTENTS_STREAM_CODEC.decode(buf);
        BlockState inputState = Block.stateById(buf.readInt());
        int chanceToUse = buf.readInt();
        return new ReforgerOTMRecipe(inputState, catalyst, chanceToUse, outputState);
    }

    public static void toNetwork(RegistryFriendlyByteBuf buf, ReforgerOTMRecipe recipe) {
        buf.writeResourceLocation(recipe.getOutputState().getTag().location());
        Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.getCatalyst());
        buf.writeInt(Block.getId(recipe.getInputState()));
        buf.writeInt(recipe.getChanceToUse());
    }

    @Override
    public MapCodec<ReforgerOTMRecipe> codec() {
        return CODEC;
    }

    @Override
    public StreamCodec<RegistryFriendlyByteBuf, ReforgerOTMRecipe> streamCodec() {
        return STREAM_CODEC;
    }

}
