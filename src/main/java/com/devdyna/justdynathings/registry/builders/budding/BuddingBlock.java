package com.devdyna.justdynathings.registry.builders.budding;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.registry.builders._core.block.BlockBaseBE;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

@SuppressWarnings("null")
public class BuddingBlock extends BlockBaseBE {

    public static BooleanProperty ACTIVE = BooleanProperty.create("active");

    public BuddingBlock() {
        super(Properties.of()
                .sound(SoundType.METAL)
                .strength(2.0f));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BuddingBE(null,pos, state);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(ACTIVE, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);
    }

}
