package com.devdyna.justdynathings.registry.builders.thermo;

import java.util.HashMap;
import java.util.Map;

import com.devdyna.justdynathings.config.common;
import com.devdyna.justdynathings.config.startup;
import com.devdyna.justdynathings.datamaps.zDataMaps;
import com.devdyna.justdynathings.datamaps.RecordMap.ThermoBlockHeatSource;
import com.devdyna.justdynathings.datamaps.RecordMap.ThermoFluidCoolant;
import com.devdyna.justdynathings.registry.interfaces.be.EnergyCharger;
import com.devdyna.justdynathings.registry.interfaces.be.EnergyGenerator;
import com.devdyna.justdynathings.registry.interfaces.be.FluidMachine;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.Actions;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.RedstoneControlledBE;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.Registration;
import com.direwolf20.justdirethings.util.interfacehelpers.RedstoneControlData;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.capabilities.BlockCapabilityCache;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

@SuppressWarnings({ "null", "deprecation" })
public class ThermoBE extends BaseMachineBE
        implements FluidMachine, EnergyGenerator, RedstoneControlledBE, EnergyCharger {

    public RedstoneControlData redstoneControlData = new RedstoneControlData();
    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);
    public final FluidContainerData fluidContainerData = new FluidContainerData(this);
    private final Map<Direction, BlockCapabilityCache<IEnergyStorage, Direction>> cache = new HashMap<>();

    public ThermoBE(BlockEntityType<?> type, BlockPos pos, BlockState b) {
        super(type, pos, b);
        MACHINE_SLOTS = 1;
    }

    public ThermoBE(BlockPos pos, BlockState b) {
        this(zBlockEntities.THERMOGEN.get(), pos, b);
    }

    @Override
    public void tickServer() {

        var heat = getHeatBlock().getBlock().builtInRegistryHolder()
                .getData(zDataMaps.THERMO_HEAT_SOURCE);

        var coolant = getFluidStack().getFluidHolder().getData(zDataMaps.THERMO_COOLANT);

        updateBlock(heat != null && coolant != null);

        if (heat != null && coolant != null)
            if (isActiveRedstone() && canExtractMB() && canRecieveFE()) {
                if (getBlockState().getValue(zProperties.ACTIVE).booleanValue()) {

                    extractMBWhenPossible((int) ((125 / coolant.coolantEfficiency())));

                    increaseFEWhenPossible((int) (125 * coolant.coolantEfficiency() * heat.heatEfficiency()));
                }
                if (canExtractFE())
                    Actions.providePowerAdjacent(level,getBlockPos(),cache,getEnergyStored());
            }

        if (isActiveRedstone() && canExtractFE())
            charge(getMachineHandler().getStackInSlot(0), getEnergyStorage());
    }

    public void updateBlock(boolean state) {
        level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(zProperties.ACTIVE, state));
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
        return getData(Registration.MACHINE_FLUID_HANDLER);
    }

    @Override
    public MachineEnergyStorage getEnergyStorage() {
        return getData(Registration.ENERGYSTORAGE_GENERATORS);
    }

    @Override
    public ContainerData getContainerData() {
        return poweredMachineData;
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
    public int getStandardEnergyCost() {
        return 0;
    }

    @Override
    public int getMaxEnergy() {
        return common.THERMOGEN_FE_CAPACITY.getAsInt();
    }

    @Override
    public int getMaxMB() {
        return common.THERMOGEN_MB_CAPACITY.getAsInt();
    }

    @Override
    public int getStandardFluidCost() {
        return 0;
    }

}
