package com.devdyna.justdynathings.compat.ae2;

import com.devdyna.justdynathings.init.types.zItems;
import com.direwolf20.justdirethings.common.items.interfaces.BasePoweredItem;
import com.direwolf20.justdirethings.common.items.interfaces.FluidContainingItem;
import com.direwolf20.justdirethings.setup.JDTRegistration;

import appeng.api.features.GridLinkables;
import appeng.api.features.IGridLinkableHandler;
import appeng.api.ids.AEComponents;
import net.minecraft.core.GlobalPos;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

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

}
