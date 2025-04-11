package com.devdyna.justdynathings.registry.builders.blazing_anvil;

import static com.devdyna.justdynathings.registry.builders.blazing_anvil.BlazingAnvilBlock.ACTIVE;

import com.devdyna.justdynathings.registry.interfaces.be.SmartFEMachine;
import com.devdyna.justdynathings.registry.types.BlockEntities;
import com.devdyna.justdynathings.registry.types.ItemTags;
import com.devdyna.justdynathings.utils.Actions;
import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.PoweredMachineContainerData;
import com.direwolf20.justdirethings.common.blockentities.basebe.RedstoneControlledBE;
import com.direwolf20.justdirethings.common.capabilities.MachineEnergyStorage;
import com.direwolf20.justdirethings.setup.Registration;
import com.direwolf20.justdirethings.util.interfacehelpers.RedstoneControlData;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("null")
public class BlazingAnvilBE extends BaseMachineBE implements RedstoneControlledBE, SmartFEMachine {

    public RedstoneControlData redstoneControlData = new RedstoneControlData();
    public final PoweredMachineContainerData poweredMachineData = new PoweredMachineContainerData(this);
    private int cost = 1000;
    private int maxsize = 10000;

    public BlazingAnvilBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        MACHINE_SLOTS = 1;
    }

    public BlazingAnvilBE(BlockEntityType<?> type, BlockPos pos, BlockState state, int cost, int maxsize) {
        this(type, pos, state);
    }

    public BlazingAnvilBE(BlockPos pos, BlockState state) {
        this(BlockEntities.BLAZING_ANVIL.get(), pos, state);
    }

    @Override
    public RedstoneControlData getRedstoneControlData() {
        return redstoneControlData;
    }

    @Override
    public BlockEntity getBlockEntity() {
        return this;
    }

    @Override
    public void tickClient() {
    }

    @Override
    public void tickServer() {
        checkState();
        if (getBlockState().getValue(ACTIVE).booleanValue()) {
            extractFEWhenPossible();
            Actions.repairItem(getMachineHandler().getStackInSlot(0));
            applySound();
        }
    }

    public void checkState() {
        level.setBlockAndUpdate(getBlockPos(),
                getBlockState().setValue(ACTIVE,
                        validEnergy() && getMachineHandler().getStackInSlot(0).isDamageableItem()
                                && getMachineHandler().getStackInSlot(0).isDamaged()
                                && !getMachineHandler().getStackInSlot(0).is(ItemTags.BLAZINGANVIL_DENY)));
    }

    @Override
    public PoweredMachineContainerData getContainerData() {
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

    public void applySound() {
        if (LevelUtil.chance(5, level))
            level.playSound(null, getBlockPos(),
                    LevelUtil.chance(75, level)
                            ? SoundEvents.GRINDSTONE_USE
                            : LevelUtil.chance(50, level)
                                    ? SoundEvents.SMITHING_TABLE_USE
                                    : SoundEvents.ANVIL_USE,
                    SoundSource.BLOCKS, (level.random.nextInt(10) + 1) * 0.01F,
                    level.random.nextInt(50) + 1 * 0.01F);
    }

}