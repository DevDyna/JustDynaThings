package com.devdyna.justdynathings.datamaps.records;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record FerricoreItemRepair(int durability) {
    public static final Codec<FerricoreItemRepair> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("durability").forGetter(FerricoreItemRepair::durability)
    ).apply(instance, FerricoreItemRepair::new));
}