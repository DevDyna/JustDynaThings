package com.devdyna.justdynathings.init.builder.ticker.advanced;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.init.builder.ticker.simple.SimpleTickerBE;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class AdvancedTickerBE extends SimpleTickerBE {

    public AdvancedTickerBE(BlockEntityType<?> p, BlockPos b, BlockState s) {
        super(p, b, s);
    }

    public AdvancedTickerBE(BlockPos p, BlockState s) {
        this(zBlockEntities.ADVANCED_TICKER.get(), p, s);
    }

    @Override
    public int getTickerRate() {
        return Config.ADVANCED_TICKER_TICK_RATE.get() ;
    }

    @Override
    public int getStandardEnergyCost() {
        return Config.ADVANCED_TICKER_FE_RATE.get();
    }

    @Override
    public int getMaxEnergy() {
        return Config.ADVANCED_TICKER_FE_CAPACITY.get();
    }

    @Override
    public int getStandardFluidCost() {
        return Config.ADVANCED_TICKER_MB_RATE.get();
    }

    @Override
    public int getMaxMB() {
        return Config.ADVANCED_TICKER_MB_CAPACITY.get();
    }

    public boolean isLocked(){
        return Config.ADVANCED_TICKER_TICK_LOCK.get();
    }

}