package com.devdyna.justdynathings.registry.builders.ferritecore_clock;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.client.builder.clock.ClockGUI;
import com.devdyna.justdynathings.registry.types.zProperties;
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

    public ClockBlock() {
        super(zProperties.MachineProp.sound(SoundType.COPPER_BULB));
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player,
            BlockHitResult hitResult) {

        if (player.isCrouching()) {
            level.setBlockAndUpdate(pos, state.setValue(DirectionUtil.StateByDir(hitResult.getDirection()),
                    !state.getValue(DirectionUtil.StateByDir(hitResult.getDirection()))));
                    //TODO sound
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
        return b.getValue(zProperties.ACTIVE).booleanValue()
                && b.getValue(DirectionUtil.StateByDir(d.getOpposite())).booleanValue()
                        ? 15
                        : 0;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext c) {
        for (BooleanProperty face : DirectionUtil.face) {
            defaultBlockState().setValue(face, false);
        }
        return defaultBlockState().setValue(zProperties.ACTIVE, false);

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
        for (BooleanProperty face : DirectionUtil.face) {
            b.add(face);
        }
        b.add(zProperties.ACTIVE);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ClockBE(pos, state);
    }

    @Override
    public void openMenu(Player player, BlockPos blockPos) {
        Actions.openMenu(player,
                (windowId, playerInventory, playerEntity) -> new ClockGUI(windowId, playerInventory, blockPos),
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
