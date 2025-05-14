package com.devdyna.justdynathings.registry.types;

import static com.devdyna.justdynathings.Main.ID;

import java.util.function.Supplier;

import com.direwolf20.justdirethings.common.blockentities.basebe.FluidMachineBE;
import com.direwolf20.justdirethings.common.capabilities.JustDireFluidTank;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries.Keys;

// @SuppressWarnings("unchecked")
public class zHandlers {

    public static void register(IEventBus bus) {
        zHandler.register(bus);
    }

    // ---------------------------------------------------------------------------------------//

    public static final DeferredRegister<AttachmentType<?>> zHandler = DeferredRegister.create(Keys.ATTACHMENT_TYPES,
            ID);

    // ---------------------------------------------------------------------------------------//

    public static final Supplier<AttachmentType<JustDireFluidTank>> THERMO_FUELS = zHandler.register("thermo_fuels",
            () -> AttachmentType.serializable((h) -> (h instanceof FluidMachineBE f)
                    ? new JustDireFluidTank(f.getMaxMB(), (fs) -> fs.is(zFluidTags.THERMO_COOLERS))
                    : new JustDireFluidTank(0)).build());
        
                    public static final Supplier<AttachmentType<JustDireFluidTank>> MAGMATIC_LIQUID = zHandler.register("magmatic_liquid",
            () -> AttachmentType.serializable((h) -> (h instanceof FluidMachineBE f)
                    ? new JustDireFluidTank(f.getMaxMB(), (fs) -> fs.is(zFluidTags.MAGMATIC_LIQUID))
                    : new JustDireFluidTank(0)).build());

}