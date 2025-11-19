package com.devdyna.justdynathings.registry.builders.stabilizer;

import com.devdyna.justdynathings.Config.CommonConfig;
import com.devdyna.justdynathings.registry.builders.paradox_mixer.ParadoxMixerBlock;
import com.devdyna.justdynathings.registry.interfaces.be.EnergyMachine;
import com.devdyna.justdynathings.registry.interfaces.be.FluidMachine;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zBlockTags;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

@SuppressWarnings("null")
public class StabilizerBE extends BaseMachineBE implements EnergyMachine, FluidMachine {

    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);
    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public StabilizerBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public StabilizerBE(BlockPos pos, BlockState state) {
        this(zBlockEntities.STABILIZER.get(), pos, state);
    }

    @Override
    public ContainerData getContainerData() {
        return poweredMachineData;
    }

    @Override
    public MachineEnergyStorage getEnergyStorage() {
        return getData(Registration.ENERGYSTORAGE_MACHINES);
    }

    @Override
    public void tickServer() {

        updateBlock();

        var block = level.getBlockState(getGooPos()).getBlock();

        if ((block instanceof GooBlock_Base || block instanceof ParadoxMixerBlock) && canExtractFE()) {

            if (level.getBlockState(getGooPos()).getValue(zProperties.GOO_ALIVE))
                return;

            if (block instanceof GooBlock_Base) {

                extractFEWhenPossible();

                if (LevelUtil.chance(5, level)) {
                    if (CommonConfig.STABILIZER_TOGGLE_SOUND.get())
                        applySound();
                    setAlive();

                }

            }

            if (block instanceof ParadoxMixerBlock && canExtractMB()) {
                extractFEWhenPossible();
                extractMBWhenPossible();
                setAlive();
            }

        }

    }

    public void setAlive() {
        level.setBlockAndUpdate(getGooPos(),
                level.getBlockState(getGooPos())
                        .setValue(GooBlock_Base.ALIVE, true));
    }

    /**
     * update the blockstate properties
     */
    public void updateBlock() {
        level.setBlockAndUpdate(getBlockPos(),
                getBlockState()
                        .setValue(zProperties.ENERGIZED, canExtractMB())
                        .setValue(zProperties.ACTIVE, canExtractFE())
                        .setValue(zProperties.GOO_FOUND,
                                level.getBlockState(getGooPos()).is(zBlockTags.STABILIZER_BELOW))
                        .setValue(BlockStateProperties.FACING,
                                getBlockState()
                                        .getValue(BlockStateProperties.FACING)));
    }

    /**
     * add sound events
     * 
     */
    public void applySound() {
        if (LevelUtil.chance(5, level))
            level.playSound(null, getBlockPos(), SoundEvents.RESPAWN_ANCHOR_CHARGE,
                    SoundSource.BLOCKS, (level.random.nextInt(50) + 1) * 0.01F,
                    level.random.nextInt(50) + 1 * 0.01F);
    }

    public BlockPos getGooPos() {
        return getBlockPos()
                .relative(getBlockState()
                        .getValue(BlockStateProperties.FACING).getOpposite());
    }

    @Override
    public int getStandardEnergyCost() {
        return CommonConfig.STABILIZER_FE_COST.get();
    }

    @Override
    public int getMaxEnergy() {
        return CommonConfig.STABILIZER_FE_CAPACITY.get();
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
    public int getStandardFluidCost() {
        return CommonConfig.STABILIZER_MB_COST.get();
    }

    @Override
    public int getMaxMB() {
        return CommonConfig.STABILIZER_MB_CAPACITY.get();
    }

}
