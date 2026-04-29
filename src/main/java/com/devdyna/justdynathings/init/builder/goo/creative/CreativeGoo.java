package com.devdyna.justdynathings.init.builder.goo.creative;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.init.types.zItemTags;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CreativeGoo extends GooBlock_Base {

   public CreativeGoo(Properties p) {
      super(p);
   }

   @Override
   protected InteractionResult useItemOn(ItemStack i, BlockState s, Level l, BlockPos p,
         Player e, InteractionHand h, BlockHitResult b) {

      if ((i.is(zItemTags.CREATIVE_GOO_WRENCHES))) {

         if (Config.GOO_CREATIVE_SOUND_TOGGLE_STATE.get())
            l.playLocalSound(p.getX(), p.getY(),
                  p.getZ(),
                  SoundEvents.LODESTONE_COMPASS_LOCK,
                  SoundSource.BLOCKS, 100,
                  l.getRandom().nextInt(9)* 0.1f, true);

         l.setBlockAndUpdate(p, s.setValue(ALIVE, !s.getValue(ALIVE)));

         return InteractionResult.SUCCESS;

      } else
         return InteractionResult.PASS;
   }

   @Nullable
   public BlockEntity newBlockEntity(BlockPos p, BlockState s) {
      return new CreativeGooBE(p, s);
   }

   protected boolean validRevivalItem(ItemStack i) {
      return false;
   }

   // @SuppressWarnings("null")
   // public void appendHoverText(ItemStack s, Item.TooltipContext c, List<Component> t, TooltipFlag f) {
   //    t.add(Component.translatable(Main.ID + "." + Constants.GooType + "." + Constants.Goo.Creative));
   //    if (Screen.hasShiftDown())
   //       t.add(Component.translatable(Main.ID + "." + Constants.GooType + ".tier")
   //             .append(Component.literal("" + CommonConfig.GOO_CREATIVE_TIER.get())));
   //    else
   //       t.add(Component.translatable("justdirethings.shiftmoreinfo").withStyle(ChatFormatting.GRAY));
   // }
}
