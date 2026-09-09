package com.devdyna.justdynathings.config;

import com.devdyna.justdynathings.Constants.*;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.*;

public class CommonConfig {
        private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

        public static IntValue CELESTIGEM_CHISEL_FE_CAPACITY;
        public static IntValue CELESTIGEM_CHISEL_FE_COST;

        public static IntValue ECLIPSE_ALLOY_CHISEL_FE_CAPACITY;
        public static IntValue ECLIPSE_ALLOY_CHISEL_FE_COST;

        public static void register(ModContainer c) {
                compats();
                c.registerConfig(ModConfig.Type.COMMON, BUILDER.build());
        }

        private static void compats() {
                BUILDER.comment("Chisel Modern Compat").push("chisels");

                CELESTIGEM_CHISEL_FE_CAPACITY = BUILDER
                                .comment(Config.Display.FE_MAX)
                                .defineInRange(Tiers.celestigem + "_chisel" + Config.Keys.FE_MAX, 1000, 1,
                                                Integer.MAX_VALUE);

                CELESTIGEM_CHISEL_FE_COST = BUILDER
                                .comment(Config.Display.FE_RATE)
                                .defineInRange(Tiers.celestigem + "_chisel" + Config.Keys.FE_RATE, 1, 1,
                                                Integer.MAX_VALUE);

                ECLIPSE_ALLOY_CHISEL_FE_CAPACITY = BUILDER
                                .comment(Config.Display.FE_MAX)
                                .defineInRange(Tiers.eclipsealloy + "_chisel" + Config.Keys.FE_MAX, 10000, 1,
                                                Integer.MAX_VALUE);

                ECLIPSE_ALLOY_CHISEL_FE_COST = BUILDER
                                .comment(Config.Display.FE_RATE)
                                .defineInRange(Tiers.eclipsealloy + "_chisel" + Config.Keys.FE_RATE, 10, 1,
                                                Integer.MAX_VALUE);

        }

}