package com.devdyna.justdynathings.registry.types;

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
import net.minecraft.world.level.block.state.properties.IntegerProperty;
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
        @Deprecated
        public static final BlockBehaviour.Properties bProp = BlockBehaviour.Properties.of();
        @Deprecated
        public static final Properties iProp = new Item.Properties();

        // public static final Properties iPropBucket =
        // iProp.craftRemainder(BUCKET).stacksTo(1);
        @Deprecated
        public final static BaseFlowingFluid.Properties FProp(DeferredHolder<FluidType, ?> type,
                        DeferredHolder<Fluid, ?> source, DeferredHolder<Fluid, FlowingFluid> flowing,
                        DeferredHolder<Item, BucketItem> bucket,
                        DeferredHolder<Block, LiquidBlock> blockfluid) {
                return new BaseFlowingFluid.Properties(type, source, flowing).bucket(bucket).block(blockfluid);
        }

        @Deprecated
        public static final BlockBehaviour.Properties MachineProp = BlockBehaviour.Properties.of()
                        .requiresCorrectToolForDrops()
                        .strength(2.0f)
                        .sound(SoundType.METAL)
                        .isRedstoneConductor(BaseMachineBlock::never);
        // ---------------------------------------------------------------------------------------//

        public static final BooleanProperty GOO_ALIVE = GooBlock_Base.ALIVE;
        public static final IntegerProperty STABILIZERS = IntegerProperty.create("stabilizers", 0, 6);
        public static final BooleanProperty SOLID = BooleanProperty.create("solid");
        public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
        public static final BooleanProperty COOLED = BooleanProperty.create("thermo_cooled");
        public static final BooleanProperty HEATED = BooleanProperty.create("thermo_heated");
        public static final BooleanProperty GOO_FOUND = BooleanProperty.create("goo_found");

}
