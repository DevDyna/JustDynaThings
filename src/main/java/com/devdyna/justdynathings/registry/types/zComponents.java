package com.devdyna.justdynathings.registry.types;

import net.minecraft.world.level.block.state.BlockState;
import static com.devdyna.justdynathings.Main.ID;

import net.minecraft.core.component.DataComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("removal")
public class zComponents {

        public static void register(IEventBus bus) {
                zComponents.register(bus);

        }
        // ---------------------------------------------------------------------------------------//

        public static final DeferredRegister<DataComponentType<?>> zComponents = DeferredRegister
                        .createDataComponents(ID);
        // ---------------------------------------------------------------------------------------//

        public static final DeferredHolder<DataComponentType<?>, DataComponentType<BlockState>> STATE = zComponents
                        .register(
                                        "state",
                                        () -> DataComponentType.<BlockState>builder().persistent(BlockState.CODEC)
                                                        .build());

}
