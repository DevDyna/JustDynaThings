package com.devdyna.justdynathings.init.builder.repair_anvils.celestigem;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.be.EnergyMachine;
import com.devdyna.justdynathings.api.repair_anvils.FunctionalAnvilBE;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import com.devdyna.justdynathings.init.types.zItemTags;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.JDTRegistration;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class CelestiGemAnvilBE extends FunctionalAnvilBE implements EnergyMachine {

    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);

    public CelestiGemAnvilBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        this.MACHINE_SLOTS = 1;
    }

    public CelestiGemAnvilBE(BlockPos pos, BlockState state) {
        this(zBlockEntities.CELESTIGEM_ANVIL.get(), pos, state);
    }

    @Override
    public PoweredMachineContainerData getContainerData() {
        return poweredMachineData;
    }

    @Override
    public MachineEnergyStorage getEnergyStorage() {
        return getData(JDTRegistration.ENERGYSTORAGE_MACHINES);
    }

    @Override
    public int getStandardEnergyCost() {
        return Config.ANVILS_CELESTIGEM_FE_RATE.get();
    }

    @Override
    public int getMaxEnergy() {
        return Config.ANVILS_CELESTIGEM_FE_CAPACITY.get();
    }

    @Override
    public void whenToolValid() {

        if (!getEnergyStorage().canExtract())
            return;

        extractFEWhenPossible();

        setDurabilityBatch(1);

    }

    @Override
    public TagKey<Item> getDenyTag() {
        return zItemTags.CELESTIGEM_DENY;
    }

    @Override
    public Boolean getSoundConfig() {
        return Config.ANVIL_CELESTIGEM_SOUND_EVENT.get();
    }

    @Override
    public Boolean ignoreDelay() {
        return Config.ANVIL_CELESTIGEM_IGNORE_DELAY.get();
    }

}