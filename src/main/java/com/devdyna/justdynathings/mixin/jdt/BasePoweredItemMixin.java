package com.devdyna.justdynathings.mixin.jdt;

import javax.annotation.Nullable;

import org.spongepowered.asm.mixin.Mixin;
import com.devdyna.cakesticklib.api.utils.ModAddonUtil;
import com.devdyna.justdynathings.compat.ae2.AE2Plugin;
import com.devdyna.justdynathings.config.StartupConfig;
import com.direwolf20.justdirethings.common.items.interfaces.BasePoweredItem;
import com.direwolf20.justdirethings.common.items.interfaces.FluidContainingItem;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

@Mixin(BasePoweredItem.class)
public abstract class BasePoweredItemMixin {

    public void inventoryTick(ItemStack stack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {

        if (ModAddonUtil.checkMod("ae2") && !StartupConfig.DISABLE_AE2_WAND_BOUND_COMPAT.get())
            if (level.getGameTime() % StartupConfig.AE2_WAND_BOUND_TIMESPAN.get() == 0)
                if (stack.getItem() instanceof BasePoweredItem && stack.getItem() instanceof FluidContainingItem) 
                AE2Plugin.createBinding(stack, level, owner, slot);
                    

                

    }

}
