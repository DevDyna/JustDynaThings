package com.devdyna.justdynathings.init.builder.goo.creative;

import java.util.Random;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.init.types.zBlockEntities;
import com.direwolf20.justdirethings.client.particles.gooexplodeparticle.GooExplodeParticleData;

import com.direwolf20.justdirethings.common.blockentities.basebe.GooBlockBE_Base;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class CreativeGooBE extends GooBlockBE_Base {

    public CreativeGooBE(BlockPos pos, BlockState state) {
        super(zBlockEntities.CREATIVE_GOO.get(), pos, state);
    }

    public int getTier() {
        return Config.GOO_CREATIVE_TIER.get();
    }

    public int counterReducer() {
        return Config.GOO_CREATIVE_COUNTER_REDUCER.get();
    }

    @Override
    public void tickServer() {
        this.checkSides();
        this.tickCounters();
        setChanged();
    }

    @SuppressWarnings("null")
    @Override
    public void setBlockToTarget(BlockState output, Direction direction) {
        if (output.hasProperty(BlockStateProperties.FACING)) {
            level.setBlockAndUpdate(getBlockPos().relative(direction),
                    output.setValue(BlockStateProperties.FACING, direction));
        } else
            level.setBlockAndUpdate(getBlockPos().relative(direction), output);

        updateSideCounter(direction, -1);
        sidedDurations.put(direction, -1);
        if (Config.GOO_CREATIVE_SOUND_RECIPE.get())
            level.playSound(null, getBlockPos(), SoundEvents.SCULK_BLOCK_BREAK, SoundSource.BLOCKS, 0.25F, 1.0F);
    }

    /**
     * A less client-fps expensive version of
     * <code>GooBlockBE_Base.spawnParticles(Direction side)</code>
     * <br/>
     * <br/>
     * Aprox. 1/8 of particles generated
     */
    @SuppressWarnings("null")
    @Override
    public void spawnParticles(Direction side) {
        Random random = new Random();
        BlockPos startPos = getBlockPos().relative(side);
        ItemStack itemStack = new ItemStack(getBlockState().getBlock());
        GooExplodeParticleData data = new GooExplodeParticleData(itemStack);

        for (int d = 0; d < Direction.values().length; ++d) {
            Direction direction = Direction.values()[d];

            var x = direction.getUnitVec3i().getX();
            var y = direction.getUnitVec3i().getY();
            var z = direction.getUnitVec3i().getZ();

            for (int i = 0; i < 12; ++i) {
                double randomX = 0.5 + 0.6 * (double) x + (x == 0 ? random.nextDouble() - 0.5 : 0.0);
                double randomY = 0.5 + 0.6 * (double) y + (y == 0 ? random.nextDouble() - 0.5 : 0.0);
                double randomZ = 0.5 + 0.6 * (double) z + (z == 0 ? random.nextDouble() - 0.5 : 0.0);
                level.addParticle(data, (double) startPos.getX() + randomX, (double) startPos.getY() + randomY,
                        (double) startPos.getZ() + randomZ, 0.0, 0.0, 0.0);
            }
        }

    }

}
