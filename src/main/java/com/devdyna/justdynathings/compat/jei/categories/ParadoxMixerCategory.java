package com.devdyna.justdynathings.compat.jei.categories;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.compat.jei.utils.BaseRecipeCategory;
import com.devdyna.justdynathings.recipetypes.type.ParadoxMixerRecipe;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zRecipeTypes;
import com.devdyna.justdynathings.utils.Size;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class ParadoxMixerCategory<T extends Recipe<?>> extends BaseRecipeCategory<RecipeHolder<ParadoxMixerRecipe>> {

        public static final RecipeType<RecipeHolder<ParadoxMixerRecipe>> TYPE = RecipeType
                        .createFromVanilla(zRecipeTypes.PARADOX_MIXER.getType());

        @Override
        public RecipeType<RecipeHolder<ParadoxMixerRecipe>> getRecipeType() {
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
        public void setRecipe(IRecipeLayoutBuilder b, RecipeHolder<ParadoxMixerRecipe> recipe, IFocusGroup focuses) {
                b.addInputSlot(4, 4).addFluidStack(recipe.value().getInput().getFluid());
                b.addSlot(RecipeIngredientRole.CATALYST, 57, 4).addIngredients(recipe.value().getCatalyst());
                b.addOutputSlot(107, 4).addFluidStack(recipe.value().getOutput().getFluid());
        }

}
