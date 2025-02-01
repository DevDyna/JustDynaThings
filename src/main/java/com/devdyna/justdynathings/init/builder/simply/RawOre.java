package com.devdyna.justdynathings.init.builder.simply;

import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseRawOre;
import net.minecraft.world.level.block.SoundType;

public class RawOre extends BaseRawOre {
    public RawOre(SoundType s,float destroytime,float explosiondestroy) {
        super(Properties.of()
                .sound(s)
                .requiresCorrectToolForDrops()
                .noOcclusion()
                .strength(destroytime,explosiondestroy)
        );
    }
}
