package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.registry.Material;

import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;

public class zEntityTags {
        public static void register(IEventBus bus) {
        }

        public static final TagKey<EntityType<?>> LIGHT_WAND_GLOWING_DENY = Material.tagEntity(Constants.Wands.Light + "_deny");

}
