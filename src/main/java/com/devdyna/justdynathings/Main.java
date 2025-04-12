package com.devdyna.justdynathings;

import com.devdyna.justdynathings.compat.core;
import com.devdyna.justdynathings.registry.Material;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(Main.ID)
public class Main {
        public static final String ID = "justdynathings";

        // ! Dont use this , intend of utils.LogUtil !
        // public static final Logger LOG = LogUtils.getLogger();

        public Main(IEventBus modEventBus, ModContainer modContainer) {

                Material.register(modEventBus);

                modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

                modEventBus.addListener(Capabilities::regCap);

                core.regCompat(modEventBus);

        }

}
