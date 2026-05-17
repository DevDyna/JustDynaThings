
package com.devdyna.justdynathings.common.recipes.paradox;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import java.util.LinkedHashMap;

import com.devdyna.cakesticklib.api.recipe.recipeBuilder.*;
import com.devdyna.cakesticklib.api.utils.x;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

public class ParadoxInfusionBuilder extends BaseRecipeBuilder
        implements ItemAttach.Input.NoItemCount<ParadoxInfusionBuilder>,
        ItemAttach.Output.SimpleOutputItem<ParadoxInfusionBuilder> {

    private Ingredient input;
    private int radius = 1;
    private ItemStackTemplate output;

    private ParadoxInfusionBuilder(HolderLookup.Provider p) {
        super(p);
        this.criteria = new LinkedHashMap<String, Criterion<?>>();
    }

    public static ParadoxInfusionBuilder of(HolderLookup.Provider p) {
        return new ParadoxInfusionBuilder(p);
    }

    public ParadoxInfusionBuilder input(Ingredient input) {
        this.input = input;
        return this;
    }

    public ParadoxInfusionBuilder radius(int radius) {
        this.radius = radius;
        return this;
    }

    public ParadoxInfusionBuilder output(ItemStackTemplate output) {
        this.output = output;
        return this;
    }

    public ParadoxInfusionBuilder unlockedBy() {
        return unlockedBy(MODULE_ID, InventoryChangeTrigger.TriggerInstance
                .hasItems(input.getValues().stream()
                        .map(Holder::getKey)
                        .map(ResourceKey::identifier)
                        .map(BuiltInRegistries.ITEM::getValue)
                        .toArray(Item[]::new)));
    }

    public ParadoxInfusionBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public Recipe<?> createRecipe() {
        return new ParadoxInfusionRecipe(input, radius, output);
    }

    @Override
    public ParadoxInfusionBuilder getBuilder() {
        return this;
    }

    @Override
    public Identifier getSuffix(String extra) {
        return x.rl(MODULE_ID, "paradox_infusion/" + input.getValues().get(0).getKey().identifier().getPath()
                + extra);
    }

}