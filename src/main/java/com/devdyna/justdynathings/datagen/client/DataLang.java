package com.devdyna.justdynathings.datagen.client;

import static com.devdyna.justdynathings.Main.ID;

import java.util.List;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class DataLang extends LanguageProvider {

    public DataLang(PackOutput o) {
        super(o, Main.ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        add(ID + ".invalid_block", "§cInvalid Block");
        add(ID + ".wand.blockstate", "BlockState : ");
        add(ID + ".wand.dimension", "Dimension : ");
        add(ID + ".wand.pos", "BlockPos : ");
        add(ID + ".disabled", "Item Disabled");

        // creative tab
        add(Main.ID + "." + Constants.CreativeTab, "Just Dyna Things");

        // wip
        add(Main.ID + ".clock.wip", "N.Y.I. -> shift-click the block to toggle");

        // missing guideme
        add(ID + ".guideme.missing", "§aFor more info install GuideMe");

        // generic type tooltips
        add(Main.ID + "." + Constants.GooType + "." + Constants.Goo.Energized + ".tip",
                "§cProvide energy to active it");
        add(Main.ID + "." + Constants.GooType + "." + Constants.Goo.Creative + ".tip",
                "§cRight click with a wrench to toggle alive state");
        add(Main.ID + "." + Constants.SolarPanelType + ".tip", "Generate Energy from ambiental situations");
        add(Main.ID + "." + Constants.Blocks.ThermoGen + ".tip",
                "Generate Energy from heat sources and coolants");

        // registry keys
        zBlocks.zBlock.getEntries().forEach(b -> addBlock(b, named(b.getRegisteredName())));
        zBlocks.zGoo.getEntries().forEach(b -> addBlock(b, named(b.getRegisteredName())));
        zBlocks.zOres.getEntries().forEach(b -> addBlock(b, named(b.getRegisteredName())));
        zBlocks.zBuddings.getEntries().forEach(b -> addBlock(b, named(b.getRegisteredName())));
        zBlocks.zBlockItem.getEntries().forEach(b -> addBlock(b, named(b.getRegisteredName())));
        // zBlocks.zBlockFluids.getEntries().forEach(b -> addBlock(b,
        // named(b.getRegisteredName())));
        zItems.zItem.getEntries().forEach(b -> addItem(b, named(b.getRegisteredName())));
        zItems.zBucketItem.getEntries().forEach(b -> addItem(b, named(b.getRegisteredName())));
        zItems.zItemTinted.getEntries().forEach(b -> addItem(b, named(b.getRegisteredName())));
        zItems.zCoals.getEntries().forEach(b -> addItem(b, named(b.getRegisteredName())));
        zItems.zItemHanded.getEntries().forEach(b -> addItem(b, named(b.getRegisteredName())));

        // compats
        List.of(
                Constants.Budding.Certus,
                Constants.Budding.Entro,
                Constants.Budding.Phasorite)
                .forEach(e -> add("block." + ID + "." + e, named(e)));

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
