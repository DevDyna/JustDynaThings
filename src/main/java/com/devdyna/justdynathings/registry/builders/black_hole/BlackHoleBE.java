package com.devdyna.justdynathings.registry.builders.black_hole;

import com.devdyna.justdynathings.registry.interfaces.be.EnergyMachine;
import com.devdyna.justdynathings.registry.interfaces.be.FluidMachine;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.RedstoneControlledBE;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.Registration;
import com.direwolf20.justdirethings.util.interfacehelpers.RedstoneControlData;

import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

public class BlackHoleBE extends BaseMachineBE implements EnergyMachine, FluidMachine, RedstoneControlledBE {

    public final RedstoneControlData redstoneControlData = new RedstoneControlData();
    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);
    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public BlackHoleBE(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
        MACHINE_SLOTS = 1;
    }

    public BlackHoleBE(BlockPos pos, BlockState blockState) {
        this(zBlockEntities.BLACKHOLE.get(), pos, blockState);
    }

    @Override
    public void tickServer() {

        if (isActiveRedstone()) {
            ItemStack item = getMachineHandler().getStackInSlot(0);
            if (!item.isEmpty())
                item.shrink(item.getCount());

            extractFEWhenPossible();
            extractMBWhenPossible();
        }

    }

    @Override
    public ContainerData getContainerData() {
        return poweredMachineData;
    }

    @Override
    public MachineEnergyStorage getEnergyStorage() {
        return getData(Registration.ENERGYSTORAGE_MACHINES);
    }

    @Override
    public ContainerData getFluidContainerData() {
        return fluidContainerData;
    }

    @Override
    public FluidTank getFluidTank() {
        return getData(Registration.MACHINE_FLUID_HANDLER);
    }

    @Override
    public int getStandardFluidCost() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getMaxMB() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getStandardEnergyCost() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getMaxEnergy() {
        return Integer.MAX_VALUE;
    }

    @Override
    public BlockEntity getBlockEntity() {
        return this;
    }

    @Override
    public RedstoneControlData getRedstoneControlData() {
        return redstoneControlData;
    }

}
