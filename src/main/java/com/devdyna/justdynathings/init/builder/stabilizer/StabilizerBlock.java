package com.devdyna.justdynathings.init.builder.stabilizer;

import javax.annotation.Nullable;

import com.devdyna.cakesticklib.api.aspect.logic.BucketInteraction;

import com.devdyna.justdynathings.api.BlockBaseBE;
import com.devdyna.justdynathings.init.types.zBlockEntities;

import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StabilizerBlock extends BlockBaseBE implements BucketInteraction {

    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
    public static final BooleanProperty ENERGIZED = BooleanProperty.create("energized");
    public static final BooleanProperty VALID_FACING = BooleanProperty.create("valid_facing");

    public static VoxelShape[] shapes = {
            Shapes.box(0, 0, 0, 1, 0.5, 1), // down
            Shapes.box(0, 0.5, 0, 1, 1, 1), // south
            Shapes.box(0, 0, 0, 1, 1, 0.5), // up
            Shapes.box(0, 0, 0.5, 1, 1, 1), // north
            Shapes.box(0, 0, 0, 0.5, 1, 1), // west
            Shapes.box(0.5, 0, 0, 1, 1, 1), // east
    };

    public StabilizerBlock(Properties p) {
        super(p
                .requiresCorrectToolForDrops()
                .strength(2.0f).destroyTime(2.0f)
                .sound(SoundType.CHAIN)
                .pushReaction(PushReaction.BLOCK)
                .isRedstoneConductor(BaseMachineBlock::never));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState s, BlockGetter w, BlockPos p, CollisionContext c) {
        return shapes[s.getValue(BlockStateProperties.FACING).get3DDataValue()];
    }

    @Override
    protected VoxelShape getShape(BlockState s, BlockGetter l, BlockPos p, CollisionContext c) {
        return shapes[s.getValue(BlockStateProperties.FACING).get3DDataValue()];
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
        return new StabilizerBE(zBlockEntities.STABILIZER.get(), p, s);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext c) {
        return defaultBlockState()
                .setValue(ENERGIZED, false)
                .setValue(ACTIVE, false)
                .setValue(VALID_FACING, false)
                .setValue(BlockStateProperties.FACING,
                        c.getPlayer().isShiftKeyDown() ? c.getClickedFace() : c.getClickedFace().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
        b.add(ENERGIZED, ACTIVE, VALID_FACING, BlockStateProperties.FACING);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
            Player player, InteractionHand hand, BlockHitResult hitResult) {
        return bucketAction(stack, state, level, pos, player, hand, hitResult);
    }

}
