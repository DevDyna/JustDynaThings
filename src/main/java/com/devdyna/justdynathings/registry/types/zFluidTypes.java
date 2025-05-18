package com.devdyna.justdynathings.registry.types;

import static com.devdyna.justdynathings.Main.ID;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries.Keys;

public class zFluidTypes {
    // ---------------------------------------------------------------------------------------//

    public static void register(IEventBus bus) {
        zFluidTypes.register(bus);
    }

    // ---------------------------------------------------------------------------------------//

    public static final DeferredRegister<FluidType> zFluidTypes = DeferredRegister.create(Keys.FLUID_TYPES, ID);

    // ---------------------------------------------------------------------------------------//

    // public static final DeferredHolder<FluidType, ?> REDSTONE_JUICE_FLUID_TYPE = zFluidTypes.register(
    //         Constants.Fluids.REDSTONE_JUICE,
    //         () -> new FluidType(FluidType.Properties.create()
    //                 .lightLevel(10)
    //                 .viscosity(200)
    //                 .canDrown(false)
    //                 .canSwim(false)
    //                 .canPushEntity(false)
    //                 .canConvertToSource(false)
    //                 .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
    //                 .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)) {

    //             @SuppressWarnings({ "null", "removal" })
    //             @Override
    //             public void initializeClient(Consumer<IClientFluidTypeExtensions> c) {

    //                 c.accept(new IClientFluidTypeExtensions() {

    //                     @Override
    //                     public ResourceLocation getStillTexture() {
    //                         return ResourceLocation.fromNamespaceAndPath(JustDireThings.MODID, "block/fluid_source");
    //                     }

    //                     @Override
    //                     public int getTintColor(FluidState s, BlockAndTintGetter g, BlockPos p) {
    //                         return 0xF71919;
    //                     }

    //                     @Override
    //                     public ResourceLocation getFlowingTexture() {
    //                         return ResourceLocation.fromNamespaceAndPath(JustDireThings.MODID, "block/fluid_flowing");
    //                     }

    //                     @Override
    //                     public ResourceLocation getOverlayTexture() {
    //                         return ResourceLocation.fromNamespaceAndPath(JustDireThings.MODID, "block/fluid_overlay");
    //                     }
                        
    //                 });
    //                 super.initializeClient(c);
    //             }
    //         });


    //         public static final DeferredHolder<FluidType, ?> LAPIS_LAZULI_JUICE_FLUID_TYPE = zFluidTypes.register(
    //         Constants.Fluids.LAPIS_LAZULI_JUICE,
    //         () -> new FluidType(FluidType.Properties.create()
    //                 .lightLevel(1)
    //                 .viscosity(400)
    //                 .canDrown(false)
    //                 .canSwim(false)
    //                 .canPushEntity(false)
    //                 .canConvertToSource(false)
    //                 .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
    //                 .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)) {

    //             @SuppressWarnings({ "null", "removal" })
    //             @Override
    //             public void initializeClient(Consumer<IClientFluidTypeExtensions> c) {

    //                 c.accept(new IClientFluidTypeExtensions() {

    //                     @Override
    //                     public ResourceLocation getStillTexture() {
    //                         return ResourceLocation.fromNamespaceAndPath(JustDireThings.MODID, "block/fluid_source");
    //                     }

    //                     @Override
    //                     public int getTintColor(FluidState s, BlockAndTintGetter g, BlockPos p) {
    //                         return 0x0033FF;
    //                     }

    //                     @Override
    //                     public ResourceLocation getFlowingTexture() {
    //                         return ResourceLocation.fromNamespaceAndPath(JustDireThings.MODID, "block/fluid_flowing");
    //                     }

    //                     @Override
    //                     public ResourceLocation getOverlayTexture() {
    //                         return ResourceLocation.fromNamespaceAndPath(JustDireThings.MODID, "block/fluid_overlay");
    //                     }
                        
    //                 });
    //                 super.initializeClient(c);
    //             }
    //         });

}
