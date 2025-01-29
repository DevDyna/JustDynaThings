package com.devdyna.justdynathings;

// import com.devdyna.justdynathings.init.Client;
import com.devdyna.justdynathings.init.Material;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
// import net.neoforged.neoforge.common.NeoForge;

@Mod(Main.ID)
public class Main {
    public static final String ID = "justdynathings";

    public Main(IEventBus modEventBus, ModContainer modContainer) {
        Material.register(modEventBus);
        // NeoForge.EVENT_BUS.register(new BlockClick());

        // if (FMLLoader.getDist().isClient()) {
        // NeoForge.EVENT_BUS.register(Client.class);
        // }
    }
}
