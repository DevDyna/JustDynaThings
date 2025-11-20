package com.devdyna.justdynathings.registry.builders.paradox_mixer;

import java.util.List;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.Config.CommonConfig;
import com.devdyna.justdynathings.client.type.paradoxMixer.ParadoxMixerGUI;
import com.devdyna.justdynathings.registry.builders._core.block.BaseFluidMachineBlock;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.Actions;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@SuppressWarnings("null")
public class ParadoxMixerBlock extends BaseFluidMachineBlock {

    public ParadoxMixerBlock() {
        super(BlockBehaviour.Properties.of()
                .requiresCorrectToolForDrops()
                .strength(2.0f).destroyTime(2.0f)
                .sound(SoundType.CHAIN).noOcclusion()
                .isRedstoneConductor(BaseMachineBlock::never));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(zProperties.GOO_ALIVE) ? Block.box(4, 4, 4, 12, 12, 12) : Block.box(6, 6, 6, 10, 10, 10);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext c) {
        return defaultBlockState()
                .setValue(zProperties.GOO_ALIVE, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
        b.add(zProperties.GOO_ALIVE);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
        return new ParadoxMixerBE(p, s);
    }

    @Override
    public void openMenu(Player p, BlockPos b) {
        Actions.openMenu(p, (w, i, e) -> new ParadoxMixerGUI(w, i, b), b);
    }

    @Override
    public boolean isValidBE(BlockEntity b) {
        return b instanceof ParadoxMixerBE;
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
        if (Constants.ModAddonCheck.docCheck && !CommonConfig.DOC_WARNING.getAsBoolean())
            tooltipComponents.add(Component.translatable(Main.ID + ".doc.missing"));
        tooltipComponents.add(Component.translatable(Main.ID + "." + Constants.Blocks.ParadoxMixer ));
    }

}
