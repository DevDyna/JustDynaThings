package com.devdyna.justdynathings;


import com.devdyna.justdynathings.common.Capability;
import com.devdyna.justdynathings.common.CreativeTabs;
import com.devdyna.justdynathings.common.RecipeSender;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;

public class GameEvents {

    public static void build(IEventBus bus, ModContainer c) {

        bus.addListener(Capability::register);
        bus.register(CreativeTabs.class);
        NeoForge.EVENT_BUS.register(RecipeSender.class);

    }

}
