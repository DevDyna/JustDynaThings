package com.devdyna.justdynathings.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.registry.types.Items;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

public class DataMaps extends DataMapProvider {

    private static int BASE_BURN_RATE = 200;    //1 item

    public DataMaps(PackOutput p, CompletableFuture<Provider> l) {
        super(p, l);
    }

    @Override
    protected void gather() {

        builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(Items.BIOFUEL, new FurnaceFuel(BASE_BURN_RATE*6), false);

    }

}
