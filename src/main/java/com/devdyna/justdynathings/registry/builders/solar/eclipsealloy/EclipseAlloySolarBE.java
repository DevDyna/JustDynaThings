package com.devdyna.justdynathings.registry.builders.solar.eclipsealloy;

import com.devdyna.justdynathings.registry.builders.solar.SolarBaseBE;
import com.devdyna.justdynathings.registry.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("null")
public class EclipseAlloySolarBE extends SolarBaseBE {

    public EclipseAlloySolarBE(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public EclipseAlloySolarBE(BlockPos pos, BlockState blockState) {
        this(zBlockEntities.ECLIPSEALLOY_SOLARGEN.get(), pos, blockState);
    }

    @Override
    public int getMaxEnergy() {
        return 1000000;
    }

    @Override
    public int FErate() {

        int min = level.getMinBuildHeight();
        int max = level.getMaxBuildHeight() - 1;

        int y = getBlockPos().getY();

        float middle = (min + max) / 2.0f;

        float unckecked = 1.0f - (((y - middle) / (max - min)) * ((y - middle) / (max - min)) * 4);
        unckecked = Math.max(unckecked, 0);
        float value = 0.05f + (1.0f - 0.05f) * (1.0f - unckecked);
        return (int) (10240 * value);

    }

    @Override
    public boolean canGenerateWhen() {
        return true;
    }

}
