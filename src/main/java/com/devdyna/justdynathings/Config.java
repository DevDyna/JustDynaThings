package com.devdyna.justdynathings;

import com.devdyna.justdynathings.utils.DataGenUtil;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.*;

public class Config {
        private static final ModConfigSpec.Builder qCOMMON = new ModConfigSpec.Builder();

        // TODO rework config logic

        public static BooleanValue GUIDEME_WARNING;

        public static BooleanValue PHASE_BOX_WRENCHABLE;

        public static IntValue REFORGER_CHANCE;

        public static BooleanValue FERRICORE_CLOCK_WRENCHABLE;

        public static IntValue REVITALIZER_FE_CAPACITY;
        public static IntValue REVITALIZER_FE_COST;
        public static BooleanValue REVITALIZER_TOGGLE_SOUND;
        public static IntValue REVITALIZER_CHANCE_FE_COST;

        public static IntValue THERMOGEN_FE_CAPACITY;
        public static IntValue THERMOGEN_MB_CAPACITY;
        public static IntValue THERMOGEN_MB_COST;
        public static IntValue THERMOGEN_FE_ONLY_HEATED;
        public static IntValue THERMOGEN_FE_WITH_COOLANT;
        public static BooleanValue THERMOGEN_REQUIRE_COOLANT;

        public static BooleanValue BLACKHOLE_KEEP_STORAGE;
        public static IntValue BLACKHOLE_FE_CAPACITY;
        public static IntValue BLACKHOLE_FE_COST;
        public static IntValue BLACKHOLE_MB_CAPACITY;
        public static IntValue BLACKHOLE_MB_COST;

        public static IntValue BUDDING_GENERAL_MB_CAPACITY;
        public static IntValue BUDDING_GENERAL_MB_COST;
        public static IntValue BUDDING_GENERAL_FE_CAPACITY;
        public static IntValue BUDDING_GENERAL_FE_COST;
        public static BooleanValue BUDDING_GENERAL_FE_CHANCE;
        public static BooleanValue BUDDING_GENERAL_MB_CHANCE;
        public static BooleanValue BUDDING_GENERAL_SOUND;

        public static BooleanValue GOO_CREATIVE_SOUND_TOGGLE_STATE;
        public static IntValue GOO_CREATIVE_TIER;
        public static IntValue GOO_CREATIVE_COUNTER_REDUCER;
        public static BooleanValue GOO_CREATIVE_SOUND_RECIPE;

        public static IntValue GOO_FEGOO_FE_CAPACITY;
        public static IntValue GOO_FEGOO_FE_RATE;
        public static BooleanValue GOO_FEGOO_FE_CAPACITY_MULTIPLY;
        public static BooleanValue GOO_FEGOO_FE_RATE_MULTIPLY;
        public static BooleanValue GOO_FEGOO_SOUND_RECIPE;
        public static BooleanValue GOO_FEGOO_SOUND_EXTRA;

        public static IntValue GOO_ENERGY_TIER;
        public static IntValue GOO_ENERGY_COUNTER_REDUCER;

        public static IntValue GOO_T1_TIER;
        public static IntValue GOO_T1_COUNTER_REDUCER;

        public static IntValue GOO_T2_TIER;
        public static IntValue GOO_T2_COUNTER_REDUCER;

        public static IntValue GOO_T3_TIER;
        public static IntValue GOO_T3_COUNTER_REDUCER;

        public static IntValue GOO_T4_TIER;
        public static IntValue GOO_T4_COUNTER_REDUCER;

        public static IntValue SOLARPANEL_FERRICORE_FE_CAPACITY;
        public static IntValue SOLARPANEL_FERRICORE_FE_RATE;
        public static BooleanValue SOLARPANEL_FERRICORE_ENABLE_YLEVEL;
        public static BooleanValue SOLARPANEL_FERRICORE_ENABLE_SPAM;
        public static BooleanValue SOLARPANEL_FERRICORE_CONDITIONS_OVERRIDE;

        public static IntValue SOLARPANEL_BLAZEGOLD_FE_CAPACITY;
        public static IntValue SOLARPANEL_BLAZEGOLD_FE_RATE;
        public static BooleanValue SOLARPANEL_BLAZEGOLD_ENABLE_YLEVEL;
        public static BooleanValue SOLARPANEL_BLAZEGOLD_ENABLE_SPAM;
        public static BooleanValue SOLARPANEL_BLAZEGOLD_CONDITIONS_OVERRIDE;

