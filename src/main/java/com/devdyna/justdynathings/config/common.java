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

        public static BooleanValue DOC_WARNING;
        public static BooleanValue ENABLE_ALL_JEI_FUELS;

        public static BooleanValue PHASE_BOX_WRENCHABLE;

        public static BooleanValue FERRICORE_CLOCK_WRENCHABLE;

        public static IntValue STABILIZER_FE_CAPACITY;
        public static IntValue STABILIZER_FE_COST;
        public static IntValue STABILIZER_MB_CAPACITY;
        public static IntValue STABILIZER_MB_COST;
        public static BooleanValue STABILIZER_TOGGLE_SOUND;

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

        public static BooleanValue ADVANCED_TIME_WAND_FAKE_PLAYER_ALLOWED;
        public static BooleanValue PICKER_WAND_FAKE_PLAYER_ALLOWED;
        public static BooleanValue SWAPPER_FAKE_PLAYER_ALLOWED;

        public static IntValue ADVANCED_TIME_WAND_FE_CAPACITY;
        public static IntValue ADVANCED_TIME_WAND_FE_RATE;
        public static IntValue ADVANCED_TIME_WAND_MB_CAPACITY;
        public static IntValue ADVANCED_TIME_WAND_MB_RATE;

        public static ConfigValue<Integer> ADVANCED_TIME_WAND_NORMAL_MODE;
        public static ConfigValue<Integer> ADVANCED_TIME_WAND_X2_MODE;
        public static ConfigValue<Integer> ADVANCED_TIME_WAND_X4_MODE;
        public static ConfigValue<Integer> ADVANCED_TIME_WAND_MAX_MODE;

        public static ConfigValue<Integer> ADVANCED_TIME_WAND_MAX_MULTIPLIER;

        public static IntValue PARADOX_MIXER_MB_CAPACITY;
        public static BooleanValue PARADOX_MIXER_SOUND_EVENT;

        public static IntValue TICKER_MB_CAPACITY;
        public static IntValue TICKER_MB_RATE;
        public static IntValue TICKER_FE_CAPACITY;
        public static IntValue TICKER_FE_RATE;

        public static IntValue TICKER_TICK_RATE;

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
                wands();
                mixer();
                ticker();
        }

        private static void general() {
                qCOMMON.comment("General").push("1-general");
                superduperConfig();

                DOC_WARNING = qCOMMON
                                .comment("Disable Documentation warning")
                                .define("disable_doc_warning", false);

                ENABLE_ALL_JEI_FUELS = qCOMMON
                                .comment("Include any fuel item to Generator JEI category")
                                .define("include_any_jei_fuels", true);

                qCOMMON.pop();
        }

        private static void blocks() {
                qCOMMON.comment("Blocks").push("2-blocks");
                qCOMMON.comment(DataGenUtil.txtDecor(Blocks.PhaseBox));

                PHASE_BOX_WRENCHABLE = qCOMMON
                                .comment("Require any wrench to change Phase Box state intend of nothing")
                                .define(Blocks.PhaseBox + Config.Keys.WRENCH, false);

                qCOMMON.comment(DataGenUtil.txtDecor(Blocks.FerricoreClock));

                FERRICORE_CLOCK_WRENCHABLE = qCOMMON
                                .comment("Require any wrench to change Ferricore Clock face state intend of nothing")
                                .define(Blocks.FerricoreClock + Config.Keys.WRENCH, false);

                qCOMMON.comment(DataGenUtil.txtDecor(Blocks.Stabilizer));

                STABILIZER_FE_CAPACITY = qCOMMON
                                .comment(Config.Display.FE_MAX)
                                .defineInRange(Blocks.Stabilizer + Config.Keys.FE_MAX, 10000, 1, Integer.MAX_VALUE);
                STABILIZER_FE_COST = qCOMMON
                                .comment(Config.Display.FE_RATE)
                                .defineInRange(Blocks.Stabilizer + Config.Keys.FE_RATE, 1000, 1, Integer.MAX_VALUE);

                STABILIZER_MB_CAPACITY = qCOMMON
                                .comment(Config.Display.MB_MAX)
                                .defineInRange(Blocks.Stabilizer + Config.Keys.MB_MAX, 1000, 1, Integer.MAX_VALUE);
                STABILIZER_MB_COST = qCOMMON
                                .comment(Config.Display.MB_RATE)
                                .defineInRange(Blocks.Stabilizer + Config.Keys.MB_RATE, 100, 1, Integer.MAX_VALUE);

                STABILIZER_TOGGLE_SOUND = qCOMMON
                                .comment("Enable/Disable sound when revitalized a goo")
                                .define(Blocks.Stabilizer + Config.Keys.SOUND, true);

                qCOMMON.comment(DataGenUtil.txtDecor(Blocks.ThermoGen));

                THERMOGEN_FE_CAPACITY = qCOMMON
                                .comment(Config.Display.FE_MAX)
                                .defineInRange(Blocks.ThermoGen + Config.Keys.FE_MAX, 1000000, 1, Integer.MAX_VALUE);
                THERMOGEN_MB_CAPACITY = qCOMMON
                                .comment("Total Coolant Capacity")
                                .defineInRange(Blocks.ThermoGen + Config.Keys.FE_RATE, 100000, 1, Integer.MAX_VALUE);

                qCOMMON.comment(DataGenUtil.txtDecor(Blocks.BlackHole));

                BLACKHOLE_KEEP_STORAGE = qCOMMON.comment("Keep stored stuff when redstone disable it")
                                .define(Blocks.BlackHole + "_keep_content", true);
                BLACKHOLE_FE_CAPACITY = qCOMMON
                                .comment(Config.Display.FE_MAX)
                                .defineInRange(Blocks.BlackHole + Config.Keys.FE_MAX, Integer.MAX_VALUE, 1,
                                                Integer.MAX_VALUE);
                BLACKHOLE_FE_COST = qCOMMON
                                .comment(Config.Display.FE_RATE)
                                .defineInRange(Blocks.BlackHole + Config.Keys.FE_RATE, Integer.MAX_VALUE, 1,
                                                Integer.MAX_VALUE);
                BLACKHOLE_MB_CAPACITY = qCOMMON
                                .comment(Config.Display.MB_MAX)
                                .defineInRange(Blocks.BlackHole + Config.Keys.MB_MAX, Integer.MAX_VALUE, 1,
                                                Integer.MAX_VALUE);
                BLACKHOLE_MB_COST = qCOMMON
                                .comment(Config.Display.MB_RATE)
                                .defineInRange(Blocks.BlackHole + Config.Keys.MB_RATE, Integer.MAX_VALUE, 1,
                                                Integer.MAX_VALUE);

                qCOMMON.pop();
        }

        private static void budding() {
                qCOMMON.comment(DataGenUtil.txtDecor(Constants.BuddingType)).push("3-" + Constants.BuddingType);
                qCOMMON.comment("general_" + Constants.BuddingType);

                BUDDING_GENERAL_MB_CAPACITY = qCOMMON
                                .comment(Config.Display.MB_MAX)
                                .defineInRange(Constants.BuddingType + Config.Keys.MB_MAX, 10000, 1, Integer.MAX_VALUE);
                BUDDING_GENERAL_MB_COST = qCOMMON
                                .comment(Config.Display.MB_RATE)
                                .defineInRange(Constants.BuddingType + Config.Keys.MB_RATE, 100, 1, Integer.MAX_VALUE);
                BUDDING_GENERAL_FE_CAPACITY = qCOMMON
                                .comment(Config.Display.FE_MAX)
                                .defineInRange(Constants.BuddingType + Config.Keys.FE_MAX, 10000, 1, Integer.MAX_VALUE);
                BUDDING_GENERAL_FE_COST = qCOMMON
                                .comment(Config.Display.FE_RATE)
                                .defineInRange(Constants.BuddingType + Config.Keys.FE_RATE, 100, 1, Integer.MAX_VALUE);

                BUDDING_GENERAL_FE_CHANCE = qCOMMON.comment("Chance to apply FE cost when a cluster will grow")
                                .define(Constants.BuddingType + "_random_energy_cost", true);
                BUDDING_GENERAL_MB_CHANCE = qCOMMON.comment("Chance to apply MB cost when a cluster will grow")
                                .define(Constants.BuddingType + "_random_fluid_cost", true);

                BUDDING_GENERAL_SOUND = qCOMMON.comment("Enable/Disable sound of buddings when grow")
                                .define(Constants.BuddingType + Config.Keys.SOUND, true);
                qCOMMON.pop();
        }

        private static void goo() {
                qCOMMON.comment(DataGenUtil.txtDecor(Constants.GooType)).push("4-" + Constants.GooType);
                qCOMMON.comment(DataGenUtil.txtDecor(Goo.Creative));

                GOO_CREATIVE_SOUND_TOGGLE_STATE = qCOMMON.comment("Enable/Disable sound on goo state change")
                                .define(Goo.Creative + "_sound_on_change_state", true);
                GOO_CREATIVE_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange(Goo.Creative + Config.Keys.TIER, Integer.MAX_VALUE, 1,
                                                Integer.MAX_VALUE);
                GOO_CREATIVE_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange(Goo.Creative + Config.Keys.REDUCER, Integer.MAX_VALUE, 1,
                                                Integer.MAX_VALUE);
                GOO_CREATIVE_SOUND_RECIPE = qCOMMON.comment("Enable/Disable sound on goo recipe execution")
                                .define(Goo.Creative + "_sound_on_execution_recipe", true);

                qCOMMON.comment("Generic FE Goo powered");

                GOO_FEGOO_FE_CAPACITY = qCOMMON
                                .comment(Config.Display.FE_MAX)
                                .defineInRange(Config.Keys.G_FEGOO + Config.Keys.FE_MAX, 10000, 1, Integer.MAX_VALUE);
                GOO_FEGOO_FE_RATE = qCOMMON
                                .comment(Config.Display.FE_RATE)
                                .defineInRange(Config.Keys.G_FEGOO + Config.Keys.FE_RATE, 100, 1, Integer.MAX_VALUE);
                GOO_FEGOO_FE_CAPACITY_MULTIPLY = qCOMMON.comment("Enable/Disable tier change capacity")
                                .define(Config.Keys.G_FEGOO + "_tier_multiply_energy_capacity", true);
                GOO_FEGOO_FE_RATE_MULTIPLY = qCOMMON.comment("Enable/Disable tier change fe cost")
                                .define(Config.Keys.G_FEGOO + "_tier_multiply_energy_cost", true);
                GOO_FEGOO_SOUND_RECIPE = qCOMMON.comment("Enable/Disable sound on goo recipe execution")
                                .define(Config.Keys.G_FEGOO + "_sound_on_execution_recipe", true);
                GOO_FEGOO_SOUND_EXTRA = qCOMMON.comment("Enable/Disable sound on goo recipe execution randomly")
                                .define(Config.Keys.G_FEGOO + "_extra_sound_on_execution", true);

                qCOMMON.comment(DataGenUtil.txtDecor(Goo.Energized));

                GOO_ENERGY_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange(Goo.Energized + Config.Keys.TIER, 5, 1, Integer.MAX_VALUE);
                GOO_ENERGY_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange(Goo.Energized + Config.Keys.REDUCER, 15, 1, Integer.MAX_VALUE);

                qCOMMON.comment(DataGenUtil.txtDecor(Goo.T1));

                GOO_T1_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange(Goo.T1 + Config.Keys.TIER, 1, 1, Integer.MAX_VALUE);
                GOO_T1_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange(Goo.T1 + Config.Keys.REDUCER, 15, 1, Integer.MAX_VALUE);

                qCOMMON.comment(DataGenUtil.txtDecor(Goo.T2));

                GOO_T2_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange(Goo.T2 + Config.Keys.TIER, 2, 1, Integer.MAX_VALUE);
                GOO_T2_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange(Goo.T2 + Config.Keys.REDUCER, 15, 1, Integer.MAX_VALUE);

                qCOMMON.comment(DataGenUtil.txtDecor(Goo.T3));

                GOO_T3_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange(Goo.T3 + Config.Keys.TIER, 3, 1, Integer.MAX_VALUE);
                GOO_T3_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange(Goo.T3 + Config.Keys.REDUCER, 15, 1, Integer.MAX_VALUE);

                qCOMMON.comment(DataGenUtil.txtDecor(Goo.T4));

                GOO_T4_TIER = qCOMMON
                                .comment("Tier of goo")
                                .defineInRange(Goo.T4 + Config.Keys.TIER, 4, 1, Integer.MAX_VALUE);
                GOO_T4_COUNTER_REDUCER = qCOMMON
                                .comment("Counter Reducer of goo")
                                .defineInRange(Goo.T4 + Config.Keys.REDUCER, 15, 1, Integer.MAX_VALUE);

                qCOMMON.pop();
        }

        private static void solar_panel() {
                qCOMMON.comment(DataGenUtil.txtDecor(Constants.SolarPanelType)).push("5-" + Constants.SolarPanelType);
                qCOMMON.comment(DataGenUtil.txtDecor(SolarPanel.t1));

                SOLARPANEL_FERRICORE_FE_CAPACITY = qCOMMON
                                .comment(Config.Display.FE_MAX)
                                .defineInRange(SolarPanel.t1 + Config.Keys.FE_MAX, 100000, 1, Integer.MAX_VALUE);
                SOLARPANEL_FERRICORE_FE_RATE = qCOMMON
                                .comment(Config.Display.FE_RATE)
                                .defineInRange(SolarPanel.t1 + Config.Keys.FE_RATE, 240, 1, Integer.MAX_VALUE);
                SOLARPANEL_FERRICORE_ENABLE_YLEVEL = qCOMMON
                                .comment(Config.Display.YLEVEL)
                                .define(SolarPanel.t1 + Config.Keys.YLEVEL, false);
                SOLARPANEL_FERRICORE_ENABLE_SPAM = qCOMMON
                                .comment(Config.Display.SPAM)
                                .define(SolarPanel.t1 + Config.Keys.SPAM, false);
                SOLARPANEL_FERRICORE_ENABLE_SKY = qCOMMON
                                .comment(Config.Display.SKY)
                                .define(SolarPanel.t1 + Config.Keys.SKY, true);
                SOLARPANEL_FERRICORE_ENABLE_DAYTIME = qCOMMON
                                .comment(Config.Display.DAY)
                                .define(SolarPanel.t1 + Config.Keys.DAY, true);
                SOLARPANEL_FERRICORE_BIOMES = qCOMMON
                                .comment(Config.Display.BIOMES)
                                .define(SolarPanel.t1 + Config.Keys.BIOMES, true);

                qCOMMON.comment(DataGenUtil.txtDecor(SolarPanel.t2));

                SOLARPANEL_BLAZEGOLD_FE_CAPACITY = qCOMMON
                                .comment(Config.Display.FE_MAX)
                                .defineInRange(SolarPanel.t2 + Config.Keys.FE_MAX, 100000, 1, Integer.MAX_VALUE);
                SOLARPANEL_BLAZEGOLD_FE_RATE = qCOMMON
                                .comment(Config.Display.FE_RATE)
                                .defineInRange(SolarPanel.t2 + Config.Keys.FE_RATE, 960, 1, Integer.MAX_VALUE);
                SOLARPANEL_BLAZEGOLD_ENABLE_YLEVEL = qCOMMON
                                .comment(Config.Display.YLEVEL)
                                .define(SolarPanel.t2 + Config.Keys.YLEVEL, false);
                SOLARPANEL_BLAZEGOLD_ENABLE_SPAM = qCOMMON
                                .comment(Config.Display.SPAM)
                                .define(SolarPanel.t2 + Config.Keys.SPAM, false);
                SOLARPANEL_BLAZEGOLD_ENABLE_SKY = qCOMMON
                                .comment(Config.Display.SKY)
                                .define(SolarPanel.t2 + Config.Keys.SKY, false);
                SOLARPANEL_BLAZEGOLD_ENABLE_DAYTIME = qCOMMON
                                .comment(Config.Display.DAY)
                                .define(SolarPanel.t2 + Config.Keys.DAY, false);
                SOLARPANEL_BLAZEGOLD_BIOMES = qCOMMON
                                .comment(Config.Display.BIOMES)
                                .define(SolarPanel.t2 + Config.Keys.BIOMES, true);

                qCOMMON.comment(DataGenUtil.txtDecor(SolarPanel.t3));

                SOLARPANEL_CELESTIGEM_FE_CAPACITY = qCOMMON
                                .comment(Config.Display.FE_MAX)
                                .defineInRange(SolarPanel.t3 + Config.Keys.FE_MAX, 1000000, 1, Integer.MAX_VALUE);
                SOLARPANEL_CELESTIGEM_FE_RATE = qCOMMON
                                .comment(Config.Display.FE_RATE)
                                .defineInRange(SolarPanel.t3 + Config.Keys.FE_RATE, 3840, 1, Integer.MAX_VALUE);
                SOLARPANEL_CELESTIGEM_ENABLE_YLEVEL = qCOMMON
                                .comment(Config.Display.YLEVEL)
                                .define(SolarPanel.t3 + Config.Keys.YLEVEL, false);
                SOLARPANEL_CELESTIGEM_ENABLE_SPAM = qCOMMON
                                .comment(Config.Display.SPAM)
                                .define(SolarPanel.t3 + Config.Keys.SPAM, true);
                SOLARPANEL_CELESTIGEM_ENABLE_SKY = qCOMMON
                                .comment(Config.Display.SKY)
                                .define(SolarPanel.t3 + Config.Keys.SKY, true);
                SOLARPANEL_CELESTIGEM_ENABLE_DAYTIME = qCOMMON
                                .comment(Config.Display.DAY)
                                .define(SolarPanel.t3 + Config.Keys.DAY, false);
                SOLARPANEL_CELESTIGEM_BIOMES = qCOMMON
                                .comment(Config.Display.BIOMES)
                                .define(SolarPanel.t3 + Config.Keys.BIOMES, false);

                qCOMMON.comment(DataGenUtil.txtDecor(SolarPanel.t4));

                SOLARPANEL_ECLIPSEALLOY_FE_CAPACITY = qCOMMON
                                .comment(Config.Display.FE_MAX)
                                .defineInRange(SolarPanel.t4 + Config.Keys.FE_MAX, 1000000, 1, Integer.MAX_VALUE);
                SOLARPANEL_ECLIPSEALLOY_FE_RATE = qCOMMON
                                .comment(Config.Display.FE_RATE)
                                .defineInRange(SolarPanel.t4 + Config.Keys.FE_RATE, 11520, 1, Integer.MAX_VALUE);
                SOLARPANEL_ECLIPSEALLOY_ENABLE_YLEVEL = qCOMMON
                                .comment(Config.Display.YLEVEL)
                                .define(SolarPanel.t4 + Config.Keys.YLEVEL, true);
                SOLARPANEL_ECLIPSEALLOY_ENABLE_SPAM = qCOMMON
                                .comment(Config.Display.SPAM)
                                .define(SolarPanel.t4 + Config.Keys.SPAM, true);
                SOLARPANEL_ECLIPSEALLOY_ENABLE_SKY = qCOMMON
                                .comment(Config.Display.SKY)
                                .define(SolarPanel.t4 + Config.Keys.SKY, false);
                SOLARPANEL_ECLIPSEALLOY_ENABLE_DAYTIME = qCOMMON
                                .comment(Config.Display.DAY)
                                .define(SolarPanel.t4 + Config.Keys.DAY, false);
                SOLARPANEL_ECLIPSEALLOY_BIOMES = qCOMMON
                                .comment(Config.Display.BIOMES)
                                .define(SolarPanel.t4 + Config.Keys.BIOMES, false);

                qCOMMON.pop();
        }

        private static void anvil() {
                qCOMMON.comment(DataGenUtil.txtDecor(Constants.AnvilType)).push("6-" + Constants.AnvilType);

                ANVILS_SOUND_EVENT = qCOMMON
                                .comment("Enable/Disable the entire sound event of all anvils on item repair")
                                .define(Constants.AnvilType + Config.Keys.SOUND, true);

                qCOMMON.comment(DataGenUtil.txtDecor(Anvils.t1));

                ANVIL_FERRICORE_SOUND_EVENT = qCOMMON
                                .comment("Enable/Disable sound event on item repair")
                                .define(Anvils.t1 + Config.Keys.SOUND, true);

                qCOMMON.comment(DataGenUtil.txtDecor(Anvils.t2));

                ANVILS_BLAZEGOLD_MB_CAPACITY = qCOMMON
                                .comment(Config.Display.MB_MAX)
                                .defineInRange(Anvils.t2 + Config.Keys.MB_MAX, 10000, 1, Integer.MAX_VALUE);
                ANVILS_BLAZEGOLD_MB_RATE = qCOMMON
                                .comment(Config.Display.MB_RATE)
                                .defineInRange(Anvils.t2 + Config.Keys.MB_RATE, 10, 1, Integer.MAX_VALUE);
                ANVIL_BLAZEGOLD_SOUND_EVENT = qCOMMON
                                .comment("Enable/Disable sound event on item repair")
                                .define(Anvils.t2 + Config.Keys.SOUND, true);

                qCOMMON.comment(DataGenUtil.txtDecor(Anvils.t3));

                ANVILS_CELESTIGEM_FE_CAPACITY = qCOMMON
                                .comment(Config.Display.FE_MAX)
                                .defineInRange(Anvils.t3 + Config.Keys.FE_MAX, 10000, 1, Integer.MAX_VALUE);
                ANVILS_CELESTIGEM_FE_RATE = qCOMMON
                                .comment(Config.Display.FE_RATE)
                                .defineInRange(Anvils.t3 + Config.Keys.FE_RATE, 100, 1, Integer.MAX_VALUE);

                ANVIL_CELESTIGEM_SOUND_EVENT = qCOMMON
                                .comment("Enable/Disable sound event on item repair")
                                .define(Anvils.t3 + Config.Keys.SOUND, true);

                qCOMMON.comment(DataGenUtil.txtDecor(Anvils.t4));

                ANVILS_ECLIPSEALLOY_MB_CAPACITY = qCOMMON
                                .comment(Config.Display.MB_MAX)
                                .defineInRange(Anvils.t4 + Config.Keys.MB_MAX, 10000, 1, Integer.MAX_VALUE);
                ANVILS_ECLIPSEALLOY_MB_RATE = qCOMMON
                                .comment(Config.Display.MB_RATE)
                                .defineInRange(Anvils.t4 + Config.Keys.MB_RATE, 100, 1, Integer.MAX_VALUE);
                ANVILS_ECLIPSEALLOY_FE_CAPACITY = qCOMMON
                                .comment(Config.Display.FE_MAX)
                                .defineInRange(Anvils.t4 + Config.Keys.FE_MAX, 10000, 1, Integer.MAX_VALUE);
                ANVILS_ECLIPSEALLOY_FE_RATE = qCOMMON
                                .comment(Config.Display.FE_RATE)
                                .defineInRange(Anvils.t4 + Config.Keys.FE_RATE, 100, 1, Integer.MAX_VALUE);
                ANVILS_ECLIPSEALLOY_DAMAGE_LIMIT = qCOMMON
                                .comment("Minimal damage until it was counted as insta-repaireable")
                                .defineInRange(Anvils.t4 + "_damage_limit", 1000, 1, Integer.MAX_VALUE);

                ANVIL_ECLIPSEALLOY_SOUND_EVENT = qCOMMON
                                .comment("Enable/Disable sound event on item repair")
                                .define(Anvils.t4 + Config.Keys.SOUND, true);

                qCOMMON.pop();
        }

        private static void wands() {
                qCOMMON.comment(DataGenUtil.txtDecor("wands")).push("7-wands");

                PICKER_WAND_FAKE_PLAYER_ALLOWED = qCOMMON
                                .comment("Picker Wand support Fake Players")
                                .define(Wands.Picker + "_allow_fakeplayer", false);

                SWAPPER_FAKE_PLAYER_ALLOWED = qCOMMON
                                .comment("Swapper Wand support Fake Players")
                                .define(Wands.Swapper + "_allow_fakeplayer", false);

                ADVANCED_TIME_WAND_FAKE_PLAYER_ALLOWED = qCOMMON
                                .comment("Advanced Time Wand support Fake Players")
                                .define(Wands.AdvancedTime + "_allow_fakeplayer", true);

                ADVANCED_TIME_WAND_MB_CAPACITY = qCOMMON
                                .comment(Config.Display.MB_MAX)
                                .defineInRange(Wands.AdvancedTime + Config.Keys.MB_MAX, 800_000, 1, Integer.MAX_VALUE);

                ADVANCED_TIME_WAND_FE_CAPACITY = qCOMMON
                                .comment(Config.Display.FE_MAX)
                                .defineInRange(Wands.AdvancedTime + Config.Keys.FE_MAX, 10_000_000, 1,
                                                Integer.MAX_VALUE);

                ADVANCED_TIME_WAND_NORMAL_MODE = qCOMMON.comment(
                                "Mode NORMAL [1|2|4|8]")
                                .define(Wands.AdvancedTime + "_mode_normal", 1,
                                                (value) -> config.validateADW("_mode_normal", value));

                ADVANCED_TIME_WAND_X2_MODE = qCOMMON.comment(
                                "Mode X2 [1|2|4|8]").define(Wands.AdvancedTime + "_mode_x2", 2,
                                                (value) -> config.validateADW("_mode_x2", value));

                ADVANCED_TIME_WAND_X4_MODE = qCOMMON.comment(
                                "Mode X4 [1|2|4|8]").define(Wands.AdvancedTime + "_mode_x4", 4,
                                                (value) -> config.validateADW("_mode_x4", value));

                ADVANCED_TIME_WAND_MAX_MODE = qCOMMON.comment(
                                "Mode MAX [1|2|4|8]").define(Wands.AdvancedTime + "_mode_max", 8,
                                                (value) -> config.validateADW("_mode_max", value));

                ADVANCED_TIME_WAND_MAX_MULTIPLIER = qCOMMON.comment(
                                "Max speed applicable with Advanced Time Wand\n It can disable other wand-modes when below 256\n This value should be a power of two")
                                .define(Wands.AdvancedTime + "_max_multiplier", 256,
                                                (value) -> config.maxADW(value));

                qCOMMON.pop();

        }

        private static void mixer() {
                qCOMMON.comment(DataGenUtil.txtDecor(Blocks.ParadoxMixer)).push("8-" + Blocks.ParadoxMixer);

                PARADOX_MIXER_MB_CAPACITY = qCOMMON
                                .comment(Config.Display.MB_MAX)
                                .defineInRange(Blocks.ParadoxMixer + Config.Keys.MB_MAX, 1000, 1, Integer.MAX_VALUE);

                PARADOX_MIXER_SOUND_EVENT = qCOMMON
                                .comment("Enable/Disable the entire sound event of paradox mixer")
                                .define(Blocks.ParadoxMixer + Config.Keys.SOUND, true);

                qCOMMON.pop();

        }

        private static void ticker() {
                qCOMMON.comment(DataGenUtil.txtDecor(Blocks.Ticker)).push("9-" + Blocks.Ticker);

                TICKER_FE_CAPACITY = qCOMMON
                                .comment(Config.Display.FE_MAX)
                                .defineInRange(Blocks.Ticker + Config.Keys.FE_MAX, 10000, 1, Integer.MAX_VALUE);
                TICKER_FE_RATE = qCOMMON
                                .comment(Config.Display.FE_RATE)
                                .defineInRange(Blocks.Ticker + Config.Keys.FE_RATE, 10, 1, Integer.MAX_VALUE);
                TICKER_MB_CAPACITY = qCOMMON
                                .comment(Config.Display.MB_MAX)
                                .defineInRange(Blocks.Ticker + Config.Keys.MB_MAX, 1000, 1, Integer.MAX_VALUE);
                TICKER_MB_RATE = qCOMMON
                                .comment(Config.Display.MB_RATE)
                                .defineInRange(Blocks.Ticker + Config.Keys.MB_RATE, 1, 1, Integer.MAX_VALUE);

                TICKER_TICK_RATE = qCOMMON
                                .comment("Tick speed applied")
                                .defineInRange(Blocks.Ticker + "_tick_rate", 16, 1, Integer.MAX_VALUE);

                qCOMMON.pop();

        }

        private static void superduperConfig() {
                qCOMMON.comment("Hello player, DevDyna is here !");
                qCOMMON.comment("If you're wondering that this config part");
                qCOMMON.comment("is used as joke , you are right...");
                qCOMMON.comment("Anyway , can I be of help to you ?")
                                .define("answer", false);
        }

}