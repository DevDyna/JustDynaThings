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

    public static final DataMapType<Item, FerricoreRepair> FERRICORE_REPAIR = DataMapType.builder(
            ResourceLocation.fromNamespaceAndPath(ID, "anvils/ferricore/repair"),
            Registries.ITEM,
            FerricoreRepair.CODEC).build();

    public static final DataMapType<Block, ThermoHeatSource> THERMO_HEAT_SOURCE = DataMapType.builder(
            ResourceLocation.fromNamespaceAndPath(ID, "thermo/heat_sources"),
            Registries.BLOCK,
            ThermoHeatSource.CODEC).build();

    public static final DataMapType<Fluid, ThermoCoolant> THERMO_COOLANT = DataMapType.builder(
            ResourceLocation.fromNamespaceAndPath(ID, "thermo/coolants"),
            Registries.FLUID,
            ThermoCoolant.CODEC).build();

    @SubscribeEvent
    public static void register(RegisterDataMapTypesEvent event) {
        event.register(FERRICORE_REPAIR);
        event.register(THERMO_HEAT_SOURCE);
        event.register(THERMO_COOLANT);
    }

}
