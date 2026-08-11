package com.devdyna.justdynathings.compat.jei.categories;

import com.devdyna.justdynathings.compat.jei.utils.BaseRecipeCategory;
import com.devdyna.justdynathings.recipetypes.BlockOrTag;
import com.devdyna.justdynathings.registry.builders.reforger.ReforgerRecipe;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zRecipeTypes;
import com.devdyna.justdynathings.utils.Size;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.RecipeIngredientRole;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class ReforgerCategory extends BaseRecipeCategory<RecipeHolder<ReforgerRecipe>> {

        public static final RecipeType<RecipeHolder<ReforgerRecipe>> TYPE = RecipeType.createFromVanilla(
                        zRecipeTypes.REFORGER.getType());

        public ReforgerCategory(IGuiHelper helper) {
                super(helper);
        }

        @Override
        public RecipeType<RecipeHolder<ReforgerRecipe>> getRecipeType() {
                return TYPE;
        }

        @Override
        public String getTitleKey() {
                return "reforger_conversion";
        }

        @Override
        public ItemLike getIconItem() {
                return zBlocks.REFORGER.get();
        }

        @Override
        public Size setXY() {
                return Size.of(127, 24);
        }

        @Override
        public String setBackGround() {
                return "textures/gui/reforger.png";
        }

        @Override
        public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<ReforgerRecipe> recipeHolder,
                        IFocusGroup focuses) {

                var recipe = recipeHolder.value();

                setBlockOrTag(builder.addInputSlot(4, 4), recipe.getInput());

                builder.addSlot(RecipeIngredientRole.CATALYST, 41, 4).addIngredients(recipe.getCatalyst());

                setBlockOrTag(builder.addOutputSlot(107, 4), recipe.getOutput());

        }

        private void setBlockOrTag(IRecipeSlotBuilder slot, BlockOrTag value) {
                switch (value) {
                        case BlockOrTag.block b -> {
                                ItemStack stack = new ItemStack(b.block());
                                if (!stack.isEmpty())
                                        slot.addItemStack(stack);
                        }
                        case BlockOrTag.tag t -> {
                                var level = Minecraft.getInstance().level;
                                if (level == null)
                                        return;
                                var ingredient = t.getAsIngredient(level);
                                if (!ingredient.isEmpty())
                                        slot.addIngredients(ingredient);
                        }
                }
        }

        @Override
        public void draw(RecipeHolder<ReforgerRecipe> recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics,
                        double mouseX, double mouseY) {

                super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);

                int chance = recipe.value().getChanceToUse();

                guiGraphics.drawString(Minecraft.getInstance().font,
                                (chance < 10 ? " " : "") + (chance < 100 ? " " : "") + chance + "%", 61, 8, 0x444444,
                                false);
        }

}