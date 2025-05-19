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
        float multipler = 2.0f;
        int min = level.getMinBuildHeight();
        int max = level.getMaxBuildHeight();
        int middle = (Math.abs(min) + max) == 0 ? 10 : (Math.abs(min) + max) / 2;

        int value = getBlockPos().getY();

        if (value != min && value != max)
            multipler *= (value - middle == 0 ? 1 : Math.abs(value - middle)) / middle;

        return (int) (640 * multipler);
    }

    @Override
    public boolean canGenerateWhen() {
        return true;
    }

}
