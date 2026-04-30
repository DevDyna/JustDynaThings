package com.devdyna.justdynathings.init.builder.stabilizer;

import com.devdyna.cakesticklib.api.utils.DirectionUtil;
import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.RandomUtil;
import com.devdyna.justdynathings.api.be.EnergyMachine;
import com.devdyna.justdynathings.api.be.FluidMachine;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import com.devdyna.justdynathings.init.types.zProperties;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;
import com.direwolf20.justdirethings.common.blocks.resources.TimeCrystalBuddingBlock;
import com.direwolf20.justdirethings.common.blocks.resources.TimeCrystalCluster;
import com.direwolf20.justdirethings.common.capabilities.JustDireFluidTank;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.JDTRegistration;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluids;

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
        return getData(JDTRegistration.ENERGYSTORAGE_MACHINES);
    }

    @Override
    public void tickServer() {

        updateBlock();

        var related = level.getBlockState(getGooPos()).getBlock();

        if (!canExtractFE())
            return;

        if (related instanceof GooBlock_Base) {

            if (level.getBlockState(getGooPos()).getValue(zProperties.GOO_ALIVE))
                return;

            extractFEWhenPossible();

            if (RandomUtil.chance(level, 5)) {
                if (Config.STABILIZER_TOGGLE_SOUND.get())
                    applySound();
                setAlive();

            }

        }

        if (related instanceof TimeCrystalBuddingBlock time) {

            var stage = level.getBlockState(getGooPos()).getValue(TimeCrystalBuddingBlock.STAGE);
            if (canExtractMB()) {
                if (stage < 3)
                    if (RandomUtil.chance(level, 1)) {
                        if (Config.STABILIZER_TOGGLE_SOUND.get())
                            applySound();
                        extractFEWhenPossible();
                        extractMBWhenPossible();
                        time.advance(level, level.getBlockState(getGooPos()), getGooPos(), stage + 1);

                    }

                if (stage == 3) {
                    if (RandomUtil.chance(level, 5))
                        tryToGrowCluster(getGooPos());
                }
            } else {
                if (RandomUtil.chance(level, 5))
                    level.setBlockAndUpdate(getGooPos(),
                            level.getBlockState(getGooPos()).setValue(TimeCrystalBuddingBlock.STAGE, 0));
                level.playSound(null, getGooPos(), SoundEvents.RESPAWN_ANCHOR_DEPLETE.value(),
                        SoundSource.BLOCKS, 1.0F, 0.25F);
            }

        }

    }

    public void tryToGrowCluster(BlockPos budPos) {

        var dir = DirectionUtil.randomDirection(level, DirectionUtil.ALL);

        var clusterPos = budPos.relative(dir);
        var blockstate = level.getBlockState(clusterPos);
        Block block = null;

        if (TimeCrystalBuddingBlock.canClusterGrowAtState(blockstate)) {
            block = JDTRegistration.TimeCrystalCluster_Small.get();
        } else if (blockstate.is(JDTRegistration.TimeCrystalCluster_Small.get())
                && blockstate.getValue(AmethystClusterBlock.FACING) == dir) {
            block = JDTRegistration.TimeCrystalCluster_Medium.get();
        } else if (blockstate.is(JDTRegistration.TimeCrystalCluster_Medium.get())
                && blockstate.getValue(AmethystClusterBlock.FACING) == dir) {
            block = JDTRegistration.TimeCrystalCluster_Large.get();
        } else if (blockstate.is(JDTRegistration.TimeCrystalCluster_Large.get())
                && blockstate.getValue(AmethystClusterBlock.FACING) == dir) {
            block = JDTRegistration.TimeCrystalCluster.get();
        }

        if (block != null)
            level.setBlockAndUpdate(clusterPos, block.defaultBlockState()
                    .setValue(TimeCrystalCluster.FACING, dir)
                    .setValue(TimeCrystalCluster.WATERLOGGED, blockstate.getFluidState().getType() == Fluids.WATER));

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
                        .setValue(zProperties.VALID_FACING, whenActive())
                        .setValue(BlockStateProperties.FACING,
                                getBlockState()
                                        .getValue(BlockStateProperties.FACING)));
    }

    public boolean whenActive() {
        return level.getBlockState(getGooPos()).getBlock() instanceof TimeCrystalBuddingBlock
                || level.getBlockState(getGooPos()).getBlock() instanceof GooBlock_Base;
    }

    /**
     * add sound events
     * 
     */
    public void applySound() {
        if (RandomUtil.chance(level, 5))
            level.playSound(null, getBlockPos(), SoundEvents.RESPAWN_ANCHOR_CHARGE,
                    SoundSource.BLOCKS, (level.getRandom().nextInt(50) + 1) * 0.01F,
                    level.getRandom().nextInt(50) + 1 * 0.01F);
    }

    public BlockPos getGooPos() {
        return getBlockPos()
                .relative(getBlockState()
                        .getValue(BlockStateProperties.FACING).getOpposite());
    }

    @Override
    public int getStandardEnergyCost() {
        return Config.STABILIZER_FE_COST.get();
    }

    @Override
    public int getMaxEnergy() {
        return Config.STABILIZER_FE_CAPACITY.get();
    }

    @Override
    public ContainerData getFluidContainerData() {
        return fluidContainerData;
    }

    @Override
    public JustDireFluidTank getFluidTank() {
        return getData(JDTRegistration.MACHINE_FLUID_HANDLER);
    }

    @Override
    public int getStandardFluidCost() {
        return Config.STABILIZER_MB_COST.get();
    }

    @Override
    public int getMaxMB() {
        return Config.STABILIZER_MB_CAPACITY.get();
    }

    public boolean canReviveGoo() {
        return canExtractFE();
    }

    public boolean isEnergized() {
        return canExtractMB() && canReviveGoo();
    }

}
