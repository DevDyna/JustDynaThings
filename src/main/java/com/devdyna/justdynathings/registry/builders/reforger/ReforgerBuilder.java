package com.devdyna.justdynathings.registry.builders.reforger;

import static com.devdyna.justdynathings.Main.ID;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Nullable;

import com.devdyna.justdynathings.recipetypes.BlockOrTag;
import com.devdyna.justdynathings.utils.DataGenUtil;

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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("null")
public class ReforgerBuilder implements RecipeBuilder {

    private BlockOrTag input;
    private Ingredient catalyst;
    private int chanceToUse;
    private BlockOrTag output;

    private final Map<String, Criterion<?>> criteria;

    public ReforgerBuilder() {
        this.criteria = new LinkedHashMap<>();
    }

    public static ReforgerBuilder of() {
        return new ReforgerBuilder();
    }

    public ReforgerBuilder input(Block block) {
        return input(BlockOrTag.add(block));
    }

    public ReforgerBuilder input(TagKey<Block> tag) {
        return input(BlockOrTag.add(tag));
    }

    public ReforgerBuilder input(BlockOrTag i) {
        this.input = i;
        return this;
    }

    public ReforgerBuilder output(BlockOrTag o) {
        this.output = o;
        return this;
    }

    public ReforgerBuilder output(Block block) {
        return output(BlockOrTag.add(block));
    }

    public ReforgerBuilder output(TagKey<Block> tag) {
        return output(BlockOrTag.add(tag));
    }

    public ReforgerBuilder catalyst(Ingredient catalyst) {
        this.catalyst = catalyst;
        return this;
    }

    /**
     * Must be {@code X > 0 && X =< 100}
     */
    public ReforgerBuilder chance(int chance) {
        this.chanceToUse = chance;
        return this;
    }

    public ReforgerBuilder unlockedBy() {
        return unlockedBy(ID, InventoryChangeTrigger.TriggerInstance.hasItems(catalyst.getItems()[0].getItem()));
    }

    public ReforgerBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public ReforgerBuilder group(@Nullable String groupName) {
        return this;
    }

    @Override
    public Item getResult() {
        return switch (output) {
            case BlockOrTag.block block -> block.block().asItem();
            case BlockOrTag.tag tag -> Items.AIR;
        };
    }

    public void save(RecipeOutput recipeOutput, String extra) {
        save(recipeOutput,
                DataGenUtil.getResource("reforger/" + getAsString(input) + "_to_" + getAsString(output) + "_with_"
                        + DataGenUtil.getPath(catalyst.getItems()[0].getItem()) + extra));
    }

    private String getAsString(BlockOrTag type) {
        return switch (input) {
            case BlockOrTag.block b ->
                DataGenUtil.getPath(b.block());

            case BlockOrTag.tag t ->
                t.tag().location().getPath().replace("/", "_");
        };
    }

    @Override
    public void save(RecipeOutput recipeOutput) {
        save(recipeOutput, "");
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceLocation id) {

        if (criteria.isEmpty())
            throw new IllegalStateException(
                    "Missing/Null Criteria " + id);

        var builder = recipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);

        criteria.forEach(builder::addCriterion);

        recipeOutput.accept(id, new ReforgerRecipe(input, catalyst, chanceToUse, output),
                builder.build(id.withPrefix("recipes/" + RecipeCategory.MISC.getFolderName() + "/")));
    }

}
