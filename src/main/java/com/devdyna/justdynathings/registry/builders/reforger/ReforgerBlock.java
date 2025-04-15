package com.devdyna.justdynathings.registry.builders.reforger;

import com.devdyna.justdynathings.client.builder.reforger.ReforgerGUI;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.Actions;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import javax.annotation.Nullable;

@SuppressWarnings("null")
public class ReforgerBlock extends BaseMachineBlock {


    public ReforgerBlock() {
        super(zProperties.MachineProp);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ReforgerBE(pos, state);
    }

    @Override
    public void openMenu(Player player, BlockPos blockPos) {
                Actions.openMenu(player,
                (windowId, playerInventory, playerEntity) -> 
                new ReforgerGUI(windowId, playerInventory, blockPos),
                blockPos);
    }

    @Override
    public boolean isValidBE(BlockEntity blockEntity) {
        return blockEntity instanceof ReforgerBE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState()
                .setValue(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite())
                .setValue(zProperties.ACTIVE, true);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder
        .add(BlockStateProperties.FACING)
        .add(zProperties.ACTIVE);
    }
}