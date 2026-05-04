package com.devdyna.justdynathings.compat.jei.categories;

import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.types.IRecipeType;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.cakesticklib.api.primitive.Pos;
import com.devdyna.cakesticklib.api.primitive.Size;
import com.devdyna.justdynathings.api.ClientRender;
import com.devdyna.justdynathings.compat.jei.utils.FuelRecords;
import com.direwolf20.justdirethings.common.blocks.resources.CoalBlock_T1;
import com.direwolf20.justdirethings.common.items.resources.Coal_T1;
import com.direwolf20.justdirethings.setup.Config;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.direwolf20.justdirethings.util.MagicHelpers;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.ItemLike;

@SuppressWarnings("null")
public class FuelRecipeCategory extends BaseRecipeCategory<FuelRecords.Items> implements ClientRender{
    public static final IRecipeType<FuelRecords.Items> TYPE = IRecipeType.create(MODULE_ID,
            JDTRegistration.GeneratorT1_ITEM.getId().getPath(), FuelRecords.Items.class);

    public FuelRecipeCategory(IGuiHelper guiHelper) {
        super(guiHelper);
    }

    @Override
    public IRecipeType<FuelRecords.Items> getRecipeType() {
        return TYPE;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FuelRecords.Items recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 8)
                .addItemStacks(recipe.getFuels());
    }

    @Override
    public String getTitleKey() {
        return JDTRegistration.GeneratorT1_ITEM.getId().getPath();
    }

    @Override
    public ItemLike getIconItem() {
        return JDTRegistration.GeneratorT1_ITEM.get();
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
    public void draw(FuelRecords.Items recipe, IRecipeSlotsView recipeSlotsView, GuiGraphicsExtractor guiGraphics, double mouseX,
            double mouseY) {
        super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);

        int multiplier = 1;

        if (recipe.getFuels().getFirst().getItem() instanceof Coal_T1 c)
            multiplier = c.getBurnSpeedMultiplier();
        else if (recipe.getFuels().getFirst().getItem() instanceof BlockItem bi
                && bi.getBlock() instanceof CoalBlock_T1 c)
            multiplier = c.getBurnSpeedMultiplier();

        var rate = (int) (Config.GENERATOR_T1_FE_PER_FUEL_TICK.get() * Config.GENERATOR_T1_BURN_SPEED_MULTIPLIER.get()
                * multiplier);

        var total = recipe.getBurnTime() * Config.GENERATOR_T1_FE_PER_FUEL_TICK.get();

        var maxburn = total / rate;

        // PoseStack stack = guiGraphics.pose();
        // stack.pushPose();
        // stack.scale(0.75F, 0.75F, 8000F);
        guiGraphics.text(font,
                (hasShiftDown()
                        ? MagicHelpers.ticksInSeconds(maxburn).replaceAll("\\.0$", "")
                                + " sec"
                        : maxburn + " ticks"),
                46, 4,
                0xFFFFFF);
        guiGraphics.text(font, rate + " FE/tick", 46, 18, 0xFFFFFF);
        guiGraphics.text(font, (hasShiftDown() ? MagicHelpers.withSuffix(total) : total) + " FE", 46, 32,
                0xFFFFFF);
        // stack.popPose();

    }

    @Override
    public void getTooltip(ITooltipBuilder tooltip, FuelRecords.Items recipe, IRecipeSlotsView recipeSlotsView,
            double mouseX, double mouseY) {

        if (Pos.of(21, 0).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(MODULE_ID + ".jei.time"));

        if (Pos.of(21, 11).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(MODULE_ID + ".jei.rate"));

        if (Pos.of(21, 22).setSize(10, 10).test(mouseX, mouseY))
            tooltip.add(Component.translatable(MODULE_ID + ".jei.total"));

    }

}