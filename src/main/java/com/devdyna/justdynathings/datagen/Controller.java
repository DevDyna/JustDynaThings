package com.devdyna.justdynathings.datagen;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.datagen.client.*;
import com.devdyna.justdynathings.datagen.server.*;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = Main.ID)
public class Controller {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent e) {
        DataGenerator g = e.getGenerator();
        PackOutput po = g.getPackOutput();
        ExistingFileHelper f = e.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> pr = e.getLookupProvider();

        // client

        providerGen(e, g, new DataBlockModelState(po, f));
        providerGen(e, g, new DataItemModel(po, f));
        providerGen(e, g, new DataLang(po));

        // server
        DataBlockTag blocktag = new DataBlockTag(po, pr, f);
        providerGen(e, g, blocktag);
        providerGen(e, g, new DataItemTag(po, pr, blocktag.contentsGetter()));
        providerGen(e, g, new LootTableProvider(po, Set.of(), List.of(new LootTableProvider.SubProviderEntry(DataLoot::new, LootContextParamSets.BLOCK)), pr));
        providerGen(e, g, new DataRecipe(po, pr));
        providerGen(e, g, new DataMaps(po, pr));
        providerGen(e, g, new DataFluidTag(po, pr, f));

    }

    private static <T extends DataProvider> void providerGen(GatherDataEvent e, DataGenerator g, T f) {
        g.addProvider(e.includeClient(), f);
    }

}
