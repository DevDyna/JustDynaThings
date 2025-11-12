package com.devdyna.justdynathings.compat.jei.categories;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.compat.jei.utils.BaseRecipeCategory;
import com.devdyna.justdynathings.compat.jei.utils.FuelTierRecord;
import com.devdyna.justdynathings.compat.jei.utils.Size;
import com.direwolf20.justdirethings.common.blocks.resources.CoalBlock_T1;
import com.direwolf20.justdirethings.common.items.resources.Coal_T1;
import com.direwolf20.justdirethings.setup.Config;
import com.direwolf20.justdirethings.setup.Registration;
import com.direwolf20.justdirethings.util.MagicHelpers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
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
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1)
                .addItemStacks(recipe.getFuels());
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

        var maxburn = (int) (Math.floor(fuelFurn) / Config.GENERATOR_T1_BURN_SPEED_MULTIPLIER.get() * multiplier) / 10;

        var total = fuelFurn * Config.GENERATOR_T1_FE_PER_FUEL_TICK.get();

        var rate = (int) (Config.GENERATOR_T1_FE_PER_FUEL_TICK.get() * Config.GENERATOR_T1_BURN_SPEED_MULTIPLIER.get()
                * multiplier);

        guiGraphics.drawString(Minecraft.getInstance().font,
                multiplier + "x",
                18, -10, 0x444444, false);

        guiGraphics.drawString(Minecraft.getInstance().font,
                "time " + (!Screen.hasShiftDown() ? MagicHelpers.ticksInSeconds(maxburn) + " seconds"
                        : maxburn + " ticks"),
                18, 0, 0x444444,
                false);
        guiGraphics.drawString(Minecraft.getInstance().font,
                "fe total " + total, 18, 10, 0x444444,
                false);
        guiGraphics.drawString(Minecraft.getInstance().font,
                "fe rate " + rate,
                18, 20, 0x444444, false);

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
        return Size.of(128, 32);
    }

    @Override
    public String setBackGround() {
        return "textures/gui/fuel_icons.png";
    }

}
