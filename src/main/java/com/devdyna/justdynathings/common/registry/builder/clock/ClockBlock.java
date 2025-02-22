package com.devdyna.justdynathings.common.registry.builder.clock;

import javax.annotation.Nullable;

import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

@SuppressWarnings("null")
public class ClockBlock extends BaseMachineBlock {

    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    // public static final BooleanProperty NORTH = BooleanProperty.create("north");
    // public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    // public static final BooleanProperty EAST = BooleanProperty.create("east");
    // public static final BooleanProperty WEST = BooleanProperty.create("west");
    // public static final BooleanProperty UP = BooleanProperty.create("up");
    // public static final BooleanProperty DOWN = BooleanProperty.create("down");

    public ClockBlock() {
        super(Properties.of()
                .requiresCorrectToolForDrops()
                .strength(5.0F, 6.0F)
                .sound(SoundType.COPPER_BULB));
    }

    @Override
    protected boolean isSignalSource(BlockState s) {
        return true;
    }

    @Override
    protected int getSignal(BlockState b, BlockGetter g, BlockPos p, Direction d) {
        return b.getValue(ACTIVE).booleanValue() ? 15 : 0;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ClockBE(pos, state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(ACTIVE, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);
    }

    @Override
    public void openMenu(Player player, BlockPos blockPos) {
        player.openMenu(new SimpleMenuProvider(
                (windowId, playerInventory, playerEntity) -> new ClockGUI(windowId, playerInventory, blockPos),
                Component.translatable("")), (buf -> {
                    buf.writeBlockPos(blockPos);
                }));
    }

    @Override
    public boolean isValidBE(BlockEntity b) {
        return true;
    }

}
