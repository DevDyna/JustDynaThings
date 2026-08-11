package com.devdyna.justdynathings.registry.builders.reforger;

import java.util.List;

import com.devdyna.justdynathings.recipetypes.BlockOrTag;
import com.devdyna.justdynathings.recipetypes.input.ReforgerRecipeInput;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zRecipeTypes;
import com.devdyna.justdynathings.utils.LevelUtil;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("null")
public class ReforgerRecipe implements Recipe<ReforgerRecipeInput> {

    private final BlockOrTag input;
    private final Ingredient catalyst;
    private final int chanceToUse;
    private final BlockOrTag output;

    public ReforgerRecipe(BlockOrTag input, Ingredient catalyst, int chanceToUse, BlockOrTag output) {
        this.input = input;
        this.catalyst = catalyst;
        this.chanceToUse = chanceToUse;
        this.output = output;
    }

    @Override
    public boolean matches(ReforgerRecipeInput input, Level level) {
        return this.input.test(input.block()) && catalyst.test(input.input());
    }

    @Override
    public ItemStack assemble(ReforgerRecipeInput input, HolderLookup.Provider registries) {
        return getResultItem(registries);
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return false;
    }

    @Override
    public RecipeType<?> getType() {
        return zRecipeTypes.REFORGER.getType();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(zBlocks.REFORGER.get());
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return zRecipeTypes.REFORGER.getSerializer();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.copyOf(List.of(catalyst));
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return switch (output) {
            case BlockOrTag.block block ->
                new ItemStack(block.block().asItem());

            case BlockOrTag.tag tag ->
                new ItemStack(
                        LevelUtil.ResourceByTag(
                                tag.tag(), 0));
        };
    }

    public BlockOrTag getInput() {
        return input;
    }

    public Ingredient getCatalyst() {
        return catalyst;
    }

    public int getChanceToUse() {
        return chanceToUse;
    }

    public BlockOrTag getOutput() {
        return output;
    }

    public BlockState getOutputState(Level level) {
        return switch (output) {

            case BlockOrTag.block block -> block.block().defaultBlockState();

            case BlockOrTag.tag tag -> {
                yield LevelUtil
                        .ResourceByTag(tag.tag(),
                                LevelUtil.getRandomValue(
                                        LevelUtil.getSizeTag(tag.tag()), level))
                        .defaultBlockState();
            }
        };
    }

}