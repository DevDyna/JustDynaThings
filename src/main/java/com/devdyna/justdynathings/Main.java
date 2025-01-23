package com.devdyna.justdynathings;

// import com.devdyna.justdynathings.init.Config;
import com.devdyna.justdynathings.init.builder.material;
import com.devdyna.justdynathings.init.builder.tab;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
// import net.neoforged.fml.config.ModConfig;

@Mod(Main.ID)
public class Main {
    public static final String ID = "justdynathings";

    public Main(IEventBus modEventBus, ModContainer modContainer) {
        material.register(modEventBus);
        tab.register(modEventBus);
        // modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        // if (FMLLoader.getDist().isClient()) {
        //     modEventBus.addListener(Client::init);
        // }
    }
}
