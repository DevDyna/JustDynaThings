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
import com.direwolf20.justdirethings.common.capabilities.JustDireFluidTank;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.JDTRegistration;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.BuddingAmethystBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.common.Tags;

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

        var state = level.getBlockState(getGooPos());

        var related = state.getBlock();

        if (!canExtractFE())
            return;

        if (related instanceof GooBlock_Base) {

            if (state.getValue(zProperties.GOO_ALIVE))
                return;

            extractFEWhenPossible();

            if (RandomUtil.chance(level, 5)) {
                if (Config.STABILIZER_TOGGLE_SOUND.get())
                    applySound();
                level.setBlockAndUpdate(getGooPos(),
                        level.getBlockState(getGooPos())
                                .setValue(GooBlock_Base.ALIVE, true));

            }

        }

        if (related instanceof BuddingAmethystBlock) {

            extractFEWhenPossible();

            if (!canExtractMB())
                return;

            if (related instanceof TimeCrystalBuddingBlock time) {

                var stage = state.getValue(TimeCrystalBuddingBlock.STAGE);

                if (stage < 3) {
                    if (RandomUtil.chance(level, 5)) {
                        if (Config.STABILIZER_TOGGLE_SOUND.get())
                            applySound();

                        extractMBWhenPossible();
                        time.advance(level, state, getGooPos(), stage + 1);

                    }
                    return;
                }

            }

            if (whenConsumeMB())
                extractMBWhenPossible();

            if (state.isRandomlyTicking())
                for (int i = 0; i < 16; i++) {
                    state.randomTick((ServerLevel) level, getGooPos(), level.getRandom());
                    if (RandomUtil.chance(level, 1))
                        if (Config.STABILIZER_TOGGLE_SOUND.get())
                            applySound();

                }

        }

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
       return level.getBlockState(getGooPos()).getBlock() instanceof GooBlock_Base  || level.getBlockState(getGooPos()).getBlock() instanceof BuddingAmethystBlock;
    }

    public boolean whenConsumeMB() {
        for (Direction d : DirectionUtil.ALL) {
            if (BuddingAmethystBlock.canClusterGrowAtState(level.getBlockState(getGooPos().relative(d)))
                    || (level.getBlockState(getGooPos().relative(d)).is(Tags.Blocks.BUDS)
                            && level.getBlockState(getGooPos().relative(d)).getValue(AmethystClusterBlock.FACING)
                                    .equals(d))) {
                return true;
            }
        }
        return false;
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

}
