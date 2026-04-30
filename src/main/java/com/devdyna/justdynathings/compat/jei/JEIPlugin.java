package com.devdyna.justdynathings.compat.jei;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import java.util.*;
import java.util.stream.Collectors;

import com.devdyna.cakesticklib.api.utils.x;
import com.devdyna.justdynathings.Config;
import com.devdyna.justdynathings.compat.jei.categories.*;
import com.devdyna.justdynathings.compat.jei.utils.FuelRecords;
import com.devdyna.justdynathings.compat.jei.utils.FuelUtils;
import com.devdyna.justdynathings.init.types.zBlocks;
import com.direwolf20.justdirethings.client.jei.GooSpreadRecipeCategory;
import com.direwolf20.justdirethings.common.blocks.resources.CoalBlock_T1;
import com.direwolf20.justdirethings.common.fluids.basefluids.RefinedFuel;
import com.direwolf20.justdirethings.common.items.resources.Coal_T1;
import com.direwolf20.justdirethings.setup.JDTRegistration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("null")
@JeiPlugin
public class JEIPlugin implements IModPlugin {

        @Override
        public Identifier getPluginUid() {
                return x.rl(MODULE_ID, "jei_plugin");
        }

        @Override
        public void registerRecipeCatalysts(IRecipeCatalystRegistration r) {

                List<Block> gooBlocks = List.of(
                                zBlocks.CREATIVE_GOO.get(),
                                zBlocks.T1_GOO.get(),
                                zBlocks.T2_GOO.get(),
                                zBlocks.T3_GOO.get(),
                                zBlocks.T4_GOO.get());

                gooBlocks.forEach(b -> r.addCraftingStation(GooSpreadRecipeCategory.TYPE, b.asItem()));

                r.addCraftingStation(FuelRecipeCategory.TYPE, JDTRegistration.GeneratorT1_ITEM.get());
                r.addCraftingStation(RefinedFuelRecipeCategory.TYPE, JDTRegistration.GeneratorFluidT1_ITEM.get());

        }

        @Override
        public void registerCategories(IRecipeCategoryRegistration r) {
                IGuiHelper h = r.getJeiHelpers().getGuiHelper();

                r.addRecipeCategories(new FuelRecipeCategory(h));
                r.addRecipeCategories(new RefinedFuelRecipeCategory(h));
        }

        @Override
        public void registerRecipes(IRecipeRegistration r) {

                Map<Integer, List<ItemStack>> fuels = new HashMap<>();

                // Process fuels
                for (ItemStack stack : FuelUtils.getAllSolidFuels()) {
                        int burnTime = stack.getBurnTime(null, Minecraft.getInstance().level.fuelValues());

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
                if (Config.ENABLE_ALL_JEI_FUELS.get()) {
                        fuels.entrySet().stream()
                                        .sorted(Map.Entry.<Integer, List<ItemStack>>comparingByKey().reversed())
                                        .forEach(entry -> r.addRecipes(FuelRecipeCategory.TYPE,
                                                        List.of(new FuelRecords.Items(entry.getValue()))));
                }

                FuelUtils.getAllRefinedFuels().stream()
                                .collect(Collectors.groupingBy(f -> ((RefinedFuel) f.getFluid()).fePerMb()))
                                .entrySet().stream()
                                .sorted(Map.Entry.comparingByKey())
                                .forEach(f -> r.addRecipes(
                                                RefinedFuelRecipeCategory.TYPE,
                                                List.of(new FuelRecords.Fluids(f.getValue()))));

        }

        @Override
        public void registerGuiHandlers(IGuiHandlerRegistration r) {
                // r.addRecipeClickArea(ParadoxMixerScreen.class, 28, -8, 48, 48,
                // ParadoxMixerCategory.TYPE);
        }

        // private <C extends RecipeInput, T extends Recipe<C>> List<RecipeHolder<T>> getRecipes(RecipeType<T> type) {
        //         return List.copyOf(Client.getRecipeCollector().byType(type));
        // }

}
