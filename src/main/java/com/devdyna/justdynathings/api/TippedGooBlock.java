package com.devdyna.justdynathings.api;

import net.minecraft.network.chat.Component;

public interface TippedGooBlock {
    abstract int getConfigTier();

    default Component extra(){
        return null;
    }
}
