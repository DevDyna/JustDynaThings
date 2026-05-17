package com.devdyna.justdynathings.api;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.cakesticklib.api.gui.ImageGui;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.world.inventory.Slot;

public interface ExtraSlots {

    int getGuiLeft();

    int getGuiTop();

    default void addSlotFlame(GuiGraphicsExtractor guiGraphics, Slot slot) {
        ImageGui.of().rl(MODULE_ID, "textures/gui/slots/burn.png")
                .size(18, 18).offset(getGuiLeft() + slot.x, getGuiTop() + slot.y)
                .sizeTexture(18, 18)
                .render(guiGraphics);
    }

    default void addToolSlot(GuiGraphicsExtractor guiGraphics, Slot slot) {
        ImageGui.of().rl("justdirethings", "textures/sprites/container/slot/justslot.png")
                .size(18, 18).offset(getGuiLeft() + slot.x, getGuiTop() + slot.y)
                .uv(18, 0)
                .sizeTexture(256, 256)
                .render(guiGraphics);

    }

    default void addSlotCatalyst(GuiGraphicsExtractor guiGraphics, Slot slot) {
        ImageGui.of().rl(MODULE_ID, "textures/gui/slots/catalyst.png")
                .size(18, 18).offset(getGuiLeft() + slot.x, getGuiTop() + slot.y)
                .sizeTexture(18, 18)
                .render(guiGraphics);
    }

    default void addSlotTimeCrystal(GuiGraphicsExtractor guiGraphics, Slot slot) {
        ImageGui.of().rl(MODULE_ID, "textures/gui/slots/shard.png")
                .size(18, 18).offset(getGuiLeft() + slot.x, getGuiTop() + slot.y)
                .sizeTexture(18, 18)
                .render(guiGraphics);
    }

    default void addSlotDireCoal(GuiGraphicsExtractor guiGraphics, Slot slot) {
        ImageGui.of().rl(MODULE_ID, "textures/gui/slots/coal.png")
                .size(18, 18).offset(getGuiLeft() + slot.x, getGuiTop() + slot.y)
                .sizeTexture(18, 18)
                .render(guiGraphics);
    }

    default void addSlotCharge(GuiGraphicsExtractor guiGraphics, Slot slot) {
        ImageGui.of().rl(MODULE_ID, "textures/gui/slots/charge.png")
                .size(18, 18).offset(getGuiLeft() + slot.x, getGuiTop() + slot.y)
                .sizeTexture(18, 18)
                .render(guiGraphics);
    }

    default void addWarningPopUp(GuiGraphicsExtractor guiGraphics, int xOffset, int yOffset) {
        ImageGui.of().rl("minecraft",
                "textures/gui/sprites/icon/unseen_notification.png")
                .size(10, 10).offset(xOffset, yOffset)
                .sizeTexture(10, 10)
                .render(guiGraphics);
    }

}
