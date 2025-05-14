package com.devdyna.justdynathings.registry.types;

import static net.minecraft.world.item.Items.*;

import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class zProperties {
        // ---------------------------------------------------------------------------------------//

        public static void register(IEventBus bus) {
        }
        // ---------------------------------------------------------------------------------------//

        public static final BlockBehaviour.Properties bProp = BlockBehaviour.Properties.of();
        public static final Properties iProp = new Item.Properties();
        public static final Properties iPropBucket = iProp.craftRemainder(BUCKET).stacksTo(1);

        public final static BaseFlowingFluid.Properties FProp(DeferredHolder<FluidType, ?> type,
                        DeferredHolder<Fluid, ?> source, DeferredHolder<Fluid, FlowingFluid> flowing,
                        DeferredHolder<Item, BucketItem> bucket,
                        DeferredHolder<Block, LiquidBlock> blockfluid) {
                return new BaseFlowingFluid.Properties(type, source, flowing).bucket(bucket).block(blockfluid);
        }

        public static final BlockBehaviour.Properties MachineProp = BlockBehaviour.Properties.of()
                        .requiresCorrectToolForDrops()
                        .strength(2.0f)
                        .sound(SoundType.METAL)
                        .isRedstoneConductor(BaseMachineBlock::never);
        // ---------------------------------------------------------------------------------------//

        public static final BooleanProperty GOO_ALIVE = GooBlock_Base.ALIVE;

        public static final BooleanProperty SOLID = BooleanProperty.create("solid");
        public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
        public static final BooleanProperty COOLED = BooleanProperty.create("thermo_cooled");
        public static final BooleanProperty HEATED = BooleanProperty.create("thermo_heated");
        public static final BooleanProperty GOO_FOUND = BooleanProperty.create("goo_found");

        // public static BaseFlowingFluid.Properties lapis = zProperties.FProp(
        //                 zFluidTypes.LAPIS_LAZULI_JUICE_FLUID_TYPE,
        //                 zFluids.LAPIS_LAZULI_JUICE_SOURCE,
        //                 zFluids.LAPIS_LAZULI_JUICE_FLOWING,
        //                 zItems.LAPIS_LAZULI_JUICE_BUCKET,
        //                 zBlocks.LAPIS_LAZULI_JUICE_FLUID);

        // public static BaseFlowingFluid.Properties redstone = zProperties.FProp(
        //                 zFluidTypes.REDSTONE_JUICE_FLUID_TYPE,
        //                 zFluids.REDSTONE_JUICE_SOURCE,
        //                 zFluids.REDSTONE_JUICE_FLOWING,
        //                 zItems.REDSTONE_JUICE_BUCKET,
        //                 zBlocks.REDSTONE_JUICE_FLUID);

}
