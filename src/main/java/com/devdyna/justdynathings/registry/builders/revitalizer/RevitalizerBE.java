package com.devdyna.justdynathings.registry.builders.revitalizer;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.registry.interfaces.be.EnergyMachine;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zBlockTags;
import com.devdyna.justdynathings.registry.types.zProperties;
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
public class RevitalizerBE extends BaseMachineBE implements EnergyMachine {
    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);

    public RevitalizerBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public RevitalizerBE(BlockPos pos, BlockState state) {
        this(zBlockEntities.REVITALIZER.get(), pos, state);
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

        if (readyToConsume()) {

            if (Config.REVITALIZER_TOGGLE_SOUND.get())
                applySound();

            if (LevelUtil.chance(Config.REVITALIZER_CHANCE_FE_COST.get(), level))
                extractFEWhenPossible();

            reviveGoo();

        }
    }

    /**
     * update the blockstate properties
     */
    public void updateBlock() {
        level.setBlockAndUpdate(getBlockPos(),
                getBlockState()
                        .setValue(zProperties.ACTIVE,
                                canExtractFE())
                        .setValue(zProperties.GOO_FOUND, checkGooTop())
                        .setValue(BlockStateProperties.FACING,
                                getBlockState()
                                        .getValue(BlockStateProperties.FACING)));
    }

    /**
     * add sound events
     * 
     */
    public void applySound() {
        if (LevelUtil.chance(50, level))
            level.playSound(null, getBlockPos(), SoundEvents.RESPAWN_ANCHOR_CHARGE,
                    SoundSource.BLOCKS, level.random.nextInt(50) + 1 * 0.01F,
                    level.random.nextInt(50) + 1 * 0.01F);
    }

    /*
     * check if on top there is a goo
     */
    public boolean checkGooTop() {
        return level.getBlockState(getGooPos())
                .is(zBlockTags.REVITALIZER_GOO);
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

    /**
     * has FE and has a Goo to revive
     */
    public boolean readyToConsume() {
        return getBlockState().getValue(zProperties.ACTIVE).booleanValue()
                && getBlockState().getValue(zProperties.GOO_FOUND).booleanValue() && checkGooStatus();
    }

    public BlockPos getGooPos() {
        return getBlockPos()
                .relative(getBlockState()
                        .getValue(BlockStateProperties.FACING).getOpposite());
    }

    @Override
    public int getStandardEnergyCost() {
        return Config.REVITALIZER_FE_COST.get();
    }

    @Override
    public int getMaxEnergy() {
        return Config.REVITALIZER_FE_CAPACITY.get();
    }

}
