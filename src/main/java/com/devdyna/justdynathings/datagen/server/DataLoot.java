package com.devdyna.justdynathings.datagen.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.devdyna.justdynathings.registry.types.zBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DataLoot extends BlockLootSubProvider {

        public DataLoot(HolderLookup.Provider l) {
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

                // oreTable(zBlocks.REDSTONE_ORE.get(), zItems.REDSTONE_FUEL.get(), 3, 5);
                // oreTable(zBlocks.LAPIS_LAZULI_ORE.get(), zItems.LAPIS_LAZULI_FUEL.get(), 3, 5);

        }

        @SuppressWarnings("unused")
        private void oreTable(Block b, Item drop, float min, float max) {
                add(b, createSilkTouchDispatchTable(b,
                                this.applyExplosionDecay(b, LootItem.lootTableItem(drop)
                                                .apply(SetItemCountFunction
                                                                .setCount(UniformGenerator.between(min, max))))));
        }

}
