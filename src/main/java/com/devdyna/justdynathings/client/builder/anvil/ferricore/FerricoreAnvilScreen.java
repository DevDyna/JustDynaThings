package com.devdyna.justdynathings.client.builder.anvil.ferricore;

import com.devdyna.justdynathings.Main;
import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;
import com.direwolf20.justdirethings.client.screens.standardbuttons.ToggleButtonFactory;
import com.direwolf20.justdirethings.client.screens.widgets.ToggleButton;
import com.direwolf20.justdirethings.util.MiscHelpers;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class FerricoreAnvilScreen extends BaseMachineScreen<FerricoreAnvilGUI> {

    protected final ResourceLocation FUELSLOT = ResourceLocation.fromNamespaceAndPath(Main.ID,
            "textures/gui/fuel.png");

    public FerricoreAnvilScreen(FerricoreAnvilGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void setTopSection() {
        extraWidth = 0;
        extraHeight = 0;
    }

    @Override
    public void addRedstoneButtons() {
        addRenderableWidget(ToggleButtonFactory.REDSTONEBUTTON(getGuiLeft() + 104, topSectionTop + 38,
                redstoneMode.ordinal(), b -> {
                    redstoneMode = MiscHelpers.RedstoneMode.values()[((ToggleButton) b).getTexturePosition()];
                    saveSettings();
                }));
    }

    @Override
    public void addTickSpeedButton() {
        // empty remove tick button
    }

    @Override
    protected void drawMachineSlot(GuiGraphics guiGraphics, Slot slot) {
        ItemStack itemStack = slot.getItem();
        if (itemStack.isEmpty()) {
            if (slot.getSlotIndex() == 0)
                guiGraphics.blit(JUSTSLOT, getGuiLeft() + slot.x - 1, getGuiTop() + slot.y - 1, 18, 0, 18, 18);
            else if (slot.getSlotIndex() == 1)
                guiGraphics.blit(FUELSLOT, getGuiLeft() + slot.x - 1, getGuiTop() + slot.y - 1, 0, 0, 18, 18);
        } else
            super.drawMachineSlot(guiGraphics, slot);

    }
}
