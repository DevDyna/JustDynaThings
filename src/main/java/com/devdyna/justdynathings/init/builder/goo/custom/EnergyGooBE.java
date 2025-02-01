package com.devdyna.justdynathings.init.builder.goo.custom;


import com.devdyna.justdynathings.init.Material;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class EnergyGooBE extends EnergyGooBE_Base {

   private int tier;
   private int reducer;

   
      public EnergyGooBE(BlockPos pos, BlockState state , int tier,int reducer) {
          super(Material.ENERGY_GOO_BE.get() , pos, state);
          this.tier = tier;
          this.reducer = reducer;
       }
   
       public EnergyGooBE(BlockPos pos, BlockState state) {
        this(pos, state, 0, 1);
   }
 
    public int getTier() {
       return tier;
    }
 
    public int counterReducer() {
       return reducer;
    }
 }
