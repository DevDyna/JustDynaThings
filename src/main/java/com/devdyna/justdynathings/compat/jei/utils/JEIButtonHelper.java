package com.devdyna.justdynathings.compat.jei.utils;

import java.util.Collection;
import java.util.List;

import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.handlers.IGuiClickableArea;
import mezz.jei.api.gui.handlers.IGuiContainerHandler;
import mezz.jei.api.recipe.IFocusFactory;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.runtime.IRecipesGui;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.network.chat.Component;

public class JEIButtonHelper {

    public static <T extends AbstractContainerScreen<?>> void addRecipeClickArea(IGuiHandlerRegistration r,
                        Class<T> screen, int xPos, int yPos, int width, int height, Component tooltip,
                        RecipeType<?>... recipeTypes) {
                r.addGuiContainerHandler(screen, new IGuiContainerHandler<T>() {
                        @Override
                        public Collection<IGuiClickableArea> getGuiClickableAreas(
                                        T containerScreen,
                                        double mouseX,
                                        double mouseY) {
                                return List.of(new IGuiClickableArea() {
                                        @Override
                                        public Rect2i getArea() {
                                                return new Rect2i(xPos, yPos, width, height);
                                        }

                                        @Override
                                        public void onClick(
                                                        IFocusFactory focusFactory,
                                                        IRecipesGui recipesGui) {
                                                recipesGui.showTypes(List.of(recipeTypes));
                                        }

                                        @Override
                                        public void getTooltip(ITooltipBuilder tooltipBuilder) {
                                                tooltipBuilder.add(tooltip);
                                        }
                                });
                        }
                });
        }
}
