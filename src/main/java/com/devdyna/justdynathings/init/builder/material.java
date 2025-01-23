package com.devdyna.justdynathings.init.builder;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.init.builder.goo.GooT5;
import com.devdyna.justdynathings.init.builder.goo.GooT5BE;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class material {
    public static void register(IEventBus bus) {
        zBLK.register(bus);
        zITM.register(bus);
        zBE.register(bus);
    }

    private static final DeferredRegister<BlockEntityType<?>> zBE = DeferredRegister
            .create(Registries.BLOCK_ENTITY_TYPE, Main.ID);

    public static final DeferredRegister.Blocks zBLK = DeferredRegister.createBlocks(Main.ID);
    public static final DeferredRegister.Items zITM = DeferredRegister.createItems(Main.ID);

    public static final DeferredHolder<Block, GooT5> GooT5 = zBLK.register("gooblock_tier5", GooT5::new);;
    public static final DeferredHolder<Item, BlockItem> GooT5_ITEM = zITM.register("gooblock_tier5", () -> {
        return new GooBlock_Item(GooT5.get(), new Item.Properties());
    });;
    @SuppressWarnings("null")
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GooT5BE>> GooT5_BE = zBE
            .register("gooblock_tier5", () -> {
                return Builder.of(GooT5BE::new, new Block[] { GooT5.get() }).build(null);
            });;

    public static final TagKey<Item> GOO_REVIVE_TIER_5 = tagItem("goo_revive_tier_5");;

    private static TagKey<Item> tagItem(String name) {
        return TagKey.create(BuiltInRegistries.ITEM.key(),
                ResourceLocation.fromNamespaceAndPath(Main.ID, name));
    }

    @SuppressWarnings("unused")
    private static TagKey<Block> tagBlock(String name) {
        return TagKey.create(BuiltInRegistries.BLOCK.key(),
                ResourceLocation.fromNamespaceAndPath(Main.ID, name));
    }

}
