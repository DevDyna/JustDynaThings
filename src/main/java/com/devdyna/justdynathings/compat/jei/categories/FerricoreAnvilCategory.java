package com.devdyna.justdynathings.compat.jei.categories;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.common.recipes.anvils.ferricore.RepairFerricoreAnvilRecipe;
import com.devdyna.justdynathings.compat.jei.utils.BaseLabelledCategory;
import com.devdyna.justdynathings.init.types.zBlocks;
import com.devdyna.justdynathings.init.types.zRecipeTypes;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
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
    public void draw(RepairFerricoreAnvilRecipe recipe, IRecipeSlotsView recipeSlotsView,
            GuiGraphicsExtractor guiGraphics,
            double mouseX,
            double mouseY) {
        super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
        guiGraphics.text(Minecraft.getInstance().font,
                "Durability : " + recipe.getDurability(), 30, 8, 0x444444, false);
    }

    @Override
    public String getTraslationKey() {
        return Constants.DataMaps.Anvils.ferricore_repair;
    }

    @Override
    public ItemLike getIconItem() {
        return zBlocks.FERRICORE_ANVIL.get();
    }

}