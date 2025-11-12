package com.devdyna.justdynathings.compat.jei.categories;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.compat.jei.utils.BaseRecipeCategory;
import com.devdyna.justdynathings.recipetypes.type.ParadoxMixerRecipe;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.utils.DataGenUtil;
import com.devdyna.justdynathings.utils.Size;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class ParadoxMixerCategory<T> extends BaseRecipeCategory<ParadoxMixerRecipe> {

        public static final RecipeType<ParadoxMixerRecipe> TYPE = new RecipeType<>(
                        DataGenUtil.getResource(Constants.Blocks.ParadoxMixer),
                        ParadoxMixerRecipe.class);

        @Override
        public RecipeType<ParadoxMixerRecipe> getRecipeType() {
                return TYPE;
        }

        public ParadoxMixerCategory(IGuiHelper helper) {
                super(helper);
        }

        @Override
        public String getTitleKey() {
                return Constants.Blocks.ParadoxMixer;
        }

        @Override
        public ItemLike getIconItem() {
                return zBlocks.PARADOX_MIXER.get();
        }

        @Override
        public Size setXY() {
                return Size.of(127, 24);
        }

        @Override
        public String setBackGround() {
                return "textures/gui/paradox_mixer.png";
        }

        @Override
        public void setRecipe(IRecipeLayoutBuilder b, ParadoxMixerRecipe recipe, IFocusGroup focuses) {
                b.addInputSlot(4, 4).addFluidStack(recipe.getInput().getFluid());
                b.addSlot(RecipeIngredientRole.CATALYST, 57, 4).addIngredients(recipe.getCatalyst());
                b.addOutputSlot(107, 4).addFluidStack(recipe.getOutput().getFluid());
        }

}
