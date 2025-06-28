package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.Material;
import com.devdyna.justdynathings.registry.builders.PhaseBox;
import com.devdyna.justdynathings.registry.builders.black_hole.BlackHoleBlock;
import com.devdyna.justdynathings.registry.builders.budding.types.amethyst.AmethystBlock;
import com.devdyna.justdynathings.registry.builders.budding.types.time.TimeBlock;
import com.devdyna.justdynathings.registry.builders.ferricore_clock.ClockBlock;
import com.devdyna.justdynathings.registry.builders.functional_anvils.blazegold.BlazeGoldAnvilBlock;
import com.devdyna.justdynathings.registry.builders.functional_anvils.celestigem.CelestiGemAnvilBlock;
import com.devdyna.justdynathings.registry.builders.functional_anvils.eclipsealloy.EclipseAlloyAnvilBlock;
import com.devdyna.justdynathings.registry.builders.functional_anvils.ferricore.FerricoreAnvilBlock;
import com.devdyna.justdynathings.registry.builders.goo.creative.CreativeGoo;
import com.devdyna.justdynathings.registry.builders.goo.energy.diregoo.*;
import com.devdyna.justdynathings.registry.builders.goo.energy.energized.EnergyGoo;
import com.devdyna.justdynathings.registry.builders.reforger.ReforgerBlock;
import com.devdyna.justdynathings.registry.builders.revitalizer.RevitalizerBlock;
import com.devdyna.justdynathings.registry.builders.solar.blazegold.BlazeGoldSolarBlock;
import com.devdyna.justdynathings.registry.builders.solar.celestigem.CelestiGemSolarBlock;
import com.devdyna.justdynathings.registry.builders.solar.eclipsealloy.EclipseAlloySolarBlock;
import com.devdyna.justdynathings.registry.builders.solar.ferricore.FerricoreSolarBlock;
import com.devdyna.justdynathings.registry.builders.thermo.ThermoBlock;

import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zBlocks {
        public static void register(IEventBus bus) {
                registerLists();
                zBlock.register(bus);
                zOres.register(bus);
                zBlockItem.register(bus);
                zGoo.register(bus);
                zBuddings.register(bus);
                // zBlockFluids.register(bus);
                zCoals.register(bus);
        }

        // ---------------------------------------------------------------------------------------//
        public static final DeferredRegister.Blocks zBlock = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Blocks zOres = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Blocks zBlockItem = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Blocks zGoo = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Blocks zBuddings = DeferredRegister.createBlocks(Main.ID);
        // public static final DeferredRegister.Blocks zBlockFluids =
        // DeferredRegister.createBlocks(Main.ID);
        /**
         * unused (due FuelBlockDW)
         */
        public static final DeferredRegister.Blocks zCoals = DeferredRegister.createBlocks(Main.ID);
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

        public static final DeferredHolder<Block, ?> REFORGER = Material
                        .registerItemAndBlock(Constants.Blocks.Reforger, ReforgerBlock::new);

        public static final DeferredHolder<Block, ?> ECHOING_BUDDING_TIME = Material.DireStuff
                        .registerBudding(Constants.Budding.Time, () -> new TimeBlock());

        public static final DeferredHolder<Block, ?> ECHOING_BUDDING_AMETHYST = Material.DireStuff
                                                                                           
                        .registerBudding(Constants.Budding.Amethyst, () -> new AmethystBlock());

        public static final DeferredHolder<Block, ?> FERRICORE_CLOCK = Material
                        .registerItemAndBlock(Constants.Blocks.FerricoreClock, ClockBlock::new);

        public static final DeferredHolder<Block, ?> REVITALIZER = Material
                        .registerItemAndBlock(Constants.Blocks.Revitalizer, RevitalizerBlock::new);

        public static final DeferredHolder<Block, ?> THERMOGEN = Material
                        .registerItemAndBlock(Constants.Blocks.ThermoGen, ThermoBlock::new);

        public static final DeferredHolder<Block, ?> BLACKHOLE = Material
                        .registerItemAndBlock(Constants.Blocks.BlackHole, BlackHoleBlock::new);

        public static final DeferredHolder<Block, ?> FERRICORE_SOLARGEN = Material
                        .registerItemAndBlock(Constants.SolarPanel.t1, FerricoreSolarBlock::new);

        public static final DeferredHolder<Block, ?> BLAZEGOLD_SOLARGEN = Material
                        .registerItemAndBlock(Constants.SolarPanel.t2, BlazeGoldSolarBlock::new);

        public static final DeferredHolder<Block, ?> CELESTIGEM_SOLARGEN = Material
                        .registerItemAndBlock(Constants.SolarPanel.t3, CelestiGemSolarBlock::new);

        public static final DeferredHolder<Block, ?> ECLIPSEALLOY_SOLARGEN = Material
                        .registerItemAndBlock(Constants.SolarPanel.t4, EclipseAlloySolarBlock::new);

        public static final DeferredHolder<Block, ?> FERRICORE_ANVIL = Material
                        .registerItemAndBlock(Constants.Anvils.t1, FerricoreAnvilBlock::new);

        public static final DeferredHolder<Block, ?> BLAZEGOLD_ANVIL = Material
                        .registerItemAndBlock(Constants.Anvils.t2, BlazeGoldAnvilBlock::new);

        public static final DeferredHolder<Block, ?> CELESTIGEM_ANVIL = Material
                        .registerItemAndBlock(Constants.Anvils.t3, CelestiGemAnvilBlock::new);

        public static final DeferredHolder<Block, ?> ECLIPSEALLOY_ANVIL = Material
                        .registerItemAndBlock(Constants.Anvils.t4, EclipseAlloyAnvilBlock::new);

        // ---------------------------------------------------------------------------------------//

        public static void registerLists() {

                // List.of(...).forEach(p -> ??);
        }

}
