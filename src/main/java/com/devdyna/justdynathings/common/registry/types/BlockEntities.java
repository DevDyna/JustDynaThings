package com.devdyna.justdynathings.common.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.common.registry.Material;
import com.devdyna.justdynathings.common.registry.core.builders.budding.BuddingBE;
import com.devdyna.justdynathings.common.registry.core.builders.clock.ClockBE;
import com.devdyna.justdynathings.common.registry.core.builders.goo.GooBE;
import com.devdyna.justdynathings.common.registry.core.builders.goo.custom.creative.CreativeGooBE;
import com.devdyna.justdynathings.common.registry.core.builders.goo.custom.energy.EnergyGooBE;
import com.devdyna.justdynathings.common.registry.core.builders.reforger.ReforgerBE;
import com.devdyna.justdynathings.common.registry.core.builders.repairer.BlazingAnvilBE;
import com.devdyna.justdynathings.common.registry.core.builders.revitalizer.RevitalizerBE;
import com.devdyna.justdynathings.common.registry.core.builders.sculk.SculkBE;
import com.devdyna.justdynathings.common.registry.core.builders.ticker.TickerBE;
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
    

public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GooBE>> GOO_BE = zBE.register(
                        Constants.Material.Goo.ID.id + "_" + Constants.BlockEntity.id,
                        () -> Builder.of(GooBE::new, Blocks.GooT5_BLOCK.get(), Blocks.GooT0_BLOCK.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyGooBE>> ENERGY_GOO_BE = zBE
                        .register(Constants.Material.Goo.Energized.id + "_" + Constants.BlockEntity.id,
                                        () -> Builder.of(EnergyGooBE::new, Blocks.GooT6_ENERGY_BLOCK.get(), Blocks.T0_ENERGY.get(),
                                        Blocks.T1_ENERGY.get(), Blocks.T2_ENERGY.get(), Blocks.T3_ENERGY.get(),
                                                        Blocks.T4_ENERGY.get(), Blocks.T5_ENERGY.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CreativeGooBE>> CREATIVE_GOO_BE = zBE
                        .register(Constants.Material.Goo.Creative.id + "_" + Constants.BlockEntity.id,
                                        () -> Builder.of(CreativeGooBE::new, Blocks.GooT5_CREATIVE_BLOCK.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ReforgerBE>> REFORGER_BE = zBE
                        .register(Constants.Material.Reforger.id + "_" + Constants.BlockEntity.id,
                                        () -> Builder.of(ReforgerBE::new, Blocks.REFORGER_BLOCK.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BuddingBE>> POWERED_BUDDING_BE = zBE
                        .register(
                                        Constants.Material.Budding.Powered.id + "_" + Constants.BlockEntity.id,
                                        () -> Builder.of(BuddingBE::new, Material.getBuddingAvailable())
                                                        .build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlazingAnvilBE>> BLAZINGANVIL_BE = zBE
                        .register(Constants.Material.BlazingAnvil.id + "_" + Constants.BlockEntity.id,
                                        () -> Builder.of(BlazingAnvilBE::new, Blocks.BLAZINGANVIL_BLOCK.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ClockBE>> CLOCK_BE = zBE
                        .register(Constants.Material.Clock.id + "_" + Constants.BlockEntity.id,
                                        () -> Builder.of(ClockBE::new, Blocks.CLOCK_BLOCK.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RevitalizerBE>> REVITALIZER_BE = zBE
                        .register(Constants.Material.Revitalizer.id + "_" + Constants.BlockEntity.id,
                                        () -> Builder.of(RevitalizerBE::new, Blocks.REVITALIZER_BLOCK.get()).build(null));

        
        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TickerBE>> TICKER_BE = zBE
                        .register(Constants.Material.Ticker.id + "_" + Constants.BlockEntity.id,
                                        () -> Builder.of(TickerBE::new, Blocks.TICKER_BLOCK.get()).build(null));

                                        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SculkBE>> SCULK_BE = zBE
                                        .register(Constants.Material.Sculk.id + "_" + Constants.BlockEntity.id,
                                                        () -> Builder.of(SculkBE::new, Blocks.SCULK_BLOCK.get()).build(null));

        

}
