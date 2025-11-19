package com.devdyna.justdynathings.compat.extendedae;

import com.devdyna.justdynathings.compat.extendedae.builder.EntroBE;
import com.devdyna.justdynathings.compat.extendedae.builder.EntroBlock;
import com.devdyna.justdynathings.registry.builders.echoing_buddings.EchoingBuddingType;

import net.neoforged.bus.api.IEventBus;

public class initExtend {
        public static void register(IEventBus bus) {
        }

        public static EchoingBuddingType<EntroBlock, EntroBE> ENTRO = EchoingBuddingType.of(
                       "entro",
                        EntroBlock::new,
                        EntroBE::new);
}