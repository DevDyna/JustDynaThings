package com.devdyna.justdynathings.registry.builders.solar.eclipsealloy;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.registry.builders.solar.SolarBaseBE;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import net.minecraft.core.BlockPos;
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
    public boolean canGenerateWhen() {
        return Config.SOLARPANEL_ECLIPSEALLOY_CONDITIONS_OVERRIDE.get() ? true
                : true; // no conditions
    }
}
