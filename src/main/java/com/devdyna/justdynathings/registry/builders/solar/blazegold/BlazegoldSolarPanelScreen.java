package com.devdyna.justdynathings.registry.builders.solar.blazegold;

import com.devdyna.justdynathings.registry.builders.solar.SolarBaseScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class BlazegoldSolarPanelScreen extends SolarBaseScreen<BlazegoldSolarPanelGUI> {
    public BlazegoldSolarPanelScreen(BlazegoldSolarPanelGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

}