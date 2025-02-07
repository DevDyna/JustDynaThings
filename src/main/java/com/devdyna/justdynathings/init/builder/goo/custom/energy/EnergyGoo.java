package com.devdyna.justdynathings.init.builder.goo.custom.energy;

import java.util.List;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.init.Material;
import com.devdyna.justdynathings.init.builder.goo.GooBE;
import com.direwolf20.justdirethings.common.blockentities.gooblocks.GooBlockBE_Tier4;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;
import com.direwolf20.justdirethings.datagen.JustDireItemTags;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("unused")
public class EnergyGoo extends GooBlock_Base implements EntityBlock {
   private String tipname;
   private int tier;
   private int reducer;
   private int rfcost;

   public EnergyGoo(String tipname,  int tier, int reducer,int rfcost) {
      this.tipname = tipname;
      this.tier = tier;
      this.reducer = reducer;
      this.rfcost = rfcost;
   }

   @SuppressWarnings("null")
   @Nullable
   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new EnergyGooBE(pos, state, tier, reducer,10);
   }

   protected boolean validRevivalItem(ItemStack itemStack) {
      return false;
   }

   @SuppressWarnings("null")
   @Override
   public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
         TooltipFlag tooltipFlag) {
      if (Screen.hasControlDown()) {
         tooltipComponents.add(Component.translatable(Main.ID + "." + tipname + ".on"));
      } else {
         tooltipComponents.add(Component.translatable(Main.ID + ".off"));
      }
      super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
   }
}
