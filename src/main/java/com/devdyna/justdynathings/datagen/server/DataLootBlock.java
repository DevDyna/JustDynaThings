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
                return List.of(zBlocks.zBlock.getEntries().stream().map(DeferredHolder::get).toArray(Block[]::new));
        }

        @Override
        protected void generate() {
                zBlocks.zBlock.getEntries().forEach(b -> dropSelf(b.get()));
        }

}
