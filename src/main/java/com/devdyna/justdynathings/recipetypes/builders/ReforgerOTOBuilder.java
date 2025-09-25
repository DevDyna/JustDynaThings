package com.devdyna.justdynathings.recipetypes.builders;

import static com.devdyna.justdynathings.Main.ID;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.recipetypes.type.ReforgerOTORecipe;
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
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("null")
public class ReforgerOTOBuilder implements RecipeBuilder {

    private BlockState inputState;
    private Ingredient catalyst;
    private int chanceToUse;
    private BlockState outputState;
    private final Map<String, Criterion<?>> criteria;

    public ReforgerOTOBuilder() {
        this.criteria = new LinkedHashMap<String, Criterion<?>>();
    }

    public static ReforgerOTOBuilder of() {
        return new ReforgerOTOBuilder();
    }

    public ReforgerOTOBuilder input(BlockState i) {
        this.inputState = i;
        return this;
    }

    public ReforgerOTOBuilder catalyst(Ingredient i) {
        this.catalyst = i;
        return this;
    }

    public ReforgerOTOBuilder chanceToUse(int i) {
        this.chanceToUse = i;
        return this;
    }

    public ReforgerOTOBuilder output(BlockState i) {
        this.outputState = i;
        return this;
    }

    public ReforgerOTOBuilder unlockedBy() {
        return unlockedBy(ID, InventoryChangeTrigger.TriggerInstance
                .hasItems(this.catalyst.getItems()[0].getItem()));
    }

    public ReforgerOTOBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    public ReforgerOTOBuilder group(@Nullable String groupName) {
        return this;
    }

    public Item getResult() {
        return this.outputState.getBlock().asItem();
    }

    public void save(RecipeOutput recipeOutput, String extra) {
        this.save(recipeOutput,
                DataGenUtil.getResource("reforger/block_to_block/" +
                        DataGenUtil.getPath(outputState.getBlock()) + "_from_"
                        + DataGenUtil.getPath(inputState.getBlock()) + "_with_"
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
        ReforgerOTORecipe shapelessrecipe = new ReforgerOTORecipe(inputState, catalyst, chanceToUse, outputState);
        pRecipeOutput.accept(pId, shapelessrecipe,
                advancement$builder.build(pId.withPrefix("recipes/" + RecipeCategory.MISC.getFolderName() + "/")));
    }
}
