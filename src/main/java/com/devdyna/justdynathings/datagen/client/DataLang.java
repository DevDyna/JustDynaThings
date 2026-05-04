package com.devdyna.justdynathings.datagen.client;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.justdynathings.Constants;

import static com.devdyna.cakesticklib.api.datagen.LangUtils.*;

import com.devdyna.justdynathings.init.types.zBlocks;
import com.devdyna.justdynathings.init.types.zItems;
import com.direwolf20.justdirethings.setup.JDTRegistration;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class DataLang extends LanguageProvider {

        public DataLang(PackOutput o) {
                super(o, MODULE_ID, "en_us");
        }

        @Override
        protected void addTranslations() {

                zItems.zItem.getEntries().forEach(i -> addItem(i, named(i, MODULE_ID)));
                zItems.zGooUpgraders.getEntries().forEach(i -> addItem(i, named(i, MODULE_ID)));
                zItems.zWands.getEntries().forEach(i -> addItem(i, named(i, MODULE_ID)));
                zBlocks.zBlockItem.getEntries().forEach(i -> addBlock(i, named(i, MODULE_ID)));
                // zBlocks.zHidden.getEntries().forEach(i -> addBlock(i, named(i, MODULE_ID)));

                // TODO check unused tk

                add(MODULE_ID + ".invalid_block", "§cInvalid Block");
                add(MODULE_ID + ".wand.blockstate", "§7BlockState : ");
                add(MODULE_ID + ".wand.dimension", "§7Dimension : ");
                add(MODULE_ID + ".wand.pos", "§7BlockPos : ");
                add(MODULE_ID + ".disabled", "§cItem Disabled");

                add(MODULE_ID + "." + Constants.Blocks.Reforger,
                                "§7Convert blocks using a catalyst to other blocks");

                add(MODULE_ID + "." + Constants.Anvils.t1,
                                "§7Repair items using metallic ingots");

                add(MODULE_ID + "." + Constants.Anvils.t2,
                                "§7Repair items using hot fluids");

                add(MODULE_ID + "." + Constants.Anvils.t3,
                                "§7Repair items using Forge Energy");

                add(MODULE_ID + "." + Constants.Anvils.t4,
                                "§7Repair items using Time Fluid");

                // add(MODULE_ID + "." + Constants.Anvils.t4 + ".boost",
                // "§7Can be boosted using Time Fluid");

                // add(MODULE_ID + "." + Constants.BuddingType,
                // "§7Grow clusters using Time Fluid and Forge Energy");

                // creative tab
                // add(MODULE_ID + "." + Constants.CreativeTab, "Just Dyna Things");

                // wip
                // add(MODULE_ID + ".clock.wip", "N.Y.I. -> shift-click the block to toggle");

                // missing guideme
                // add(MODULE_ID + ".doc.missing", "§aFor more info consider to install GuideMe
                // or Patchouli");

                // generic type tooltips
                add(MODULE_ID + "." + Constants.GooType + "." + Constants.Goo.Energized,
                                "§cProvide energy to active it");
                add(MODULE_ID + "." + Constants.GooType + "." + Constants.Goo.Creative,
                                "§cRight click with a wrench to toggle alive state");
                add(MODULE_ID + "." + Constants.SolarPanelType, "§7Generate Energy from ambiental situations");
                // add(MODULE_ID + "." + Constants.Blocks.ThermoGen,
                // "§7Generate Energy from heat sources and coolants");

                add(MODULE_ID + "." + Constants.Blocks.Stabilizer,
                                "§7Feed Goo blocks and Buddings blocks");
                add(MODULE_ID + "." + Constants.Blocks.simple_fluid_mixer,
                                "§7Allow to mass-craft fluid drop recipes");

                add(MODULE_ID + "." + Constants.Blocks.Ticker,
                                "§7A block that act at same of a time wand but configurable!");

                add(MODULE_ID + "." + Constants.GooUpgraders.base,
                                "§7Right click on a goo to upgrade it to the next tier");
                add(MODULE_ID + "." + Constants.Wands.Picker,
                                "§7Allow to pickup simple blocks and place where you want");
                add(MODULE_ID + "." + Constants.Wands.Swapper, "§7Allow to swap simple blocks without break it");

                add(MODULE_ID + "." + Constants.GooType + ".tier", "§7Goo Tier: ");

                add(MODULE_ID + "." + Constants.SolarPanelType + ".ferate", "§7Max FE rate : ");

                add(MODULE_ID + ".init_invalid", "§cInitial Block isn't anymore valid");
                add(MODULE_ID + ".clear_pos", "Position Cleared");

                add(MODULE_ID + "." + Constants.Wands.AdvancedTime,
                                "§7More capable and configurable version of Time wand");

                add(MODULE_ID + "." + Constants.Wands.AdvancedTime + ".mode.disabled", "§cThis Mode was disabled");
                add(MODULE_ID + "." + Constants.Wands.AdvancedTime + ".mode.reset", "This wand is ready to be used!");

                add(MODULE_ID + "." + Constants.Wands.AdvancedTime + ".tip.normal", "Mode set to §aNormal");
                add(MODULE_ID + "." + Constants.Wands.AdvancedTime + ".tip.x2", "Mode set to §a2x");
                add(MODULE_ID + "." + Constants.Wands.AdvancedTime + ".tip.x4", "Mode set to §a4x");
                add(MODULE_ID + "." + Constants.Wands.AdvancedTime + ".tip.max", "Mode set to §aMax");

                add(MODULE_ID + "." + Constants.Wands.AdvancedTime + ".mode.normal", "1x");
                add(MODULE_ID + "." + Constants.Wands.AdvancedTime + ".mode.x2", "2x");
                add(MODULE_ID + "." + Constants.Wands.AdvancedTime + ".mode.x4", "4x");
                add(MODULE_ID + "." + Constants.Wands.AdvancedTime + ".mode.max", "8x");

                add(MODULE_ID + "." + Constants.Wands.Stupefy, "§7Remove TimeWand Entities and Stupefy ability");

                add(MODULE_ID + ".jei.warning", "Item form doesn't exist or doesn't respect the block placed!");

                add(MODULE_ID + ".jei.category." + JDTRegistration.GeneratorT1_ITEM.getId().getPath(),
                                "Solid Generator Fuels");
                add(MODULE_ID + ".jei.category." + JDTRegistration.GeneratorFluidT1_ITEM.getId().getPath(),
                                "Fluid Generator Fuels");

                add(MODULE_ID + ".jei.time", "Duration");
                add(MODULE_ID + ".jei.rate", "FE production");
                add(MODULE_ID + ".jei.total", "Total FE produced");

                add(MODULE_ID + ".jei.bucket", "Every Bucket");

                // add(MODULE_ID + "." + Constants.Blocks.simple_fluid_mixer + ".unstable",
                // "Energized Stabilizer not found");

                addBlock(zBlocks.LIGHT_WAND_BLOCK, "Light Wand Block");

                add(MODULE_ID + "." + Constants.BuddingType + ".break", "§cDoesn't drop when broken!");

                // required to render disabled items
                // zCompat.getEchoingBuddingTypes.forEach(k -> add("item." + ID + "." + k,
                // named(k)));
                // zCompat.getChiselItems.forEach(k -> add("item." + ID + "." + k, named(k)));

                add(MODULE_ID + ".hold_control", "§7Hold Control for Chisel detailts");

                add(MODULE_ID + "." + Constants.BuddingType + ".jade.fe", "§cRequire ForgeEnergy");
                add(MODULE_ID + "." + Constants.BuddingType + ".jade.time", "§cRequire Time Fluid");

                add(MODULE_ID + "." + Constants.Blocks.Stabilizer + ".jade.goo", "Revive Goo");
                add(MODULE_ID + "." + Constants.Blocks.Stabilizer + ".jade.energized", "Revive Time Budding");
                // add(MODULE_ID + "." + Constants.Blocks.ParadoxMixer + ".jade.dead",
                // "§cRequire a Stabilizer energized!");

                // add("config.jade.plugin_" + MODULE_ID + "." + Constants.BuddingType, "Echoing
                // Buddings Requirements");
                // add("config.jade.plugin_" + MODULE_ID + "." + Constants.Blocks.Stabilizer,
                // "Stabilizer Abilities");
                // add("config.jade.plugin_" + MODULE_ID + "." + Constants.Blocks.ParadoxMixer,
                // "Paradox Mixer Requirements");

                add(MODULE_ID + ".configuration.entry_anvils", "Functional Anvils");
                add(MODULE_ID + ".configuration.entry_blocks", "Misc Blocks");
                add(MODULE_ID + ".configuration.entry_goo", "Mo'Goo");
                add(MODULE_ID + ".configuration.entry_misc", "Misc stuff");
                add(MODULE_ID + ".configuration.entry_solar_panels", "Solar Panels");
                add(MODULE_ID + ".configuration.entry_wands", "Wands");

                // wands
                add(MODULE_ID + ".configuration.light_wand_allow_fakeplayer", "Light wand allow Fakeplayers");
                add(MODULE_ID + ".configuration.light_wand_block_particles", "Light Wand Block emit Particles");
                add(MODULE_ID + ".configuration.light_wand_energy_every_tick", "Light wand FE cost");
                add(MODULE_ID + ".configuration.light_wand_glowing", "Light wand entity glowing");
                add(MODULE_ID + ".configuration.light_wand_glowing_duration", "Entity glowing duration");
                add(MODULE_ID + ".configuration.light_wand_light_level_change", "Light wand light level change");
                add(MODULE_ID + ".configuration.light_wand_max_energy_storage", "Light wand energy storage");
                add(MODULE_ID + ".configuration.light_wand_placing", "Light wand placing light blocks");
                add(MODULE_ID + ".configuration.light_wand_sound", "Light wand sounds");
                add(MODULE_ID + ".configuration.advanced_light_wand_glowing_duration",
                                "Advanced Light wand glowing duration");
                add(MODULE_ID + ".configuration.advanced_time_wand_allow_fakeplayer",
                                "Advanced Time wand allow Fakeplayers");
                add(MODULE_ID + ".configuration.advanced_time_wand_max_energy_storage",
                                "Advanced Time wand max energy storage");
                add(MODULE_ID + ".configuration.advanced_time_wand_max_fluid_storage",
                                "Advanced Time wand max fluid storage");
                add(MODULE_ID + ".configuration.advanced_time_wand_max_multiplier",
                                "Advanced Time wand max multiplier");
                add(MODULE_ID + ".configuration.advanced_time_wand_mode_max", "Advanced Time wand mode max");
                add(MODULE_ID + ".configuration.advanced_time_wand_mode_normal", "Advanced Time wand max mode normal");
                add(MODULE_ID + ".configuration.advanced_time_wand_mode_x2", "Advanced Time wand max mode 2x");
                add(MODULE_ID + ".configuration.advanced_time_wand_mode_x4", "Advanced Time wand max mode 4x");

                add(MODULE_ID + ".configuration.picker_wand_allow_fakeplayer", "Picker wand allow Fakeplayers");

                add(MODULE_ID + ".configuration.swapper_wand_allow_fakeplayer", "Swapper wand allow Fakeplayers");

                // misc
                add(MODULE_ID + ".configuration.answer", "A questionable question");
                add(MODULE_ID + ".configuration.include_any_jei_fuels", "Include Any Fuel to JEI fuel category");

                // stabilizer
                add(MODULE_ID + ".configuration.stabilizer_emit_sound", "Stabilizer emit sound");
                add(MODULE_ID + ".configuration.stabilizer_energy_every_tick", "Stabilizer energy every tick");
                add(MODULE_ID + ".configuration.stabilizer_fluid_every_tick", "Stabilizer fluid every tick");
                add(MODULE_ID + ".configuration.stabilizer_max_energy_storage", "Stabilizer max energy storage");
                add(MODULE_ID + ".configuration.stabilizer_max_fluid_storage", "Stabilizer max fluid storage");

                // blackhole
                add(MODULE_ID + ".configuration.blackhole_energy_every_tick", "BlackHole energy consumed every tick");
                add(MODULE_ID + ".configuration.blackhole_fluid_every_tick", "BlackHole fluid consumed every tick");
                add(MODULE_ID + ".configuration.blackhole_keep_content", "BlackHole keep content when redstone off");
                add(MODULE_ID + ".configuration.blackhole_max_energy_storage", "BlackHole max energy storage");
                add(MODULE_ID + ".configuration.blackhole_max_fluid_storage", "BlackHole max fluid storage");

                // ticker
                add(MODULE_ID + ".configuration.ticker_energy_every_tick", "Ticker energy every tick");
                add(MODULE_ID + ".configuration.ticker_fluid_every_tick", "Ticker fluid every tick");
                add(MODULE_ID + ".configuration.ticker_max_energy_storage", "Ticker max energy storage");
                add(MODULE_ID + ".configuration.ticker_max_fluid_storage", "Ticker max fluid storage");
                add(MODULE_ID + ".configuration.ticker_tick_limit", "Ticker tick limiter");

                // anvils
                add(MODULE_ID + ".configuration.anvil_emit_sound", "Anvils can emit sounds");

                add(MODULE_ID + ".configuration.ferricore_anvil_emit_sound", "FerricoreAnvil emit sounds");
                add(MODULE_ID + ".configuration.ferricore_anvil_ignore_delay", "FerricoreAnvil ignore repair delay");

                add(MODULE_ID + ".configuration.blazegold_anvil_emit_sound", "BlazeGoldAnvil emit sounds");
                add(MODULE_ID + ".configuration.blazegold_anvil_ignore_delay", "BlazeGoldAnvil ignore repair delay");
                add(MODULE_ID + ".configuration.blazegold_anvil_max_fluid_storage", "BlazeGoldAnvil max fluid storage");

                add(MODULE_ID + ".configuration.celestigem_anvil_energy_every_tick", "CelestiGemAnvil energy usage");
                add(MODULE_ID + ".configuration.celestigem_anvil_emit_sound", "CelestiGemAnvil emit sounds");
                add(MODULE_ID + ".configuration.celestigem_anvil_ignore_delay", "CelestiGemAnvil ignore repair delay");
                add(MODULE_ID + ".configuration.celestigem_anvil_max_energy_storage",
                                "CelestiGemAnvil max energy storage");

                add(MODULE_ID + ".configuration.eclipse_alloy_anvil_emit_sound", "EclipseAlloyAnvil emit sounds");
                add(MODULE_ID + ".configuration.eclipse_alloy_anvil_ignore_delay",
                                "EclipseAlloyAnvil ignore repair delay");
                add(MODULE_ID + ".configuration.eclipse_alloy_anvil_max_fluid_storage",
                                "EclipseAlloyAnvil max fluid storage");

                // solar_panel
                add(MODULE_ID + ".configuration.ferricore_solar_panel_biomeTag_list",
                                "FerricoreSolarPanel biomelist whitelist");
                add(MODULE_ID + ".configuration.ferricore_solar_panel_energy_every_tick",
                                "FerricoreSolarPanel energy every tick");
                add(MODULE_ID + ".configuration.ferricore_solar_panel_max_energy_storage",
                                "FerricoreSolarPanel max energy storage");
                add(MODULE_ID + ".configuration.ferricore_solar_panel_reduce_production_at_y_level",
                                "FerricoreSolarPanel reduce production at y level");
                add(MODULE_ID + ".configuration.ferricore_solar_panel_reduce_production_when_placed_alone",
                                "FerricoreSolarPanel when placed alone");
                add(MODULE_ID + ".configuration.ferricore_solar_panel_require_dayTime",
                                "FerricoreSolarPanel require daytime");
                add(MODULE_ID + ".configuration.ferricore_solar_panel_require_to_see_sky",
                                "FerricoreSolarPanel require to see sky");

                add(MODULE_ID + ".configuration.blazegold_solar_panel_biomeTag_list",
                                "BLazeGoldSolarPanel biomelist whitelist");
                add(MODULE_ID + ".configuration.blazegold_solar_panel_energy_every_tick",
                                "BLazeGoldSolarPanel energy every tick");
                add(MODULE_ID + ".configuration.blazegold_solar_panel_max_energy_storage",
                                "BLazeGoldSolarPanel max energy storage");
                add(MODULE_ID + ".configuration.blazegold_solar_panel_reduce_production_at_y_level",
                                "BLazeGoldSolarPanel reduce production at y level");
                add(MODULE_ID + ".configuration.blazegold_solar_panel_reduce_production_when_placed_alone",
                                "BLazeGoldSolarPanel when placed alone");
                add(MODULE_ID + ".configuration.blazegold_solar_panel_require_dayTime",
                                "BLazeGoldSolarPanel require daytime");
                add(MODULE_ID + ".configuration.blazegold_solar_panel_require_to_see_sky",
                                "BLazeGoldSolarPanel require to see sky");

                add(MODULE_ID + ".configuration.celestigem_solar_panel_biomeTag_list",
                                "CelestigemSolarPanel biomelist whitelist");
                add(MODULE_ID + ".configuration.celestigem_solar_panel_energy_every_tick",
                                "CelestigemSolarPanel energy every tick");
                add(MODULE_ID + ".configuration.celestigem_solar_panel_max_energy_storage",
                                "CelestigemSolarPanel max energy storage");
                add(MODULE_ID + ".configuration.celestigem_solar_panel_reduce_production_at_y_level",
                                "CelestigemSolarPanel reduce production at y level");
                add(MODULE_ID + ".configuration.celestigem_solar_panel_reduce_production_when_placed_alone",
                                "CelestigemSolarPanel when placed alone");
                add(MODULE_ID + ".configuration.celestigem_solar_panel_require_dayTime",
                                "CelestigemSolarPanel require daytime");
                add(MODULE_ID + ".configuration.celestigem_solar_panel_require_to_see_sky",
                                "CelestigemSolarPanel require to see sky");

                add(MODULE_ID + ".configuration.eclipse_alloy_solar_panel_biomeTag_list",
                                "EclipseAlloySolarPanel biomelist whitelist");
                add(MODULE_ID + ".configuration.eclipse_alloy_solar_panel_energy_every_tick",
                                "EclipseAlloySolarPanel energy every tick");
                add(MODULE_ID + ".configuration.eclipse_alloy_solar_panel_max_energy_storage",
                                "EclipseAlloySolarPanel max energy storage");
                add(MODULE_ID + ".configuration.eclipse_alloy_solar_panel_reduce_production_at_y_level",
                                "EclipseAlloySolarPanel reduce production at y level");
                add(MODULE_ID + ".configuration.eclipse_alloy_solar_panel_reduce_production_when_placed_alone",
                                "EclipseAlloySolarPanel when placed alone");
                add(MODULE_ID + ".configuration.eclipse_alloy_solar_panel_require_dayTime",
                                "EclipseAlloySolarPanel require daytime");
                add(MODULE_ID + ".configuration.eclipse_alloy_solar_panel_require_to_see_sky",
                                "EclipseAlloySolarPanel require to see sky");

                // goo
                add(MODULE_ID + ".configuration.generic_energy_goo_energy_every_tick",
                                "Generic energy goo energy every tick");
                add(MODULE_ID + ".configuration.generic_energy_goo_extra_sound_on_execution",
                                "Generic energy goo extra sound on execution");
                add(MODULE_ID + ".configuration.generic_energy_goo_max_energy_storage",
                                "Generic energy goo max energy storage");
                add(MODULE_ID + ".configuration.generic_energy_goo_sound_on_execution_recipe",
                                "Generic energy goo sound on execution recipe");
                add(MODULE_ID + ".configuration.generic_energy_goo_tier_multiply_energy_capacity",
                                "Generic energy goo tier multiply energy capacity");
                add(MODULE_ID + ".configuration.generic_energy_goo_tier_multiply_energy_cost",
                                "Generic energy goo tier multiply energy cost");

                add(MODULE_ID + ".configuration.charged_primogel_goo_counter_reducer",
                                "Charged Primogel Goo counter reducer");
                add(MODULE_ID + ".configuration.charged_primogel_goo_tier", "Charged Primogel Goo tier");

                add(MODULE_ID + ".configuration.charged_blazebloom_goo_counter_reducer",
                                "Charged BlazeBloom Goo counter reducer");
                add(MODULE_ID + ".configuration.charged_blazebloom_goo_tier", "Charged BlazeBloom Goo tier");

                add(MODULE_ID + ".configuration.charged_voidshimmer_goo_counter_reducer",
                                "Charged VoidShimmer Goo counter reducer");
                add(MODULE_ID + ".configuration.charged_voidshimmer_goo_tier", "Charged VoidShimmer Goo tier");

                add(MODULE_ID + ".configuration.charged_shadowpulse_goo_counter_reducer",
                                "Charged ShadowPulse Goo counter reducer");
                add(MODULE_ID + ".configuration.charged_shadowpulse_goo_tier", "Charged ShadowPulse Goo tier");

                add(MODULE_ID + ".configuration.creative_goo_counter_reducer", "Creative Goo counter reducer");
                add(MODULE_ID + ".configuration.creative_goo_sound_on_change_state",
                                "Creative Goo sound on change state");
                add(MODULE_ID + ".configuration.creative_goo_sound_on_execution_recipe",
                                "Creative Goo sound on ececution recipe");
                add(MODULE_ID + ".configuration.creative_goo_tier", "Creative Goo tier");

                add(MODULE_ID + ".configuration.ferricore_clock_require_wrench",
                                "Ferricore Clock require wrench to change face");

                // add(MODULE_ID + ".configuration.include_any_jei_fuels", "##DESC##");

                add(MODULE_ID + ".configuration.phase_box_require_wrench", "PhaseBox require wrench to change state");

        }

}
