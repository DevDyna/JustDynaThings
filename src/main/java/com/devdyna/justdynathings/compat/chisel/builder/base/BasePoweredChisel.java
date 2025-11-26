package com.devdyna.justdynathings.compat.chisel.builder.base;

import java.util.*;

import com.direwolf20.justdirethings.common.items.interfaces.PoweredItem;
import com.direwolf20.justdirethings.util.TooltipHelpers;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("null")
public abstract class BasePoweredChisel extends BaseAbilityChisel implements PoweredItem {

    protected ChiselType chiselType;

    public BasePoweredChisel(ChiselType chiselType, Properties p) {
        super(chiselType, p, -1);
        this.chiselType = chiselType;
        
    }

    public int getMaxDamage(ItemStack stack) {
        return 0;
    }

    public boolean isDamageable(ItemStack stack) {
        return false;// TODO FE cost on damage craft
    }

    public boolean onChisel(Level world, Player player, ItemStack chisel, Block target) {
        return false;// ??
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (PoweredItem.hasEnoughEnergy(stack, getFECostAtUse()))
            return PoweredItem.consumeEnergy(stack, getFECostAtUse());
        return false;
    }

    protected abstract int getFECostAtUse();

    public void appendHoverText(ItemStack s, Item.TooltipContext c, List<Component> t,
            TooltipFlag f) {
        super.appendHoverText(s, c, t, f);
        if (c.level() != null)
            TooltipHelpers.appendFEText(s, t);
    }

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
