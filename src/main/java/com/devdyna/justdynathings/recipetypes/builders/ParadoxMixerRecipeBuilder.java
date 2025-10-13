package com.devdyna.justdynathings.recipetypes.builders;

import static com.devdyna.justdynathings.Main.ID;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.recipetypes.type.ParadoxMixerRecipe;
import com.devdyna.justdynathings.utils.DataGenUtil;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.FluidStack;

@SuppressWarnings("null")
public class ParadoxMixerRecipeBuilder implements RecipeBuilder {

    private FluidStack input;
    private Ingredient catalyst;
    private FluidStack output;
    private final Map<String, Criterion<?>> criteria;

    public ParadoxMixerRecipeBuilder() {
        this.criteria = new LinkedHashMap<String, Criterion<?>>();
    }

    public static ParadoxMixerRecipeBuilder of() {
        return new ParadoxMixerRecipeBuilder();
    }

    public ParadoxMixerRecipeBuilder input(FluidStack i) {
        this.input = i;
        return this;
    }

    public ParadoxMixerRecipeBuilder catalyst(Ingredient i) {
        this.catalyst = i;
        return this;
    }


    public ParadoxMixerRecipeBuilder output(FluidStack i) {
        this.output = i;
        return this;
    }

    public ParadoxMixerRecipeBuilder unlockedBy() {
        return unlockedBy(ID, InventoryChangeTrigger.TriggerInstance
                .hasItems(this.catalyst.getItems()[0].getItem()));
    }

    public ParadoxMixerRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    public ParadoxMixerRecipeBuilder group(@Nullable String groupName) {
        return this;
    }

    public Item getResult() {
        return null;
    }

    public void save(RecipeOutput recipeOutput, String extra) {
        this.save(recipeOutput,
                DataGenUtil.getResource("fluidtank/" +
                        DataGenUtil.getPath(output.getFluid()) + "_from_"
                        + DataGenUtil.getPath(input.getFluid()) + "_with_"
                        + DataGenUtil.getPath(catalyst.getItems()[0].getItem())
                        + extra));
    }

    @Override
    public void save(RecipeOutput recipeOutput) {
        save(recipeOutput, "");
    }

    public void save(RecipeOutput pRecipeOutput, ResourceLocation pId) {
        if (this.criteria.isEmpty())
            throw new IllegalStateException("Missing/Null Criteria " + String.valueOf(pId));
        Advancement.Builder advancement$builder = pRecipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(pId))
                .rewards(AdvancementRewards.Builder.recipe(pId))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement$builder::addCriterion);
        ParadoxMixerRecipe shapelessrecipe = new ParadoxMixerRecipe(input, catalyst, output);
        pRecipeOutput.accept(pId, shapelessrecipe,
                advancement$builder.build(pId.withPrefix("recipes/" + RecipeCategory.MISC.getFolderName() + "/")));
    }
}
