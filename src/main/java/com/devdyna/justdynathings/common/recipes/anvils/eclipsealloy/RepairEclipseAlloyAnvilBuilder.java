
package com.devdyna.justdynathings.common.recipes.anvils.eclipsealloy;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import java.util.LinkedHashMap;

import com.devdyna.cakesticklib.api.recipe.recipeBuilder.*;
import com.devdyna.cakesticklib.api.utils.x;
import com.devdyna.justdynathings.Constants;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;

public class RepairEclipseAlloyAnvilBuilder extends BaseRecipeBuilder
        implements FluidAttach.Input.SizedFluid<RepairEclipseAlloyAnvilBuilder> {

    private SizedFluidIngredient input;
    private int durability;

    private RepairEclipseAlloyAnvilBuilder() {
        this.criteria = new LinkedHashMap<String, Criterion<?>>();
    }

    public static RepairEclipseAlloyAnvilBuilder of() {
        return new RepairEclipseAlloyAnvilBuilder();
    }

    @Override
    public RepairEclipseAlloyAnvilBuilder fluid(SizedFluidIngredient input) {
        this.input = input;
        return this;
    }

    public RepairEclipseAlloyAnvilBuilder durability(int durability) {
        this.durability = durability;
        return this;
    }

    public RepairEclipseAlloyAnvilBuilder unlockedBy() {
        return unlockedBy(MODULE_ID, InventoryChangeTrigger.TriggerInstance
                .hasItems(input.ingredient().fluids().stream()
                        .map(Holder::getKey)
                        .map(ResourceKey::identifier)
                        .map(BuiltInRegistries.ITEM::getValue)
                        .toArray(Item[]::new)));
    }

    public RepairEclipseAlloyAnvilBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public Recipe<?> createRecipe() {
        return new RepairEclipseAlloyAnvilRecipe(input, durability);
    }

    @Override
    public RepairEclipseAlloyAnvilBuilder getBuilder() {
        return this;
    }

    @Override
    public Identifier getSuffix(String extra) {
        return x.rl(MODULE_ID,
                Constants.Anvils.t4 + "/" + input.ingredient().fluids().get(0).getKey().identifier().getPath()
                        + extra);
    }

}