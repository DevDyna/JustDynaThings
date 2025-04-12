package com.devdyna.justdynathings.registry.types;

import static com.devdyna.justdynathings.Main.ID;
import java.util.function.Consumer;

import com.devdyna.justdynathings.Constants;
import com.direwolf20.justdirethings.JustDireThings;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.common.SoundActions;
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

    public static final DeferredHolder<FluidType, ?> CRYSTALLINE_FLUID_TYPE = zFluidTypes.register(
            Constants.Fluids.CRYSTALLINE,
            () -> new FluidType(FluidType.Properties.create()
                    .lightLevel(10)
                    .viscosity(200)
                    .canDrown(false)
                    .canSwim(false)
                    .canPushEntity(false)
                    .canConvertToSource(false)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)) {

                @SuppressWarnings({ "null" })
                @Override
                public void initializeClient(Consumer<IClientFluidTypeExtensions> c) {

                    c.accept(new IClientFluidTypeExtensions() {

                        @Override
                        public ResourceLocation getStillTexture() {
                            return ResourceLocation.fromNamespaceAndPath(JustDireThings.MODID, "block/fluid_source");
                        }

                        @Override
                        public int getTintColor(FluidState s, BlockAndTintGetter g, BlockPos p) {
                            return 0xCCCCCC;
                        }

                        @Override
                        public ResourceLocation getFlowingTexture() {
                            return ResourceLocation.fromNamespaceAndPath(JustDireThings.MODID, "block/fluid_flowing");
                        }

                        @Override
                        public ResourceLocation getOverlayTexture() {
                            return ResourceLocation.fromNamespaceAndPath(JustDireThings.MODID, "block/fluid_overlay");
                        }
                    });
                }
            });

}
