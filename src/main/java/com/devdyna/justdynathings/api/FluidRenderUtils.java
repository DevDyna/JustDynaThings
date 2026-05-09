package com.devdyna.justdynathings.api;

import com.devdyna.cakesticklib.api.utils.x;
import com.direwolf20.justdirethings.JustDireThings;
import com.direwolf20.justdirethings.client.FluidModels;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.block.FluidModel;
import net.minecraft.client.renderer.block.FluidModel.Unbaked;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.client.fluid.FluidTintSource;

public class FluidRenderUtils {

    public static final Material STILL = new Material(x.rl(JustDireThings.MODID, "block/fluid_source"));
    public static final Material FLOW = new Material(x.rl(JustDireThings.MODID, "block/fluid_flowing"));
    public static final Material OVERLAY = new Material(x.rl(JustDireThings.MODID, "block/fluid_overlay"));

    public static Unbaked createModel(FluidTintSource tint) {
        return new FluidModel.Unbaked(STILL, FLOW, OVERLAY, tint);
    }

    public static FluidTintSource instability(int delay, int start, int end) {
        return new FluidTintSource() {
            @Override
            public int color(FluidState state) {

                if (delay <= 0)
                    return start;

                double time = System.currentTimeMillis() % delay;
                float t = (float) ((Math.sin(time * (Math.PI * 2D / delay)) + 1D) * 0.5D);

                int a1 = (start >> 24) & 255;
                int r1 = (start >> 16) & 255;
                int g1 = (start >> 8) & 255;
                int b1 = start & 255;

                int a2 = (end >> 24) & 255;
                int r2 = (end >> 16) & 255;
                int g2 = (end >> 8) & 255;
                int b2 = end & 255;

                int a = (int) (a1 + (a2 - a1) * t);
                int r = (int) (r1 + (r2 - r1) * t);
                int g = (int) (g1 + (g2 - g1) * t);
                int b = (int) (b1 + (b2 - b1) * t);

                return (a << 24) | (r << 16) | (g << 8) | b;

            }

            @Override
            public int colorInWorld(FluidState fluidState, BlockState blockState,
                    BlockAndTintGetter level, BlockPos pos) {

                // maybe overkill?
                Minecraft.getInstance().levelRenderer.setBlocksDirty(
                        pos.getX(), pos.getY(), pos.getZ(),
                        pos.getX(), pos.getY(), pos.getZ());

                float t = (float) ((Math.sin((System.currentTimeMillis() % delay)
                        * (Math.PI * 2 / delay)) + 1.0) / 2.0);

                int a1 = (start >> 24) & 255;
                int r1 = (start >> 16) & 255;
                int g1 = (start >> 8) & 255;
                int b1 = start & 255;

                int a2 = (end >> 24) & 255;
                int r2 = (end >> 16) & 255;
                int g2 = (end >> 8) & 255;
                int b2 = end & 255;

                int a = (int) (a1 + (a2 - a1) * t);
                int r = (int) (r1 + (r2 - r1) * t);
                int g = (int) (g1 + (g2 - g1) * t);
                int b = (int) (b1 + (b2 - b1) * t);

                return (a << 24) | (r << 16) | (g << 8) | b;
            }
        };
    }

    public static FluidTintSource rgbColor() {
        return new FluidTintSource() {
            @Override
            public int color(FluidState state) {
                return FluidModels.currentRainbowArgb(0);
            }

            @Override
            public int colorInWorld(FluidState fluidState, BlockState blockState, BlockAndTintGetter level,
                    BlockPos pos) {
                return FluidModels.currentRainbowArgb(0);
            }
        };

    }
}
