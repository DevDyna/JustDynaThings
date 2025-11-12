package com.devdyna.justdynathings.compat.jei.utils;

import static com.devdyna.justdynathings.Main.ID;

import org.jetbrains.annotations.Nullable;

import com.devdyna.justdynathings.utils.Size;

import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.ItemLike;

public abstract class BaseRecipeCategory<T> implements IRecipeCategory<T> {

    protected IGuiHelper helper;

    public BaseRecipeCategory(IGuiHelper h) {
        this.helper = h;
    }

    public abstract String getTitleKey();

    public abstract ItemLike getIconItem();

    public abstract Size setXY();

    public abstract String setBackGround();

    @Override
    public Component getTitle() {
        return Component.translatable(ID + ".jei.category." + getTitleKey());
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return helper.createDrawableItemLike(getIconItem());
    }

    @Override
    public int getWidth() {
        return setXY().getX();
    }

    @Override
    public int getHeight() {
        return setXY().getY();
    }

    @SuppressWarnings("null")
    @Override
    public void draw(T recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX,
            double mouseY) {
        Image.of()
                .rl(this.setBackGround())
                .size(this.getWidth(), this.getHeight())
                .render(helper,guiGraphics);
    }

}
