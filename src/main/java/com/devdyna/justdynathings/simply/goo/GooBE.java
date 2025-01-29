package com.devdyna.justdynathings.simply.goo;


import com.devdyna.justdynathings.init.Material;
import com.direwolf20.justdirethings.common.blockentities.basebe.GooBlockBE_Base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class GooBE extends GooBlockBE_Base {

   private int tier;
   private int reducer;

   
      public GooBE(BlockPos pos, BlockState state , int tier,int reducer) {
          super(Material.GOO_BE.get() , pos, state);
          this.tier = tier;
          this.reducer = reducer;
       }
   
       public GooBE(BlockPos pos, BlockState state) {
        this(pos, state, 0, 1);
   }
 
    public int getTier() {
       return tier;
    }
 
    public int counterReducer() {
       return reducer;
    }
 }
