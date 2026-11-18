package com.devdyna.justdynathings;

import java.util.List;

import com.devdyna.cakesticklib.api.utils.ModAddonUtil;
import com.devdyna.justdynathings.common.Capability;
import com.devdyna.justdynathings.common.CreativeTabs;
import com.devdyna.justdynathings.common.ItemToolTipped;
import com.devdyna.justdynathings.common.RecipeSender;
import com.devdyna.justdynathings.common.events.*;
import com.devdyna.justdynathings.compat.ae2.AE2Plugin;
import com.devdyna.justdynathings.config.StartupConfig;

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

        if (ModAddonUtil.checkMod("ae2") && !StartupConfig.DISABLE_AE2_WAND_BOUND_COMPAT.get())
            bus.addListener(AE2Plugin::register);

    }

}
