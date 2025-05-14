package com.devdyna.justdynathings.datagen.server;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
@SuppressWarnings("unused")
public class DataMaps extends DataMapProvider {

    
    private static int BASE_BURN_RATE = 200; // 1 item

    public DataMaps(PackOutput p, CompletableFuture<Provider> l) {
        super(p, l);
    }

    @Override
    protected void gather() {

        // builder(NeoForgeDataMaps.FURNACE_FUELS)
        //         .add(zBlocks.REDSTONE_FUEL.getId(), new FurnaceFuel(BASE_BURN_RATE * 1440), false)
        //         .add(zBlocks.LAPIS_LAZULI_FUEL.getId(), new FurnaceFuel(BASE_BURN_RATE * 480), false)
        //         .add(zItems.REDSTONE_FUEL, new FurnaceFuel(BASE_BURN_RATE * 144), false)
        //         .add(zItems.LAPIS_LAZULI_FUEL, new FurnaceFuel(BASE_BURN_RATE * 48), false);

    }

}
