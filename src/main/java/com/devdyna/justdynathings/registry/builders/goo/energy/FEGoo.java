package com.devdyna.justdynathings.registry.builders.goo.energy;

import com.direwolf20.justdirethings.common.blockentities.basebe.GooBlockBE_Base;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import com.devdyna.justdynathings.config.common;
import com.devdyna.justdynathings.registry.interfaces.be.EnergyMachine;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.LevelUtil;

public class FEGoo extends GooBlockBE_Base implements EnergyMachine {

    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);

    public FEGoo(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void tickServer() {
        checkEnergy();
        checkSides();
        tickCounters();
        setChanged();
    }

    @SuppressWarnings("null")
    public void checkEnergy() {
        level.setBlockAndUpdate(getBlockPos(),
                getBlockState().setValue(zProperties.GOO_ALIVE, canExtractFE()));
    }

    @SuppressWarnings("null")
    @Override
    public void setBlockToTarget(BlockState output, Direction direction) {
        if (output.hasProperty(BlockStateProperties.FACING)) {
            level.setBlockAndUpdate(getBlockPos().relative(direction),
                    output.setValue(BlockStateProperties.FACING, direction));
        } else
            level.setBlockAndUpdate(getBlockPos().relative(direction), output);

        updateSideCounter(direction, -1);
        sidedDurations.put(direction, -1);
        if (common.GOO_FEGOO_SOUND_RECIPE.get())
            level.playSound(null, getBlockPos(), SoundEvents.SCULK_BLOCK_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);

        if (level != null && !level.isClientSide) {

            if (getBlockState().getValue(zProperties.GOO_ALIVE)) {

                extractFEWhenPossible();

                if (LevelUtil.chance(25, level) && common.GOO_FEGOO_SOUND_EXTRA.get())
                    level.playSound(null, getBlockPos(),
                            canExtractFE() ? SoundEvents.RESPAWN_ANCHOR_DEPLETE.value()
                                    : SoundEvents.SCULK_BLOCK_SPREAD,
                            SoundSource.BLOCKS, 1.0F, 0.25F);
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
        return common.GOO_FEGOO_FE_RATE.get() * (common.GOO_FEGOO_FE_RATE_MULTIPLY.get() ? getTier() : 1);
    }

    @Override
    public int getMaxEnergy() {
        return common.GOO_FEGOO_FE_CAPACITY.get() * (common.GOO_FEGOO_FE_CAPACITY_MULTIPLY.get() ? getTier() : 1);
    }

}
