package com.devdyna.justdynathings.api;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;

//TODO move to api
public interface ClientRender {
    default boolean hasShiftDown() {
        return Minecraft.getInstance().hasShiftDown();
    }

    default void drawCentredStringFixed(GuiGraphicsExtractor g, Font font, Component text, int x, int y, int color,Boolean bool) {
        var f = text.getVisualOrderText();
        g.text(font, f, x - font.width(f) / 2, y, color,bool);
    }
}
