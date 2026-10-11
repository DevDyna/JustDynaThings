package com.devdyna.justdynathings.api.solar_panels;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import java.util.ArrayList;
import java.util.List;

import com.devdyna.cakesticklib.api.datagen.LangUtils.TipColors;
import com.devdyna.cakesticklib.api.primitive.Pos;
import com.devdyna.justdynathings.api.ExtraSlots;
import com.devdyna.justdynathings.api.ScrollableTooltip;
import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;
import com.direwolf20.justdirethings.client.screens.standardbuttons.ToggleButtonFactory;
import com.direwolf20.justdirethings.client.screens.widgets.ToggleButton;
import com.direwolf20.justdirethings.util.MiscHelpers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.level.biome.Biome;

public class SolarPanelScreen<T extends SolarGUIBase> extends BaseMachineScreen<T> implements ExtraSlots {

        public SolarPanelScreen(T arg0, Inventory arg1, Component arg2) {
                super(arg0, arg1, arg2);
        }

        @Override
        public void init() {
                super.init();
        }

        @Override
        public void setTopSection() {
                extraWidth = 0;
                extraHeight = 0;
        }

        @Override
        public void addRedstoneButtons() {
                addRenderableWidget(ToggleButtonFactory.REDSTONEBUTTON(
                                getLeftPos() + 104,
                                topSectionTop + 38,
                                redstoneMode.ordinal(),
                                b -> {
                                        redstoneMode = MiscHelpers.RedstoneMode.values()[((ToggleButton) b)
                                                        .getTexturePosition()];
                                        saveSettings();
                                }));
        }

        @Override
        public void addTickSpeedButton() {

        }

        @Override
        protected void extractLabels(GuiGraphicsExtractor graphics, int x, int y) {

                var tip = baseMachineBE.getBlockState().getValue(SolarBlockBase.ACTIVE)
                                ? Component.translatable(MODULE_ID + ".gui.solarpanel.fetip", menu.getFERate())
                                : Component.translatable(MODULE_ID + ".gui.solarpanel.error");

                graphics.text(this.font, tip,
                                this.topSectionLeft - this.leftPos + (this.topSectionWidth / 2)
                                                - this.font.width(tip) / 2,
                                this.topSectionTop - this.topPos + 18, -12566464, false);

                super.extractLabels(graphics, x, y);
        }

        @Override
        public void extractBackground(GuiGraphicsExtractor graphics, int arg1, int arg2, float arg3) {

                super.extractBackground(graphics, arg1, arg2, arg3);

                graphics.blitSprite(RenderPipelines.GUI_TEXTURED, SOCIALBACKGROUND, topSectionLeft + 20 + 20 - 10,
                                topSectionTop + 20 - 10 + 1, topSectionWidth - 40 - 40 / 2, 20);

                addYLevel(graphics, leftPos + 158, topPos + 58);

                if (!menu.enableMultiYLevel())
                        addCross(graphics, leftPos + 158, topPos + 58);

                addSpam(graphics, leftPos + 158 - 18, topPos + 58);

                if (!menu.enableMultiPopulator())
                        addCross(graphics, leftPos + 158 - 18, topPos + 58);

                addSky(graphics, leftPos + 158 - 18 - 18, topPos + 58);

                if (!menu.enableCleanSky())
                        addCross(graphics, leftPos + 158 - 18 - 18, topPos + 58);

                addDayTime(graphics, leftPos + 158 - 18 - 18 - 18, topPos + 58);

                if (!menu.enableDayTimeOnly())
                        addCross(graphics, leftPos + 158 - 18 - 18 - 18, topPos + 58);

                addBiomeListType(graphics, leftPos + 158 - 18 - 18 - 18 - 18, topPos + 58, menu.isAllowBiome());
        }

        private final ScrollableTooltip biomeTooltipBuilder = new ScrollableTooltip(9);

