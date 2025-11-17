package com.devdyna.justdynathings.registry.builders.lightwand;

import com.devdyna.justdynathings.registry.types.zItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LightBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("null")
public class LightWandBlock extends LightBlock {

    public LightWandBlock() {
        super(Properties.of()
                .sound(SoundType.EMPTY)
                .replaceable()
                .noOcclusion()
                .isSuffocating((s, g, p) -> false)
                .isViewBlocking((s, g, p) -> false)
                .instabreak()
                .mapColor(s -> s.getValue(BlockStateProperties.WATERLOGGED) ? MapColor.WATER : MapColor.NONE)
                .lightLevel(s -> s.getValue(LightBlock.LEVEL))
                .pushReaction(PushReaction.DESTROY));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return context.isHoldingItem(zItems.LIGHT_WAND.get()) || context.isHoldingItem(zItems.ADVANCED_LIGHT_WAND.get())
                ? Shapes.block()
                : Shapes.empty();
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player,
            BlockHitResult hitResult) {
        if (!level.isClientSide) {
            level.setBlock(pos, state.cycle(LEVEL), 2);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.CONSUME;
        }
    }

}
