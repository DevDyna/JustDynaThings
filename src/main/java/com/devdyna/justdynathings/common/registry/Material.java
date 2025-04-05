package com.devdyna.justdynathings.common.registry;

import java.util.ArrayList;
import java.util.function.Supplier;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.common.registry.core.builder.block.BlockBase;
import com.devdyna.justdynathings.common.registry.core.builder.item.ItemBase;
import com.devdyna.justdynathings.common.registry.core.builders.goo.GooBlockItem;
import com.devdyna.justdynathings.common.registry.core.builders.goo.custom.energy.EnergyGoo;
import com.devdyna.justdynathings.common.registry.types.*;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Material {
        public static void register(IEventBus bus) {
                BlockEntities.register(bus);
                Blocks.register(bus);
                BlockTags.register(bus);
                CreativeTab.register(bus);
                Items.register(bus);
                ItemTags.register(bus);
                Containers.register(bus);
        }

        public static final BlockBehaviour.Properties bProp = BlockBehaviour.Properties.of();
        public static final Properties iProp = new Item.Properties();

        /**
         * register an block + item
         * 
         * @param sup () -> new Builder
         */
        public static DeferredHolder<Block, ?> registerItemBlock(String blockname, Supplier<? extends Block> sup) {
                return registerItemBlock(blockname, sup, Blocks.zBlockItem);
        }

        /**
         * register an block + item
         * 
         * @param sup () -> new Builder
         * @param b   Blocks.zBlock
         */
        public static DeferredHolder<Block, ?> registerItemBlock(String blockname, Supplier<? extends Block> sup,
                        DeferredRegister.Blocks b) {
                DeferredHolder<Block, ?> block = b.register(blockname, sup);
                Items.zBlockItem.registerSimpleBlockItem(block);
                return block;
        }

        /**
         * create an itemtag
         */
        public static TagKey<Item> tagItem(String name) {
                return TagKey.create(BuiltInRegistries.ITEM.key(),
                                ResourceLocation.fromNamespaceAndPath(Main.ID, name));
        }

        /**
         * create an blocktag
         */
        public static TagKey<Block> tagBlock(String name) {
                return TagKey.create(BuiltInRegistries.BLOCK.key(),
                                ResourceLocation.fromNamespaceAndPath(Main.ID, name));
        }

        public static DeferredBlock<EnergyGoo> simpleFEGoo(String id, int tier, int reducer, int fecost, int fecap) {
                return Blocks.zBlock.register(
                                Constants.Material.Goo.Energized.id + "_" + id + "_" + Constants.Material.Goo.ID.id,
                                () -> new EnergyGoo(
                                                Constants.Material.Goo.Energized.id + "_" + id + "_"
                                                                + Constants.Material.Goo.ID.id,
                                                tier, reducer, fecost,
                                                fecap));
        }

        public static DeferredBlock<EnergyGoo> simpleFEGoo(String id, int tier) {
                return simpleFEGoo(id, tier, 4, 1000, 10000);
        }

        public static DeferredBlock<EnergyGoo> FEGooCapByTier(String id, int tier) {
                return simpleFEGoo(id, tier, 4 * (tier + 1), 1000 * tier,
                                10000 * (tier + 1));
        }

        public static DeferredHolder<Item, BlockItem> simpleGooItem(DeferredHolder<Block, ?> block, String id) {
                return Items.zItem.register(
                                id + "_" + Constants.Material.Goo.ID.id,
                                () -> new GooBlockItem(block.get()));
        }

        public static DeferredHolder<Item, BlockItem> simpleFEGooItem(DeferredHolder<Block, ?> block, String id) {
                return Items.zItem.register(
                                Constants.Material.Goo.Energized.id + "_" + id + "_" + Constants.Material.Goo.ID.id,
                                () -> new GooBlockItem(block.get()));
        }

        public static Block[] getBuddingAvailable() {
                ArrayList<Block> a = new ArrayList<>();
                // a.add(POWERED_AMETHYST.get());
                // a.add(POWERED_TIME.get());

                if (Constants.Mods.AE2.check)
                        a.add(com.devdyna.justdynathings.compat.ae2.init.AE2_POWERED.get());
                if (Constants.Mods.ExtendedAE.check)
                        a.add(com.devdyna.justdynathings.compat.extendedae.init.EXTENDED_POWERED.get());
                if (Constants.Mods.PhasoriteNetworks.check)
                        a.add(com.devdyna.justdynathings.compat.phasorite.init.PHASORITE_POWERED.get());

                Block[] b = new Block[a.size()];
                for (int i = 0; i < a.size(); i++) {
                        b[i] = a.get(i);
                }

                return b;
        }


    public static DeferredHolder<Item, ?> createItem(String name) {
        return Items.zItem.register(name,
                ItemBase::new);
    }

    public static DeferredHolder<Block, ?> createBlock(String name) {
        return Blocks.zBlock.register(name,
                BlockBase::new);
    }


    public static DeferredHolder<Block, ?> createBlockItem(String name) {
        Items.zBlockItem.register(name,ItemBase::new);
        return Blocks.zBlockItem.register(name,
                BlockBase::new);
    }

}
