package com.devdyna.justdynathings.init.builder.repair_anvils.eclipsealloy;


import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.be.EnergyMachine;
import com.devdyna.justdynathings.api.be.FluidMachine;
import com.devdyna.justdynathings.api.repair_anvils.CAnvilBE;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.capabilities.JustDireFluidTank;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.JDTRegistration;

import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class EclipseAlloyAnvilBE extends CAnvilBE implements EnergyMachine, FluidMachine {

    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);
    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public EclipseAlloyAnvilBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        this.MACHINE_SLOTS = 1;
    }

    public EclipseAlloyAnvilBE(BlockPos pos, BlockState state) {
        this(zBlockEntities.ECLIPSEALLOY_ANVIL.get(), pos, state);
    }

    @Override
    public void tickServer() {
        super.tickServer();
        //TODO
        // var fluid = getFluidStack().getFluidHolder().getData(zDataMaps.ECLIPSEALLOY_FLUID);
        // var tool = getMachineHandler().getStackInSlot(0);
        // if (isActiveRedstone()) // getMachineHandler() only work inside tick event!
        //     if (canExtractFE() && tool.isDamageableItem() && !tool.is(zItemTags.ECLIPSE_ALLOY_ANVIL_DENY)
        //             && tool.isDamaged()) {
        //         if (CommonConfig.ANVIL_ECLIPSEALLOY_SOUND_EVENT.get())
        //             applySound();

        //         if (fluid != null && canExtractMB() && getEnergyStored() >= getDamageLimit()) {
        //             if (tool.getMaxDamage() >= getDamageLimit()
        //                     && tool.getDamageValue() >= tool.getMaxDamage() / fluid.percentuage())
        //                 Actions.repairItem(tool,
        //                         (int) (tool.getMaxDamage() / fluid.percentuage()));
        //             else
        //                 Actions.repairItem(tool, tool.getDamageValue());

        //             extractMB((int) (4*fluid.percentuage()));
        //             extractEnergy((int) (getStandardEnergyCost() * fluid.percentuage() / 2),
        //                     remove);

        //         } else {
        //             extractFEWhenPossible();
        //             Actions.repairItem(tool);
        //         }
        //     }
    }

    @Override
    public PoweredMachineContainerData getContainerData() {
        return poweredMachineData;
    }

    @Override
    public MachineEnergyStorage getEnergyStorage() {
        return getData(JDTRegistration.ENERGYSTORAGE_MACHINES);
    }

    @Override
    public ContainerData getFluidContainerData() {
        return fluidContainerData;
    }

    @Override
    public JustDireFluidTank getFluidTank() {
        return getData(JDTRegistration.MACHINE_FLUID_HANDLER);
    }

    @Override
    public int getStandardEnergyCost() {
        return Config.ANVILS_ECLIPSEALLOY_FE_RATE.get();
    }

    @Override
    public int getMaxEnergy() {
        return Config.ANVILS_ECLIPSEALLOY_FE_CAPACITY.get();
    }

    @Override
    public int getMaxMB() {
        return Config.ANVILS_ECLIPSEALLOY_MB_CAPACITY.get();
    }

    @Override
    public int getStandardFluidCost() {
        return Config.ANVILS_ECLIPSEALLOY_MB_RATE.get();
    }

    public int getDamageLimit() {
        return Config.ANVILS_ECLIPSEALLOY_DAMAGE_LIMIT.get();
    }
}