package com.devdyna.justdynathings.config;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.*;

public class startup {
        private static final ModConfigSpec.Builder qCOMMON = new ModConfigSpec.Builder();

        public static BooleanValue DOC_WARNING;
        public static BooleanValue ENABLE_ALL_JEI_FUELS;

        public static void register(ModContainer c) {
                regStartup();
                c.registerConfig(ModConfig.Type.STARTUP, qCOMMON.build());
        }

        private static void regStartup() {
              modCompat();
        }

        private static void modCompat() {
                qCOMMON.comment("General").push("1-general");
             

                DOC_WARNING = qCOMMON
                                .comment("Disable Documentation warning")
                                .define("disable_doc_warning", false);

                ENABLE_ALL_JEI_FUELS = qCOMMON
                                .comment("Include any fuel item to Generator JEI category")
                                .define("include_any_jei_fuels", true);

                qCOMMON.pop();
        }


     

}