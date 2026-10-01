package com.devdyna.justdynathings.api;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.cakesticklib.api.gui.ImageGui;
import com.devdyna.cakesticklib.api.utils.ColorUtils;
import net.minecraft.client.Minecraft;
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
        ImageGui.of().rl(MODULE_ID, "textures/gui/slots/tool.png")
                .size(18, 18).offset(getGuiLeft() + slot.x, getGuiTop() + slot.y)
                .sizeTexture(18, 18)
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

    default void addRecipeButton(GuiGraphicsExtractor guiGraphics, int x, int y) {
        ImageGui.of().rl(MODULE_ID, "textures/gui/slots/recipe.png")
                .size(16, 16).offset(getGuiLeft() + x, getGuiTop() + y)
                .sizeTexture(16, 16)
                .render(guiGraphics);
    }

    default void addWarningPopUp(GuiGraphicsExtractor guiGraphics, int xOffset, int yOffset) {
        ImageGui.of().rl("minecraft",
                "textures/gui/sprites/icon/unseen_notification.png")
                .size(10, 10).offset(xOffset, yOffset)
                .sizeTexture(10, 10)
                .render(guiGraphics);
    }

    default void addCross(GuiGraphicsExtractor graphics, int xOffset, int yOffset) {
        ImageGui.of()
                .rl(MODULE_ID, "textures/gui/slots/cross.png")
                .size(16, 16)
                .offset(xOffset, yOffset)
                .sizeTexture(16, 16)
                .render(graphics);
    }

    default void addBiomeListType(GuiGraphicsExtractor graphics, int xOffset, int yOffset, boolean flag) {
        ImageGui.of()
                .rl(MODULE_ID, "textures/gui/slots/solar/biome/" +
                        (flag ? "whitelist" : "blacklist") + ".png")
                .size(16, 16)
                .offset(xOffset, yOffset)
                .sizeTexture(16, 16)
                .render(graphics);
    }

    default void addYLevel(GuiGraphicsExtractor graphics, int xOffset, int yOffset) {
        ImageGui.of()
                .rl(MODULE_ID, "textures/gui/slots/solar/ylevel.png")
                .size(16, 16)
                .offset(xOffset, yOffset)
                .sizeTexture(16, 16)
                .render(graphics);
    }

    default void addSpam(GuiGraphicsExtractor graphics, int xOffset, int yOffset) {
        ImageGui.of()
                .rl(MODULE_ID, "textures/gui/slots/solar/spam.png")
                .size(16, 16)
                .offset(xOffset, yOffset)
                .sizeTexture(16, 16)
                .render(graphics);
    }

    default void addSky(GuiGraphicsExtractor graphics, int xOffset, int yOffset) {
        ImageGui.of()
                .rl(MODULE_ID, "textures/gui/slots/solar/sky.png")
                .size(16, 16)
                .offset(xOffset, yOffset)
                .sizeTexture(16, 16)
                .render(graphics);
    }

    default void addDayTime(GuiGraphicsExtractor graphics, int xOffset, int yOffset) {
        ImageGui.of()
                .rl(MODULE_ID, "textures/gui/slots/solar/daytime.png")
                .size(16, 16)
                .offset(xOffset, yOffset)
                .sizeTexture(16, 16)
                .render(graphics);
    }

    default void addFakeTickButton(GuiGraphicsExtractor graphics, int xOffset, int yOffset, int value) {
        var width = 24;
        var height = 12;
        var scale = 0.75f;
        var font = Minecraft.getInstance().font;

        graphics.fill(xOffset, yOffset, xOffset + width, yOffset + height, 0xFF353535);
        graphics.fill(xOffset + 1, yOffset + 1, xOffset + width - 1, yOffset + height - 1, 0xFFD8D8D8);
        var stack = graphics.pose();
        stack.pushMatrix();
        stack.scale(scale, scale);

        var txt = String.format("%,d", value);

        graphics.text(font, txt,
                (int) ((xOffset + width / 2f) / scale - font.width(txt) / 2f),
                (int) ((yOffset + (height - font.lineHeight) / 2f / scale) / scale + 1),
                ColorUtils.GRAY.DARK_GRAY.getRGB(), false);
        stack.popMatrix();
    }

    default void addLock(GuiGraphicsExtractor graphics, int xOffset, int yOffset) {
        ImageGui.of()
                .rl(MODULE_ID, "textures/gui/slots/lock.png")
                .size(11, 11)
                .offset(xOffset, yOffset)
                .sizeTexture(11, 11)
                .render(graphics);
    }

}
