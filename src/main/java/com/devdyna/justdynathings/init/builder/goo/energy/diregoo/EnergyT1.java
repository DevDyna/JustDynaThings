package com.devdyna.justdynathings.init.builder.goo.energy.diregoo;

import javax.annotation.Nullable;

import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class EnergyT1 extends GooBlock_Base {

   public EnergyT1(Properties p) {
      super(p);
   }

   @SuppressWarnings("null")
   @Nullable
   public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
      return new EnergyT1BE(pos, state);
   }

   protected boolean validRevivalItem(ItemStack itemStack) {
      return false;
   }

   //TODO tip
   // @SuppressWarnings("null")
   // public void appendHoverText(ItemStack s, Item.TooltipContext c, List<Component> t, TooltipFlag f) {
   //    t.add(Component.translatable(Main.ID + "." + Constants.GooType + "." + Constants.Goo.Energized ));
   //    if (Screen.hasShiftDown())
   //       t.add(Component.translatable(Main.ID + "." + Constants.GooType + ".tier")
   //             .append(Component.literal("" + CommonConfig.GOO_T1_TIER.get())));
   //    else
   //       t.add(Component.translatable("justdirethings.shiftmoreinfo").withStyle(ChatFormatting.GRAY));
   // }
}
