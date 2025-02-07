package com.devdyna.justdynathings;

public enum Constants {

    Item("item"),
    Block("block"),
    BlockEntity(Block.id+"_entity"),
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

        public enum Chaotic {

            Name("chaotic"),
            Item(Name.id + "_" + "gem"),
            Block("raw_" + Name.id + "_ore"),
            ;

            public final String id;
            Chaotic(String id) {
                this.id = id;
            }
        }

        public enum Goo {

            ID("goo"),
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
        ;

        public final String id;

        ToolTip(String id){
            this.id = id;
        }
    }


}
