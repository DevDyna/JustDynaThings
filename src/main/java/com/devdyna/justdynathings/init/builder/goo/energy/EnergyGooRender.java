package com.devdyna.justdynathings.init.builder.goo.energy;

import com.direwolf20.justdirethings.client.blockentityrenders.baseber.GooBlockRender_Base;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer.CrumblingOverlay;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.world.phys.Vec3;

public class EnergyGooRender extends GooBlockRender_Base<FEGoo> {
   public EnergyGooRender(BlockEntityRendererProvider.Context context) {
      super(context);
   }

   public GooBlockRenderState createRenderState() {
      return new GooBlockRenderState();
   }

   // brute force to disable item revive render
   @Override
   public void extractRenderState(FEGoo be, GooBlockRenderState render,
         float ticks, Vec3 cam, CrumblingOverlay breakprogress) {
      super.extractRenderState(be, render, ticks, cam, breakprogress);
      render.showFloatingItem = false;

   }

   @Override
   public void submit(GooBlockRenderState arg0, PoseStack arg1, SubmitNodeCollector arg2, CameraRenderState arg3) {
      super.submit(arg0, arg1, arg2, arg3);
   }

}