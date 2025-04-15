package com.devdyna.justdynathings.registry.builders.generators.thermo;

import com.devdyna.justdynathings.registry.interfaces.be.SmartFEMachine;
import com.devdyna.justdynathings.registry.interfaces.be.SmartMBMachine;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zBlockTags;
import com.devdyna.justdynathings.registry.types.zHandlers;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

@SuppressWarnings("null")
public class ThermoBE extends BaseMachineBE implements SmartMBMachine, SmartFEMachine {

    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);
    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public ThermoBE(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public ThermoBE(BlockPos pos, BlockState blockState) {
        super(zBlockEntities.THERMOGEN.get(), pos, blockState);
    }

    @Override
    public void tickServer() {
        updateBlock();
        if (getBlockState().getValue(zProperties.ACTIVE).booleanValue()) {
            if (getBlockState().getValue(zProperties.COOLED).booleanValue()) {
                increaseFEWhenPossible(FErate * 4);
                extractMBWhenPossible();
            } else {
                increaseFEWhenPossible(FErate);
            }
        }
    }

    /**
     * update the blockstate properties
     */
    public void updateBlock() {
        level.setBlockAndUpdate(getBlockPos(),
                getBlockState().setValue(zProperties.ACTIVE,
                        !isFEfull() && getHeatBlock().is(zBlockTags.THERMO_HEATER))
                        .setValue(zProperties.COOLED, validFluid()));
    }

    public BlockState getHeatBlock() {
        return level.getBlockState(getBlockPos()
                .relative(getBlockState()
                        .getValue(BlockStateProperties.FACING)));
    }

    @Override
    public ContainerData getFluidContainerData() {
        return fluidContainerData;
    }

    @Override
    public FluidTank getFluidTank() {
        return getData(zHandlers.THERMO_FUELS);
    }

    @Override
    public MachineEnergyStorage getEnergyStorage() {
        return getData(Registration.ENERGYSTORAGE_MACHINES);
    }

    @Override
    public ContainerData getContainerData() {
        return poweredMachineData;
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
    public int getMaxMB() {
        return FLsize;
    }

    @Override
    public int getStandardFluidCost() {
        return FLrate;
    }

}
