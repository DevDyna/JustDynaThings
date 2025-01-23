package com.devdyna.justdynathings.init.builder;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.init.builder.goo.GooT0BE;
import com.devdyna.justdynathings.init.builder.goo.GooT5;
import com.devdyna.justdynathings.init.builder.goo.GooT5BE;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("unchecked")
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

    public static final DeferredHolder<Block, com.devdyna.justdynathings.init.builder.goo.GooT5> GooT5;
    public static final DeferredHolder<Block, com.devdyna.justdynathings.init.builder.goo.GooT0> GooT0;

    static {
        GooT5 = (DeferredHolder<Block, com.devdyna.justdynathings.init.builder.goo.GooT5>) createGooBlock(
                "ferrous", true);
        GooT0 = (DeferredHolder<Block, com.devdyna.justdynathings.init.builder.goo.GooT0>) createGooBlock(
                "rotten", true);
    }

    @SuppressWarnings("null")
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GooT5BE>> GooT5_BE = zBE
            .register("complex_goo", () -> {
                return Builder.of(GooT5BE::new, GooT5.get()).build(null);
            });

    @SuppressWarnings("null")
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GooT0BE>> GooT0_BE = zBE
            .register("rotten_goo", () -> {
                return Builder.of(GooT0BE::new, GooT0.get()).build(null);
            });

    public static final TagKey<Item> GOO_REVIVE_TIER_5 = tagItem("goo_revive_tier_5");
    public static final TagKey<Item> GOO_REVIVE_TIER_0 = tagItem("goo_revive_tier_0");

    private static TagKey<Item> tagItem(String name) {
        return TagKey.create(BuiltInRegistries.ITEM.key(),
                ResourceLocation.fromNamespaceAndPath(Main.ID, name));
    }

    @SuppressWarnings("unused")
    private static TagKey<Block> tagBlock(String name) {
        return TagKey.create(BuiltInRegistries.BLOCK.key(),
                ResourceLocation.fromNamespaceAndPath(Main.ID, name));
    }

    private static DeferredBlock<?> createGooBlock(String name, Boolean regItemRelated) {
        DeferredBlock<GooT5> b = zBLK.register(name + "_goo", () -> new GooT5(name));
        if (regItemRelated) {
            zITM.register(name + "_goo", () -> {
                return new GooBlock_Item(b.get(), new Item.Properties());
            });
        }
        return b;
    }

}
