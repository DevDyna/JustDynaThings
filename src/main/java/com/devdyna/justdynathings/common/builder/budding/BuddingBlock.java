package com.devdyna.justdynathings.common.builder.budding;

import java.util.List;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.common.core.BlockBaseBE;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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

    private int FEcost;
    private int FEsize;
    private int FLsize;
    private int FLcost;

    private Block smallCluster;
    private Block mediumCluster;
    private Block largeCluster;
    private Block finalCluster;

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
    public boolean isValidBE(BlockEntity blockEntity) {
        return blockEntity instanceof BuddingBE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(ACTIVE, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);
    }

        @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
            TooltipFlag tooltipFlag) {
        if (Screen.hasControlDown()) {
            tooltipComponents.add(Component.translatable(Main.ID + "."+Constants.Material.Budding.ID.id+"."+Constants.ToolTip.On.id));
        } else {
            tooltipComponents.add(Component.translatable(Main.ID + "."+Constants.ToolTip.Off.id));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

}
