package com.devdyna.justdynathings.init.builder.goo.creative;

import com.devdyna.justdynathings.config.ServerConfig;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import com.direwolf20.justdirethings.common.blockentities.basebe.GooBlockBE_Base;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class CreativeGooBE extends GooBlockBE_Base {

    public CreativeGooBE(BlockPos pos, BlockState state) {
        super(zBlockEntities.CREATIVE_GOO.get(), pos, state);
    }

    public int getTier() {
        return ServerConfig.GOO_CREATIVE_TIER.get();
    }

    public int counterReducer() {
        return ServerConfig.GOO_CREATIVE_COUNTER_REDUCER.get();
    }

    @Override
    public void tickServer() {
        this.checkSides();
        this.tickCounters();
        setChanged();
    }

    @Override
    public void setBlockToTarget(BlockState output, Direction direction) {
        if (output.hasProperty(BlockStateProperties.FACING)) {
            level.setBlockAndUpdate(getBlockPos().relative(direction),
                    output.setValue(BlockStateProperties.FACING, direction));
        } else
            level.setBlockAndUpdate(getBlockPos().relative(direction), output);

        updateSideCounter(direction, -1);
        sidedDurations.put(direction, -1);
        if (ServerConfig.GOO_CREATIVE_SOUND_RECIPE.get())
            level.playSound(null, getBlockPos(), SoundEvents.SCULK_BLOCK_BREAK, SoundSource.BLOCKS, 0.25F, 1.0F);
    }

}
