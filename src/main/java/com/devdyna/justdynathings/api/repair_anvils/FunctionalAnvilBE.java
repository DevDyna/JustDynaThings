package com.devdyna.justdynathings.api.repair_anvils;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.api.Actions;
import com.devdyna.justdynathings.api.RandomUtil;
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

        if (getTool().is(getDenyTag())
                || !getTool().toStack().isDamageableItem()
                || !getTool().toStack().isDamaged())
            return;

        if (ignoreDelay()) {
            repair(Math.min(totalToRepair, getTool().toStack().getDamageValue()));
            totalToRepair = 0;
            return;
        } else if (totalToRepair > 0) {
            totalToRepair--;
            repair(1);
            return;
        }

        whenToolValid();

    }

    public abstract void whenToolValid();

    public void applySound() {
        if (getSoundConfig())
            if (RandomUtil.chance(level, 5) && Config.ANVILS_SOUND_EVENT.get())
                level.playSound(null, getBlockPos(),
                        RandomUtil.rnd50(level)
                                ? SoundEvents.GRINDSTONE_USE
                                : RandomUtil.chance(level, 75)
                                        ? SoundEvents.SMITHING_TABLE_USE
                                        : SoundEvents.ANVIL_USE,
                        SoundSource.BLOCKS, (level.getRandom().nextInt(10) + 1) * 0.01F,
                        level.getRandom().nextInt(50) + 1 * 0.01F);
    }

    public ItemResource getTool() {
        return getMachineHandler().getResource(0);
    }

    public abstract TagKey<Item> getDenyTag();

    public abstract Boolean getSoundConfig();

    public abstract Boolean ignoreDelay();

    public void repair(int v) {
        Actions.repairItem(getMachineHandler(), 0, getTool(), v);

        applySound();
    }

    private int totalToRepair = 0;

    public int getDurabilityLeft() {
        return totalToRepair;
    }

    public void setDurabilityBatch(int totalToRepair) {
        this.totalToRepair = totalToRepair;
    }

}