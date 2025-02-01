package com.devdyna.justdynathings.init.builder.goo.custom;

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
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.IEnergyStorage;
import static com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base.ALIVE;


public class EnergyGooBE_Base extends GooBlockBE_Base implements PoweredMachineBE {

    public final PoweredMachineContainerData poweredMachineData;

    public EnergyGooBE_Base(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        poweredMachineData = new PoweredMachineContainerData(this);
    }

    @SuppressWarnings("null")
    @Override
    public void setBlockToTarget(BlockState output, Direction direction) {
        if (output.hasProperty(BlockStateProperties.FACING)) {
            level.setBlockAndUpdate(getBlockPos().relative(direction),
                    output.setValue(BlockStateProperties.FACING, direction));
        } else {
            level.setBlockAndUpdate(getBlockPos().relative(direction), output);
        }

        updateSideCounter(direction, -1);
        sidedDurations.put(direction, -1);
        level.playSound(null, getBlockPos(), SoundEvents.SCULK_BLOCK_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);

        if (level != null && !level.isClientSide) {
            BlockState state = this.getBlockState();

            IEnergyStorage cap = level.getCapability(Capabilities.EnergyStorage.BLOCK,
                    getBlockPos().relative(Direction.DOWN), Direction.UP);

            if (!(cap instanceof IEnergyStorage))
                return;

            if (!state.getValue(ALIVE) && cap.getEnergyStored() > 0) {
                level.setBlock(worldPosition, state.setValue(ALIVE, true), 3);
                level.playSound(null, getBlockPos(), SoundEvents.SCULK_BLOCK_SPREAD, SoundSource.BLOCKS, 1.0F, 0.25F);
            }

            if (state.getValue(ALIVE)) {
                if (cap.getEnergyStored() <= 250) {
                    cap.extractEnergy(cap.getEnergyStored(), true);
                    level.setBlock(worldPosition, state.setValue(ALIVE, false), 3);
                    level.playSound(null, getBlockPos(), SoundEvents.VEX_DEATH, SoundSource.BLOCKS, 1.0F, 0.25F);
                } else {
                    cap.extractEnergy(250, true);
                }
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
