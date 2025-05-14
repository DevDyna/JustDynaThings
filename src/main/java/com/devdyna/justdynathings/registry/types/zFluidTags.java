package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.registry.Material;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;

public class zFluidTags {
    public static void register(IEventBus bus) {

    }

    public static final TagKey<Fluid> THERMO_COOLERS = Material.tagFluid("thermo_coolers");
}
