package com.devdyna.justdynathings.common.registry.builder.budding;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.common.registry.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class DecayBuddingBlock extends BuddingBlock {

    private int FEcost;
    private int FEsize;
    private int FLsize;
    private int FLcost;

    private Block smallCluster;
    private Block mediumCluster;
    private Block largeCluster;
    private Block finalCluster;

    public static IntegerProperty AGE = BlockStateProperties.AGE_4;
    public static BooleanProperty ALIVE = BooleanProperty.create("alive");

    public DecayBuddingBlock(int FEcost, int FEsize, int FLcost, int FLsize, Block smallCluster, Block mediumCluster,
            Block largeCluster, Block finalCluster) {
        super(FEcost, FEsize, FLcost, FLsize, smallCluster, mediumCluster, largeCluster, finalCluster);
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
        return new DecayBuddingBE(pos, state, FEcost, FEsize, FLcost, FLsize,
                smallCluster, mediumCluster, largeCluster, finalCluster);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(ACTIVE, false).setValue(AGE, 0).setValue(ALIVE, true);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE).add(AGE).add(ALIVE);
    }

    @SuppressWarnings("null")
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
            Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (stack.is(Material.FLAWED_REVITALIZER) && !state.getValue(ALIVE)) {
            stack.shrink(1);
            level.setBlockAndUpdate(pos,
                    state.setValue(AGE, 0).setValue(ACTIVE, state.getValue(ACTIVE)));
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

}
