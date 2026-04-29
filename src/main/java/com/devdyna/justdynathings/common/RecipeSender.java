package com.devdyna.justdynathings.common;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.OnDatapackSyncEvent;

public class RecipeSender {
    @SubscribeEvent
    public static void onDatapackSync(OnDatapackSyncEvent event) {
        // if (ModList.get().isLoaded("jei"))
            // event.sendRecipes(zRecipeTypes.QUERN.getType());

    }
}
