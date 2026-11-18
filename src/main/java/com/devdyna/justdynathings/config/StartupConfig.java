package com.devdyna.justdynathings.config;

import com.devdyna.justdynathings.Constants.Tiers;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.*;

public class StartupConfig {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static IntValue FERRICORE_CHISEL_DURABILITY;
    public static IntValue BLAZEGOLD_CHISEL_DURABILITY;
    public static BooleanValue DISABLE_CHISEL_COMPAT;
    public static BooleanValue DISABLE_AE2_WAND_BOUND_COMPAT;
    public static IntValue AE2_WAND_BOUND_TIMESPAN;//TODO maybe it could be more useful server side?

    public static void register(ModContainer c) {

        BUILDER.comment("Chisel 3 Compat (Startup)").push("startup_chisels");

        DISABLE_CHISEL_COMPAT = BUILDER
                .comment("Disable entirely Chisel 3 Compat")
                .define("disable_chisel_compat", false);

        FERRICORE_CHISEL_DURABILITY = BUILDER
                .comment("Ferricore Chisel Durability")
                .defineInRange(Tiers.ferricore + "_chisel_durability", 768, 1,
                        Integer.MAX_VALUE);

        BLAZEGOLD_CHISEL_DURABILITY = BUILDER
                .comment("Blazegold Chisel Durability")
                .defineInRange(Tiers.blazegold + "_chisel_durability", 1024, 1,
                        Integer.MAX_VALUE);

        BUILDER.pop();

        BUILDER.comment("Applied Energistics 2 Compat (Startup)").push("startup_ae2");

        DISABLE_AE2_WAND_BOUND_COMPAT = BUILDER
                .comment("Disable entirely JDT Wand bounding to access points")
                .define("disable_wand_bound", false);

        AE2_WAND_BOUND_TIMESPAN = BUILDER
                .comment("JDT Wand Recharging Timespan")
                .defineInRange("jdt_wands_timespan", 40, 1,
                        Integer.MAX_VALUE);

        

        BUILDER.pop();

        c.registerConfig(ModConfig.Type.STARTUP, BUILDER.build());
    }

}
