package com.devdyna.justdynathings.client.factory.clock;

import com.devdyna.justdynathings.client.core.FactoryButtons;
import com.devdyna.justdynathings.utils.DirectionUtil;
import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;
import com.direwolf20.justdirethings.client.screens.standardbuttons.ToggleButtonFactory;
import com.direwolf20.justdirethings.client.screens.widgets.NumberButton;
import com.direwolf20.justdirethings.common.network.data.TickSpeedPayload;

import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.neoforge.network.PacketDistributor;

public class ClockScreen extends BaseMachineScreen<ClockGUI> {
    public ClockScreen(ClockGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

    @Override
    public void init() {
        super.init();
    }

    @SuppressWarnings("null")
    @Override
    public void addTickSpeedButton() {
        this.addRenderableWidget(ToggleButtonFactory.TICKSPEEDBUTTON(
                this.getGuiLeft() + 72,
                this.topSectionTop + 40,
                this.tickSpeed,
                (b) -> {
                    this.tickSpeed = ((NumberButton) b).getValue();
                    PacketDistributor.sendToServer(new TickSpeedPayload(this.tickSpeed),
                            new CustomPacketPayload[0]);
                }));

        for (Direction d : DirectionUtil.ALL)
            this.addRenderableWidget(
                    FactoryButtons.SIDE(
                            this.getGuiLeft() +
                                    102,
                            this.topSectionTop
                                    + 60,
                            true,
                            d,
                            (b) -> {
                                // need to be payloaded , now it dont work
                                this.baseMachineBE.getLevel().setBlockAndUpdate(this.baseMachineBE.getBlockPos(),
                                        this.baseMachineBE.getBlockState()
                                                .setValue(
                                                        DirectionUtil.face[DirectionUtil.indexByDir(d)],
                                                        !b.active));
                            }));
    }
}