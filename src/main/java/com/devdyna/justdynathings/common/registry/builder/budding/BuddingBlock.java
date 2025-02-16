package com.devdyna.justdynathings.common.registry.builder.budding;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import com.devdyna.justdynathings.common.registry.core.BlockBaseBE;

@SuppressWarnings("null")
public class BuddingBlock extends BlockBaseBE {

    public static BooleanProperty ACTIVE = BooleanProperty.create("active");

    public int FEcost;
    public int FEsize;
    public int FLsize;
    public int FLcost;

    public Block smallCluster;
    public Block mediumCluster;
    public Block largeCluster;
    public Block finalCluster;

    public BuddingBlock(int FEcost, int FEsize, int FLcost, int FLsize, Block smallCluster, Block mediumCluster,
            Block largeCluster, Block finalCluster) {
        super(Properties.of()
                .sound(SoundType.METAL)
                .strength(2.0f));
        this.FEcost = FEcost;
        this.FEsize = FEsize;
        this.FLcost = FLcost;
        this.FLsize = FLsize;
        this.smallCluster = smallCluster;
        this.mediumCluster = mediumCluster;
        this.largeCluster = largeCluster;
        this.finalCluster = finalCluster;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BuddingBE(pos, state, FEcost, FEsize, FLcost, FLsize,
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
