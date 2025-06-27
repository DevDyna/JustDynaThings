package com.devdyna.justdynathings.registry.builders.thermo;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.datamaps.zDataMaps;
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
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

@SuppressWarnings({ "null", "deprecation" })
public class ThermoBE extends BaseMachineBE implements FluidMachine, EnergyGenerator, RedstoneControlledBE {

    public RedstoneControlData redstoneControlData = new RedstoneControlData();
    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);
    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public ThermoBE(BlockEntityType<?> type, BlockPos pos, BlockState b) {
        super(type, pos, b);
    }

    public ThermoBE(BlockPos pos, BlockState b) {
        this(zBlockEntities.THERMOGEN.get(), pos, b);
    }

    @Override
    public void tickServer() {

        var heat = getHeatBlock().getBlock().builtInRegistryHolder()
                .getData(zDataMaps.THERMO_HEAT_SOURCE);

        var coolant = getFluidStack().getFluidHolder().getData(zDataMaps.THERMO_COOLANT);

        updateBlock(heat != null, coolant != null);

        if (heat != null && coolant != null)
            if (isActiveRedstone() && canExtractMB() && canRecieveFE()) {
                if (getBlockState().getValue(zProperties.ACTIVE).booleanValue()) {

                    extractMBWhenPossible((int) (1 / (coolant.coolantEfficiency() * 10)));

                    increaseFEWhenPossible((int) ((1 / coolant.coolantEfficiency()) * 1250 * heat.heatEfficiency()));
                }
                if (canExtractFE())
                    Actions.providePowerAdjacent(getBlockPos(), level, getEnergyStored());
            }
    }

    /**
     * TODO
     * <br/>
     * <br/>
     * update the blockstate properties
     * Credits: Thanks "@S4lvious" to optimize block update logic
     * <br/>
     * <br/>
     * TO verify
     */
    public void updateBlock(boolean heat, boolean coolant) {
        if (getBlockState().getValue(zProperties.ACTIVE) != (heat || coolant))
            level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(zProperties.ACTIVE, coolant && heat));
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
        return Config.THERMOGEN_FE_CAPACITY.get();
    }

    @Override
    public int getMaxMB() {
        return Config.THERMOGEN_MB_CAPACITY.get();
    }

    @Override
    public int getStandardFluidCost() {
        return 0;
    }

}
