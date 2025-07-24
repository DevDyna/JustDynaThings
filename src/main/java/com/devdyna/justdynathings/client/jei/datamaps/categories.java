package com.devdyna.justdynathings.client.jei.datamaps;

import static com.devdyna.justdynathings.Main.ID;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.client.jei.datamaps.core.BaseMapCategory;
import com.devdyna.justdynathings.client.jei.datamaps.records.*;
import com.devdyna.justdynathings.registry.types.zBlocks;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.LavaCauldronBlock;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoulFireBlock;

@SuppressWarnings("null")
public class categories {

    public static class FerricoreItemRepairCategory extends BaseMapCategory<records.FerricoreItemRepair> {
        public static final RecipeType<FerricoreItemRepair> TYPE = RecipeType.create(ID,
                Constants.DataMaps.Anvils.ferricore_repair,
                FerricoreItemRepair.class);

        public FerricoreItemRepairCategory(IGuiHelper guiHelper) {
            super(guiHelper, zBlocks.FERRICORE_ANVIL.get(),
                    Component.translatable(ID + ".jei.category." + Constants.DataMaps.Anvils.ferricore_repair),
                    guiHelper.drawableBuilder(ResourceLocation.fromNamespaceAndPath(ID, "textures/gui/labelled.png"), 0,
                            0, 160, 24).addPadding(1, 0, 0, 0).build());
        }

        @Override
        public RecipeType<FerricoreItemRepair> getRecipeType() {
            return TYPE;
        }

        @Override
        public void setRecipe(IRecipeLayoutBuilder b, FerricoreItemRepair map, IFocusGroup focuses) {
            b.addSlot(RecipeIngredientRole.INPUT, 4, 5)
                    .addItemLike(map.item());
        }

        @Override
        public void draw(FerricoreItemRepair map, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics,
                double mouseX,
                double mouseY) {
            guiGraphics.drawString(Minecraft.getInstance().font,
                    "Durability : " + map.durability(), 30, 9, 0x444444, false);
        }
    }

    public static class BlazeGoldFluidRepairCategory extends BaseMapCategory<records.BlazeGoldFluidRepair> {
        public static final RecipeType<BlazeGoldFluidRepair> TYPE = RecipeType.create(ID,
                Constants.DataMaps.Anvils.blazegold_repair,
                BlazeGoldFluidRepair.class);

        public BlazeGoldFluidRepairCategory(IGuiHelper guiHelper) {
            super(guiHelper, zBlocks.BLAZEGOLD_ANVIL.get(),
                    Component.translatable(ID + ".jei.category." + Constants.DataMaps.Anvils.blazegold_repair),
                    guiHelper.drawableBuilder(ResourceLocation.fromNamespaceAndPath(ID, "textures/gui/labelled.png"), 0,
                            0, 160, 24).addPadding(1, 0, 0, 0).build());
        }

        @Override
        public RecipeType<BlazeGoldFluidRepair> getRecipeType() {
            return TYPE;
        }

        @Override
        public void setRecipe(IRecipeLayoutBuilder b, BlazeGoldFluidRepair map, IFocusGroup focuses) {
            b.addSlot(RecipeIngredientRole.INPUT, 4, 5)
                    .addFluidStack(map.fluid());
        }

        @Override
        public void draw(BlazeGoldFluidRepair map, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics,
                double mouseX,
                double mouseY) {
            guiGraphics.drawString(Minecraft.getInstance().font,
                    "Efficiency : " + map.efficiency(), 30, 9, 0x444444, false);
        }
    }

    public static class EclipseAlloyFluidRepairCategory extends BaseMapCategory<records.EclipseAlloyFluidRepair> {
        public static final RecipeType<EclipseAlloyFluidRepair> TYPE = RecipeType.create(ID,
                Constants.DataMaps.Anvils.eclipsealloy_repair,
                EclipseAlloyFluidRepair.class);

        public EclipseAlloyFluidRepairCategory(IGuiHelper guiHelper) {
            super(guiHelper, zBlocks.ECLIPSEALLOY_ANVIL.get(),
                    Component.translatable(ID + ".jei.category." + Constants.DataMaps.Anvils.eclipsealloy_repair),
                    guiHelper.drawableBuilder(ResourceLocation.fromNamespaceAndPath(ID, "textures/gui/labelled.png"), 0,
                            0, 160, 24).addPadding(1, 0, 0, 0).build());
        }

        @Override
        public RecipeType<EclipseAlloyFluidRepair> getRecipeType() {
            return TYPE;
        }

