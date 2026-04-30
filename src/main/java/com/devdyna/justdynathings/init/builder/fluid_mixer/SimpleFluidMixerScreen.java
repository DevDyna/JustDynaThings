package com.devdyna.justdynathings.init.builder.fluid_mixer;

import com.devdyna.justdynathings.api.ExtraSlots;
import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;
import com.direwolf20.justdirethings.client.screens.standardbuttons.ToggleButtonFactory;
import com.direwolf20.justdirethings.client.screens.widgets.ToggleButton;
import com.direwolf20.justdirethings.util.MiscHelpers;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

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
    // TODO rework
    // @Override
    // public void render(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY,
    // float partialTicks) {
    // super.render(guiGraphics, mouseX, mouseY, partialTicks);

    // if (baseMachineBE instanceof ParadoxMixerBE paradox)
    // if (!paradox.getBlockState().getValue(zProperties.GOO_ALIVE))
    // addWarningPopUp(guiGraphics, getGuiLeft()+110, getGuiTop());

    // }

    // @Override
    // protected void renderTooltip(GuiGraphicsExtractor guiGraphics, int x, int y)
    // {
    // super.renderTooltip(guiGraphics, x, y);
    // if (Pos.of(getGuiLeft()+110, getGuiTop()).setSize(10, 10).test(x, y))
    // guiGraphics.renderTooltip(font,
    // Component.translatable(
    // ID + "." + Constants.Blocks.ParadoxMixer + ".unstable"),
    // x, y);
    // }

}