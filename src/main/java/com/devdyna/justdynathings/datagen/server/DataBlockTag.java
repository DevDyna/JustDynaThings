package com.devdyna.justdynathings.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.JustDynaThings;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

public class DataBlockTag extends BlockTagsProvider {

        public DataBlockTag(PackOutput output, CompletableFuture<Provider> lookupProvider) {
                super(output, lookupProvider, JustDynaThings.MODULE_ID);
        }

        @Override
        protected void addTags(Provider p) {
                // tag(BlockTags.MINEABLE_WITH_PICKAXE).add(zBlocks.QUERN.get());
        }

}