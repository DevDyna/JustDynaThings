package com.devdyna.justdynathings.compat.chisel;

import com.devdyna.justdynathings.compat.chisel.api.BaseAbilityChisel;
import com.devdyna.justdynathings.config.StartupConfig;
import com.direwolf20.justdirethings.common.items.interfaces.Ability;
import com.direwolf20.justdirethings.common.items.interfaces.Helpers;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;

public class BlazegoldChisel extends BaseAbilityChisel {

    public BlazegoldChisel(Properties p) {
        super(p.durability(StartupConfig.BLAZEGOLD_CHISEL_DURABILITY.get()));
        registerAbility(Ability.LAVAREPAIR);
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        if (canUseAbility(stack, Ability.LAVAREPAIR))
            return Helpers.doLavaRepair(stack, entity);
        return false;
    }

}
