
package com.devdyna.justdynathings.api.fluid;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.systems.*;
import com.mojang.blaze3d.textures.*;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.renderer.texture.SpriteContents;
import net.minecraft.client.renderer.texture.atlas.SpriteSource;
import net.minecraft.client.resources.metadata.animation.AnimationMetadataSection;
import net.minecraft.client.resources.metadata.animation.FrameSize;
import net.minecraft.client.resources.metadata.texture.TextureMetadataSection;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.metadata.MetadataSectionType;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.ARGB;

import org.jspecify.annotations.Nullable;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Instability implementation based on
 * {@link com.direwolf20.justdirethings.client.fluid.RainbowFluidSpriteSource}
 */
public final class InstabilityFluidSprite implements SpriteSource {

        public static final MapCodec<InstabilityFluidSprite> CODEC = RecordCodecBuilder
                        .mapCodec(i -> i.group(
                                        Identifier.CODEC.fieldOf("resource")
                                                        .forGetter(InstabilityFluidSprite::getResource),
                                        Identifier.CODEC.fieldOf("sprite")
                                                        .forGetter(InstabilityFluidSprite::getSprite),
                                        Codec.INT.fieldOf("delay")
                                                        .forGetter(InstabilityFluidSprite::getDelay),
                                        Codec.INT.fieldOf("start")
                                                        .forGetter(InstabilityFluidSprite::getStart),
                                        Codec.INT.fieldOf("end")
                                                        .forGetter(InstabilityFluidSprite::getEnd))
                                        .apply(i, InstabilityFluidSprite::new));

        private final Identifier resource;
        private final Identifier sprite;

        private final int delay;
        private final int start;
        private final int end;

        public Identifier getResource() {
                return resource;
        }

        public Identifier getSprite() {
                return sprite;
        }

        public int getDelay() {
                return delay;
        }

        public int getEnd() {
                return end;
        }

        public int getStart() {
                return start;
        }

        public InstabilityFluidSprite(Identifier resource, Identifier sprite, int delay, int start,
                        int end) {
                this.resource = resource;
                this.sprite = sprite;
                this.delay = delay;
                this.start = start;
                this.end = end;
        }

        @Override
        public void run(ResourceManager mng, Output c) {

                var src = mng.getResource(new FileToIdConverter("textures", ".png").idToFile(resource));

                if (src.isEmpty())
                        return;

                c.add(sprite, l -> l.loadSprite(sprite, src.get(),
                                (n, f, i, a, m, t) -> new FluidSpriteContents(n, f, i, a, m, t, delay, start,
                                                end)));
        }

        @Override
        public MapCodec<? extends SpriteSource> codec() {
                return CODEC;
        }

        public final class FluidSpriteContents extends SpriteContents {

                private final int delay;
                private final int start;
                private final int end;

                public FluidSpriteContents(Identifier id, FrameSize fps, NativeImage img,
                                Optional<AnimationMetadataSection> info, List<MetadataSectionType.WithValue<?>> meta,
                                Optional<TextureMetadataSection> txt, int delay, int start, int end) {
                        super(id, fps, img, info, meta, txt);

                        this.delay = delay;
                        this.start = start;
                        this.end = end;
                }

                @Override
                public boolean isAnimated() {
                        return true;
                }

                @Override
                public @Nullable AnimationState createAnimationState(GpuBufferSlice gpu, int s) {
                        return new AnimatedFluidState(this, this.animatedTexture, gpu, s, delay, start, end);
                }
        }

        final class AnimatedFluidState extends SpriteContents.AnimationState {

                private final int mipLevels;

                private final GpuTexture tintedTexture;
                private final GpuTextureView tintedView;

                private final GpuBufferSlice[] spriteUbosByMip;

                private final int frameCount;
                private final int framesPerRow;

                private final int[][] baseSheetPixels;
                private final int[] sheetWidthByMip;

                private final NativeImage[] scratchByMip;

                private final int delay;
                private final int start;
                private final int end;

                private int ticks;

