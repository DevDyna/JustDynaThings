package com.devdyna.justdynathings.registry.builders.functional_anvils.energy;

import com.devdyna.justdynathings.registry.builders.functional_anvils.CAnvilBE;
import com.devdyna.justdynathings.registry.interfaces.be.EnergyMachine;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zItemTags;
import com.devdyna.justdynathings.utils.Actions;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PoweredAnvilBE extends CAnvilBE implements EnergyMachine {

    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);

    public PoweredAnvilBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        this.MACHINE_SLOTS = 2;
        this.condition = canExtractFE() && getMachineHandler().getStackInSlot(0).isDamageableItem()
                && getMachineHandler().getStackInSlot(0).isDamaged()
                && !getMachineHandler().getStackInSlot(0).is(zItemTags.CELESTIGEM_DENY);
    }

    public PoweredAnvilBE(BlockPos pos, BlockState state) {
        this(zBlockEntities.POWERED_ANVIL.get(), pos, state);
    }

    public void runActions() {
        extractFEWhenPossible();
        Actions.repairItem(getMachineHandler().getStackInSlot(0));
    }

    @Override
    public PoweredMachineContainerData getContainerData() {
        return poweredMachineData;
    }

    @Override
    public MachineEnergyStorage getEnergyStorage() {
        return getData(Registration.ENERGYSTORAGE_MACHINES);
    }

    @Override
    public int getStandardEnergyCost() {
        return FErate * 10;
    }

    @Override
    public int getMaxEnergy() {
        return FEsize * 10;
    }

}