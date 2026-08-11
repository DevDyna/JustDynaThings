package com.devdyna.justdynathings.registry.builders.solar.eclipsealloy;

import com.devdyna.justdynathings.registry.builders.solar.SolarBaseScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class EclipseAlloySolarPanelScreen extends SolarBaseScreen<EclipseAlloySolarPanelGUI> {
    public EclipseAlloySolarPanelScreen(EclipseAlloySolarPanelGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

}