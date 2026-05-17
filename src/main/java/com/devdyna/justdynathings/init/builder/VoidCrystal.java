package com.devdyna.justdynathings.init.builder;

import java.util.List;
import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.devdyna.cakesticklib.api.animations.AnimatedText;
import com.devdyna.justdynathings.Config;
import com.direwolf20.justdirethings.common.items.resources.TimeCrystal;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

public class VoidCrystal extends TimeCrystal {

    public VoidCrystal(Properties p) {
        super(p.stacksTo(1));
    }

    @Override
    public void inventoryTick(@NotNull ItemStack item, @NotNull ServerLevel level, @NotNull Entity entity,
            @Nullable EquipmentSlot slot) {
        // apply different effects?
        if (entity instanceof LivingEntity) {
            if (level.getRandom().nextFloat() < 0.005F) {
                level.playSound(entity, entity.getOnPos(),
                        SoundEvents.SCULK_SHRIEKER_SHRIEK,
                        SoundSource.PLAYERS,
                        1f, 1.75f);
            }
        }

        for (int i = 0; i < 4; i++) {
            super.inventoryTick(item, level, entity, slot);
        }
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable(getDescriptionId())
                .withStyle(ChatFormatting.DARK_PURPLE);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display,
            Consumer<Component> tooltip, TooltipFlag flagIn) {
        tooltip.accept(
                AnimatedText.create(this.descriptionId, (List<String>) Config.UNSTABLE_TIME_CRYSTAL_TOOLTIPS.get())
                .withStyle(ChatFormatting.GOLD));
    }

}