package com.devdyna.justdynathings.datagen.server;

import java.util.*;

import com.devdyna.justdynathings.init.types.zBlocks;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;

public class DataLootBlock extends BlockLootSubProvider {

        public DataLootBlock(HolderLookup.Provider l) {
                super(Set.of(), FeatureFlags.DEFAULT_FLAGS, l);
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {

                List<Block> blocks = new ArrayList<>();
                List.of(zBlocks.zBlock, zBlocks.zBlockItem)
                                .forEach(t -> blocks.addAll(t.getEntries().stream().map(DeferredHolder::get).toList()));
                return blocks;
        }

        @Override
        protected void generate() {
                zBlocks.zBlock.getEntries().forEach(b -> dropSelf(b.get()));
                zBlocks.zBlockItem.getEntries().forEach(b -> dropSelf(b.get()));
        }

}
