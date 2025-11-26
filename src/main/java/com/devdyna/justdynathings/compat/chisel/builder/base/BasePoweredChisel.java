package com.devdyna.justdynathings.compat.chisel.builder.base;

import static com.devdyna.justdynathings.Main.ID;

import java.util.*;

import com.direwolf20.justdirethings.common.items.interfaces.PoweredItem;
import com.direwolf20.justdirethings.util.TooltipHelpers;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("null")
public abstract class BasePoweredChisel extends BaseAbilityChisel implements PoweredItem {

    protected ChiselType chiselType;
    protected boolean isGuiOpened = false;

    public BasePoweredChisel(ChiselType chiselType, Properties p) {
        super(chiselType, p, -1);
        this.chiselType = chiselType;

    }

    public int getMaxDamage(ItemStack stack) {
        return 0;
    }

    public boolean isDamageable(ItemStack stack) {
        return PoweredItem.hasEnoughEnergy(stack, getFECostAtUse());
    }

    @Override
    public boolean canChiselBlock(Level world, Player player, InteractionHand hand, BlockPos pos, BlockState state) {
        return checkPower(player, player.getItemInHand(hand), true);
    }

    @Override
    public boolean canOpenGui(Level world, Player player, InteractionHand hand) {
        return checkPower(player, player.getItemInHand(hand), false);
    }

    public boolean onChisel(Level world, Player player, ItemStack chisel, Block target) {
        return checkPower(player, chisel, true);
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return checkPower((Player) attacker, stack, true);
    }

    protected boolean checkPower(Player player, ItemStack item, boolean consume) {
        var val = PoweredItem.hasEnoughEnergy(item, getFECostAtUse());
        if (!val)
            player.displayClientMessage(Component.translatable("justdirethings.lowenergy"), true);
        else if (consume)
            PoweredItem.consumeEnergy(item, getFECostAtUse());

        return val;
    }

    protected abstract int getFECostAtUse();

    @Override
    protected boolean enableToolAbilityTip() {
        return false;
    }

    public void appendHoverText(ItemStack s, Item.TooltipContext c, List<Component> t,
            TooltipFlag f) {

        if (Screen.hasControlDown())
            super.appendHoverText(s, c, t, f);
        else
            t.add(Component.translatable(ID + ".hold_control"));

        toolAbilityTips(s, c, t);
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
