package com.devdyna.justdynathings.api.ticker;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import java.util.List;

import com.devdyna.cakesticklib.api.primitive.Pos;
import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.api.ExtraSlots;
import com.direwolf20.justdirethings.JustDireThings;
import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;
import com.direwolf20.justdirethings.client.screens.standardbuttons.ToggleButtonFactory;
import com.direwolf20.justdirethings.client.screens.widgets.ToggleButton;
import com.direwolf20.justdirethings.common.containers.basecontainers.BaseMachineContainer;
import com.direwolf20.justdirethings.util.MiscHelpers;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;

public abstract class BaseTickerScreen<T extends BaseMachineContainer> extends BaseMachineScreen<T>
        implements ExtraSlots {

    public BaseTickerScreen(T arg0, Inventory arg1, Component arg2) {
        super(arg0, arg1, arg2);
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
        addRenderableWidget(ToggleButtonFactory.REDSTONEBUTTON(getLeftPos() + 104+40, topSectionTop + 38+20,
                redstoneMode.ordinal(), b -> {
                    redstoneMode = MiscHelpers.RedstoneMode.values()[((ToggleButton) b).getTexturePosition()];
                    saveSettings();
                }));
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int arg1, int arg2, float arg3) {

        super.extractBackground(graphics, arg1, arg2, arg3);

        if (isLocked()) {
            addFakeTickButton(graphics, this.leftPos + 144, this.topSectionTop + 40, getTickRate());
            addLock(graphics, this.leftPos + 144 + 5 + 5 + 5 + 5, this.topSectionTop + 40 + 5);
        } else if (baseMachineBE.getTickSpeed() > getTickRate())
            addWarningPopUp(graphics, getLeftPos() + 144 + 8, getTopPos());

        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, SOCIALBACKGROUND,
                topSectionLeft + 20 + 20 + 20 - 10, topSectionTop + 20 - 10 + 1,
                topSectionWidth - 100+10, 20 );

        graphics.blitSprite(RenderPipelines.GUI_TEXTURED, SOCIALBACKGROUND,
                topSectionLeft + 20 + 20 + 20 - 10, topSectionTop + 20 - 10 + 1+20,
                topSectionWidth - 100+10, 20 );

    }

    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {

        super.extractLabels(graphics, mouseX, mouseY);

        var fe = Component.translatable(MODULE_ID + ".gui." + Constants.Blocks.Ticker.BASE + ".cost.fe",
                getFErate());

        graphics.text(this.font, fe,
                this.topSectionLeft - this.leftPos + (this.topSectionWidth / 2)
                        - this.font.width(fe) / 2 +4,
                this.topSectionTop - this.topPos + 18, -12566464, false);

        var mb = Component.translatable(MODULE_ID + ".gui." + Constants.Blocks.Ticker.BASE + ".cost.mb",
                getMBrate());

        graphics.text(this.font, mb,
                this.topSectionLeft - this.leftPos + (this.topSectionWidth / 2)
                        - this.font.width(mb) / 2 +4,
                this.topSectionTop - this.topPos + 18 + 5+5+10, -12566464, false);
    }

    @Override
    protected void extractTooltip(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {

        super.extractTooltip(graphics, mouseX, mouseY);

        if (Pos.of(this.leftPos + 144 + 5 + 5 + 5 + 5, this.topSectionTop + 40 + 5).setSize(11, 11).test(mouseX,
                mouseY) && isLocked()) {

            graphics.setComponentTooltipForNextFrame(font,
                    List.of(Component.translatable(MODULE_ID + Constants.Blocks.Ticker.BASE + ".locked")),
                    mouseX, mouseY);

        } else if (Pos.of(this.leftPos + 144, this.topSectionTop + 40).setSize(24, 12).test(mouseX, mouseY))
            graphics.setComponentTooltipForNextFrame(font,
                    List.of(Component.translatable(JustDireThings.MODID + ".screen.tickspeed")),
                    mouseX, mouseY);

        if (baseMachineBE.getTickSpeed() > getTickRate())
            if (Pos.of(getLeftPos() + 144 + 8, getTopPos()).setSize(10, 10).test(mouseX, mouseY))
                graphics.setTooltipForNextFrame(font,
                        Component.translatable(
                                MODULE_ID + "." + Constants.Blocks.Ticker.BASE + ".tick_overflow",
                                getTickRate()),
                        mouseX, mouseY);

    }

    @Override
    public void addTickSpeedButton() {
        if (!isLocked())
            super.addTickSpeedButton();
    }

    public abstract boolean isLocked();

    public abstract int getTickRate();

    public abstract int getFErate();

    public abstract int getMBrate();

    @Override
    protected void drawMachineSlot(GuiGraphicsExtractor guiGraphics, Slot slot) {
        super.drawMachineSlot(guiGraphics, slot);
    }

}
