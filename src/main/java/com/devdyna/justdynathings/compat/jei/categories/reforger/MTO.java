package com.devdyna.justdynathings.compat.jei.categories.reforger;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.recipetypes.type.*;
import com.devdyna.justdynathings.registry.types.zRecipeTypes;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;

public class MTO extends BaseReforgerCategory<ReforgerMTORecipe> {

    public static final RecipeType<RecipeHolder<ReforgerMTORecipe>> TYPE = 
    RecipeType.createFromVanilla(zRecipeTypes.REFORGER_MTO.getType());

    public MTO(IGuiHelper helper) {
        super(helper);
    }

    @Override
    public RecipeType<RecipeHolder<ReforgerMTORecipe>> getRecipeType() {
        return TYPE;
    }

    @Override
    public String getTitleKey() {
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
