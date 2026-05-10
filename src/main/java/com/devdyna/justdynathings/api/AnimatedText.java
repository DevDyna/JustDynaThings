package com.devdyna.justdynathings.api;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.devdyna.cakesticklib.api.utils.TimeUtil;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

@Deprecated
public class AnimatedText {

    private static final Map<String, AnimatedText> CACHE = new ConcurrentHashMap<>();
    private static final Random RANDOM = new Random();

    private static final long CHAR_SPEED = 25L;

    private final List<Integer> bag = new ArrayList<>();
    private final List<String> entries;

    private int progress = 0;
    private long nextSwitch = 0L;
    private String currentRaw = "";
    private long switchDelay = 0L;
    private boolean reversing = false;
    private long lastTick = 0L;

    private AnimatedText(List<String> entries) {
        this.entries = entries;

        refillBag();
        pickNext();
    }

    public static Component create(String id, List<String> entries) {
        return CACHE
                .computeIfAbsent(id, k -> new AnimatedText(entries))
                .tick();
    }

    private Component tick() {

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

        for (int i = 0; i < progress; i++) {
            result.append(Component.literal(String.valueOf(currentRaw.charAt(i))));
        }

        if (progress < currentRaw.length()) {
            result.append(Component.literal(String.valueOf(randomChar())));
        }

        return result.withStyle(ChatFormatting.GOLD);
    }

    private void pickNext() {
        if (bag.isEmpty()) {
            refillBag();
        }

        currentRaw = entries.get(bag.remove(0));
    }

    private void refillBag() {
        bag.clear();

        for (int i = 0; i < entries.size(); i++) {
            bag.add(i);
        }

        Collections.shuffle(bag);
    }

    private void randomizeDelay() {
        switchDelay = (long) (
                (TimeUtil.ONE_SECOND * 1.5)
                        + RANDOM.nextInt((int) (3.5 * TimeUtil.ONE_SECOND)));
    }

    private char randomChar() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        return chars.charAt(RANDOM.nextInt(chars.length()));
    }
}