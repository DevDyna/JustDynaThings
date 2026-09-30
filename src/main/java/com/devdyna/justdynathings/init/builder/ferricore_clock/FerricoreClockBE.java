package com.devdyna.justdynathings.init.builder.ferricore_clock;

import com.devdyna.justdynathings.api.DirUtils;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class FerricoreClockBE extends BaseMachineBE {

    public FerricoreClockBE(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public FerricoreClockBE(BlockPos pos, BlockState blockState) {
        this(zBlockEntities.FERRICORE_CLOCK.get(), pos, blockState);
    }

    private int i = 0;

    @Override
    public void tickServer() {

        if (i < tickSpeed)
            i++;

        if (i >= tickSpeed) {
            i = 0;
            updateBlock();
        }

    }

    public void updateBlock() {
        var state = getBlockState()
                .setValue(FerricoreClockBlock.ACTIVE,
                        !getBlockState().getValue(FerricoreClockBlock.ACTIVE));

        for (var d : DirUtils.DirProperties.ALL)
            state.setValue(d, state.getValue(d));

        level.setBlockAndUpdate(getBlockPos(), state);

    }

}
