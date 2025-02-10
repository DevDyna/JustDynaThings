package com.devdyna.justdynathings.common.registry.builder.budding;

import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import static com.devdyna.justdynathings.common.registry.builder.budding.BuddingBlock.ACTIVE;
import static com.devdyna.justdynathings.common.registry.builder.budding.DecayBuddingBlock.AGE;
import static com.devdyna.justdynathings.common.registry.builder.budding.DecayBuddingBlock.ALIVE;

import com.devdyna.justdynathings.common.registry.Material;

@SuppressWarnings("null")
public class DecayBuddingBE extends BuddingBE {

    public final PoweredMachineContainerData poweredMachineData;
    public final FluidContainerData fluidContainerData;

    public DecayBuddingBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        poweredMachineData = new PoweredMachineContainerData(this);
        fluidContainerData = new FluidContainerData(this);
    }

    public DecayBuddingBE(BlockPos pos, BlockState state) {
        super(pos, state);
        poweredMachineData = new PoweredMachineContainerData(this);
        fluidContainerData = new FluidContainerData(this);
    }

    public DecayBuddingBE(BlockPos pos, BlockState state, int FEcost, int FEsize, int FLcost, int FLsize,
            Block smallCluster, Block mediumCluster, Block largeCluster, Block finalCluster) {
        super(Material.POWERED_FLAWED_BUDDING_BE.get(), pos, state, FEcost, FEsize, FLcost, FLsize, smallCluster,
                mediumCluster, largeCluster, finalCluster);
        poweredMachineData = new PoweredMachineContainerData(this);
        fluidContainerData = new FluidContainerData(this);
    }

    @Override
    public void tickClient() {
    }

    @Override
    public void tickServer() {
        super.tickServer();
        run();
    }

    @Override

    public void run() {
        // prevent eventual crash caused by setblock other blocks
        try {
            updateBlock();
        } catch (Exception e) {
        }

        if (LevelUtil.chance(25, level) && getBlockState().getValue(ALIVE) && getBlockState().getValue(ACTIVE)) {

            // RANDOM REQUIRE VARIABLE
            Direction dir = LevelUtil.randomDirection(level, Direction.values());

            if (growCluster(dir)) {

                applyParticles();

                applySound(dir);

                consumeEnergy();

                consumeFluid();

                increaseAndDecay();

            }
        }
    }

    @Override
    public void updateBlock() {
        level.setBlockAndUpdate(getBlockPos(),
                getBlockState().setValue(AGE, getBlockState().getValue(AGE))
                        .setValue(ACTIVE,
                                getEnergyStored() > getStandardEnergyCost()
                                        && getAmountStored() > getStandardFluidCost()
                                        && getBlockState().getValue(ALIVE))
                        .setValue(ALIVE, getBlockState().getValue(AGE) != AGE.getPossibleValues().size() - 1));
    }

    public void increaseAndDecay() {

        if (LevelUtil.chance(5, level)
                && getBlockState().getValue(AGE) < (AGE.getPossibleValues().size() - 1))

            level.setBlockAndUpdate(getBlockPos(),
                    getBlockState().setValue(AGE, getBlockState().getValue(AGE) + 1));

    }

}
