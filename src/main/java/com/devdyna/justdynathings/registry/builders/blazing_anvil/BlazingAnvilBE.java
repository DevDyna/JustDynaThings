package com.devdyna.justdynathings.registry.builders.blazing_anvil;

import com.devdyna.justdynathings.registry.interfaces.be.EnergyMachine;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zItemTags;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.Actions;
import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.RedstoneControlledBE;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.Registration;
import com.direwolf20.justdirethings.util.interfacehelpers.RedstoneControlData;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("null")
public class BlazingAnvilBE extends BaseMachineBE implements RedstoneControlledBE, EnergyMachine {

    public final RedstoneControlData redstoneControlData = new RedstoneControlData();
    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);

    public BlazingAnvilBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        MACHINE_SLOTS = 1;
    }

    public BlazingAnvilBE(BlockPos pos, BlockState state) {
        this(zBlockEntities.BLAZING_ANVIL.get(), pos, state);
    }

    @Override
    public RedstoneControlData getRedstoneControlData() {
        return redstoneControlData;
    }

    @Override
    public BlockEntity getBlockEntity() {
        return this;
    }

    @Override
    public void tickClient() {
    }

    @Override
    public void tickServer() {
        if (isActiveRedstone()) {
            checkState();
            if (getBlockState().getValue(zProperties.ACTIVE).booleanValue()) {
                extractFEWhenPossible();
                Actions.repairItem(getMachineHandler().getStackInSlot(0));
                applySound();
            }
        }
    }

    public void checkState() {
        level.setBlockAndUpdate(getBlockPos(),
                getBlockState().setValue(zProperties.ACTIVE,
                        canExtractFE() && getMachineHandler().getStackInSlot(0).isDamageableItem()
                                && getMachineHandler().getStackInSlot(0).isDamaged()
                                && !getMachineHandler().getStackInSlot(0).is(zItemTags.BLAZINGANVIL_DENY)));
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

    public void applySound() {
        if (LevelUtil.chance(5, level))
            level.playSound(null, getBlockPos(),
                    LevelUtil.chance(75, level)
                            ? SoundEvents.GRINDSTONE_USE
                            : LevelUtil.chance(50, level)
                                    ? SoundEvents.SMITHING_TABLE_USE
                                    : SoundEvents.ANVIL_USE,
                    SoundSource.BLOCKS, (level.random.nextInt(10) + 1) * 0.01F,
                    level.random.nextInt(50) + 1 * 0.01F);
    }


}