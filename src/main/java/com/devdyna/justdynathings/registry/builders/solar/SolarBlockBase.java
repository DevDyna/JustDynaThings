package com.devdyna.justdynathings.registry.builders.solar;

import java.util.List;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.interfaces.block.Harvestable;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("null")
public class SolarBlockBase extends BaseMachineBlock implements Harvestable {

    public SolarBlockBase() {
        super(zProperties.MachineProp);
    }

    @Override
    protected VoxelShape getShape(BlockState s, BlockGetter l, BlockPos p, CollisionContext c) {
        return Block.box(0, 0, 0, 16, 4, 16);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext c) {
        return defaultBlockState().setValue(zProperties.ACTIVE, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
        b.add(zProperties.ACTIVE);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
            Player player, InteractionHand hand, BlockHitResult hitResult) {

        if (canHarvest(stack, state, player, hand, pos, level))
            return ItemInteractionResult.SUCCESS;

        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
        return new SolarBaseBE(p, s);
    }

    @Override
    public boolean isValidBE(BlockEntity b) {
        return b instanceof SolarBaseBE;
    }

    @Override
    public void openMenu(Player p, BlockPos b) {
    }

    // brute-force fix for invalid rotation
    @Override
    public BlockState direRotate(BlockState s, Rotation r) {
        return s;
    }

    @Override
    public BlockState direRotate(BlockState s, LevelAccessor l, BlockPos p, Rotation d) {
        return s;
    }

    @Override
    public BlockState rotate(BlockState s, Rotation r) {
        return s;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
            TooltipFlag tooltipFlag) {
        if (!Constants.ModAddonCheck.GuideMe && Config.GUIDEME_WARNING.getAsBoolean())
            tooltipComponents.add(Component.translatable(Main.ID + ".guideme.missing"));
        tooltipComponents.add(Component.translatable(Main.ID + "." + Constants.SolarPanelType + ".tip"));
    }

    @Override
    public boolean requireWrench() {
        return true;
    }

    @Override
    public boolean requireCrouching() {
        return true;
    }

    @Override
    public List<ItemStack> getResult(BlockState state, Player player,
            BlockPos pos, Level level) {
        return Block.getDrops(state, (ServerLevel) level, pos, null, player, player.getMainHandItem());
    }

}
