package com.devdyna.justdynathings.compat.jei.utils;

import net.minecraft.world.item.ItemStack;

import java.util.List;

public record FuelTierRecord(List<ItemStack> fuels,int burnTime) {
    public List<ItemStack> getFuels() {
        return fuels;
    }

    public int getBurnTime(){
        return burnTime;
    }
}
