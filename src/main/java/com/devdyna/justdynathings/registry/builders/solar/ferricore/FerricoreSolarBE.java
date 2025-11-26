package com.devdyna.justdynathings.registry.builders.solar.ferricore;

import com.devdyna.justdynathings.ConfigCommon;
import com.devdyna.justdynathings.registry.builders.solar.SolarBaseBE;
import com.devdyna.justdynathings.registry.types.zBiomeTags;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class FerricoreSolarBE extends SolarBaseBE {

    public FerricoreSolarBE(BlockEntityType<?> t, BlockPos p, BlockState b) {
        super(t, p, b);
    }

    public FerricoreSolarBE(BlockPos p, BlockState b) {
        this(zBlockEntities.FERRICORE_SOLARGEN.get(), p, b);
    }

    @Override
    public int getMaxEnergy() {
        return ConfigCommon.SOLARPANEL_FERRICORE_FE_CAPACITY.get();
    }

    @Override
    public int FErate() {
        return ConfigCommon.SOLARPANEL_FERRICORE_FE_RATE.get();
    }

    @Override
    public boolean enableMultiPopulator() {
        return ConfigCommon.SOLARPANEL_FERRICORE_ENABLE_SPAM.get();
    }

    @Override
    public boolean enableMultiYLevel() {
        return ConfigCommon.SOLARPANEL_FERRICORE_ENABLE_YLEVEL.get();
    }

    @Override
    public boolean enableCleanSky() {
        return ConfigCommon.SOLARPANEL_FERRICORE_ENABLE_SKY.get();
    }

    @Override
    public boolean enableDayTimeOnly() {
        return ConfigCommon.SOLARPANEL_FERRICORE_ENABLE_DAYTIME.get();
    }

    @Override
    public TagKey<Biome> getBiomeTag() {
        return zBiomeTags.FERRICORE_SOLAR_PANEL_BIOME_LIST;
    }

    @Override
    public boolean isAllowBiome() {
        return ConfigCommon.SOLARPANEL_FERRICORE_BIOMES.get();
    }

}
