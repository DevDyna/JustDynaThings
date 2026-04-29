package com.devdyna.justdynathings.datagen.server;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;

public class DataAdvancement extends AdvancementProvider {

        public DataAdvancement(PackOutput output, CompletableFuture<Provider> registries,
                        List<AdvancementSubProvider> subProviders) {
                super(output, registries, subProviders);
        }

        public static class DataAdvancementGenerator implements AdvancementSubProvider {

                @SuppressWarnings("unused")
                @Override
                public void generate(Provider p, Consumer<AdvancementHolder> c) {

                        // var quern = AdvancementsUtils
                        //                 .getExistingParent("minecraft:story/mine_stone", zBlocks.QUERN.get(),
                        //                                 MODULE_ID, "quern",
                        //                                 AdvancementType.TASK, true, true, false)
                        //                 .addCriterion("craft_quern",
                        //                                 InventoryChangeTrigger.TriggerInstance
                        //                                                 .hasItems(zBlocks.QUERN.get()))
                        //                 .requirements(AdvancementRequirements.allOf(List.of("craft_quern")))
                        //                 .save(c, MODULE_ID + ":extend/story/mine_stone/quern");

                }

        }

}
