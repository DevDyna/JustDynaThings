package com.devdyna.justdynathings.compat.jei.categories;

import com.devdyna.cakesticklib.api.compat.jei.JEIFluidTankHelper;
import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.JustDynaThings;
import com.devdyna.justdynathings.common.recipes.anvils.eclipsealloy.RepairEclipseAlloyAnvilRecipe;
import com.devdyna.justdynathings.compat.jei.utils.BaseLabelledCategory;
import com.devdyna.justdynathings.init.types.zBlocks;
import com.devdyna.justdynathings.init.types.zRecipeTypes;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class EclipseAlloyAnvilCategory extends BaseLabelledCategory<RepairEclipseAlloyAnvilRecipe> {
        public static final IRecipeType<RecipeHolder<RepairEclipseAlloyAnvilRecipe>> TYPE = IRecipeType
                        .create(zRecipeTypes.ECLIPSEALLOY_ANVIL.getType());

        public EclipseAlloyAnvilCategory(IGuiHelper guiHelper) {
                super(guiHelper);
        }

        @Override
        public IRecipeType<RecipeHolder<RepairEclipseAlloyAnvilRecipe>> getRecipeType() {
                return TYPE;
        }

        @Override
        public void setRecipe(IRecipeLayoutBuilder b, RepairEclipseAlloyAnvilRecipe recipe, IFocusGroup focuses) {
                JEIFluidTankHelper.of()
                                .fluid(recipe.getInput())
                                .offset(4, 4 + 16)
                                .build((x, y) -> b.addInputSlot(x, y));
        }

        @Override
        public String getTraslationKey() {
                return JustDynaThings.MODULE_ID + ".jei.category." + Constants.Anvils.t4;
        }

        @Override
        public ItemLike getIconItem() {
                return zBlocks.ECLIPSEALLOY_ANVIL.get();
        }
}