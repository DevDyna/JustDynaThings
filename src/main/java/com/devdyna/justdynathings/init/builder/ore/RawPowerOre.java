package com.devdyna.justdynathings.init.builder.ore;

import com.direwolf20.justdirethings.common.blocks.baseblocks.BaseRawOre;
import net.minecraft.world.level.block.SoundType;

public class RawPowerOre extends BaseRawOre {
    public RawPowerOre() {
        super(Properties.of()
                .sound(SoundType.AMETHYST)
                .requiresCorrectToolForDrops()
                .noOcclusion()
                .strength(6.0F, 7.0F)
        );
    }
}