        @Override
        protected void extractTooltip(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
                super.extractTooltip(graphics, mouseX, mouseY);

                if (Pos.of(leftPos + 158, topPos + 58).setSize(16, 16).test(mouseX, mouseY))
                        graphics.setComponentTooltipForNextFrame(font,
                                        List.of(Component.translatable(MODULE_ID + ".gui.solarpanel.tip.ylevel."
                                                        + (menu.enableMultiYLevel() ? "enabled" : "disabled"))),
                                        mouseX, mouseY);

                if (Pos.of(leftPos + 158 - 18, topPos + 58).setSize(16, 16).test(mouseX, mouseY))
                        graphics.setComponentTooltipForNextFrame(font,
                                        List.of(Component.translatable(MODULE_ID + ".gui.solarpanel.tip.spam."
                                                        + (menu.enableMultiPopulator() ? "enabled" : "disabled"))),
                                        mouseX, mouseY);

                if (Pos.of(leftPos + 158 - 18 - 18, topPos + 58).setSize(16, 16).test(mouseX, mouseY))
                        graphics.setComponentTooltipForNextFrame(font,
                                        List.of(Component.translatable(MODULE_ID + ".gui.solarpanel.tip.cleansky."
                                                        + (menu.enableCleanSky() ? "enabled" : "disabled"))),
                                        mouseX, mouseY);

                if (Pos.of(leftPos + 158 - 18 - 18 - 18, topPos + 58).setSize(16, 16).test(mouseX, mouseY))
                        graphics.setComponentTooltipForNextFrame(font,
                                        List.of(Component.translatable(MODULE_ID + ".gui.solarpanel.tip.daytime."
                                                        + (menu.enableDayTimeOnly() ? "enabled" : "disabled"))),
                                        mouseX, mouseY);

                if (Pos.of(leftPos + 158 - 18 - 18 - 18 - 18, topPos + 58).setSize(16, 16).test(mouseX, mouseY))
                        graphics.setComponentTooltipForNextFrame(font, extractBiomeTooltip(menu.getBiomeTag()), mouseX,
                                        mouseY);

        }

        private List<Component> extractBiomeTooltip(TagKey<Biome> tag) {

                List<Component> tip = new ArrayList<>();

                var level = Minecraft.getInstance().level;

                if (level == null)
                        return tip;

                var isWhiteList = menu.isAllowBiome();

                tip.add(Component.translatable(
                                MODULE_ID + ".gui.solarpanel.tip.biomes." + (isWhiteList ? "whitelist" : "blacklist")));

                var b = level.registryAccess()
                                .lookupOrThrow(Registries.BIOME).get(tag);

                if (b.isEmpty()) {
                        tip.clear();
                        tip.add(Component.translatable(
                                        MODULE_ID + ".gui.solarpanel.tip.biomes.empty."
                                                        + (isWhiteList ? "whitelist" : "blacklist")));
                        return biomeTooltipBuilder.tooltips(tip).render();
                }

                var biomes = b.get();

                if (biomes.size() == 0) {
                        tip.clear();
                        tip.add(Component.translatable(MODULE_ID + ".gui.solarpanel.tip.biomes.empty."
                                        + (isWhiteList ? "whitelist" : "blacklist")));
                        return biomeTooltipBuilder.tooltips(tip).render();
                }

                for (var holder : biomes)
                        holder.unwrapKey().ifPresent(key -> tip.add(Component.literal(
                                        (isWhiteList ? TipColors.GREEN : TipColors.RED) + "- " + key.identifier())));

                return biomeTooltipBuilder.tooltips(tip).render();
        }

        @Override
        public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
                if (Pos.of(leftPos + 158 - 18 - 18 - 18 - 18, topPos + 58).setSize(16, 16).test(mouseX, mouseY))
                        return biomeTooltipBuilder.onMouseScroll(scrollY);

                return super.mouseScrolled(mouseX, mouseY, scrollX, scrollY);
        }

        @Override
        protected void drawMachineSlot(GuiGraphicsExtractor guiGraphics, Slot slot) {
                if (slot.getItem().isEmpty())
                        addSlotCharge(guiGraphics, slot);
                else
                        super.drawMachineSlot(guiGraphics, slot);
        }
}