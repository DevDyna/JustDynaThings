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
import net.neoforged.neoforge.transfer.energy.EnergyHandler;
import net.neoforged.neoforge.transfer.transaction.Transaction;

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
    public int transmitPowerWithLoss(EnergyHandler sender, EnergyHandler receiver, int amtToSend,
            BlockPos remotePosition) {
        int insert;

        try (var simulated = Transaction.openRoot()) {
            insert = receiver.insert(amtToSend, simulated);
        }

        if (insert <= 0)
            return 0;
        int extract;

        try (var input = Transaction.openRoot()) {
            extract = sender.extract(insert, input);
            input.commit();
        }
        if (extract <= 0)
            return 0;

        if (!canExtractMB())
            return 0;

        extractMBWhenPossible();

        try (var output = Transaction.openRoot()) {
            int inserted = receiver.insert(calculateLoss(extract, remotePosition), output);
            output.commit();
            return inserted;
        }
    }

}
