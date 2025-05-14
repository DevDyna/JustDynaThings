package com.devdyna.justdynathings.registry.builders.sculk;

import com.devdyna.justdynathings.registry.interfaces.be.FluidMachine;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.FluidContainerData;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;

@SuppressWarnings("null")
public class SculkBE extends BaseMachineBE implements FluidMachine {

    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    public SculkBE(BlockEntityType<?> p, BlockPos b, BlockState s) {
        super(p, b, s);
    }

    public SculkBE(BlockPos p, BlockState s) {
        this(null, p, s);//WIP
    }

    @Override
    public void tickClient() {
    }

    private int delay = 0;

    private BlockPos basePos = getBlockPos();
    private BlockPos nextPos;

    private int maxtimer = 1000;

    @Override
    public void tickServer() {

        checkState();

        if (getBlockState().getValue(zProperties.ACTIVE) && delay < maxtimer) {
            delay++;
        } else {
            delay = 0;
            basePos = getBlockPos();
        }

        if (delay != 0 && delay % 10 == 0) {
            
            extractMBWhenPossible();

            nextPos = LevelUtil.RandomPos3D(level, basePos);

            if (level.getBlockState(
                    nextPos).is(
                            BlockTags.AIR
            // BlockTags.SCULK_REPLACEABLE
            )) {

                level.setBlockAndUpdate(nextPos, Blocks.SCULK.defaultBlockState());
            }

            basePos = nextPos;

        }

    }

    public void checkState() {
        level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(zProperties.ACTIVE,
                canExtractMB()));
    }

    public void playSound(BlockPos pos) {
        level.playLocalSound(pos.getX(), pos.getY(),
                pos.getZ(),
                SoundEvents.AMETHYST_BLOCK_BREAK,
                SoundSource.BLOCKS, 100,
                LevelUtil.getRandomValue(9, level) * 0.1f, true);
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
    public int getStandardFluidCost() {
        return FLrate;
    }

    @Override
    public int getMaxMB() {
        return FLsize;
    }


}