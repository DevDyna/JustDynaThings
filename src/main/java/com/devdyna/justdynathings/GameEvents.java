package com.devdyna.justdynathings;

import java.util.List;

import com.devdyna.justdynathings.common.Capability;
import com.devdyna.justdynathings.common.CreativeTabs;
import com.devdyna.justdynathings.common.ItemToolTipped;
import com.devdyna.justdynathings.common.RecipeSender;
import com.devdyna.justdynathings.common.events.ItemAbstractParadox;
import com.devdyna.justdynathings.common.events.ParadoxRecipeExecutor;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;

public class GameEvents {

    public static void build(IEventBus bus, ModContainer c) {

        List.of(
                ParadoxRecipeExecutor.class,
                ItemAbstractParadox.class,
                ItemToolTipped.class,
                RecipeSender.class

        ).forEach(NeoForge.EVENT_BUS::register);

        bus.addListener(Capability::register);
        bus.register(CreativeTabs.class);

    }

}
