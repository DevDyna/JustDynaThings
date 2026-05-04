package com.devdyna.justdynathings.init.builder.fluid_mixer;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.api.Actions;
import com.devdyna.justdynathings.api.BaseFluidMachineBlock;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("null")
public class SimpleFluidMixerBlock extends BaseFluidMachineBlock {

    public SimpleFluidMixerBlock(Properties p) {
        super(p
                .requiresCorrectToolForDrops()
                .strength(2.0f).destroyTime(2.0f)
                .sound(SoundType.CHAIN).noOcclusion()
                .isRedstoneConductor(BaseMachineBlock::never));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.0625, 0.875, 0.0625, 0.9375, 1, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0, 0.0625, 0.9375, 0.375, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.375, 0, 1, 0.5625, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0, 0.6875, 0, 1, 0.875, 1), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0625, 0.5625, 0.0625, 0.9375, 0.6875, 0.9375), BooleanOp.OR);
        return shape;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext c) {
        return defaultBlockState();
    }

    // @Override
    // protected void createBlockStateDefinition(StateDefinition.Builder<Block,
    // BlockState> b) {
    // b.add(zProperties.GOO_ALIVE);
    // }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
        return new SimpleFluidMixerBE(p, s);
    }

    @Override
    public void openMenu(Player p, BlockPos b) {
        Actions.openMenu(p, (w, i, e) -> new SimpleFluidMixerGUI(w, i, b), b);
    }

    @Override
    public boolean isValidBE(BlockEntity b) {
        return b instanceof SimpleFluidMixerBE;
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
    // TODO rework
    // @Override
    // public void appendHoverText(ItemStack stack, TooltipContext context,
    // List<Component> tooltipComponents,
    // TooltipFlag tooltipFlag) {
    // if (Constants.ModAddonCheck.docCheck &&
    // !CommonConfig.DOC_WARNING.getAsBoolean())
    // tooltipComponents.add(Component.translatable(Main.ID + ".doc.missing"));
    // tooltipComponents.add(Component.translatable(Main.ID + "." +
    // Constants.Blocks.ParadoxMixer ));
    // }

}
