package com.devdyna.justdynathings.init.builder.ticker.simple;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.api.ExtraSlots;
import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;
import com.direwolf20.justdirethings.client.screens.standardbuttons.ToggleButtonFactory;
import com.direwolf20.justdirethings.client.screens.widgets.ToggleButton;
import com.direwolf20.justdirethings.util.MiscHelpers;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

public class SimpleTickerScreen extends BaseMachineScreen<SimpleTickerGUI> implements ExtraSlots {
    public SimpleTickerScreen(SimpleTickerGUI container, Inventory inv, Component name) {
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

    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int arg1, int arg2, float arg3) {

        super.extractBackground(graphics, arg1, arg2, arg3);

        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, SOCIALBACKGROUND,
                topSectionLeft+ 20 + 20 + 20 - 10, topSectionTop + 20 - 10 + 1,
                topSectionWidth - 100 , 20);

    }

    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int x, int y) {

        var tip = Component.translatable(MODULE_ID + ".gui." + Constants.Blocks.Ticker.Simple + ".ticks",
                Config.SIMPLE_TICKER_TICK_RATE.get());

        graphics.text(this.font, tip,
                this.topSectionLeft - this.leftPos + (this.topSectionWidth / 2)
                        - this.font.width(tip) / 2,
                this.topSectionTop - this.topPos + 18, -12566464, false);

        super.extractLabels(graphics, x, y);
    }

    @Override
    protected void drawMachineSlot(GuiGraphicsExtractor guiGraphics, Slot slot) {
        super.drawMachineSlot(guiGraphics, slot);
    }
}