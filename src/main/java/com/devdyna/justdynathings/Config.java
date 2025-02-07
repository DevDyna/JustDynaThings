package com.devdyna.justdynathings;

import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = Main.ID, bus = EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue PHASEBOX_WRENCHABLE = BUILDER
            .comment("Allow to require any wrench to change Phase Box state intend of nothing")
            .define("requireWrench", false);

    public static final ModConfigSpec.IntValue ENERGYGOO_COST_FOOD = BUILDER
            .comment("EnergyGoo cost foreach conversion")
            .defineInRange("fe/block", 200, 0, Integer.MAX_VALUE);

            public static final ModConfigSpec.IntValue REFORGER_CHANCE = BUILDER
            .comment("Chance to consume reforger catalyst")
            .defineInRange("<num>% of consume", 50, 0, Integer.MAX_VALUE);

    static final ModConfigSpec SPEC = BUILDER.build();

}