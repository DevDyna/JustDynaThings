package com.devdyna.justdynathings.common.registry.builder.ticker;

import static com.devdyna.justdynathings.common.registry.builder.ticker.TickerBlock.ACTIVE;

import com.devdyna.justdynathings.common.registry.Material;
import com.devdyna.justdynathings.common.registry.core.interfaces.be.SmartFEMachine;
import com.devdyna.justdynathings.common.registry.core.interfaces.be.SmartMBMachine;
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

    private int FEcost;
    private int FEcapacity;
    private int MBcost;
    private int MBcapacity;

    /**
     * DONT USE THIS ON BE REGISTRATION
     */
    public TickerBE(BlockEntityType<?> p, BlockPos b, BlockState s) {
        super(p, b, s);
    }

    public TickerBE(BlockPos p, BlockState s, int FEcapacity, int FEcost, int MBcapacity, int MBcost) {
        this(Material.TICKER_BE.get(), p, s);
        this.FEcost = FEcost;
        this.FEcapacity = FEcapacity;
        this.MBcost = MBcost;
        this.MBcapacity = MBcapacity;
    }

    /**
     * DONT USE THIS ON BE REGISTRATION
     */
    public TickerBE(BlockPos p, BlockState s) {
        this(Material.TICKER_BE.get(), p, s);
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

        if (getBlockState().getValue(ACTIVE)) {

            Actions.tickWhenRandom(pos, level);

            playSound(pos);

            extractFEWhenPossible();
            extractMBWhenPossible();

        }
    }

    public void checkState(BlockPos pos) {
        level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(ACTIVE,
                !level.getBlockState(pos).is(Material.TICKER_DENY) && validEnergy() && validFluid()));
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
        return FEcost;
    }

    @Override
    public int getMaxEnergy() {
        return FEcapacity;
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
        return MBcost;
    }

    @Override
    public int getMaxMB() {
        return MBcapacity;
    }

}