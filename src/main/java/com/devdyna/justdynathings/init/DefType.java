package com.devdyna.justdynathings.init;

import com.devdyna.justdynathings.Main;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DefType {
        public static final DeferredRegister<BlockEntityType<?>> zBE = DeferredRegister
                        .create(Registries.BLOCK_ENTITY_TYPE, Main.ID);
        public static final DeferredRegister.Blocks zBLK = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Items zITM = DeferredRegister.createItems(Main.ID);
        public static final DeferredRegister<CreativeModeTab> zCTBS = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, Main.ID);

        public static void register(IEventBus bus) {
                zBLK.register(bus);
                zITM.register(bus);
                zBE.register(bus);
                zCTBS.register(bus);
        }
}
