package com.devdyna.justdynathings.init.builder.advanced_energy_transmitter;

import org.jspecify.annotations.Nullable;

import com.devdyna.cakesticklib.api.utils.x;
import com.direwolf20.justdirethings.client.blockentityrenders.EnergyTransmitterRenderer.EnergyTransmitterRenderState;
import com.direwolf20.justdirethings.client.blockentityrenders.baseber.AreaAffectingBER;
import com.direwolf20.justdirethings.common.blockentities.EnergyTransmitterBE;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

public class AdvEnergyTransmitterRenderer extends AreaAffectingBER<EnergyTransmitterBE, EnergyTransmitterRenderState> {

    private final ItemModelResolver resolver;

    public AdvEnergyTransmitterRenderer(BlockEntityRendererProvider.Context context) {
        this.resolver = context.itemModelResolver();
    }

    public EnergyTransmitterRenderState createRenderState() {
        return new EnergyTransmitterRenderState();
    }

    public void extractRenderState(EnergyTransmitterBE blockEntity, EnergyTransmitterRenderState state,
            float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        state.facing = blockEntity.getBlockState().getValue(BlockStateProperties.FACING).getOpposite();
        state.millis = System.currentTimeMillis();
        this.resolver.updateForTopItem(state.item, x.item(JDTRegistration.TimeCrystal.get()), ItemDisplayContext.FIXED,
                blockEntity.getLevel(), null, 0);
    }

    public void submit(EnergyTransmitterRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector,
            CameraRenderState camera) {
        super.submit(state, poseStack, submitNodeCollector, camera);
        var dir = state.facing;
        poseStack.pushPose();
        poseStack.translate(0.5F + dir.getStepX() * 0.3F, 0.5F + dir.getStepY() * 0.3F, 0.5F + dir.getStepZ() * 0.3F);
        poseStack.mulPose(Axis.XP.rotationDegrees(dir.getStepZ() * -90));
        poseStack.mulPose(Axis.ZP.rotationDegrees(dir.getStepX() * 90));
        poseStack.mulPose(Axis.XP.rotationDegrees(dir.getStepY() == 1 ? 0.0F : 180.0F));
        poseStack.mulPose(Axis.YP.rotationDegrees(state.millis / 15L % 360L));
        poseStack.scale(0.15F, 0.15F, 0.15F);
        state.item.submit(poseStack, submitNodeCollector, 15728880, OverlayTexture.NO_OVERLAY, 0);
        poseStack.popPose();
    }

}
