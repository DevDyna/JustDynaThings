package com.devdyna.justdynathings.api.repair_anvils;

import com.devdyna.cakesticklib.api.RandomUtil;
import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.Actions;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.RedstoneControlledBE;
import com.direwolf20.justdirethings.util.interfacehelpers.RedstoneControlData;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.transfer.item.ItemResource;

@SuppressWarnings("null")
public abstract class FunctionalAnvilBE extends BaseMachineBE implements RedstoneControlledBE {

    public final RedstoneControlData redstoneControlData = new RedstoneControlData();

    public FunctionalAnvilBE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    @Deprecated
    public FunctionalAnvilBE(BlockPos pos, BlockState state) {
        this(null, pos, state);
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
    public void tickServer() {
        super.tickServer();

        if (!isActiveRedstone())
            return;

        var tool = getTool();

        if (tool.toStack().is(getDenyTag()))
            return;

        if (!tool.toStack().isDamageableItem())
            return;

        if (!tool.toStack().isDamaged())
            return;

        if (!extraConditions())
            return;

        onToolValid();
    }

    public boolean extraConditions() {
        return true;
    }

    public abstract void onToolValid();

    public void applySound() {
        if (!getSoundConfig())
            return;

        if (!RandomUtil.chance(level, 5))
            return;

        if (!Config.ANVILS_SOUND_EVENT.get())
            return;

        level.playSound(null, getBlockPos(),
                RandomUtil.rnd50(level)
                        ? SoundEvents.GRINDSTONE_USE
                        : RandomUtil.chance(level, 75)
                                ? SoundEvents.SMITHING_TABLE_USE
                                : SoundEvents.ANVIL_USE,
                SoundSource.BLOCKS,
                (level.getRandom().nextInt(10) + 1) * 0.01F,
                (level.getRandom().nextInt(50) + 1) * 0.01F);
    }

    public ItemResource getTool() {
        return getMachineHandler().getResource(0);
    }

    public abstract TagKey<Item> getDenyTag();

    public abstract Boolean getSoundConfig();

    public abstract Boolean ignoreDelay();

    public void repair(int v) {
        if (v <= 0)
            return;

        Actions.repairItem(getMachineHandler(), 0, getTool(), v);

        applySound();
    }

    public int getToolDamage() {
        return getTool().toStack().getDamageValue();
    }
}