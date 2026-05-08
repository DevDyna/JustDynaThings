package com.devdyna.justdynathings.compat.jei.utils;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.cakesticklib.api.compat.jei.BaseRecipeCategory;
import com.devdyna.cakesticklib.api.primitive.Size;
import com.devdyna.cakesticklib.api.utils.x;

import mezz.jei.api.helpers.IGuiHelper;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.Recipe;

public abstract class BaseLabelledCategory<T extends Recipe<?>> extends BaseRecipeCategory<T> {

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

}