                AnimatedFluidState(SpriteContents ctx, SpriteContents.AnimatedTexture info, GpuBufferSlice gpu, int ubo,
                                int delay, int start, int end) {

                        ctx.super(info, Int2ObjectMaps.emptyMap(),
                                        IntStream.range(0, ctx.byMipLevel.length)
                                                        .mapToObj(i -> gpu.slice((long) i * ubo, ubo))
                                                        .toArray(GpuBufferSlice[]::new));

                        this.delay = delay;
                        this.start = start;
                        this.end = end;

                        this.mipLevels = ctx.byMipLevel.length;

                        this.spriteUbosByMip = new GpuBufferSlice[mipLevels];

                        for (var i = 0; i < mipLevels; i++)
                                spriteUbosByMip[i] = gpu.slice((long) i * ubo, ubo);

                        var width = ctx.width();
                        var height = ctx.height();

                        var originalMip0 = ctx.byMipLevel[0];

                        this.framesPerRow = Math.max(1, originalMip0.getWidth() / width);
                        this.frameCount = Math.max(1, framesPerRow * Math.max(1, originalMip0.getHeight() / height));

                        this.baseSheetPixels = new int[mipLevels][];
                        this.sheetWidthByMip = new int[mipLevels];
                        this.scratchByMip = new NativeImage[mipLevels];

                        for (var m = 0; m < mipLevels; m++) {

                                var fw = width >> m;
                                var fh = height >> m;

                                if (fw <= 0 || fh <= 0)
                                        continue;

                                var mipImage = ctx.byMipLevel[m];

                                var sheetW = mipImage.getWidth();
                                var sheetH = mipImage.getHeight();

                                sheetWidthByMip[m] = sheetW;

                                var buf = new int[sheetW * sheetH];

                                for (var y = 0; y < sheetH; y++)
                                        for (var x = 0; x < sheetW; x++)
                                                buf[y * sheetW + x] = mipImage.getPixel(x, y);

                                baseSheetPixels[m] = buf;
                                scratchByMip[m] = new NativeImage(NativeImage.Format.RGBA, fw, fh, false);
                        }

                        this.tintedTexture = RenderSystem.getDevice().createTexture(() -> ctx.name() + " instability",
                                        GpuTexture.USAGE_COPY_DST | GpuTexture.USAGE_TEXTURE_BINDING,
                                        TextureFormat.RGBA8, width, height, 1, mipLevels);

                        this.tintedView = RenderSystem.getDevice().createTextureView(tintedTexture);

                        updateTint();
                }

                @Override
                public void tick() {
                        ticks++;
                        updateTint();
                }

                private static int lerp(int start, int end, float t) {

                        var a1 = ARGB.alpha(start);
                        var r1 = ARGB.red(start);
                        var g1 = ARGB.green(start);
                        var b1 = ARGB.blue(start);

                        var a2 = ARGB.alpha(end);
                        var r2 = ARGB.red(end);
                        var g2 = ARGB.green(end);
                        var b2 = ARGB.blue(end);

                        return ARGB.color(
                                        (int) (a1 + (a2 - a1) * t),
                                        (int) (r1 + (r2 - r1) * t),
                                        (int) (g1 + (g2 - g1) * t),
                                        (int) (b1 + (b2 - b1) * t));
                }

                private void updateTint() {

                        var color = (delay <= 0)
                                        ? start
                                        : lerp(start, end, (float) ((Math.sin(
                                                        (System.currentTimeMillis() % delay) * (Math.PI * 2D / delay))
                                                        + 1D) * 0.5D));

                        var a = ARGB.alpha(color) / 255.0f;
                        var r = ARGB.red(color) / 255.0f;
                        var g = ARGB.green(color) / 255.0f;
                        var b = ARGB.blue(color) / 255.0f;

                        var frame = (ticks / 2) % frameCount;

                        for (var m = 0; m < mipLevels; m++) {

                                var scratch = scratchByMip[m];
                                var sheet = baseSheetPixels[m];

                                if (scratch == null || sheet == null)
                                        continue;

                                var fw = scratch.getWidth();
                                var fh = scratch.getHeight();

                                var fx = (frame % framesPerRow) * fw;
                                var fy = (frame / framesPerRow) * fh;

                                for (var y = 0; y < fh; y++)
                                        for (var x = 0; x < fw; x++) {

                                                var src = sheet[((fy + y) * sheetWidthByMip[m] + fx) + x];

                                                scratch.setPixel(x, y,
                                                                ARGB.color(clamp(ARGB.alpha(src) * a),
                                                                                clamp(ARGB.red(src) * r),
                                                                                clamp(ARGB.green(src) * g),
                                                                                clamp(ARGB.blue(src) * b)));
                                        }

                                RenderSystem.getDevice().createCommandEncoder().writeToTexture(tintedTexture, scratch,
                                                m, 0, 0, 0, fw, fh, 0, 0);
                        }
                }

                private static int clamp(float v) {
                        if (v <= 0)
                                return 0;
                        if (v >= 255)
                                return 255;
                        return (int) v;
                }

                @Override
                public GpuBufferSlice getDrawUbo(int level) {
                        return spriteUbosByMip[level];
                }

                @Override
                public boolean needsToDraw() {
                        return true;
                }

                @Override
                public void drawToAtlas(RenderPass gpass, GpuBufferSlice ubo) {
                        gpass.setPipeline(RenderPipelines.ANIMATE_SPRITE_BLIT);
                        gpass.bindTexture("Sprite", tintedView,
                                        RenderSystem.getSamplerCache().getClampToEdge(FilterMode.NEAREST, true));
                        gpass.setUniform("SpriteAnimationInfo", ubo);
                        gpass.draw(0, 6);
                }

                @Override
                public void close() {
                        tintedView.close();
                        tintedTexture.close();
                        for (var img : scratchByMip)
                                if (img != null)
                                        img.close();

                }
        }

}
