package com.devdyna.justdynathings.api;

public class ColorAddon {
    // TODO move to api
    // TODO change from int to long and separate seconds to milliseconds
    
    public static int pulseColor(int delay, int startColor, int endColor) {
        var t = (Math.sin((System.currentTimeMillis() % delay) * (Math.PI * 2D / delay)) + 1.0D) / 2.0D;

        int r1 = (startColor >> 16) & 255;
        int g1 = (startColor >> 8) & 255;
        int b1 = startColor & 255;

        int r = (int) (r1 + (((endColor >> 16) & 255) - r1) * t);
        int g = (int) (g1 + (((endColor >> 8) & 255) - g1) * t);
        int b = (int) (b1 + ((endColor & 255) - b1) * t);

        return (r << 16) | (g << 8) | b;
    }
}
