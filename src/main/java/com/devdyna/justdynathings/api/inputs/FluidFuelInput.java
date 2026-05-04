package com.devdyna.justdynathings.api.inputs;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.neoforged.neoforge.fluids.FluidStack;

public record FluidFuelInput(FluidStack input) implements RecipeInput{

    @Override
    public ItemStack getItem(int arg0) {
        return input.getFluidType().getBucket(input);
    }

    @Override
    public int size() {
        return 1;
    }
    
}
