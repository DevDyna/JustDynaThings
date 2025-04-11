package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.builders.blazing_anvil.BlazingAnvilBE;
import com.devdyna.justdynathings.registry.builders.budding.types.amethyst.AmethystBE;
import com.devdyna.justdynathings.registry.builders.budding.types.time.TimeBE;
import com.devdyna.justdynathings.registry.builders.ferritecore_clock.ClockBE;
import com.devdyna.justdynathings.registry.builders.goo.creative.CreativeGooBE;
import com.devdyna.justdynathings.registry.builders.goo.energy.EnergyGooBE;
import com.devdyna.justdynathings.registry.builders.reforger.ReforgerBE;
import com.devdyna.justdynathings.registry.builders.revitalizer.RevitalizerBE;
import com.devdyna.justdynathings.registry.builders.sculk.SculkBE;
import com.devdyna.justdynathings.registry.builders.ticker.TickerBE;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("null")
public class BlockEntities {
        public static void register(IEventBus bus) {
                zBE.register(bus);
        }
        // ---------------------------------------------------------------------------------------//

        public static final DeferredRegister<BlockEntityType<?>> zBE = DeferredRegister
                        .create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Main.ID);
        // ---------------------------------------------------------------------------------------//

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyGooBE>> ENERGIZED_GOO = zBE
                        .register(Constants.Goo.Energized ,
                                        () -> Builder.of(EnergyGooBE::new, Blocks.ENERGIZED_GOO.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CreativeGooBE>> CREATIVE_GOO = zBE
                        .register(Constants.Goo.Creative ,
                                        () -> Builder.of(CreativeGooBE::new, Blocks.CREATIVE_GOO.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ReforgerBE>> REFORGER = zBE
                        .register(Constants.Blocks.Reforger ,
                                        () -> Builder.of(ReforgerBE::new, Blocks.REFORGER.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BUDDING_TIME = zBE
                        .register(Constants.Budding.Time, () -> Builder.of(TimeBE::new,
                                        Blocks.BUDDING_TIME.get())
                                        .build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BUDDING_AMETHYST = zBE
                        .register(Constants.Budding.Amethyst, () -> Builder.of(AmethystBE::new,
                                        Blocks.BUDDING_AMETHYST.get())
                                        .build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlazingAnvilBE>> BLAZING_ANVIL = zBE
                        .register(Constants.Blocks.BlazingAnvil ,
                                        () -> Builder.of(BlazingAnvilBE::new, Blocks.BLAZING_ANVIL.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ClockBE>> FERRITECORE_CLOCK = zBE
                        .register(Constants.Blocks.FerritecoreClock ,
                                        () -> Builder.of(ClockBE::new, Blocks.FERRITECORE_CLOCK.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RevitalizerBE>> REVITALIZER = zBE
                        .register(Constants.Blocks.Revitalizer ,
                                        () -> Builder.of(RevitalizerBE::new, Blocks.REVITALIZER.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TickerBE>> TICKER = zBE
                        .register(Constants.Blocks.Ticker ,
                                        () -> Builder.of(TickerBE::new, Blocks.TICKER.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SculkBE>> SCULK = zBE
                        .register(Constants.Blocks.Sculk ,
                                        () -> Builder.of(SculkBE::new, Blocks.SCULK.get()).build(null));

}
