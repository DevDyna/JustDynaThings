package com.devdyna.justdynathings.api;

import net.minecraft.world.level.Level;

public class RandomUtil {
    public static boolean chance(Level level, int chance) {
        return level.getRandom().nextInt(100) < chance;
    }

    @Deprecated
    public static boolean chance(int chance, Level level) {
        return chance(level, chance);
    }

    public static boolean rnd50(Level level) {
        return level.getRandom().nextBoolean();
    }
}
