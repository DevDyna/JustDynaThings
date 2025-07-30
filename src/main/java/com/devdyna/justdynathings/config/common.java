package com.devdyna.justdynathings.config;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Constants.*;
import com.devdyna.justdynathings.utils.DataGenUtil;

import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec.*;

public class common {
        private static final ModConfigSpec.Builder qCOMMON = new ModConfigSpec.Builder();

        // TODO rework config logic

        public static BooleanValue DOC_WARNING;

        public static BooleanValue PHASE_BOX_WRENCHABLE;

        public static BooleanValue FERRICORE_CLOCK_WRENCHABLE;

        public static IntValue REVITALIZER_FE_CAPACITY;
        public static IntValue REVITALIZER_FE_COST;
        public static BooleanValue REVITALIZER_TOGGLE_SOUND;
        public static IntValue REVITALIZER_CHANCE_FE_COST;

        public static IntValue THERMOGEN_FE_CAPACITY;
        public static IntValue THERMOGEN_MB_CAPACITY;

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
        public static BooleanValue SOLARPANEL_FERRICORE_ENABLE_SKY;
        public static BooleanValue SOLARPANEL_FERRICORE_ENABLE_DAYTIME;
        public static BooleanValue SOLARPANEL_FERRICORE_BIOMES;

        public static IntValue SOLARPANEL_BLAZEGOLD_FE_CAPACITY;
        public static IntValue SOLARPANEL_BLAZEGOLD_FE_RATE;
        public static BooleanValue SOLARPANEL_BLAZEGOLD_ENABLE_YLEVEL;
        public static BooleanValue SOLARPANEL_BLAZEGOLD_ENABLE_SPAM;
        public static BooleanValue SOLARPANEL_BLAZEGOLD_ENABLE_SKY;
        public static BooleanValue SOLARPANEL_BLAZEGOLD_ENABLE_DAYTIME;
        public static BooleanValue SOLARPANEL_BLAZEGOLD_BIOMES;

        public static IntValue SOLARPANEL_CELESTIGEM_FE_CAPACITY;
        public static IntValue SOLARPANEL_CELESTIGEM_FE_RATE;
        public static BooleanValue SOLARPANEL_CELESTIGEM_ENABLE_YLEVEL;
        public static BooleanValue SOLARPANEL_CELESTIGEM_ENABLE_SPAM;
        public static BooleanValue SOLARPANEL_CELESTIGEM_ENABLE_SKY;
        public static BooleanValue SOLARPANEL_CELESTIGEM_ENABLE_DAYTIME;
        public static BooleanValue SOLARPANEL_CELESTIGEM_BIOMES;

        public static IntValue SOLARPANEL_ECLIPSEALLOY_FE_CAPACITY;
        public static IntValue SOLARPANEL_ECLIPSEALLOY_FE_RATE;
        public static BooleanValue SOLARPANEL_ECLIPSEALLOY_ENABLE_YLEVEL;
        public static BooleanValue SOLARPANEL_ECLIPSEALLOY_ENABLE_SPAM;
        public static BooleanValue SOLARPANEL_ECLIPSEALLOY_ENABLE_SKY;
        public static BooleanValue SOLARPANEL_ECLIPSEALLOY_ENABLE_DAYTIME;
        public static BooleanValue SOLARPANEL_ECLIPSEALLOY_BIOMES;

        public static BooleanValue ANVILS_SOUND_EVENT;

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

                DOC_WARNING = qCOMMON
                                .comment("Disable Documentation warning")
                                .define("disable_doc_warning", false);

