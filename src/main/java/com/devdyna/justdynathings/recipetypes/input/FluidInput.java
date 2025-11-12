package com.devdyna.justdynathings.recipetypes.input;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;

public record FluidInput(FluidIngredient fluid) implements RecipeInput {

    @Override
    public ItemStack getItem(int i) {
        return new ItemStack(fluid.getStacks()[0].getFluid().getBucket());
    }

    @Override
    public int size() {
        return 1;
    }

}