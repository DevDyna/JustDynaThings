package com.devdyna.justdynathings.compat.extendedae;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.common.registry.builder.budding.BuddingBlock;
import com.devdyna.justdynathings.common.registry.builder.budding.DecayBuddingBlock;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;
import com.direwolf20.justdirethings.setup.Registration;
import com.glodblock.github.extendedae.common.EAESingletons;

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
        public static DeferredHolder<Block, BuddingBlock> EXTENDED_FLAWLESS = zEXTAE_BLK.register(
                        Constants.Material.Budding.Flawless.id + Constants.Material.Budding.Entro.id,
                        () -> new BuddingBlock(
                                        Constants.FEBudding.FECost.value,
                                        Constants.FEBudding.FECapacity.value,
                                        Constants.FEBudding.FLCost.value,
                                        Constants.FEBudding.FLCapacity.value,
                                        EAESingletons.ENTRO_BUD_SMALL,
                                        EAESingletons.ENTRO_BUD_MEDIUM,
                                        EAESingletons.ENTRO_BUD_LARGE,
                                        EAESingletons.ENTRO_CLUSTER));

        public static DeferredHolder<Block, DecayBuddingBlock> EXTENDED_FLAWED = zEXTAE_BLK.register(

                        Constants.Material.Budding.Flawed.id + Constants.Material.Budding.Entro.id,
                        () -> new DecayBuddingBlock(
                                        Constants.FEBudding.FECost.value,
                                        Constants.FEBudding.FECapacity.value,
                                        Constants.FEBudding.FLCost.value,
                                        Constants.FEBudding.FLCapacity.value,
                                        EAESingletons.ENTRO_BUD_SMALL,
                                        EAESingletons.ENTRO_BUD_MEDIUM,
                                        EAESingletons.ENTRO_BUD_LARGE,
                                        EAESingletons.ENTRO_CLUSTER));
        // -----------------------------------------------------------------------------------------------------------//
        public static DeferredHolder<Item, BlockItem> EXTENDED_FLAWLESS_ITEM = zEXTAE_ITM
                        .registerSimpleBlockItem(EXTENDED_FLAWLESS);
        public static DeferredHolder<Item, BlockItem> EXTENDED_FLAWED_ITEM = zEXTAE_ITM
                        .registerSimpleBlockItem(EXTENDED_FLAWED);
        // -----------------------------------------------------------------------------------------------------------//

        public static void regCap(RegisterCapabilitiesEvent event) {
                event.registerBlock(EnergyStorage.BLOCK, (level, pos, state, be,
                                side) -> be instanceof PoweredMachineBE
                                                ? be.getData(Registration.ENERGYSTORAGE_MACHINES)
                                                : null,
                                EXTENDED_FLAWED.get(), EXTENDED_FLAWLESS.get());

                event.registerBlock(FluidHandler.BLOCK,
                                (level, pos, state, be, side) -> be instanceof FluidMachineBE
                                                ? be.getData(Registration.PARADOX_FLUID_HANDLER)
                                                : null,
                                EXTENDED_FLAWED.get(), EXTENDED_FLAWLESS.get());
        }

}