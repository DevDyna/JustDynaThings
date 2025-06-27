package com.devdyna.justdynathings.datamaps.records;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record FerricoreRepair(int durability) {
    public static final Codec<FerricoreRepair> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("efficiency").forGetter(FerricoreRepair::durability)
    ).apply(instance, FerricoreRepair::new));
}