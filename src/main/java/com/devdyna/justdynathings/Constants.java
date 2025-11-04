package com.devdyna.justdynathings;

import java.util.List;

import net.neoforged.fml.ModList;

public class Constants {

    public static String CreativeTab = "creative_tab";

    public class Wands {
        public static String Swapper = "swapper_wand";
        public static String Picker = "picker_wand";
        public static String Stupefy = "temporal_stupefy_wand";
        public static String AdvancedTime = "advanced_time_wand";

    }

    public class GooUpgraders {
        public static String base = "goo_upgrader";
        public static String T1 = base + "_t1";
        public static String T2 = base + "_t2";
        public static String T3 = base + "_t3";
        public static String T4 = base + "_t4";
    }

    public class Blocks {
        public static String PhaseBox = "phase_box";
        public static String Reforger = "reforger";
        public static String FerricoreClock = Tiers.ferricore + "_clock";
        public static String Stabilizer = "stabilizer";
        public static String Ticker = "ticker";
        public static String ThermoGen = "thermo_generator";
        public static String ParadoxMixer = "paradox_mixer";
        public static String BlackHole = "blackhole";
    }

    public static String AnvilType = "anvil";

    public static String SolarPanelType = "solar_panel";

    public class SolarPanel {
        public static String t1 = Tiers.ferricore + "_" + SolarPanelType;
        public static String t2 = Tiers.blazegold + "_" + SolarPanelType;
        public static String t3 = Tiers.celestigem + "_" + SolarPanelType;
        public static String t4 = Tiers.eclipsealloy + "_" + SolarPanelType;
    }

    public class Anvils {
        public static String t1 = Tiers.ferricore + "_" + AnvilType;
        public static String t2 = Tiers.blazegold + "_" + AnvilType;
        public static String t3 = Tiers.celestigem + "_" + AnvilType;
        public static String t4 = Tiers.eclipsealloy + "_" + AnvilType;
    }

    public class Tiers {
        public static String ferricore = "ferricore";
        public static String blazegold = "blazegold";
        public static String celestigem = "celestigem";
        public static String eclipsealloy = "eclipse_alloy";
        public static List<String> materials = List.of(ferricore, blazegold, celestigem, eclipsealloy);
    }

    public static String GooType = "goo";

    public class Goo {

        public static String T1 = "charged_primogel_" + GooType;
        public static String T2 = "charged_blazebloom_" + GooType;
        public static String T3 = "charged_voidshimmer_" + GooType;
        public static String T4 = "charged_shadowpulse_" + GooType;
        public static String Creative = "creative_" + GooType;
        public static String Energized = "energized_" + GooType;
        public static List<String> goos = List.of("primogel", "blazebloom", "voidshimmer", "shadowpulse", "energized");
    }

    public static String BuddingType = "echoing_budding";

    public class Budding {
        public static String Amethyst = BuddingType + "_amethyst";
        public static String Time = BuddingType + "_time";
        public static String Certus = BuddingType + "_certus";
        public static String Entro = BuddingType + "_entro";
        public static String Phasorite = BuddingType + "_phasorite";
    }

    public class ModAddonCheck {
        public static boolean AppliedEnergistics2 = ModList.get().isLoaded("ae2");
        public static boolean ExtendedAE = ModList.get().isLoaded("extendedae");
        public static boolean PhasoriteNetworks = ModList.get().isLoaded("phasoritenetworks");
        public static boolean GuideMe = ModList.get().isLoaded("guideme");
        public static boolean Patchouli = ModList.get().isLoaded("patchouli");

        public static boolean docCheck = !(GuideMe || Patchouli);
    }

    public class DataMaps {
        public class Anvils {
            public static String anvil = "anvils/";
            public static String ferricore_repair = anvil + "ferricore_repair";
            public static String blazegold_repair = anvil + "blazegold_repair";
            public static String eclipsealloy_repair = anvil + "eclipsealloy_repair";
        }

        public class Thermo {
            private static String thermo = "thermo_";
            public static String thermo_heat_sources = thermo + "heat_sources";
            public static String thermo_coolants = thermo + "coolants";
        }

        public class Reforger {
            public static String reforger = "reforger_conversion/";
            public static String block_to_block = reforger + "block_to_block";
            public static String block_to_tag = reforger + "block_to_tag";
            public static String tag_to_block = reforger + "tag_to_block";
        }
    }

    @Deprecated
    public class System {
        public static String Switch(boolean v) {
            return v ? "on" : "off";
        }
    }

    public class Config {

        

        public class Keys
        {
            public static String G_FEGOO = "generic_energy_goo";

        public static String WRENCH = "_require_wrench";
        public static String FE_RATE = "_energy_every_tick";
        public static String FE_MAX = "_max_energy_storage";

        public static String MB_RATE = "_fluid_every_tick";
        public static String MB_MAX = "_max_fluid_storage";
        public static String SOUND = "_emit_sound";

        public static String TIER = "_tier";
        public static String REDUCER = "_counter_reducer";

        public static String YLEVEL = "_reduce_production_at_y_level";
        public static String SPAM = "_reduce_production_when_placed_alone";
        public static String SKY = "_require_to_see_sky";
        public static String DAY = "_require_dayTime";
        public static String BIOMES = "_biomeTag_list";
        }

        public class Display
        {
         

        
        public static String FE_RATE = "FE/t";
        public static String FE_MAX = "FE Capacity";

        public static String MB_RATE = "MB/t";
        public static String MB_MAX = "MB Capacity";
        // public static String SOUND = "Enable/Disable sound event";

        public static String YLEVEL = "Enable/Disable Y-Level multiplier to reduce FE gen based on Y";
        public static String SPAM = "Enable/Disable Solar-Spam multiplier to reduce FE gen based on cheap prices";
        public static String SKY = "Enable/Disable condition to see the sky";
        public static String DAY = "Enable/Disable condition of daytime only";
        public static String BIOMES = "Change the logic of biometag | True == whitelist | False == blacklist";
        }

    }

}