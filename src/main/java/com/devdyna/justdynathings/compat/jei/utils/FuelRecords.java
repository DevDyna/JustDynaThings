package com.devdyna.justdynathings.compat.jei.utils;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.fluids.FluidStack;

import java.util.List;

import com.direwolf20.justdirethings.common.fluids.basefluids.RefinedFuel;

public class FuelRecords {
    public record Items(List<ItemStack> fuels) {
        public List<ItemStack> getFuels() {
            return fuels;
        }

        public int getBurnTime() {
            return fuels.getFirst().getBurnTime(net.minecraft.world.item.crafting.RecipeType.SMELTING);
        }
    }

    public record Fluids(List<FluidStack> fuel) {
        public List<FluidStack> getFuels() {
            return fuel;
        }

        public int getMultiplier() {
            if (fuel != null && !fuel.isEmpty() && fuel.getFirst().getFluid() instanceof RefinedFuel f)
                return f.fePerMb();
            return 0; // *Should be impossible, but lets be sure!*
        }
    }
}