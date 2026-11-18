package com.devdyna.justdynathings.mixin.jdt;

import javax.annotation.Nullable;

import org.spongepowered.asm.mixin.Mixin;
import com.devdyna.cakesticklib.api.utils.ModAddonUtil;
import com.devdyna.justdynathings.compat.ae2.utils.AEAccessPointUtils;
import com.direwolf20.justdirethings.common.items.interfaces.BasePoweredItem;
import com.direwolf20.justdirethings.common.items.interfaces.FluidContainingItem;

import appeng.api.config.Actionable;
import appeng.api.ids.AEComponents;
import appeng.api.networking.security.IActionSource;
import appeng.api.stacks.AEFluidKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.transaction.Transaction;

@Mixin(BasePoweredItem.class)
public abstract class BasePoweredItemMixin {

    public void inventoryTick(ItemStack stack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {

        if (ModAddonUtil.checkMod("ae2"))
            if (level.getGameTime() % 40 == 0)// TODO config delay? //TODO toggle config
                if (stack.getItem() instanceof BasePoweredItem && stack.getItem() instanceof FluidContainingItem) {

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

}
