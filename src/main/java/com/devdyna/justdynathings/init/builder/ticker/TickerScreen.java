package com.devdyna.justdynathings.init.builder.ticker;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.cakesticklib.api.primitive.Pos;
import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.api.ExtraSlots;
import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;
import com.direwolf20.justdirethings.client.screens.standardbuttons.ToggleButtonFactory;
import com.direwolf20.justdirethings.client.screens.widgets.ToggleButton;
import com.direwolf20.justdirethings.util.MiscHelpers;

import net.minecraft.client.gui.GuiGraphicsExtractor;
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
        addRenderableWidget(ToggleButtonFactory.REDSTONEBUTTON(getLeftPos() + 104, topSectionTop + 38,
                redstoneMode.ordinal(), b -> {
                    redstoneMode = MiscHelpers.RedstoneMode.values()[((ToggleButton) b).getTexturePosition()];
                    saveSettings();
                }));
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
        super.extractBackground(guiGraphics, mouseX, mouseY, partialTicks);

        if (baseMachineBE.getTickSpeed() > Config.TICKER_TICK_RATE.get())
            addWarningPopUp(guiGraphics, getLeftPos() + 144 + 8, getTopPos());
    }

    @Override
    protected void extractTooltip(GuiGraphicsExtractor graphics, int x, int y) {
        super.extractTooltip(graphics, x, y);

        if (Pos.of(getLeftPos() + 144 + 8, getTopPos()).setSize(10, 10).test(x, y))
            graphics.setTooltipForNextFrame(font,
                    Component.translatable(
                            MODULE_ID + "." + Constants.Blocks.Ticker + ".tick_overflow",
                            Config.TICKER_TICK_RATE.get()),
                    x, y);
    }

    @Override
    protected void drawMachineSlot(GuiGraphicsExtractor guiGraphics, Slot slot) {
        super.drawMachineSlot(guiGraphics, slot);
    }
}