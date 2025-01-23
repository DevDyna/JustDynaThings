package com.devdyna.justdynathings.init;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.init.builder.goo.GooT5;
import com.devdyna.justdynathings.init.builder.goo.GooT5BE;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Item;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import com.mojang.datafixers.types.Type;

@SuppressWarnings({ "null", "rawtypes" })
public class Reg {

    public static void register(IEventBus bus) {
        zBLK.register(bus);
        zITM.register(bus);
        zBE.register(bus);
        zCTBS.register(bus);
    }

    private static final DeferredRegister<BlockEntityType<?>> zBE = DeferredRegister
            .create(Registries.BLOCK_ENTITY_TYPE, Main.ID);

    public static final DeferredRegister.Blocks zBLK = DeferredRegister.createBlocks(Main.ID);
    public static final DeferredRegister.Items zITM = DeferredRegister.createItems(Main.ID);

    public static final DeferredHolder<Block, GooT5> GooT5;
    public static final DeferredHolder<Item, BlockItem> GooT5_ITEM;
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GooT5BE>> GooT5_BE;

    public static final DeferredRegister<CreativeModeTab> zCTBS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, Main.ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CreativeTab;

    public static final TagKey<Item> GOO_REVIVE_TIER_5;

    static {

        GooT5 = zBLK.register("gooblock_tier5", GooT5::new);
        
        GooT5_ITEM = zITM.register("gooblock_tier5", () -> {
            return new GooBlock_Item((Block) GooT5.get(), new Item.Properties());
        });

        GooT5_BE = zBE.register("gooblock_tier5", () -> {
            return Builder.of(GooT5BE::new, new Block[] { (Block) GooT5.get() }).build((Type) null);
        });

        CreativeTab = zCTBS
                .register(Main.ID, () -> CreativeModeTab.builder()
                        .title(Component.translatable(Main.ID + ".tab"))

                        .withTabsBefore(CreativeModeTabs.COMBAT)
                        .icon(() -> GooT5_ITEM.get().getDefaultInstance())
                        .displayItems((parameters, output) -> {
                            output.accept(GooT5_ITEM.get());
                        }).build());

                        GOO_REVIVE_TIER_5  = tagItem("goo_revive_tier_5");

    }



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
