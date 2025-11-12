package com.devdyna.justdynathings.compat.phasorite;

import com.devdyna.justdynathings.Main;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class init {

        public static void register(IEventBus bus) {
                zPHASO_BLK.register(bus);
                zPHASO_ITM.register(bus);
                zPHASO_BE.register(bus);
        }

        // -----------------------------------------------------------------------------------------------------------//
        public static final DeferredRegister<BlockEntityType<?>> zPHASO_BE = DeferredRegister
                        .create(Registries.BLOCK_ENTITY_TYPE, Main.ID);
        public static final DeferredRegister.Blocks zPHASO_BLK = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Items zPHASO_ITM = DeferredRegister.createItems(Main.ID);

        // -----------------------------------------------------------------------------------------------------------//

        // public static DeferredHolder<Block, ?> PHASORITE_POWERED = zPHASO_BLK.register(
        //                 Constants.Budding.Phasorite,
        //                 () -> new PhasoriteBlock());

        // // -----------------------------------------------------------------------------------------------------------//
        // public static DeferredHolder<Item, BlockItem> PHASORITE_POWERED_ITEM = zPHASO_ITM
        //                 .registerSimpleBlockItem(PHASORITE_POWERED);
        // // -----------------------------------------------------------------------------------------------------------//

        // public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PHASORITE_POWERED_BE = zPHASO_BE
        //                 .register(Constants.Budding.Phasorite, () -> Builder.of(PhasoriteBE::new,
        //                                 PHASORITE_POWERED.get())
        //                                 .build(null));
}