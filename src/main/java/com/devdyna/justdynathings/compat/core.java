package com.devdyna.justdynathings.compat;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.utils.LogUtil;

import guideme.Guide;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;

public class core {

        public static void regCompat(IEventBus bus) {
                LogUtil.decor(20);
                LogUtil.info("JustDynaThings Compatibility Checker started");
                LogUtil.decor(20);
                core.ae2_compat(bus);
                core.extendedae_compat(bus);
                core.phasorite_compat(bus);
                core.createGuide();
                LogUtil.decor(20);
        }

        private static void ae2_compat(IEventBus bus) {
                LogUtil.info("AppliedEnergistics2" + (Constants.Mods.AE2.check ? " found"
                                : " not found"));
                if (Constants.Mods.AE2.check)
                        com.devdyna.justdynathings.compat.ae2.init.register(bus);
        }

        private static void extendedae_compat(IEventBus bus) {
                LogUtil.info("ExtendedAE" + (Constants.Mods.ExtendedAE.check ? " found"
                                : " not found"));
                if (Constants.Mods.ExtendedAE.check)
                        com.devdyna.justdynathings.compat.extendedae.init.register(bus);
        }

        private static void phasorite_compat(IEventBus bus) {
                LogUtil.info("PhasoriteNetworks"
                                + (Constants.Mods.PhasoriteNetworks.check ? " found"
                                                : " not found"));
                if (Constants.Mods.PhasoriteNetworks.check)
                        com.devdyna.justdynathings.compat.phasorite.init.register(bus);
        }

        private static void createGuide() {

                LogUtil.info("GuideMe"
                                + (Constants.Mods.GuideMe.check ? "found"
                                                : " not found"));
                if (Constants.Mods.GuideMe.check)
                        Guide.builder(ResourceLocation.parse(Main.ID + ":guide")).build();

        }
}
