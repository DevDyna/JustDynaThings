package com.devdyna.justdynathings.init.builder.ferricore_clock;

import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;
import com.direwolf20.justdirethings.client.screens.standardbuttons.ToggleButtonFactory;
import com.direwolf20.justdirethings.client.screens.widgets.NumberButton;
import com.direwolf20.justdirethings.common.network.data.TickSpeedPayload;

import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;

public class FerricoreClockScreen extends BaseMachineScreen<FerricoreClockGUI> {

    public FerricoreClockScreen(FerricoreClockGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

    @Override
    public void init() {
        super.init();
    }

    // @SuppressWarnings("null")
    @Override
    public void addTickSpeedButton() {
        this.addRenderableWidget(ToggleButtonFactory.TICKSPEEDBUTTON(
                this.getLeftPos() + 72,
                this.topSectionTop + 40,
                this.tickSpeed,
                (b) -> {
                    this.tickSpeed = ((NumberButton) b).getValue();
                    ClientPacketDistributor.sendToServer(new TickSpeedPayload(this.tickSpeed),
                            new CustomPacketPayload[0]);
                }));

    }
}