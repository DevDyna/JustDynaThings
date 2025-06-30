package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.registry.Material;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.bus.api.IEventBus;

public class zBiomeTags {

        public static void register(IEventBus bus) {

        }

        public static final TagKey<Biome> FERRICORE_SOLAR_PANEL_BIOME_LIST = Material
                        .tagBiome(Constants.SolarPanelType + "s/" + Constants.Tiers.ferricore + "/list");

        public static final TagKey<Biome> BLAZEGOLD_SOLAR_PANEL_BIOME_LIST = Material
                        .tagBiome(Constants.SolarPanelType + "s/" + Constants.Tiers.blazegold + "/list");

        public static final TagKey<Biome> CELESTIGEM_SOLAR_PANEL_BIOME_LIST = Material
                        .tagBiome(Constants.SolarPanelType + "s/" + Constants.Tiers.celestigem + "/list");

        public static final TagKey<Biome> ECLIPSEALLOY_SOLAR_PANEL_BIOME_LIST = Material
                        .tagBiome(Constants.SolarPanelType + "s/" + Constants.Tiers.eclipsealloy + "/list");

}
