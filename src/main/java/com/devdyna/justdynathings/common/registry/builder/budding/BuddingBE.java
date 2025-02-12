package com.devdyna.justdynathings.common.registry.builder.budding;

import static com.devdyna.justdynathings.common.registry.builder.budding.BuddingBlock.ACTIVE;

import com.devdyna.justdynathings.common.registry.Material;
import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineBE;
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
public class BuddingBE extends BaseMachineBE implements PoweredMachineBE, FluidMachineBE {

    public final PoweredMachineContainerData poweredMachineData;
    public final FluidContainerData fluidContainerData;
    public int FEcost;
    public int FEsize;
    public int FLsize;
    public int FLcost;
    public Block smallCluster;
    public Block mediumCluster;
    public Block largeCluster;
    public Block finalCluster;

    public BuddingBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        poweredMachineData = new PoweredMachineContainerData(this);
        fluidContainerData = new FluidContainerData(this);
    }

    public BuddingBE(BlockPos pos, BlockState state) {
        super(Material.POWERED_BUDDING_BE.get(), pos, state);
        poweredMachineData = new PoweredMachineContainerData(this);
        fluidContainerData = new FluidContainerData(this);
    }

    public BuddingBE(BlockPos pos, BlockState state, int FEcost, int FEsize, int FLcost, int FLsize,
            Block smallCluster, Block mediumCluster, Block largeCluster, Block finalCluster) {
        super(Material.POWERED_BUDDING_BE.get(), pos, state);
        poweredMachineData = new PoweredMachineContainerData(this);
        fluidContainerData = new FluidContainerData(this);
        this.FEcost = FEcost;
        this.FEsize = FEsize;
        this.FLcost = FLcost;
        this.FLsize = FLsize;
        this.smallCluster = smallCluster;
        this.mediumCluster = mediumCluster;
        this.largeCluster = largeCluster;
        this.finalCluster = finalCluster;
    }

    // public BuddingBE(BlockEntityType<?> type, BlockPos pos, BlockState state, int FEcost, int FEsize, int FLcost,
    //         int FLsize,
    //         Block smallCluster, Block mediumCluster, Block largeCluster, Block finalCluster) {
    //     super(type, pos, state);
    //     poweredMachineData = new PoweredMachineContainerData(this);
    //     fluidContainerData = new FluidContainerData(this);
    //     this.FEcost = FEcost;
    //     this.FEsize = FEsize;
    //     this.FLcost = FLcost;
    //     this.FLsize = FLsize;
    //     this.smallCluster = smallCluster;
    //     this.mediumCluster = mediumCluster;
    //     this.largeCluster = largeCluster;
    //     this.finalCluster = finalCluster;
    // }

    @Override
    public void tickClient() {
    }

    @Override
    public void tickServer() {
        super.tickServer();
        run();
    }

    public void run() {

        updateBlock();

        if (LevelUtil.chance(25, level) && getBlockState().getValue(ACTIVE)) {

            // RANDOM REQUIRE VARIABLE
            Direction dir = LevelUtil.randomDirection(level, Direction.values());

            if (growCluster(dir)) {

                applyParticles();

                applySound(dir);

                consumeEnergy();

                consumeFluid();

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
            BlockState state1 = block.defaultBlockState()
                    .setValue(TimeCrystalCluster.FACING, dir)
                    .setValue(TimeCrystalCluster.WATERLOGGED,
                            Boolean.valueOf(state.getFluidState().getType() == Fluids.WATER));
            level.setBlockAndUpdate(getBlockPos().relative(dir), state1);
            return true;
        } else
            return false;

    }

    /**
     * extract fluid
     */
    public void consumeFluid() {
        if (LevelUtil.chance(50, level))
            setAmountStored(
                    getAmountStored() <= getStandardFluidCost() ? getAmountStored() : getStandardFluidCost());
    }

    /**
     * extract energy
     */
    public void consumeEnergy() {
        if (LevelUtil.chance(50, level))
            extractEnergy(
                    getEnergyStored() <= getStandardEnergyCost() ? getEnergyStored() : getStandardEnergyCost(),
                    false);
    }

    /**
     * add sound events
     * 
     * @param pos
     */
    public void applySound(Direction dir) {
        if (LevelUtil.chance(50, level))
            level.playSound(null, getBlockPos().relative(dir), SoundEvents.AMETHYST_BLOCK_RESONATE,
                    SoundSource.BLOCKS, level.random.nextInt(50) + 1 * 0.01F,
                    level.random.nextInt(50) + 1 * 0.01F);
    }

    /**
     * add dire-glitter particles
     */
    public void applyParticles() {
        if (LevelUtil.chance(25, level))
        LevelUtil.SpawnGlitterParticle(0.0F, 255.0F, 154.0F, getBlockPos(), level, new float[]
        { 1.0F, 1.0F, 1.0F },
        6);
    }

    /**
     * update the blockstate properties
     */
    public void updateBlock() {
        level.setBlockAndUpdate(getBlockPos(),
                getBlockState().setValue(ACTIVE,
                        getEnergyStored() > getStandardEnergyCost() && getAmountStored() > getStandardFluidCost()));
    }

    @Override
    public int getStandardEnergyCost() {
        return FEcost;
    }

    @Override
    public int getMaxEnergy() {
        return FEsize;
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
        return FLsize;
    }

    /**
     * "why not?"
     */
    public int getStandardFluidCost() {
        return FLcost;
    }
}
