package com.devdyna.justdynathings.client.core;

import java.util.List;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;

/**
 * Utility render class based on
 * {@code net.minecraft.client.gui.screens.inventory.CyclingSlotBackground}
 */
public class CyclicImageGui {

    private final int slotIndex;
    private List<ResourceLocation> icons = List.of();
    private int tick;
    private int iconIndex;
    private int tickDelay = 30;

    public CyclicImageGui(int slotIndex, int delay) {
        this(slotIndex);
        this.tickDelay = delay;
    }

    public CyclicImageGui(int slotIndex) {
        this.slotIndex = slotIndex;
    }

    public void tick(List<ResourceLocation> newIcons) {
        if (!this.icons.equals(newIcons)) {
            this.icons = newIcons;
            this.iconIndex = 0;
        }

        if (!this.icons.isEmpty() && ++this.tick % tickDelay == 0)
            this.iconIndex = (this.iconIndex + 1) % this.icons.size();

    }

    public void render(AbstractContainerMenu menu, GuiGraphics graphics, float partialTicks,
            int top, int left, int width, int height, int u, int v, int textureX, int textureY) {
        Slot slot = menu.getSlot(this.slotIndex);
        if (!this.icons.isEmpty() && !slot.hasItem()) {
            float alphaProgress = (this.icons.size() > 1 && this.tick >= tickDelay)
                    ? (Math.min((this.tick % tickDelay) + partialTicks, 4.0F) / 4.0F)
                    : 1.0F;
            if (alphaProgress < 1.0F)
                sprite(slot,
                        this.icons.get(Math.floorMod(this.iconIndex - 1, this.icons.size())),
                        1.0F - alphaProgress, graphics, top, left, width, height, u, v, textureX, textureY);

            sprite(slot, this.icons.get(this.iconIndex), alphaProgress, graphics, top, left, width, height, u, v,
                    textureX, textureY);
        }

    }

    private void sprite(Slot slot, ResourceLocation image, float alphaProgress,
            GuiGraphics graphics, int top, int left, int width, int height, int u, int v, int textureX,
            int textureY) {
        graphics.blit(image,
                left + slot.x - 1, top + slot.y - 1,
                u, v,
                width, height,
                textureX, textureY);
    }

}