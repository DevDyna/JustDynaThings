package com.devdyna.justdynathings.registry.builders.budding;

import com.devdyna.justdynathings.config.common;
import com.devdyna.justdynathings.registry.interfaces.be.EnergyMachine;
import com.devdyna.justdynathings.registry.interfaces.be.FluidMachine;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.DirectionUtil;
import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.blocks.resources.TimeCrystalCluster;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.Registration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.minecraft.world.level.block.BuddingAmethystBlock;

@SuppressWarnings("null")
public class BuddingBE extends BaseMachineBE implements EnergyMachine, FluidMachine {

    //TODO rework time fluid -> recipe types with differents efficiency

    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);
    public final FluidContainerData fluidContainerData = new FluidContainerData(this);
    public Block smallCluster;
    public Block mediumCluster;
    public Block largeCluster;
    public Block finalCluster;

    public BuddingBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void tickClient() {
    }

    @Override
    public void tickServer() {

        updateBlock();

        if (LevelUtil.chance(25, level) && getBlockState().getValue(zProperties.GOO_ALIVE)) {

            // RANDOM REQUIRE VARIABLE
            Direction dir = DirectionUtil.randomDirection(level, Direction.values());

            if (growCluster(dir)) {

                // applyParticles();

                if (common.BUDDING_GENERAL_SOUND.get())
                    applySound(dir);

                if (common.BUDDING_GENERAL_FE_CHANCE.get() ? LevelUtil.rnd50(level) : true)
                    extractFEWhenPossible();

                if (common.BUDDING_GENERAL_MB_CHANCE.get() ? LevelUtil.rnd50(level) : true)
                    extractMBWhenPossible();

            }
        }
    }

    /**
     * grow something on a direction
     * 
     * @param pos
     * @param state
     * @param dir
     * @return found a valid growable direction
     */
    public boolean growCluster(Direction dir) {
        BlockState state = level.getBlockState(getBlockPos().relative(dir));
        Block block = BuddingAmethystBlock.canClusterGrowAtState(state)
                ? smallCluster
                : (state.is(smallCluster)
                        && state.getValue(AmethystClusterBlock.FACING) == dir)
                                ? mediumCluster
                                : (state.is(mediumCluster)
                                        && state.getValue(AmethystClusterBlock.FACING) == dir)
                                                ? largeCluster
                                                : (state.is(largeCluster)
                                                        && state.getValue(AmethystClusterBlock.FACING) == dir)
                                                                ? finalCluster
                                                                : null;
        if (block != null) {
            level.setBlockAndUpdate(getBlockPos().relative(dir),
                    block.defaultBlockState()
                            .setValue(TimeCrystalCluster.FACING, dir)
                            .setValue(TimeCrystalCluster.WATERLOGGED, state.getFluidState().getType() == Fluids.WATER));
            return true;
        } else
            return false;

    }

    /**
     * add sound events
     * 
     * @param pos
     */
    public void applySound(Direction dir) {
        if (LevelUtil.chance(50, level))
            level.playSound(null, getBlockPos().relative(dir), SoundEvents.AMETHYST_BLOCK_RESONATE,
                    SoundSource.BLOCKS, 1.0F, 0.25F);
    }

    /**
     * update the blockstate properties
     */
    public void updateBlock() {
        level.setBlockAndUpdate(getBlockPos(),
                getBlockState().setValue(zProperties.GOO_ALIVE,
                        canExtractFE() && canExtractMB()));
    }

    @Override
    public MachineEnergyStorage getEnergyStorage() {
        return getData(Registration.ENERGYSTORAGE_MACHINES);
    }

    @Override
    public ContainerData getContainerData() {
        return poweredMachineData;
    }

    @Override
    public ContainerData getFluidContainerData() {
        return fluidContainerData;
    }

    @Override
    public FluidTank getFluidTank() {
        return getData(Registration.PARADOX_FLUID_HANDLER);
    }

    @Override
    public int getMaxMB() {
        return common.BUDDING_GENERAL_MB_CAPACITY.get();
    }

    @Override
    public int getStandardFluidCost() {
        return common.BUDDING_GENERAL_MB_COST.get();
    }

    @Override
    public int getStandardEnergyCost() {
        return common.BUDDING_GENERAL_FE_COST.get();
    }

    @Override
    public int getMaxEnergy() {
        return common.BUDDING_GENERAL_FE_CAPACITY.get();
    }

}
