package com.devdyna.justdynathings.utils;


import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.LevelAccessor;

public class EnchantUtil {
    /**
     * @param level   net.minecraft.world.level.Level
     * @param enchant Enchantments.name
     * @return Holder[Enchantment]
     */
    public static Holder<Enchantment> getEnchantHolder(LevelAccessor level, ResourceKey<Enchantment> enchant) {
        return level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT)
                .getOrThrow(enchant);
    }
}
