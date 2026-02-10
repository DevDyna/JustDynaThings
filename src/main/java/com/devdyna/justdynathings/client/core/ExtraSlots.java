package com.devdyna.justdynathings.client.core;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.compat.jei.utils.Image;
import com.devdyna.justdynathings.utils.LogUtil;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;

public interface ExtraSlots {

    int getGuiLeft();

    int getGuiTop();

    default void addSlotFlame(GuiGraphics guiGraphics, Slot slot) {
      Image.of().rl(Main.ID,"textures/gui/slots/burn.png")
                .size(18, 18).offset( getGuiLeft() + slot.x , getGuiTop() + slot.y)
                .sizeTexture(18, 18)
                .render(guiGraphics);
    }

    default void addSlotCharge(GuiGraphics guiGraphics, Slot slot) {
        Image.of().rl(Main.ID,"textures/gui/slots/charge.png")
                .size(18, 18).offset( getGuiLeft() + slot.x , getGuiTop() + slot.y)
                .sizeTexture(18, 18)
                .render(guiGraphics);
    }

    default void addWarningPopUp(GuiGraphics guiGraphics, int xOffset, int yOffset) {
        Image.of().rl("minecraft",
                "textures/gui/sprites/icon/unseen_notification.png")
                .size(10, 10).offset( xOffset,  yOffset)
                .render(guiGraphics);
    }

}
