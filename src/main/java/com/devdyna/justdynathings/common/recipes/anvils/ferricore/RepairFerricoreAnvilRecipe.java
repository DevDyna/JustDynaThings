package com.devdyna.justdynathings.common.recipes.anvils.ferricore;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.api.inputs.ItemFuelInput;
import com.devdyna.justdynathings.api.repair_anvils.BaseAnvilRecipe;
import com.devdyna.justdynathings.init.types.zBlocks;
import com.devdyna.justdynathings.init.types.zRecipeTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

@SuppressWarnings("null")
public class RepairFerricoreAnvilRecipe extends BaseAnvilRecipe<ItemFuelInput> {

    private final Ingredient input;

    public RepairFerricoreAnvilRecipe(Ingredient input, int durability) {
        super(durability);
        this.input = input;
    }

    public static RepairFerricoreAnvilRecipe of(Ingredient input, int durability) {
        return new RepairFerricoreAnvilRecipe(input, durability);
    }

    public boolean matches(ItemFuelInput r, Level l) {
        return this.input.test(r.input());
    }

    @Deprecated
    @Override
    public ItemStack assemble(ItemFuelInput r) {
        return ItemStack.EMPTY;
    }

    public Ingredient getInput() {
        return input;
    }

    @Override
    public RecipeType<? extends Recipe<ItemFuelInput>> getType() {
        return zRecipeTypes.FERRICORE_ANVIL.getType();
    }

    @Override
    public RecipeSerializer<? extends Recipe<ItemFuelInput>> getSerializer() {
        return zRecipeTypes.FERRICORE_ANVIL.getSerializer();
    }

    @Override
    public String group() {
        return Constants.Anvils.t1;
    }

    @Override
    public Item getToastIcon() {
        return zBlocks.FERRICORE_ANVIL.get().asItem();
    }

    public static final RecipeSerializer<RepairFerricoreAnvilRecipe> serializer() {
        return new RecipeSerializer<>(CODEC, STREAM_CODEC);
    }

    public static final MapCodec<RepairFerricoreAnvilRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
            Ingredient.CODEC.fieldOf("ingredient").forGetter(RepairFerricoreAnvilRecipe::getInput),
            Codec.intRange(1, Integer.MAX_VALUE).fieldOf("durability")
                    .forGetter(RepairFerricoreAnvilRecipe::getDurability))
            .apply(inst, RepairFerricoreAnvilRecipe::new));

    public static final StreamCodec<RegistryFriendlyByteBuf, RepairFerricoreAnvilRecipe> STREAM_CODEC = StreamCodec
            .composite(
                    Ingredient.CONTENTS_STREAM_CODEC, RepairFerricoreAnvilRecipe::getInput,
                    ByteBufCodecs.INT, RepairFerricoreAnvilRecipe::getDurability,
                    RepairFerricoreAnvilRecipe::new);

}