package com.devdyna.justdynathings.compat;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.utils.LogUtil;

import guideme.Guide;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;

public class compat {

        public static void core(IEventBus bus) {
                LogUtil.decor(20);
                LogUtil.info("JustDynaThings Compatibility Checker started");
                LogUtil.decor(20);
                ae2_compat(bus);
                extendedae_compat(bus);
                phasorite_compat(bus);
                createGuide();
                LogUtil.decor(20);
        }

        private static void ae2_compat(IEventBus bus) {
                LogUtil.info("AppliedEnergistics2"
                                + (Constants.ModAddonCheck.AppliedEnergistics2 ? " found " : " not found "));
                if (Constants.ModAddonCheck.AppliedEnergistics2)
                        com.devdyna.justdynathings.compat.ae2.init.register(bus);

        }

        private static void extendedae_compat(IEventBus bus) {
                LogUtil.info("ExtendedAE" + (Constants.ModAddonCheck.ExtendedAE ? " found " : " not found "));
                if (Constants.ModAddonCheck.ExtendedAE)
                        com.devdyna.justdynathings.compat.extendedae.init.register(bus);

        }

        private static void phasorite_compat(IEventBus bus) {
                LogUtil.info("PhasoriteNetworks"
                                + (Constants.ModAddonCheck.PhasoriteNetworks ? " found " : " not found "));
                if (Constants.ModAddonCheck.PhasoriteNetworks)
                        com.devdyna.justdynathings.compat.phasorite.init.register(bus);

        }

        private static void createGuide() {

                LogUtil.info("GuideMe"
                                + (Constants.ModAddonCheck.GuideMe ? " found" : " not found"));
                if (Constants.ModAddonCheck.GuideMe)
                        Guide.builder(ResourceLocation.parse(Main.ID + ":guide")).build();

        }

}
