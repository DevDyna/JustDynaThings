package com.devdyna.justdynathings.common.registry.core.builders.budding;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.common.registry.core.builder.block.BlockBaseBE;

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

    public Block smallCluster;
    public Block mediumCluster;
    public Block largeCluster;
    public Block finalCluster;

    public BuddingBlock(Block smallCluster, Block mediumCluster,
            Block largeCluster, Block finalCluster) {
        super(Properties.of()
                .sound(SoundType.METAL)
                .strength(2.0f));
        this.smallCluster = smallCluster;
        this.mediumCluster = mediumCluster;
        this.largeCluster = largeCluster;
        this.finalCluster = finalCluster;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BuddingBE(pos, state,
                smallCluster, mediumCluster, largeCluster, finalCluster);
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
