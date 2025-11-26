package com.devdyna.justdynathings.registry.builders.stabilizer;

import java.util.List;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.CommonConfig;
import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.builders._core.block.BlockBaseBE;
import com.devdyna.justdynathings.registry.interfaces.block.BucketInteractive;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.DirectionUtil;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("null")

public class StabilizerBlock extends BlockBaseBE implements BucketInteractive {

    public static VoxelShape[] shapes = {
            Shapes.box(0, 0, 0, 1, 0.5, 1), // down
            Shapes.box(0, 0.5, 0, 1, 1, 1), // south
            Shapes.box(0, 0, 0, 1, 1, 0.5), // up
            Shapes.box(0, 0, 0.5, 1, 1, 1), // north
            Shapes.box(0, 0, 0, 0.5, 1, 1), // west
            Shapes.box(0.5, 0, 0, 1, 1, 1), // east
    };

    public StabilizerBlock() {
        super(BlockBehaviour.Properties.of()
                .requiresCorrectToolForDrops()
                .strength(2.0f).destroyTime(2.0f)
                .sound(SoundType.CHAIN)
                .pushReaction(PushReaction.BLOCK)
                .isRedstoneConductor(BaseMachineBlock::never));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState s, BlockGetter w, BlockPos p, CollisionContext c) {
        return shapes[DirectionUtil.indexByStateFacing(s)];
    }

    @Override
    protected VoxelShape getShape(BlockState s, BlockGetter l, BlockPos p, CollisionContext c) {
        return shapes[DirectionUtil.indexByStateFacing(s)];
    }

    @Override
    @Nullable
    public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
        return new StabilizerBE(zBlockEntities.STABILIZER.get(), p, s);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext c) {
        return defaultBlockState()
                .setValue(zProperties.ENERGIZED, false)
                .setValue(zProperties.ACTIVE, false)
                .setValue(zProperties.GOO_FOUND, false)
                .setValue(BlockStateProperties.FACING,
                        c.getPlayer().isShiftKeyDown() ? c.getClickedFace() : c.getClickedFace().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
        b.add(zProperties.ENERGIZED, zProperties.ACTIVE, zProperties.GOO_FOUND, BlockStateProperties.FACING);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
            Player player, InteractionHand hand, BlockHitResult hitResult) {
        return bucketAction(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
            TooltipFlag tooltipFlag) {
        if (Constants.ModAddonCheck.docCheck && !CommonConfig.DOC_WARNING.getAsBoolean())
            tooltipComponents.add(Component.translatable(Main.ID + ".doc.missing"));
        tooltipComponents.add(Component.translatable(Main.ID + "." + Constants.Blocks.Stabilizer));
    }

}
