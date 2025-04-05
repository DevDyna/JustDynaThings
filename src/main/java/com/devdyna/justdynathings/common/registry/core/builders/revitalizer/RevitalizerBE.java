package com.devdyna.justdynathings.common.registry.core.builders.revitalizer;

import static com.devdyna.justdynathings.common.registry.core.builders.revitalizer.RevitalizerBlock.*;

import com.devdyna.justdynathings.common.registry.core.interfaces.be.SmartFEMachine;
import com.devdyna.justdynathings.common.registry.types.BlockEntities;
import com.devdyna.justdynathings.common.registry.types.BlockTags;
import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
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

@SuppressWarnings("null")
public class RevitalizerBE extends BaseMachineBE implements SmartFEMachine {
    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);
    private int cost = 1000;
    private int maxsize = 10000;

    public RevitalizerBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public RevitalizerBE(BlockPos pos, BlockState state) {
        this(BlockEntities.REVITALIZER_BE.get(), pos, state);
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
    public int getStandardEnergyCost() {
        return cost;
    }

    @Override
    public int getMaxEnergy() {
        return maxsize;
    }

    @Override
    public void tickServer() {

        updateBlock();

        if (readyToConsume()) {

            applyParticles();

            applySound();

            consumeEnergy();

            reviveGoo();

        }
    }

    /**
     * update the blockstate properties
     */
    public void updateBlock() {
        level.setBlockAndUpdate(getBlockPos(),
                getBlockState()
                        .setValue(ACTIVE,
                                validEnergy())
                        .setValue(GOO_FOUND, checkGooTop())
                        .setValue(BlockStateProperties.FACING,
                                getBlockState()
                                        .getValue(BlockStateProperties.FACING)));
    }

    /**
     * add dire-glitter particles
     */
    public void applyParticles() {
        if (LevelUtil.chance(25, level))
            LevelUtil.SpawnGlitterParticle(0.0F, 255.0F, 154.0F, getBlockPos(), level, new float[] { 1.0F, 1.0F, 1.0F },
                    6);
    }

    /**
     * add sound events
     * 
     */
    public void applySound() {
        if (LevelUtil.chance(50, level))
            level.playSound(null, getBlockPos(), SoundEvents.AMETHYST_BLOCK_RESONATE,
                    SoundSource.BLOCKS, level.random.nextInt(50) + 1 * 0.01F,
                    level.random.nextInt(50) + 1 * 0.01F);
    }

    /**
     * extract energy
     */
    public void consumeEnergy() {
        if (LevelUtil.chance(50, level))
            extractFEWhenPossible();
    }

    /*
     * check if on top there is a goo
     */
    public boolean checkGooTop() {
        return level.getBlockState(getGooPos())
                .is(BlockTags.REVITALIZER_GOO);
    }

    public boolean checkGooStatus() {
        return !level
                .getBlockState(getGooPos())
                .getValue(GooBlock_Base.ALIVE).booleanValue();
    }

    public void reviveGoo() {
        if (LevelUtil.chance(25, level))
            level.setBlockAndUpdate(getGooPos(),
                    level.getBlockState(getGooPos())
                            .setValue(GooBlock_Base.ALIVE, true));
    }

    public boolean readyToConsume() {
        return getBlockState().getValue(ACTIVE).booleanValue()
                && getBlockState().getValue(GOO_FOUND).booleanValue() && checkGooStatus();
    }

    public BlockPos getGooPos() {
        return getBlockPos()
                .relative(getBlockState()
                        .getValue(BlockStateProperties.FACING).getOpposite());
    }

}
