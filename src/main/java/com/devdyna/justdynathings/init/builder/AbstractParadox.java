package com.devdyna.justdynathings.init.builder;

import java.awt.Color;
import java.util.function.Consumer;

import com.devdyna.cakesticklib.api.RandomUtil;
import com.devdyna.cakesticklib.api.utils.ColorUtils;
import com.direwolf20.justdirethings.common.items.resources.TimeCrystal;

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

public class AbstractParadox extends TimeCrystal {

    public AbstractParadox(Properties p) {
        super(p.stacksTo(1).fireResistant());
    }

    @Override
    public void inventoryTick(ItemStack itemStack, ServerLevel level, Entity entity, EquipmentSlot slot) {
        //apply different effects?
        if (entity instanceof LivingEntity)
            if (RandomUtil.chance(level, 5))
                level.playSound(entity, entity.getOnPos(),
                        SoundEvents.SCULK_SHRIEKER_SHRIEK, SoundSource.PLAYERS,
                        0.5f, 1.75f);
        super.inventoryTick(itemStack, level, entity, slot);
    }

    @Override
    public Component getName(ItemStack stack) {
        return Component.translatable(getDescriptionId())
                .withColor(ColorUtils.pulse(Color.BLUE, Color.MAGENTA, 4).getRGB());
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay display,
            Consumer<Component> tooltip, TooltipFlag flagIn) {
    }

    

  

}
