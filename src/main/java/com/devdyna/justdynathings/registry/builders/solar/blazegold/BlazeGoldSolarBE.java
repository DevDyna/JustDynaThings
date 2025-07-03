package com.devdyna.justdynathings.registry.builders.solar.blazegold;

import com.devdyna.justdynathings.config.common;
import com.devdyna.justdynathings.registry.builders.solar.SolarBaseBE;
import com.devdyna.justdynathings.registry.types.zBiomeTags;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class BlazeGoldSolarBE extends SolarBaseBE {

    public BlazeGoldSolarBE(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public BlazeGoldSolarBE(BlockPos pos, BlockState blockState) {
        this(zBlockEntities.BLAZEGOLD_SOLARGEN.get(), pos, blockState);
    }

    @Override
    public int getMaxEnergy() {
        return common.SOLARPANEL_BLAZEGOLD_FE_CAPACITY.get();
    }

    @Override
    public int FErate() {
        return common.SOLARPANEL_BLAZEGOLD_FE_RATE.get();
    }

    @Override
    public boolean enableMultiPopulator() {
        return common.SOLARPANEL_BLAZEGOLD_ENABLE_SPAM.get();
    }

    @Override
    public boolean enableMultiYLevel() {
        return common.SOLARPANEL_BLAZEGOLD_ENABLE_YLEVEL.get();
    }

    @Override
    public boolean enableCleanSky() {
        return common.SOLARPANEL_BLAZEGOLD_ENABLE_SKY.get();
    }

    @Override
    public boolean enableDayTimeOnly() {
        return common.SOLARPANEL_BLAZEGOLD_ENABLE_DAYTIME.get();
    }

    @Override
    public TagKey<Biome> getBiomeTag() {
        return zBiomeTags.BLAZEGOLD_SOLAR_PANEL_BIOME_LIST;
    }

    @Override
    public boolean isAllowBiome() {
        return common.SOLARPANEL_BLAZEGOLD_BIOMES.get();
    }

}
