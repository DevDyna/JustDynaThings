package com.devdyna.justdynathings.datamaps.records;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record BlazeGoldFluidRepair(float efficiency) {
    public static final Codec<BlazeGoldFluidRepair> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.FLOAT.fieldOf("efficiency").forGetter(BlazeGoldFluidRepair::efficiency)
    ).apply(instance, BlazeGoldFluidRepair::new));
}