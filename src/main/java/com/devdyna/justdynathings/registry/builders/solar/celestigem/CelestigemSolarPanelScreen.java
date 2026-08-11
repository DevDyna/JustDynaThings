package com.devdyna.justdynathings.registry.builders.solar.celestigem;

import com.devdyna.justdynathings.registry.builders.solar.SolarBaseScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class CelestigemSolarPanelScreen extends SolarBaseScreen<CelestigemSolarPanelGUI> {
    public CelestigemSolarPanelScreen(CelestigemSolarPanelGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

}