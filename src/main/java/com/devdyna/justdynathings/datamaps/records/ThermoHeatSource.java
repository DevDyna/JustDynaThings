package com.devdyna.justdynathings.datamaps.records;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record ThermoHeatSource(float heatEfficiency) {
    public static final Codec<ThermoHeatSource> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.FLOAT.fieldOf("heatEfficiency").forGetter(ThermoHeatSource::heatEfficiency)
    ).apply(instance, ThermoHeatSource::new));
}