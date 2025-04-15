package com.devdyna.justdynathings.registry.builders.ticker;

import com.devdyna.justdynathings.registry.interfaces.be.SmartFEMachine;
import com.devdyna.justdynathings.registry.interfaces.be.SmartMBMachine;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zBlockTags;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.Actions;
import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

@SuppressWarnings("null")
public class TickerBE extends BaseMachineBE implements SmartFEMachine, SmartMBMachine {

    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);
    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public TickerBE(BlockEntityType<?> p, BlockPos b, BlockState s) {
        super(p, b, s);
    }

    public TickerBE(BlockPos p, BlockState s) {
        this(zBlockEntities.TICKER.get(), p, s);
    }

    @Override
    public void tickClient() {
    }

    @Override
    public void tickServer() {

        BlockPos pos = getBlockPos()
                .relative(getBlockState()
                        .getValue(BlockStateProperties.FACING));

        checkState(pos);

        if (getBlockState().getValue(zProperties.ACTIVE) && blockValid(pos)) {

            Actions.tickWhenRandom(pos, level);

            Actions.tickWhenBE(level, pos);

            playSound(pos);

            extractFEWhenPossible();
            extractMBWhenPossible();

        }
    }

    public void checkState(BlockPos pos) {
        level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(zProperties.ACTIVE,
             validEnergy() && validFluid()));
    }

    public boolean blockValid(BlockPos pos){
        return !level.getBlockState(pos).is(zBlockTags.TICKER_DENY);
    }

    public void playSound(BlockPos pos) {
        level.playLocalSound(pos.getX(), pos.getY(),
                pos.getZ(),
                SoundEvents.AMETHYST_BLOCK_BREAK,
                SoundSource.BLOCKS, 100,
                LevelUtil.getRandomValue(9, level) * 0.1f, true);
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
    public int getStandardEnergyCost() {
        return FErate;
    }

    @Override
    public int getMaxEnergy() {
        return FEsize;
    }

    @Override
    public ContainerData getFluidContainerData() {
        return fluidContainerData;
    }

    @Override
    public FluidTank getFluidTank() {
        return getData(Registration.PARADOX_FLUID_HANDLER);
    }

    @Override
    public int getStandardFluidCost() {
        return FLrate;
    }

    @Override
    public int getMaxMB() {
        return FLsize;
    }

}