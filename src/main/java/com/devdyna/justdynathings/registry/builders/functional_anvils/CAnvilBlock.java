package com.devdyna.justdynathings.registry.builders.functional_anvils;

import com.devdyna.justdynathings.ConfigCommon;
import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.interfaces.block.BucketInteractive;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import java.util.List;

import javax.annotation.Nullable;

@SuppressWarnings("null")
public abstract class CAnvilBlock extends BaseMachineBlock implements BucketInteractive{

    private static final VoxelShape BASE = Block.box(2.0, 0.0, 2.0, 14.0, 4.0, 14.0);
    private static final VoxelShape X_LEG1 = Block.box(3.0, 4.0, 4.0, 13.0, 5.0, 12.0);
    private static final VoxelShape X_LEG2 = Block.box(4.0, 5.0, 6.0, 12.0, 10.0, 10.0);
    private static final VoxelShape X_TOP = Block.box(0.0, 10.0, 3.0, 16.0, 16.0, 13.0);
    private static final VoxelShape Z_LEG1 = Block.box(4.0, 4.0, 3.0, 12.0, 5.0, 13.0);
    private static final VoxelShape Z_LEG2 = Block.box(6.0, 5.0, 4.0, 10.0, 10.0, 12.0);
    private static final VoxelShape Z_TOP = Block.box(3.0, 10.0, 0.0, 13.0, 16.0, 16.0);
    private static final VoxelShape X_AXIS_AABB = Shapes.or(BASE, X_LEG1, X_LEG2, X_TOP);
    private static final VoxelShape Z_AXIS_AABB = Shapes.or(BASE, Z_LEG1, Z_LEG2, Z_TOP);

    public CAnvilBlock() {
        super(BlockBehaviour.Properties.of()
                .requiresCorrectToolForDrops()
                .strength(4.0f).destroyTime(4.0f)
                .isRedstoneConductor(BaseMachineBlock::never)
                .sound(SoundType.ANVIL)
                .pushReaction(PushReaction.BLOCK));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
        return new CAnvilBE(p, s);
    }

    @Override
    public void openMenu(Player p, BlockPos b) {
    }

    @Override
    public boolean isValidBE(BlockEntity b) {
        return b instanceof CAnvilBE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext c) {
        return this.defaultBlockState()
                .setValue(AnvilBlock.FACING, c.getHorizontalDirection().getClockWise());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
        b.add(AnvilBlock.FACING);
    }

    @Override
    protected VoxelShape getShape(BlockState s, BlockGetter l, BlockPos p, CollisionContext c) {
        return s.getValue(AnvilBlock.FACING).getAxis() == Direction.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
            TooltipFlag tooltipFlag) {
        if (Constants.ModAddonCheck.docCheck && !ConfigCommon.DOC_WARNING.getAsBoolean())
            tooltipComponents.add(Component.translatable(Main.ID + ".doc.missing"));
    }

    @Override
    public BlockState direRotate(BlockState s, Rotation r) {
        return s.cycle(AnvilBlock.FACING);
    }

    @Override
    public BlockState direRotate(BlockState s, LevelAccessor l, BlockPos p, Rotation d) {
        return s.cycle(AnvilBlock.FACING);
    }

    @Override
    public BlockState rotate(BlockState s, Rotation r) {
        return s.cycle(AnvilBlock.FACING);
    }

    /**
     * Enable/Disable bucket actions related to this block
     */
    public abstract boolean supportFluidContent();

      @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
            Player player, InteractionHand hand, BlockHitResult hitResult) {
                if(supportFluidContent())
              return  bucketAction(stack, state, level, pos, player, hand, hitResult);
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }
}