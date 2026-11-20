package com.devdyna.justdynathings.compat.ae2;

import com.devdyna.justdynathings.compat.ae2.utils.AEAccessPointUtils;
import com.devdyna.justdynathings.init.types.zItems;
import com.direwolf20.justdirethings.common.items.interfaces.BasePoweredItem;
import com.direwolf20.justdirethings.common.items.interfaces.FluidContainingItem;
import com.direwolf20.justdirethings.setup.JDTRegistration;

import appeng.api.config.Actionable;
import appeng.api.features.GridLinkables;
import appeng.api.features.IGridLinkableHandler;
import appeng.api.ids.AEComponents;
import appeng.api.networking.security.IActionSource;
import appeng.api.stacks.AEFluidKey;
import net.minecraft.core.GlobalPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.transaction.Transaction;

public class AE2Plugin {

    public static void register(final FMLCommonSetupEvent e) {
        GridLinkables.register(JDTRegistration.TimeWand.get(), GRID_LINK);
        GridLinkables.register(zItems.ADVANCED_TIME_WAND.get(), GRID_LINK);
        GridLinkables.register(JDTRegistration.PolymorphicWand.get(), GRID_LINK);
        GridLinkables.register(JDTRegistration.PolymorphicWandV2.get(), GRID_LINK);
        GridLinkables.register(JDTRegistration.PortalGunV2.get(), GRID_LINK);
    }

    public static final IGridLinkableHandler GRID_LINK = new IGridLinkableHandler() {
        @Override
        public boolean canLink(ItemStack i) {
            return i.getItem() instanceof FluidContainingItem && i.getItem() instanceof BasePoweredItem;
        }

        @Override
        public void link(ItemStack i, GlobalPos p) {
            i.set(AEComponents.WIRELESS_LINK_TARGET, p);
        }

        @Override
        public void unlink(ItemStack i) {
            i.remove(AEComponents.WIRELESS_LINK_TARGET);
        }
    };

    public static void createBinding(ItemStack stack, ServerLevel level, Entity owner, EquipmentSlot slot) {
        if (stack.has(AEComponents.WIRELESS_LINK_TARGET)) {

            var gps = stack.get(AEComponents.WIRELESS_LINK_TARGET);

            var tank = stack.getCapability(Capabilities.Fluid.ITEM, ItemAccess.forStack(stack));

            var storage = AEAccessPointUtils.getGridStorage(gps, owner);

            if (owner instanceof Player player)
                if (storage != null)
                    if (tank != null) {

                        var fluid = AEAccessPointUtils.getFluidOrTemplate(stack);

                        if (fluid != null) {

                            var required = tank.getCapacityAsInt(0, fluid) - tank.getAmountAsInt(0);

                            if (required > 0) {

                                var simulated = (int) storage.extract(AEFluidKey.of(fluid), required,
                                        Actionable.SIMULATE,
                                        IActionSource.ofPlayer(player));

                                if (simulated > 0) {

                                    storage.extract(AEFluidKey.of(fluid), simulated, Actionable.MODULATE,
                                            IActionSource.ofPlayer(player));

                                    try (var tx = Transaction.openRoot()) {
                                        tank.insert(fluid, simulated, tx);
                                        tx.commit();
                                    }

                                }

                            }

                        }

                    }

        }
    }

}
