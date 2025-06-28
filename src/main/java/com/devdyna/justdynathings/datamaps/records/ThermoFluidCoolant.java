package com.devdyna.justdynathings.datamaps.records;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record ThermoFluidCoolant(float coolantEfficiency) {
    public static final Codec<ThermoFluidCoolant> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.FLOAT.fieldOf("coolantEfficiency").forGetter(ThermoFluidCoolant::coolantEfficiency)
    ).apply(instance, ThermoFluidCoolant::new));
}