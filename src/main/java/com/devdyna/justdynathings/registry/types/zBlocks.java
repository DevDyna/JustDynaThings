package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.Material;
import com.devdyna.justdynathings.registry.builders.PhaseBox;
import com.devdyna.justdynathings.registry.builders.blazing_anvil.BlazingAnvilBlock;
import com.devdyna.justdynathings.registry.builders.budding.types.amethyst.AmethystBlock;
import com.devdyna.justdynathings.registry.builders.budding.types.time.TimeBlock;
import com.devdyna.justdynathings.registry.builders.ferritecore_clock.ClockBlock;
import com.devdyna.justdynathings.registry.builders.generators.thermo.ThermoBlock;
import com.devdyna.justdynathings.registry.builders.goo.creative.CreativeGoo;
import com.devdyna.justdynathings.registry.builders.goo.energy.diregoo.*;
import com.devdyna.justdynathings.registry.builders.goo.energy.energized.EnergyGoo;
import com.devdyna.justdynathings.registry.builders.reforger.ReforgerBlock;
import com.devdyna.justdynathings.registry.builders.revitalizer.RevitalizerBlock;
import com.devdyna.justdynathings.registry.builders.ticker.TickerBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.minecraft.world.level.block.Blocks.*;

public class zBlocks {
        public static void register(IEventBus bus) {
                registerLists();
                zBlock.register(bus);
                zOres.register(bus);
                zBlockItem.register(bus);
                zGoo.register(bus);
                zBuddings.register(bus);
                zBlockFluids.register(bus);
        }

        // ---------------------------------------------------------------------------------------//
        public static final DeferredRegister.Blocks zBlock = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Blocks zOres = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Blocks zBlockItem = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Blocks zGoo = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Blocks zBuddings = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Blocks zBlockFluids = DeferredRegister.createBlocks(Main.ID);
        // ---------------------------------------------------------------------------------------//

        public static final DeferredHolder<Block, ?> ENERGIZED_GOO = Material.DireStuff
                        .simpleGoo(Constants.Goo.Energized, () -> new EnergyGoo());

        public static final DeferredHolder<Block, ?> CREATIVE_GOO = Material.DireStuff
                        .simpleGoo(Constants.Goo.Creative, () -> new CreativeGoo());

        public static final DeferredHolder<Block, ?> T1_GOO = Material.DireStuff
                        .simpleGoo(Constants.Goo.T1, () -> new EnergyT1());
        public static final DeferredHolder<Block, ?> T2_GOO = Material.DireStuff
                        .simpleGoo(Constants.Goo.T2, () -> new EnergyT2());
        public static final DeferredHolder<Block, ?> T3_GOO = Material.DireStuff
                        .simpleGoo(Constants.Goo.T3, () -> new EnergyT3());
        public static final DeferredHolder<Block, ?> T4_GOO = Material.DireStuff
                        .simpleGoo(Constants.Goo.T4, () -> new EnergyT4());

        public static final DeferredHolder<Block, ?> PHASEBOX = Material
                        .registerItemAndBlock(Constants.Blocks.PhaseBox, PhaseBox::new);

        public static final DeferredHolder<Block, ?> RAW_CHAOTIC = Material.DireStuff
                        .simpleRawOreDW(Constants.Ores.Chaotic.ore);

        public static final DeferredHolder<Block, ?> RAW_REDSTONIC = Material.DireStuff
                        .simpleRawOreDW(Constants.Ores.Redstonic.ore);

        public static final DeferredHolder<Block, ?> RAW_COPRINIUM = Material.DireStuff
                        .simpleRawOreDW(Constants.Ores.Coprinium.ore);

        public static final DeferredHolder<Block, ?> REFORGER = Material
                        .registerItemAndBlock(Constants.Blocks.Reforger, ReforgerBlock::new);

        public static final DeferredHolder<Block, ?> BUDDING_TIME = Material.DireStuff
                        .registerBudding(Constants.Budding.Time, () -> new TimeBlock());

        public static final DeferredHolder<Block, ?> BUDDING_AMETHYST = Material.DireStuff
                        .registerBudding(Constants.Budding.Amethyst, () -> new AmethystBlock());

        public static final DeferredHolder<Block, ?> BLAZING_ANVIL = Material
                        .registerItemAndBlock(Constants.Blocks.BlazingAnvil, BlazingAnvilBlock::new);

        public static final DeferredHolder<Block, ?> FERRITECORE_CLOCK = Material
                        .registerItemAndBlock(Constants.Blocks.FerritecoreClock, ClockBlock::new);

        public static final DeferredHolder<Block, ?> REVITALIZER = Material
                        .registerItemAndBlock(Constants.Blocks.Revitalizer, RevitalizerBlock::new);

        public static final DeferredHolder<Block, ?> TICKER = Material
                        .registerItemAndBlock(Constants.Blocks.Ticker, TickerBlock::new);

                        public static final DeferredHolder<Block, ?> THERMOGEN = Material
                        .registerItemAndBlock(Constants.Blocks.Thermo, ThermoBlock::new);

        // public static final DeferredHolder<Block, ?> SCULK = Material
        //                 .registerItemAndBlock(Constants.Blocks.Sculk, SculkBlock::new);

        public static final DeferredHolder<Block, LiquidBlock> CRYSTALLINE_FLUID = zBlockFluids.register(
                        Constants.Fluids.Crystalline.Block,
                        () -> new LiquidBlock(zFluids.CRYSTALLINE_FLOWING.value(), Properties.ofFullCopy(WATER)
                                        .liquid()
                                        .lightLevel(value -> 10)
                                        .emissiveRendering((a, b, c) -> true)));

        // ---------------------------------------------------------------------------------------//

        public static void registerLists() {

                // List.of(...).forEach(p -> ??);
        }

}
