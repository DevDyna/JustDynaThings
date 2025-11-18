package com.devdyna.justdynathings.compat.phasorite;

import com.devdyna.justdynathings.compat.phasorite.builder.PhasoriteBE;
import com.devdyna.justdynathings.compat.phasorite.builder.PhasoriteBlock;
import com.devdyna.justdynathings.registry.builders.budding.EchoingBuddingType;

import net.neoforged.bus.api.IEventBus;

public class initPhaso {
        public static void register(IEventBus bus) {
        }

        public static EchoingBuddingType<PhasoriteBlock, PhasoriteBE> PHASORITE = EchoingBuddingType.of(
                        "phasorite",
                        PhasoriteBlock::new,
                        PhasoriteBE::new);
}