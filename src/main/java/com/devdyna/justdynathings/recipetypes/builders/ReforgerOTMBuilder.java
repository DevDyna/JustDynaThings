package com.devdyna.justdynathings.recipetypes.builders;

import static com.devdyna.justdynathings.Main.ID;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.recipetypes.type.ReforgerOTMRecipe;
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
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.crafting.BlockTagIngredient;

@SuppressWarnings("null")
public class ReforgerOTMBuilder implements RecipeBuilder {

    private BlockState inputState;
    private Ingredient catalyst;
    private int chanceToUse;
    private BlockTagIngredient outputState;
    private final Map<String, Criterion<?>> criteria;

    public ReforgerOTMBuilder() {
        this.criteria = new LinkedHashMap<String, Criterion<?>>();
    }

    public static ReforgerOTMBuilder of() {
        return new ReforgerOTMBuilder();
    }

    public ReforgerOTMBuilder input(BlockState i) {
        this.inputState = i;
        return this;
    }

    public ReforgerOTMBuilder catalyst(Ingredient i) {
        this.catalyst = i;
        return this;
    }

    public ReforgerOTMBuilder chanceToUse(int i) {
        this.chanceToUse = i;
        return this;
    }

    public ReforgerOTMBuilder output(BlockTagIngredient i) {
        this.outputState = i;
        return this;
    }

    public ReforgerOTMBuilder output(TagKey<Block> t) {
        return output(new BlockTagIngredient(t));
    }

    public ReforgerOTMBuilder unlockedBy() {
        return unlockedBy(ID, InventoryChangeTrigger.TriggerInstance
                .hasItems(this.catalyst.getItems()[0].getItem()));
    }

    public ReforgerOTMBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    public ReforgerOTMBuilder group(@Nullable String groupName) {
        return this;
    }

    public Item getResult() {
        return this.outputState.getItems().toList().get(0).getItem();
    }

    public void save(RecipeOutput recipeOutput, String extra) {
        this.save(recipeOutput,
                DataGenUtil.getResource("reforger/block_to_tag/" +
                        outputState.getTag().location().getPath() + "_from_"
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
        ReforgerOTMRecipe shapelessrecipe = new ReforgerOTMRecipe(inputState, catalyst, chanceToUse, outputState);
        pRecipeOutput.accept(pId, shapelessrecipe,
                advancement$builder.build(pId.withPrefix("recipes/" + RecipeCategory.MISC.getFolderName() + "/")));
    }
}
