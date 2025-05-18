package com.devdyna.justdynathings.registry.builders.solar.blazegold;

import com.devdyna.justdynathings.registry.builders.solar.SolarBaseBE;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.utils.LevelUtil;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
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
        return 1000000;
    }

    @Override
    public int FErate() {
        return 40;
    }

    @Override
    public boolean canGenerateWhen() {
        return LevelUtil.isDimension(level, Level.NETHER);
    }

}
