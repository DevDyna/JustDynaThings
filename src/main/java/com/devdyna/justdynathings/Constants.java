package com.devdyna.justdynathings;

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

    }

    public enum ToolTip {
        On("on"),
        Off("off"),
        Goo("goo");

        public final String id;

        ToolTip(String id) {
            this.id = id;
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

}
