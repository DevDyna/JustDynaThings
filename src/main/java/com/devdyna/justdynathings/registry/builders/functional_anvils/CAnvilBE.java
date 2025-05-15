package com.devdyna.justdynathings.registry.builders.functional_anvils;

import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.RedstoneControlledBE;
import com.direwolf20.justdirethings.util.interfacehelpers.RedstoneControlData;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("null")
public class CAnvilBE extends BaseMachineBE implements RedstoneControlledBE {

    public final RedstoneControlData redstoneControlData = new RedstoneControlData();

    public CAnvilBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        MACHINE_SLOTS = 1;
    }

    public CAnvilBE(BlockPos pos, BlockState state) {
        this(null, pos, state);
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
    }

    public void applySound() {
        if (LevelUtil.chance(5, level))
            level.playSound(null, getBlockPos(),
                    LevelUtil.chance(50, level)
                            ? SoundEvents.GRINDSTONE_USE
                            : LevelUtil.chance(75, level)
                                    ? SoundEvents.SMITHING_TABLE_USE
                                    : SoundEvents.ANVIL_USE,
                    SoundSource.BLOCKS, (level.random.nextInt(10) + 1) * 0.01F,
                    level.random.nextInt(50) + 1 * 0.01F);
    }

}