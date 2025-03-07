package com.devdyna.justdynathings.common.registry.builder.sculk;

import static com.devdyna.justdynathings.common.registry.builder.sculk.SculkBlock.ACTIVE;

import com.devdyna.justdynathings.common.registry.Material;
import com.devdyna.justdynathings.common.registry.core.interfaces.be.SmartMBMachine;
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
public class SculkBE extends BaseMachineBE implements SmartMBMachine {

    public final FluidContainerData fluidContainerData = new FluidContainerData(this);

    private int cost;
    private int capacity;

    /**
     * DONT USE THIS ON BE REGISTRATION
     */
    public SculkBE(BlockEntityType<?> p, BlockPos b, BlockState s) {
        super(p, b, s);
    }

    public SculkBE(BlockPos p, BlockState s, int capacity, int cost) {
        this(Material.SCULK_BE.get(), p, s);
        this.cost = cost;
        this.capacity = capacity;
    }

    /**
     * DONT USE THIS ON BE REGISTRATION
     */
    public SculkBE(BlockPos p, BlockState s) {
        this(Material.SCULK_BE.get(), p, s);
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

        if (getBlockState().getValue(ACTIVE) && delay < maxtimer) {
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
        level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(ACTIVE,
                validFluid()));
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
        return cost;
    }

    @Override
    public int getMaxMB() {
        return capacity;
    }

}