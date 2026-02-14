package com.devdyna.justdynathings.datagen.client;

import static com.devdyna.justdynathings.Main.ID;

import java.util.List;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.compat.zCompat;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zItems;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class DataLang extends LanguageProvider {

        public DataLang(PackOutput o) {
                super(o, ID, "en_us");
        }

        @Override
        protected void addTranslations() {

                add(ID + ".invalid_block", "§cInvalid Block");
                add(ID + ".wand.blockstate", "§7BlockState : ");
                add(ID + ".wand.dimension", "§7Dimension : ");
                add(ID + ".wand.pos", "§7BlockPos : ");
                add(ID + ".disabled", "§cItem Disabled");

                add(ID + "." + Constants.Blocks.Reforger,
                                "§7Convert blocks using a catalyst to other blocks");

                add(ID + "." + Constants.Anvils.t1,
                                "§7Repair items using metallic ingots");

                add(ID + "." + Constants.Anvils.t2,
                                "§7Repair items using hot fluids");

                add(ID + "." + Constants.Anvils.t3,
                                "§7Repair items using Forge Energy");

                add(ID + "." + Constants.Anvils.t4,
                                "§7Repair items using Forge Energy");

                add(ID + "." + Constants.Anvils.t4 + ".boost",
                                "§7Can be boosted using Time Fluid");

                add(ID + "." + Constants.BuddingType,
                                "§7Grow clusters using Time Fluid and Forge Energy");

                // creative tab
                add(ID + "." + Constants.CreativeTab, "Just Dyna Things");

                // wip
                add(ID + ".clock.wip", "N.Y.I. -> shift-click the block to toggle");

                // missing guideme
                add(ID + ".doc.missing", "§aFor more info consider to install GuideMe or Patchouli");

                // generic type tooltips
                add(ID + "." + Constants.GooType + "." + Constants.Goo.Energized,
                                "§cProvide energy to active it");
                add(ID + "." + Constants.GooType + "." + Constants.Goo.Creative,
                                "§cRight click with a wrench to toggle alive state");
                add(ID + "." + Constants.SolarPanelType, "§7Generate Energy from ambiental situations");
                add(ID + "." + Constants.Blocks.ThermoGen,
                                "§7Generate Energy from heat sources and coolants");

                add(ID + "." + Constants.Blocks.Stabilizer,
                                "§7Feed Goo blocks and can be used to keep alive the paradox mixer");
                add(ID + "." + Constants.Blocks.ParadoxMixer,
                                "§7Allow to mass-craft fluid drop recipes");

                add(ID + "." + Constants.Blocks.Ticker,
                                "§7A block that act at same of a time wand");

                // registry keys

                List.of(
                                zBlocks.zBlock,
                                zBlocks.zGoo,
                                zBlocks.zOres,
                                zBlocks.zBuddings,
                                zBlocks.zBlockItem)
                                .forEach(c -> c.getEntries().forEach(b -> addBlock(b, named(b.getRegisteredName()))));

                List.of(
                                zItems.zItemHanded,
                                zItems.zCoals,
                                zItems.zItemTinted,
                                zItems.zBucketItem,
                                zItems.zGooUpgraders,
                                zItems.zItem)
                                .forEach(c -> c.getEntries().forEach(b -> addItem(b, named(b.getRegisteredName()))));

                // compats
                zCompat.extraItems.getEntries().forEach(i -> addItem(i, named(i.getRegisteredName())));

                List.of(
                                Constants.DataMaps.Anvils.ferricore_repair,
                                Constants.DataMaps.Anvils.blazegold_repair,
                                Constants.DataMaps.Anvils.eclipsealloy_repair,

                                Constants.DataMaps.Thermo.thermo_coolants,
                                Constants.DataMaps.Thermo.thermo_heat_sources,
                                Constants.DataMaps.Reforger.block_to_block,
                                Constants.DataMaps.Reforger.block_to_tag,
                                Constants.DataMaps.Reforger.tag_to_block,
                                Constants.Blocks.ParadoxMixer

                ).forEach(j -> add(ID + ".jei.category." + j, named(j.replace(
                                Constants.DataMaps.Anvils.anvil, "")
                                .replace(Constants.DataMaps.Reforger.reforger, "reforger_"))));

                add(ID + "." + Constants.GooUpgraders.base, "§7Right click on a goo to upgrade it to the next tier");
                add(ID + "." + Constants.Wands.Picker, "§7Allow to pickup simple blocks and place where you want");
                add(ID + "." + Constants.Wands.Swapper, "§7Allow to swap simple blocks without break it");

                add(ID + "." + Constants.GooType + ".tier", "§7Goo Tier: ");

                add(ID + "." + Constants.SolarPanelType + ".ferate", "§7Max FE rate : ");

                add(ID + ".init_invalid", "§cInitial Block isn't anymore valid");
                add(ID + ".clear_pos", "Position Cleared");

                add(ID + "." + Constants.Wands.AdvancedTime,
                                "§7More capable and configurable version of Time wand");

                add(ID + "." + Constants.Wands.AdvancedTime + ".mode.disabled", "§cThis Mode was disabled");
                add(ID + "." + Constants.Wands.AdvancedTime + ".mode.reset", "This wand is ready to be used!");

                add(ID + "." + Constants.Wands.AdvancedTime + ".tip.normal", "Mode set to §aNormal");
                add(ID + "." + Constants.Wands.AdvancedTime + ".tip.x2", "Mode set to §a2x");
                add(ID + "." + Constants.Wands.AdvancedTime + ".tip.x4", "Mode set to §a4x");
                add(ID + "." + Constants.Wands.AdvancedTime + ".tip.max", "Mode set to §aMax");

                add(ID + "." + Constants.Wands.AdvancedTime + ".mode.normal", "1x");
                add(ID + "." + Constants.Wands.AdvancedTime + ".mode.x2", "2x");
                add(ID + "." + Constants.Wands.AdvancedTime + ".mode.x4", "4x");
                add(ID + "." + Constants.Wands.AdvancedTime + ".mode.max", "8x");

                add(ID + "." + Constants.Wands.Stupefy, "§7Remove TimeWand Entities and Stupefy ability");

                add(ID + ".jei.warning", "Item form doesn't exist or doesn't respect the block placed!");

                add(ID + ".jei.category." + Registration.GeneratorT1_ITEM.getId().getPath(), "Solid Generator Fuels");
                add(ID + ".jei.category." + Registration.GeneratorFluidT1_ITEM.getId().getPath(),
                                "Fluid Generator Fuels");

                add(ID + ".jei.time", "Duration");
                add(ID + ".jei.rate", "FE production");
                add(ID + ".jei.total", "Total FE produced");

                add(ID + ".jei.bucket", "Every Bucket");

                add(ID + "." + Constants.Blocks.ParadoxMixer + ".unstable", "Energized Stabilizer not found");

                addBlock(zBlocks.LIGHT_WAND_BLOCK, "Light Wand Block");

                add(ID + "." + Constants.BuddingType + ".break", "§cDoesn't drop when broken!");

                // required to render disabled items
                zCompat.getEchoingBuddingTypes.forEach(k -> add("item." + ID + "." + k, named(k)));
                // zCompat.getChiselItems.forEach(k -> add("item." + ID + "." + k, named(k)));

                add(ID + ".hold_control", "§7Hold Control for Chisel detailts");

                add(Main.ID + "." + Constants.BuddingType + ".jade.fe", "§cRequire ForgeEnergy");
                add(Main.ID + "." + Constants.BuddingType + ".jade.time", "§cRequire Time Fluid");

                add(Main.ID + "." + Constants.Blocks.Stabilizer + ".jade.goo", "Revive Goo");
                add(Main.ID + "." + Constants.Blocks.Stabilizer + ".jade.energized", "Stabilize paradox mixer");
                add(Main.ID + "." + Constants.Blocks.ParadoxMixer + ".jade.dead", "§cRequire a Stabilizer energized!");

                add("config.jade.plugin_" + ID + "." + Constants.BuddingType, "Echoing Buddings Requirements");
                add("config.jade.plugin_" + ID + "." + Constants.Blocks.Stabilizer, "Stabilizer Abilities");
                add("config.jade.plugin_" + ID + "." + Constants.Blocks.ParadoxMixer, "Paradox Mixer Requirements");

        }

        private String named(String text) {

                StringBuilder result = new StringBuilder();
                for (String word : text.replace(ID + ":", "").replaceAll("_", " ").split(" ")) {
                        if (!word.isEmpty()) {
                                result.append(Character.toUpperCase(word.charAt(0)))
                                                .append(word.substring(1))
                                                .append(" ");
                        }
                }
                return result.toString().trim();
        }

}
