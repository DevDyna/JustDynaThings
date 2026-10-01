package com.devdyna.justdynathings.api.solar_panels;

import org.jetbrains.annotations.Nullable;

import com.direwolf20.justdirethings.common.containers.basecontainers.BaseMachineContainer;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.biome.Biome;

public abstract class SolarGUIBase extends BaseMachineContainer {

    public SolarGUIBase(@Nullable MenuType<?> arg0, int arg1, Inventory arg2, BlockPos arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    public abstract int getFERate();

    public abstract boolean isAllowBiome();

    public abstract TagKey<Biome> getBiomeTag();

    public abstract boolean enableDayTimeOnly();

    public abstract boolean enableCleanSky();

    public abstract boolean enableMultiYLevel();

    public abstract boolean enableMultiPopulator();

}
