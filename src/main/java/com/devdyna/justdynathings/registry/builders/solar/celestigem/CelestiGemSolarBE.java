package com.devdyna.justdynathings.registry.builders.solar.celestigem;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.registry.builders.solar.SolarBaseBE;
import com.devdyna.justdynathings.registry.types.zBiomeTags;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CelestiGemSolarBE extends SolarBaseBE {

    public CelestiGemSolarBE(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public CelestiGemSolarBE(BlockPos pos, BlockState blockState) {
        this(zBlockEntities.CELESTIGEM_SOLARGEN.get(), pos, blockState);
    }

    @Override
    public int getMaxEnergy() {
        return Config.SOLARPANEL_CELESTIGEM_FE_CAPACITY.get();
    }

    @Override
    public int FErate() {
        return Config.SOLARPANEL_CELESTIGEM_FE_RATE.get();
    }

    @Override
    public boolean enableMultiPopulator() {
        return Config.SOLARPANEL_CELESTIGEM_ENABLE_SPAM.get();
    }

    @Override
    public boolean enableMultiYLevel() {
        return Config.SOLARPANEL_CELESTIGEM_ENABLE_YLEVEL.get();
    }

    @Override
    public boolean enableCleanSky() {
        return Config.SOLARPANEL_CELESTIGEM_ENABLE_SKY.get();
    }

    @Override
    public boolean enableDayTimeOnly() {
        return Config.SOLARPANEL_CELESTIGEM_ENABLE_DAYTIME.get();
    }

    @Override
    public TagKey<Biome> getBiomeTag() {
        return zBiomeTags.CELESTIGEM_SOLAR_PANEL_BIOME_LIST;
    }

    @Override
    public boolean isAllowBiome() {
        return Config.SOLARPANEL_CELESTIGEM_BIOMES.get();
    }

}
