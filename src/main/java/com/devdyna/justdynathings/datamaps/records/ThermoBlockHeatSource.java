package com.devdyna.justdynathings.datamaps.records;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record ThermoBlockHeatSource(float heatEfficiency) {
    public static final Codec<ThermoBlockHeatSource> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.FLOAT.fieldOf("heatEfficiency").forGetter(ThermoBlockHeatSource::heatEfficiency)
    ).apply(instance, ThermoBlockHeatSource::new));
}