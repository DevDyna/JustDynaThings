package com.devdyna.justdynathings.init.builder.ticker.simple;

import com.devdyna.justdynathings.api.ticker.BaseTickerScreen;
import com.devdyna.justdynathings.config.ServerConfig;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class SimpleTickerScreen extends BaseTickerScreen<SimpleTickerGUI> {
    public SimpleTickerScreen(SimpleTickerGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

    @Override
    public boolean isLocked() {
        return ServerConfig.SIMPLE_TICKER_TICK_LOCK.get();
    }

    @Override
    public int getTickRate() {
        return ServerConfig.SIMPLE_TICKER_TICK_RATE.get();
    }

    @Override
    public int getFErate() {
        return ServerConfig.SIMPLE_TICKER_FE_RATE.get();
    }

    @Override
    public int getMBrate() {
        return ServerConfig.SIMPLE_TICKER_MB_RATE.get();
    }

}