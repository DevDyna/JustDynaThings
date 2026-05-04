package com.devdyna.justdynathings.common;

import com.devdyna.cakesticklib.api.utils.ModAddonUtil;
import com.devdyna.justdynathings.init.types.zRecipeTypes;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;

public class RecipeSender {
    @SubscribeEvent
    public static void onDatapackSync(OnDatapackSyncEvent event) {
        if (ModAddonUtil.checkMod("jei")) {
            event.sendRecipes(zRecipeTypes.FERRICORE_ANVIL.getType());
            event.sendRecipes(zRecipeTypes.BLAZEGOLD_ANVIL.getType());
            event.sendRecipes(zRecipeTypes.ECLIPSEALLOY_ANVIL.getType());

        }

    }
}
