package com.devdyna.justdynathings.init.builder.fluid_mixer;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import java.util.List;

import com.devdyna.cakesticklib.api.utils.x;
import com.devdyna.justdynathings.api.CyclicImageGUI;
import com.devdyna.justdynathings.api.ExtraSlots;
import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;
import com.direwolf20.justdirethings.client.screens.standardbuttons.ToggleButtonFactory;
import com.direwolf20.justdirethings.client.screens.widgets.ToggleButton;
import com.direwolf20.justdirethings.util.MiscHelpers;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class SimpleFluidMixerScreen extends BaseMachineScreen<SimpleFluidMixerGUI> implements ExtraSlots {

    public SimpleFluidMixerScreen(SimpleFluidMixerGUI container, Inventory inv, Component name) {
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
        addRenderableWidget(ToggleButtonFactory.REDSTONEBUTTON(getLeftPos() + 104, topSectionTop + 38,
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
    protected void drawMachineSlot(GuiGraphicsExtractor guiGraphics, Slot slot) {
        ItemStack itemStack = slot.getItem();
        if (!itemStack.isEmpty())
            super.drawMachineSlot(guiGraphics, slot);
    }

    private final CyclicImageGUI templateIcon = new CyclicImageGUI(0, 30);

    private final static List<Identifier> images = List.of(
            x.rl(MODULE_ID, "textures/gui/slots/catalyst.png"),
            x.rl(MODULE_ID, "textures/gui/slots/shard.png"),
            x.rl(MODULE_ID, "textures/gui/slots/coal.png"));

    @Override
    protected void containerTick() {
        super.containerTick();
        templateIcon.tick(preview_slots);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks) {
        super.extractBackground(graphics, mouseX, mouseY, partialTicks);
        templateIcon.extractRenderState(menu, graphics, partialTicks, this.leftPos, this.topPos);
    }

}