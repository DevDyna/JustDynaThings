package com.devdyna.justdynathings.init.builder.ticker;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import com.devdyna.justdynathings.init.types.zBlockTags;
import com.devdyna.justdynathings.init.types.zProperties;
import com.devdyna.justdynathings.interfaces.be.EnergyMachine;
import com.devdyna.justdynathings.interfaces.be.FluidMachine;
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
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

@SuppressWarnings("null")
public class TickerBE extends BaseMachineBE implements EnergyMachine, FluidMachine, RedstoneControlledBE {
    public RedstoneControlData redstoneControlData = new RedstoneControlData();
    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);
    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public TickerBE(BlockEntityType<?> p, BlockPos b, BlockState s) {
        super(p, b, s);
    }

    public TickerBE(BlockPos p, BlockState s) {
        this(zBlockEntities.TICKER.get(), p, s);
    }

    @Override
    public void tickServer() {
        super.tickServer();

        BlockPos pos = getBlockPos()
                .relative(getBlockState()
                        .getValue(BlockStateProperties.FACING));

        checkState(pos);

        if (getBlockState().getValue(zProperties.ACTIVE) && blockValid(pos)) {

            playSound(pos);

            extractFEWhenPossible();
            extractMBWhenPossible();

            if (level instanceof ServerLevel serverLevel &&
                    MiscTools.isValidTickAccelBlock(serverLevel, level.getBlockState(pos),
                            level.getBlockEntity(pos)))
                MiscTools.doExtraTicks(serverLevel, pos, Config.TICKER_TICK_RATE.get());

        }

    }

    public void checkState(BlockPos pos) {
        level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(zProperties.ACTIVE,
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
        return Config.TICKER_FE_RATE.get();
    }

    @Override
    public int getMaxEnergy() {
        return Config.TICKER_FE_CAPACITY.get();
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
        return Config.TICKER_MB_RATE.get();
    }

    @Override
    public int getMaxMB() {
        return Config.TICKER_MB_CAPACITY.get();
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