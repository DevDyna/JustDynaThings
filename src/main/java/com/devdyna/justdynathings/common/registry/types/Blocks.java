package com.devdyna.justdynathings.common.registry.types;



import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.common.registry.Material;
import com.devdyna.justdynathings.common.registry.core.builders.MetalBlock;
import com.devdyna.justdynathings.common.registry.core.builders.PhaseBox;
import com.devdyna.justdynathings.common.registry.core.builders.RawOre;
import com.devdyna.justdynathings.common.registry.core.builders.budding.BuddingBlock;
import com.devdyna.justdynathings.common.registry.core.builders.clock.ClockBlock;
import com.devdyna.justdynathings.common.registry.core.builders.goo.Goo;
import com.devdyna.justdynathings.common.registry.core.builders.goo.custom.creative.CreativeGoo;
import com.devdyna.justdynathings.common.registry.core.builders.goo.custom.energy.EnergyGoo;
import com.devdyna.justdynathings.common.registry.core.builders.reforger.ReforgerBlock;
import com.devdyna.justdynathings.common.registry.core.builders.repairer.BlazingAnvilBlock;
import com.devdyna.justdynathings.common.registry.core.builders.revitalizer.RevitalizerBlock;
import com.devdyna.justdynathings.common.registry.core.builders.sculk.SculkBlock;
import com.devdyna.justdynathings.common.registry.core.builders.ticker.TickerBlock;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Blocks {
        public static void register(IEventBus bus) {
                registerLists();
                zBlock.register(bus);
                zBlockItem.register(bus);
        }

        // ---------------------------------------------------------------------------------------//
        public static final DeferredRegister.Blocks zBlock = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Blocks zBlockItem = DeferredRegister.createBlocks(Main.ID);
        // ---------------------------------------------------------------------------------------//

        public static final DeferredHolder<Block, Goo> GooT5_BLOCK = zBlock.register(
                        Constants.Material.Goo.Complex.id + "_" + Constants.Material.Goo.ID.id,
                        () -> new Goo(Constants.Material.Goo.Complex.id, 5, 20, ItemTags.GOO_REVIVE_TIER_5));

        public static final DeferredHolder<Block, Goo> GooT0_BLOCK = zBlock.register(
                        Constants.Material.Goo.Rotten.id + "_" + Constants.Material.Goo.ID.id,
                        () -> new Goo(Constants.Material.Goo.Rotten.id, 0, 4, ItemTags.GOO_REVIVE_TIER_0));

        public static final DeferredHolder<Block, EnergyGoo> GooT6_ENERGY_BLOCK = zBlock.register(
                        Constants.Material.Goo.Energized.id + "_" + Constants.Material.Goo.ID.id,
                        () -> new EnergyGoo(Constants.Material.Goo.Energized.id, 6, 10, 250,
                                        10000));

        public static final DeferredHolder<Block, CreativeGoo> GooT5_CREATIVE_BLOCK = zBlock.register(
                        Constants.Material.Goo.Creative.id + "_" + Constants.Material.Goo.ID.id,
                        () -> new CreativeGoo(Constants.Material.Goo.Creative.id, Integer.MAX_VALUE - 1, 1000));

        public static final DeferredHolder<Block, EnergyGoo> T0_ENERGY = Material.FEGooCapByTier(
                        Constants.Material.Goo.Rotten.id, 0);
        public static final DeferredHolder<Block, EnergyGoo> T1_ENERGY = Material.FEGooCapByTier(Constants.Material.Goo.T1.id,
                        1);
        public static final DeferredHolder<Block, EnergyGoo> T2_ENERGY = Material.FEGooCapByTier(Constants.Material.Goo.T2.id,
                        2);
        public static final DeferredHolder<Block, EnergyGoo> T3_ENERGY = Material.FEGooCapByTier(Constants.Material.Goo.T3.id,
                        3);
        public static final DeferredHolder<Block, EnergyGoo> T4_ENERGY = Material.FEGooCapByTier(Constants.Material.Goo.T4.id,
                        4);
        public static final DeferredHolder<Block, EnergyGoo> T5_ENERGY = Material.FEGooCapByTier(
                        Constants.Material.Goo.Complex.id, 5);

        public static final DeferredHolder<Block, PhaseBox> PHASEBOX = zBlock.register(Constants.Material.PhaseBox.id,
                        () -> new PhaseBox());

        public static final DeferredHolder<Block, MetalBlock> METAL_BLOCK = zBlock.register(
                        Constants.Material.MetalBlock.id,
                        () -> new MetalBlock());

        public static final DeferredHolder<Block, RawOre> RAW_CHAOTIC_BLOCK = zBlock.register(
                        Constants.Material.Ore.Chaotic_Block.id,
                        () -> new RawOre(SoundType.AMETHYST, 2.0f, 2.0f));

        public static final DeferredHolder<Block, RawOre> RAW_REDSTONIC_BLOCK = zBlock.register(
                        Constants.Material.Ore.Redstonic_Block.id,
                        () -> new RawOre(SoundType.AMETHYST, 3.0f, 6.0f));

        public static final DeferredHolder<Block, RawOre> RAW_COPRINIUM_BLOCK = zBlock.register(
                        Constants.Material.Ore.Coprinium_Block.id,
                        () -> new RawOre(SoundType.AMETHYST, 1.4f, 7.0f));

        public static final DeferredHolder<Block, ReforgerBlock> REFORGER_BLOCK = zBlock
                        .register(Constants.Material.Reforger.id, ReforgerBlock::new);

        public static final DeferredHolder<Block, BuddingBlock> POWERED_TIME = zBlock.register(
                        Constants.Material.Budding.Powered.id + "_" + Constants.Material.Budding.Time.id,
                        () -> new BuddingBlock(
                                        Registration.TimeCrystalCluster_Small.get(),
                                        Registration.TimeCrystalCluster_Medium.get(),
                                        Registration.TimeCrystalCluster_Large.get(),
                                        Registration.TimeCrystalCluster.get()));

        public static final DeferredHolder<Block, BuddingBlock> POWERED_AMETHYST = zBlock.register(
                        Constants.Material.Budding.Powered.id + "_" + Constants.Material.Budding.Amethyst.id,
                        () -> new BuddingBlock(
                                        net.minecraft.world.level.block.Blocks.SMALL_AMETHYST_BUD,
                                        net.minecraft.world.level.block.Blocks.MEDIUM_AMETHYST_BUD,
                                        net.minecraft.world.level.block.Blocks.LARGE_AMETHYST_BUD,
                                        net.minecraft.world.level.block.Blocks.AMETHYST_CLUSTER));

        public static final DeferredHolder<Block, BlazingAnvilBlock> BLAZINGANVIL_BLOCK = zBlock
                        .register(Constants.Material.BlazingAnvil.id,
                                        () -> new BlazingAnvilBlock());

        public static final DeferredHolder<Block, ClockBlock> CLOCK_BLOCK = zBlock
                        .register(Constants.Material.Clock.id, ClockBlock::new);

        public static final DeferredHolder<Block, RevitalizerBlock> REVITALIZER_BLOCK = zBlock
                        .register(Constants.Material.Revitalizer.id,
                                        () -> new RevitalizerBlock());

        public static final DeferredHolder<Block, TickerBlock> TICKER_BLOCK = zBlock
                        .register(Constants.Material.Ticker.id,
                                        () -> new TickerBlock(1000,
                                                        100,1000,100));
        
                                                        public static final DeferredHolder<Block, SculkBlock> SCULK_BLOCK = zBlock
                                                        .register(Constants.Material.Sculk.id,
                                                                        () -> new SculkBlock());

        // ---------------------------------------------------------------------------------------//

        public static void registerLists() {

                // List.of(...).forEach(p -> ??);

        }

}
