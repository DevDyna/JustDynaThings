package com.devdyna.justdynathings.compat.jei.utils;

import java.util.Comparator;
import java.util.List;

import com.direwolf20.justdirethings.common.blocks.resources.CoalBlock_T1;
import com.direwolf20.justdirethings.common.fluids.basefluids.RefinedFuel;
import com.direwolf20.justdirethings.common.items.resources.Coal_T1;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.neoforged.neoforge.fluids.FluidStack;

public class FuelUtils {
    public static List<ItemStack> getAllSolidFuels() {
        return BuiltInRegistries.ITEM.stream()
                .map(ItemStack::new)
                .filter(AbstractFurnaceBlockEntity::isFuel)
                .sorted(Comparator.comparingInt(stack -> {
                    if (stack.getItem() instanceof Coal_T1)
                        return 0;
                    if (stack.getItem() instanceof BlockItem bi && bi.getBlock() instanceof CoalBlock_T1)
                        return 1;
                    return 2;
                }))
                .toList();
    }

    public static List<FluidStack> getAllRefinedFuels() {
        return BuiltInRegistries.FLUID.stream()
                .filter(fluid -> fluid instanceof RefinedFuel)
                .map(fluid -> new FluidStack(fluid, 1000))
                // .sorted(Comparator.comparingInt(stack -> ((RefinedFuel) stack.getFluid()).fePerMb()))
                .toList();
    }

}
