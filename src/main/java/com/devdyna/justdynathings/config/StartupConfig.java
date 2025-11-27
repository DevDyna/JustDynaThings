package com.devdyna.justdynathings.config;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.*;

public class StartupConfig {
        private static final ModConfigSpec.Builder qSTARTUP = new ModConfigSpec.Builder();

        public static BooleanValue APPLIEDENERGISTICS2;
        public static BooleanValue EXTENDEDAE;
        public static BooleanValue PHASORITENETWORKS;
        public static BooleanValue GEORE;
        public static BooleanValue CHISEL;

        public static void register(ModContainer c) {
                regStartup();
                c.registerConfig(ModConfig.Type.STARTUP, qSTARTUP.build());
        }

        private static void regStartup() {
                compat();
        }

        private static void compat() {
                qSTARTUP.comment("Compatibility Features").push("1-compat");
                qSTARTUP.comment(
                                "This section is dedicated to override the ModIsLoaded-compat" +
                                                "\nIt can be useful when you dont want some extra features or they cause some issues"+
                                                "\nIt doesn't disable/remove all data-stuff so you need to change that!"+
                                                "\nAll placed compat blocks will be removed and all items will be overriden with useless items!\n");

                APPLIEDENERGISTICS2 = qSTARTUP
                                .comment("Disable AppliedEnergistics2 Compat")
                                .define("disable_ae2", false);

                EXTENDEDAE = qSTARTUP
                                .comment("Disable ExtendedAE Compat")
                                .define("disable_extendedae", false);

                PHASORITENETWORKS = qSTARTUP
                                .comment("Disable PhasoriteNetworks Compat")
                                .define("disable_phasoritenetworks", false);

                GEORE = qSTARTUP
                                .comment("Disable GeOre Compat")
                                .define("disable_geore", false);

                CHISEL = qSTARTUP
                                .comment("Disable Chisel Modern Compat")
                                .define("disable_chisel_modern", false);

                qSTARTUP.pop();
        }

}