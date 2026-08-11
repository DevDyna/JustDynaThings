package com.devdyna.justdynathings.compat.jei;

import static com.devdyna.justdynathings.Main.ID;

import java.util.*;
import java.util.stream.Collectors;

import com.devdyna.justdynathings.compat.jei.categories.*;
import com.devdyna.justdynathings.compat.jei.categories.anvils.*;
import com.devdyna.justdynathings.compat.jei.categories.thermo.ThermoCoolant;
import com.devdyna.justdynathings.compat.jei.categories.thermo.ThermoHeatSource;
import com.devdyna.justdynathings.compat.jei.datamaps.records;
import com.devdyna.justdynathings.compat.jei.utils.FuelRecords;
import com.devdyna.justdynathings.compat.jei.utils.FuelUtils;
import com.devdyna.justdynathings.config.ServerConfig;
import com.devdyna.justdynathings.datagen.server.DataRecipe;
import com.devdyna.justdynathings.registry.builders.functional_anvils.blazegold.BlazeGoldAnvilScreen;
import com.devdyna.justdynathings.registry.builders.functional_anvils.eclipsealloy.EclipseAlloyAnvilScreen;
import com.devdyna.justdynathings.registry.builders.functional_anvils.ferricore.FerricoreAnvilScreen;
import com.devdyna.justdynathings.registry.builders.paradox_mixer.ParadoxMixerScreen;
import com.devdyna.justdynathings.registry.builders.thermo.ThermoScreen;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zRecipeTypes;
import com.direwolf20.justdirethings.client.jei.GooSpreadRecipeCategory;
import com.direwolf20.justdirethings.client.jei.GooSpreadRecipeTagCategory;
import com.direwolf20.justdirethings.common.blocks.resources.CoalBlock_T1;
import com.direwolf20.justdirethings.common.fluids.basefluids.RefinedFuel;
import com.direwolf20.justdirethings.common.items.resources.Coal_T1;
import com.direwolf20.justdirethings.setup.Registration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.ModList;

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

                r.addRecipeCatalyst(zBlocks.REFORGER.get(), ReforgerCategory.TYPE);

                r.addRecipeCatalyst(zBlocks.PARADOX_MIXER.get(), ParadoxMixerCategory.TYPE);

                r.addRecipeCatalyst(Registration.GeneratorT1_ITEM.get(), FuelRecipeCategory.TYPE);
                r.addRecipeCatalyst(Registration.GeneratorFluidT1_ITEM.get(), RefinedFuelRecipeCategory.TYPE);

        }

        @Override
        public void registerCategories(IRecipeCategoryRegistration r) {
                IGuiHelper h = r.getJeiHelpers().getGuiHelper();

                r.addRecipeCategories(new FerricoreAnvil(h));
                r.addRecipeCategories(new BlazeGoldAnvil(h));
                r.addRecipeCategories(new EclipseAlloyAnvil(h));

                r.addRecipeCategories(new ThermoHeatSource(h));
                r.addRecipeCategories(new ThermoCoolant(h));

                r.addRecipeCategories(new ReforgerCategory(h));

                r.addRecipeCategories(new ParadoxMixerCategory<>(h));

                r.addRecipeCategories(new FuelRecipeCategory(h));
                r.addRecipeCategories(new RefinedFuelRecipeCategory(h));
        }

        @Override
        public void registerRecipes(IRecipeRegistration r) {

                var recipes = Minecraft.getInstance().level.getRecipeManager();

                r.addRecipes(FerricoreAnvil.TYPE, records.FerricoreItemRepair.get());
                r.addRecipes(BlazeGoldAnvil.TYPE, records.BlazeGoldFluidRepair.get());
                r.addRecipes(EclipseAlloyAnvil.TYPE, records.EclipseAlloyFluidRepair.get());

                r.addRecipes(ThermoHeatSource.TYPE, records.ThermoBlockHeatSource.get());
                r.addRecipes(ThermoCoolant.TYPE, records.ThermoFluidCoolant.get());

                r.addRecipes(ReforgerCategory.TYPE, recipes.getAllRecipesFor(zRecipeTypes.REFORGER.getType()));

                r.addRecipes(ParadoxMixerCategory.TYPE, recipes.getAllRecipesFor(zRecipeTypes.PARADOX_MIXER.getType()));

                if (!(ModList.get().isLoaded("justtieredgens") && ServerConfig.DISABLE_FUEL_JEI.get())) {
                        Map<Integer, List<ItemStack>> fuels = new HashMap<>();

                        // Process fuels
                        for (ItemStack stack : FuelUtils.getAllSolidFuels()) {
                                int burnTime = stack.getBurnTime(net.minecraft.world.item.crafting.RecipeType.SMELTING);

                                // Add JDT fuels before
                                if (stack.getItem() instanceof Coal_T1 ||
                                                (stack.getItem() instanceof BlockItem bi
                                                                && bi.getBlock() instanceof CoalBlock_T1)) {
                                        r.addRecipes(FuelRecipeCategory.TYPE,
                                                        List.of(new FuelRecords.Items(List.of(stack))));
                                        continue;
                                }

                                if (burnTime > 0)
                                        fuels.computeIfAbsent(burnTime, k -> new ArrayList<>()).add(stack);

                        }

                        // Add remaining fuels
                        if (ServerConfig.ENABLE_ALL_JEI_FUELS.get())
                                fuels.entrySet().stream()
                                                .sorted(Map.Entry.<Integer, List<ItemStack>>comparingByKey().reversed())
                                                .forEach(entry -> r.addRecipes(FuelRecipeCategory.TYPE,
                                                                List.of(new FuelRecords.Items(entry.getValue()))));

                        FuelUtils.getAllRefinedFuels().stream()
                                        .collect(Collectors.groupingBy(f -> ((RefinedFuel) f.getFluid()).fePerMb()))
                                        .entrySet().stream()
                                        .sorted(Map.Entry.comparingByKey())
                                        .forEach(f -> r.addRecipes(
                                                        RefinedFuelRecipeCategory.TYPE,
                                                        List.of(new FuelRecords.Fluids(f.getValue()))));
                }
        }

        @Override
        public void registerGuiHandlers(IGuiHandlerRegistration r) {

                r.addRecipeClickArea(ParadoxMixerScreen.class, 158, -22, 16, 16,
                                ParadoxMixerCategory.TYPE);

                r.addRecipeClickArea(FerricoreAnvilScreen.class, 158, -22, 16, 16,
                                FerricoreAnvil.TYPE);

                r.addRecipeClickArea(BlazeGoldAnvilScreen.class, 158, -22, 16, 16,
                                BlazeGoldAnvil.TYPE);

                r.addRecipeClickArea(EclipseAlloyAnvilScreen.class, 158, -22, 16, 16,
                                EclipseAlloyAnvil.TYPE);

                r.addRecipeClickArea(ThermoScreen.class, 158, -22, 16, 16,
                                ThermoCoolant.TYPE);
                                
                r.addRecipeClickArea(ThermoScreen.class, 158-18, -22, 16, 16,
                                ThermoHeatSource.TYPE);

        }

}
