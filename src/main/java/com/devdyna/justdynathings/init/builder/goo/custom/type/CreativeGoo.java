package com.devdyna.justdynathings.init.builder.goo.custom.type;

import com.direwolf20.justdirethings.common.blockentities.basebe.GooBlockBE_Base;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import static com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base.ALIVE;

public class CreativeGoo extends GooBlockBE_Base {

    public CreativeGoo(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public void tickServer() {
        this.checkEnergy();
        this.checkSides();
        this.tickCounters();
        setChanged();
    }

    @SuppressWarnings("null")
    public void checkEnergy() {
        level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(ALIVE, true));
    }

    @SuppressWarnings("null")
    @Override
    public void setBlockToTarget(BlockState output, Direction direction) {
        if (output.hasProperty(BlockStateProperties.FACING)) {
            level.setBlockAndUpdate(getBlockPos().relative(direction),
                    output.setValue(BlockStateProperties.FACING, direction));
        } else
            level.setBlockAndUpdate(getBlockPos().relative(direction), output);

        updateSideCounter(direction, -1);
        sidedDurations.put(direction, -1);
        level.playSound(null, getBlockPos(), SoundEvents.SCULK_BLOCK_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F);

        if (level != null && !level.isClientSide) {
                level.playSound(null, getBlockPos(),
                        SoundEvents.SCULK_BLOCK_SPREAD,
                        SoundSource.BLOCKS, 1.0F, 0.25F);
        }
    }

}
