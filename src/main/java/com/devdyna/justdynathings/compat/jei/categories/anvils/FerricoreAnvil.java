package com.devdyna.justdynathings.compat.jei.categories.anvils;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.compat.jei.datamaps.records.FerricoreItemRepair;
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
public class FerricoreAnvil extends BaseLabelledCategory<FerricoreItemRepair> {
    public static final RecipeType<FerricoreItemRepair> TYPE = RecipeType.create(ID,
            Constants.DataMaps.Anvils.ferricore_repair,
            FerricoreItemRepair.class);

    public FerricoreAnvil(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public RecipeType<FerricoreItemRepair> getRecipeType() {
        return TYPE;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder b, FerricoreItemRepair map, IFocusGroup focuses) {
        b.addSlot(RecipeIngredientRole.INPUT, 4, 4)
                .addItemLike(map.item());
    }

    @Override
    public void draw(FerricoreItemRepair map, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics,
            double mouseX,
            double mouseY) {
                super.draw(map, recipeSlotsView, guiGraphics, mouseX, mouseY);
        guiGraphics.drawString(Minecraft.getInstance().font,
                "Durability : " + map.durability(), 30, 8, 0x444444, false);
    }

    @Override
    public String getTitleKey() {
        return Constants.DataMaps.Anvils.ferricore_repair;
    }

    @Override
    public ItemLike getIconItem() {
        return zBlocks.FERRICORE_ANVIL.get();
    }
}
