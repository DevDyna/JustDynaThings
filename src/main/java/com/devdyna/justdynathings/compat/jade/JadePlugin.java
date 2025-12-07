package com.devdyna.justdynathings.compat.jade;

import com.devdyna.justdynathings.compat.jade.providers.EchoingBuddingProvider;
import com.devdyna.justdynathings.compat.jade.providers.ParadoxMixerProvider;
import com.devdyna.justdynathings.compat.jade.providers.StabilizerProvider;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.BuddingBlock;
import com.devdyna.justdynathings.registry.builders.paradox_mixer.ParadoxMixerBlock;
import com.devdyna.justdynathings.registry.builders.stabilizer.StabilizerBlock;

import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadePlugin implements IWailaPlugin {
    @Override

    public void registerClient(IWailaClientRegistration registration) {

        registration.registerBlockComponent(EchoingBuddingProvider.INSTANCE, BuddingBlock.class);
        registration.registerBlockComponent(StabilizerProvider.INSTANCE, StabilizerBlock.class);
        registration.registerBlockComponent(ParadoxMixerProvider.INSTANCE, ParadoxMixerBlock.class);

    }

    @Override

    public void register(IWailaCommonRegistration registration) {

        registration.registerBlockDataProvider(EchoingBuddingProvider.INSTANCE, BuddingBlock.class);
        registration.registerBlockDataProvider(StabilizerProvider.INSTANCE, StabilizerBlock.class);
        registration.registerBlockDataProvider(ParadoxMixerProvider.INSTANCE, ParadoxMixerBlock.class);

    }
}
