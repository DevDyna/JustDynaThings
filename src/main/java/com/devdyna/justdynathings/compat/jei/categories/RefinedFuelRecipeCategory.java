package com.devdyna.justdynathings.compat.jei.categories;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.types.IRecipeType;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.cakesticklib.api.compat.jei.BaseCategory;
import com.devdyna.cakesticklib.api.compat.jei.JEIFluidTankHelper;
import com.devdyna.cakesticklib.api.primitive.Pos;
import com.devdyna.cakesticklib.api.primitive.Size;
import com.devdyna.cakesticklib.api.utils.x;
import com.devdyna.justdynathings.JustDynaThings;
import com.devdyna.justdynathings.compat.jei.utils.FuelRecords;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.FluidIngredient;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

@SuppressWarnings("null")
public class RefinedFuelRecipeCategory extends BaseCategory<FuelRecords.Fluids> {
    public static final IRecipeType<FuelRecords.Fluids> TYPE = IRecipeType.create(MODULE_ID,
            JDTRegistration.GeneratorFluidT1_ITEM.getId().getPath(), FuelRecords.Fluids.class);

    public RefinedFuelRecipeCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public IRecipeType<FuelRecords.Fluids> getRecipeType() {
        return TYPE;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FuelRecords.Fluids recipe, IFocusGroup focuses) {
        JEIFluidTankHelper.of()
                .fluid(new SizedFluidIngredient(FluidIngredient.of(recipe.getFuels().toArray(FluidStack[]::new)), 1))
                .offset(1, 8 + 16)
                .build((x, y) -> builder.addInputSlot(x, y));

    }

    @Override
    public ItemLike getIconItem() {
        return JDTRegistration.GeneratorFluidT1_ITEM.get();
    }

    @Override
    public Size setXY() {
        return Size.of(96, 32);
    }

    @Override
    public void draw(FuelRecords.Fluids recipe, IRecipeSlotsView recipeSlotsView, GuiGraphicsExtractor guiGraphics,
            double mouseX,
            double mouseY) {
        super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);

        // var BUCKET = 1000;
        var rate = recipe.getMultiplier();
        var maxburn = 1;
        var total = maxburn * rate;

        var stack = guiGraphics.pose();
        stack.pushMatrix();
        stack.scale(0.75F, 0.75F);
        guiGraphics.text(font,
                Component.literal(maxburn + " ticks"),
                46, 4,
                0xFFFFFFFF);
        guiGraphics.text(font, Component.literal(rate + " FE/tick"), 46, 18, 0xFFFFFFFF);
        guiGraphics.text(font, Component.literal(total + " FE"), 46,
                32,
                0xFFFFFFFF);

        stack.popMatrix();

        // ImageJei.of().rl("minecraft",
        // "textures/gui/sprites/icon/unseen_notification.png")
        // .size(10, 10).offset(100, 10)
        // .render(helper, guiGraphics);

    }

    @Override
    public void getTooltip(ITooltipBuilder tooltip, FuelRecords.Fluids recipe, IRecipeSlotsView recipeSlotsView,
            double mouseX, double mouseY) {

        if (Pos.of(21, 0).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(MODULE_ID + ".jei.time"));

        if (Pos.of(21, 11).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(MODULE_ID + ".jei.rate"));

        if (Pos.of(21, 22).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(MODULE_ID + ".jei.total"));

        // if (Pos.of(100, 10).setSize(10, 10).test(mouseX, mouseY))
        // tooltip.add(Component.translatable(MODULE_ID + ".jei.bucket"));

    }

    @Override
    public String getTraslationKey() {
        return JustDynaThings.MODULE_ID + ".jei.category." + JDTRegistration.GeneratorFluidT1_ITEM.getId().getPath();
    }

    @Override
    public Identifier setBackGround() {
        return x.rl(MODULE_ID, "textures/gui/fuel_icons.png");
    }

}
