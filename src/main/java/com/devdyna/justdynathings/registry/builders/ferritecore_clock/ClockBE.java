package com.devdyna.justdynathings.registry.builders.ferritecore_clock;

import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.DirectionUtil;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("null")
public class ClockBE extends BaseMachineBE {

    public ClockBE(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public ClockBE(BlockPos pos, BlockState blockState) {
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
                .setValue(zProperties.ACTIVE,
                        !getBlockState().getValue(zProperties.ACTIVE));

        for (int i = 0; i < Direction.values().length; i++)
            state.setValue(DirectionUtil.face[i],
                    getBlockState().getValue(DirectionUtil.face[i]));

        level.setBlockAndUpdate(getBlockPos(), state);

    }

}
