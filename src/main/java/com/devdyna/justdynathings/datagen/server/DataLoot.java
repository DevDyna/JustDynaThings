package com.devdyna.justdynathings.datagen.server;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.datagen.server.tables.BlockDrop;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

public class DataLoot extends LootTableProvider {

    public DataLoot(PackOutput o, CompletableFuture<Provider> r) {
        super(o, Set.of(),
                List.of(
                    //list of any loot table entries inside ./server/tables/
                        new LootTableProvider.SubProviderEntry(BlockDrop::new, LootContextParamSets.BLOCK)),
                r);
    }

}
