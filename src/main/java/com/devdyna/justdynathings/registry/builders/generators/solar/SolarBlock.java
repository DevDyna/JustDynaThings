package com.devdyna.justdynathings.registry.builders.generators.solar;

import java.util.Arrays;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.client.builder.solarGen.SolarGUI;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.Actions;
import com.devdyna.justdynathings.utils.DirectionUtil;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("null")
public class SolarBlock extends BaseMachineBlock {

    public SolarBlock() {
        super(zProperties.MachineProp);
    }

    @Override
    protected VoxelShape getShape(BlockState s, BlockGetter l, BlockPos p, CollisionContext c) {
        return Block.box(0, 0, 0, 16, 4, 16);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext c) {
        var state = defaultBlockState()
                .setValue(zProperties.ACTIVE, false);

        // BlockStateProperties.HORIZONTAL_FACING.getAllValues().forEach(d -> {

        // state.setValue(
        // DirectionUtil.horizontal_face[Arrays.asList(DirectionUtil.HORIZONTAL).indexOf(d.value())],
        // c.getLevel().getBlockState(c.getClickedPos().relative(d.value()))
        // .is(zBlocks.SOLARGEN.get()));
        // });

        return state;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
        b.add(zProperties.ACTIVE);
        // for (BooleanProperty face : DirectionUtil.horizontal_face) {
        // b.add(face);
        // }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new SolarBE(pos, state);
    }

    @Override
    public boolean isValidBE(BlockEntity be) {
        return be instanceof SolarBE;
    }

    @Override
    public void openMenu(Player player, BlockPos blockPos) {
        Actions.openMenu(player,
                (windowId, playerInventory, playerEntity) -> new SolarGUI(windowId, playerInventory, blockPos),
                blockPos);
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
