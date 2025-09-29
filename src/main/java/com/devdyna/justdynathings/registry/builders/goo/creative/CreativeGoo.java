package com.devdyna.justdynathings.registry.builders.goo.creative;

import java.util.List;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.config.common;
import com.devdyna.justdynathings.registry.types.zItemTags;
import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CreativeGoo extends GooBlock_Base {

   public CreativeGoo() {
   }

   @Override
   protected ItemInteractionResult useItemOn(ItemStack i, BlockState s, Level l, BlockPos p,
         Player e, InteractionHand h, BlockHitResult b) {

      if ((i.is(zItemTags.CREATIVE_GOO_WRENCHES))) {

         if (common.GOO_CREATIVE_SOUND_TOGGLE_STATE.get())
            l.playLocalSound(p.getX(), p.getY(),
                  p.getZ(),
                  SoundEvents.LODESTONE_COMPASS_LOCK,
                  SoundSource.BLOCKS, 100,
                  LevelUtil.getRandomValue(9, l) * 0.1f, true);

         l.setBlockAndUpdate(p, s.setValue(ALIVE, !s.getValue(ALIVE)));

         return ItemInteractionResult.SUCCESS;

      } else
         return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
   }

   @Nullable
   public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
      return new CreativeGooBE(p, s);
   }

   protected boolean validRevivalItem(ItemStack i) {
      return false;
   }

   @SuppressWarnings("null")
   public void appendHoverText(ItemStack s, Item.TooltipContext c, List<Component> t, TooltipFlag f) {
      t.add(Component.translatable(Main.ID + "." + Constants.GooType + "." + Constants.Goo.Creative + ".tip"));
      if (Screen.hasShiftDown())
         t.add(Component.translatable(Main.ID + "." + Constants.GooType + ".tier")
               .append(Component.literal("" + common.GOO_CREATIVE_TIER.get())));
      else
         t.add(Component.translatable("justdirethings.shiftmoreinfo").withStyle(ChatFormatting.GRAY));
   }
}
