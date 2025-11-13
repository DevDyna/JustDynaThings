package com.devdyna.justdynathings.compat.jei.categories;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.compat.jei.utils.BaseRecipeCategory;
import com.devdyna.justdynathings.compat.jei.utils.FuelTierRecord;
import com.devdyna.justdynathings.utils.Pos;
import com.devdyna.justdynathings.utils.Size;
import com.direwolf20.justdirethings.common.blocks.resources.CoalBlock_T1;
import com.direwolf20.justdirethings.common.items.resources.Coal_T1;
import com.direwolf20.justdirethings.setup.Config;
import com.direwolf20.justdirethings.setup.Registration;
import com.direwolf20.justdirethings.util.MagicHelpers;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class FuelRecipeCategory extends BaseRecipeCategory<FuelTierRecord> {
    public static final RecipeType<FuelTierRecord> TYPE = RecipeType.create(ID,
            Registration.GeneratorT1_ITEM.getId().getPath(), FuelTierRecord.class);

    public FuelRecipeCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public RecipeType<FuelTierRecord> getRecipeType() {
        return TYPE;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FuelTierRecord recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 8)
                .addItemStacks(recipe.getFuels());
    }

    @Override
    public String getTitleKey() {
        return Registration.GeneratorT1_ITEM.getId().getPath();
    }

    @Override
    public ItemLike getIconItem() {
        return Registration.GeneratorT1_ITEM.get();
    }

    @Override
    public Size setXY() {
        return Size.of(96, 32);
    }

    @Override
    public String setBackGround() {
        return "textures/gui/fuel_icons.png";
    }

    @Override
    public void draw(FuelTierRecord recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX,
            double mouseY) {
        super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);

        int multiplier = 1;

        if (recipe.getFuels().getFirst().getItem() instanceof Coal_T1 c)
            multiplier = c.getBurnSpeedMultiplier();
        else if (recipe.getFuels().getFirst().getItem() instanceof BlockItem bi
                && bi.getBlock() instanceof CoalBlock_T1 c)
            multiplier = c.getBurnSpeedMultiplier();

        var fuelFurn = recipe.getBurnTime();

        // (int) (Math.floor(fuelFurn) / Config.GENERATOR_T1_BURN_SPEED_MULTIPLIER.get()
        // * multiplier);

        var rate = (int) (Config.GENERATOR_T1_FE_PER_FUEL_TICK.get() * Config.GENERATOR_T1_BURN_SPEED_MULTIPLIER.get()
                * multiplier);

        var total = fuelFurn * Config.GENERATOR_T1_FE_PER_FUEL_TICK.get();

        var maxburn = total / rate;

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

    }

    @Override
    public void getTooltip(ITooltipBuilder tooltip, FuelTierRecord recipe, IRecipeSlotsView recipeSlotsView,
            double mouseX, double mouseY) {

        if (Pos.of(21, 0).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(ID + ".jei.time"));

        if (Pos.of(21, 11).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(ID + ".jei.rate"));

        if (Pos.of(21, 22).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(ID + ".jei.total"));

    }

}
