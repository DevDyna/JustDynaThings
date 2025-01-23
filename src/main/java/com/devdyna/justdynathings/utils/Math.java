package com.devdyna.justdynathings.utils;

import java.util.Random;

public class Math {
    public static int getRandomValue(int max) {
        if (max <= 0)
            return 1;

        Random random = new Random();
        return random.nextInt(max) + 1;
    }

    public static boolean chance(int value) {
        if (value == 0)
            return false;

        return getRandomValue(100) <= value;
    }
}
