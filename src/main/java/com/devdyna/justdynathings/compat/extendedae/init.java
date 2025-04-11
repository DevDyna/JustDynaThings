package com.devdyna.justdynathings.compat.extendedae;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.compat.extendedae.builder.EntroBE;
import com.devdyna.justdynathings.compat.extendedae.builder.EntroBlock;
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
                zEXTAE_BLK.register(bus);
                zEXTAE_ITM.register(bus);
                zEXTAE_BE.register(bus);
        }

        // -----------------------------------------------------------------------------------------------------------//
        public static final DeferredRegister<BlockEntityType<?>> zEXTAE_BE = DeferredRegister
                        .create(Registries.BLOCK_ENTITY_TYPE, Main.ID);
        public static final DeferredRegister.Blocks zEXTAE_BLK = DeferredRegister.createBlocks(Main.ID);
        public static final DeferredRegister.Items zEXTAE_ITM = DeferredRegister.createItems(Main.ID);

        // -----------------------------------------------------------------------------------------------------------//
        public static DeferredHolder<Block, ?> EXTENDED_POWERED = zEXTAE_BLK.register(
                        Constants.Budding.Entro,
                        () -> new EntroBlock());

        // -----------------------------------------------------------------------------------------------------------//
        public static DeferredHolder<Item, BlockItem> EXTENDED_POWERED_ITEM = zEXTAE_ITM
                        .registerSimpleBlockItem(EXTENDED_POWERED);
        // -----------------------------------------------------------------------------------------------------------//

        public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> EXTENDED_POWERED_BE = zEXTAE_BE
                        .register(Constants.Budding.Entro, () -> Builder.of(EntroBE::new,
                                        EXTENDED_POWERED.get())
                                        .build(null));
}