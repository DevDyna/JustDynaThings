package com.devdyna.justdynathings.compat.jei.reforger;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.recipetypes.type.*;
import com.devdyna.justdynathings.utils.DataGenUtil;

import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.crafting.Ingredient;

public class MTO extends BaseReforgerCategory<ReforgerMTORecipe> {

    public static final RecipeType<ReforgerMTORecipe> TYPE = new RecipeType<>(
            DataGenUtil.getResource(Constants.DataMaps.Reforger.tag_to_block),
            ReforgerMTORecipe.class);

    public MTO(IGuiHelper helper) {
        super(helper);
    }

    @Override
    public RecipeType<ReforgerMTORecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public String setTitle() {
        return Constants.DataMaps.Reforger.tag_to_block;
    }

    @Override
    public void setInput(IRecipeSlotBuilder slot, ReforgerMTORecipe recipe) {
        slot.addItemStacks(recipe.getInputState().getItems().toList());
    }

    @Override
    public void setCatalyst(IRecipeSlotBuilder slot, ReforgerMTORecipe recipe) {
        slot.addIngredients(recipe.getCatalyst());
    }

    @Override
    public void setOutput(IRecipeSlotBuilder slot, ReforgerMTORecipe recipe) {
        slot.addIngredients(Ingredient.of(recipe.getOutputState().getBlock().asItem()));
    }

    @Override
    public int setChance(ReforgerMTORecipe recipe) {
        return recipe.getChanceToUse();
    }

}
