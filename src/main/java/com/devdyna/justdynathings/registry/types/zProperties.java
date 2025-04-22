package com.devdyna.justdynathings.registry.types;

import static net.minecraft.world.item.Items.*;

import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public class zProperties {
    // ---------------------------------------------------------------------------------------//

    public static void register(IEventBus bus) {
    }
    // ---------------------------------------------------------------------------------------//

    public static final BlockBehaviour.Properties bProp = BlockBehaviour.Properties.of();
    public static final Properties iProp = new Item.Properties();
    public static final Properties iPropBucket = iProp.craftRemainder(BUCKET).stacksTo(1);
    public final static BaseFlowingFluid.Properties FProp = new BaseFlowingFluid.Properties(
            zFluidTypes.CRYSTALLINE_FLUID_TYPE,
            zFluids.CRYSTALLINE_SOURCE,
            zFluids.CRYSTALLINE_FLOWING)
            .bucket(zItems.CRYSTALLINE_BUCKET)
            .block(zBlocks.CRYSTALLINE_FLUID);

    public static final BlockBehaviour.Properties MachineProp = BlockBehaviour.Properties.of()
            .requiresCorrectToolForDrops()
            .strength(2.0f)
            .sound(SoundType.METAL)
            .isRedstoneConductor(BaseMachineBlock::never);
    // ---------------------------------------------------------------------------------------//

    public static final BooleanProperty GOO_ALIVE = GooBlock_Base.ALIVE;

    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
    public static final BooleanProperty COOLED = BooleanProperty.create("thermo_cooled");
    public static final BooleanProperty HEATED = BooleanProperty.create("thermo_heated");
    public static final BooleanProperty GOO_FOUND = BooleanProperty.create("goo_found");

}
