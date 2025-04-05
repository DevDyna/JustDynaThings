package com.devdyna.justdynathings.common.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.common.registry.Material;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {
    public static void register(IEventBus bus) {
        zItem.register(bus);
        zTool.register(bus);
        zBlockItem.register(bus);
    }
    // ---------------------------------------------------------------------------------------//
    public static final DeferredRegister.Items zTool = DeferredRegister.createItems(Main.ID);
    //DONT USE IT , ONLY FUNCTIONAL
    public static final DeferredRegister.Items zBlockItem = DeferredRegister.createItems(Main.ID);
    public static final DeferredRegister.Items zItem = DeferredRegister.createItems(Main.ID);
    // ---------------------------------------------------------------------------------------//

    public static final DeferredHolder<Item, BlockItem> GooT5_ITEM = Material.simpleGooItem(Blocks.GooT5_BLOCK,
                        Constants.Material.Goo.Complex.id);

        public static final DeferredHolder<Item, BlockItem> GooT0_ITEM = Material.simpleGooItem(Blocks.GooT0_BLOCK,
                        Constants.Material.Goo.Rotten.id);

        public static final DeferredHolder<Item, BlockItem> GooT6_ITEM_Energy = Material.simpleGooItem(Blocks.GooT6_ENERGY_BLOCK,
                        Constants.Material.Goo.Energized.id);

        public static final DeferredHolder<Item, BlockItem> GooT5_ITEM_Creative = Material.simpleGooItem(Blocks.GooT5_CREATIVE_BLOCK,
                        Constants.Material.Goo.Creative.id);

        public static final DeferredHolder<Item, Item> RAW_CHAOTIC_ITEM = zItem
                        .registerSimpleItem(Constants.Material.Ore.Chaotic_Item.id);

        public static final DeferredHolder<Item, BlockItem> RAW_CHAOTIC_BI = zItem
                        .registerSimpleBlockItem(Blocks.RAW_CHAOTIC_BLOCK);

        public static final DeferredHolder<Item, Item> RAW_REDSTONIC_ITEM = zItem
                        .registerSimpleItem(Constants.Material.Ore.Redstonic_Item.id);

        public static final DeferredHolder<Item, BlockItem> RAW_REDSTONIC_BI = zItem
                        .registerSimpleBlockItem(Blocks.RAW_REDSTONIC_BLOCK);

        public static final DeferredHolder<Item, Item> RAW_COPRINIUM_RAW_ITEM = zItem
                        .registerSimpleItem(Constants.Material.Ore.Coprinium_Raw.id);

        public static final DeferredHolder<Item, Item> RAW_COPRINIUM_INGOT_ITEM = zItem
                        .registerSimpleItem(Constants.Material.Ore.Coprinium_Ingot.id);

        public static final DeferredHolder<Item, BlockItem> RAW_COPRINIUM_BI = zItem
                        .registerSimpleBlockItem(Blocks.RAW_COPRINIUM_BLOCK);

        public static final DeferredHolder<Item, BlockItem> PHASEBOX_BI = zItem
                        .registerSimpleBlockItem(Blocks.PHASEBOX);

        public static final DeferredHolder<Item, BlockItem> METALBLOCK_BI = zItem
                        .registerSimpleBlockItem(Blocks.METAL_BLOCK);

        public static final DeferredHolder<Item, BlockItem> REFORGER_BI = zItem
                        .registerSimpleBlockItem(Blocks.REFORGER_BLOCK);

        public static final DeferredHolder<Item, BlockItem> T0_ENERGY_BI = Material.simpleFEGooItem(Blocks.T0_ENERGY,
                        Constants.Material.Goo.Rotten.id);
        public static final DeferredHolder<Item, BlockItem> T1_ENERGY_BI = Material.simpleFEGooItem(Blocks.T1_ENERGY,
                        Constants.Material.Goo.T1.id);
        public static final DeferredHolder<Item, BlockItem> T2_ENERGY_BI = Material.simpleFEGooItem(Blocks.T2_ENERGY,
                        Constants.Material.Goo.T2.id);
        public static final DeferredHolder<Item, BlockItem> T3_ENERGY_BI = Material.simpleFEGooItem(Blocks.T3_ENERGY,
                        Constants.Material.Goo.T3.id);
        public static final DeferredHolder<Item, BlockItem> T4_ENERGY_BI = Material.simpleFEGooItem(Blocks.T4_ENERGY,
                        Constants.Material.Goo.T4.id);
        public static final DeferredHolder<Item, BlockItem> T5_ENERGY_BI = Material.simpleFEGooItem(Blocks.T5_ENERGY,
                        Constants.Material.Goo.Complex.id);

        public static final DeferredHolder<Item, BlockItem> TIME_BI = zItem
                        .registerSimpleBlockItem(Blocks.POWERED_TIME);

        public static final DeferredHolder<Item, BlockItem> AMETHYST_BI = zItem
                        .registerSimpleBlockItem(Blocks.POWERED_AMETHYST);

        public static final DeferredHolder<Item, BlockItem> BLAZINGANVIL_BI = zItem
                        .registerSimpleBlockItem(Blocks.BLAZINGANVIL_BLOCK);

        public static final DeferredHolder<Item, BlockItem> CLOCK_BLOCK_BI = zItem
                        .registerSimpleBlockItem(Blocks.CLOCK_BLOCK);

        public static final DeferredHolder<Item, BlockItem> REVITALIZER_BI = zItem
                        .registerSimpleBlockItem(Blocks.REVITALIZER_BLOCK);

        public static final DeferredHolder<Item, BlockItem> TICKER_BI = zItem
                        .registerSimpleBlockItem(Blocks.TICKER_BLOCK);

                        public static final DeferredHolder<Item, BlockItem> SCULK_BI = zItem
                        .registerSimpleBlockItem(Blocks.SCULK_BLOCK);


}
