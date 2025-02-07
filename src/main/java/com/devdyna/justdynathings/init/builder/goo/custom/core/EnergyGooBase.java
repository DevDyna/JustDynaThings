package com.devdyna.justdynathings.init.builder.goo.custom.core;

import com.direwolf20.justdirethings.common.blockentities.basebe.GooBlockBE_Base;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;
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
import static com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base.ALIVE;

public class EnergyGooBase extends GooBlockBE_Base implements PoweredMachineBE {

    public final PoweredMachineContainerData poweredMachineData;
    private int RF_COST = 200;

    public EnergyGooBase(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        poweredMachineData = new PoweredMachineContainerData(this);
    }

    public EnergyGooBase(BlockEntityType<?> type, BlockPos pos, BlockState state,int cost) {
        this(type, pos, state);
        RF_COST = cost;
    }

    @Override
    public void tickServer() {
        this.checkEnergy();
        this.checkSides();
        this.tickCounters();
        setChanged();
    }

    @SuppressWarnings("null")
    public void checkEnergy() {
        level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(ALIVE, getEnergyStored() > RF_COST));
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
        level.playSound(null, getBlockPos(), SoundEvents.SCULK_BLOCK_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);

        if (level != null && !level.isClientSide) {

            if (getBlockState().getValue(ALIVE)) {

                extractEnergy(getEnergyStored() <= RF_COST ? getEnergyStored() : RF_COST,
                        false);

                level.playSound(null, getBlockPos(),
                        getEnergyStored() <= RF_COST ? SoundEvents.VEX_DEATH : SoundEvents.SCULK_BLOCK_SPREAD,
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
        return 500;
    }

}
