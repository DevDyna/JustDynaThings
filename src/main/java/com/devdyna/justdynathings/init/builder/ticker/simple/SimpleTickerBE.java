package com.devdyna.justdynathings.init.builder.ticker.simple;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.be.EnergyMachine;
import com.devdyna.justdynathings.api.be.FluidMachine;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import com.devdyna.justdynathings.init.types.zBlockTags;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.RedstoneControlledBE;
import com.direwolf20.justdirethings.common.capabilities.JustDireFluidTank;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.direwolf20.justdirethings.util.MiscTools;
import com.direwolf20.justdirethings.util.interfacehelpers.RedstoneControlData;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class SimpleTickerBE extends BaseMachineBE implements EnergyMachine, FluidMachine, RedstoneControlledBE {
    public RedstoneControlData redstoneControlData = new RedstoneControlData();
    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);
    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public SimpleTickerBE(BlockEntityType<?> p, BlockPos b, BlockState s) {
        super(p, b, s);
    }

    public SimpleTickerBE(BlockPos p, BlockState s) {
        this(zBlockEntities.SIMPLE_TICKER.get(), p, s);
    }

    @Override
    public void tickServer() {
        super.tickServer();

        var pos = getBlockPos()
                .relative(getBlockState()
                        .getValue(SimpleTickerBlock.FACING));

        checkState(pos);

        if (getBlockState().getValue(SimpleTickerBlock.ACTIVE) && blockValid(pos)) {

            playSound(pos);

            extractFEWhenPossible();
            extractMBWhenPossible();

            if (level instanceof ServerLevel serverLevel &&
                    MiscTools.isValidTickAccelBlock(serverLevel, level.getBlockState(pos),
                            level.getBlockEntity(pos)))
                MiscTools.doExtraTicks(serverLevel, pos, getTickerRate());

        }

    }

    public int getTickerRate() {
        return  Config.SIMPLE_TICKER_TICK_RATE.get();
    }

    public void checkState(BlockPos pos) {
        level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(SimpleTickerBlock.ACTIVE,
                canExtractFE() && canExtractMB() && isActiveRedstone()));
    }

    public boolean blockValid(BlockPos pos) {
        return !level.getBlockState(pos).is(zBlockTags.TICKER_DENY);
    }

    public void playSound(BlockPos pos) {
        level.playLocalSound(pos.getX(), pos.getY(),
                pos.getZ(),
                SoundEvents.AMETHYST_BLOCK_BREAK,
                SoundSource.BLOCKS, 100,
                level.getRandom().nextInt(9) * 0.1f, true);
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
    public int getStandardEnergyCost() {
        return Config.SIMPLE_TICKER_FE_RATE.get();
    }

    @Override
    public int getMaxEnergy() {
        return Config.SIMPLE_TICKER_FE_CAPACITY.get();
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
    public int getStandardFluidCost() {
        return Config.SIMPLE_TICKER_MB_RATE.get();
    }

    @Override
    public int getMaxMB() {
        return Config.SIMPLE_TICKER_MB_CAPACITY.get();
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