package com.devdyna.justdynathings.registry;

import static com.devdyna.justdynathings.Main.ID;
import java.util.ArrayList;
import java.util.function.Supplier;
import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.builders.RawOre;
import com.devdyna.justdynathings.registry.builders._core.block.BlockBase;
import com.devdyna.justdynathings.registry.builders._core.item.ItemFuel;
import com.devdyna.justdynathings.registry.builders._core.item.ItemBase;
import com.devdyna.justdynathings.registry.types.*;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;

public class Material {
        public static void register(IEventBus bus) {
                zBlockEntities.register(bus);
                zBlocks.register(bus);
                zBlockTags.register(bus);
                zContainers.register(bus);
                zCreativeTab.register(bus);
                zFluids.register(bus);
                zFluidTypes.register(bus);
                zHandlers.register(bus);
                zItems.register(bus);
                zItemTags.register(bus);
                zComponents.register(bus);
                zBiomeTags.register(bus);
        }

        /**
         * register an block + item
         * 
         * @param sup () -> new Builder
         * @param b   Blocks.zBlock
         */
        public static DeferredHolder<Block, ?> registerItemAndBlock(String blockname, Supplier<? extends Block> sup) {
                DeferredHolder<Block, ?> block = zBlocks.zBlockItem.register(blockname, sup);
                zItems.zBlockItem.registerSimpleBlockItem(block);
                return block;
        }

        /**
         * create an itemtag
         */
        public static TagKey<Item> tagItem(String name) {
                return tagItem(ID, name);
        }

        /**
         * create an fluidtag
         */
        public static TagKey<Fluid> tagFluid(String name) {
                return TagKey.create(BuiltInRegistries.FLUID.key(),
                                ResourceLocation.fromNamespaceAndPath(Main.ID, name));
        }

        /**
         * create an biome tag
         */
        public static TagKey<Biome> tagBiome(String name) {
                return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Main.ID, name));
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
                return tagBlock(ID, name);
        }

        /**
         * create an blocktag
         */
        public static TagKey<Block> tagBlock(String modname, String name) {
                return TagKey.create(BuiltInRegistries.BLOCK.key(),
                                ResourceLocation.fromNamespaceAndPath(modname, name));
        }

        public static Block[] getBuddingAvailable() {
                ArrayList<Block> a = new ArrayList<>();
                a.add(zBlocks.ECHOING_BUDDING_AMETHYST.get());
                a.add(zBlocks.ECHOING_BUDDING_TIME.get());
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
                return zItems.zItem.register(name,
                                ItemBase::new);
        }

        public static DeferredHolder<Block, ?> createBlock(String name) {
                return zBlocks.zBlock.register(name,
                                BlockBase::new);
        }

        @Deprecated
        public static DeferredHolder<Block, ?> createBlockItem(String name) {
                zItems.zBlockItem.register(name, ItemBase::new);
                return zBlocks.zBlockItem.register(name,
                                BlockBase::new);
        }

        public class DireStuff {

                public static DeferredHolder<Block, ?> simpleGoo(String id, Supplier<? extends Block> sup) {
                        DeferredHolder<Block, ?> block = zBlocks.zGoo.register(id, sup);
                        zItems.zBlockItem.registerSimpleBlockItem(block);
                        return block;
                }

                public static DeferredHolder<Block, RawOre> simpleRawOreDW(String name) {
                        DeferredHolder<Block, RawOre> block = zBlocks.zOres.register(
                                        name,
                                        () -> new RawOre(SoundType.AMETHYST, 1.4f, 6.0f));
                        zItems.zBlockItem.registerSimpleBlockItem(block);
                        return block;
                }

                public static DeferredHolder<Item, ?> FuelItemDW(String name, int burnrate) {
                        return zItems.zCoals.register(name, () -> new ItemFuel(burnrate));
                }

                // public static DeferredHolder<Block, ?> FuelBlockDW(String name, int
                // burnrate,Supplier<? extends Block> o) {
                // DeferredHolder<Block, ?> b = zBlocks.zCoals.register(name,()-> new
                // BlockFuel(burnrate));
                // zItems.zCoals.registerSimpleBlockItem(name, o);
                // return b;
                // }

                public static DeferredHolder<Block, ?> registerBudding(String blockname,
                                Supplier<? extends Block> sup) {
                        DeferredHolder<Block, ?> block = zBlocks.zBuddings.register(blockname, sup);
                        zItems.zBlockItem.registerSimpleBlockItem(block);
                        return block;
                }

        }

}
