package com.devdyna.justdynathings.init.builder;

import java.awt.Color;

import com.devdyna.cakesticklib.api.utils.TimeUtil;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class AbstractParadox extends Item {

    public AbstractParadox(Properties p) {
        super(p.stacksTo(1));
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable(getDescriptionId())
                .withColor(pulseColor(Color.BLUE.getRGB(), Color.MAGENTA.getRGB()));
    }

    //TODO move to api
    private int pulseColor(int delay, int startColor, int endColor) {
        var t = (Math.sin((System.currentTimeMillis() % delay) * (Math.PI * 2D / delay)) + 1.0D) / 2.0D;

        int r1 = (startColor >> 16) & 255;
        int g1 = (startColor >> 8) & 255;
        int b1 = startColor & 255;

        int r = (int) (r1 + (((endColor >> 16) & 255) - r1) * t);
        int g = (int) (g1 + (((endColor >> 8) & 255) - g1) * t);
        int b = (int) (b1 + ((endColor & 255) - b1) * t);

        return (r << 16) | (g << 8) | b;
    }

    private int pulseColor(int startColor, int endColor) {
        return pulseColor((int)TimeUtil.ONE_SECOND, startColor, endColor);
    }

}
