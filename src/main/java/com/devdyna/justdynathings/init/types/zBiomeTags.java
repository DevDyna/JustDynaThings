package com.devdyna.justdynathings.init.types;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.cakesticklib.api.RegistryUtils;
import com.devdyna.justdynathings.Constants;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.bus.api.IEventBus;

public class zBiomeTags {

        public static void register(IEventBus bus) {

        }

        public static final TagKey<Biome> FERRICORE_SOLAR_PANEL_BIOME_LIST = RegistryUtils.tagBiome(MODULE_ID,
                        Constants.SolarPanelType + "s/" + Constants.Tiers.ferricore + "_allow");

        public static final TagKey<Biome> BLAZEGOLD_SOLAR_PANEL_BIOME_LIST = RegistryUtils.tagBiome(MODULE_ID,
                        Constants.SolarPanelType + "s/" + Constants.Tiers.blazegold + "_allow");

        public static final TagKey<Biome> CELESTIGEM_SOLAR_PANEL_BIOME_LIST = RegistryUtils.tagBiome(MODULE_ID,
                        Constants.SolarPanelType + "s/" + Constants.Tiers.celestigem + "_allow");

        public static final TagKey<Biome> ECLIPSEALLOY_SOLAR_PANEL_BIOME_LIST = RegistryUtils.tagBiome(MODULE_ID,
                        Constants.SolarPanelType + "s/" + Constants.Tiers.eclipsealloy + "_allow");

}