package com.devdyna.justdynathings.registry.builders;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.registry.types.zProperties;
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
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.block.TransparentBlock;
import com.direwolf20.justdirethings.datagen.JustDireItemTags;

@SuppressWarnings("null")
public class PhaseBox extends TransparentBlock {

    public PhaseBox() {
        super(Properties.of().sound(SoundType.AMETHYST)
                .noOcclusion()
                .isSuffocating(BaseMachineBlock::never)
                .isViewBlocking(BaseMachineBlock::never)
                .instabreak()
                .pushReaction(PushReaction.DESTROY));
        this.registerDefaultState(stateDefinition.any()
                .setValue(zProperties.SOLID, true));
    }

    @Override
    protected boolean isPathfindable(BlockState s, PathComputationType p) {
        return false;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState s, BlockGetter w, BlockPos p, CollisionContext c) {
        return s.getValue(zProperties.SOLID) ? s.getShape(w, p) : Shapes.empty();
    }

    @Override
    protected float getShadeBrightness(BlockState s, BlockGetter g, BlockPos p) {
        return (!s.getValue(zProperties.SOLID) ? 1 : 0) * 1.0F;
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState s, BlockGetter g, BlockPos p) {
        return !s.getValue(zProperties.SOLID);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
        b.add(zProperties.SOLID);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack i, BlockState s, Level l, BlockPos pos,
            Player p, InteractionHand h, BlockHitResult t) {
        BlockState clicked = l.getBlockState(t.getBlockPos());
        if (p.isCrouching()) {

            if (i.isEmpty())
                return success(i, clicked, l, pos);
            else
                return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;

        } else
            return success(i, clicked, l, pos);

    }

    private ItemInteractionResult success(ItemStack i, BlockState s, Level l, BlockPos pos) {

        if (Config.PHASEBOX_WRENCHABLE.get()
                ? i.is(JustDireItemTags.WRENCHES) || i.is(JustDireItemTags.TOOLS_WRENCH)
                : true) {

            l.playLocalSound(pos.getX(), pos.getY(),
                    pos.getZ(),
                    s.getValue(zProperties.SOLID) ? SoundEvents.COPPER_TRAPDOOR_CLOSE
                            : SoundEvents.COPPER_TRAPDOOR_OPEN,
                    SoundSource.BLOCKS, 100,
                    LevelUtil.getRandomValue(9, l) * 0.1f, true);
            l.setBlockAndUpdate(pos, s.setValue(zProperties.SOLID, !s.getValue(zProperties.SOLID)));

        }
        return ItemInteractionResult.SUCCESS;
    }
}
