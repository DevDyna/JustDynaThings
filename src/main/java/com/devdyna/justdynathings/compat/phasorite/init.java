package com.devdyna.justdynathings.compat.phasorite;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.common.registry.builder.budding.BuddingBlock;
import xyz.milosworks.phasoritenetworks.init.PNBlocks;

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

        public static DeferredHolder<Block, BuddingBlock> PHASORITE_POWERED = zPHASO_BLK.register(
                        Constants.Material.Budding.Powered.id + "_"
                                        + Constants.Material.Budding.Phasorite.id,
                        () -> new BuddingBlock(
                                        Constants.FEBudding.FECost.value,
                                        Constants.FEBudding.FECapacity.value,
                                        Constants.FEBudding.FLCost.value,
                                        Constants.FEBudding.FLCapacity.value,
                                        PNBlocks.INSTANCE.getSMALL_PHASORITE_BUD(),
                                        PNBlocks.INSTANCE.getMEDIUM_PHASORITE_BUD(),
                                        PNBlocks.INSTANCE.getLARGE_PHASORITE_BUD(),
                                        PNBlocks.INSTANCE.getPHASORITE_CLUSTER()));

        // -----------------------------------------------------------------------------------------------------------//
        public static DeferredHolder<Item, BlockItem> PHASORITE_POWERED_ITEM = zPHASO_ITM
                        .registerSimpleBlockItem(PHASORITE_POWERED);
}