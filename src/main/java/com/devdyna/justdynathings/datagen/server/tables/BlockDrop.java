package com.devdyna.justdynathings.datagen.server.tables;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.devdyna.justdynathings.registry.types.Blocks;
import com.devdyna.justdynathings.registry.types.Items;
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
                blocks.addAll(getList(Blocks.zBlock));
                blocks.addAll(getList(Blocks.zBlockItem));
                blocks.addAll(getList(Blocks.zGoo));
                blocks.addAll(getList(Blocks.zOres));
                return blocks;
        }

        @SuppressWarnings("unchecked")
        private List<Block> getList(DeferredRegister.Blocks c) {
                return (List<Block>) c.getEntries().stream().map(DeferredHolder::get).toList();
        }

        @Override
        protected void generate() {

                Blocks.zBlock.getEntries().forEach(b -> dropSelf(b.get()));
                Blocks.zBlockItem.getEntries().forEach(b -> dropSelf(b.get()));
                Blocks.zGoo.getEntries().forEach(b -> dropSelf(b.get()));

                add(Blocks.RAW_CHAOTIC.get(), createOreDrop(Blocks.RAW_CHAOTIC.get(), Items.CHAOTIC_DUST.get()));
                add(Blocks.RAW_COPRINIUM.get(), createOreDrop(Blocks.RAW_COPRINIUM.get(), Items.RAW_COPRINIUM.get()));
                add(Blocks.RAW_REDSTONIC.get(), createOreDrop(Blocks.RAW_REDSTONIC.get(), Items.REDSTONIC_GEM.get()));


        }

        

}
