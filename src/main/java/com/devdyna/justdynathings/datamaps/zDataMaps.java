package com.devdyna.justdynathings.datamaps;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.datamaps.records.*;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.datamaps.DataMapType;
import net.neoforged.neoforge.registries.datamaps.RegisterDataMapTypesEvent;

public class zDataMaps {

        public static final DataMapType<Item, FerricoreItemRepair> FERRICORE_REPAIR = DataMapType.builder(
                        ResourceLocation.fromNamespaceAndPath(ID, "anvils/ferricore_repair"),
                        Registries.ITEM,
                        FerricoreItemRepair.CODEC).build();

        public static final DataMapType<Block, ThermoBlockHeatSource> THERMO_HEAT_SOURCE = DataMapType.builder(
                        ResourceLocation.fromNamespaceAndPath(ID, "thermo/heat_sources"),
                        Registries.BLOCK,
                        ThermoBlockHeatSource.CODEC).build();

        public static final DataMapType<Fluid, ThermoFluidCoolant> THERMO_COOLANT = DataMapType.builder(
                        ResourceLocation.fromNamespaceAndPath(ID, "thermo/coolants"),
                        Registries.FLUID,
                        ThermoFluidCoolant.CODEC).build();

        public static final DataMapType<Fluid, BlazeGoldFluidRepair> BLAZEGOLD_FLUID = DataMapType.builder(
                        ResourceLocation.fromNamespaceAndPath(ID, "anvils/blazegold_repair"),
                        Registries.FLUID,
                        BlazeGoldFluidRepair.CODEC).build();

        public static final DataMapType<Fluid, EclipseAlloyFluidRepair> ECLIPSEALLOY_FLUID = DataMapType.builder(
                        ResourceLocation.fromNamespaceAndPath(ID, "anvils/eclipsealloy_repair"),
                        Registries.FLUID,
                        EclipseAlloyFluidRepair.CODEC).build();

        @SubscribeEvent
        public static void register(RegisterDataMapTypesEvent event) {
                event.register(FERRICORE_REPAIR);
                event.register(THERMO_HEAT_SOURCE);
                event.register(THERMO_COOLANT);
                event.register(BLAZEGOLD_FLUID);
                event.register(ECLIPSEALLOY_FLUID);
        }
}
