package com.devdyna.justdynathings.registry.builders.ferricore_clock;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.client.builder.clock.ClockGUI;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.Actions;
import com.devdyna.justdynathings.utils.DirectionUtil;
import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseMachineBlock;
import com.direwolf20.justdirethings.datagen.JustDireItemTags;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

@SuppressWarnings("null")
public class ClockBlock extends BaseMachineBlock {

    public ClockBlock() {
        super(zProperties.MachineProp.sound(SoundType.COPPER_BULB));
    }

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player,
            BlockHitResult hitResult) {
        var value = state.getValue((BooleanProperty) DirectionUtil.StateByDir(hitResult.getDirection()));
        var item = player.getMainHandItem();

        if (player.isCrouching() &&
                (Config.FERRICORE_CLOCK_WRENCHABLE.get()
                        ? item.is(JustDireItemTags.WRENCHES) || item.is(JustDireItemTags.TOOLS_WRENCH)
                        : true)) {
            this.openMenu(player, pos);
            return InteractionResult.SUCCESS;
        } else {
            level.setBlockAndUpdate(pos,
                    state.setValue((BooleanProperty) DirectionUtil.StateByDir(hitResult.getDirection()),
                            !value.booleanValue()));

            applySound(level, player, pos, value);
            return InteractionResult.SUCCESS;
        }
    }

    /**
     * add sound events
     * 
     * @param pos
     */
    public void applySound(Level l, Player p, BlockPos pos, boolean state) {
        if (LevelUtil.chance(50, l))
            l.playSound(p, pos, state ? SoundEvents.COPPER_BULB_TURN_ON : SoundEvents.COPPER_BULB_TURN_OFF,
                    SoundSource.BLOCKS, l.random.nextInt(50) + 1 * 0.01F,
                    l.random.nextInt(50) + 1 * 0.01F);
    }

    @Override
    protected boolean isSignalSource(BlockState s) {
        return true;
    }

    @Override
    protected int getSignal(BlockState b, BlockGetter g, BlockPos p, Direction d) {
        return b.getValue(zProperties.ACTIVE).booleanValue()
                && b.getValue((BooleanProperty) DirectionUtil.StateByDir(d.getOpposite())).booleanValue()
                        ? 15
                        : 0;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext c) {
        for (BooleanProperty face : DirectionUtil.face) {
            defaultBlockState().setValue(face, false);
        }
        return defaultBlockState().setValue(zProperties.ACTIVE, false);

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> b) {
        for (BooleanProperty face : DirectionUtil.face) {
            b.add(face);
        }
        b.add(zProperties.ACTIVE);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ClockBE(pos, state);
    }

    @Override
    public void openMenu(Player player, BlockPos blockPos) {
        Actions.openMenu(player,
                (windowId, playerInventory, playerEntity) -> new ClockGUI(windowId, playerInventory, blockPos),
                blockPos);
    }

    @Override
    public boolean isValidBE(BlockEntity b) {
        return true;
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

}
