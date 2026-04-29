package com.devdyna.justdynathings.init.builder.ticker;

import com.devdyna.justdynathings.api.Actions;
import com.devdyna.justdynathings.api.BaseFluidMachineBlock;
import com.devdyna.justdynathings.init.types.zProperties;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import javax.annotation.Nullable;

@SuppressWarnings("null")
public class TickerBlock extends BaseFluidMachineBlock {

    public TickerBlock(Properties p) {
        super(p
                .requiresCorrectToolForDrops()
                .strength(2.0f).destroyTime(2.0f)
                .sound(SoundType.CHAIN)
                .isRedstoneConductor(BaseMachineBlock::never));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TickerBE(pos, state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState()
                .setValue(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite())
                .setValue(zProperties.ACTIVE, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder
                .add(BlockStateProperties.FACING)
                .add(zProperties.ACTIVE);
    }

    @Override
    public void openMenu(Player player, BlockPos blockPos) {
        Actions.openMenu(player,
                (windowId, playerInventory, playerEntity) -> new TickerGUI(windowId, playerInventory, blockPos),
                blockPos);
    }

    @Override
    public boolean isValidBE(BlockEntity blockEntity) {
        return blockEntity instanceof TickerBE;
    }

     
}