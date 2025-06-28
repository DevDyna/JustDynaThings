package com.devdyna.justdynathings.datamaps.records;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record EclipseAlloyFluidRepair(float percentuage) {
    public static final Codec<EclipseAlloyFluidRepair> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.floatRange(0f, 99f).fieldOf("percentuage").forGetter(EclipseAlloyFluidRepair::percentuage))
            .apply(instance, EclipseAlloyFluidRepair::new));
}