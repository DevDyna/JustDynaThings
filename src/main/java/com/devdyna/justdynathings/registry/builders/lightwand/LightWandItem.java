package com.devdyna.justdynathings.registry.builders.lightwand;

import com.devdyna.justdynathings.ConfigCommon;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

@SuppressWarnings("null")
public class LightWandItem extends Item implements ILightWand{

    public LightWandItem() {
        super(new Item.Properties()
                .durability(512)
                .stacksTo(1));
    }

    @Override
    public boolean condToRun(ItemStack stack) {
        return true;
    }

    @Override
    public void consume(Player player, ItemStack stack, InteractionHand hand) {
        stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
        player.getCooldowns().addCooldown(stack.getItem(), 20);
    }

    @Override
    public int glowingDuration() {
        return ConfigCommon.LIGHT_WAND_GLOWING_DURATION.get();
    }

      @Override
    public InteractionResult useOn(UseOnContext context) {
        return itemUse(context);
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity interactionTarget,
            InteractionHand usedHand) {
        return entityGlowing(stack, player, interactionTarget, usedHand);
    }

}
