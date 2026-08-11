package com.devdyna.justdynathings.registry.builders.solar.ferricore;

import com.devdyna.justdynathings.registry.builders.solar.SolarBaseScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class FerricoreSolarPanelScreen extends SolarBaseScreen<FerricoreSolarPanelGUI> {
    public FerricoreSolarPanelScreen(FerricoreSolarPanelGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

    
}