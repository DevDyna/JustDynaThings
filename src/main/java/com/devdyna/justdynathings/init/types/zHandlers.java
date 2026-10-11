package com.devdyna.justdynathings.init.types;

import java.util.function.Supplier;

import com.devdyna.cakesticklib.CakeStickLib;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidMachineBE;
import com.direwolf20.justdirethings.common.capabilities.JustDireFluidTank;
import com.direwolf20.justdirethings.common.fluids.portalfluid.PortalFluid;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries.Keys;

public class zHandlers {

    public static void register(IEventBus bus) {
        zHandler.register(bus);
    }

    public static final DeferredRegister<AttachmentType<?>> zHandler = DeferredRegister.create(
            Keys.ATTACHMENT_TYPES,
            CakeStickLib.MODULE_ID);

    public static final Supplier<AttachmentType<JustDireFluidTank>> PORTAL_FLUID_HANDLER = zHandler.register(
            "portal_handler",
            () -> AttachmentType.serializable(h -> (h instanceof FluidMachineBE be)
                    ? new JustDireFluidTank(be.getMaxMB(), f -> f.getFluid() instanceof PortalFluid)
                    : new JustDireFluidTank(0)).build());
}
