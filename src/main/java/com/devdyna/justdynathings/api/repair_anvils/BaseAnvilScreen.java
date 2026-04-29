package com.devdyna.justdynathings.api.repair_anvils;

import com.devdyna.justdynathings.api.ExtraSlots;
import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;
import com.direwolf20.justdirethings.client.screens.standardbuttons.ToggleButtonFactory;
import com.direwolf20.justdirethings.client.screens.widgets.ToggleButton;
import com.direwolf20.justdirethings.common.containers.basecontainers.BaseMachineContainer;
import com.direwolf20.justdirethings.util.MiscHelpers;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public abstract class BaseAnvilScreen<T extends BaseMachineContainer> extends BaseMachineScreen<T>
        implements ExtraSlots {

    public BaseAnvilScreen(T arg0, Inventory arg1, Component arg2) {
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

}
