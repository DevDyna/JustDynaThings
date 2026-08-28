package com.devdyna.justdynathings.registry.builders.ticker;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.api.client.ExtraSlots;
import com.devdyna.justdynathings.config.ServerConfig;
import com.devdyna.justdynathings.utils.Pos;
import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;
import com.direwolf20.justdirethings.client.screens.standardbuttons.ToggleButtonFactory;
import com.direwolf20.justdirethings.client.screens.widgets.ToggleButton;
import com.direwolf20.justdirethings.util.MiscHelpers;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

public class TickerScreen extends BaseMachineScreen<TickerGUI> implements ExtraSlots {
    public TickerScreen(TickerGUI container, Inventory inv, Component name) {
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
    public void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        super.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);

        if (baseMachineBE.getTickSpeed() > ServerConfig.TICKER_TICK_RATE.get())
            addWarningPopUp(guiGraphics, getGuiLeft() + 144+8, getGuiTop());

    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int x, int y) {
        super.renderTooltip(guiGraphics, x, y);
        if (Pos.of(getGuiLeft()+144+8 , getGuiTop()).setSize(10, 10).test(x, y))
            guiGraphics.renderTooltip(font,
                    Component.translatable(
                            ID + "." + Constants.Blocks.Ticker + ".tick_overflow",ServerConfig.TICKER_TICK_RATE.get()),
                    x, y);
    }

    @Override
    protected void drawMachineSlot(GuiGraphics guiGraphics, Slot slot) {
        super.drawMachineSlot(guiGraphics, slot);
    }
}