        public static IntValue SOLARPANEL_CELESTIGEM_FE_CAPACITY;
        public static IntValue SOLARPANEL_CELESTIGEM_FE_RATE;
        public static BooleanValue SOLARPANEL_CELESTIGEM_ENABLE_YLEVEL;
        public static BooleanValue SOLARPANEL_CELESTIGEM_ENABLE_SPAM;
        public static BooleanValue SOLARPANEL_CELESTIGEM_CONDITIONS_OVERRIDE;

        public static IntValue SOLARPANEL_ECLIPSEALLOY_FE_CAPACITY;
        public static IntValue SOLARPANEL_ECLIPSEALLOY_FE_RATE;
        public static BooleanValue SOLARPANEL_ECLIPSEALLOY_ENABLE_YLEVEL;
        public static BooleanValue SOLARPANEL_ECLIPSEALLOY_ENABLE_SPAM;
        public static BooleanValue SOLARPANEL_ECLIPSEALLOY_CONDITIONS_OVERRIDE;

        public static BooleanValue ANVILS_SOUND_EVENT;

        public static IntValue ANVILS_FERRICORE_ITEM_COOLDOWN;
        public static BooleanValue ANVIL_FERRICORE_SOUND_EVENT;

        public static IntValue ANVILS_BLAZEGOLD_MB_RATE;
        public static IntValue ANVILS_BLAZEGOLD_MB_CAPACITY;
        public static BooleanValue ANVIL_BLAZEGOLD_SOUND_EVENT;

        public static IntValue ANVILS_CELESTIGEM_FE_RATE;
        public static IntValue ANVILS_CELESTIGEM_FE_CAPACITY;
        public static BooleanValue ANVIL_CELESTIGEM_SOUND_EVENT;

        public static IntValue ANVILS_ECLIPSEALLOY_MB_RATE;
        public static IntValue ANVILS_ECLIPSEALLOY_MB_CAPACITY;
        public static IntValue ANVILS_ECLIPSEALLOY_FE_RATE;
        public static IntValue ANVILS_ECLIPSEALLOY_FE_CAPACITY;
        public static IntValue ANVILS_ECLIPSEALLOY_DAMAGE_LIMIT;
        public static IntValue ANVILS_ECLIPSEALLOY_DAMAGE_PERCENTUAGE;
        public static BooleanValue ANVIL_ECLIPSEALLOY_SOUND_EVENT;

        public static void register(ModContainer c) {
                regCommon();
                c.registerConfig(ModConfig.Type.COMMON, qCOMMON.build());
        }

        private static void regCommon() {
                general();
                blocks();
                budding();
                goo();
                solar_panel();
                anvil();
        }

        private static void general() {
                qCOMMON.comment("General").push("1-general");

                GUIDEME_WARNING = qCOMMON
                                .comment("Disable GuideMe warning")
                                .define("disable_guideme_warning", false);

                superduperconfig();
                qCOMMON.pop();
        }

