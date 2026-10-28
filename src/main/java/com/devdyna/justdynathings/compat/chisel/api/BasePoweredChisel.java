package com.devdyna.justdynathings.compat.chisel.api;

import org.jspecify.annotations.NonNull;

import com.direwolf20.justdirethings.JustDireThings;
import com.direwolf20.justdirethings.common.items.interfaces.PoweredItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class BasePoweredChisel extends BaseAbilityChisel implements PoweredItem {

    public BasePoweredChisel(Properties p) {
        super(p);

    }

    public int getMaxDamage(ItemStack stack) {
        return 0;
    }

    public boolean isDamageable(ItemStack stack) {
        return PoweredItem.hasEnoughEnergy(stack, getFECostAtUse());
    }

    @Override
    public @NonNull InteractionResult use(Level level, @NonNull Player player, @NonNull InteractionHand hand) {
        return checkPower(player, player.getItemInHand(hand), false)
                ? super.use(level, player, hand)
                : InteractionResult.PASS;
    }

    public boolean checkPower(Player player, ItemStack item, boolean consume) {
        var val = PoweredItem.hasEnoughEnergy(item, getFECostAtUse());
        if (!val)
            player.sendOverlayMessage(Component.translatable(JustDireThings.MODID + ".lowenergy"));
        else if (consume)
            PoweredItem.consumeEnergy(player, item, getFECostAtUse());

        return val;
    }

    protected abstract int getFECostAtUse();

    public boolean isBarVisible(ItemStack s) {
        return ((PoweredItem) s.getItem()).isPowerBarVisible(s);
    }

    public int getBarWidth(ItemStack s) {
        return ((PoweredItem) s.getItem()).getPowerBarWidth(s);
    }

    public int getBarColor(ItemStack s) {
        int color = ((PoweredItem) s.getItem()).getPowerBarColor(s);
        return color == -1 ? super.getBarColor(s) : color; // to prevent possible null recipes
    }

}
