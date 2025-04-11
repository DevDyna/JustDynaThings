package com.devdyna.justdynathings;

import net.neoforged.fml.ModList;

public class Constants {

    // public class Types {
    //     public static String Item = "item";
    //     public static String Block = "block";
    //     public static String BlockEntity = "blockentity";
    //     public static String Container = "container";
        public static String CreativeTab = "creative_tab";
    // }

    public class Blocks {
        public static String PhaseBox = "phase_box";
        public static String Reforger = "reforger";
        public static String BlazingAnvil = "blazing_anvil";
        public static String FerritecoreClock = "ferritecore_clock";
        public static String Revitalizer = "revitalizer";
        public static String Ticker = "ticker";
        public static String Sculk = "sculk";
    }

    public class Ores {
        public static String ChaoticType = "chaotic";

        public static class Chaotic {
            public static String dust = ChaoticType + "_dust";
            public static String ore = ChaoticType + "_ore";
        }

        public static String RedstonicType = "redstonic";

        public class Redstonic {
            public static String gem = RedstonicType + "_gem";
            public static String ore = RedstonicType + "_ore";
        }

        public static String CopriniumType = "coprinium";

        public class Coprinium {
            public static String raw = "raw_" + CopriniumType;
            public static String ingot = CopriniumType + "_ingot";
            public static String ore = CopriniumType + "_ore";

        }
    }

    public static String GooType = "goo";

    public class Goo {

        // public static String Primogel = "primogel";
        // public static String Blazebloom = "blazebloom";
        // public static String Voidshimmer = "voidshimmer";
        // public static String Shadowpulse = "shadowpulse";
        // public static String Powered = "powered";
        public static String Creative = "creative";
        public static String Energized = "energized";
    }

    public static String BuddingType = "budding";

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

    public class Fuel {

        /**
         * Values of JDT coals
         */
        public static int[] DW_FUEL_VALUES = { 2, 4, 8, 16 };

        public static String BIOFUEL = "biofuel";

        public static String Biofuel(int num) {
            return BIOFUEL + "_" + String.valueOf(num);
        }
    }

    public class Fluids {
        public static String CRYSTALLINE = "liquid_crystalline";

        public class Crystalline {
            public static String Block = CRYSTALLINE+"_block";
            public static String Type = CRYSTALLINE+"_fluid";
            public static String Source= CRYSTALLINE+"_fluid_source";
            public static String Flowing= CRYSTALLINE+"_fluid_flowing";
            public static String Bucket= CRYSTALLINE+"_bucket_item";
        }
    }

}