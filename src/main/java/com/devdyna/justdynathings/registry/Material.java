package com.devdyna.justdynathings.registry;

import java.util.ArrayList;
import java.util.function.Supplier;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.builders.RawOre;
import com.devdyna.justdynathings.registry.builders._core.block.BlockBase;
import com.devdyna.justdynathings.registry.builders._core.item.ItemBase;
import com.devdyna.justdynathings.registry.builders.fuels.item.BaseFuel;
import com.devdyna.justdynathings.registry.types.*;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import static net.minecraft.world.item.Items.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;

public class Material {
        public static void register(IEventBus bus) {
                BlockEntities.register(bus);
                Blocks.register(bus);
                BlockTags.register(bus);
                Containers.register(bus);
                CreativeTab.register(bus);
                Fluids.register(bus);
                FluidTypes.register(bus);
                Handlers.register(bus);
                Items.register(bus);
                ItemTags.register(bus);
        }

        public static final BlockBehaviour.Properties bProp = BlockBehaviour.Properties.of();
        public static final Properties iProp = new Item.Properties();
        public static final Properties iPropBucket = iProp.craftRemainder(BUCKET).stacksTo(1);

        /**
         * register an block + item
         * 
         * @param sup () -> new Builder
         * @param b   Blocks.zBlock
         */
        public static DeferredHolder<Block, ?> registerItemAndBlock(String blockname, Supplier<? extends Block> sup) {
                DeferredHolder<Block, ?> block = Blocks.zBlockItem.register(blockname, sup);
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
         * create an itemtag
         */
        public static TagKey<Item> tagItem(String modname, String name) {
                return TagKey.create(BuiltInRegistries.ITEM.key(),
                                ResourceLocation.fromNamespaceAndPath(modname, name));
        }

        /**
         * create an blocktag
         */
        public static TagKey<Block> tagBlock(String name) {
                return TagKey.create(BuiltInRegistries.BLOCK.key(),
                                ResourceLocation.fromNamespaceAndPath(Main.ID, name));
        }

        public static Block[] getBuddingAvailable() {
                ArrayList<Block> a = new ArrayList<>();
                a.add(Blocks.BUDDING_AMETHYST.get());
                a.add(Blocks.BUDDING_TIME.get());
                if (Constants.ModAddonCheck.AppliedEnergistics2)
                        a.add(com.devdyna.justdynathings.compat.ae2.init.AE2_POWERED.get());
                if (Constants.ModAddonCheck.ExtendedAE)
                        a.add(com.devdyna.justdynathings.compat.extendedae.init.EXTENDED_POWERED.get());
                if (Constants.ModAddonCheck.PhasoriteNetworks)
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

        @Deprecated
        public static DeferredHolder<Block, ?> createBlockItem(String name) {
                Items.zBlockItem.register(name, ItemBase::new);
                return Blocks.zBlockItem.register(name,
                                BlockBase::new);
        }

        public class DireStuff {

                public static DeferredHolder<Block, ?> simpleGoo(String id, Supplier<? extends Block> sup) {
                        DeferredHolder<Block, ?> block = Blocks.zGoo.register(id + "_" + Constants.GooType, sup);
                        Items.zBlockItem.registerSimpleBlockItem(block);
                        return block;
                }

                public static DeferredHolder<Block, RawOre> simpleRawOreDW(String name) {
                        DeferredHolder<Block, RawOre> block = Blocks.zOres.register(
                                        name,
                                        () -> new RawOre(SoundType.AMETHYST, 1.4f, 6.0f));
                        Items.zBlockItem.registerSimpleBlockItem(block);
                        return block;
                }

                public static DeferredHolder<Item, ?> FuelItemDW(String name, int burnrate) {
                        return Items.zCoals.register(name, () -> new BaseFuel(burnrate));
                }

        }

}
