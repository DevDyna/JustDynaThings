package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.builders.black_hole.BlackHoleBE;
import com.devdyna.justdynathings.registry.builders.budding.types.amethyst.AmethystBE;
import com.devdyna.justdynathings.registry.builders.budding.types.time.TimeBE;
import com.devdyna.justdynathings.registry.builders.ferricore_clock.ClockBE;
import com.devdyna.justdynathings.registry.builders.functional_anvils.energy.PoweredAnvilBE;
import com.devdyna.justdynathings.registry.builders.functional_anvils.magmatic.MagmaAnvilBE;
import com.devdyna.justdynathings.registry.builders.functional_anvils.metallic.MetallicAnvilBE;
import com.devdyna.justdynathings.registry.builders.functional_anvils.time.TimeAnvilBE;
import com.devdyna.justdynathings.registry.builders.goo.creative.CreativeGooBE;
import com.devdyna.justdynathings.registry.builders.goo.energy.diregoo.*;
import com.devdyna.justdynathings.registry.builders.goo.energy.energized.EnergyGooBE;
import com.devdyna.justdynathings.registry.builders.reforger.ReforgerBE;
import com.devdyna.justdynathings.registry.builders.revitalizer.RevitalizerBE;
import com.devdyna.justdynathings.registry.builders.solar.blazegold.BlazeGoldSolarBE;
import com.devdyna.justdynathings.registry.builders.solar.celestigem.CelestiGemSolarBE;
import com.devdyna.justdynathings.registry.builders.solar.eclipsealloy.EclipseAlloySolarBE;
import com.devdyna.justdynathings.registry.builders.solar.ferricore.FerricoreSolarBE;
import com.devdyna.justdynathings.registry.builders.thermo.ThermoBE;

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

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BUDDING_TIME = zBE
                        .register(Constants.Budding.Time, () -> Builder.of(TimeBE::new,
                                        zBlocks.BUDDING_TIME.get())
                                        .build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> BUDDING_AMETHYST = zBE
                        .register(Constants.Budding.Amethyst, () -> Builder.of(AmethystBE::new,
                                        zBlocks.BUDDING_AMETHYST.get())
                                        .build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ClockBE>> FERRICORE_CLOCK = zBE
                        .register(Constants.Blocks.FerricoreClock,
                                        () -> Builder.of(ClockBE::new, zBlocks.FERRICORE_CLOCK.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<RevitalizerBE>> REVITALIZER = zBE
                        .register(Constants.Blocks.Revitalizer,
                                        () -> Builder.of(RevitalizerBE::new, zBlocks.REVITALIZER.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ThermoBE>> THERMOGEN = zBE
                        .register(Constants.Blocks.ThermoGen,
                                        () -> Builder.of(ThermoBE::new, zBlocks.THERMOGEN.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlackHoleBE>> BLACKHOLE = zBE
                        .register(Constants.Blocks.BlackHole,
                                        () -> Builder.of(BlackHoleBE::new, zBlocks.BLACKHOLE.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FerricoreSolarBE>> FERRICORE_SOLARGEN = zBE
                        .register(Constants.TieredStuff.SolarPanel.t1,
                                        () -> Builder.of(FerricoreSolarBE::new, zBlocks.FERRICORE_SOLARGEN.get())
                                                        .build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlazeGoldSolarBE>> BLAZEGOLD_SOLARGEN = zBE
                        .register(Constants.TieredStuff.SolarPanel.t2,
                                        () -> Builder.of(BlazeGoldSolarBE::new, zBlocks.BLAZEGOLD_SOLARGEN.get())
                                                        .build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CelestiGemSolarBE>> CELESTIGEM_SOLARGEN = zBE
                        .register(Constants.TieredStuff.SolarPanel.t3,
                                        () -> Builder.of(CelestiGemSolarBE::new, zBlocks.CELESTIGEM_SOLARGEN.get())
                                                        .build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EclipseAlloySolarBE>> ECLIPSEALLOY_SOLARGEN = zBE
                        .register(Constants.TieredStuff.SolarPanel.t4,
                                        () -> Builder.of(EclipseAlloySolarBE::new, zBlocks.ECLIPSEALLOY_SOLARGEN.get())
                                                        .build(null));

        // TODO rename to match id
        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MetallicAnvilBE>> METALLIC_ANVIL = zBE
                        .register(Constants.TieredStuff.Anvils.t1,
                                        () -> Builder.of(MetallicAnvilBE::new, zBlocks.METALLIC_ANVIL.get())
                                                        .build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MagmaAnvilBE>> MAGMATIC_ANVIL = zBE
                        .register(Constants.TieredStuff.Anvils.t2,
                                        () -> Builder.of(MagmaAnvilBE::new, zBlocks.MAGMATIC_ANVIL.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PoweredAnvilBE>> POWERED_ANVIL = zBE
                        .register(Constants.TieredStuff.Anvils.t3,
                                        () -> Builder.of(PoweredAnvilBE::new, zBlocks.POWERED_ANVIL.get()).build(null));

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TimeAnvilBE>> TIME_ANVIL = zBE
                        .register(Constants.TieredStuff.Anvils.t4,
                                        () -> Builder.of(TimeAnvilBE::new, zBlocks.TIME_ANVIL.get()).build(null));

}
