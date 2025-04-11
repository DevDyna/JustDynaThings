package com.devdyna.justdynathings.registry.types;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.registry.builders.crystalline.CrystallineFluidType;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries.Keys;

public class FluidTypes {
    // ---------------------------------------------------------------------------------------//

    public static void register(IEventBus bus) {
        zFluidTypes.register(bus);
    }

    // ---------------------------------------------------------------------------------------//
    public static final DeferredRegister<FluidType> zFluidTypes = DeferredRegister.create(Keys.FLUID_TYPES, ID);

    // ---------------------------------------------------------------------------------------//
    public static final DeferredHolder<FluidType, CrystallineFluidType> CRYSTALLINE_FLUID_TYPE = FluidTypes.zFluidTypes
            .register(Constants.Fluids.Crystalline.Type, CrystallineFluidType::new);

}
