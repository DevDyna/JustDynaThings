package com.devdyna.justdynathings.client.jei;

import static com.devdyna.justdynathings.Main.ID;

import java.util.ArrayList;
import java.util.List;

import com.devdyna.justdynathings.datagen.server.DataRecipe;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.direwolf20.justdirethings.client.jei.GooSpreadRecipeCategory;
import com.direwolf20.justdirethings.client.jei.GooSpreadRecipeTagCategory;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
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
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {

        List<RecipeType<? extends CraftingRecipe>> recipeTypes = List.of(GooSpreadRecipeCategory.TYPE,
                GooSpreadRecipeTagCategory.TYPE);

        List<Block> gooBlocks = List.of(
                zBlocks.CREATIVE_GOO.get(),
                zBlocks.ENERGIZED_GOO.get(),
                zBlocks.T1_GOO.get(),
                zBlocks.T2_GOO.get(),
                zBlocks.T3_GOO.get(),
                zBlocks.T4_GOO.get());

        gooBlocks.forEach(b -> recipeTypes.forEach(r -> registration.addRecipeCatalyst(new ItemStack(b), r)));
    }
}
