package com.devdyna.justdynathings.client.builder.paradoxMixer;

import com.devdyna.justdynathings.registry.builders.paradox_mixer.ParadoxMixerBE;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zProperties;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;

@SuppressWarnings({ "null", "deprecation" })
public class ParadoxMixerRender implements BlockEntityRenderer<ParadoxMixerBE> {

    private final Minecraft mc;

    public ParadoxMixerRender(BlockEntityRendererProvider.Context context) {
        this.mc = Minecraft.getInstance();
    }

    @Override
    public void render(ParadoxMixerBE be, float tickDelta, com.mojang.blaze3d.vertex.PoseStack poseStack,
            MultiBufferSource bufferSource, int packedLight, int packedOverlay) {

        boolean active = false;
        try {
            active = be.getLevel().getBlockState(be.getBlockPos()).getValue(zProperties.GOO_ALIVE);
        } catch (Exception ignored) {
        }

        if (!active)
            return;

        BlockPos pos = be.getBlockPos();

        double t = be.getLevel() != null ? be.getLevel().getGameTime() + tickDelta : 0.0;

        long seed = pos.asLong();
        double offsetX = ((seed & 0xFFFF) / (double) 0xFFFF) * Math.PI * 2;
        double offsetY = (((seed >> 16) & 0xFFFF) / (double) 0xFFFF) * Math.PI * 2;
        double offsetZ = (((seed >> 32) & 0xFFFF) / (double) 0xFFFF) * Math.PI * 2;

        // Rotation
        float rotX = (float) (Math.sin(t * 0.05 + offsetX) * 25); // faster and more exaggerated
        float rotY = (float) (Math.sin(t * 0.045 + offsetY) * 25);
        float rotZ = (float) (Math.cos(t * 0.055 + offsetZ) * 25);

        // Bobbing up and down (like conduit)
        float bob = (float) (Math.sin(t * 0.1 + offsetY) * 0.1);

        // Pulsing scale
        float scale = 0.5f + (float) (Math.sin(t * 0.1 + offsetZ) * 0.05);

        poseStack.pushPose();
        poseStack.translate(0.5, 0.55 + bob, 0.5);

        // Apply rotation
        poseStack.mulPose(Axis.XP.rotationDegrees(rotX));
        poseStack.mulPose(Axis.YP.rotationDegrees(rotY));
        poseStack.mulPose(Axis.ZP.rotationDegrees(rotZ));

        // Apply pulsating scale
        poseStack.scale(scale, scale, scale);

        poseStack.translate(-0.5, -0.55, -0.5);
        
        // Render the block normally
        mc.getBlockRenderer().renderSingleBlock(zBlocks.PARADOX_RENDER.get().defaultBlockState(), poseStack,
                bufferSource, packedLight, OverlayTexture.NO_OVERLAY);

        poseStack.popPose();
    }
}
