
package com.devdyna.justdynathings.common.recipes.anvils.ferricore;

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
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

public class RepairFerricoreAnvilBuilder extends BaseRecipeBuilder
        implements ItemAttach.Input.NoItemCount<RepairFerricoreAnvilBuilder> {

    private Ingredient input;
    private int durability;

    private RepairFerricoreAnvilBuilder() {
        this.criteria = new LinkedHashMap<String, Criterion<?>>();
    }

    public static RepairFerricoreAnvilBuilder of() {
        return new RepairFerricoreAnvilBuilder();
    }

    public RepairFerricoreAnvilBuilder input(Ingredient input) {
        this.input = input;
        return this;
    }

    public RepairFerricoreAnvilBuilder durability(int durability) {
        this.durability = durability;
        return this;
    }

    public RepairFerricoreAnvilBuilder unlockedBy() {
        return unlockedBy(MODULE_ID, InventoryChangeTrigger.TriggerInstance
                .hasItems(input.getValues().stream()
                        .map(Holder::getKey)
                        .map(ResourceKey::identifier)
                        .map(BuiltInRegistries.ITEM::getValue)
                        .toArray(Item[]::new)));
    }

    public RepairFerricoreAnvilBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public Recipe<?> createRecipe() {
        return new RepairFerricoreAnvilRecipe(input, durability);
    }

    @Override
    public RepairFerricoreAnvilBuilder getBuilder() {
        return this;
    }

    @Override
    public Identifier getSuffix(String extra) {
        return x.rl(MODULE_ID, Constants.Anvils.t1 + "/" + input.getValues().get(0).getKey().identifier().getPath()
                + extra);
    }

}