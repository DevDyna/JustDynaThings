package com.devdyna.justdynathings.mixin;

import com.devdyna.cakesticklib.api.gui.ImageGui;
import com.direwolf20.justdirethings.client.screens.GeneratorFluidT1Screen;
import com.direwolf20.justdirethings.client.screens.GeneratorT1Screen;
import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.neoforged.fml.ModList;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;


@Mixin(BaseMachineScreen.class)
public class GeneratorsJEIScreenMixin {

    @Inject(method = "extractBackground", at = @At("TAIL"))
    private void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {

        @SuppressWarnings("rawtypes")
        var gui = (BaseMachineScreen) (Object) this;

        if (gui instanceof GeneratorT1Screen || gui instanceof GeneratorFluidT1Screen)
            if (!ModList.get().isLoaded("justtieredgens")) {

                var screen = gui;

                int x = screen.getLeftPos();
                int y = screen.getTopPos();

                ImageGui.of()
                        .rl(MODULE_ID, "textures/gui/slots/recipe.png")
                        .size(16, 16)
                        .offset(x + 158, y - 22)
                        .sizeTexture(16, 16)
                        .render(graphics);
            }

    }
}