
package com.devdyna.justdynathings.api;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;

public class ScrollableTooltip {

    private final List<Component> lines = new ArrayList<>();

    private int visible;
    private int scroll = 0;

    private final Component scrollUp =
            Component.translatable(MODULE_ID + ".gui.tip.scroll.up");

    private final Component scrollDown =
            Component.translatable(MODULE_ID + ".gui.tip.scroll.down");

    public ScrollableTooltip(int visible) {
        this.visible = visible;
    }

    public ScrollableTooltip tooltips(List<Component> tip) {
        this.lines.clear();
        this.lines.addAll(tip);

        this.scroll = Mth.clamp(this.scroll, 0, getMaxEntries());

        return this;
    }

    public int getScroll() {
        return scroll;
    }

    public List<Component> getLines() {
        return lines;
    }

    
    public int getMaxEntries() {
        if (lines.size() <= 1)
            return 0;

        return Math.max(0, lines.size() - 1 - visible);
    }

    public boolean onMouseScroll(double y) {
        int oldScroll = this.scroll;

        this.scroll = Mth.clamp(
                this.scroll - (int) y,
                0,
                getMaxEntries()
        );

        return oldScroll != this.scroll;
    }

    public List<Component> render() {
        if (lines.isEmpty())
            return List.of();

        this.scroll = Mth.clamp(
                this.scroll,
                0,
                getMaxEntries()
        );

        List<Component> result = new ArrayList<>();

        result.add(lines.get(0));

        if (lines.size() == 1)
            return result;

        int start = 1 + scroll;
        int end = Math.min(start + visible, lines.size());

        if (scroll > 0)
            result.add(scrollUp);

        result.addAll(lines.subList(start, end));

        if (end < lines.size())
            result.add(scrollDown);

        return result;
    }
}

