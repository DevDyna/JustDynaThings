package com.devdyna.justdynathings.compat.jei.categories;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.neoforge.NeoForgeTypes;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.compat.jei.utils.BaseRecipeCategory;
import com.devdyna.justdynathings.compat.jei.utils.FuelRecords;
import com.devdyna.justdynathings.compat.jei.utils.Image;
import com.devdyna.justdynathings.utils.Pos;
import com.devdyna.justdynathings.utils.Size;
import com.direwolf20.justdirethings.setup.Registration;
import com.direwolf20.justdirethings.util.MagicHelpers;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class RefinedFuelRecipeCategory extends BaseRecipeCategory<FuelRecords.Fluids> {
    public static final RecipeType<FuelRecords.Fluids> TYPE = RecipeType.create(ID,
            Registration.GeneratorFluidT1_ITEM.getId().getPath(), FuelRecords.Fluids.class);

    public RefinedFuelRecipeCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public RecipeType<FuelRecords.Fluids> getRecipeType() {
        return TYPE;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FuelRecords.Fluids recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 8)
                .addIngredients(NeoForgeTypes.FLUID_STACK,
                        recipe.getFuels());
    }

    @Override
    public String getTitleKey() {
        return Registration.GeneratorFluidT1_ITEM.getId().getPath();
    }

    @Override
    public ItemLike getIconItem() {
        return Registration.GeneratorFluidT1_ITEM.get();
    }

    @Override
    public Size setXY() {
        return Size.of(124, 32);
    }

    @Override
    public String setBackGround() {
        return "textures/gui/fuel_icons.png";
    }

    @Override
    public void background(GuiGraphics graphics) {
        Image.of()
                .rl(this.setBackGround())
                .size(96, this.getHeight())
                .render(helper, graphics);
    }

    @Override
    public void draw(FuelRecords.Fluids recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics,
            double mouseX,
            double mouseY) {
        super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);

        var BUCKET = 1000;
        var rate = recipe.getMultiplier();
        var maxburn = BUCKET;
        var total = maxburn * rate;

        PoseStack stack = guiGraphics.pose();
        stack.pushPose();
        stack.scale(0.75F, 0.75F, 8000F);
        guiGraphics.drawString(font,
                (Screen.hasShiftDown()
                        ? MagicHelpers.ticksInSeconds(maxburn).replaceAll("\\.0$", "")
                                + " sec"
                        : maxburn + " ticks"),
                46, 4,
                0xFFFFFF);
        guiGraphics.drawString(font, rate + " FE/tick", 46, 18, 0xFFFFFF);
        guiGraphics.drawString(font, (Screen.hasShiftDown() ? MagicHelpers.withSuffix(total) : total) + " FE", 46, 32,
                0xFFFFFF);
        stack.popPose();

        Image.of().rl("minecraft",
                "textures/gui/sprites/icon/unseen_notification.png")
                .size(10, 10).offset(100, 10)
                .render(helper, guiGraphics);

    }

    @Override
    public void getTooltip(ITooltipBuilder tooltip, FuelRecords.Fluids recipe, IRecipeSlotsView recipeSlotsView,
            double mouseX, double mouseY) {

        if (Pos.of(21, 0).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(ID + ".jei.time"));

        if (Pos.of(21, 11).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(ID + ".jei.rate"));

        if (Pos.of(21, 22).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(ID + ".jei.total"));

        if (Pos.of(100, 10).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(ID + ".jei.bucket"));

    }

}
