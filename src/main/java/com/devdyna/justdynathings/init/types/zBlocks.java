package com.devdyna.justdynathings.init.types;


import java.util.function.Function;


import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.JustDynaThings;
import com.devdyna.justdynathings.init.builder.PhaseBox;
import com.devdyna.justdynathings.init.builder.black_hole.BlackHoleBlock;
import com.devdyna.justdynathings.init.builder.ferricore_clock.FerricoreClockBlock;
import com.devdyna.justdynathings.init.builder.fluid_mixer.SimpleFluidMixerBlock;
import com.devdyna.justdynathings.init.builder.goo.creative.CreativeGoo;
import com.devdyna.justdynathings.init.builder.goo.energy.diregoo.*;
import com.devdyna.justdynathings.init.builder.light_wands.LightWandBlock;
import com.devdyna.justdynathings.init.builder.repair_anvils.blazegold.BlazeGoldAnvilBlock;
import com.devdyna.justdynathings.init.builder.repair_anvils.celestigem.CelestiGemAnvilBlock;
import com.devdyna.justdynathings.init.builder.repair_anvils.eclipsealloy.EclipseAlloyAnvilBlock;
import com.devdyna.justdynathings.init.builder.repair_anvils.ferricore.FerricoreAnvilBlock;
import com.devdyna.justdynathings.init.builder.solar_panels.blazegold.BlazeGoldSolarBlock;
import com.devdyna.justdynathings.init.builder.solar_panels.celestigem.CelestiGemSolarBlock;
import com.devdyna.justdynathings.init.builder.solar_panels.eclipsealloy.EclipseAlloySolarBlock;
import com.devdyna.justdynathings.init.builder.solar_panels.ferricore.FerricoreSolarBlock;
import com.devdyna.justdynathings.init.builder.stabilizer.StabilizerBlock;
import com.devdyna.justdynathings.init.builder.ticker.TickerBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zBlocks {

    public static void register(IEventBus bus) {
        zBlock.register(bus);
        zBlockItem.register(bus);
        zHidden.register(bus);
    }

    public static final DeferredRegister.Blocks zBlock = DeferredRegister.createBlocks(JustDynaThings.MODULE_ID);
    public static final DeferredRegister.Blocks zBlockItem = DeferredRegister.createBlocks(JustDynaThings.MODULE_ID);
    public static final DeferredRegister.Blocks zHidden = DeferredRegister.createBlocks(JustDynaThings.MODULE_ID);

 

        // ---------------------------------------------------------------------------------------//
       
      

        public static final DeferredHolder<Block, ?> CREATIVE_GOO = 
                        registerItemBlock(Constants.Goo.Creative, CreativeGoo::new);

        public static final DeferredHolder<Block, ?> T1_GOO = 
                        registerItemBlock(Constants.Goo.T1, EnergyT1::new);
        public static final DeferredHolder<Block, ?> T2_GOO = 
                        registerItemBlock(Constants.Goo.T2, EnergyT2::new);
        public static final DeferredHolder<Block, ?> T3_GOO = 
                        registerItemBlock(Constants.Goo.T3, EnergyT3::new);
        public static final DeferredHolder<Block, ?> T4_GOO = 
                        registerItemBlock(Constants.Goo.T4, EnergyT4::new);

        public static final DeferredHolder<Block, ?> PHASEBOX = 
                        registerItemBlock(Constants.Blocks.PhaseBox, PhaseBox::new);

        // public static final DeferredHolder<Block, ?> REFORGER = Material
        //                 registerItemBlock(Constants.Blocks.Reforger, ReforgerBlock::new);

        public static final DeferredHolder<Block, ?> TICKER = 
                        registerItemBlock(Constants.Blocks.Ticker, TickerBlock::new);

                        //TODO buddings
        // public static final DeferredHolder<Block, ?> ECHOING_BUDDING_TIME = Material.DireStuff
        //                 .registerBudding(Constants.BuddingType+"_time", () -> new TimeBlock());

        // public static final DeferredHolder<Block, ?> ECHOING_BUDDING_AMETHYST = Material.DireStuff

        //                 .registerBudding(Constants.BuddingType+"_amethyst", () -> new AmethystBlock());

        public static final DeferredHolder<Block, ?> FERRICORE_CLOCK = 
                        registerItemBlock(Constants.Blocks.FerricoreClock, FerricoreClockBlock::new);

        public static final DeferredHolder<Block, ?> STABILIZER = 
                        registerItemBlock(Constants.Blocks.Stabilizer, StabilizerBlock::new);

        // public static final DeferredHolder<Block, ?> THERMOGEN = 
        //                 registerItemBlock(Constants.Blocks.ThermoGen, ThermoBlock::new);

        public static final DeferredHolder<Block, ?> BLACKHOLE = 
                        registerItemBlock(Constants.Blocks.BlackHole, BlackHoleBlock::new);

        public static final DeferredHolder<Block, ?> FERRICORE_SOLARGEN = 
                        registerItemBlock(Constants.SolarPanel.t1, FerricoreSolarBlock::new);

        public static final DeferredHolder<Block, ?> BLAZEGOLD_SOLARGEN = 
                        registerItemBlock(Constants.SolarPanel.t2, BlazeGoldSolarBlock::new);

        public static final DeferredHolder<Block, ?> CELESTIGEM_SOLARGEN = 
                        registerItemBlock(Constants.SolarPanel.t3, CelestiGemSolarBlock::new);

        public static final DeferredHolder<Block, ?> ECLIPSEALLOY_SOLARGEN = 
                        registerItemBlock(Constants.SolarPanel.t4, EclipseAlloySolarBlock::new);

        public static final DeferredHolder<Block, ?> FERRICORE_ANVIL = 
                        registerItemBlock(Constants.Anvils.t1, FerricoreAnvilBlock::new);

        public static final DeferredHolder<Block, ?> BLAZEGOLD_ANVIL = 
                        registerItemBlock(Constants.Anvils.t2, BlazeGoldAnvilBlock::new);

        public static final DeferredHolder<Block, ?> CELESTIGEM_ANVIL = 
                    registerItemBlock(Constants.Anvils.t3, CelestiGemAnvilBlock::new);

        public static final DeferredHolder<Block, ?> ECLIPSEALLOY_ANVIL = 
                        registerItemBlock(Constants.Anvils.t4, EclipseAlloyAnvilBlock::new);

        public static final DeferredHolder<Block, ?> SIMPLE_FLUID_MIXER = 
                        registerItemBlock(Constants.Blocks.simple_fluid_mixer,  SimpleFluidMixerBlock::new);

        public static final DeferredHolder<Block, ?> LIGHT_WAND_BLOCK = zHidden
                        .registerBlock(Constants.Wands.Light + "_block", LightWandBlock::new);

        // ---------------------------------------------------------------------------------------//

      

 

    public static DeferredHolder<Block, Block> registerItemBlock(String blockname,
            Function<BlockBehaviour.Properties, ? extends Block> sup) {
        DeferredHolder<Block, Block> block = zBlockItem.registerBlock(blockname, sup);
        zItems.zBlockItem.registerSimpleBlockItem(block);
        return block;
    }

}
