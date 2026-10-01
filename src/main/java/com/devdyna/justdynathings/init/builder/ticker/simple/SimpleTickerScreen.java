package com.devdyna.justdynathings.init.builder.ticker.simple;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.ticker.BaseTickerScreen;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class SimpleTickerScreen extends BaseTickerScreen<SimpleTickerGUI> {
    public SimpleTickerScreen(SimpleTickerGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

    @Override
    public boolean isLocked() {
        return Config.SIMPLE_TICKER_TICK_LOCK.get();
    }

    @Override
    public int getTickRate() {
        return Config.SIMPLE_TICKER_TICK_RATE.get();
    }

    @Override
    public int getFErate() {
        return Config.SIMPLE_TICKER_FE_RATE.get();
    }

    @Override
    public int getMBrate() {
        return Config.SIMPLE_TICKER_MB_RATE.get();
    }

}