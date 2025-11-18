package com.devdyna.justdynathings.config;

import java.util.List;

import com.devdyna.justdynathings.Constants.Wands;
import com.devdyna.justdynathings.utils.LogUtil;

import net.neoforged.fml.ModContainer;

public class config {
    public static void core(ModContainer chest) {
        common.register(chest);
        startup.register(chest);
    }

    private static List<Integer> validStages = List.of(1, 2, 4, 8);

    public static boolean validateADW(String type, Object value) {
        if (value == null) {
            LogUtil.warn(Wands.AdvancedTime + type + " is null");
            return false;
        }
        var result = validStages.contains((int) value);

        if (!result)
            LogUtil.error("Invalid " + Wands.AdvancedTime + type + ", must be 1 , 2 , 4 or 8");

        return result;
    }

    public static boolean maxADW(Object value) {

        if (value == null) {
            LogUtil.warn(Wands.AdvancedTime + "_max_multiplier is null");
            return false;
        }

        boolean result = (Integer) value > 2 && ((Integer) value & ((Integer) value - 1)) == 0;
        if (!result) 
            LogUtil.error("Invalid " + Wands.AdvancedTime  + "_max_multiplier , must be >= 2 and power of 2");
        

        return result;

    }
}
