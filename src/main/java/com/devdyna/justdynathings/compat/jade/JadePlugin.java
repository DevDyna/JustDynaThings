package com.devdyna.justdynathings.compat.jade;

import com.devdyna.justdynathings.compat.jade.providers.EchoingBuddingProvider;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBlock;

import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadePlugin implements IWailaPlugin {
    @Override

    public void registerClient(IWailaClientRegistration registration) {

        registration.registerBlockComponent(EchoingBuddingProvider.INSTANCE, BuddingBlock.class);

    }

    @Override

    public void register(IWailaCommonRegistration registration) {

        registration.registerBlockDataProvider(EchoingBuddingProvider.INSTANCE, BuddingBlock.class);

    }
}
