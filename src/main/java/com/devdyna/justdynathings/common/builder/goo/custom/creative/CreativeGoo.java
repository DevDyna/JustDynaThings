package com.devdyna.justdynathings.common.builder.goo.custom.creative;

import java.util.List;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.common.Material;
import com.devdyna.justdynathings.common.builder.goo.GooBE;
import com.direwolf20.justdirethings.common.blockentities.gooblocks.GooBlockBE_Tier4;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;
import com.direwolf20.justdirethings.datagen.JustDireItemTags;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Item.TooltipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

@SuppressWarnings("unused")
public class CreativeGoo extends GooBlock_Base implements EntityBlock {
   private String tipname;
   private int tier;
   private int reducer;

   public CreativeGoo(String tipname, int tier, int reducer) {
      this.tipname = tipname;
      this.tier = tier;
      this.reducer = reducer;
   }

   @Override
   protected ItemInteractionResult useItemOn(ItemStack itemStack, BlockState state, Level level, BlockPos pos,
         Player player, InteractionHand hand, BlockHitResult blockHitResult) {
      if (level.getBlockState(pos).is(Material.GooT5_CREATIVE_BLOCK) && itemStack.is(JustDireItemTags.WRENCHES)
            || itemStack.is(JustDireItemTags.TOOLS_WRENCH)) {
         level.setBlock(pos, state.setValue(ALIVE, !state.getValue(ALIVE)), 3);
         return ItemInteractionResult.SUCCESS;
      } else {
         return super.useItemOn(itemStack, state, level, pos, player, hand, blockHitResult);
      }
   }

   @SuppressWarnings("null")
   @Nullable
   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new CreativeGooBE(pos, state, tier, reducer);
   }

   protected boolean validRevivalItem(ItemStack itemStack) {
      return false;
   }

   @SuppressWarnings("null")
   @Override
   public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
         TooltipFlag tooltipFlag) {
      if (Screen.hasControlDown()) {
         tooltipComponents.add(Component.translatable(Main.ID + "." + tipname + "." + Constants.ToolTip.On.id));
         tooltipComponents.add(Component.translatable(Main.ID + "."+Constants.ToolTip.Goo.id));
      } else {
         tooltipComponents.add(Component.translatable(Main.ID + "." + Constants.ToolTip.Off.id));
      }
      super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
   }
}
