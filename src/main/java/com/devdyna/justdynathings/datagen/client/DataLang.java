package com.devdyna.justdynathings.datagen.client;

import static com.devdyna.justdynathings.Main.ID;

import java.util.List;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.types.Blocks;
import com.devdyna.justdynathings.registry.types.Items;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

public class DataLang extends LanguageProvider {

    public DataLang(PackOutput o) {
        super(o, Main.ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        add(Main.ID + "." + Constants.CreativeTab, "Just Dyna Things");
        add(Main.ID + ".off", "§8[§fControl§8]§f");
        add(Main.ID + ".clock.wip", "N.Y.I. -> shift-click the block to toggle");

        Blocks.zBlock.getEntries().forEach(b -> RegistryToLang("block", b));
        Blocks.zGoo.getEntries().forEach(b -> RegistryToLang("block", b));
        Blocks.zOres.getEntries().forEach(b -> RegistryToLang("block", b));
        Blocks.zBuddings.getEntries().forEach(b -> RegistryToLang("block", b));
        Blocks.zBlockItem.getEntries().forEach(b -> RegistryToLang("block", b));
        Blocks.zBlockFluids.getEntries().forEach(b -> RegistryToLang("block", b));
        Items.zItem.getEntries().forEach(b -> RegistryToLang("item", b));
        Items.zBucketItem.getEntries().forEach(b -> RegistryToLang("item", b));
        Items.zItemTinted.getEntries().forEach(b -> RegistryToLang("item", b));

        // compats
        List.of(
                Constants.Budding.Certus,
                Constants.Budding.Entro,
                Constants.Budding.Phasorite)
                .forEach(e -> {
                    add("block." + ID + "." + e, Named(e));
                });

    }

    @SuppressWarnings({ "rawtypes" })
    private void RegistryToLang(String type, DeferredHolder d) {
        add(type + "." + d.getRegisteredName().replace(":", "."),
                Named(d.getRegisteredName().replace(Main.ID + ":", "")));
    }

    private String Named(String text) {

        StringBuilder result = new StringBuilder();
        for (String word : text.replaceAll("_", " ").split(" ")) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        return result.toString().trim();
    }

}
