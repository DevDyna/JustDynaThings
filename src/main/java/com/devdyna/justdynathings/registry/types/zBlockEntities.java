package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.builders.black_hole.BlackHoleBE;
import com.devdyna.justdynathings.registry.builders.blazing_anvil.BlazingAnvilBE;
import com.devdyna.justdynathings.registry.builders.ferritecore_clock.ClockBE;
import com.devdyna.justdynathings.registry.builders.generators.solar.SolarBE;
import com.devdyna.justdynathings.registry.builders.generators.thermo.ThermoBE;
import com.devdyna.justdynathings.registry.builders.goo.creative.CreativeGooBE;
import com.devdyna.justdynathings.registry.builders.goo.energy.diregoo.*;
import com.devdyna.justdynathings.registry.builders.goo.energy.energized.EnergyGooBE;
import com.devdyna.justdynathings.registry.builders.reforger.ReforgerBE;
import com.devdyna.justdynathings.registry.builders.revitalizer.RevitalizerBE;
import com.devdyna.justdynathings.registry.builders.ticker.TickerBE;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("null")
public class zBlockEntities {
        public static void register(IEventBus bus) {
                zBE.register(bus);
        }
        // ---------------------------------------------------------------------------------------//

        public static final DeferredRegister<BlockEntityType<?>> zBE = DeferredRegister
                        .create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Main.ID);
        // ---------------------------------------------------------------------------------------//

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyGooBE>> ENERGIZED_GOO = zBE
                        .register(Constants.Goo.Energized,
                                        () -> Builder.of(EnergyGooBE::new, zBlocks.ENERGIZED_GOO.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CreativeGooBE>> CREATIVE_GOO = zBE
                        .register(Constants.Goo.Creative,
                                        () -> Builder.of(CreativeGooBE::new, zBlocks.CREATIVE_GOO.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyT1BE>> T1_GOO = zBE
                        .register(Constants.Goo.T1,
                                        () -> Builder.of(EnergyT1BE::new, zBlocks.T1_GOO.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyT2BE>> T2_GOO = zBE
                        .register(Constants.Goo.T2,
                                        () -> Builder.of(EnergyT2BE::new, zBlocks.T2_GOO.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyT3BE>> T3_GOO = zBE
                        .register(Constants.Goo.T3,
                                        () -> Builder.of(EnergyT3BE::new, zBlocks.T3_GOO.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyT4BE>> T4_GOO = zBE
                        .register(Constants.Goo.T4,
                                        () -> Builder.of(EnergyT4BE::new, zBlocks.T4_GOO.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> REFORGER = zBE
                        .register(Constants.Blocks.Reforger,
                                        () -> Builder.of(ReforgerBE::new, zBlocks.REFORGER.get()).build(null));

        // public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BUDDING_TIME = zBE
        //                 .register(Constants.Budding.Time, () -> Builder.of(TimeBE::new,
        //                                 zBlocks.BUDDING_TIME.get())
        //                                 .build(null));

        // public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BUDDING_AMETHYST = zBE
        //                 .register(Constants.Budding.Amethyst, () -> Builder.of(AmethystBE::new,
        //                                 zBlocks.BUDDING_AMETHYST.get())
        //                                 .build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlazingAnvilBE>> BLAZING_ANVIL = zBE
                        .register(Constants.Blocks.BlazingAnvil,
                                        () -> Builder.of(BlazingAnvilBE::new, zBlocks.BLAZING_ANVIL.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ClockBE>> FERRITECORE_CLOCK = zBE
                        .register(Constants.Blocks.FerritecoreClock,
                                        () -> Builder.of(ClockBE::new, zBlocks.FERRITECORE_CLOCK.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RevitalizerBE>> REVITALIZER = zBE
                        .register(Constants.Blocks.Revitalizer,
                                        () -> Builder.of(RevitalizerBE::new, zBlocks.REVITALIZER.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TickerBE>> TICKER = zBE
                        .register(Constants.Blocks.Ticker,
                                        () -> Builder.of(TickerBE::new, zBlocks.TICKER.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ThermoBE>> THERMOGEN = zBE
                        .register(Constants.Blocks.ThermoGen,
                                        () -> Builder.of(ThermoBE::new, zBlocks.THERMOGEN.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlackHoleBE>> BLACKHOLE = zBE
                        .register(Constants.Blocks.BlackHole,
                                        () -> Builder.of(BlackHoleBE::new, zBlocks.BLACKHOLE.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SolarBE>> SOLARGEN = zBE
                        .register(Constants.Blocks.SolarGen,
                                        () -> Builder.of(SolarBE::new, zBlocks.SOLARGEN.get()).build(null));

        // public static final DeferredHolder<BlockEntityType<?>,
        // BlockEntityType<SculkBE>> SCULK = zBE
        // .register(Constants.Blocks.Sculk,
        // () -> Builder.of(SculkBE::new, Blocks.SCULK.get()).build(null));

}
