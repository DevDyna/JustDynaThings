package com.devdyna.justdynathings.registry.builders.thermo;

import java.util.List;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.client.builder.thermoGen.ThermoGUI;
import com.devdyna.justdynathings.config.common;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.Actions;
import com.devdyna.justdynathings.utils.ShapeUtil;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("null")
public class ThermoBlock extends BaseMachineBlock {

    public ThermoBlock() {
        super(zProperties.MachineProp);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext c) {
        return defaultBlockState()
                .setValue(BlockStateProperties.FACING, c.getClickedFace().getOpposite())
                .setValue(zProperties.ACTIVE, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
        b.add(BlockStateProperties.FACING, zProperties.ACTIVE);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
        return new ThermoBE(p, s);
    }

    @Override
    public void openMenu(Player p, BlockPos b) {
        Actions.openMenu(p, (w, i, e) -> new ThermoGUI(w, i, b), b);
    }

    @Override
    public boolean isValidBE(BlockEntity b) {
        return b instanceof ThermoBE;
    }

    @Override
    protected VoxelShape getShape(BlockState s, BlockGetter l, BlockPos p, CollisionContext c) {
        VoxelShape shape = Shapes.empty();

        switch (s.getValue(BlockStateProperties.FACING)) {
            case NORTH:
                shape = ShapeUtil.ThermoGen.north;
                break;
            case SOUTH:
                shape = ShapeUtil.ThermoGen.south;
                break;
            case EAST:
                shape = ShapeUtil.ThermoGen.east;
                break;
            case WEST:
                shape = ShapeUtil.ThermoGen.west;
                break;
            case UP:
                shape = ShapeUtil.ThermoGen.up;
                break;
            case DOWN:
                shape = ShapeUtil.ThermoGen.down;
                break;
            default:
                break;
        }

        return shape.optimize();
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
            TooltipFlag tooltipFlag) {
        if (!Constants.ModAddonCheck.GuideMe && common.GUIDEME_WARNING.getAsBoolean())
            tooltipComponents.add(Component.translatable(Main.ID + ".guideme.missing"));
            tooltipComponents.add(Component.translatable(Main.ID + "." + Constants.Blocks.ThermoGen + ".tip"));
    }

}
