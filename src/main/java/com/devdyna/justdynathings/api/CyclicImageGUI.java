package com.devdyna.justdynathings.api;

import java.util.List;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.Identifier;
import net.minecraft.util.ARGB;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;

//TODO move to api

/**
 * Utility render class based on {@code net.minecraft.client.gui.screens.inventory.CyclingSlotBackground}
 */
public class CyclicImageGUI {

    private final int slotIndex;
    private List<Identifier> icons = List.of();
    private int tick;
    private int iconIndex;
    private int tickDelay = 30;

    public CyclicImageGUI(int slotIndex, int delay) {
        this.slotIndex = slotIndex;
        this.tickDelay = delay;
    }

    public void tick(List<Identifier> newIcons) {
        if (!this.icons.equals(newIcons)) {
            this.icons = newIcons;
            this.iconIndex = 0;
        }

        if (!this.icons.isEmpty() && ++this.tick % tickDelay == 0)
            this.iconIndex = (this.iconIndex + 1) % this.icons.size();

    }

    public void extractRenderState(AbstractContainerMenu menu, GuiGraphicsExtractor graphics, float a, int left,
            int top) {
        Slot slot = menu.getSlot(this.slotIndex);
        if (!this.icons.isEmpty() && !slot.hasItem()) {
            float alphaProgress = (this.icons.size() > 1 && this.tick >= tickDelay)
                    ? (Math.min((this.tick % tickDelay) + a, 4.0F) / 4.0F)
                    : 1.0F;
            if (alphaProgress < 1.0F) {
                this.extractIcon(slot, this.icons.get(Math.floorMod(this.iconIndex - 1, this.icons.size())),
                        1.0F - alphaProgress, graphics,
                        left, top);
            }

            this.extractIcon(slot, this.icons.get(this.iconIndex), alphaProgress, graphics, left, top);
        }

    }

    private void extractIcon(Slot slot, Identifier image, float alphaProgress, GuiGraphicsExtractor graphics,
            int left, int top) {
                //TODO ImageGui setColor and getters
                // image.render(graphics);
        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, image, left + slot.x-1, top + slot.y-1, 18, 18,
                ARGB.white(alphaProgress));
    }

}
