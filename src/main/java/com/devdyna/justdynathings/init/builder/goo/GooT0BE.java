package com.devdyna.justdynathings.init.builder.goo;


import com.devdyna.justdynathings.init.builder.material;
import com.direwolf20.justdirethings.common.blockentities.basebe.GooBlockBE_Base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class GooT0BE extends GooBlockBE_Base {

   public GooT0BE(BlockPos pos, BlockState state) {
       super(material.GooT0_BE.get(), pos, state);
    }
 
    public int getTier() {
       return 0;
    }
 
    public int counterReducer() {
       return 10;
    }
 }
