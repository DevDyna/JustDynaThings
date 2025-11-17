package com.devdyna.justdynathings.registry.builders.lightwand;

import java.util.function.ToIntFunction;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.registry.builders.PhaseBox;
import com.devdyna.justdynathings.registry.types.zItems;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;
import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LightBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("null")
public class LightWandBlock extends TransparentBlock {

    public static final ToIntFunction<BlockState> LIGHT_EMISSION = s -> 15;

    public LightWandBlock(Properties properties) {
        super(Properties.of().sound(SoundType.SCULK)
                .replaceable()
                .strength(-1.0F, 3600000.8F)
                .mapColor(s -> s.getValue(BlockStateProperties.WATERLOGGED) ? MapColor.WATER : MapColor.NONE)
                .noLootTable()
                .noOcclusion()
                .isSuffocating(BaseMachineBlock::never)
                .isViewBlocking(BaseMachineBlock::never)
                .instabreak()
                .pushReaction(PushReaction.DESTROY)
                .lightLevel(LIGHT_EMISSION));
        registerDefaultState(stateDefinition.any());

    }


    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return context.isHoldingItem(zItems.LIGHT_WAND.get()) ? Shapes.block() : Shapes.empty();
    }

    @Override
    protected boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @Override
    protected float getShadeBrightness(BlockState state, BlockGetter level, BlockPos pos) {
        return 1.0F;
    }


    @Override
    public VoxelShape getCollisionShape(BlockState s, BlockGetter w, BlockPos p, CollisionContext c) {
        return Shapes.empty();
    }

}
