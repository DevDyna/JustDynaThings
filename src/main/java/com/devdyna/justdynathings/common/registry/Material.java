package com.devdyna.justdynathings.common.registry;

import java.util.ArrayList;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.common.registry.builder.MetalBlock;
import com.devdyna.justdynathings.common.registry.builder.PhaseBox;
import com.devdyna.justdynathings.common.registry.builder.RawOre;
import com.devdyna.justdynathings.common.registry.builder.budding.BuddingBE;
import com.devdyna.justdynathings.common.registry.builder.budding.BuddingBlock;
import com.devdyna.justdynathings.common.registry.builder.goo.Goo;
import com.devdyna.justdynathings.common.registry.builder.goo.GooBE;
import com.devdyna.justdynathings.common.registry.builder.goo.GooBlockItem;
import com.devdyna.justdynathings.common.registry.builder.goo.custom.creative.CreativeGoo;
import com.devdyna.justdynathings.common.registry.builder.goo.custom.creative.CreativeGooBE;
import com.devdyna.justdynathings.common.registry.builder.goo.custom.energy.EnergyGoo;
import com.devdyna.justdynathings.common.registry.builder.goo.custom.energy.EnergyGooBE;
import com.devdyna.justdynathings.common.registry.builder.reforger.ReforgerBE;
import com.devdyna.justdynathings.common.registry.builder.reforger.ReforgerBlock;
import com.devdyna.justdynathings.common.registry.builder.reforger.ReforgerGUI;
import com.devdyna.justdynathings.utils.RegUtil;
import com.direwolf20.justdirethings.setup.Registration;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredBlock;
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
                zATC.register(bus); // UNUSED
        }

        // -----------------------------------------------------------------------------------------------------------//
        public static final DeferredRegister<BlockEntityType<?>> zBE = DeferredRegister
                        .create(Registries.BLOCK_ENTITY_TYPE, Main.ID);
        public static final DeferredRegister.Blocks zBLK = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Items zITM = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister<CreativeModeTab> zCTBS = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, Main.ID);
        public static final DeferredRegister<MenuType<?>> zCTNR = DeferredRegister.create(Registries.MENU, Main.ID);

        // UNUSED
        private static final DeferredRegister<AttachmentType<?>> zATC = DeferredRegister.create(Keys.ATTACHMENT_TYPES,
                        Main.ID);
        // -----------------------------------------------------------------------------------------------------------//

        public static final TagKey<Item> GOO_REVIVE_TIER_0 = RegUtil.createtagItem("goo_revive_tier_0");

        public static final TagKey<Item> GOO_REVIVE_TIER_5 = RegUtil.createtagItem("goo_revive_tier_5");

        public static final TagKey<Block> REFORGER_REPLACE = RegUtil.createtagBlock("reforger_replace");

        public static final TagKey<Item> REFORGER_CATALYST = RegUtil.createtagItem("reforger_catalyst");

        public static final TagKey<Item> FLAWED_REVITALIZER = RegUtil.createtagItem("flawed_revitalizer");

        // -----------------------------------------------------------------------------------------------------------//

        public static final DeferredHolder<Block, Goo> GooT5_BLOCK = zBLK.register(
                        Constants.Material.Goo.Complex.id + "_" + Constants.Material.Goo.ID.id,
                        () -> new Goo(Constants.Material.Goo.Complex.id, 5, 20, GOO_REVIVE_TIER_5));

        public static final DeferredHolder<Block, Goo> GooT0_BLOCK = zBLK.register(
                        Constants.Material.Goo.Rotten.id + "_" + Constants.Material.Goo.ID.id,
                        () -> new Goo(Constants.Material.Goo.Rotten.id, 0, 4, GOO_REVIVE_TIER_0));

        public static final DeferredHolder<Block, EnergyGoo> GooT6_ENERGY_BLOCK = zBLK.register(
                        Constants.Material.Goo.Energized.id + "_" + Constants.Material.Goo.ID.id,
                        () -> new EnergyGoo(Constants.Material.Goo.Energized.id, 6, 10, 250,
                                        10000));

        public static final DeferredHolder<Block, CreativeGoo> GooT5_CREATIVE_BLOCK = zBLK.register(
                        Constants.Material.Goo.Creative.id + "_" + Constants.Material.Goo.ID.id,
                        () -> new CreativeGoo(Constants.Material.Goo.Creative.id, 5, 10));

        public static final DeferredHolder<Block, EnergyGoo> T0_ENERGY = FEGooCapByTier(
                        Constants.Material.Goo.Rotten.id, 0);
        public static final DeferredHolder<Block, EnergyGoo> T1_ENERGY = FEGooCapByTier(Constants.Material.Goo.T1.id,
                        1);
        public static final DeferredHolder<Block, EnergyGoo> T2_ENERGY = FEGooCapByTier(Constants.Material.Goo.T2.id,
                        2);
        public static final DeferredHolder<Block, EnergyGoo> T3_ENERGY = FEGooCapByTier(Constants.Material.Goo.T3.id,
                        3);
        public static final DeferredHolder<Block, EnergyGoo> T4_ENERGY = FEGooCapByTier(Constants.Material.Goo.T4.id,
                        4);
        public static final DeferredHolder<Block, EnergyGoo> T5_ENERGY = FEGooCapByTier(
                        Constants.Material.Goo.Complex.id, 5);

        public static final DeferredHolder<Block, PhaseBox> PHASEBOX = zBLK.register(Constants.Material.PhaseBox.id,
                        () -> new PhaseBox());

        public static final DeferredHolder<Block, MetalBlock> METAL_BLOCK = zBLK.register(
                        Constants.Material.MetalBlock.id,
                        () -> new MetalBlock());

        public static final DeferredHolder<Block, RawOre> RAW_CHAOTIC_BLOCK = zBLK.register(
                        Constants.Material.Ore.Chaotic_Block.id,
                        () -> new RawOre(SoundType.AMETHYST, 2.0f, 2.0f));

        public static final DeferredHolder<Block, RawOre> RAW_REDSTONIC_BLOCK = zBLK.register(
                        Constants.Material.Ore.Redstonic_Block.id,
                        () -> new RawOre(SoundType.AMETHYST, 3.0f, 6.0f));

        public static final DeferredHolder<Block, RawOre> RAW_COPRINIUM_BLOCK = zBLK.register(
                        Constants.Material.Ore.Coprinium_Block.id,
                        () -> new RawOre(SoundType.AMETHYST, 1.4f, 7.0f));

        public static final DeferredHolder<Block, ReforgerBlock> REFORGER_BLOCK = zBLK
                        .register(Constants.Material.Reforger.id, ReforgerBlock::new);

        public static final DeferredHolder<Block, BuddingBlock> POWERED_TIME = zBLK.register(
                        Constants.Material.Budding.Powered.id + "_" + Constants.Material.Budding.Time.id,
                        () -> new BuddingBlock(
                                        Constants.FEBudding.FECost.value, Constants.FEBudding.FECapacity.value,
                                        Constants.FEBudding.FLCost.value, Constants.FEBudding.FLCapacity.value,
                                        Registration.TimeCrystalCluster_Small.get(),
                                        Registration.TimeCrystalCluster_Medium.get(),
                                        Registration.TimeCrystalCluster_Large.get(),
                                        Registration.TimeCrystalCluster.get()));

        public static final DeferredHolder<Block, BuddingBlock> POWERED_AMETHYST = zBLK.register(
                        Constants.Material.Budding.Powered.id + "_" + Constants.Material.Budding.Amethyst.id,
                        () -> new BuddingBlock(
                                        Constants.FEBudding.FECost.value, Constants.FEBudding.FECapacity.value,
                                        Constants.FEBudding.FLCost.value, Constants.FEBudding.FLCapacity.value,
                                        Blocks.SMALL_AMETHYST_BUD,
                                        Blocks.MEDIUM_AMETHYST_BUD,
                                        Blocks.LARGE_AMETHYST_BUD,
                                        Blocks.AMETHYST_CLUSTER));

        // -----------------------------------------------------------------------------------------------------------//

        public static final DeferredHolder<Item, BlockItem> GooT5_ITEM = simpleGooItem(GooT5_BLOCK,
                        Constants.Material.Goo.Complex.id);

        public static final DeferredHolder<Item, BlockItem> GooT0_ITEM = simpleGooItem(GooT0_BLOCK,
                        Constants.Material.Goo.Rotten.id);

        public static final DeferredHolder<Item, BlockItem> GooT6_ITEM_Energy = simpleGooItem(GooT6_ENERGY_BLOCK,
                        Constants.Material.Goo.Energized.id);

        public static final DeferredHolder<Item, BlockItem> GooT5_ITEM_Creative = simpleGooItem(GooT5_CREATIVE_BLOCK,
                        Constants.Material.Goo.Creative.id);

        public static final DeferredHolder<Item, Item> RAW_CHAOTIC_ITEM = zITM
                        .registerSimpleItem(Constants.Material.Ore.Chaotic_Item.id);

        public static final DeferredHolder<Item, BlockItem> RAW_CHAOTIC_BLOCK_ITEM = zITM
                        .registerSimpleBlockItem(RAW_CHAOTIC_BLOCK);

        public static final DeferredHolder<Item, Item> RAW_REDSTONIC_ITEM = zITM
                        .registerSimpleItem(Constants.Material.Ore.Redstonic_Item.id);

        public static final DeferredHolder<Item, BlockItem> RAW_REDSTONIC_BLOCK_ITEM = zITM
                        .registerSimpleBlockItem(RAW_REDSTONIC_BLOCK);

        public static final DeferredHolder<Item, Item> RAW_COPRINIUM_RAW_ITEM = zITM
                        .registerSimpleItem(Constants.Material.Ore.Coprinium_Raw.id);

        public static final DeferredHolder<Item, Item> RAW_COPRINIUM_INGOT_ITEM = zITM
                        .registerSimpleItem(Constants.Material.Ore.Coprinium_Ingot.id);

        public static final DeferredHolder<Item, BlockItem> RAW_COPRINIUM_BLOCK_ITEM = zITM
                        .registerSimpleBlockItem(RAW_COPRINIUM_BLOCK);

        public static final DeferredHolder<Item, BlockItem> PHASEBOX_ITEM = zITM
                        .registerSimpleBlockItem(PHASEBOX);

        public static final DeferredHolder<Item, BlockItem> METALBLOCK_ITEM = zITM
                        .registerSimpleBlockItem(METAL_BLOCK);

        public static final DeferredHolder<Item, BlockItem> REFORGER_ITEM = zITM
                        .registerSimpleBlockItem(REFORGER_BLOCK);

        public static final DeferredHolder<Item, BlockItem> T0_ENERGY_ITEM = simpleFEGooItem(T0_ENERGY,
                        Constants.Material.Goo.Rotten.id);
        public static final DeferredHolder<Item, BlockItem> T1_ENERGY_ITEM = simpleFEGooItem(T1_ENERGY,
                        Constants.Material.Goo.T1.id);
        public static final DeferredHolder<Item, BlockItem> T2_ENERGY_ITEM = simpleFEGooItem(T2_ENERGY,
                        Constants.Material.Goo.T2.id);
        public static final DeferredHolder<Item, BlockItem> T3_ENERGY_ITEM = simpleFEGooItem(T3_ENERGY,
                        Constants.Material.Goo.T3.id);
        public static final DeferredHolder<Item, BlockItem> T4_ENERGY_ITEM = simpleFEGooItem(T4_ENERGY,
                        Constants.Material.Goo.T4.id);
        public static final DeferredHolder<Item, BlockItem> T5_ENERGY_ITEM = simpleFEGooItem(T5_ENERGY,
                        Constants.Material.Goo.Complex.id);

        public static final DeferredHolder<Item, BlockItem> POWERED_TIME_ITEM = zITM
                        .registerSimpleBlockItem(POWERED_TIME);

        public static final DeferredHolder<Item, BlockItem> POWERED_AMETHYST_ITEM = zITM
                        .registerSimpleBlockItem(POWERED_AMETHYST);

        // -----------------------------------------------------------------------------------------------------------//

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GooBE>> GOO_BE = zBE.register(
                        Constants.Material.Goo.ID.id + "_" + Constants.BlockEntity.id,
                        () -> Builder.of(GooBE::new, GooT5_BLOCK.get(), GooT0_BLOCK.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyGooBE>> ENERGY_GOO_BE = zBE
                        .register(Constants.Material.Goo.Energized.id + "_" + Constants.BlockEntity.id,
                                        () -> Builder.of(EnergyGooBE::new, GooT6_ENERGY_BLOCK.get(), T0_ENERGY.get(),
                                                        T1_ENERGY.get(), T2_ENERGY.get(), T3_ENERGY.get(),
                                                        T4_ENERGY.get(), T5_ENERGY.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CreativeGooBE>> CREATIVE_GOO_BE = zBE
                        .register(Constants.Material.Goo.Creative.id + "_" + Constants.BlockEntity.id,
                                        () -> Builder.of(CreativeGooBE::new, GooT5_CREATIVE_BLOCK.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ReforgerBE>> REFORGER_BE = zBE
                        .register(Constants.Material.Reforger.id + "_" + Constants.BlockEntity.id,
                                        () -> Builder.of(ReforgerBE::new, REFORGER_BLOCK.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BuddingBE>> POWERED_BUDDING_BE = zBE
                        .register(
                                        Constants.Material.Budding.Powered.id + "_" + Constants.BlockEntity.id,
                                        () -> Builder.of(BuddingBE::new, getBuddingAvailable())
                                                        .build(null));

        // -----------------------------------------------------------------------------------------------------------//

        public static final DeferredHolder<MenuType<?>, MenuType<ReforgerGUI>> REFORGER_GUI = zCTNR
                        .register(Constants.Material.Reforger.id + "_" + Constants.GUI.id,
                                        () -> IMenuTypeExtension.create(ReforgerGUI::new));

        // -----------------------------------------------------------------------------------------------------------//

        public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVETAB = zCTBS
                        .register(Main.ID, () -> CreativeModeTab.builder()
                                        .title(Component.translatable(Main.ID + "." + Constants.CreativeTab.id))
                                        .withTabsBefore(CreativeModeTabs.COMBAT)
                                        .icon(() -> REFORGER_BLOCK.get().asItem().getDefaultInstance())
                                        .displayItems((parameters, output) -> {
                                                zITM.getEntries().forEach(e -> {
                                                        output.accept((Item) e.get());
                                                });

                                                if (Constants.Mods.AE2.check)
                                                        com.devdyna.justdynathings.compat.ae2.init.zAE_ITM.getEntries()
                                                                        .forEach(e -> {
                                                                                output.accept((Item) e.get());
                                                                        });
                                                if (Constants.Mods.ExtendedAE.check)
                                                        com.devdyna.justdynathings.compat.extendedae.init.zEXTAE_ITM
                                                                        .getEntries().forEach(e -> {
                                                                                output.accept((Item) e.get());
                                                                        });
                                                if (Constants.Mods.PhasoriteNetworks.check)
                                                        com.devdyna.justdynathings.compat.phasorite.init.zPHASO_ITM
                                                                        .getEntries().forEach(e -> {
                                                                                output.accept((Item) e.get());
                                                                        });

                                        }).build());

        // -----------------------------------------------------------------------------------------------------------//
        // -----------------------------------------------------------------------------------------------------------//

        public static DeferredBlock<EnergyGoo> simpleFEGoo(String id, int tier, int reducer, int fecost, int fecap) {
                return zBLK.register(
                                Constants.Material.Goo.Energized.id + "_" + id + "_" + Constants.Material.Goo.ID.id,
                                () -> new EnergyGoo(
                                                Constants.Material.Goo.Energized.id + "_" + id + "_"
                                                                + Constants.Material.Goo.ID.id,
                                                tier, reducer, fecost,
                                                fecap));
        }

        public static DeferredBlock<EnergyGoo> simpleFEGoo(String id, int tier) {
                return simpleFEGoo(id, tier, 4, Constants.FEGoo.Cost.value, Constants.FEGoo.Capacity.value);
        }

        public static DeferredBlock<EnergyGoo> FEGooCapByTier(String id, int tier) {
                return simpleFEGoo(id, tier, 4 * (tier + 1), Constants.FEGoo.Cost.value * tier,
                                Constants.FEGoo.Capacity.value * (tier + 1));
        }

        public static DeferredHolder<Item, BlockItem> simpleGooItem(DeferredHolder<Block, ?> block, String id) {
                return zITM.register(
                                id + "_" + Constants.Material.Goo.ID.id,
                                () -> new GooBlockItem(block.get()));
        }

        public static DeferredHolder<Item, BlockItem> simpleFEGooItem(DeferredHolder<Block, ?> block, String id) {
                return zITM.register(
                                Constants.Material.Goo.Energized.id + "_" + id + "_" + Constants.Material.Goo.ID.id,
                                () -> new GooBlockItem(block.get()));
        }

        public static Block[] getBuddingAvailable() {
                ArrayList<Block> a = new ArrayList<>();
                a.add(POWERED_AMETHYST.get());
                a.add(POWERED_TIME.get());

                if (Constants.Mods.AE2.check)
                        a.add(com.devdyna.justdynathings.compat.ae2.init.AE2_POWERED.get());
                if (Constants.Mods.ExtendedAE.check)
                        a.add(com.devdyna.justdynathings.compat.extendedae.init.EXTENDED_POWERED.get());
                if (Constants.Mods.PhasoriteNetworks.check)
                        a.add(com.devdyna.justdynathings.compat.phasorite.init.PHASORITE_POWERED.get());

                Block[] array = new Block[a.size()];
                for (int i = 0; i < a.size(); i++) {
                        array[i] = a.get(i);
                }

                return array;
        }

}
