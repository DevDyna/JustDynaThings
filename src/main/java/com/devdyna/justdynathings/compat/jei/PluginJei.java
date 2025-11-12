package com.devdyna.justdynathings.compat.jei;

import static com.devdyna.justdynathings.Main.ID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.devdyna.justdynathings.compat.jei.categories.*;
import com.devdyna.justdynathings.compat.jei.categories.anvils.*;
import com.devdyna.justdynathings.compat.jei.categories.reforger.*;
import com.devdyna.justdynathings.compat.jei.categories.thermo.ThermoCoolant;
import com.devdyna.justdynathings.compat.jei.categories.thermo.ThermoHeatSource;
import com.devdyna.justdynathings.compat.jei.datamaps.records;
import com.devdyna.justdynathings.compat.jei.utils.FuelTierRecord;
import com.devdyna.justdynathings.config.common;
import com.devdyna.justdynathings.datagen.server.DataRecipe;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zRecipeTypes;
import com.direwolf20.justdirethings.client.jei.GooSpreadRecipeCategory;
import com.direwolf20.justdirethings.client.jei.GooSpreadRecipeTagCategory;
import com.direwolf20.justdirethings.common.blocks.resources.CoalBlock_T1;
import com.direwolf20.justdirethings.common.items.resources.Coal_T1;
import com.direwolf20.justdirethings.setup.Registration;

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
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;

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

        r.addRecipeCatalyst(zBlocks.FERRICORE_ANVIL.get(), FerricoreAnvil.TYPE);
        r.addRecipeCatalyst(zBlocks.BLAZEGOLD_ANVIL.get(), BlazeGoldAnvil.TYPE);
        r.addRecipeCatalyst(zBlocks.ECLIPSEALLOY_ANVIL.get(), EclipseAlloyAnvil.TYPE);

        r.addRecipeCatalyst(zBlocks.THERMOGEN.get(), ThermoHeatSource.TYPE);
        r.addRecipeCatalyst(zBlocks.THERMOGEN.get(), ThermoCoolant.TYPE);

        r.addRecipeCatalyst(zBlocks.REFORGER.get(), OTO.TYPE);
        r.addRecipeCatalyst(zBlocks.REFORGER.get(), OTM.TYPE);
        r.addRecipeCatalyst(zBlocks.REFORGER.get(), MTO.TYPE);

        r.addRecipeCatalyst(zBlocks.PARADOX_MIXER.get(), ParadoxMixerCategory.TYPE);

        r.addRecipeCatalyst(Registration.GeneratorT1_ITEM.get(), FuelRecipeCategory.TYPE);

    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration r) {
        IGuiHelper h = r.getJeiHelpers().getGuiHelper();

        r.addRecipeCategories(new FerricoreAnvil(h));
        r.addRecipeCategories(new BlazeGoldAnvil(h));
        r.addRecipeCategories(new EclipseAlloyAnvil(h));

        r.addRecipeCategories(new ThermoHeatSource(h));
        r.addRecipeCategories(new ThermoCoolant(h));

        // reforger
        r.addRecipeCategories(new OTO(h));
        r.addRecipeCategories(new OTM(h));
        r.addRecipeCategories(new MTO(h));

        r.addRecipeCategories(new ParadoxMixerCategory<>(h));

        r.addRecipeCategories(new FuelRecipeCategory(h));
    }

    @Override
    public void registerRecipes(IRecipeRegistration r) {

        var recipes = Minecraft.getInstance().level.getRecipeManager();

        r.addRecipes(FerricoreAnvil.TYPE, records.FerricoreItemRepair.get());
        r.addRecipes(BlazeGoldAnvil.TYPE, records.BlazeGoldFluidRepair.get());
        r.addRecipes(EclipseAlloyAnvil.TYPE, records.EclipseAlloyFluidRepair.get());

        r.addRecipes(ThermoHeatSource.TYPE, records.ThermoBlockHeatSource.get());
        r.addRecipes(ThermoCoolant.TYPE, records.ThermoFluidCoolant.get());

        r.addRecipes(OTO.TYPE, recipes.getAllRecipesFor(zRecipeTypes.REFORGER_OTO.getType())
                .stream().map(RecipeHolder::value).toList());

        r.addRecipes(OTM.TYPE, recipes.getAllRecipesFor(zRecipeTypes.REFORGER_OTM.getType())
                .stream().map(RecipeHolder::value).toList());

        r.addRecipes(MTO.TYPE, recipes.getAllRecipesFor(zRecipeTypes.REFORGER_MTO.getType())
                .stream().map(RecipeHolder::value).toList());

        r.addRecipes(ParadoxMixerCategory.TYPE, recipes.getAllRecipesFor(zRecipeTypes.PARADOX_MIXER.getType())
                .stream().map(RecipeHolder::value).toList());

        Map<Integer, List<ItemStack>> fuels = new HashMap<>();

        for (ItemStack i : BuiltInRegistries.ITEM.stream()
                .map(ItemStack::new)
                .filter(AbstractFurnaceBlockEntity::isFuel)
                .toList()) {

            if (i.getItem() instanceof Coal_T1 ||
                    (i.getItem() instanceof BlockItem bi && bi.getBlock() instanceof CoalBlock_T1)) {

                int burnTime = i.getBurnTime(net.minecraft.world.item.crafting.RecipeType.SMELTING);

                r.addRecipes(
                        FuelRecipeCategory.TYPE,
                        List.of(new FuelTierRecord(List.of(i), burnTime)));
                continue; // skip
            }

            // create group
            int burnTime = i.getBurnTime(net.minecraft.world.item.crafting.RecipeType.SMELTING);
            if (burnTime > 0) {
                fuels.computeIfAbsent(burnTime, k -> new ArrayList<>()).add(i);
            }
        }

        if (common.ENABLE_ALL_JEI_FUELS.get())
            for (Map.Entry<Integer, List<ItemStack>> entry : fuels.entrySet()) {
                r.addRecipes(
                        FuelRecipeCategory.TYPE,
                        List.of(new FuelTierRecord(entry.getValue(), entry.getKey())));
            }

    }

}
