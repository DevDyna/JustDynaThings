package com.devdyna.justdynathings.registry.builders.solar.blazegold;

import com.devdyna.justdynathings.registry.builders.solar.SolarBaseBE;
import com.devdyna.justdynathings.registry.types.zBlockEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("null")
public class BlazeGoldSolarBE extends SolarBaseBE {

    public BlazeGoldSolarBE(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public BlazeGoldSolarBE(BlockPos pos, BlockState blockState) {
        this(zBlockEntities.BLAZEGOLD_SOLARGEN.get(), pos, blockState);
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
        return level.canSeeSkyFromBelowWater(getBlockPos().above()) && level.isDay(); //TODO make it work on nether
    }

}
