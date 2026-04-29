package com.devdyna.justdynathings.init.builder.solar_panels.eclipsealloy;


import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.solar_panels.SolarBaseBE;
import com.devdyna.justdynathings.init.types.zBiomeTags;
import com.devdyna.justdynathings.init.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class EclipseAlloySolarBE extends SolarBaseBE {

    public EclipseAlloySolarBE(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public EclipseAlloySolarBE(BlockPos pos, BlockState blockState) {
        this(zBlockEntities.ECLIPSEALLOY_SOLARGEN.get(), pos, blockState);
    }

    @Override
    public int getMaxEnergy() {
        return Config.SOLARPANEL_ECLIPSEALLOY_FE_CAPACITY.get();
    }

    @Override
    public int FErate() {
        return Config.SOLARPANEL_ECLIPSEALLOY_FE_RATE.get();
    }

    @Override
    public boolean enableMultiPopulator() {
        return Config.SOLARPANEL_ECLIPSEALLOY_ENABLE_SPAM.get();
    }

    @Override
    public boolean enableMultiYLevel() {
        return Config.SOLARPANEL_ECLIPSEALLOY_ENABLE_YLEVEL.get();
    }

     @Override
    public boolean enableCleanSky() {
        return Config.SOLARPANEL_ECLIPSEALLOY_ENABLE_SKY.get();
    }

    @Override
    public boolean enableDayTimeOnly() {
        return Config.SOLARPANEL_ECLIPSEALLOY_ENABLE_DAYTIME.get();
    }

    @Override
    public TagKey<Biome> getBiomeTag() {
        return zBiomeTags.ECLIPSEALLOY_SOLAR_PANEL_BIOME_LIST;
    }

    @Override
    public boolean isAllowBiome() {
        return Config.SOLARPANEL_ECLIPSEALLOY_BIOMES.get();
    }
}
