package com.devdyna.justdynathings.compat.jei.categories;

import com.devdyna.cakesticklib.api.compat.jei.JEIFluidTankHelper;
import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.common.recipes.anvils.blazegold.RepairBlazegoldAnvilRecipe;
import com.devdyna.justdynathings.compat.jei.utils.BaseLabelledCategory;
import com.devdyna.justdynathings.init.types.zBlocks;
import com.devdyna.justdynathings.init.types.zRecipeTypes;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class BlazeGoldAnvilCategory extends BaseLabelledCategory<RepairBlazegoldAnvilRecipe> {
        public static final IRecipeType<RecipeHolder<RepairBlazegoldAnvilRecipe>> TYPE = IRecipeType
                        .create(zRecipeTypes.BLAZEGOLD_ANVIL.getType());

        public BlazeGoldAnvilCategory(IGuiHelper guiHelper) {
                super(guiHelper);
        }

        @Override
        public IRecipeType<RecipeHolder<RepairBlazegoldAnvilRecipe>> getRecipeType() {
                return TYPE;
        }

        @Override
        public void setRecipe(IRecipeLayoutBuilder b, RepairBlazegoldAnvilRecipe recipe, IFocusGroup focuses) {
                JEIFluidTankHelper.of()
                                .fluid(recipe.getInput())
                                .offset(4, 4)
                                .build((x, y) -> b.addInputSlot(x, y));
        }

        @Override
        public void draw(RepairBlazegoldAnvilRecipe recipe, IRecipeSlotsView recipeSlotsView,
                        GuiGraphicsExtractor guiGraphics,
                        double mouseX,
                        double mouseY) {
                super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
                guiGraphics.text(Minecraft.getInstance().font,
                                "Durability : " + recipe.getDurability(), 30, 8, 0x444444, false);
        }

        @Override
        public String getTraslationKey() {
                return Constants.DataMaps.Anvils.blazegold_repair;
        }

        @Override
        public ItemLike getIconItem() {
                return zBlocks.BLAZEGOLD_ANVIL.get();
        }
}