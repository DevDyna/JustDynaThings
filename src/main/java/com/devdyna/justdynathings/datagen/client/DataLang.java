package com.devdyna.justdynathings.datagen.client;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import static com.devdyna.cakesticklib.api.datagen.LangUtils.*;

import com.devdyna.justdynathings.init.types.zBlocks;
import com.devdyna.justdynathings.init.types.zItems;
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

        }

}
