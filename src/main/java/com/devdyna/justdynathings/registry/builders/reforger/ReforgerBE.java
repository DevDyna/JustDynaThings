package com.devdyna.justdynathings.registry.builders.reforger;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zBlockTags;
import com.devdyna.justdynathings.registry.types.zItemTags;
import com.devdyna.justdynathings.utils.Actions;
import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.RedstoneControlledBE;
import com.direwolf20.justdirethings.util.interfacehelpers.RedstoneControlData;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ReforgerBE extends BaseMachineBE implements RedstoneControlledBE {

    public RedstoneControlData redstoneControlData = new RedstoneControlData();

    public ReforgerBE(BlockEntityType<?> p, BlockPos b, BlockState s) {
        super(p, b, s);
        MACHINE_SLOTS = 1;
    }

    public ReforgerBE(BlockPos p, BlockState s) {
        this(zBlockEntities.REFORGER.get(), p, s);
    }

    @Override
    public RedstoneControlData getRedstoneControlData() {
        return redstoneControlData;
    }

    @Override
    public BlockEntity getBlockEntity() {
        return this;
    }

    @Override
    public void tickClient() {
    }

    @Override
    public void tickServer() {
        if (isActiveRedstone())
{        ItemStack item = getMachineHandler().getStackInSlot(0);

        BlockPos pos = getBlockPos()
                .relative(getBlockState()
                        .getValue(BlockStateProperties.FACING));

        if (!item.isEmpty())
            if (Actions.checkItemBlock(level, pos, zBlockTags.REFORGER_REPLACE, item, zItemTags.REFORGER_CATALYST)) {

                Actions.reforgerReplaceBlock(pos, level);

                playSound(pos);

                Actions.consumeItem(item, level,Config.REFORGER_CHANCE.get());

            }}
    }

        @SuppressWarnings("null")
        public void playSound(BlockPos pos) {
        level.playLocalSound(pos.getX(), pos.getY(),
                pos.getZ(),
                SoundEvents.AMETHYST_BLOCK_BREAK,
                SoundSource.BLOCKS, 100,
                LevelUtil.getRandomValue(9, level) * 0.1f, true);
    }

}