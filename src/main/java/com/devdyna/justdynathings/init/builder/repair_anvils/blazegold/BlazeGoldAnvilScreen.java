package com.devdyna.justdynathings.init.builder.repair_anvils.blazegold;

import com.devdyna.justdynathings.api.repair_anvils.BaseAnvilScreen;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class BlazeGoldAnvilScreen extends BaseAnvilScreen<BlazeGoldAnvilGUI> {
    public BlazeGoldAnvilScreen(BlazeGoldAnvilGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

    @Override
    protected void drawMachineSlot(GuiGraphicsExtractor guiGraphics, Slot slot) {
        ItemStack itemStack = slot.getItem();
        if (itemStack.isEmpty() && slot.getSlotIndex() == 0)
            addToolSlot(guiGraphics, slot);
        else
            super.drawMachineSlot(guiGraphics, slot);
    }
}