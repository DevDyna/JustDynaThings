package com.devdyna.justdynathings.config;

import com.devdyna.justdynathings.Constants.Tiers;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.IntValue;

public class StartupConfig {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static IntValue FERRICORE_CHISEL_DURABILITY;
    public static IntValue BLAZEGOLD_CHISEL_DURABILITY;

    public static void register(ModContainer c) {

        BUILDER.comment("Chisel 3 Compat (Startup)").push("startup_chisels");

        FERRICORE_CHISEL_DURABILITY = BUILDER
                .comment("Ferricore Chisel Durability")
                .defineInRange(Tiers.ferricore + "_chisel_durability", 768, 1,
                        Integer.MAX_VALUE);

        BLAZEGOLD_CHISEL_DURABILITY = BUILDER
                .comment("Blazegold Chisel Durability")
                .defineInRange(Tiers.blazegold + "_chisel_durability", 1024, 1,
                        Integer.MAX_VALUE);

        BUILDER.pop();

        c.registerConfig(ModConfig.Type.STARTUP, BUILDER.build());
    }


}
