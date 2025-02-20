package com.devdyna.justdynathings;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue PHASEBOX_WRENCHABLE = BUILDER
            .comment("Allow to require any wrench to change Phase Box state intend of nothing")
            .define("requireWrench", false);

            public static final ModConfigSpec.IntValue REFORGER_CHANCE = BUILDER
            .comment("Chance to consume reforger catalyst")
            .defineInRange("consumeChance", 50, 1, 99);

    static final ModConfigSpec SPEC = BUILDER.build();

}