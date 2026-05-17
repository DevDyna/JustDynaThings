package com.devdyna.justdynathings.compat.jei.utils;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.cakesticklib.api.compat.jei.BaseRecipeCategory;
import com.devdyna.cakesticklib.api.primitive.Size;
import com.devdyna.cakesticklib.api.utils.x;
import com.devdyna.justdynathings.api.repair_anvils.BaseAnvilRecipe;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.resources.Identifier;

public abstract class BaseLabelledCategory<T extends BaseAnvilRecipe<?>> extends BaseRecipeCategory<T> {

    public BaseLabelledCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public Identifier setBackGround() {
        return x.rl(MODULE_ID, "textures/gui/labelled.png");
    }

    @Override
    public Size setXY() {
        return Size.of(160, 24);
    }

    @Override
    public void draw(T recipe, IRecipeSlotsView recipeSlotsView,
            GuiGraphicsExtractor guiGraphics,
            double mouseX,
            double mouseY) {
        super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
        guiGraphics.text(Minecraft.getInstance().font,
                "Durability :", 30, 8, 0xFF444444, false);

        guiGraphics.text(Minecraft.getInstance().font,
                (recipe.getDurability() > 0 ? "§a+" : "§c") + recipe.getDurability() + "§f", 86, 8, 0xFF444444,
                true);
    }

}
