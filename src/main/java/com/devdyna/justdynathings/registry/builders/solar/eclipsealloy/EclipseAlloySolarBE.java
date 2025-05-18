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
        return 1000;
    }

    @Override
    public int FErate() {
        return FErate;
    }

    @Override
    public boolean canGenerateWhen() {
        return level.canSeeSkyFromBelowWater(getBlockPos().above()) && level.isDay(); //TODO work make to everywhere
    }

}
