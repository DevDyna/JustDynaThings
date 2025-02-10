package com.devdyna.justdynathings.common.registry.builder.reforger;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.List;

import javax.annotation.Nullable;

@SuppressWarnings("null")
public class ReforgerBlock extends BaseMachineBlock {
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    public ReforgerBlock() {
        super(Properties.of()
                .sound(SoundType.METAL)
                .strength(2.0f)
                .isRedstoneConductor(BaseMachineBlock::never));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ReforgerBE(pos, state);
    }

    @Override
    public void openMenu(Player player, BlockPos blockPos) {
        player.openMenu(new SimpleMenuProvider(
                (windowId, playerInventory, playerEntity) -> new ReforgerGUI(windowId, playerInventory, blockPos),
                Component.translatable("")), (buf -> {
                    buf.writeBlockPos(blockPos);
                }));
    }

    @Override
    public boolean isValidBE(BlockEntity blockEntity) {
        return blockEntity instanceof ReforgerBE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState()
                .setValue(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite())
                .setValue(ACTIVE, true);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING);
        builder.add(ACTIVE);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
            TooltipFlag tooltipFlag) {
        if (Screen.hasControlDown()) {
            tooltipComponents.add(Component.translatable(Main.ID + "."+Constants.Material.Reforger.id+"."+Constants.ToolTip.On.id));
        } else {
            tooltipComponents.add(Component.translatable(Main.ID + "."+Constants.ToolTip.Off.id));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}