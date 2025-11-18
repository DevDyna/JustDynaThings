package com.devdyna.justdynathings.compat.ae2;

import com.devdyna.justdynathings.compat.ae2.builder.CertusBE;
import com.devdyna.justdynathings.compat.ae2.builder.CertusBlock;
import com.devdyna.justdynathings.registry.builders.budding.EchoingBuddingType;

import net.neoforged.bus.api.IEventBus;

public class initApp {
        public static void register(IEventBus bus) {
        }

        public static EchoingBuddingType<CertusBlock, CertusBE> CERTUS = EchoingBuddingType.of(
                        "certus",
                        CertusBlock::new,
                        CertusBE::new);
}