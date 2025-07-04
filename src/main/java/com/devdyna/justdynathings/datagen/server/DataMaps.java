package com.devdyna.justdynathings.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.datamaps.zDataMaps;
import com.devdyna.justdynathings.datamaps.RecordMap.*;
import com.devdyna.justdynathings.registry.types.zFluidTags;
import com.devdyna.justdynathings.registry.types.zItemTags;
import com.devdyna.justdynathings.utils.DataGenUtil;
import com.direwolf20.justdirethings.datagen.JustDireBlockTags;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
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

                // TODO jei integration

                builder(zDataMaps.FERRICORE_REPAIR)
                                .add(Registration.FerricoreIngot.get().builtInRegistryHolder(),
                                                new FerricoreItemRepair(128), false)
                                .add(Items.IRON_INGOT.builtInRegistryHolder(), new FerricoreItemRepair(64), false);

                builder(zDataMaps.THERMO_COOLANT)
                                .add(Fluids.WATER.builtInRegistryHolder(), new ThermoFluidCoolant(1.0f), false)
                                .add(Registration.POLYMORPHIC_FLUID_SOURCE.get().builtInRegistryHolder(),
                                                new ThermoFluidCoolant(2.5f),
                                                false)
                                .add(Registration.TIME_FLUID_SOURCE.get().builtInRegistryHolder(),
                                                new ThermoFluidCoolant(5f), false);

                builder(zDataMaps.THERMO_HEAT_SOURCE)
                                .add(Blocks.MAGMA_BLOCK.builtInRegistryHolder(), new ThermoBlockHeatSource(0.75f),
                                                false)
                                .add(Blocks.LAVA.builtInRegistryHolder(), new ThermoBlockHeatSource(1f), false)
                                .add(Blocks.LAVA_CAULDRON.builtInRegistryHolder(), new ThermoBlockHeatSource(0.99f),
                                                false)
                                .add(Blocks.FIRE.builtInRegistryHolder(), new ThermoBlockHeatSource(0.5f), false)
                                .add(Blocks.SOUL_FIRE.builtInRegistryHolder(), new ThermoBlockHeatSource(0.75f), false)
                                .add(Blocks.CAMPFIRE.builtInRegistryHolder(), new ThermoBlockHeatSource(0.5f), false)
                                .add(Blocks.SOUL_CAMPFIRE.builtInRegistryHolder(), new ThermoBlockHeatSource(0.75f),
                                                false)
                                .add(Registration.CoalBlock_T1.get().builtInRegistryHolder(),
                                                new ThermoBlockHeatSource(2.5f), false)
                                .add(Registration.CoalBlock_T2.get().builtInRegistryHolder(),
                                                new ThermoBlockHeatSource(5.5f), false)
                                .add(Registration.CoalBlock_T3.get().builtInRegistryHolder(),
                                                new ThermoBlockHeatSource(7.5f), false)
                                .add(Registration.CoalBlock_T4.get().builtInRegistryHolder(),
                                                new ThermoBlockHeatSource(10.5f), false);

                builder(zDataMaps.BLAZEGOLD_FLUID)
                                .add(Fluids.LAVA.builtInRegistryHolder(), new BlazeGoldFluidRepair(1.0F), false)
                                .add(Registration.REFINED_T2_FLUID_SOURCE.get().builtInRegistryHolder(),
                                                new BlazeGoldFluidRepair(2.5f),
                                                false)
                                .add(Registration.REFINED_T3_FLUID_SOURCE.get().builtInRegistryHolder(),
                                                new BlazeGoldFluidRepair(5.5f),
                                                false)
                                .add(Registration.REFINED_T4_FLUID_SOURCE.get().builtInRegistryHolder(),
                                                new BlazeGoldFluidRepair(7.5f),
                                                false);

                builder(zDataMaps.ECLIPSEALLOY_FLUID)
                                .add(Registration.TIME_FLUID_SOURCE.get().builtInRegistryHolder(),
                                                new EclipseAlloyFluidRepair(10.0f),
                                                false);

                builder(zDataMaps.REFORGER_oneToMany)
                                .add(Items.DIAMOND.builtInRegistryHolder(),
                                                new ReforgerResult.oneToMany(
                                                                Blocks.STONE.defaultBlockState(),
                                                                Tags.Blocks.ORES_IN_GROUND_STONE, 95),
                                                false)
                                .add(Registration.Celestigem.get().builtInRegistryHolder(),
                                                new ReforgerResult.oneToMany(
                                                                Blocks.STONE.defaultBlockState(),
                                                                Tags.Blocks.ORES_IN_GROUND_STONE, 50),
                                                false);

                builder(zDataMaps.REFORGER_manyToOne)
                                .add(Registration.Coal_T1.get().builtInRegistryHolder(),
                                                new ReforgerResult.manyToOne(
                                                                JustDireBlockTags.CHARCOAL,
                                                                Registration.RawCoal_T1.get().defaultBlockState(), 25),
                                                false);

                builder(zDataMaps.REFORGER_oneToOne)
                                .add(Registration.Coal_T2.get().builtInRegistryHolder(),
                                                new ReforgerResult.oneToOne(
                                                                Registration.RawCoal_T1.get().defaultBlockState(),
                                                                Registration.RawCoal_T2.get().defaultBlockState(), 50),
                                                false)

                                .add(Registration.Coal_T3.get().builtInRegistryHolder(),
                                                new ReforgerResult.oneToOne(
                                                                Registration.RawCoal_T2.get().defaultBlockState(),
                                                                Registration.RawCoal_T3.get().defaultBlockState(), 75),
                                                false)

                                .add(Registration.Coal_T4.get().builtInRegistryHolder(),
                                                new ReforgerResult.oneToOne(
                                                                Registration.RawCoal_T3.get().defaultBlockState(),
                                                                Registration.RawCoal_T4.get().defaultBlockState(), 100),
                                                false);

        }

}
