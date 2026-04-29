package com.devdyna.justdynathings.init.builder.light_wands;

import com.devdyna.justdynathings.Config;
import com.direwolf20.justdirethings.common.items.interfaces.BasePoweredItem;
import com.direwolf20.justdirethings.common.items.interfaces.PoweredItem;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;

@SuppressWarnings("null")
public class AdvancedLightWand extends BasePoweredItem implements PoweredItem, ILightWand {

    public AdvancedLightWand(Properties p) {
        super(p
                .stacksTo(1));
    }

    @Override
    public int getMaxEnergy() {
        return Config.ADVANCED_LIGHT_WAND_FE_CAPACITY.get();
    }

    public static int getFECostAtUse() {
        return Config.ADVANCED_LIGHT_WAND_FE_COST.get();
    }

    @Override
    public boolean condToRun(ItemStack stack) {
        return PoweredItem.hasEnoughEnergy(stack, getFECostAtUse());
    }

    @Override
    public void consume(Player player, ItemStack stack, InteractionHand hand) {
        PoweredItem.consumeEnergy(player,stack, getFECostAtUse());
    }

    @Override
    public int glowingDuration() {
        return Config.ADVANCED_LIGHT_WAND_GLOWING_DURATION.get();
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
