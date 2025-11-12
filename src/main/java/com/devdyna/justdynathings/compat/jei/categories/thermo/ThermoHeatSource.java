package com.devdyna.justdynathings.compat.jei.categories.thermo;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.compat.jei.datamaps.records.ThermoBlockHeatSource;
import com.devdyna.justdynathings.compat.jei.utils.BaseLabelledCategory;
import com.devdyna.justdynathings.compat.jei.utils.Image;
import com.devdyna.justdynathings.compat.jei.utils.Pos;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.LavaCauldronBlock;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoulFireBlock;

@SuppressWarnings("null")
public class ThermoHeatSource extends BaseLabelledCategory<ThermoBlockHeatSource> {
        public static final RecipeType<ThermoBlockHeatSource> TYPE = RecipeType.create(ID,
                        Constants.DataMaps.Thermo.thermo_heat_sources,
                        ThermoBlockHeatSource.class);

        public ThermoHeatSource(IGuiHelper guiHelper) {
                super(guiHelper);
        }

        @Override
        public RecipeType<ThermoBlockHeatSource> getRecipeType() {
                return TYPE;
        }

        @Override
        public void setRecipe(IRecipeLayoutBuilder b, ThermoBlockHeatSource map, IFocusGroup focuses) {

                if (map.block() instanceof LiquidBlock fluid) {
                        try {
                                b.addSlot(RecipeIngredientRole.INPUT, 4, 4)
                                                .addItemLike(fluid.fluid.getBucket());
                        } catch (Exception e) {

                        }
                } else

                if (map.block() instanceof FireBlock || map.block() instanceof SoulFireBlock) {
                        try {
                                var item = new ItemStack(Items.FIRE_CHARGE);
                                item.set(DataComponents.ITEM_NAME,
                                                Component.translatable(map.block().getDescriptionId()));

                                b.addSlot(RecipeIngredientRole.INPUT, 4, 4)
                                                .addItemStack(item);
                        } catch (Exception e) {

                        }
                } else

                if (map.block() instanceof LayeredCauldronBlock || map.block() instanceof LavaCauldronBlock) {
                        try {
                                var item = new ItemStack(Items.CAULDRON);
                                item.set(DataComponents.ITEM_NAME,
                                                Component.translatable(map.block().getDescriptionId()));

                                b.addSlot(RecipeIngredientRole.INPUT, 4, 4)
                                                .addItemStack(item);
                        } catch (Exception e) {

                        }
                } else

                        b.addSlot(RecipeIngredientRole.INPUT, 4, 4)
                                        .addItemLike(map.block().asItem());

        }

        @Override
        public void draw(ThermoBlockHeatSource map, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics,
                        double mouseX,
                        double mouseY) {
                super.draw(map, recipeSlotsView, guiGraphics, mouseX, mouseY);
                guiGraphics.drawString(Minecraft.getInstance().font,
                                "Efficiency : " + map.heatEfficiency(), 30, 8, 0x444444, false);

                var b = map.block();
                if (b instanceof LavaCauldronBlock || b instanceof LayeredCauldronBlock || b instanceof FireBlock
                                || b instanceof SoulFireBlock)
                        Image.of().rl("minecraft",
                                        "textures/gui/sprites/icon/unseen_notification.png")
                                        .size(10, 10).offset(130, 6)
                                        .render(helper, guiGraphics);

        }

        @Override
        public void getTooltip(ITooltipBuilder tooltip, ThermoBlockHeatSource map, IRecipeSlotsView recipeSlotsView,
                        double mouseX, double mouseY) {
                if (Pos.of(130, 6).setSize(10, 10).test(mouseX, mouseY))
                        tooltip.add(Component.translatable(ID + ".jei.warning"));

        }

        @Override
        public String getTitleKey() {
                return Constants.DataMaps.Thermo.thermo_heat_sources;
        }

        @Override
        public ItemLike getIconItem() {
                return Items.MAGMA_BLOCK;
        }
}
