package com.devdyna.justdynathings.init.builder.advanced_energy_transmitter;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.be.FluidMachine;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import com.direwolf20.justdirethings.common.blockentities.EnergyTransmitterBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.capabilities.JustDireFluidTank;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class AdvEnergyTransmitterBE extends EnergyTransmitterBE implements FluidMachine {

    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public AdvEnergyTransmitterBE(BlockPos pPos, BlockState pBlockState) {
        super(zBlockEntities.ADVANCED_ENERGY_TRANSMITTER.get(), pPos, pBlockState);
        this.tickSpeed = Config.ADV_ENERGY_TRANSMITTER_TICK_RATE.get();
    }

    @Override
    public ContainerData getFluidContainerData() {
        return fluidContainerData;
    }

    @Override
    public JustDireFluidTank getFluidTank() {
        return getData(JDTRegistration.PARADOX_FLUID_HANDLER);
    }

    @Override
    public BlockEntity getBlockEntity() {
        return this;
    }

    public int fePerTick() {
        return Config.ADV_ENERGY_TRANSMITTER_FE_RATE.get();
    }

    @Override
    public int getMaxEnergy() {
        return Config.ADV_ENERGY_TRANSMITTER_FE_CAPACITY.get();
    }

    public int calculateLoss(int amtToSend, BlockPos remotePosition) {
        return amtToSend - (int) (Math.floor(amtToSend * (getFELoss()
                * Math.abs(getBlockPos().distManhattan(remotePosition))) / 100));
    }

    public Double getFELoss() {
        return Config.ADV_ENERGY_TRANSMITTER_LOSS.get();
    }

    @Override
    public int getStandardFluidCost() {
        return Config.ADV_ENERGY_TRANSMITTER_MB_COST.get();
    }

    @Override
    public int getMaxMB() {
        return Config.ADV_ENERGY_TRANSMITTER_MB_CAPACITY.get();
    }

    @Override
    public int getTickSpeed() {
        return Config.ADV_ENERGY_TRANSMITTER_TICK_RATE.get();
    }

    @Override
    public void providePower() {

        if (!canExtractMB())
            return;

        extractMBWhenPossible();

        super.providePower();
    }

}