                superduperconfig();
                qCOMMON.pop();
        }

        private static void blocks() {
                qCOMMON.comment("Blocks").push("2-blocks");
                qCOMMON.comment(DataGenUtil.txtDecor(Blocks.PhaseBox));

                PHASE_BOX_WRENCHABLE = qCOMMON
                                .comment("Require any wrench to change Phase Box state intend of nothing")
                                .define(Blocks.PhaseBox + Config.WRENCH, false);

                qCOMMON.comment(DataGenUtil.txtDecor(Blocks.FerricoreClock));

                FERRICORE_CLOCK_WRENCHABLE = qCOMMON
                                .comment("Require any wrench to change Ferricore Clock face state intend of nothing")
                                .define(Blocks.FerricoreClock + Config.WRENCH, false);

                qCOMMON.comment(DataGenUtil.txtDecor(Blocks.Revitalizer));

                REVITALIZER_FE_CAPACITY = qCOMMON
                                .comment("Total FE Capacity")
                                .defineInRange(Blocks.Revitalizer + Config.FE_MAX, 10000, 1, Integer.MAX_VALUE);
                REVITALIZER_FE_COST = qCOMMON
                                .comment("FE/t cost")
                                .defineInRange(Blocks.Revitalizer + Config.FE_RATE, 1000, 1, Integer.MAX_VALUE);
                REVITALIZER_TOGGLE_SOUND = qCOMMON
                                .comment("Enable/Disable sound when revitalized a goo")
                                .define(Blocks.Revitalizer + Config.SOUND, true);
                REVITALIZER_CHANCE_FE_COST = qCOMMON
                                .comment("Chance to apply FE cost when revitalized a goo")
                                .defineInRange(Blocks.Revitalizer + "_cost_chance", 50, 1, 100);

                qCOMMON.comment(DataGenUtil.txtDecor(Blocks.ThermoGen));

                THERMOGEN_FE_CAPACITY = qCOMMON
                                .comment("Total FE Capacity")
                                .defineInRange(Blocks.ThermoGen + Config.FE_MAX, 1000000, 1, Integer.MAX_VALUE);
                THERMOGEN_MB_CAPACITY = qCOMMON
                                .comment("Total Coolant Capacity")
                                .defineInRange(Blocks.ThermoGen + Config.FE_RATE, 100000, 1, Integer.MAX_VALUE);

                qCOMMON.comment(DataGenUtil.txtDecor(Blocks.BlackHole));

                // TODO rework to make more blackhole storages
                BLACKHOLE_KEEP_STORAGE = qCOMMON.comment("Keep stored stuff when redstone disable it")
                                .define(Blocks.BlackHole + "_keep_content", true);
                BLACKHOLE_FE_CAPACITY = qCOMMON
                                .comment("Total FE Capacity")
                                .defineInRange(Blocks.BlackHole + Config.FE_MAX, Integer.MAX_VALUE, 1,
                                                Integer.MAX_VALUE);
                BLACKHOLE_FE_COST = qCOMMON
                                .comment("FE/t cost")
                                .defineInRange(Blocks.BlackHole + Config.FE_RATE, Integer.MAX_VALUE, 1,
                                                Integer.MAX_VALUE);
                BLACKHOLE_MB_CAPACITY = qCOMMON
                                .comment("Total Fluid Capacity")
                                .defineInRange(Blocks.BlackHole + Config.MB_MAX, Integer.MAX_VALUE, 1,
                                                Integer.MAX_VALUE);
                BLACKHOLE_MB_COST = qCOMMON
                                .comment("MB/t cost")
                                .defineInRange(Blocks.BlackHole + Config.MB_RATE, Integer.MAX_VALUE, 1,
                                                Integer.MAX_VALUE);

                qCOMMON.pop();
        }

        private static void budding() {
                qCOMMON.comment(DataGenUtil.txtDecor(Constants.BuddingType)).push("3-" + Constants.BuddingType);
                qCOMMON.comment("general_" + Constants.BuddingType);

                BUDDING_GENERAL_MB_CAPACITY = qCOMMON
                                .comment("MB Capacity")
                                .defineInRange(Constants.BuddingType + Config.MB_MAX, 10000, 1, Integer.MAX_VALUE);
                BUDDING_GENERAL_MB_COST = qCOMMON
                                .comment("MB/t cost")
                                .defineInRange(Constants.BuddingType + Config.MB_RATE, 100, 1, Integer.MAX_VALUE);
                BUDDING_GENERAL_FE_CAPACITY = qCOMMON
                                .comment("FE Capacity")
                                .defineInRange(Constants.BuddingType + Config.FE_MAX, 10000, 1, Integer.MAX_VALUE);
                BUDDING_GENERAL_FE_COST = qCOMMON
                                .comment("FE/t cost")
                                .defineInRange(Constants.BuddingType + Config.FE_RATE, 100, 1, Integer.MAX_VALUE);

                BUDDING_GENERAL_FE_CHANCE = qCOMMON.comment("Chance to apply FE cost when a cluster will grow")
                                .define(Constants.BuddingType + "_random_energy_cost", true);
                BUDDING_GENERAL_MB_CHANCE = qCOMMON.comment("Chance to apply MB cost when a cluster will grow")
                                .define(Constants.BuddingType + "_random_fluid_cost", true);

                BUDDING_GENERAL_SOUND = qCOMMON.comment("Enable/Disable sound of buddings when grow")
                                .define(Constants.BuddingType + Config.SOUND, true);
                qCOMMON.pop();
        }

        private static void goo() {
                qCOMMON.comment(DataGenUtil.txtDecor(Constants.GooType)).push("4-" + Constants.GooType);
                qCOMMON.comment(DataGenUtil.txtDecor(Goo.Creative));

                GOO_CREATIVE_SOUND_TOGGLE_STATE = qCOMMON.comment("Enable/Disable sound on goo state change")
                                .define(Goo.Creative + "_sound_on_change_state", true);
                GOO_CREATIVE_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange(Goo.Creative + Config.TIER, Integer.MAX_VALUE, 1, Integer.MAX_VALUE);
                GOO_CREATIVE_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange(Goo.Creative + Config.REDUCER, Integer.MAX_VALUE, 1, Integer.MAX_VALUE);
                GOO_CREATIVE_SOUND_RECIPE = qCOMMON.comment("Enable/Disable sound on goo recipe execution")
                                .define(Goo.Creative + "_sound_on_execution_recipe", true);

                qCOMMON.comment("Generic FE Goo powered");

                GOO_FEGOO_FE_CAPACITY = qCOMMON
                                .comment("Max FE capacity")
                                .defineInRange(Config.G_FEGOO + Config.FE_MAX, 10000, 1, Integer.MAX_VALUE);
                GOO_FEGOO_FE_RATE = qCOMMON
                                .comment("FE/t cost")
                                .defineInRange(Config.G_FEGOO + Config.FE_RATE, 100, 1, Integer.MAX_VALUE);
                GOO_FEGOO_FE_CAPACITY_MULTIPLY = qCOMMON.comment("Enable/Disable tier change capacity")
                                .define(Config.G_FEGOO + "_tier_multiply_energy_capacity", true);
                GOO_FEGOO_FE_RATE_MULTIPLY = qCOMMON.comment("Enable/Disable tier change fe cost")
                                .define(Config.G_FEGOO + "_tier_multiply_energy_cost", true);
                GOO_FEGOO_SOUND_RECIPE = qCOMMON.comment("Enable/Disable sound on goo recipe execution")
                                .define(Config.G_FEGOO + "_sound_on_execution_recipe", true);
                GOO_FEGOO_SOUND_EXTRA = qCOMMON.comment("Enable/Disable sound on goo recipe execution randomly")
                                .define(Config.G_FEGOO + "_extra_sound_on_execution", true);

                qCOMMON.comment(DataGenUtil.txtDecor(Goo.Energized));

                GOO_ENERGY_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange(Goo.Energized + Config.TIER, 5, 1, Integer.MAX_VALUE);
                GOO_ENERGY_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange(Goo.Energized + Config.REDUCER, 15, 1, Integer.MAX_VALUE);

                qCOMMON.comment(DataGenUtil.txtDecor(Goo.T1));

                GOO_T1_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange(Goo.T1 + Config.TIER, 1, 1, Integer.MAX_VALUE);
                GOO_T1_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange(Goo.T1 + Config.REDUCER, 15, 1, Integer.MAX_VALUE);

                qCOMMON.comment(DataGenUtil.txtDecor(Goo.T2));

                GOO_T2_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange(Goo.T2 + Config.TIER, 2, 1, Integer.MAX_VALUE);
                GOO_T2_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange(Goo.T2 + Config.REDUCER, 15, 1, Integer.MAX_VALUE);

                qCOMMON.comment(DataGenUtil.txtDecor(Goo.T3));

                GOO_T3_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange(Goo.T3 + Config.TIER, 3, 1, Integer.MAX_VALUE);
                GOO_T3_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange(Goo.T3 + Config.REDUCER, 15, 1, Integer.MAX_VALUE);

                qCOMMON.comment(DataGenUtil.txtDecor(Goo.T4));

                GOO_T4_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange(Goo.T4 + Config.TIER, 4, 1, Integer.MAX_VALUE);
                GOO_T4_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange(Goo.T4 + Config.REDUCER, 15, 1, Integer.MAX_VALUE);

                qCOMMON.pop();
        }

        private static void solar_panel() {
                qCOMMON.comment(DataGenUtil.txtDecor(Constants.SolarPanelType)).push("5-" + Constants.SolarPanelType);
                qCOMMON.comment(DataGenUtil.txtDecor(SolarPanel.t1));

                SOLARPANEL_FERRICORE_FE_CAPACITY = qCOMMON
                                .comment("FE Capacity")
                                .defineInRange(SolarPanel.t1 + Config.FE_MAX, 100000, 1, Integer.MAX_VALUE);
                SOLARPANEL_FERRICORE_FE_RATE = qCOMMON
                                .comment("FE/t production")
                                .defineInRange(SolarPanel.t1 + Config.FE_RATE, 240, 1, Integer.MAX_VALUE);
                SOLARPANEL_FERRICORE_ENABLE_YLEVEL = qCOMMON
                                .comment("Enable/Disable Y-Level multiplier to reduce FE gen based on Y")
                                .define(SolarPanel.t1 + Config.YLEVEL, false);
                SOLARPANEL_FERRICORE_ENABLE_SPAM = qCOMMON
                                .comment("Enable/Disable Solar-Spam multiplier to reduce FE gen based on cheap prices")
                                .define(SolarPanel.t1 + Config.SPAM, false);
                SOLARPANEL_FERRICORE_ENABLE_SKY = qCOMMON
                                .comment("Enable/Disable condition to see the sky")
                                .define(SolarPanel.t1 + Config.SKY, true);
                SOLARPANEL_FERRICORE_ENABLE_DAYTIME = qCOMMON
                                .comment("Enable/Disable condition of daytime only")
                                .define(SolarPanel.t1 + Config.DAY, true);
                SOLARPANEL_FERRICORE_BIOMES = qCOMMON
                                .comment("Change the logic of biometag | True == whitelist | False == blacklist")
                                .define(SolarPanel.t1 + Config.BIOMES, true);

                qCOMMON.comment(DataGenUtil.txtDecor(SolarPanel.t2));

                SOLARPANEL_BLAZEGOLD_FE_CAPACITY = qCOMMON
                                .comment("FE Capacity")
                                .defineInRange(SolarPanel.t2 + Config.FE_MAX, 100000, 1, Integer.MAX_VALUE);
                SOLARPANEL_BLAZEGOLD_FE_RATE = qCOMMON
                                .comment("FE/t production")
                                .defineInRange(SolarPanel.t2 + Config.FE_RATE, 960, 1, Integer.MAX_VALUE);
                SOLARPANEL_BLAZEGOLD_ENABLE_YLEVEL = qCOMMON
                                .comment("Enable/Disable Y-Level multiplier to reduce FE gen based on Y")
                                .define(SolarPanel.t2 + Config.YLEVEL, false);
                SOLARPANEL_BLAZEGOLD_ENABLE_SPAM = qCOMMON
                                .comment("Enable/Disable Solar-Spam multiplier to reduce FE gen based on cheap prices")
                                .define(SolarPanel.t2 + Config.SPAM, false);
                SOLARPANEL_BLAZEGOLD_ENABLE_SKY = qCOMMON
                                .comment("Enable/Disable condition to see the sky")
                                .define(SolarPanel.t2 + Config.SKY, false);
                SOLARPANEL_BLAZEGOLD_ENABLE_DAYTIME = qCOMMON
                                .comment("Enable/Disable condition of daytime only")
                                .define(SolarPanel.t2 + Config.DAY, false);
                SOLARPANEL_BLAZEGOLD_BIOMES = qCOMMON
                                .comment("Change the logic of biometag | True == whitelist | False == blacklist")
                                .define(SolarPanel.t2 + Config.BIOMES, true);

                qCOMMON.comment(DataGenUtil.txtDecor(SolarPanel.t3));

                SOLARPANEL_CELESTIGEM_FE_CAPACITY = qCOMMON
                                .comment("FE Capacity")
                                .defineInRange(SolarPanel.t3 + Config.FE_MAX, 1000000, 1, Integer.MAX_VALUE);
                SOLARPANEL_CELESTIGEM_FE_RATE = qCOMMON
                                .comment("FE/t production")
                                .defineInRange(SolarPanel.t3 + Config.FE_RATE, 3840, 1, Integer.MAX_VALUE);
                SOLARPANEL_CELESTIGEM_ENABLE_YLEVEL = qCOMMON
                                .comment("Enable/Disable Y-Level multiplier to reduce FE gen based on Y")
                                .define(SolarPanel.t3 + Config.YLEVEL, false);
                SOLARPANEL_CELESTIGEM_ENABLE_SPAM = qCOMMON
                                .comment("Enable/Disable Solar-Spam multiplier to reduce FE gen based on cheap prices")
                                .define(SolarPanel.t3 + Config.SPAM, true);
                SOLARPANEL_CELESTIGEM_ENABLE_SKY = qCOMMON
                                .comment("Enable/Disable condition to see the sky")
                                .define(SolarPanel.t3 + Config.SKY, true);
                SOLARPANEL_CELESTIGEM_ENABLE_DAYTIME = qCOMMON
                                .comment("Enable/Disable condition of daytime only")
                                .define(SolarPanel.t3 + Config.DAY, false);
                SOLARPANEL_CELESTIGEM_BIOMES = qCOMMON
                                .comment("Change the logic of biometag | True == whitelist | False == blacklist")
                                .define(SolarPanel.t3 + Config.BIOMES, false);

                qCOMMON.comment(DataGenUtil.txtDecor(SolarPanel.t4));

                SOLARPANEL_ECLIPSEALLOY_FE_CAPACITY = qCOMMON
                                .comment("FE Capacity")
                                .defineInRange(SolarPanel.t4 + Config.FE_MAX, 1000000, 1, Integer.MAX_VALUE);
                SOLARPANEL_ECLIPSEALLOY_FE_RATE = qCOMMON
                                .comment("FE/t production")
                                .defineInRange(SolarPanel.t4 + Config.FE_RATE, 11520, 1, Integer.MAX_VALUE);
                SOLARPANEL_ECLIPSEALLOY_ENABLE_YLEVEL = qCOMMON
                                .comment("Enable/Disable Y-Level multiplier to reduce FE gen based on Y")
                                .define(SolarPanel.t4 + Config.YLEVEL, true);
                SOLARPANEL_ECLIPSEALLOY_ENABLE_SPAM = qCOMMON
                                .comment("Enable/Disable Solar-Spam multiplier to reduce FE gen based on cheap prices")
                                .define(SolarPanel.t4 + Config.SPAM, true);
                SOLARPANEL_ECLIPSEALLOY_ENABLE_SKY = qCOMMON
                                .comment("Enable/Disable condition to see the sky")
                                .define(SolarPanel.t4 + Config.SKY, false);
                SOLARPANEL_ECLIPSEALLOY_ENABLE_DAYTIME = qCOMMON
                                .comment("Enable/Disable condition of daytime only")
                                .define(SolarPanel.t4 + Config.DAY, false);
                SOLARPANEL_ECLIPSEALLOY_BIOMES = qCOMMON
                                .comment("Change the logic of biometag | True == whitelist | False == blacklist")
                                .define(SolarPanel.t4 + Config.BIOMES, false);

                qCOMMON.pop();
        }

        private static void anvil() {
                qCOMMON.comment(DataGenUtil.txtDecor(Constants.AnvilType)).push("6-" + Constants.AnvilType);

                ANVILS_SOUND_EVENT = qCOMMON
                                .comment("Enable/Disable the entire sound event of all anvils on item repair")
                                .define(Constants.AnvilType + Config.SOUND, true);

                qCOMMON.comment(DataGenUtil.txtDecor(Anvils.t1));

                ANVIL_FERRICORE_SOUND_EVENT = qCOMMON
                                .comment("Enable/Disable sound event on item repair")
                                .define(Anvils.t1 + Config.SOUND, true);

                qCOMMON.comment(DataGenUtil.txtDecor(Anvils.t2));

                ANVILS_BLAZEGOLD_MB_CAPACITY = qCOMMON
                                .comment("MB Capacity")
                                .defineInRange(Anvils.t2 + Config.MB_MAX, 10000, 1, Integer.MAX_VALUE);
                ANVILS_BLAZEGOLD_MB_RATE = qCOMMON
                                .comment("MB/t cost")
                                .defineInRange(Anvils.t2 + Config.MB_RATE, 10, 1, Integer.MAX_VALUE);
                ANVIL_BLAZEGOLD_SOUND_EVENT = qCOMMON
                                .comment("Enable/Disable sound event on item repair")
                                .define(Anvils.t2 + Config.SOUND, true);

                qCOMMON.comment(DataGenUtil.txtDecor(Anvils.t3));

                ANVILS_CELESTIGEM_FE_CAPACITY = qCOMMON
                                .comment("FE Capacity")
                                .defineInRange(Anvils.t3 + Config.FE_MAX, 10000, 1, Integer.MAX_VALUE);
                ANVILS_CELESTIGEM_FE_RATE = qCOMMON
                                .comment("FE/t cost")
                                .defineInRange(Anvils.t3 + Config.FE_RATE, 100, 1, Integer.MAX_VALUE);

                ANVIL_CELESTIGEM_SOUND_EVENT = qCOMMON
                                .comment("Enable/Disable sound event on item repair")
                                .define(Anvils.t3 + Config.SOUND, true);

                qCOMMON.comment(DataGenUtil.txtDecor(Anvils.t4));

                ANVILS_ECLIPSEALLOY_MB_CAPACITY = qCOMMON
                                .comment("MB Capacity")
                                .defineInRange(Anvils.t4 + Config.MB_MAX, 10000, 1, Integer.MAX_VALUE);
                ANVILS_ECLIPSEALLOY_MB_RATE = qCOMMON
                                .comment("MB/t cost")
                                .defineInRange(Anvils.t4 + Config.MB_RATE, 100, 1, Integer.MAX_VALUE);
                ANVILS_ECLIPSEALLOY_FE_CAPACITY = qCOMMON
                                .comment("FE Capacity")
                                .defineInRange(Anvils.t4 + Config.FE_MAX, 10000, 1, Integer.MAX_VALUE);
                ANVILS_ECLIPSEALLOY_FE_RATE = qCOMMON
                                .comment("FE/t cost")
                                .defineInRange(Anvils.t4 + Config.FE_RATE, 100, 1, Integer.MAX_VALUE);
                ANVILS_ECLIPSEALLOY_DAMAGE_LIMIT = qCOMMON
                                .comment("Minimal damage until it was counted as insta-repaireable")
                                .defineInRange(Anvils.t4 + "_damage_limit", 1000, 1, Integer.MAX_VALUE);

                ANVIL_ECLIPSEALLOY_SOUND_EVENT = qCOMMON
                                .comment("Enable/Disable sound event on item repair")
                                .define(Anvils.t4 + Config.SOUND, true);

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