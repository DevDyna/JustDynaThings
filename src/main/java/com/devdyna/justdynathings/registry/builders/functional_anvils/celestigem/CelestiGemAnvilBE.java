package com.devdyna.justdynathings.registry.builders.functional_anvils.celestigem;

import com.devdyna.justdynathings.Config;
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

public class CelestiGemAnvilBE extends CAnvilBE implements EnergyMachine {

    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);

    public CelestiGemAnvilBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        this.MACHINE_SLOTS = 1;
    }

    public CelestiGemAnvilBE(BlockPos pos, BlockState state) {
        this(zBlockEntities.POWERED_ANVIL.get(), pos, state);
    }

    @Override
    public void tickServer() {
        var tool = getMachineHandler().getStackInSlot(0);
        if (isActiveRedstone()) {
            // getMachineHandler() only work inside tick event!
            if (canExtractFE() && tool.isDamageableItem()
                    && tool.isDamaged() && !tool.is(zItemTags.CELESTIGEM_DENY)) {
                extractFEWhenPossible();
                Actions.repairItem(tool);
                if (Config.ANVIL_CELESTIGEM_SOUND_EVENT.get())
                    applySound();
            }
        }
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
        return Config.ANVILS_CELESTIGEM_FE_RATE.get();
    }

    @Override
    public int getMaxEnergy() {
        return Config.ANVILS_CELESTIGEM_FE_CAPACITY.get();
    }

}