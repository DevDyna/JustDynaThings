package com.devdyna.justdynathings.init.builder.goo;


import com.devdyna.justdynathings.init.Material;
import com.direwolf20.justdirethings.common.blockentities.basebe.GooBlockBE_Base;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class GooT5BE extends GooBlockBE_Base {

   public GooT5BE(BlockPos pos, BlockState state) {
       super(Material.GooT5_BE.get(), pos, state);
    }
 
    public int getTier() {
       return 5;
    }
 
    public int counterReducer() {
       return 10;
    }
 }
