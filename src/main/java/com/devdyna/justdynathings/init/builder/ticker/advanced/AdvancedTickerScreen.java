package com.devdyna.justdynathings.init.builder.ticker.advanced;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.ticker.BaseTickerScreen;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class AdvancedTickerScreen extends BaseTickerScreen<AdvancedTickerGUI> {
    public AdvancedTickerScreen(AdvancedTickerGUI container, Inventory inv, Component name) {
        super(container, inv, name);
    }

    @Override
    public boolean isLocked() {
        return Config.ADVANCED_TICKER_TICK_LOCK.get();
    }

    @Override
    public int getTickRate() {
        return Config.ADVANCED_TICKER_TICK_RATE.get();
    }

    @Override
    public int getFErate() {
       return Config.ADVANCED_TICKER_FE_RATE.get();
    }

    @Override
    public int getMBrate() {
        return Config.ADVANCED_TICKER_MB_RATE.get();
    }

}