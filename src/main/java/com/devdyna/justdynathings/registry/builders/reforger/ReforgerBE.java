package com.devdyna.justdynathings.registry.builders.reforger;

import java.util.Random;

import com.devdyna.justdynathings.recipetypes.input.ReforgerRecipeInput;
import com.devdyna.justdynathings.registry.types.zBlockEntities;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.devdyna.justdynathings.registry.types.zRecipeTypes;
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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

@SuppressWarnings("null")
public class ReforgerBE extends BaseMachineBE implements RedstoneControlledBE {

        public RedstoneControlData redstoneControlData = new RedstoneControlData();

        public ReforgerBE(BlockEntityType<?> type, BlockPos pos, BlockState state) {
                super(type, pos, state);
                MACHINE_SLOTS = 1;
        }

        public ReforgerBE(BlockPos pos, BlockState state) {
                this(zBlockEntities.REFORGER.get(), pos, state);
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

                var item = getMachineHandler().getStackInSlot(0);

                var relative = getBlockPos().relative(
                                getBlockState().getValue(
                                                BlockStateProperties.FACING));

                updateBlock(!item.isEmpty() && isActiveRedstone());

                if (level.getGameTime() % tickSpeed != 0)
                        return;

                if (!getBlockState().getValue(zProperties.ACTIVE))
                        return;

                if (item.isEmpty())
                        return;

                var r = level.getRecipeManager().getRecipeFor(zRecipeTypes.REFORGER.getType(),
                                new ReforgerRecipeInput(level.getBlockState(relative), item), level);

                if (r.isEmpty())
                        return;

                var recipe = r.get().value();

                var output = recipe.getOutputState(level);

                spawnParticles((ServerLevel) level, relative);

                applySound();

                // adjusted rotation for rotable blocks like JDT raw ores
                if (output.getOptionalValue(BlockStateProperties.FACING).isPresent())
                        output = output.trySetValue(BlockStateProperties.FACING,
                                        getBlockState().getValue(BlockStateProperties.FACING));

                level.setBlockAndUpdate(relative, output);

                if (LevelUtil.chance(recipe.getChanceToUse(), level))
                        item.shrink(1);

        }

        /**
         * update the blockstate properties
         */
        public void updateBlock(boolean v) {
                if (getBlockState().getValue(zProperties.ACTIVE) != v)
                        level.setBlockAndUpdate(getBlockPos(), getBlockState().setValue(zProperties.ACTIVE, v));
        }

        public void applySound() {
                if (LevelUtil.chance(50, level))
                        level.playSound(null, getBlockPos(), SoundEvents.STRIDER_EAT,
                                        SoundSource.BLOCKS, 1F, 0.1F);
        }

        public void spawnParticles(ServerLevel level, BlockPos pos) {
                var item = new ItemStack(level.getBlockState(pos).getBlock());

                if(!item.isEmpty())
                for (int i = 0; i < 5; ++i)
                        level.sendParticles(
                                        new GooExplodeParticleData(item),
                                        (double) pos.getX() + new Random().nextDouble(),
                                        (double) pos.getY() + new Random().nextDouble(),
                                        (double) pos.getZ() + new Random().nextDouble(),
                                        1, 0.0, 0.0, 0.0, 0.0);
        }
}