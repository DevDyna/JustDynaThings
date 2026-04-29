package com.devdyna.justdynathings;

import com.devdyna.justdynathings.init.Material;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(JustDynaThings.MODULE_ID)
public class JustDynaThings {
        public static final String MODULE_ID = "justdynathings";

        public JustDynaThings(IEventBus bus, ModContainer c) {
                Material.register(bus);
                GameEvents.build(bus, c);

                Config.register(c);
        }

}
