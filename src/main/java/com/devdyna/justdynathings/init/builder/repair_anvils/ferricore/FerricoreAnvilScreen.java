package com.devdyna.justdynathings.init.builder.repair_anvils.ferricore;

import com.devdyna.justdynathings.api.repair_anvils.BaseAnvilScreen;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class FerricoreAnvilScreen extends BaseAnvilScreen<FerricoreAnvilGUI> {

    public FerricoreAnvilScreen(FerricoreAnvilGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

    @Override
    protected void drawMachineSlot(GuiGraphicsExtractor guiGraphics, Slot slot) {
        ItemStack itemStack = slot.getItem();
        if (itemStack.isEmpty()) {
            if (slot.getSlotIndex() == 0)
                addToolSlot(guiGraphics, slot);
            else if (slot.getSlotIndex() == 1)
                addSlotFlame(guiGraphics, slot);
        } else
            super.drawMachineSlot(guiGraphics, slot);

    }
}
