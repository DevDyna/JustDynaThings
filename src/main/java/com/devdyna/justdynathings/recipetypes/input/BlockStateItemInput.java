package com.devdyna.justdynathings.recipetypes.input;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.block.state.BlockState;

public record BlockStateItemInput(BlockState block,ItemStack input) implements RecipeInput {

    @Override
    public ItemStack getItem(int i) {
        return input;
    }

    @Override
    public int size() {
        return 1;
    }

}