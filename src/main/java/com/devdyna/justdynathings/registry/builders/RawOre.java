package com.devdyna.justdynathings.registry.builders;

import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseRawOre;
import net.minecraft.world.level.block.SoundType;

public class RawOre extends BaseRawOre {
    public RawOre(SoundType soundType,float destroytime,float explosiondestroy) {
        super(Properties.of()
                .sound(soundType)
                .requiresCorrectToolForDrops()
                .noOcclusion()
                .strength(destroytime,explosiondestroy)
        );
    }
}
