package com.devdyna.justdynathings.client.jei.datamaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.devdyna.justdynathings.datamaps.zDataMaps;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class records {

    public record FerricoreItemRepair(Item item, int durability) {
        public static List<FerricoreItemRepair> get() {
            List<FerricoreItemRepair> result = new ArrayList<>();

            for (var entry : BuiltInRegistries.ITEM.getDataMap(zDataMaps.FERRICORE_REPAIR).entrySet()) {

                var item = BuiltInRegistries.ITEM.get(entry.getKey().location());

                result.add(new FerricoreItemRepair(
                        item, entry.getValue().durability()));
            }
            result.sort(Comparator.comparingInt(p -> p.durability));
            return result;
        }
    }

    public record BlazeGoldFluidRepair(Fluid fluid, float efficiency) {
        public static List<BlazeGoldFluidRepair> get() {
            List<BlazeGoldFluidRepair> result = new ArrayList<>();

            for (var entry : BuiltInRegistries.FLUID.getDataMap(zDataMaps.BLAZEGOLD_FLUID).entrySet()) {

                var fluid = BuiltInRegistries.FLUID.get(entry.getKey().location());

                if (!fluid.isSource(fluid.defaultFluidState()))
                    continue;

                result.add(new BlazeGoldFluidRepair(
                        fluid, entry.getValue().efficiency()));
            }
            result.sort(Comparator.comparingDouble(p -> p.efficiency));
            return result;
        }
    }

    public record EclipseAlloyFluidRepair(Fluid fluid, float percentuage) {
        public static List<EclipseAlloyFluidRepair> get() {
            List<EclipseAlloyFluidRepair> result = new ArrayList<>();

            for (var entry : BuiltInRegistries.FLUID.getDataMap(zDataMaps.ECLIPSEALLOY_FLUID).entrySet()) {

                var fluid = BuiltInRegistries.FLUID.get(entry.getKey().location());

                if (!fluid.isSource(fluid.defaultFluidState()))
                    continue;

                result.add(new EclipseAlloyFluidRepair(
                        fluid, entry.getValue().percentuage()));
            }
            result.sort(Comparator.comparingDouble(p -> p.percentuage));
            return result;
        }
    }

    public record ThermoBlockHeatSource(Block block, float heatEfficiency) {
        public static List<ThermoBlockHeatSource> get() {
            List<ThermoBlockHeatSource> result = new ArrayList<>();

            for (var entry : BuiltInRegistries.BLOCK.getDataMap(zDataMaps.THERMO_HEAT_SOURCE).entrySet()) {

                var block = BuiltInRegistries.BLOCK.get(entry.getKey().location());

                result.add(new ThermoBlockHeatSource(
                        block, entry.getValue().heatEfficiency()));
            }
            result.sort(Comparator.comparingDouble(p -> p.heatEfficiency));
            return result;
        }
    }

    public record ThermoFluidCoolant(Fluid fluid, float coolantEfficiency) {
        public static List<ThermoFluidCoolant> get() {
            List<ThermoFluidCoolant> result = new ArrayList<>();

            for (var entry : BuiltInRegistries.FLUID.getDataMap(zDataMaps.THERMO_COOLANT).entrySet()) {

                var fluid = BuiltInRegistries.FLUID.get(entry.getKey().location());

                if (!fluid.isSource(fluid.defaultFluidState()))
                    continue;

                result.add(new ThermoFluidCoolant(
                        fluid, entry.getValue().coolantEfficiency()));
            }
            result.sort(Comparator.comparingDouble(p -> p.coolantEfficiency));
            return result;
        }
    }

    // TODO REFORGER

}
