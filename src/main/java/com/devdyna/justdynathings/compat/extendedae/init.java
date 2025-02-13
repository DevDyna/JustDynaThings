package com.devdyna.justdynathings.compat.extendedae;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.common.registry.builder.budding.BuddingBlock;
import com.glodblock.github.extendedae.common.EAESingletons;
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
        public static DeferredHolder<Block, BuddingBlock> EXTENDED_POWERED = zEXTAE_BLK.register(
                        Constants.Material.Budding.Powered.id + "_" + Constants.Material.Budding.Entro.id,
                        () -> new BuddingBlock(
                                        Constants.FEBudding.FECost.value,
                                        Constants.FEBudding.FECapacity.value,
                                        Constants.FEBudding.FLCost.value,
                                        Constants.FEBudding.FLCapacity.value,
                                        EAESingletons.ENTRO_BUD_SMALL,
                                        EAESingletons.ENTRO_BUD_MEDIUM,
                                        EAESingletons.ENTRO_BUD_LARGE,
                                        EAESingletons.ENTRO_CLUSTER));

        // -----------------------------------------------------------------------------------------------------------//
        public static DeferredHolder<Item, BlockItem> EXTENDED_POWERED_ITEM = zEXTAE_ITM
                        .registerSimpleBlockItem(EXTENDED_POWERED);

}