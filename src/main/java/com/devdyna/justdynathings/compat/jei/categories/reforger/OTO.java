package com.devdyna.justdynathings.compat.jei.categories.reforger;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.recipetypes.type.*;
import com.devdyna.justdynathings.registry.types.zRecipeTypes;
import com.devdyna.justdynathings.utils.DataGenUtil;

import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;

public class OTO extends BaseReforgerCategory<ReforgerOTORecipe> {

    public static final RecipeType<RecipeHolder<ReforgerOTORecipe>> TYPE = 
    RecipeType.createFromVanilla(zRecipeTypes.REFORGER_OTO.getType());

    public OTO(IGuiHelper helper) {
        super(helper);
    }

    @Override
    public RecipeType<RecipeHolder<ReforgerOTORecipe>> getRecipeType() {
        return TYPE;
    }

    @Override
    public String getTitleKey() {
        return Constants.DataMaps.Reforger.block_to_block;
    }

    @Override
    public void setInput(IRecipeSlotBuilder slot, ReforgerOTORecipe recipe) {
        slot.addIngredients(Ingredient.of(recipe.getInputState().getBlock().asItem()));
    }

    @Override
    public void setCatalyst(IRecipeSlotBuilder slot, ReforgerOTORecipe recipe) {
        slot.addIngredients(recipe.getCatalyst());
    }

    @Override
    public void setOutput(IRecipeSlotBuilder slot, ReforgerOTORecipe recipe) {
        slot.addIngredients(Ingredient.of(recipe.getOutputState().getBlock().asItem()));
    }

    @Override
    public int setChance(ReforgerOTORecipe recipe) {
        return recipe.getChanceToUse();
    }

    @Override
    public @Nullable ResourceLocation getRegistryName(
            RecipeHolder<ReforgerOTORecipe> recipe) {
        return DataGenUtil.getResource(recipe.value().getOutputState().getBlock().getDescriptionId());
    }

}
