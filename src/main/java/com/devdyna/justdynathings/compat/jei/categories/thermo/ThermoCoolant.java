package com.devdyna.justdynathings.compat.jei.categories.thermo;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.compat.jei.utils.BaseLabelledCategory;
import com.devdyna.justdynathings.compat.jei.datamaps.records.ThermoFluidCoolant;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class ThermoCoolant extends BaseLabelledCategory<ThermoFluidCoolant> {
    public static final RecipeType<ThermoFluidCoolant> TYPE = RecipeType.create(ID,
            Constants.DataMaps.Thermo.thermo_coolants,
            ThermoFluidCoolant.class);

    public ThermoCoolant(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public RecipeType<ThermoFluidCoolant> getRecipeType() {
        return TYPE;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder b, ThermoFluidCoolant map, IFocusGroup focuses) {
        b.addSlot(RecipeIngredientRole.INPUT, 4, 4)
                .addFluidStack(map.fluid());
    }

    @Override
    public void draw(ThermoFluidCoolant map, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics,
            double mouseX,
            double mouseY) {
        super.draw(map, recipeSlotsView, guiGraphics, mouseX, mouseY);
        guiGraphics.drawString(Minecraft.getInstance().font,
                "Efficiency : " + map.coolantEfficiency(), 30, 8, 0x444444, false);
    }

    @Override
    public String getTitleKey() {
        return Constants.DataMaps.Thermo.thermo_coolants;
    }

    @Override
    public ItemLike getIconItem() {
        return Items.WATER_BUCKET;
    }
}
