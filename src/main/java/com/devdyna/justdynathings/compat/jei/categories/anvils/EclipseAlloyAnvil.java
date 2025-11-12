package com.devdyna.justdynathings.compat.jei.categories.anvils;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.compat.jei.datamaps.records.EclipseAlloyFluidRepair;
import com.devdyna.justdynathings.compat.jei.utils.BaseLabelledCategory;
import com.devdyna.justdynathings.registry.types.zBlocks;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class EclipseAlloyAnvil extends BaseLabelledCategory<EclipseAlloyFluidRepair> {
        public static final RecipeType<EclipseAlloyFluidRepair> TYPE = RecipeType.create(ID,
                        Constants.DataMaps.Anvils.eclipsealloy_repair,
                        EclipseAlloyFluidRepair.class);

        public EclipseAlloyAnvil(IGuiHelper guiHelper) {
                super(guiHelper);
        }

        @Override
        public RecipeType<EclipseAlloyFluidRepair> getRecipeType() {
                return TYPE;
        }

        @Override
        public void setRecipe(IRecipeLayoutBuilder b, EclipseAlloyFluidRepair map, IFocusGroup focuses) {
                b.addSlot(RecipeIngredientRole.INPUT, 4, 4)
                                .addFluidStack(map.fluid());
        }

        @Override
        public void draw(EclipseAlloyFluidRepair map, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics,
                        double mouseX,
                        double mouseY) {
                                super.draw(map, recipeSlotsView, guiGraphics, mouseX, mouseY);
                guiGraphics.drawString(Minecraft.getInstance().font,
                                "Percentuage : " + map.percentuage(), 30, 8, 0x444444, false);
        }

        @Override
        public String getTitleKey() {
                return Constants.DataMaps.Anvils.eclipsealloy_repair;
        }

        @Override
        public ItemLike getIconItem() {
                return zBlocks.ECLIPSEALLOY_ANVIL.get();
        }
}
