package com.devdyna.justdynathings;

import net.neoforged.fml.ModList;

public enum Constants {

    Item("item"),
    Block("block"),
    BlockEntity(Block.id + "_entity"),
    GUI("gui"),
    CreativeTab("creative_tab"),
    ;

    public final String id;

    Constants(String id) {
        this.id = id;
    }

    public enum Material {

        PhaseBox("phase_box"),
        MetalBlock("metal_block"),
        Reforger("reforger"),
        BlazingAnvil("blazing_anvil"),
        Clock("clock"),
        Revitalizer("revitalizer"),
        ;

        public final String id;

        Material(String id) {
            this.id = id;
        }

        public enum Ore {

            Chaotic("chaotic"),
            Chaotic_Item(Chaotic.id + "_gem"),
            Chaotic_Block("raw_" + Chaotic.id + "_ore"),

            Redstonic("redstonic"),
            Redstonic_Item(Redstonic.id + "_shard"),
            Redstonic_Block("raw_" + Redstonic.id + "_ore"),

            Coprinium("coprinium"),
            Coprinium_Raw("raw_"+Coprinium.id),
            Coprinium_Ingot(Coprinium.id + "_ingot"),
            Coprinium_Block("raw_" + Coprinium.id + "_ore"),
            ;

            public final String id;

            Ore(String id) {
                this.id = id;
            }
        }

        public enum Goo {

            ID("goo"),
            T1("primogel"),
            T2("blazebloom"),
            T3("voidshimmer"),
            T4("shadowpulse"),
            Rotten("rotten"),
            Complex("complex"),
            Creative("creative"),
            Energized("energized"),
            ;

            public final String id;

            Goo(String id) {
                this.id = id;
            }

        }

        public enum Budding {

            ID("budding"),
            Powered("powered"),
            Time(ID.id+"_time"),
            Amethyst(ID.id+"_amethyst"),
            Certus(ID.id+"_certus"),
            Entro(ID.id+"_entro"),
            Phasorite(ID.id+"_phasorite"),
            ;

            public final String id;

            Budding(String id) {
                this.id = id;
            }
        }

    }

    public enum RevitalizerFE {
        Cost(1000),
        Capacity(100000),
        ;

        public final int value;

        RevitalizerFE(int value) {
            this.value = value;
        }
    }



    public enum BlazingAnvilFE {
        Cost(1000),
        Capacity(100000),
        ;

        public final int value;

        BlazingAnvilFE(int value) {
            this.value = value;
        }
    }

    public enum FEGoo {
        Cost(250),
        Capacity(10000),
        ;

        public final int value;

        FEGoo(int value) {
            this.value = value;
        }
    }

    public enum FEBudding {
        FECost(1),
        FECapacity(10000),
        FLCost(1),
        FLCapacity(10000),
        ;

        public final int value;

        FEBudding(int value) {
            this.value = value;
        }
    }

    public enum Mods {
        AE2(ModList.get().isLoaded("ae2")),
        ExtendedAE(ModList.get().isLoaded("extendedae")),
        PhasoriteNetworks(ModList.get().isLoaded("phasoritenetworks")),
        GuideMe(ModList.get().isLoaded("guideme")),
        ;

        public final boolean check;

        Mods(boolean check) {
            this.check = check;
        }
    }


    public enum Traslable {
        on("on"),
        off("off"),
        delay("delay"),
        ;

        public final String value;

        Traslable(String value) {
            this.value = value;
        }
    }
}
