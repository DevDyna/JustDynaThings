package com.devdyna.justdynathings.registry.builders.solar.ferricore;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.registry.builders.solar.SolarBaseBE;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.utils.LevelUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("null")
public class FerricoreSolarBE extends SolarBaseBE {

    public FerricoreSolarBE(BlockEntityType<?> t, BlockPos p, BlockState b) {
        super(t, p, b);
    }

    public FerricoreSolarBE(BlockPos p, BlockState b) {
        this(zBlockEntities.FERRICORE_SOLARGEN.get(), p, b);
    }

    @Override
    public int getMaxEnergy() {
        return Config.SOLARPANEL_FERRICORE_FE_CAPACITY.get();
    }

    @Override
    public int FErate() {
        return Config.SOLARPANEL_FERRICORE_FE_RATE.get();
    }

    @Override
    public boolean enableMultiPopulator() {
        return Config.SOLARPANEL_FERRICORE_ENABLE_SPAM.get();
    }

    @Override
    public boolean enableMultiYLevel() {
        return Config.SOLARPANEL_FERRICORE_ENABLE_YLEVEL.get();
    }

    @Override
    public boolean canGenerateWhen() {
        return Config.SOLARPANEL_FERRICORE_CONDITIONS_OVERRIDE.get() ? true
                : level.canSeeSkyFromBelowWater(getBlockPos().above()) && level.isDay()
                        && level.getBlockState(getBlockPos().above()).isAir()
                        && LevelUtil.isDimension(level, Level.OVERWORLD);
    }

}
