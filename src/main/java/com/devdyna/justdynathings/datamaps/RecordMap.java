package com.devdyna.justdynathings.datamaps;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public class RecordMap {

    public record FerricoreItemRepair(int durability) {
        public static final Codec<FerricoreItemRepair> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.INT.fieldOf("durability").forGetter(FerricoreItemRepair::durability))
                .apply(instance, FerricoreItemRepair::new));
    }

    public record BlazeGoldFluidRepair(float efficiency) {
        public static final Codec<BlazeGoldFluidRepair> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.FLOAT.fieldOf("efficiency").forGetter(BlazeGoldFluidRepair::efficiency))
                .apply(instance, BlazeGoldFluidRepair::new));
    }

    public record EclipseAlloyFluidRepair(float percentuage) {
        public static final Codec<EclipseAlloyFluidRepair> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.floatRange(0f, 99f).fieldOf("percentuage").forGetter(EclipseAlloyFluidRepair::percentuage))
                .apply(instance, EclipseAlloyFluidRepair::new));
    }

    public record ThermoBlockHeatSource(float heatEfficiency) {
        public static final Codec<ThermoBlockHeatSource> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.FLOAT.fieldOf("heatEfficiency").forGetter(ThermoBlockHeatSource::heatEfficiency))
                .apply(instance, ThermoBlockHeatSource::new));
    }

    public record ThermoFluidCoolant(float coolantEfficiency) {
        public static final Codec<ThermoFluidCoolant> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                Codec.FLOAT.fieldOf("coolantEfficiency").forGetter(ThermoFluidCoolant::coolantEfficiency))
                .apply(instance, ThermoFluidCoolant::new));
    }

}
