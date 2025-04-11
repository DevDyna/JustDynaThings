package com.devdyna.justdynathings.compat.ae2;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.compat.ae2.builder.CertusBE;
import com.devdyna.justdynathings.compat.ae2.builder.CertusBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.Builder;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@SuppressWarnings("null")
public class init {

        public static void register(IEventBus bus) {
                zAE_BLK.register(bus);
                zAE_ITM.register(bus);
                zAE_BE.register(bus);
        }

        // -----------------------------------------------------------------------------------------------------------//
        public static final DeferredRegister<BlockEntityType<?>> zAE_BE = DeferredRegister
                        .create(Registries.BLOCK_ENTITY_TYPE, Main.ID);
        public static final DeferredRegister.Blocks zAE_BLK = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Items zAE_ITM = DeferredRegister.createItems(Main.ID);

        // -----------------------------------------------------------------------------------------------------------//
        public static DeferredHolder<Block, ?> AE2_POWERED = zAE_BLK.register(
                        Constants.Budding.Certus,
                        () -> new CertusBlock());

        // -----------------------------------------------------------------------------------------------------------//
        public static DeferredHolder<Item, BlockItem> AE2_POWERED_ITEM = zAE_ITM
                        .registerSimpleBlockItem(AE2_POWERED);
        // -----------------------------------------------------------------------------------------------------------//

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> AE2_POWERED_BE = zAE_BE
                        .register(Constants.Budding.Certus, () -> Builder.of(CertusBE::new,
                                        AE2_POWERED.get())
                                        .build(null));
}