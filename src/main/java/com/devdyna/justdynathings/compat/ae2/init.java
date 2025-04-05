package com.devdyna.justdynathings.compat.ae2;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.common.registry.core.builders.budding.BuddingBlock;

import appeng.core.definitions.AEBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

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
        public static DeferredHolder<Block, BuddingBlock> AE2_POWERED = zAE_BLK.register(
                        Constants.Material.Budding.Powered.id + "_" + Constants.Material.Budding.Certus.id,
                        () -> new BuddingBlock(
                                        AEBlocks.SMALL_QUARTZ_BUD.block(),
                                        AEBlocks.MEDIUM_QUARTZ_BUD.block(),
                                        AEBlocks.LARGE_QUARTZ_BUD.block(),
                                        AEBlocks.QUARTZ_CLUSTER.block()));

        // -----------------------------------------------------------------------------------------------------------//
        public static DeferredHolder<Item, BlockItem> AE2_POWERED_ITEM = zAE_ITM
                        .registerSimpleBlockItem(AE2_POWERED);
        // -----------------------------------------------------------------------------------------------------------//
}