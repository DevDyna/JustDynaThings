package com.devdyna.justdynathings.init.types;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.cakesticklib.api.utils.x;
import com.devdyna.justdynathings.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.bus.api.IEventBus;

public class zBiomeTags {

        public static void register(IEventBus bus) {

        }

        // TODO move to api
        @Deprecated
        public static TagKey<Biome> tagBiome(String modname, String id) {
                return TagKey.create(Registries.BIOME, x.rl(modname, id));
        }

        public static final TagKey<Biome> FERRICORE_SOLAR_PANEL_BIOME_LIST = tagBiome(MODULE_ID,
                        Constants.SolarPanelType + "s/" + Constants.Tiers.ferricore + "_allow");

        public static final TagKey<Biome> BLAZEGOLD_SOLAR_PANEL_BIOME_LIST = tagBiome(MODULE_ID,
                        Constants.SolarPanelType + "s/" + Constants.Tiers.blazegold + "_allow");

        public static final TagKey<Biome> CELESTIGEM_SOLAR_PANEL_BIOME_LIST = tagBiome(MODULE_ID,
                        Constants.SolarPanelType + "s/" + Constants.Tiers.celestigem + "_allow");

        public static final TagKey<Biome> ECLIPSEALLOY_SOLAR_PANEL_BIOME_LIST = tagBiome(MODULE_ID,
                        Constants.SolarPanelType + "s/" + Constants.Tiers.eclipsealloy + "_allow");

}