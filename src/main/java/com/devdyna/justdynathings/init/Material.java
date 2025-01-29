package com.devdyna.justdynathings.init;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.init.builder.PhaseBox;
import com.devdyna.justdynathings.init.builder.goo.GooT0;
import com.devdyna.justdynathings.init.builder.goo.GooT0BE;
import com.devdyna.justdynathings.init.builder.goo.GooT5;
import com.devdyna.justdynathings.init.builder.goo.GooT5BE;
import com.devdyna.justdynathings.init.builder.reforger.ReforgerBE;
import com.devdyna.justdynathings.init.builder.reforger.ReforgerBlock;
import com.devdyna.justdynathings.init.builder.reforger.ReforgerGUI;
import com.devdyna.justdynathings.simply.GooBlockItem;
import com.devdyna.justdynathings.simply.RawOre;
import com.devdyna.justdynathings.utils.RegUtil;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("null")
public class Material {

    public static void register(IEventBus bus) {
        zBLK.register(bus);
        zITM.register(bus);
        zBE.register(bus);
        zCTBS.register(bus);
        zCTNR.register(bus);
    }

    // -----------------------------------------------------------------------------------------------------------//
    public static final DeferredRegister<BlockEntityType<?>> zBE = DeferredRegister
            .create(Registries.BLOCK_ENTITY_TYPE, Main.ID);
    public static final DeferredRegister.Blocks zBLK = DeferredRegister.createBlocks(Main.ID);
    public static final DeferredRegister.Items zITM = DeferredRegister.createItems(Main.ID);
    public static final DeferredRegister<CreativeModeTab> zCTBS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, Main.ID);
    public static final DeferredRegister<MenuType<?>> zCTNR = DeferredRegister.create(Registries.MENU, Main.ID);

    // -----------------------------------------------------------------------------------------------------------//

    public static final DeferredHolder<Block, GooT5> GooT5_BLOCK = zBLK.register("ferrous_goo",
            () -> new GooT5("ferrous"));

    public static final DeferredHolder<Block, GooT0> GooT0_BLOCK = zBLK.register("rotten_goo",
            () -> new GooT0("rotten"));

    public static final DeferredHolder<Block, PhaseBox> PHASEBOX = zBLK.register("phase_box",
            () -> new PhaseBox());

    public static final DeferredHolder<Block, ?> a = zBLK.register("ore_a",
            () -> new RawOre(SoundType.AMETHYST, 2.0f, 2.0f));

    public static final DeferredHolder<Block, ?> b = zBLK.register("ore_b",
            () -> new RawOre(SoundType.AMETHYST, 2.0f, 2.0f));

    public static final DeferredHolder<Block, ?> c = zBLK.register("ore_c",
            () -> new RawOre(SoundType.AMETHYST, 2.0f, 2.0f));

    public static final DeferredHolder<Block, ReforgerBlock> REFORGER_BLOCK = zBLK
            .register("reforger", ReforgerBlock::new);
    // -----------------------------------------------------------------------------------------------------------//
    public static final DeferredHolder<Item, BlockItem> GooT0_ITEM = zITM.register("rotten_goo",
            () -> new GooBlockItem(GooT0_BLOCK.get()));

    public static final DeferredHolder<Item, BlockItem> GooT5_ITEM = zITM.register("complex_goo",
            () -> new GooBlockItem(GooT5_BLOCK.get()));

    public static final DeferredHolder<Item, BlockItem> ANTIBLOCK_ITEM = zITM
            .registerSimpleBlockItem(PHASEBOX);

    public static final DeferredHolder<Item, BlockItem> REFORGER_ITEM = zITM
            .register("reforger", () -> new BlockItem(REFORGER_BLOCK.get(), new Item.Properties()));

            public static final DeferredHolder<Item, BlockItem> A_ITEM = zITM
            .registerSimpleBlockItem(a);
            public static final DeferredHolder<Item, BlockItem> B_ITEM = zITM
            .registerSimpleBlockItem(b);
            public static final DeferredHolder<Item, BlockItem> C_ITEM = zITM
            .registerSimpleBlockItem(c);

    // -----------------------------------------------------------------------------------------------------------//

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GooT5BE>> GooT5_BE = zBE
            .register("complex_goo", () -> Builder.of(GooT5BE::new, GooT5_BLOCK.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GooT0BE>> GooT0_BE = zBE
            .register("rotten_goo", () -> Builder.of(GooT0BE::new, GooT0_BLOCK.get()).build(null));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ReforgerBE>> REFORGER_BE = zBE
            .register("reforger_be",
                    () -> Builder.of(ReforgerBE::new, REFORGER_BLOCK.get()).build(null));

    // -----------------------------------------------------------------------------------------------------------//

    public static final TagKey<Item> GOO_REVIVE_TIER_0 = RegUtil.tagItem("goo_revive_tier_0");

    public static final TagKey<Item> GOO_REVIVE_TIER_5 = RegUtil.tagItem("goo_revive_tier_5");

    // -----------------------------------------------------------------------------------------------------------//

    public static final DeferredHolder<MenuType<?>, MenuType<ReforgerGUI>> GEN_GUI = zCTNR
            .register("gen_c",
                    () -> IMenuTypeExtension.create(ReforgerGUI::new));
    // -----------------------------------------------------------------------------------------------------------//

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CreativeTab = zCTBS
            .register(Main.ID, () -> CreativeModeTab.builder()
                    .title(Component.translatable(Main.ID + ".tabname"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> GooT5_BLOCK.get().asItem().getDefaultInstance())
                    .displayItems((parameters, output) -> {

                        zITM.getEntries().forEach(e -> {
                            output.accept((Item) e.get());
                        });

                    }).build());

}
