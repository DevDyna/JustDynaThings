package com.devdyna.justdynathings.compat.jei.reforger;

import static com.devdyna.justdynathings.Main.ID;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.utils.DataGenUtil;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

@SuppressWarnings("null")
public abstract class BaseReforgerCategory<T> implements IRecipeCategory<T> {

        private IGuiHelper helper;

        // public static final RecipeType<ReforgerOTORecipe> TYPE = new RecipeType<>(
        // DataGenUtil.getResource(Constants.DataMaps.Reforger.block_to_block),
        // ReforgerOTORecipe.class);

        public BaseReforgerCategory(IGuiHelper helper) {
                this.helper = helper;
        }

        // @Override
        // public RecipeType<T> getRecipeType() {
        // return TYPE;
        // }

        public abstract String setTitle();

        @Override
        public Component getTitle() {
                return Component.translatable(ID + ".jei.category."
                                + setTitle());
        }

        @Override
        public @Nullable IDrawable getIcon() {
                return helper.createDrawableItemLike(zBlocks.REFORGER.get());
        }

        @Override
        public @Nullable IDrawable getBackground() {
                return helper.createDrawable(DataGenUtil.getResource("textures/gui/reforger.png"), 0, 0, 160,
                                24);
        }

        public abstract void setInput(IRecipeSlotBuilder slot, T recipe);

        public abstract void setCatalyst(IRecipeSlotBuilder slot, T recipe);

        public abstract void setOutput(IRecipeSlotBuilder slot, T recipe);

        public abstract int setChance(T recipe);

        @Override
        public void setRecipe(IRecipeLayoutBuilder b, T recipe, IFocusGroup focuses) {
                setInput(b.addSlot(RecipeIngredientRole.INPUT, 4, 5), recipe);
                setCatalyst(b.addSlot(RecipeIngredientRole.CATALYST, 41, 5), recipe);
                setOutput(b.addSlot(RecipeIngredientRole.OUTPUT, 107, 5), recipe);
        }

        @Override
        public void draw(T recipe, IRecipeSlotsView recipeSlotsView,
                        GuiGraphics guiGraphics,
                        double mouseX,
                        double mouseY) {

                guiGraphics.drawString(Minecraft.getInstance().font,
                                (setChance(recipe) < 10 ? " " : "")
                                                + (setChance(recipe) < 100 ? " " : "")
                                                + setChance(recipe) + "%",
                                61, 9, 0x444444, false);
        }
}
