package com.devdyna.justdynathings.compat.phasorite;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.common.registry.builder.budding.BuddingBlock;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;
import com.direwolf20.justdirethings.setup.Registration;

import xyz.milosworks.phasoritenetworks.init.PNBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.capabilities.Capabilities.EnergyStorage;
import net.neoforged.neoforge.capabilities.Capabilities.FluidHandler;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
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

        public static DeferredHolder<Block, BuddingBlock> PHASORITE_FLAWLESS = zPHASO_BLK.register(
                        Constants.Material.Budding.Flawless.id
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
        public static DeferredHolder<Item, BlockItem> PHASORITE_FLAWLESS_ITEM = zPHASO_ITM
                        .registerSimpleBlockItem(PHASORITE_FLAWLESS);

        // -----------------------------------------------------------------------------------------------------------//
        public static void regCap(RegisterCapabilitiesEvent event) {
                event.registerBlock(EnergyStorage.BLOCK, (level, pos, state, be,
                                side) -> be instanceof PoweredMachineBE
                                                ? be.getData(Registration.ENERGYSTORAGE_MACHINES)
                                                : null,
                                PHASORITE_FLAWLESS.get());

                event.registerBlock(FluidHandler.BLOCK,
                                (level, pos, state, be, side) -> be instanceof FluidMachineBE
                                                ? be.getData(Registration.PARADOX_FLUID_HANDLER)
                                                : null,
                                PHASORITE_FLAWLESS.get());
        }
}