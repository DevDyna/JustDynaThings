package com.devdyna.justdynathings.mixin;

import com.devdyna.justdynathings.compat.jei.utils.Image;
import com.direwolf20.justdirethings.client.screens.GeneratorFluidT1Screen;
import com.direwolf20.justdirethings.client.screens.GeneratorT1Screen;
import com.direwolf20.justdirethings.client.screens.basescreens.BaseMachineScreen;

import net.minecraft.client.gui.GuiGraphics;
import net.neoforged.fml.ModList;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.devdyna.justdynathings.Main.ID;

//TODO port 26.1 and unify on JTG
@Mixin(BaseMachineScreen.class)
public class GeneratorsJEIScreenMixin {

    @Inject(method = "renderBg", at = @At("TAIL"))
    private void renderBg(
            GuiGraphics guiGraphics,
            float partialTicks,
            int mouseX,
            int mouseY,
            CallbackInfo ci) {

        @SuppressWarnings("rawtypes")
        var gui = (BaseMachineScreen) (Object) this;

        if (gui instanceof GeneratorT1Screen || gui instanceof GeneratorFluidT1Screen)
            if (!ModList.get().isLoaded("justtieredgens")) {

                var screen = gui;

                int x = screen.getGuiLeft();
                int y = screen.getGuiTop();

                Image.of()
                        .rl(ID, "textures/gui/slots/recipe.png")
                        .size(16, 16)
                        .offset(x + 158, y - 22)
                        .sizeTexture(16, 16)
                        .render(guiGraphics);
            }

    }
}