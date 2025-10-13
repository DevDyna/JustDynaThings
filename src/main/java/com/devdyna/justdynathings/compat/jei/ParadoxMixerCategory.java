package com.devdyna.justdynathings.compat.jei;

import static com.devdyna.justdynathings.Main.ID;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.recipetypes.type.ParadoxMixerRecipe;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.utils.DataGenUtil;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;

@SuppressWarnings("null")
public class ParadoxMixerCategory<T> implements IRecipeCategory<ParadoxMixerRecipe> {

        public static final RecipeType<ParadoxMixerRecipe> TYPE = new RecipeType<>(
                        DataGenUtil.getResource(Constants.Blocks.ParadoxMixer),
                        ParadoxMixerRecipe.class);

        @Override
        public RecipeType<ParadoxMixerRecipe> getRecipeType() {
                return TYPE;
        }

        private IGuiHelper helper;

        public ParadoxMixerCategory(IGuiHelper helper) {
                this.helper = helper;
        }

        @Override
        public Component getTitle() {
                return Component.translatable(ID + ".jei.category.paradox_mixer");
        }

        @Override
        public @Nullable IDrawable getIcon() {
                return helper.createDrawableItemLike(zBlocks.PARADOX_MIXER.get());
        }

        @Override
        public @Nullable IDrawable getBackground() {
                return helper.createDrawable(DataGenUtil.getResource("textures/gui/paradox_mixer.png"), 0, 0, 127,
                                24);
        }

        @Override
        public void setRecipe(IRecipeLayoutBuilder b, ParadoxMixerRecipe recipe, IFocusGroup focuses) {
                b.addInputSlot(4, 4).addFluidStack(recipe.getInput().getFluid());
                b.addSlot(RecipeIngredientRole.CATALYST, 57, 4).addIngredients(recipe.getCatalyst());
                b.addOutputSlot(107, 4).addFluidStack(recipe.getOutput().getFluid());
        }

}
