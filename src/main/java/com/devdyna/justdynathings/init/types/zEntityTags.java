package com.devdyna.justdynathings.init.types;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.cakesticklib.api.RegistryUtils;
import com.devdyna.justdynathings.Constants;

import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;

public class zEntityTags {
        public static void register(IEventBus bus) {
        }

        public static final TagKey<EntityType<?>> LIGHT_WAND_GLOWING_DENY = RegistryUtils.tagEntity(MODULE_ID,
                        Constants.Wands.Light + "_deny");

}