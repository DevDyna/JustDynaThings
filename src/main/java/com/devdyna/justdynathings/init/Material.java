package com.devdyna.justdynathings.init;

import com.devdyna.justdynathings.init.types.*;

import net.neoforged.bus.api.IEventBus;

public class Material {
        public static void register(IEventBus bus) {
                zBiomeTags.register(bus);
                zBlockEntities.register(bus);
                zBlocks.register(bus);
                zBlockTags.register(bus);
                zComponents.register(bus);
                zContainers.register(bus);
                zEntityTags.register(bus);
                zItems.register(bus);
                zItemTags.register(bus);
                zProperties.register(bus);
                zRecipeTypes.register(bus);

        }

}
