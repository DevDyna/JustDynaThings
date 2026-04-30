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


                //TODO check unused tk

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
                                "§7Repair items using Forge Energy");

                add(MODULE_ID + "." + Constants.Anvils.t4 + ".boost",
                                "§7Can be boosted using Time Fluid");

                add(MODULE_ID + "." + Constants.BuddingType,
                                "§7Grow clusters using Time Fluid and Forge Energy");

                // creative tab
                // add(MODULE_ID + "." + Constants.CreativeTab, "Just Dyna Things");

                // wip
                // add(MODULE_ID + ".clock.wip", "N.Y.I. -> shift-click the block to toggle");

                // missing guideme
                // add(MODULE_ID + ".doc.missing", "§aFor more info consider to install GuideMe or Patchouli");

                // generic type tooltips
                add(MODULE_ID + "." + Constants.GooType + "." + Constants.Goo.Energized,
                                "§cProvide energy to active it");
                add(MODULE_ID + "." + Constants.GooType + "." + Constants.Goo.Creative,
                                "§cRight click with a wrench to toggle alive state");
                add(MODULE_ID + "." + Constants.SolarPanelType, "§7Generate Energy from ambiental situations");
                add(MODULE_ID + "." + Constants.Blocks.ThermoGen,
                                "§7Generate Energy from heat sources and coolants");

                add(MODULE_ID + "." + Constants.Blocks.Stabilizer,
                                "§7Feed Goo blocks and can be used to keep alive the paradox mixer");
                add(MODULE_ID + "." + Constants.Blocks.simple_fluid_mixer,
                                "§7Allow to mass-craft fluid drop recipes");

                add(MODULE_ID + "." + Constants.Blocks.Ticker,
                                "§7A block that act at same of a time wand");

                
                add(MODULE_ID + "." + Constants.GooUpgraders.base, "§7Right click on a goo to upgrade it to the next tier");
                add(MODULE_ID + "." + Constants.Wands.Picker, "§7Allow to pickup simple blocks and place where you want");
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

                add(MODULE_ID + ".jei.category." + JDTRegistration.GeneratorT1_ITEM.getId().getPath(), "Solid Generator Fuels");
                add(MODULE_ID + ".jei.category." + JDTRegistration.GeneratorFluidT1_ITEM.getId().getPath(),
                                "Fluid Generator Fuels");

                add(MODULE_ID + ".jei.time", "Duration");
                add(MODULE_ID + ".jei.rate", "FE production");
                add(MODULE_ID + ".jei.total", "Total FE produced");

                add(MODULE_ID + ".jei.bucket", "Every Bucket");

                // add(MODULE_ID + "." + Constants.Blocks.simple_fluid_mixer + ".unstable", "Energized Stabilizer not found");

                addBlock(zBlocks.LIGHT_WAND_BLOCK, "Light Wand Block");

                add(MODULE_ID + "." + Constants.BuddingType + ".break", "§cDoesn't drop when broken!");

                // required to render disabled items
                // zCompat.getEchoingBuddingTypes.forEach(k -> add("item." + ID + "." + k, named(k)));
                // zCompat.getChiselItems.forEach(k -> add("item." + ID + "." + k, named(k)));

                add(MODULE_ID + ".hold_control", "§7Hold Control for Chisel detailts");

                add(MODULE_ID + "." + Constants.BuddingType + ".jade.fe", "§cRequire ForgeEnergy");
                add(MODULE_ID + "." + Constants.BuddingType + ".jade.time", "§cRequire Time Fluid");

                add(MODULE_ID + "." + Constants.Blocks.Stabilizer + ".jade.goo", "Revive Goo");
                add(MODULE_ID + "." + Constants.Blocks.Stabilizer + ".jade.energized", "Revive Time Budding");
                // add(MODULE_ID + "." + Constants.Blocks.ParadoxMixer + ".jade.dead", "§cRequire a Stabilizer energized!");

                // add("config.jade.plugin_" + MODULE_ID + "." + Constants.BuddingType, "Echoing Buddings Requirements");
                // add("config.jade.plugin_" + MODULE_ID + "." + Constants.Blocks.Stabilizer, "Stabilizer Abilities");
                // add("config.jade.plugin_" + MODULE_ID + "." + Constants.Blocks.ParadoxMixer, "Paradox Mixer Requirements");




        }

}
