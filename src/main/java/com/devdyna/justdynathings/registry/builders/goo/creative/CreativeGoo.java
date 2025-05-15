package com.devdyna.justdynathings.registry.builders.goo.creative;

import java.util.List;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.Material;
import com.devdyna.justdynathings.registry.types.zItemTags;
import com.devdyna.justdynathings.utils.LevelUtil;
import com.direwolf20.justdirethings.common.blockentities.gooblocks.GooBlockBE_Tier4;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;
import com.direwolf20.justdirethings.datagen.JustDireItemTags;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;

@SuppressWarnings("unused")
public class CreativeGoo extends GooBlock_Base implements EntityBlock {

   public CreativeGoo() {
   }

   @Override
   protected ItemInteractionResult useItemOn(ItemStack i, BlockState s, Level l, BlockPos p,
         Player e, InteractionHand h, BlockHitResult b) {

      if ((i.is(zItemTags.CREATIVE_GOO_WRENCHES))) {

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

   @SuppressWarnings("null")
   @Nullable
   public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
      return new CreativeGooBE(p, s);
   }

   protected boolean validRevivalItem(ItemStack i) {
      return false;
   }

   @SuppressWarnings("null")
   public void appendHoverText(ItemStack s, Item.TooltipContext c, List<Component> t, TooltipFlag f) {
      t.add(Component.translatable(Main.ID + "." + Constants.GooType+"."+Constants.Goo.Creative + ".tip"));
   }
}
