package com.devdyna.justdynathings.client.core;

import com.devdyna.justdynathings.Main;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;

public interface ExtraSlots {

    int getGuiLeft();

    int getGuiTop();

    ResourceLocation EXTRA_SLOTS = ResourceLocation.fromNamespaceAndPath(Main.ID,
            "textures/gui/slots.png");

    int SLOT_SIZE = 18;


    default void addSlotFlame(GuiGraphics guiGraphics, Slot slot) {
        guiGraphics.blit(ExtraSlots.EXTRA_SLOTS, getGuiLeft() + slot.x - 1, getGuiTop() + slot.y - 1, 0, 0, SLOT_SIZE,
                SLOT_SIZE);
    }

    default void addSlotCharge(GuiGraphics guiGraphics, Slot slot) {
        guiGraphics.blit(ExtraSlots.EXTRA_SLOTS, getGuiLeft() + slot.x - 1, getGuiTop() + slot.y - 1, SLOT_SIZE, 0,
                SLOT_SIZE * 2, SLOT_SIZE);
    }

}
