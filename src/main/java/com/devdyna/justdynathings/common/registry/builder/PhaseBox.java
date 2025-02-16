package com.devdyna.justdynathings.common.registry.builder;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.TransparentBlock;
import com.direwolf20.justdirethings.datagen.JustDireItemTags;

public class PhaseBox extends TransparentBlock {

    public static final BooleanProperty SOLID = BooleanProperty.create("solid");

    public PhaseBox() {
        super(Properties.of().sound(SoundType.COPPER_BULB)
                .noOcclusion()
                .isSuffocating(BaseMachineBlock::never)
                .isViewBlocking(BaseMachineBlock::never)
                .instabreak()
                .pushReaction(PushReaction.DESTROY));
        this.registerDefaultState(stateDefinition.any()
                .setValue(SOLID, true));
    }

    @SuppressWarnings("null")
    @Override
    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    @SuppressWarnings("null")
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return state.getValue(SOLID) ? state.getShape(world, pos) : Shapes.empty();
    }

    @SuppressWarnings("null")
    @Override
    protected float getShadeBrightness(BlockState p_308911_, BlockGetter p_308952_, BlockPos p_308918_) {
        return (!p_308911_.getValue(SOLID) ? 1 : 0) * 1.0F;
    }

    @SuppressWarnings("null")
    @Override
    protected boolean propagatesSkylightDown(BlockState p_309084_, BlockGetter p_309133_, BlockPos p_309097_) {
        return !p_309084_.getValue(SOLID);
    }

    @SuppressWarnings("null")
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(SOLID);
    }

    @SuppressWarnings("null")
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
            Player player, InteractionHand hand, BlockHitResult hitResult) {
        BlockState clicked = level.getBlockState(hitResult.getBlockPos());
        if (player.isCrouching()) {

            if (stack.isEmpty())
                return success(stack, clicked, level, pos);
            else
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

        } else
            return success(stack, clicked, level, pos);

    }

    private ItemInteractionResult success(ItemStack stack, BlockState state, Level level, BlockPos pos) {

        if (Config.PHASEBOX_WRENCHABLE.get()
                ? stack.is(JustDireItemTags.WRENCHES) || stack.is(JustDireItemTags.TOOLS_WRENCH)
                : true) {

            level.playLocalSound(pos.getX(), pos.getY(),
                    pos.getZ(),
                    state.getValue(SOLID) ? SoundEvents.COPPER_TRAPDOOR_CLOSE : SoundEvents.COPPER_TRAPDOOR_OPEN,
                    SoundSource.BLOCKS, 100,
                    LevelUtil.getRandomValue(9, level) * 0.1f, true);
            level.setBlockAndUpdate(pos, state.setValue(SOLID, !state.getValue(SOLID)));
        
        }
        return ItemInteractionResult.SUCCESS;
    }
}
