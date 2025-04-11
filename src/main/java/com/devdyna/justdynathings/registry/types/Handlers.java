package com.devdyna.justdynathings.registry.types;

import static com.devdyna.justdynathings.Main.ID;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries.Keys;
// @SuppressWarnings("unchecked")
public class Handlers {

    public static void register(IEventBus bus) {
        zHandler.register(bus);
    }

    // ---------------------------------------------------------------------------------------//

    public static final DeferredRegister<AttachmentType<?>> zHandler = DeferredRegister.create(Keys.ATTACHMENT_TYPES, ID);

    // ---------------------------------------------------------------------------------------//


//     public static final Supplier<AttachmentType<ItemStackHandler>> HANDLER = (Supplier<AttachmentType<ItemStackHandler>>) zHandler.register(
//     "handler", () -> AttachmentType.serializable(() -> new ItemStackHandler(1)).build()
// );

    
//     public static final Supplier<AttachmentType<JustDireFluidTank>>
//     PARADOX_FLUID_HANDLER = (Supplier<AttachmentType<JustDireFluidTank>>) zHandler.register("paradox_fluid_handler", () -> {
//         return AttachmentType.serializable((h) ->
//            (h instanceof FluidMachineBE f) 
//            ? new JustDireFluidTank(f.getMaxMB(), (fluidstack) ->fluidstack.getFluid() instanceof TimeFluid)
//            : new JustDireFluidTank(0)
//         ).build();
//      });

}