        private static void blocks() {
                qCOMMON.comment("Blocks").push("2-blocks");
                qCOMMON.comment(DataGenUtil.txtDecor(Constants.Blocks.PhaseBox));

                PHASE_BOX_WRENCHABLE = qCOMMON
                                .comment("Require any wrench to change Phase Box state intend of nothing")
                                .define("phasebox_requireWrench", false);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.Blocks.Reforger));

                REFORGER_CHANCE = qCOMMON
                                .comment("Chance to consume reforger catalyst")
                                .defineInRange("consumeChance", 50, 1, 99);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.Blocks.FerricoreClock));

                FERRICORE_CLOCK_WRENCHABLE = qCOMMON
                                .comment("Require any wrench to change Ferricore Clock face state intend of nothing")
                                .define("ferricoreclock_requireWrench", false);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.Blocks.Revitalizer));

                REVITALIZER_FE_CAPACITY = qCOMMON
                                .comment("Total FE Capacity")
                                .defineInRange("revitalizer_maxFE", 10000, 1, Integer.MAX_VALUE);
                REVITALIZER_FE_COST = qCOMMON
                                .comment("FE/t cost")
                                .defineInRange("revitalizer_FErate", 1000, 1, Integer.MAX_VALUE);
                REVITALIZER_TOGGLE_SOUND = qCOMMON
                                .comment("Enable/Disable sound when revitalized a goo")
                                .define("revitalizer_sound", true);
                REVITALIZER_CHANCE_FE_COST = qCOMMON
                                .comment("Chance to apply FE cost when revitalized a goo")
                                .defineInRange("revitalizer_cost_chance", 50, 1, 100);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.Blocks.ThermoGen));

                THERMOGEN_REQUIRE_COOLANT = qCOMMON.comment("Require a fluid coolant to generate FE")
                                .define("thermogen_coolant_to_fe", false);
                THERMOGEN_FE_CAPACITY = qCOMMON
                                .comment("Total FE Capacity")
                                .defineInRange("thermogen_maxfe", 1000000, 1, Integer.MAX_VALUE);
                THERMOGEN_MB_CAPACITY = qCOMMON
                                .comment("Total Coolant Capacity")
                                .defineInRange("thermogen_maxmb", 100000, 1, Integer.MAX_VALUE);
                THERMOGEN_MB_COST = qCOMMON
                                .comment("MB/t Coolant cost")
                                .defineInRange("thermogen_mbrate", 1, 1, Integer.MAX_VALUE);
                THERMOGEN_FE_ONLY_HEATED = qCOMMON
                                .comment("FE/t generated without a coolant")
                                .defineInRange("thermogen_not_cool", 270, 1, Integer.MAX_VALUE);
                THERMOGEN_FE_WITH_COOLANT = qCOMMON
                                .comment("FE/t generated with a coolant")
                                .defineInRange("thermogen_very_cool", 1620, 1, Integer.MAX_VALUE);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.Blocks.BlackHole));

                BLACKHOLE_KEEP_STORAGE = qCOMMON.comment("Keep stored stuff when redstone disable it")
                                .define("blackhole_keep", true);
                BLACKHOLE_FE_CAPACITY = qCOMMON
                                .comment("Total FE Capacity")
                                .defineInRange("blackhole_maxfe", Integer.MAX_VALUE, 1, Integer.MAX_VALUE);
                BLACKHOLE_FE_COST = qCOMMON
                                .comment("FE/t cost")
                                .defineInRange("blackhole_ferate", Integer.MAX_VALUE, 1, Integer.MAX_VALUE);
                BLACKHOLE_MB_CAPACITY = qCOMMON
                                .comment("Total Fluid Capacity")
                                .defineInRange("blackhole_maxmb", Integer.MAX_VALUE, 1, Integer.MAX_VALUE);
                BLACKHOLE_MB_COST = qCOMMON
                                .comment("MB/t cost")
                                .defineInRange("blackhole_mbrate", Integer.MAX_VALUE, 1, Integer.MAX_VALUE);

                qCOMMON.pop();
        }

        private static void budding() {
                qCOMMON.comment(DataGenUtil.txtDecor(Constants.BuddingType)).push("3-" + Constants.BuddingType);
                qCOMMON.comment("general_" + Constants.BuddingType);

                BUDDING_GENERAL_MB_CAPACITY = qCOMMON
                                .comment("MB Capacity")
                                .defineInRange("budding_general_maxmb", 10000, 1, Integer.MAX_VALUE);
                BUDDING_GENERAL_MB_COST = qCOMMON
                                .comment("MB/t cost")
                                .defineInRange("budding_general_mbrate", 100, 1, Integer.MAX_VALUE);
                BUDDING_GENERAL_FE_CAPACITY = qCOMMON
                                .comment("FE Capacity")
                                .defineInRange("budding_general_maxfe", 10000, 1, Integer.MAX_VALUE);
                BUDDING_GENERAL_FE_COST = qCOMMON
                                .comment("FE/t cost")
                                .defineInRange("budding_general_ferate", 100, 1, Integer.MAX_VALUE);

                BUDDING_GENERAL_FE_CHANCE = qCOMMON.comment("Chance to apply FE cost when a cluster will grow")
                                .define("budding_general_fechance", true);
                BUDDING_GENERAL_MB_CHANCE = qCOMMON.comment("Chance to apply MB cost when a cluster will grow")
                                .define("budding_general_mbchance", true);

                BUDDING_GENERAL_SOUND = qCOMMON.comment("Enable/Disable sound of buddings when grow")
                                .define("budding_general_sound", true);
                qCOMMON.pop();
        }

        private static void goo() {
                qCOMMON.comment(DataGenUtil.txtDecor(Constants.GooType)).push("4-" + Constants.GooType);
                qCOMMON.comment(DataGenUtil.txtDecor(Constants.Goo.Creative));

                GOO_CREATIVE_SOUND_TOGGLE_STATE = qCOMMON.comment("Enable/Disable sound on goo state change")
                                .define("goo_creative_sound_state", true);
                GOO_CREATIVE_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange("goo_creative_tier", Integer.MAX_VALUE, 1, Integer.MAX_VALUE);
                GOO_CREATIVE_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange("goo_creative_counter_reducer", Integer.MAX_VALUE, 1, Integer.MAX_VALUE);
                GOO_CREATIVE_SOUND_RECIPE = qCOMMON.comment("Enable/Disable sound on goo recipe execution")
                                .define("goo_creative_sound_recipe", true);

                qCOMMON.comment("Generic FE Goo powered");

                GOO_FEGOO_FE_CAPACITY = qCOMMON
                                .comment("Max FE capacity")
                                .defineInRange("goo_fegoo_maxfe", 10000, 1, Integer.MAX_VALUE);
                GOO_FEGOO_FE_RATE = qCOMMON
                                .comment("FE/t cost")
                                .defineInRange("goo_fegoo_ferate", 100, 1, Integer.MAX_VALUE);
                GOO_FEGOO_FE_CAPACITY_MULTIPLY = qCOMMON.comment("Enable/Disable tier capacity multiplier")
                                .define("goo_fegoo_maxfe_multiply", true);
                GOO_FEGOO_FE_RATE_MULTIPLY = qCOMMON.comment("Enable/Disable tier capacity multiplier")
                                .define("goo_fegoo_ferate_multiply", true);
                GOO_FEGOO_SOUND_RECIPE = qCOMMON.comment("Enable/Disable sound on goo recipe execution")
                                .define("goo_fegoo_sound_recipe", true);
                GOO_FEGOO_SOUND_EXTRA = qCOMMON.comment("Enable/Disable sound on goo recipe execution randomly")
                                .define("goo_fegoo_sound_extra", true);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.Goo.Energized));

                GOO_ENERGY_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange("goo_energized_tier", 5, 1, Integer.MAX_VALUE);
                GOO_ENERGY_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange("goo_energized_counter_reducer", 15, 1, Integer.MAX_VALUE);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.Goo.T1));

                GOO_T1_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange("goo_charged_primogel_tier", 1, 1, Integer.MAX_VALUE);
                GOO_T1_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange("goo_charged_primogel_counter_reducer", 15, 1, Integer.MAX_VALUE);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.Goo.T2));

                GOO_T2_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange("goo_charged_blazebloom_tier", 2, 1, Integer.MAX_VALUE);
                GOO_T2_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange("goo_charged_blazebloom_counter_reducer", 15, 1, Integer.MAX_VALUE);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.Goo.T3));

                GOO_T3_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange("goo_charged_voidshimmer_tier", 3, 1, Integer.MAX_VALUE);
                GOO_T3_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange("goo_charged_voidshimmer_counter_reducer", 15, 1, Integer.MAX_VALUE);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.Goo.T4));

                GOO_T4_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange("goo_charged_shadowpulse_tier", 4, 1, Integer.MAX_VALUE);
                GOO_T4_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange("goo_charged_shadowpulse_counter_reducer", 15, 1, Integer.MAX_VALUE);

                qCOMMON.pop();
        }

        private static void solar_panel() {
                qCOMMON.comment(DataGenUtil.txtDecor(Constants.SolarPanelType)).push("5-" + Constants.SolarPanelType);
                qCOMMON.comment(DataGenUtil.txtDecor(Constants.SolarPanel.t1));

                SOLARPANEL_FERRICORE_FE_CAPACITY = qCOMMON
                                .comment("FE Capacity")
                                .defineInRange("solar_ferricore_maxfe", 10000, 1, Integer.MAX_VALUE);
                SOLARPANEL_FERRICORE_FE_RATE = qCOMMON
                                .comment("FE/t production")
                                .defineInRange("solar_ferricore_ferate", 240, 1, Integer.MAX_VALUE);
                SOLARPANEL_FERRICORE_ENABLE_YLEVEL = qCOMMON
                                .comment("Enable/Disable Y-Level multiplier to reduce FE gen based on Y")
                                .define("solar_ferricore_ylevel", false);
                SOLARPANEL_FERRICORE_ENABLE_SPAM = qCOMMON
                                .comment("Enable/Disable Solar-Spam multiplier to reduce FE gen based on cheap prices")
                                .define("solar_ferricore_spam", false);
                SOLARPANEL_FERRICORE_CONDITIONS_OVERRIDE = qCOMMON
                                .comment("Enable/Disable the entire system of conditions to keep active forever")
                                .define("solar_ferricore_override", false);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.SolarPanel.t2));

                SOLARPANEL_BLAZEGOLD_FE_CAPACITY = qCOMMON
                                .comment("FE Capacity")
                                .defineInRange("solar_blazegold_maxfe", 100000, 1, Integer.MAX_VALUE);
                SOLARPANEL_BLAZEGOLD_FE_RATE = qCOMMON
                                .comment("FE/t production")
                                .defineInRange("solar_blazegold_ferate", 960, 1, Integer.MAX_VALUE);
                SOLARPANEL_BLAZEGOLD_ENABLE_YLEVEL = qCOMMON
                                .comment("Enable/Disable Y-Level multiplier to reduce FE gen based on Y")
                                .define("solar_blazegold_ylevel", false);
                SOLARPANEL_BLAZEGOLD_ENABLE_SPAM = qCOMMON
                                .comment("Enable/Disable Solar-Spam multiplier to reduce FE gen based on cheap prices")
                                .define("solar_blazegold_spam", false);
                SOLARPANEL_BLAZEGOLD_CONDITIONS_OVERRIDE = qCOMMON
                                .comment("Enable/Disable the entire system of conditions to keep active forever")
                                .define("solar_blazegold_override", false);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.SolarPanel.t3));

                SOLARPANEL_CELESTIGEM_FE_CAPACITY = qCOMMON
                                .comment("FE Capacity")
                                .defineInRange("solar_celestigem_maxfe", 100000, 1, Integer.MAX_VALUE);
                SOLARPANEL_CELESTIGEM_FE_RATE = qCOMMON
                                .comment("FE/t production")
                                .defineInRange("solar_celestigem_ferate", 3840, 1, Integer.MAX_VALUE);
                SOLARPANEL_CELESTIGEM_ENABLE_YLEVEL = qCOMMON
                                .comment("Enable/Disable Y-Level multiplier to reduce FE gen based on Y")
                                .define("solar_celestigem_ylevel", false);
                SOLARPANEL_CELESTIGEM_ENABLE_SPAM = qCOMMON
                                .comment("Enable/Disable Solar-Spam multiplier to reduce FE gen based on cheap prices")
                                .define("solar_celestigem_spam", true);
                SOLARPANEL_CELESTIGEM_CONDITIONS_OVERRIDE = qCOMMON
                                .comment("Enable/Disable the entire system of conditions to keep active forever")
                                .define("solar_celestigem_override", false);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.SolarPanel.t4));

                SOLARPANEL_ECLIPSEALLOY_FE_CAPACITY = qCOMMON
                                .comment("FE Capacity")
                                .defineInRange("solar_eclipsealloy_maxfe", 1000000, 1, Integer.MAX_VALUE);
                SOLARPANEL_ECLIPSEALLOY_FE_RATE = qCOMMON
                                .comment("FE/t production")
                                .defineInRange("solar_eclipsealloy_ferate", 11520, 1, Integer.MAX_VALUE);
                SOLARPANEL_ECLIPSEALLOY_ENABLE_YLEVEL = qCOMMON
                                .comment("Enable/Disable Y-Level multiplier to reduce FE gen based on Y")
                                .define("solar_eclipsealloy_ylevel", true);
                SOLARPANEL_ECLIPSEALLOY_ENABLE_SPAM = qCOMMON
                                .comment("Enable/Disable Solar-Spam multiplier to reduce FE gen based on cheap prices")
                                .define("solar_eclipsealloy_spam", true);
                SOLARPANEL_ECLIPSEALLOY_CONDITIONS_OVERRIDE = qCOMMON
                                .comment("Enable/Disable the entire system of conditions to keep active forever")
                                .define("solar_eclipsealloy_override", false);

                qCOMMON.pop();
        }

        private static void anvil() {
                qCOMMON.comment(DataGenUtil.txtDecor(Constants.AnvilType)).push("6-" + Constants.AnvilType);

                ANVILS_SOUND_EVENT = qCOMMON
                                .comment("Enable/Disable the entire sound event of all anvils on item repair")
                                .define("anvils_sound", true);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.Anvils.t1));

                ANVILS_FERRICORE_ITEM_COOLDOWN = qCOMMON
                                .comment("Ticks of delay to consume a metallic items")
                                .defineInRange("anvil_ferricore_cooldown", 200, 10, Integer.MAX_VALUE);
                ANVIL_FERRICORE_SOUND_EVENT = qCOMMON
                                .comment("Enable/Disable sound event on item repair")
                                .define("anvil_ferricore_sound", true);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.Anvils.t2));

                ANVILS_BLAZEGOLD_MB_CAPACITY = qCOMMON
                                .comment("MB Capacity")
                                .defineInRange("anvil_blazegold_maxmb", 10000, 1, Integer.MAX_VALUE);
                ANVILS_BLAZEGOLD_MB_RATE = qCOMMON
                                .comment("MB/t cost")
                                .defineInRange("anvil_blazegold_mbrate", 10, 1, Integer.MAX_VALUE);
                ANVIL_BLAZEGOLD_SOUND_EVENT = qCOMMON
                                .comment("Enable/Disable sound event on item repair")
                                .define("anvil_blazegold_sound", true);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.Anvils.t3));

                ANVILS_CELESTIGEM_FE_CAPACITY = qCOMMON
                                .comment("FE Capacity")
                                .defineInRange("anvil_celestigem_maxfe", 10000, 1, Integer.MAX_VALUE);
                ANVILS_CELESTIGEM_FE_RATE = qCOMMON
                                .comment("FE/t cost")
                                .defineInRange("anvil_celestigem_ferate", 100, 1, Integer.MAX_VALUE);

                ANVIL_CELESTIGEM_SOUND_EVENT = qCOMMON
                                .comment("Enable/Disable sound event on item repair")
                                .define("anvil_celestigem_sound", true);

                qCOMMON.comment(DataGenUtil.txtDecor(Constants.Anvils.t4));

                ANVILS_ECLIPSEALLOY_MB_CAPACITY = qCOMMON
                                .comment("MB Capacity")
                                .defineInRange("anvil_eclipsealloy_maxmb", 10000, 1, Integer.MAX_VALUE);
                ANVILS_ECLIPSEALLOY_MB_RATE = qCOMMON
                                .comment("MB/t cost")
                                .defineInRange("anvil_eclipsealloy_mbrate", 100, 1, Integer.MAX_VALUE);
                ANVILS_ECLIPSEALLOY_FE_CAPACITY = qCOMMON
                                .comment("FE Capacity")
                                .defineInRange("anvil_eclipsealloy_maxfe", 10000, 1, Integer.MAX_VALUE);
                ANVILS_ECLIPSEALLOY_FE_RATE = qCOMMON
                                .comment("FE/t cost")
                                .defineInRange("anvil_eclipsealloy_ferate", 100, 1, Integer.MAX_VALUE);
                ANVILS_ECLIPSEALLOY_DAMAGE_LIMIT = qCOMMON
                                .comment("Minimal damage until it was counted as insta-repaireable")
                                .defineInRange("anvil_eclipsealloy_damage_limit", 1000, 1, Integer.MAX_VALUE);
                ANVILS_ECLIPSEALLOY_DAMAGE_PERCENTUAGE = qCOMMON
                                .comment("Percentuage of damage repaired when the tool is over the Damage Limit")
                                .defineInRange("anvil_eclipsealloy_damage_percentuage", 10, 1, 99);
                ANVIL_ECLIPSEALLOY_SOUND_EVENT = qCOMMON
                                .comment("Enable/Disable sound event on item repair")
                                .define("anvil_eclipsealloy_sound", true);

                qCOMMON.pop();
        }

        private static void superduperconfig() {
                qCOMMON.comment("Hello player, Dyna is here !");
                qCOMMON.comment("If you're wondering that this config part");
                qCOMMON.comment("is used as joke , you are right...");
                qCOMMON.comment("Anyway , can I be of help to you ?")
                                .define("answer", false);
        }

}