        @Override
        public void setRecipe(IRecipeLayoutBuilder b, EclipseAlloyFluidRepair map, IFocusGroup focuses) {
            b.addSlot(RecipeIngredientRole.INPUT, 4, 5)
                    .addFluidStack(map.fluid());
        }

        @Override
        public void draw(EclipseAlloyFluidRepair map, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics,
                double mouseX,
                double mouseY) {
            guiGraphics.drawString(Minecraft.getInstance().font,
                    "Percentuage : " + map.percentuage(), 30, 9, 0x444444, false);
        }
    }

    public static class ThermoBlockHeatSourceCategory extends BaseMapCategory<records.ThermoBlockHeatSource> {
        public static final RecipeType<ThermoBlockHeatSource> TYPE = RecipeType.create(ID,
                Constants.DataMaps.Thermo.thermo_heat_sources,
                ThermoBlockHeatSource.class);

        public ThermoBlockHeatSourceCategory(IGuiHelper guiHelper) {
            super(guiHelper, Items.MAGMA_BLOCK,
                    Component.translatable(ID + ".jei.category." + Constants.DataMaps.Thermo.thermo_heat_sources),
                    guiHelper.drawableBuilder(ResourceLocation.fromNamespaceAndPath(ID, "textures/gui/labelled.png"), 0,
                            0, 160, 24).addPadding(1, 0, 0, 0).build());
        }

        @Override
        public RecipeType<ThermoBlockHeatSource> getRecipeType() {
            return TYPE;
        }

        @Override
        public void setRecipe(IRecipeLayoutBuilder b, ThermoBlockHeatSource map, IFocusGroup focuses) {

            if (map.block() instanceof LiquidBlock fluid)
                try {
                    b.addSlot(RecipeIngredientRole.INPUT, 4, 5)
                            .addItemLike(fluid.fluid.getBucket());
                } catch (Exception e) {

                }

            if (map.block() instanceof FireBlock || map.block() instanceof SoulFireBlock)
                try {
                    var item = new ItemStack(Items.FIRE_CHARGE);
                    item.set(DataComponents.ITEM_NAME, Component.translatable(map.block().getDescriptionId()));

                    b.addSlot(RecipeIngredientRole.INPUT, 4, 5)
                            .addItemStack(item);
                } catch (Exception e) {

                }

            if (map.block() instanceof LayeredCauldronBlock || map.block() instanceof LavaCauldronBlock)
                try {
                    var item = new ItemStack(Items.CAULDRON);
                    item.set(DataComponents.ITEM_NAME, Component.translatable(map.block().getDescriptionId()));

                    b.addSlot(RecipeIngredientRole.INPUT, 4, 5)
                            .addItemStack(item);
                } catch (Exception e) {

                }

            b.addSlot(RecipeIngredientRole.INPUT, 4, 5)
                    .addItemLike(map.block().asItem());

        }

        @Override
        public void draw(ThermoBlockHeatSource map, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics,
                double mouseX,
                double mouseY) {
            guiGraphics.drawString(Minecraft.getInstance().font,
                    "Efficiency : " + map.heatEfficiency(), 30, 9, 0x444444, false);
        }
    }

    public static class ThermoFluidCoolantCategory extends BaseMapCategory<records.ThermoFluidCoolant> {
        public static final RecipeType<ThermoFluidCoolant> TYPE = RecipeType.create(ID,
                Constants.DataMaps.Thermo.thermo_coolants,
                ThermoFluidCoolant.class);

        public ThermoFluidCoolantCategory(IGuiHelper guiHelper) {
            super(guiHelper, Items.WATER_BUCKET,
                    Component.translatable(ID + ".jei.category." + Constants.DataMaps.Thermo.thermo_coolants),
                    guiHelper.drawableBuilder(ResourceLocation.fromNamespaceAndPath(ID, "textures/gui/labelled.png"), 0,
                            0, 160, 24).addPadding(1, 0, 0, 0).build());
        }

        @Override
        public RecipeType<ThermoFluidCoolant> getRecipeType() {
            return TYPE;
        }

        @Override
        public void setRecipe(IRecipeLayoutBuilder b, ThermoFluidCoolant map, IFocusGroup focuses) {
            b.addSlot(RecipeIngredientRole.INPUT, 4, 5)
                    .addFluidStack(map.fluid());
        }

        @Override
        public void draw(ThermoFluidCoolant map, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics,
                double mouseX,
                double mouseY) {
            guiGraphics.drawString(Minecraft.getInstance().font,
                    "Efficiency : " + map.coolantEfficiency(), 30, 9, 0x444444, false);
        }
    }

}
