package com.devdyna.justdynathings.registry.types;

import static com.devdyna.justdynathings.Main.ID;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class zFluids {

    // ---------------------------------------------------------------------------------------//

    public static void register(IEventBus bus) {
        zFluids.register(bus);
    }

    // ---------------------------------------------------------------------------------------//
    public static final DeferredRegister<Fluid> zFluids = DeferredRegister.create(BuiltInRegistries.FLUID, ID);

    // ---------------------------------------------------------------------------------------//

    // public static final DeferredHolder<Fluid, ?> CRYSTALLINE_SOURCE = zFluids.register(Constants.Fluids.Crystalline.Source,
    //         () -> new BaseFlowingFluid.Source(zProperties.FProp));
    // public static final DeferredHolder<Fluid, FlowingFluid> CRYSTALLINE_FLOWING = zFluids.register(Constants.Fluids.Crystalline.Flowing,
    //         () -> new BaseFlowingFluid.Flowing(zProperties.FProp));



}
