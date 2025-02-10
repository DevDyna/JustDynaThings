package com.devdyna.justdynathings.compat.ae2;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.common.registry.builder.budding.BuddingBlock;
import com.devdyna.justdynathings.common.registry.builder.budding.DecayBuddingBlock;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;
import com.direwolf20.justdirethings.setup.Registration;

import appeng.core.definitions.AEBlocks;
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
        public static DeferredHolder<Block, BuddingBlock> AE2_FLAWLESS = zAE_BLK.register(
                        Constants.Material.Budding.Flawless.id + Constants.Material.Budding.Certus.id,
                        () -> new BuddingBlock(
                                        Constants.FEBudding.FECost.value,
                                        Constants.FEBudding.FECapacity.value,
                                        Constants.FEBudding.FLCost.value,
                                        Constants.FEBudding.FLCapacity.value,
                                        AEBlocks.SMALL_QUARTZ_BUD.block(),
                                        AEBlocks.MEDIUM_QUARTZ_BUD.block(),
                                        AEBlocks.LARGE_QUARTZ_BUD.block(),
                                        AEBlocks.QUARTZ_CLUSTER.block()));

        public static DeferredHolder<Block, DecayBuddingBlock> AE2_FLAWED = zAE_BLK.register(

                        Constants.Material.Budding.Flawed.id + Constants.Material.Budding.Certus.id,
                        () -> new DecayBuddingBlock(
                                        Constants.FEBudding.FECost.value,
                                        Constants.FEBudding.FECapacity.value,
                                        Constants.FEBudding.FLCost.value,
                                        Constants.FEBudding.FLCapacity.value,
                                        AEBlocks.SMALL_QUARTZ_BUD.block(),
                                        AEBlocks.MEDIUM_QUARTZ_BUD.block(),
                                        AEBlocks.LARGE_QUARTZ_BUD.block(),
                                        AEBlocks.QUARTZ_CLUSTER.block()));
        // -----------------------------------------------------------------------------------------------------------//
        public static DeferredHolder<Item, BlockItem> AE2_FLAWLESS_ITEM = zAE_ITM
                        .registerSimpleBlockItem(AE2_FLAWLESS);
        public static DeferredHolder<Item, BlockItem> AE2_FLAWED_ITEM = zAE_ITM
                        .registerSimpleBlockItem(AE2_FLAWED);
        // -----------------------------------------------------------------------------------------------------------//
        // public static DeferredHolder<BlockEntityType<?>, BlockEntityType<BuddingBE>>
        // AE2_FLAWLESS_BE = zAE_BE
        // .register(
        // Constants.Material.Budding.Flawless.id
        // + Constants.Material.Budding.Certus.id + "_"
        // + Constants.BlockEntity.id,
        // () -> Builder.of(BuddingBE::new, AE2_FLAWLESS.get())
        // .build(null));

        // public static DeferredHolder<BlockEntityType<?>,
        // BlockEntityType<DecayBuddingBE>> AE2_FLAWED_BE = zAE_BE
        // .register(
        // Constants.Material.Budding.Flawed.id
        // + Constants.Material.Budding.Certus.id + "_"
        // + Constants.BlockEntity.id,
        // () -> Builder.of(DecayBuddingBE::new, AE2_FLAWED.get())
        // .build(null));

        // -----------------------------------------------------------------------------------------------------------//
        public static void regCap(RegisterCapabilitiesEvent event) {
                event.registerBlock(EnergyStorage.BLOCK, (level, pos, state, be,
                                side) -> be instanceof PoweredMachineBE
                                                ? be.getData(Registration.ENERGYSTORAGE_MACHINES)
                                                : null,
                                AE2_FLAWED.get(), AE2_FLAWLESS.get());

                event.registerBlock(FluidHandler.BLOCK,
                                (level, pos, state, be, side) -> be instanceof FluidMachineBE
                                                ? be.getData(Registration.PARADOX_FLUID_HANDLER)
                                                : null,
                                AE2_FLAWED.get(), AE2_FLAWLESS.get());
        }
}