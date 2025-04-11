package com.devdyna.justdynathings.registry.types;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.registry.builders.crystalline.CrystallineFluid;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Fluids {

    // ---------------------------------------------------------------------------------------//

    public static void register(IEventBus bus) {
        zFluids.register(bus);

    }

    // ---------------------------------------------------------------------------------------//

    public static final DeferredRegister<Fluid> zFluids = DeferredRegister.create(Registries.FLUID, ID);

    // ---------------------------------------------------------------------------------------//

    public static final DeferredHolder<Fluid, CrystallineFluid> CRYSTALLINE_FLOWING = zFluids
            .register(Constants.Fluids.Crystalline.Flowing, CrystallineFluid.Flowing::new);
    public static final DeferredHolder<Fluid, CrystallineFluid> CRYSTALLINE_SOURCE = zFluids
            .register(Constants.Fluids.Crystalline.Source, CrystallineFluid.Source::new);

}
