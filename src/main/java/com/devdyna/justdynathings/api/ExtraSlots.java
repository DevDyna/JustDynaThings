package com.devdyna.justdynathings.api;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.inventory.Slot;

public interface ExtraSlots {

    int getGuiLeft();

    int getGuiTop();

    default void addSlotFlame(GuiGraphicsExtractor guiGraphics, Slot slot) {
        Image.of().rl(MODULE_ID, "textures/gui/slots/burn.png")
                .size(18, 18).offset(getGuiLeft() + slot.x, getGuiTop() + slot.y)
                .sizeTexture(18, 18)
                .render(guiGraphics);
    }

    default void addToolSlot(GuiGraphicsExtractor guiGraphics, Slot slot) {
        Image.of().rl("justdirethings", "textures/gui/justslot.png")
                .size(18, 18).offset(getGuiLeft() + slot.x, getGuiTop() + slot.y)
                .uv(18, 0)
                .sizeTexture(256, 256)
                .render(guiGraphics);

    }

    default void addSlotCharge(GuiGraphicsExtractor guiGraphics, Slot slot) {
        Image.of().rl(MODULE_ID, "textures/gui/slots/charge.png")
                .size(18, 18).offset(getGuiLeft() + slot.x, getGuiTop() + slot.y)
                .sizeTexture(18, 18)
                .render(guiGraphics);
    }

    default void addWarningPopUp(GuiGraphicsExtractor guiGraphics, int xOffset, int yOffset) {
        Image.of().rl("minecraft",
                "textures/gui/sprites/icon/unseen_notification.png")
                .size(10, 10).offset(xOffset, yOffset)
                .sizeTexture(10, 10)
                .render(guiGraphics);
    }


}
