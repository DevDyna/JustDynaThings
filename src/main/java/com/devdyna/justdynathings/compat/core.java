package com.devdyna.justdynathings.compat;

import static com.devdyna.justdynathings.Main.LOG;
import com.devdyna.justdynathings.Constants;

import net.neoforged.bus.api.IEventBus;

public class core {
    public static void ae2_compat(IEventBus bus) {
        LOG.info("AppliedEnergistics2" + (Constants.Mods.AE2.check ? " found -> adding compat features"
                : " not found -> skipping"));
        if (Constants.Mods.AE2.check)
            com.devdyna.justdynathings.compat.ae2.init.register(bus);
    }

    public static void extendedae_compat(IEventBus bus) {
        LOG.info("ExtendedAE" + (Constants.Mods.ExtendedAE.check ? " found -> adding compat features"
                : " not found -> skipping"));
        if (Constants.Mods.ExtendedAE.check)
            com.devdyna.justdynathings.compat.extendedae.init.register(bus);
    }

    public static void phasorite_compat(IEventBus bus) {
        LOG.info("PhasoriteNetworks"
                + (Constants.Mods.PhasoriteNetworks.check ? " found -> adding compat features"
                        : " not found -> skipping"));
        if (Constants.Mods.PhasoriteNetworks.check)
            com.devdyna.justdynathings.compat.phasorite.init.register(bus);
    }
}
