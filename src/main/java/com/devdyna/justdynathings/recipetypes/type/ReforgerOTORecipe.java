package com.devdyna.justdynathings.recipetypes.type;

import java.util.List;

import com.devdyna.justdynathings.recipetypes.input.BlockStateItemInput;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zRecipeTypes;

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
public class ReforgerOTORecipe implements Recipe<BlockStateItemInput> {

    private BlockState inputState;
    private Ingredient catalyst;
    private int chanceToUse;
    private BlockState outputState;

    public ReforgerOTORecipe(BlockState inputState, Ingredient catalyst, int chanceToUse, BlockState outputState) {
        this.inputState = inputState;
        this.catalyst = catalyst;
        this.chanceToUse = chanceToUse;
        this.outputState = outputState;
    }

    public boolean matches(BlockStateItemInput r, Level l) {
        return this.inputState.is(r.block().getBlock()) && this.catalyst.test(r.input());
    }

    public ItemStack assemble(BlockStateItemInput i, HolderLookup.Provider r) {
        return new ItemStack(this.outputState.getBlock().asItem());
    }

    public boolean canCraftInDimensions(int xz, int y) {
        return false;
    }

    public RecipeType<?> getType() {
        return zRecipeTypes.REFORGER_OTO.getType();
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(zBlocks.REFORGER.get());
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return zRecipeTypes.REFORGER_OTO.getSerializer();
    }

    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.copyOf(List.of(this.catalyst));
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registryAccess) {
        return new ItemStack(this.outputState.getBlock().asItem());
    }

public BlockState getInputState() {
    return inputState;
}

public BlockState getOutputState() {
    return outputState;
}

public int getChanceToUse() {
    return chanceToUse;
}

public Ingredient getCatalyst() {
    return catalyst;
}
}
