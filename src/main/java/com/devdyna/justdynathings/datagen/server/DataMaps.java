package com.devdyna.justdynathings.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.datamaps.zDataMaps;
import com.devdyna.justdynathings.datamaps.records.*;
import com.devdyna.justdynathings.registry.types.zFluidTags;
import com.devdyna.justdynathings.registry.types.zItemTags;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.Tags;
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

        // TODO expand
        builder(zDataMaps.THERMO_COOLANT)
                .add(Fluids.WATER.builtInRegistryHolder(), new ThermoCoolant(1), false)
                .add(Registration.REFINED_T2_FLUID_SOURCE.get().builtInRegistryHolder(), new ThermoCoolant(1.2f),
                        false)
                .add(Registration.REFINED_T3_FLUID_SOURCE.get().builtInRegistryHolder(), new ThermoCoolant(2.5f),
                        false)
                .add(Registration.REFINED_T4_FLUID_SOURCE.get().builtInRegistryHolder(), new ThermoCoolant(7.5f),
                        false)
                .add(Registration.POLYMORPHIC_FLUID_SOURCE.get().builtInRegistryHolder(), new ThermoCoolant(12.5f),
                        false)
                .add(Registration.TIME_FLUID_SOURCE.get().builtInRegistryHolder(), new ThermoCoolant(15f), false);

        builder(zDataMaps.THERMO_HEAT_SOURCE)
                .add(Blocks.MAGMA_BLOCK.builtInRegistryHolder(), new ThermoHeatSource(0.75f), false)
                .add(Blocks.LAVA.builtInRegistryHolder(), new ThermoHeatSource(1f), false)
                .add(Blocks.LAVA_CAULDRON.builtInRegistryHolder(), new ThermoHeatSource(0.99f), false)
                .add(Blocks.FIRE.builtInRegistryHolder(), new ThermoHeatSource(0.5f), false)
                .add(Blocks.SOUL_FIRE.builtInRegistryHolder(), new ThermoHeatSource(0.75f), false)
                .add(Blocks.CAMPFIRE.builtInRegistryHolder(), new ThermoHeatSource(0.5f), false)
                .add(Blocks.SOUL_CAMPFIRE.builtInRegistryHolder(), new ThermoHeatSource(0.75f), false);

    }

}
