package com.devdyna.justdynathings.registry.types;

import net.minecraft.world.level.block.state.BlockState;
import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.recipetypes.BetterThanBlockStates;
import com.mojang.serialization.Codec;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
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
                                        () -> DataComponentType.<BlockState>builder()
                                        .networkSynchronized(BetterThanBlockStates.STREAM_CODEC)
                                        .persistent(BlockState.CODEC)
                                                        .build());

        public static final DeferredHolder<DataComponentType<?>, DataComponentType<String>> MODE = zComponents
                        .register(
                                        "mode",
                                        () -> DataComponentType.<String>builder()
                                        .networkSynchronized(ByteBufCodecs.STRING_UTF8)
                                        .persistent(Codec.STRING)
                                                        .build());

}
