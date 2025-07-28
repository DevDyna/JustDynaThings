package com.devdyna.justdynathings.compat.jei.datamaps.core;

import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.ItemLike;

public abstract class BaseMapCategory<T> implements IRecipeCategory<T> {
    private final Component title;
    private final IDrawable background;
    private final IDrawable icon;

    public BaseMapCategory(IGuiHelper guiHelper, ItemLike icon, Component title, IDrawable bg) {
        this.title = title;
        this.background = bg;
        this.icon = guiHelper.createDrawableItemLike(icon);
    }

    @Override
    public final Component getTitle() {
        return title;
    }

    @Override
    public final IDrawable getBackground() {
        return background;
    }

    @Override
    public final IDrawable getIcon() {
        return icon;
    }
}