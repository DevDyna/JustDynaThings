package com.devdyna.justdynathings.registry.builders.goo.energy;

import com.direwolf20.justdirethings.client.blockentityrenders.baseber.GooBlockRender_Base;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;

public class EnergyGooRender extends GooBlockRender_Base<FEGoo> {
   public EnergyGooRender(BlockEntityRendererProvider.Context context) {
      super(context);
   }

   // brute force to remove item berenderitem
   @Override
   public void render(FEGoo be, float t, PoseStack s, MultiBufferSource b, int l, int o) {
      for (int i = 0; i < Direction.values().length; ++i)
         if (be.getRemainingTimeFor(Direction.values()[i]) > 0)
            this.renderTextures(Direction.values()[i], be.getLevel(), be.getBlockPos(), s, b, l,
                  be.getRemainingTimeFor(Direction.values()[i]), be.getCraftingDuration(Direction.values()[i]),
                  be.getBlockState(), be);
   }

}
