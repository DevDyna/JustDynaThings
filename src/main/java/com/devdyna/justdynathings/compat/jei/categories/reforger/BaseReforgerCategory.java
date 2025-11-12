package com.devdyna.justdynathings.compat.jei.categories.reforger;

import com.devdyna.justdynathings.compat.jei.utils.BaseRecipeCategory;
import com.devdyna.justdynathings.compat.jei.utils.Size;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.utils.LogUtil;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public abstract class BaseReforgerCategory<T> extends BaseRecipeCategory<T> {

        public BaseReforgerCategory(IGuiHelper helper) {
                super(helper);
        }

        public abstract String getTitleKey();

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

        public abstract void setInput(IRecipeSlotBuilder slot, T recipe);

        public abstract void setCatalyst(IRecipeSlotBuilder slot, T recipe);

        public abstract void setOutput(IRecipeSlotBuilder slot, T recipe);

        public abstract int setChance(T recipe);

        @Override
        public void setRecipe(IRecipeLayoutBuilder b, T recipe, IFocusGroup focuses) {
                try {
                        setInput(b.addSlot(RecipeIngredientRole.INPUT, 4, 4), recipe);
                } catch (Exception e) {
                        LogUtil.error(e.getLocalizedMessage());
                }
                try {
                        setCatalyst(b.addSlot(RecipeIngredientRole.CATALYST, 41, 4), recipe);
                } catch (Exception e) {
                        LogUtil.error(e.getLocalizedMessage());
                }
                try {
                        setOutput(b.addSlot(RecipeIngredientRole.OUTPUT, 107, 4), recipe);
                } catch (Exception e) {
                        LogUtil.error(e.getLocalizedMessage());
                }

        }

        @Override
        public void draw(T recipe, IRecipeSlotsView recipeSlotsView,
                        GuiGraphics guiGraphics,
                        double mouseX,
                        double mouseY) {
                super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
                guiGraphics.drawString(Minecraft.getInstance().font,
                                (setChance(recipe) < 10 ? " " : "")
                                                + (setChance(recipe) < 100 ? " " : "")
                                                + setChance(recipe) + "%",
                                61, 8, 0x444444, false);
        }
}
