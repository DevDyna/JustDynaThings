package com.devdyna.justdynathings.init.types;


import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.neoforged.bus.api.IEventBus;

public class zProperties {
        // ---------------------------------------------------------------------------------------//

        public static void register(IEventBus bus) {
        }

        public static final BooleanProperty GOO_ALIVE = GooBlock_Base.ALIVE;
        public static final BooleanProperty SOLID = BooleanProperty.create("solid");
        public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
        public static final BooleanProperty ENERGIZED = BooleanProperty.create("energized");
        public static final BooleanProperty COOLED = BooleanProperty.create("thermo_cooled");
        public static final BooleanProperty HEATED = BooleanProperty.create("thermo_heated");
        public static final BooleanProperty VALID_FACING = BooleanProperty.create("valid_facing");

}