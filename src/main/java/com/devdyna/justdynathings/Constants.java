package com.devdyna.justdynathings;

import net.neoforged.fml.ModList;

public class Constants {

    // public class Types {
    // public static String Item = "item";
    // public static String Block = "block";
    // public static String BlockEntity = "blockentity";
    // public static String Container = "container";
    public static String CreativeTab = "creative_tab";
    // }

    public class Blocks {
        public static String PhaseBox = "phase_box";
        public static String Reforger = "reforger";
        public static String BlazingAnvil = "blazing_anvil";
        public static String FerricoreClock = "ferricore_clock";
        public static String Revitalizer = "revitalizer";
        public static String Ticker = "ticker";
        public static String Sculk = "sculk";
        public static String ThermoGen = "thermo_generator";
        public static String SolarGen = "solar_panel";
        public static String BlackHole = "blackhole";
    }

    public static String GooType = "goo";

    public class Goo {

        public static String T1 = "charged_primogel";
        public static String T2 = "charged_blazebloom";
        public static String T3 = "charged_voidshimmer";
        public static String T4 = "charged_shadowpulse";
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

    public static String EMBER = "ember";

    public class Fuel {

        /**
         * @unused
         *         Values of JDT coals
         */
        public static int[] DW_FUEL_VALUES = { 2, 4, 8, 16 };

        public static String BIOFUEL = "bio_fuel"; // TODO NYI

        public static String REDSTONE = "redstone_" + EMBER;
        public static String LAPIS_LAZULI = "lapis_lazuli_" + EMBER;

        public class redstone {
            public static String Block = REDSTONE + "_block";
            public static String Raw = "raw_" + REDSTONE;
        }

        public class lapis_lazuli {
            public static String Block = LAPIS_LAZULI + "_block";
            public static String Raw = "raw_" + LAPIS_LAZULI;
        }

    }

    public class Fluids {
        public static String REDSTONE_JUICE = "redstone_juice";
        public static String LAPIS_LAZULI_JUICE = "lapis_lazuli_juice";

        public class RedstoneJuice {
            public static String Block = REDSTONE_JUICE + "_block";
            public static String Type = REDSTONE_JUICE + "_fluid";
            public static String Source = REDSTONE_JUICE + "_fluid_source";
            public static String Flowing = REDSTONE_JUICE + "_fluid_flowing";
            public static String Bucket = REDSTONE_JUICE + "_bucket_item";
        }

        public class LapisLazuliJuice {
            public static String Block = LAPIS_LAZULI_JUICE + "_block";
            public static String Type = LAPIS_LAZULI_JUICE + "_fluid";
            public static String Source = LAPIS_LAZULI_JUICE + "_fluid_source";
            public static String Flowing = LAPIS_LAZULI_JUICE + "_fluid_flowing";
            public static String Bucket = LAPIS_LAZULI_JUICE + "_bucket_item";
        }
    }

}