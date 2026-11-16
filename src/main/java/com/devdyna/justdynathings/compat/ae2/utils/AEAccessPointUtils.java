package com.devdyna.justdynathings.compat.ae2.utils;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import java.util.List;

import com.devdyna.cakesticklib.api.utils.ColorUtils;
import com.direwolf20.justdirethings.common.items.PolymorphicWand;
import com.direwolf20.justdirethings.common.items.PortalGunV2;
import com.direwolf20.justdirethings.common.items.TimeWand;
import com.direwolf20.justdirethings.common.items.interfaces.FluidContainingItem;
import com.direwolf20.justdirethings.common.items.interfaces.PoweredItem;
import com.direwolf20.justdirethings.setup.JDTRegistration;

import appeng.api.ids.AEComponents;
import appeng.api.implementations.blockentities.IWirelessAccessPoint;
import appeng.api.storage.MEStorage;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.GlobalPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.fluid.FluidResource;

public class AEAccessPointUtils {
    public static MEStorage getGridStorage(GlobalPos bound, Entity owner) {
        var level = owner.level();

        if (level == null)
            return null;

        var server = level.getServer().getLevel(bound.dimension());

        if (server == null)
            return null;

        var be = server.getBlockEntity(bound.pos());

        if (be == null)
            return null;

        if (!(be instanceof IWirelessAccessPoint poi))
            return null;

        var grid = poi.getGrid();

        if (grid == null)
            return null;

        return grid.getStorageService().getInventory();
    }

    public static FluidResource getFluidOrTemplate(ItemStack stack) {
        var item = stack.getItem();
        var tank = stack.getCapability(Capabilities.Fluid.ITEM, ItemAccess.forStack(stack));

        if (tank != null && tank.getResource(0) != null && !tank.getResource(0).isEmpty())
            return tank.getResource(0);

        // TODO i need to find a way to extract without manually adding it!

        if (item instanceof TimeWand)
            return FluidResource.of(JDTRegistration.TIME_FLUID_SOURCE);

        if (item instanceof PolymorphicWand)
            return FluidResource.of(JDTRegistration.POLYMORPHIC_FLUID_SOURCE);

        if (item instanceof PortalGunV2)
            return FluidResource.of(JDTRegistration.PORTAL_FLUID_SOURCE);

        return null;
    }

    public static void renderAdditionalTooltip(ItemStack item, List<Component> tip) {
        var index = Math.max(1, tip.size() - 2);

        if ((item.getItem() instanceof PoweredItem || item.getItem() instanceof PolymorphicWand)
                && item.getItem() instanceof FluidContainingItem)
            if (item.has(AEComponents.WIRELESS_LINK_TARGET)) {
                if (Minecraft.getInstance().hasControlDown()) {

                    var pos = item.get(AEComponents.WIRELESS_LINK_TARGET);

                    tip.add(index, Component.translatable(MODULE_ID + ".wand.pos")

                            .append(Component.literal("" + pos.pos().getX()).withStyle(ChatFormatting.AQUA))

                            .append(Component.literal(" " + pos.pos().getY()).withStyle(ChatFormatting.AQUA))

                            .append(Component.literal(" " + pos.pos().getZ()).withStyle(ChatFormatting.AQUA)));
                } else {
                    tip.add(index, Component.translatable(MODULE_ID + ".ae2.linkable.info"));
                }
            } else {
                tip.add(index, Component.translatable(MODULE_ID + ".ae2.linkable.desc")
                        .withColor(ColorUtils.rainbow().getRGB()));
            }
    }
}
