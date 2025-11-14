package com.devdyna.justdynathings.client.builder.paradoxMixer;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.client.core.ExtraSlots;
import com.devdyna.justdynathings.registry.builders.paradox_mixer.ParadoxMixerBE;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.Pos;
import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;
import com.direwolf20.justdirethings.client.screens.standardbuttons.ToggleButtonFactory;
import com.direwolf20.justdirethings.client.screens.widgets.ToggleButton;
import com.direwolf20.justdirethings.util.MiscHelpers;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class ParadoxMixerScreen extends BaseMachineScreen<ParadoxMixerGUI> implements ExtraSlots {

    public ParadoxMixerScreen(ParadoxMixerGUI container, Inventory inv, Component name) {
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
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
        super.render(guiGraphics, mouseX, mouseY, partialTicks);

        if (baseMachineBE instanceof ParadoxMixerBE paradox)
            if (!paradox.getBlockState().getValue(zProperties.GOO_ALIVE))
                addWarningPopUp(guiGraphics, getGuiLeft()+110, getGuiTop());

    }

    @Override
    protected void renderTooltip(GuiGraphics guiGraphics, int x, int y) {
        super.renderTooltip(guiGraphics, x, y);
        if (Pos.of(getGuiLeft()+110, getGuiTop()).setSize(10, 10).test(x, y))
            guiGraphics.renderTooltip(font,
                    Component.translatable(
                            ID + "." + Constants.Blocks.ParadoxMixer + ".unstable"),
                    x, y);
    }

}