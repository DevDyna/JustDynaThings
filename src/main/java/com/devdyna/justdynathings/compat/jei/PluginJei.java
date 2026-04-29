package com.devdyna.justdynathings.compat.jei;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import com.devdyna.cakesticklib.api.utils.x;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.Identifier;

@JeiPlugin
public class PluginJEI implements IModPlugin {

    @Override
    public Identifier getPluginUid() {
        return x.rl(MODULE_ID,"jei_plugin");
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration r) {

        // r.addCraftingStation(QuernCategory.TYPE, x.item(zBlocks.QUERN.get()));

    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration r) {
        // var helper = r.getJeiHelpers().getGuiHelper();

        // r.addRecipeCategories(

                // new QuernCategory(helper)

        // );

    }

    @Override
    public void registerRecipes(IRecipeRegistration r) {

        // r.addRecipes(QuernCategory.TYPE,
        //         getRecipes(zRecipeTypes.QUERN.getType()));

    }

    // private <C extends RecipeInput, T extends Recipe<C>> List<RecipeHolder<T>> getRecipes(RecipeType<T> type) {
    //     return List.copyOf(Client.getRecipeCollector().byType(type));
    // }

}
