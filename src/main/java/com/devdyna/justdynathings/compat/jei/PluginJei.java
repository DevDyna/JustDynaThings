package com.devdyna.justdynathings.compat.jei;

import static com.devdyna.justdynathings.Main.ID;

import java.util.ArrayList;
import java.util.List;

import com.devdyna.justdynathings.compat.jei.datamaps.categories;
import com.devdyna.justdynathings.compat.jei.datamaps.records;
import com.devdyna.justdynathings.compat.jei.datamaps.categories.*;
import com.devdyna.justdynathings.datagen.server.DataRecipe;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.direwolf20.justdirethings.client.jei.GooSpreadRecipeCategory;
import com.direwolf20.justdirethings.client.jei.GooSpreadRecipeTagCategory;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("null")
@JeiPlugin
public class PluginJei implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(ID, "jei_plugin");
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {

        List<RecipeHolder<CraftingRecipe>> toHide = new ArrayList<>();

        zBlocks.zBlockItem.getEntries().forEach(b -> {
            if (!DataRecipe.denyClearBlocks.contains(b.get())) {
                Minecraft.getInstance().level.getRecipeManager()
                        .byKey(ResourceLocation.parse(b.getId() + "_clear_nbt"))
                        .ifPresent(r -> toHide.add((RecipeHolder<CraftingRecipe>) r));

            }
        });

        jeiRuntime.getRecipeManager().hideRecipes(RecipeTypes.CRAFTING, toHide);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration r) {

        List<RecipeType<? extends CraftingRecipe>> recipeTypes = List.of(GooSpreadRecipeCategory.TYPE,
                GooSpreadRecipeTagCategory.TYPE);

        List<Block> gooBlocks = List.of(
                zBlocks.CREATIVE_GOO.get(),
                zBlocks.ENERGIZED_GOO.get(),
                zBlocks.T1_GOO.get(),
                zBlocks.T2_GOO.get(),
                zBlocks.T3_GOO.get(),
                zBlocks.T4_GOO.get());

        gooBlocks.forEach(b -> recipeTypes.forEach(t -> r.addRecipeCatalyst(new ItemStack(b), t)));

        r.addRecipeCatalyst(zBlocks.FERRICORE_ANVIL.get(), FerricoreItemRepairCategory.TYPE);
        r.addRecipeCatalyst(zBlocks.BLAZEGOLD_ANVIL.get(), BlazeGoldFluidRepairCategory.TYPE);
        r.addRecipeCatalyst(zBlocks.ECLIPSEALLOY_ANVIL.get(), EclipseAlloyFluidRepairCategory.TYPE);
        r.addRecipeCatalyst(zBlocks.THERMOGEN.get(), ThermoBlockHeatSourceCategory.TYPE);
        r.addRecipeCatalyst(zBlocks.THERMOGEN.get(), ThermoFluidCoolantCategory.TYPE);

    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration r) {
        IGuiHelper h = r.getJeiHelpers().getGuiHelper();
        r.addRecipeCategories(new categories.FerricoreItemRepairCategory(h));
        r.addRecipeCategories(new categories.BlazeGoldFluidRepairCategory(h));
        r.addRecipeCategories(new categories.EclipseAlloyFluidRepairCategory(h));
        r.addRecipeCategories(new categories.ThermoBlockHeatSourceCategory(h));
        r.addRecipeCategories(new categories.ThermoFluidCoolantCategory(h));
    }

    @Override
    public void registerRecipes(IRecipeRegistration r) {
        r.addRecipes(FerricoreItemRepairCategory.TYPE, records.FerricoreItemRepair.get());
        r.addRecipes(BlazeGoldFluidRepairCategory.TYPE, records.BlazeGoldFluidRepair.get());
        r.addRecipes(EclipseAlloyFluidRepairCategory.TYPE, records.EclipseAlloyFluidRepair.get());
        r.addRecipes(ThermoBlockHeatSourceCategory.TYPE, records.ThermoBlockHeatSource.get());
        r.addRecipes(ThermoFluidCoolantCategory.TYPE, records.ThermoFluidCoolant.get());
    }

}
