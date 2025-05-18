package com.devdyna.justdynathings.registry.builders.solar.celestigem;

import com.devdyna.justdynathings.registry.builders.solar.SolarBaseBE;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("null")
public class CelestiGemSolarBE extends SolarBaseBE {

    public CelestiGemSolarBE(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public CelestiGemSolarBE(BlockPos pos, BlockState blockState) {
        this(zBlockEntities.CELESTIGEM_SOLARGEN.get(), pos, blockState);
    }

    @Override
    public int getMaxEnergy() {
        return 1000000;
    }

    @Override
    public int FErate() {
        return 160;
    }

    @Override
    public boolean canGenerateWhen() {
        return level.canSeeSkyFromBelowWater(getBlockPos().above()) && level.isDay()
                && level.getBlockState(getBlockPos().above()).isAir();
    }

}
