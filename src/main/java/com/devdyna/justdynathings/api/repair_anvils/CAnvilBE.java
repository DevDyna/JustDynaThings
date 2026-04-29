package com.devdyna.justdynathings.api.repair_anvils;


import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.RandomUtil;
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

    @Deprecated
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

    public void applySound() {
        if (RandomUtil.chance( level,5) && Config.ANVILS_SOUND_EVENT.get())
            level.playSound(null, getBlockPos(),
                    RandomUtil.rnd50( level)
                            ? SoundEvents.GRINDSTONE_USE
                            : RandomUtil.chance( level,75)
                                    ? SoundEvents.SMITHING_TABLE_USE
                                    : SoundEvents.ANVIL_USE,
                    SoundSource.BLOCKS, (level.getRandom().nextInt(10) + 1) * 0.01F,
                    level.getRandom().nextInt(50) + 1 * 0.01F);
    }

}