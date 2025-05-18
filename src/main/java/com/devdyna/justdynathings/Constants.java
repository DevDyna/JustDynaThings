package com.devdyna.justdynathings;

import java.util.List;

import net.neoforged.fml.ModList;

public class Constants {

    public static String CreativeTab = "creative_tab";

    public class Blocks {
        public static String PhaseBox = "phase_box";
        public static String Reforger = "reforger";
        public static String FerricoreClock = "ferricore_clock";
        public static String Revitalizer = "revitalizer";
        public static String Ticker = "ticker";
        public static String Sculk = "sculk";
        public static String ThermoGen = "thermo_generator";
        public static String BlackHole = "blackhole";
    }

    public static String AnvilType = "anvil";

    public static String SolarPanelType = "solar_panel";

    public class TieredStuff {

        public class SolarPanel {
            public static String t1 = Tiers.ferricore + SolarPanelType;
            public static String t2 = Tiers.blazegold + SolarPanelType;
            public static String t3 = Tiers.celestigem + SolarPanelType;
            public static String t4 = Tiers.eclipsealloy + SolarPanelType;
        }

        public class Anvils {
            public static String t1 = Tiers.ferricore + AnvilType;
            public static String t2 = Tiers.blazegold + AnvilType;
            public static String t3 = Tiers.celestigem + AnvilType;
            public static String t4 = Tiers.eclipsealloy + AnvilType;
        }

    }

    public class Tiers {
        public static String ferricore = "ferricore_";
        public static String blazegold = "blazegold_";
        public static String celestigem = "celestigem_";
        public static String eclipsealloy = "eclipse_alloy_";
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
        public static boolean GuideMe = ModList.get().isLoaded("guideme");
        public static boolean PhasoriteNetworks = ModList.get().isLoaded("phasoritenetworks");
    }

    public class System {
        public static String Switch(boolean v) {
            return v ? "on" : "off";
        }
    }

}