package com.devdyna.justdynathings.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberUtils {
    public static String decorateNumbers(int number) {
        NumberFormat format = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        format.setMaximumFractionDigits(1);
        format.setMinimumFractionDigits(1);
        return format.format(number);
    }
}
