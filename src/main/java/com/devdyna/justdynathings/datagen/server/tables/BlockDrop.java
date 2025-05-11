package com.devdyna.justdynathings.datagen.server.tables;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.devdyna.justdynathings.registry.types.zBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockDrop extends BlockLootSubProvider {

        public BlockDrop(HolderLookup.Provider l) {
                super(Set.of(), FeatureFlags.DEFAULT_FLAGS, l);
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
                List<Block> blocks = new ArrayList<>();
                blocks.addAll(getList(zBlocks.zBlock));
                blocks.addAll(getList(zBlocks.zBlockItem));
                blocks.addAll(getList(zBlocks.zGoo));
                blocks.addAll(getList(zBlocks.zOres));
                return blocks;
        }

        @SuppressWarnings("unchecked")
        private List<Block> getList(DeferredRegister.Blocks c) {
                return (List<Block>) c.getEntries().stream().map(DeferredHolder::get).toList();
        }

        @Override
        protected void generate() {

                zBlocks.zBlock.getEntries().forEach(b -> dropSelf(b.get()));
                zBlocks.zBlockItem.getEntries().forEach(b -> dropSelf(b.get()));
                zBlocks.zGoo.getEntries().forEach(b -> dropSelf(b.get()));

                // add(zBlocks.RAW_CHAOTIC.get(), createOreDrop(zBlocks.RAW_CHAOTIC.get(), zItems.CHAOTIC_DUST.get()));
                // add(zBlocks.RAW_COPRINIUM.get(), createOreDrop(zBlocks.RAW_COPRINIUM.get(), zItems.RAW_COPRINIUM.get()));
                // add(zBlocks.RAW_REDSTONIC.get(), createOreDrop(zBlocks.RAW_REDSTONIC.get(), zItems.REDSTONIC_GEM.get()));


        }

        

}
