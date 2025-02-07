package com.devdyna.justdynathings.init;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.init.builder.MetalBlock;
import com.devdyna.justdynathings.init.builder.PhaseBox;
import com.devdyna.justdynathings.init.builder.RawOre;
import com.devdyna.justdynathings.init.builder.goo.Goo;
import com.devdyna.justdynathings.init.builder.goo.GooBE;
import com.devdyna.justdynathings.init.builder.goo.GooBlockItem;
import com.devdyna.justdynathings.init.builder.goo.custom.creative.CreativeGoo;
import com.devdyna.justdynathings.init.builder.goo.custom.creative.CreativeGooBE;
import com.devdyna.justdynathings.init.builder.goo.custom.energy.EnergyGoo;
import com.devdyna.justdynathings.init.builder.goo.custom.energy.EnergyGooBE;
import com.devdyna.justdynathings.init.builder.reforger.ReforgerBE;
import com.devdyna.justdynathings.init.builder.reforger.ReforgerBlock;
import com.devdyna.justdynathings.init.builder.reforger.ReforgerGUI;
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
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries.Keys;

@SuppressWarnings("null")
public class Material {

        public static void register(IEventBus bus) {
                zBLK.register(bus);
                zITM.register(bus);
                zBE.register(bus);
                zCTBS.register(bus);
                zCTNR.register(bus);
                zATC.register(bus);
        }

