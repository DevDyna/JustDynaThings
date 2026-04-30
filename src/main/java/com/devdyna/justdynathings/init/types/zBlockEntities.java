package com.devdyna.justdynathings.init.types;

import com.devdyna.cakesticklib.api.RegistryUtils;
import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.JustDynaThings;
import com.devdyna.justdynathings.init.builder.black_hole.BlackHoleBE;
import com.devdyna.justdynathings.init.builder.ferricore_clock.FerricoreClockBE;
import com.devdyna.justdynathings.init.builder.fluid_mixer.SimpleFluidMixerBE;
import com.devdyna.justdynathings.init.builder.goo.creative.CreativeGooBE;
import com.devdyna.justdynathings.init.builder.goo.energy.diregoo.*;
import com.devdyna.justdynathings.init.builder.repair_anvils.blazegold.BlazeGoldAnvilBE;
import com.devdyna.justdynathings.init.builder.repair_anvils.celestigem.CelestiGemAnvilBE;
import com.devdyna.justdynathings.init.builder.repair_anvils.eclipsealloy.EclipseAlloyAnvilBE;
import com.devdyna.justdynathings.init.builder.repair_anvils.ferricore.FerricoreAnvilBE;
import com.devdyna.justdynathings.init.builder.solar_panels.blazegold.BlazeGoldSolarBE;
import com.devdyna.justdynathings.init.builder.solar_panels.celestigem.CelestiGemSolarBE;
import com.devdyna.justdynathings.init.builder.solar_panels.eclipsealloy.EclipseAlloySolarBE;
import com.devdyna.justdynathings.init.builder.solar_panels.ferricore.FerricoreSolarBE;
import com.devdyna.justdynathings.init.builder.stabilizer.StabilizerBE;
import com.devdyna.justdynathings.init.builder.ticker.TickerBE;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zBlockEntities {

    public static void register(IEventBus bus) {
        zTiles.register(bus);
    }

    public static final DeferredRegister<BlockEntityType<?>> zTiles = DeferredRegister
            .create(BuiltInRegistries.BLOCK_ENTITY_TYPE, JustDynaThings.MODULE_ID);

    
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CreativeGooBE>> CREATIVE_GOO = RegistryUtils
            .createBlockEntity(Constants.Goo.Creative,zTiles,
                    CreativeGooBE::new, zBlocks.CREATIVE_GOO);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyT1BE>> T1_GOO = RegistryUtils
            .createBlockEntity(Constants.Goo.T1,zTiles,
                    EnergyT1BE::new, zBlocks.T1_GOO);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyT2BE>> T2_GOO = RegistryUtils
            .createBlockEntity(Constants.Goo.T2,zTiles,
                    EnergyT2BE::new, zBlocks.T2_GOO);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyT3BE>> T3_GOO = RegistryUtils
            .createBlockEntity(Constants.Goo.T3,zTiles,
                    EnergyT3BE::new, zBlocks.T3_GOO);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EnergyT4BE>> T4_GOO = RegistryUtils
            .createBlockEntity(Constants.Goo.T4,zTiles,
                    EnergyT4BE::new, zBlocks.T4_GOO);

//     public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ReforgerBE>> REFORGER = RegistryUtils
//             .createBlockEntity(Constants.Blocks.Reforger,zTiles,
//                     ReforgerBE::new, zBlocks.REFORGER);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TickerBE>> TICKER = RegistryUtils
            .createBlockEntity(Constants.Blocks.Ticker,zTiles,
                    TickerBE::new, zBlocks.TICKER);

    // public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TimeBE>> ECHOING_BUDDING_TIME = RegistryUtils
    //         .createBlockEntity(Constants.BuddingType + "_time",zTiles, TimeBE::new,
    //                 zBlocks.ECHOING_BUDDING_TIME);

    // public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AmethystBE>> ECHOING_BUDDING_AMETHYST = RegistryUtils
    //         .createBlockEntity(Constants.BuddingType + "_amethyst",zTiles, AmethystBE::new,
    //                 zBlocks.ECHOING_BUDDING_AMETHYST);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FerricoreClockBE>> FERRICORE_CLOCK = RegistryUtils
            .createBlockEntity(Constants.Blocks.FerricoreClock,zTiles,
                    FerricoreClockBE::new, zBlocks.FERRICORE_CLOCK);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StabilizerBE>> STABILIZER = RegistryUtils
            .createBlockEntity(Constants.Blocks.Stabilizer,zTiles,
                    StabilizerBE::new, zBlocks.STABILIZER);

    // public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ThermoBE>> THERMOGEN = RegistryUtils
    //         .createBlockEntity(Constants.Blocks.ThermoGen,zTiles,
    //                 ThermoBE::new, zBlocks.THERMOGEN);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlackHoleBE>> BLACKHOLE = RegistryUtils
            .createBlockEntity(Constants.Blocks.BlackHole,zTiles,
                    BlackHoleBE::new, zBlocks.BLACKHOLE);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FerricoreSolarBE>> FERRICORE_SOLARGEN = RegistryUtils
            .createBlockEntity(Constants.SolarPanel.t1,zTiles,
                    FerricoreSolarBE::new, zBlocks.FERRICORE_SOLARGEN);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlazeGoldSolarBE>> BLAZEGOLD_SOLARGEN = RegistryUtils
            .createBlockEntity(Constants.SolarPanel.t2,zTiles,
                    BlazeGoldSolarBE::new, zBlocks.BLAZEGOLD_SOLARGEN);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CelestiGemSolarBE>> CELESTIGEM_SOLARGEN = RegistryUtils
            .createBlockEntity(Constants.SolarPanel.t3,zTiles,
                    CelestiGemSolarBE::new, zBlocks.CELESTIGEM_SOLARGEN);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EclipseAlloySolarBE>> ECLIPSEALLOY_SOLARGEN = RegistryUtils
            .createBlockEntity(Constants.SolarPanel.t4,zTiles,
                    EclipseAlloySolarBE::new, zBlocks.ECLIPSEALLOY_SOLARGEN);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FerricoreAnvilBE>> FERRICORE_ANVIL = RegistryUtils
            .createBlockEntity(Constants.Anvils.t1,zTiles,
                    FerricoreAnvilBE::new, zBlocks.FERRICORE_ANVIL);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BlazeGoldAnvilBE>> BLAZEGOLD_ANVIL = RegistryUtils
            .createBlockEntity(Constants.Anvils.t2,zTiles,
                    BlazeGoldAnvilBE::new, zBlocks.BLAZEGOLD_ANVIL);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CelestiGemAnvilBE>> CELESTIGEM_ANVIL = RegistryUtils
            .createBlockEntity(Constants.Anvils.t3,zTiles,
                    CelestiGemAnvilBE::new, zBlocks.CELESTIGEM_ANVIL);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EclipseAlloyAnvilBE>> ECLIPSEALLOY_ANVIL = RegistryUtils
            .createBlockEntity(Constants.Anvils.t4,zTiles,
                    EclipseAlloyAnvilBE::new, zBlocks.ECLIPSEALLOY_ANVIL);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SimpleFluidMixerBE>> SIMPLE_FLUID_MIXER = RegistryUtils
            .createBlockEntity(Constants.Blocks.simple_fluid_mixer,zTiles,
                    SimpleFluidMixerBE::new, zBlocks.SIMPLE_FLUID_MIXER);

}
