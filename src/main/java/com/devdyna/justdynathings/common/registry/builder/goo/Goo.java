package com.devdyna.justdynathings.common.registry.builder.goo;

import java.util.List;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.common.registry.Material;
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
public class Goo extends GooBlock_Base implements EntityBlock {
   private String tipname;
   private int tier;
   private int reducer;
   private TagKey<Item> tag_revival;

   public Goo(String tipname,  int tier, int reducer, TagKey<Item> tag_revival) {
      this.tipname = tipname;
      this.tier = tier;
      this.reducer = reducer;
      this.tag_revival = tag_revival;

   }

   @SuppressWarnings("null")
   @Nullable
   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new GooBE(pos, state , tier, reducer);
   }

   protected boolean validRevivalItem(ItemStack itemStack) {
      return itemStack.is(tag_revival);
   }

}
