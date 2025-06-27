package com.devdyna.justdynathings.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.datamaps.zDataMaps;
import com.devdyna.justdynathings.datamaps.records.*;
import com.devdyna.justdynathings.registry.types.zFluidTags;
import com.devdyna.justdynathings.registry.types.zItemTags;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.fluids.FluidStack;

@SuppressWarnings("unused")
public class DataMaps extends DataMapProvider {

    private static int BASE_BURN_RATE = 200; // 1 item

    public DataMaps(PackOutput p, CompletableFuture<Provider> l) {
        super(p, l);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void gather() {

        builder(zDataMaps.FERRICORE_REPAIR)
                .add(Registration.FerricoreIngot.get().builtInRegistryHolder(), new FerricoreRepair(128), false)
                .add(Items.IRON_INGOT.builtInRegistryHolder(), new FerricoreRepair(64), false);

    }

}
