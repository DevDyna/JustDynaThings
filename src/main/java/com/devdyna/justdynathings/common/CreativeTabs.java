package com.devdyna.justdynathings.common;

import com.devdyna.cakesticklib.api.CreativeTabUtils;
import com.devdyna.justdynathings.init.types.zItems;
import com.direwolf20.justdirethings.setup.ModSetup;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class CreativeTabs {

    @SubscribeEvent
    public static void register(BuildCreativeModeTabContentsEvent event) {

        if (event.getTabKey() == ModSetup.TAB_JUSTDIRETHINGS.getKey())
            CreativeTabUtils.accept(event, zItems.zWands, zItems.zBlockItem, zItems.zGooUpgraders, zItems.zItem);

    }
}
