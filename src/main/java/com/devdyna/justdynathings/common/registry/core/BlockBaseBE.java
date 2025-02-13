package com.devdyna.justdynathings.common.registry.core;

import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("null")
public abstract class BlockBaseBE extends Block implements EntityBlock {
    public BlockBaseBE(Properties properties) {
        super(properties);
    }

    // public abstract boolean isValidBE(BlockEntity blockEntity);

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state,
            BlockEntityType<T> type) {
        if (level.isClientSide()) {
            return (lvl, pos, blockState, t) -> {
                if (t instanceof BaseMachineBE tile) {
                    tile.tickClient();
                }
            };
        }
        return (lvl, pos, blockState, t) -> {
            if (t instanceof BaseMachineBE tile) {
                tile.tickServer();
            }
        };
    }

}