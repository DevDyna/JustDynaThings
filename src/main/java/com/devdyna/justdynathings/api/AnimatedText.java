package com.devdyna.justdynathings.api;

import java.util.*;

import com.devdyna.cakesticklib.api.utils.TimeUtil;
import com.devdyna.justdynathings.Config;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

//TODO move to api and format where possible
public class AnimatedText {

    private final List<Integer> bag = new ArrayList<>();
    private final List<Component> entries;
    private int progress = 0;
    private long nextSwitch = 0L;
    private int currentIndex = 0;
    private String currentRaw = "";
    private long switchDelay = 0L;
    private static final long CHAR_SPEED = 25L;
    private boolean reversing = false;
    private long lastTick = 0L;
    private static final Random RANDOM = new Random();

    // IT WORK , DONT TOUCH IT
    // SERIOUSLY DONT TOUCH IT!
    private static AnimatedText TOOLTIP = new AnimatedText(Config.UNSTABLE_TIME_CRYSTAL_TOOLTIPS.get());

    public static Component build() {
        return TOOLTIP.tick();
    }

    public AnimatedText(List<String> entries) {
        this.entries = entries.stream().map(s -> (Component) Component.literal(s)).toList();
        refillBag();
        pickNext();
    }

    public Component tick() {

        long now = System.currentTimeMillis();

        if (now >= nextSwitch) {

            reversing = !reversing;

            if (!reversing) {
                pickNext();
                progress = 0;
            }

            randomizeDelay();
            nextSwitch = now + switchDelay;
        }

        if (now - lastTick >= CHAR_SPEED) {

            int len = currentRaw.length();

            if (!reversing) {
                if (progress < len)
                    progress++;
            } else {
                if (progress > 0)
                    progress--;
            }

            progress = Math.max(0, Math.min(progress, len));

            lastTick = now;
        }

        MutableComponent result = Component.empty();
        int len = currentRaw.length();

        for (int i = 0; i < progress && i < len; i++)
            result.append(Component.literal(String.valueOf(currentRaw.charAt(i))));

        if (progress < len)
            result.append(Component.literal(String.valueOf(randomChar())));

        return result.withStyle(ChatFormatting.GOLD);
    }

    private void pickNext() {
        if (bag.isEmpty())
            refillBag();
        currentIndex = bag.remove(0);
        currentRaw = entries.get(currentIndex).getString();
    }

    private void refillBag() {
        bag.clear();
        for (int i = 0; i < entries.size(); i++)
            bag.add(i);

        Collections.shuffle(bag);
    }

    private void randomizeDelay() {
        switchDelay = (long) ((TimeUtil.ONE_SECOND * 1.5) + RANDOM.nextInt((int) (3.5 * TimeUtil.ONE_SECOND)));
    }

    // TODO API
    // move to StringUtil
    private char randomChar() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return chars.charAt(RANDOM.nextInt(chars.length()));
    }

}