        // -----------------------------------------------------------------------------------------------------------//
        public static final DeferredRegister<BlockEntityType<?>> zBE = DeferredRegister
                        .create(Registries.BLOCK_ENTITY_TYPE, Main.ID);
        public static final DeferredRegister.Blocks zBLK = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Items zITM = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister<CreativeModeTab> zCTBS = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, Main.ID);
        public static final DeferredRegister<MenuType<?>> zCTNR = DeferredRegister.create(Registries.MENU, Main.ID);
        private static final DeferredRegister<AttachmentType<?>> zATC = DeferredRegister.create(Keys.ATTACHMENT_TYPES,
                        Main.ID);
        // -----------------------------------------------------------------------------------------------------------//

        public static final TagKey<Item> GOO_REVIVE_TIER_0 = RegUtil.tagItem("goo_revive_tier_0");

        public static final TagKey<Item> GOO_REVIVE_TIER_5 = RegUtil.tagItem("goo_revive_tier_5");

        public static final TagKey<Block> REFORGER_REPLACE = RegUtil.tagBlock("reforger/replace");

        public static final TagKey<Item> REFORGER_CATALYST = RegUtil.tagItem("reforger/catalyst");

        // -----------------------------------------------------------------------------------------------------------//

        public static final DeferredHolder<Block, Goo> GooT5_BLOCK = zBLK.register(
                        Constants.Material.Goo.Complex.id + "_" + Constants.Material.Goo.ID.id,
                        () -> new Goo(Constants.Material.Goo.Complex.id + "", 5, 20, GOO_REVIVE_TIER_5));

        public static final DeferredHolder<Block, Goo> GooT0_BLOCK = zBLK.register(
                        Constants.Material.Goo.Rotten.id + "_" + Constants.Material.Goo.ID.id,
                        () -> new Goo(Constants.Material.Goo.Rotten.id + "", 0, 4, GOO_REVIVE_TIER_0));

        public static final DeferredHolder<Block, EnergyGoo> GooT4_ENERGY_BLOCK = zBLK.register(
                        Constants.Material.Goo.Energized.id + "_" + Constants.Material.Goo.ID.id,
                        () -> new EnergyGoo(Constants.Material.Goo.Energized.id + "", 4, 10, 250,
                                        10000));

        public static final DeferredHolder<Block, CreativeGoo> GooT5_CREATIVE_BLOCK = zBLK.register(
                        Constants.Material.Goo.Creative.id + "_" + Constants.Material.Goo.ID.id,
                        () -> new CreativeGoo(Constants.Material.Goo.Creative.id, 5, 10));

        public static final DeferredHolder<Block, PhaseBox> PHASEBOX = zBLK.register(Constants.Material.PhaseBox.id,
                        () -> new PhaseBox());

        public static final DeferredHolder<Block, MetalBlock> METAL_BLOCK = zBLK.register(
                        Constants.Material.MetalBlock.id,
                        () -> new MetalBlock());

        public static final DeferredHolder<Block, RawOre> RAW_CHAOTIC_BLOCK = zBLK.register(
                        Constants.Material.Chaotic.Block.id,
                        () -> new RawOre(SoundType.AMETHYST, 2.0f, 2.0f));

        public static final DeferredHolder<Block, ReforgerBlock> REFORGER_BLOCK = zBLK
                        .register(Constants.Material.Reforger.id, ReforgerBlock::new);

        // -----------------------------------------------------------------------------------------------------------//

        public static final DeferredHolder<Item, BlockItem> GooT5_ITEM = zITM.register(
                        Constants.Material.Goo.Complex.id + "_" + Constants.Material.Goo.ID.id,
                        () -> new GooBlockItem(GooT5_BLOCK.get()));

        public static final DeferredHolder<Item, BlockItem> GooT0_ITEM = zITM.register(
                        Constants.Material.Goo.Rotten.id + "_" + Constants.Material.Goo.ID.id,
                        () -> new GooBlockItem(GooT0_BLOCK.get()));

        public static final DeferredHolder<Item, BlockItem> GooT4_ITEM_Energy = zITM.register(
                        Constants.Material.Goo.Energized.id + "_" + Constants.Material.Goo.ID.id,
                        () -> new GooBlockItem(GooT4_ENERGY_BLOCK.get()));

        public static final DeferredHolder<Item, BlockItem> GooT5_ITEM_Creative = zITM.register(
                        Constants.Material.Goo.Creative.id + "_" + Constants.Material.Goo.ID.id,
                        () -> new GooBlockItem(GooT5_CREATIVE_BLOCK.get()));

        public static final DeferredHolder<Item, Item> RAW_CHAOTIC_ITEM = zITM
                        .registerSimpleItem(Constants.Material.Chaotic.Item.id);

        public static final DeferredHolder<Item, BlockItem> PHASEBOX_ITEM = zITM
                        .registerSimpleBlockItem(PHASEBOX);

        public static final DeferredHolder<Item, BlockItem> METALBLOCK_ITEM = zITM
                        .registerSimpleBlockItem(METAL_BLOCK);

        public static final DeferredHolder<Item, BlockItem> REFORGER_ITEM = zITM
                        .register(Constants.Material.Reforger.id,
                                        () -> new BlockItem(REFORGER_BLOCK.get(), new Item.Properties()));

        public static final DeferredHolder<Item, BlockItem> RAW_CHAOTIC_BLOCK_ITEM = zITM
                        .registerSimpleBlockItem(RAW_CHAOTIC_BLOCK);

        // -----------------------------------------------------------------------------------------------------------//

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GooBE>> GOO_BE = zBE.register(
                        Constants.Material.Goo.ID.id + "_" + Constants.BlockEntity.id,
                        () -> Builder.of(GooBE::new, GooT5_BLOCK.get(), GooT0_BLOCK.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyGooBE>> ENERGY_GOO_BE = zBE
                        .register(Constants.Material.Goo.Energized.id + "_" + Constants.BlockEntity.id,
                                        () -> Builder.of(EnergyGooBE::new, GooT4_ENERGY_BLOCK.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CreativeGooBE>> CREATIVE_GOO_BE = zBE
                        .register(Constants.Material.Goo.Creative.id + "_" + Constants.BlockEntity.id,
                                        () -> Builder.of(CreativeGooBE::new, GooT5_CREATIVE_BLOCK.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ReforgerBE>> REFORGER_BE = zBE
                        .register(Constants.Material.Reforger.id + "_" + Constants.BlockEntity.id,
                                        () -> Builder.of(ReforgerBE::new, REFORGER_BLOCK.get()).build(null));

        // -----------------------------------------------------------------------------------------------------------//

        public static final DeferredHolder<MenuType<?>, MenuType<ReforgerGUI>> REFORGER_GUI = zCTNR
                        .register(Constants.Material.Reforger.id + "_" + Constants.GUI.id,
                                        () -> IMenuTypeExtension.create(ReforgerGUI::new));

        // -----------------------------------------------------------------------------------------------------------//

        public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CreativeTab = zCTBS
                        .register(Main.ID, () -> CreativeModeTab.builder()
                                        .title(Component.translatable(Main.ID +"."+ Constants.CreativeTab.id))
                                        .withTabsBefore(CreativeModeTabs.COMBAT)
                                        .icon(() -> GooT5_BLOCK.get().asItem().getDefaultInstance())
                                        .displayItems((parameters, output) -> {

                                                zITM.getEntries().forEach(e -> {
                                                        output.accept((Item) e.get());
                                                });

                                        }).build());

        // -----------------------------------------------------------------------------------------------------------//
}
