package com.devdyna.justdynathings.datamaps.records;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record ThermoCoolant(float coolantEfficiency) {
    public static final Codec<ThermoCoolant> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.FLOAT.fieldOf("coolantEfficiency").forGetter(ThermoCoolant::coolantEfficiency)
    ).apply(instance, ThermoCoolant::new));
}