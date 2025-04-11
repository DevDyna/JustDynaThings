package com.devdyna.justdynathings.registry.builders.crystalline;

import com.devdyna.justdynathings.registry.types.Fluids;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class CrystallineBlock extends LiquidBlock{

    public CrystallineBlock() {
        super(Fluids.CRYSTALLINE_SOURCE.get(), Properties.of()
                .mapColor(MapColor.COLOR_RED)
                .replaceable()
                .noCollission()
                .strength(100.0F)
                .pushReaction(PushReaction.DESTROY)
                .noLootTable()
                .liquid()
                .sound(SoundType.EMPTY)
        );
    }
    
}
