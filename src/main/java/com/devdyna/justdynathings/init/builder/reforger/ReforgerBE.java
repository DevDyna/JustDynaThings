package com.devdyna.justdynathings.init.builder.reforger;

import com.devdyna.justdynathings.init.Material;
import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.RedstoneControlledBE;
import com.direwolf20.justdirethings.util.MiscHelpers;
import com.direwolf20.justdirethings.util.interfacehelpers.RedstoneControlData;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.common.Tags;
import com.devdyna.justdynathings.utils.Math;

@SuppressWarnings("null")
public class ReforgerBE extends BaseMachineBE implements RedstoneControlledBE {

    public RedstoneControlData redstoneControlData = new RedstoneControlData();

    public ReforgerBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
        MACHINE_SLOTS = 1;
    }

    public ReforgerBE(BlockPos pPos, BlockState pBlockState) {
        this(Material.REFORGER_BE.get(), pPos, pBlockState);
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
        super.tickServer();
        run();
    }

    public void run() {
        ItemStack tool = getMachineHandler().getStackInSlot(0);
        if (tool.isEmpty()) {
            getRedstoneControlData().pulsed = false;
            return;
        }

        if (!canRun)
            return;

        BlockPos pos = getBlockPos().relative(getBlockState().getValue(BlockStateProperties.FACING));
        if (level.getBlockState(pos).is(BlockTags.STONE_ORE_REPLACEABLES) && tool.is(Tags.Items.GEMS_DIAMOND)) {
            level.setBlockAndUpdate(pos,
                    LevelUtil
                            .ResourceByTag(Tags.Blocks.ORES_IN_GROUND_STONE,
                                    Math.getRandomValue(LevelUtil.getSizeTag(Tags.Blocks.ORES_IN_GROUND_STONE)))
                            .defaultBlockState());
        }
    }

    @Override
    public boolean isDefaultSettings() {
        if (!super.isDefaultSettings())
            return false;
        if (tickSpeed != 20)
            return false;
        if (!getRedstoneControlData().equals(getDefaultRedstoneData()))
            return false;
        return true;
    }

    public boolean canRun = (getRedstoneControlData().redstoneMode.equals(MiscHelpers.RedstoneMode.HIGH)
            && getRedstoneControlData().receivingRedstone)
            || (getRedstoneControlData().redstoneMode.equals(MiscHelpers.RedstoneMode.LOW)
                    && !getRedstoneControlData().receivingRedstone)
            || getRedstoneControlData().redstoneMode.equals(MiscHelpers.RedstoneMode.IGNORED)
            || (getRedstoneControlData().pulsed
                    && getRedstoneControlData().redstoneMode.equals(MiscHelpers.RedstoneMode.PULSE));

}