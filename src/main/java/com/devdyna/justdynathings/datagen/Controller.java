package com.devdyna.justdynathings.datagen;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.datagen.client.*;
import com.devdyna.justdynathings.datagen.server.*;
import com.devdyna.justdynathings.datagen.server.DataAdvancement.DataAdvancementGenerator;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.*;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = MODULE_ID)
public class Controller {
        @SubscribeEvent
        public static void gatherData(GatherDataEvent.Client e) {
                DataGenerator gen = e.getGenerator();
                CompletableFuture<HolderLookup.Provider> provider = e.getLookupProvider();
                var output = gen.getPackOutput();

                // client

                e.addProvider(new DataLang(output));
                e.addProvider(new DataModel(output));

                // server

                e.addProvider(new DataAdvancement(output, provider, List.of(new DataAdvancementGenerator())));

                e.addProvider(new DataBlockTag(output, provider));

                e.addProvider(new LootTableProvider(output, Set.of(),
                                List.of(
                                                new LootTableProvider.SubProviderEntry(DataLootBlock::new,
                                                                LootContextParamSets.BLOCK)),
                                provider));

                e.createProvider(DataRecipe.RecipeRunner::new);

        }

}