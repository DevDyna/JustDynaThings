package com.devdyna.justdynathings.registry.types;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.Material;
import com.devdyna.justdynathings.registry.builders.black_hole.BlackHoleBE;
import com.devdyna.justdynathings.registry.builders.budding.types.amethyst.AmethystBE;
import com.devdyna.justdynathings.registry.builders.budding.types.time.TimeBE;
import com.devdyna.justdynathings.registry.builders.ferricore_clock.ClockBE;
import com.devdyna.justdynathings.registry.builders.fluid_tank.FluidTankBE;
import com.devdyna.justdynathings.registry.builders.functional_anvils.blazegold.BlazeGoldAnvilBE;
import com.devdyna.justdynathings.registry.builders.functional_anvils.celestigem.CelestiGemAnvilBE;
import com.devdyna.justdynathings.registry.builders.functional_anvils.eclipsealloy.EclipseAlloyAnvilBE;
import com.devdyna.justdynathings.registry.builders.functional_anvils.ferricore.FerricoreAnvilBE;
import com.devdyna.justdynathings.registry.builders.goo.creative.CreativeGooBE;
import com.devdyna.justdynathings.registry.builders.goo.energy.diregoo.*;
import com.devdyna.justdynathings.registry.builders.goo.energy.energized.EnergyGooBE;
import com.devdyna.justdynathings.registry.builders.reforger.ReforgerBE;
import com.devdyna.justdynathings.registry.builders.solar.blazegold.BlazeGoldSolarBE;
import com.devdyna.justdynathings.registry.builders.solar.celestigem.CelestiGemSolarBE;
import com.devdyna.justdynathings.registry.builders.solar.eclipsealloy.EclipseAlloySolarBE;
import com.devdyna.justdynathings.registry.builders.solar.ferricore.FerricoreSolarBE;
import com.devdyna.justdynathings.registry.builders.stabilizer.StabilizerBE;
import com.devdyna.justdynathings.registry.builders.thermo.ThermoBE;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("unchecked")
public class zBlockEntities {
        public static void register(IEventBus bus) {
                zBE.register(bus);
        }
        // ---------------------------------------------------------------------------------------//

        public static final DeferredRegister<BlockEntityType<?>> zBE = DeferredRegister
                        .create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Main.ID);
        // ---------------------------------------------------------------------------------------//

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyGooBE>> ENERGIZED_GOO = Material
                        .createBlockEntity(Constants.Goo.Energized, EnergyGooBE::new, zBlocks.ENERGIZED_GOO);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CreativeGooBE>> CREATIVE_GOO = Material
                        .createBlockEntity(Constants.Goo.Creative,
                                        CreativeGooBE::new, zBlocks.CREATIVE_GOO);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyT1BE>> T1_GOO = Material
                        .createBlockEntity(Constants.Goo.T1,
                                        EnergyT1BE::new, zBlocks.T1_GOO);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyT2BE>> T2_GOO = Material
                        .createBlockEntity(Constants.Goo.T2,
                                        EnergyT2BE::new, zBlocks.T2_GOO);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyT3BE>> T3_GOO = Material
                        .createBlockEntity(Constants.Goo.T3,
                                        EnergyT3BE::new, zBlocks.T3_GOO);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyT4BE>> T4_GOO = Material
                        .createBlockEntity(Constants.Goo.T4,
                                        EnergyT4BE::new, zBlocks.T4_GOO);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ReforgerBE>> REFORGER = Material
                        .createBlockEntity(Constants.Blocks.Reforger,
                                        ReforgerBE::new, zBlocks.REFORGER);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TimeBE>> ECHOING_BUDDING_TIME = Material
                        .createBlockEntity(Constants.Budding.Time, TimeBE::new,
                                        zBlocks.ECHOING_BUDDING_TIME);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AmethystBE>> ECHOING_BUDDING_AMETHYST = Material
                        .createBlockEntity(Constants.Budding.Amethyst, AmethystBE::new,
                                        zBlocks.ECHOING_BUDDING_AMETHYST);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ClockBE>> FERRICORE_CLOCK = Material
                        .createBlockEntity(Constants.Blocks.FerricoreClock,
                                        ClockBE::new, zBlocks.FERRICORE_CLOCK);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StabilizerBE>> REVITALIZER = Material
                        .createBlockEntity(Constants.Blocks.Stabilizer,
                                        StabilizerBE::new, zBlocks.STABILIZER);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ThermoBE>> THERMOGEN = Material
                        .createBlockEntity(Constants.Blocks.ThermoGen,
                                        ThermoBE::new, zBlocks.THERMOGEN);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlackHoleBE>> BLACKHOLE = Material
                        .createBlockEntity(Constants.Blocks.BlackHole,
                                        BlackHoleBE::new, zBlocks.BLACKHOLE);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FerricoreSolarBE>> FERRICORE_SOLARGEN = Material
                        .createBlockEntity(Constants.SolarPanel.t1,
                                        FerricoreSolarBE::new, zBlocks.FERRICORE_SOLARGEN);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlazeGoldSolarBE>> BLAZEGOLD_SOLARGEN = Material
                        .createBlockEntity(Constants.SolarPanel.t2,
                                        BlazeGoldSolarBE::new, zBlocks.BLAZEGOLD_SOLARGEN);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CelestiGemSolarBE>> CELESTIGEM_SOLARGEN = Material
                        .createBlockEntity(Constants.SolarPanel.t3,
                                        CelestiGemSolarBE::new, zBlocks.CELESTIGEM_SOLARGEN);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EclipseAlloySolarBE>> ECLIPSEALLOY_SOLARGEN = Material
                        .createBlockEntity(Constants.SolarPanel.t4,
                                        EclipseAlloySolarBE::new, zBlocks.ECLIPSEALLOY_SOLARGEN);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FerricoreAnvilBE>> FERRICORE_ANVIL = Material
                        .createBlockEntity(Constants.Anvils.t1,
                                        FerricoreAnvilBE::new, zBlocks.FERRICORE_ANVIL);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlazeGoldAnvilBE>> BLAZEGOLD_ANVIL = Material
                        .createBlockEntity(Constants.Anvils.t2,
                                        BlazeGoldAnvilBE::new, zBlocks.BLAZEGOLD_ANVIL);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CelestiGemAnvilBE>> CELESTIGEM_ANVIL = Material
                        .createBlockEntity(Constants.Anvils.t3,
                                        CelestiGemAnvilBE::new, zBlocks.CELESTIGEM_ANVIL);

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EclipseAlloyAnvilBE>> ECLIPSEALLOY_ANVIL = Material
                        .createBlockEntity(Constants.Anvils.t4,
                                        EclipseAlloyAnvilBE::new, zBlocks.ECLIPSEALLOY_ANVIL);
      
      
                                        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FluidTankBE>> FLUID_TANK = Material
                        .createBlockEntity(Constants.Blocks.FluidTank,
                                        FluidTankBE::new, zBlocks.FLUID_TANK);

}
