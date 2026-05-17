package com.devdyna.justdynathings.compat.jei.categories;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.JustDynaThings;
import com.devdyna.justdynathings.common.recipes.anvils.ferricore.RepairFerricoreAnvilRecipe;
import com.devdyna.justdynathings.compat.jei.utils.BaseLabelledCategory;
import com.devdyna.justdynathings.init.types.zBlocks;
import com.devdyna.justdynathings.init.types.zRecipeTypes;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class FerricoreAnvilCategory extends BaseLabelledCategory<RepairFerricoreAnvilRecipe> {
    public static final IRecipeType<RecipeHolder<RepairFerricoreAnvilRecipe>> TYPE = IRecipeType
            .create(zRecipeTypes.FERRICORE_ANVIL.getType());

    public FerricoreAnvilCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public IRecipeType<RecipeHolder<RepairFerricoreAnvilRecipe>> getRecipeType() {
        return TYPE;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder b, RepairFerricoreAnvilRecipe recipe, IFocusGroup focuses) {
        b.addSlot(RecipeIngredientRole.INPUT, 4, 4)
                .add(recipe.getInput());
    }

    @Override
    public String getTraslationKey() {
        return JustDynaThings.MODULE_ID + ".jei.category." + Constants.Anvils.t1;
    }

    @Override
    public ItemLike getIconItem() {
        return zBlocks.FERRICORE_ANVIL.get();
    }

}