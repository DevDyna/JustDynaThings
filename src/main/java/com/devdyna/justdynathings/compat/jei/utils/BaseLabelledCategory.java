package com.devdyna.justdynathings.compat.jei.utils;

import mezz.jei.api.helpers.IGuiHelper;

public abstract class BaseLabelledCategory<T> extends BaseRecipeCategory<T> {

    public BaseLabelledCategory(IGuiHelper guiHelper) {
       super(guiHelper);
    }

    @Override
    public String setBackGround() {
        return "textures/gui/labelled.png";
    }

    @Override
    public Size setXY() {
        return Size.of(160, 24);
    }

}