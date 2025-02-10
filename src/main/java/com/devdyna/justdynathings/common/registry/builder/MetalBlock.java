package com.devdyna.justdynathings.common.registry.builder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;

public class MetalBlock extends Block {
    public MetalBlock() {
        super(Properties.of()
                .sound(SoundType.METAL)
                .requiresCorrectToolForDrops()
                .noOcclusion()
                .strength(4.0f, 8.0f));
    }
}
