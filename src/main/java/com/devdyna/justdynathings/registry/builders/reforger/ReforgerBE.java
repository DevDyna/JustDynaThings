package com.devdyna.justdynathings.registry.builders.reforger;

import java.util.Random;

import com.devdyna.justdynathings.datamaps.zDataMaps;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.client.particles.gooexplodeparticle.GooExplodeParticleData;
import com.direwolf20.justdirethings.common.blockentities.basebe.BaseMachineBE;
import com.direwolf20.justdirethings.common.blockentities.basebe.RedstoneControlledBE;
import com.direwolf20.justdirethings.util.interfacehelpers.RedstoneControlData;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

@SuppressWarnings("null")
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
    public void tickServer() {

        ItemStack item = getMachineHandler().getStackInSlot(0);
        BlockPos posRel = getBlockPos()
                .relative(getBlockState()
                        .getValue(BlockStateProperties.FACING));
        BlockState stateRelated = level.getBlockState(posRel);

        var holder = item.getItemHolder();

        if (item != null)
            updateBlock(item);

        if (level.getGameTime() % tickSpeed == 0 && isActiveRedstone()
                && getBlockState().getValue(zProperties.ACTIVE).booleanValue()) {

            if (holder.getData(zDataMaps.REFORGER_oneToOne) != null) {
                if (stateRelated.is(holder.getData(zDataMaps.REFORGER_oneToOne).input().getBlock())) {
                    success(holder.getData(zDataMaps.REFORGER_oneToOne).output(), posRel, item, level,
                            holder.getData(zDataMaps.REFORGER_oneToOne).chanceToUse());
                    return;
                }
            }

            if (holder.getData(zDataMaps.REFORGER_oneToMany) != null) {
                if (stateRelated.is(holder.getData(zDataMaps.REFORGER_oneToMany).input().getBlock())) {
                    success(LevelUtil.ResourceByTag(
                            holder.getData(zDataMaps.REFORGER_oneToMany).output(),
                            LevelUtil.getRandomValue(
                                    LevelUtil.getSizeTag(holder.getData(zDataMaps.REFORGER_oneToMany).output()), level))
                            .defaultBlockState(), posRel, item, level,
                            holder.getData(zDataMaps.REFORGER_oneToMany).chanceToUse());
                    return;
                }
            }

            if (holder.getData(zDataMaps.REFORGER_manyToOne) != null) {
                if (stateRelated.is(holder.getData(zDataMaps.REFORGER_manyToOne).input())) {
                    success(holder.getData(zDataMaps.REFORGER_manyToOne).output(), posRel, item, level,
                            holder.getData(zDataMaps.REFORGER_manyToOne).chanceToUse());
                    return;
                }
            }

        }
    }

    /**
     * update the blockstate properties
     */
    public void updateBlock(ItemStack item) {
        level.setBlockAndUpdate(getBlockPos(),
                getBlockState()
                        .setValue(zProperties.ACTIVE,
                                !item.isEmpty()));
    }

    public void success(BlockState b, BlockPos pos, ItemStack item, Level level, int cosChance) {
        spawnParticles((ServerLevel) level, pos);
        applySound();
        // adjusted rotation for rotable blocks like JDT raw ores
        if (b.getValue(BlockStateProperties.FACING) != null)
            b = b.setValue(BlockStateProperties.FACING, getBlockState()
                    .getValue(BlockStateProperties.FACING));
        level.setBlockAndUpdate(pos, b);
        if (LevelUtil.chance(cosChance, level))
            item.shrink(1);
    }

    public void applySound() {
        if (LevelUtil.chance(50, level))
            level.playSound(null, getBlockPos(), SoundEvents.STRIDER_EAT,
                    SoundSource.BLOCKS, 1F, 0.1F);
    }

    public void spawnParticles(ServerLevel level, BlockPos pos) {
        for (int i = 0; i < 20; ++i)
            level.sendParticles(new GooExplodeParticleData(new ItemStack(getBlockState().getBlock())),
                    (double) pos.getX() + new Random().nextDouble(),
                    (double) pos.getY() + new Random().nextDouble(),
                    (double) pos.getZ() + new Random().nextDouble(),
                    1, 0.0, 0.0, 0.0, 0.0);
    }

}