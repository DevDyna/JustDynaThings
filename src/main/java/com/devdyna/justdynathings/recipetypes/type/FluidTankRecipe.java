package com.devdyna.justdynathings.recipetypes.type;

import java.util.List;

import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zRecipeTypes;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.fluids.FluidStack;

@SuppressWarnings("null")
public class FluidTankRecipe implements Recipe<RecipeInput> {

    private FluidStack input;
    private Ingredient catalyst;
    private FluidStack output;

    public FluidTankRecipe(FluidStack input, Ingredient catalyst, FluidStack output) {
        this.input = input;
        this.catalyst = catalyst;
        this.output = output;
    }

    public boolean matches(RecipeInput r, Level l) {
        return false;
    }

    public ItemStack assemble(RecipeInput i, HolderLookup.Provider r) {
        return ItemStack.EMPTY;
    }

    public boolean canCraftInDimensions(int xz, int y) {
        return false;
    }

    public RecipeType<?> getType() {
        return zRecipeTypes.FLUID_TANK_RECIPES.getType();
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(zBlocks.FLUID_TANK.get());
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return zRecipeTypes.FLUID_TANK_RECIPES.getSerializer();
    }

    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.copyOf(List.of(this.catalyst));
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registryAccess) {
        return ItemStack.EMPTY;
    }

    public FluidStack getInput() {
        return input;
    }

    public FluidStack getOutput() {
        return output;
    }

    public Ingredient getCatalyst() {
        return catalyst;
    }

}
