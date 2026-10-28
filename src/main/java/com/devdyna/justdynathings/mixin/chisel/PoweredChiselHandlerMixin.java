package com.devdyna.justdynathings.mixin.chisel;

import com.devdyna.justdynathings.compat.chisel.api.BasePoweredChisel;
import io.github.chiselteam.chisel.event.LeftClickBlockEventHandler;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LeftClickBlockEventHandler.class)
public class PoweredChiselHandlerMixin {

    @Inject(method = "onHitBlock", at = @At("HEAD"), cancellable = true)
    private static void checkPowerOnChisel(PlayerInteractEvent.LeftClickBlock event, CallbackInfo ci) {

        var chisel = event.getItemStack();
        var player = event.getEntity();

        if (player.getUsedItemHand() == event.getHand())
            if (chisel.getItem() instanceof BasePoweredChisel powa) {

                if (!powa.checkPower(player, chisel, true)) {
                    event.setCanceled(true);
                    ci.cancel();
                }

            }
    }
}