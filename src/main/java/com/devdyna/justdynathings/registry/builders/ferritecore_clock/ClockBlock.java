package com.devdyna.justdynathings.registry.builders.ferritecore_clock;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.client.builder.clock.ClockGUI;
import com.devdyna.justdynathings.utils.Actions;
import com.devdyna.justdynathings.utils.DirectionUtil;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

@SuppressWarnings("null")
public class ClockBlock extends BaseMachineBlock {

    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    public ClockBlock() {
        super(Properties.of()
                .requiresCorrectToolForDrops()
                .strength(5.0F, 6.0F)
                .sound(SoundType.COPPER_BULB)
                .isRedstoneConductor(BaseMachineBlock::never));
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player,
            BlockHitResult hitResult) {

        if (player.isCrouching()) {
            level.setBlockAndUpdate(pos, state.setValue(DirectionUtil.StateByDir(hitResult.getDirection()),
                    !state.getValue(DirectionUtil.StateByDir(hitResult.getDirection()))));
            return InteractionResult.SUCCESS;
        } else {
            this.openMenu(player, pos);
            return InteractionResult.SUCCESS;
        }
    }

    @Override
    protected boolean isSignalSource(BlockState s) {
        return true;
    }

    @Override
    protected int getSignal(BlockState b, BlockGetter g, BlockPos p, Direction d) {
        return b.getValue(ACTIVE).booleanValue()
                && b.getValue(DirectionUtil.StateByDir(d.getOpposite())).booleanValue()
                        ? 15
                        : 0;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState()
                .setValue(DirectionUtil.face[0], false)
                .setValue(DirectionUtil.face[1], false)
                .setValue(DirectionUtil.face[2], false)
                .setValue(DirectionUtil.face[3], false)
                .setValue(DirectionUtil.face[4], false)
                .setValue(DirectionUtil.face[5], false)
                .setValue(ACTIVE, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder
                .add(DirectionUtil.face[0])
                .add(DirectionUtil.face[1])
                .add(DirectionUtil.face[2])
                .add(DirectionUtil.face[3])
                .add(DirectionUtil.face[4])
                .add(DirectionUtil.face[5])
                .add(ACTIVE);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ClockBE(pos, state);
    }

    @Override
    public void openMenu(Player player, BlockPos blockPos) {
                Actions.openMenu(player,
                (windowId, playerInventory, playerEntity) -> 
                new ClockGUI(windowId, playerInventory, blockPos),
                blockPos);
    }

    @Override
    public boolean isValidBE(BlockEntity b) {
        return true;
    }

    // brute-force fix for invalid rotation
    @Override
    public BlockState direRotate(BlockState s, Rotation r) {
        return s;
    }

    @Override
    public BlockState direRotate(BlockState s, LevelAccessor l, BlockPos p, Rotation d) {
        return s;
    }

    @Override
    public BlockState rotate(BlockState s, Rotation r) {
        return s;
    }

}
