package com.devdyna.justdynathings.init.builder.black_hole;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.be.EnergyMachine;
import com.devdyna.justdynathings.api.be.FluidMachine;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.RedstoneControlledBE;
import com.direwolf20.justdirethings.common.capabilities.JustDireFluidTank;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.direwolf20.justdirethings.util.interfacehelpers.RedstoneControlData;

import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.transfer.transaction.Transaction;

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
        super.tickServer();
        if (Config.BLACKHOLE_KEEP_STORAGE.get() ? isActiveRedstone() : true) {
            if(!getMachineHandler().getResource(0).isEmpty())
            try (var tx = Transaction.openRoot()) {
                getMachineHandler().extract(0,getMachineHandler().getResource(0) ,
                        getMachineHandler().getAmountAsInt(0), tx);
                tx.commit();
            }

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
    public BlockEntity getBlockEntity() {
        return this;
    }

    @Override
    public RedstoneControlData getRedstoneControlData() {
        return redstoneControlData;
    }

    @Override
    public int getStandardFluidCost() {
        return Config.BLACKHOLE_MB_COST.get();
    }

    @Override
    public int getMaxMB() {
        return Config.BLACKHOLE_MB_CAPACITY.get();
    }

    @Override
    public int getStandardEnergyCost() {
        return Config.BLACKHOLE_FE_COST.get();
    }

    @Override
    public int getMaxEnergy() {
        return Config.BLACKHOLE_FE_CAPACITY.get();
    }

}
