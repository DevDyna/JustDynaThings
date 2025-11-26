package com.devdyna.justdynathings.registry.builders.solar.eclipsealloy;

import com.devdyna.justdynathings.CommonConfig;
import com.devdyna.justdynathings.registry.builders.solar.SolarBaseBE;
import com.devdyna.justdynathings.registry.types.zBiomeTags;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
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
        return CommonConfig.SOLARPANEL_ECLIPSEALLOY_FE_CAPACITY.get();
    }

    @Override
    public int FErate() {
        return CommonConfig.SOLARPANEL_ECLIPSEALLOY_FE_RATE.get();
    }

    @Override
    public boolean enableMultiPopulator() {
        return CommonConfig.SOLARPANEL_ECLIPSEALLOY_ENABLE_SPAM.get();
    }

    @Override
    public boolean enableMultiYLevel() {
        return CommonConfig.SOLARPANEL_ECLIPSEALLOY_ENABLE_YLEVEL.get();
    }

     @Override
    public boolean enableCleanSky() {
        return CommonConfig.SOLARPANEL_ECLIPSEALLOY_ENABLE_SKY.get();
    }

    @Override
    public boolean enableDayTimeOnly() {
        return CommonConfig.SOLARPANEL_ECLIPSEALLOY_ENABLE_DAYTIME.get();
    }

    @Override
    public TagKey<Biome> getBiomeTag() {
        return zBiomeTags.ECLIPSEALLOY_SOLAR_PANEL_BIOME_LIST;
    }

    @Override
    public boolean isAllowBiome() {
        return CommonConfig.SOLARPANEL_ECLIPSEALLOY_BIOMES.get();
    }
}
