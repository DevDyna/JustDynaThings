package com.devdyna.justdynathings.init;

import com.devdyna.justdynathings.init.builder.AntiBlock;
import com.devdyna.justdynathings.init.builder.goo.GooT0;
import com.devdyna.justdynathings.init.builder.goo.GooT0BE;
import com.devdyna.justdynathings.init.builder.goo.GooT5;
import com.devdyna.justdynathings.init.builder.goo.GooT5BE;
import com.devdyna.justdynathings.simply.GooBlockItem;
import com.devdyna.justdynathings.simply.RawOre;
import com.devdyna.justdynathings.utils.RegUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.neoforged.neoforge.registries.DeferredHolder;

public class Material {

        public static final DeferredHolder<Block, GooT5> GooT5_BLOCK = DefType.zBLK.register("ferrous_goo",
                        () -> new GooT5("ferrous"));
        public static final DeferredHolder<Block, GooT0> GooT0_BLOCK = DefType.zBLK.register("rotten_goo",
                        () -> new GooT0("rotten"));

        public static final DeferredHolder<Block, AntiBlock> ANTIBLOCK = DefType.zBLK.register("antiblock",
                        () -> new AntiBlock());

        public static final DeferredHolder<Item, BlockItem> GooT0_ITEM = DefType.zITM.register("rotten_goo",
                        () -> new GooBlockItem(GooT0_BLOCK.get()));
        public static final DeferredHolder<Item, BlockItem> GooT5_ITEM = DefType.zITM.register("ferrous_goo",
                        () -> new GooBlockItem(GooT5_BLOCK.get()));

        public static final DeferredHolder<Item, BlockItem> ANTIBLOCK_ITEM = DefType.zITM
                        .registerSimpleBlockItem(ANTIBLOCK);

        public static final DeferredHolder<Item, ?> a = RegUtil.ezItem("a");

        public static final DeferredHolder<Block, ?> b = RegUtil.ezBlock("b");

        public static final DeferredHolder<Block, ?> c = DefType.zBLK.register("a",
                        () -> new RawOre(SoundType.AMETHYST, 2.0f, 2.0f));

        @SuppressWarnings("null")
        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GooT5BE>> GooT5_BE = DefType.zBE
                        .register("complex_goo", () -> Builder.of(GooT5BE::new, GooT5_BLOCK.get()).build(null));

        @SuppressWarnings("null")
        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GooT0BE>> GooT0_BE = DefType.zBE
                        .register("rotten_goo", () -> Builder.of(GooT0BE::new, GooT0_BLOCK.get()).build(null));

        public static final TagKey<Item> GOO_REVIVE_TIER_0 = RegUtil.tagItem("goo_revive_tier_0");
        public static final TagKey<Item> GOO_REVIVE_TIER_5 = RegUtil.tagItem("goo_revive_tier_5");

}
