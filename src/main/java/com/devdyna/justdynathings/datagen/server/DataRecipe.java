package com.devdyna.justdynathings.datagen.server;

import static net.minecraft.data.recipes.RecipeCategory.MISC;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zItemTags;
import com.devdyna.justdynathings.registry.types.zItems;
import com.devdyna.justdynathings.utils.DataGenUtil;
import com.direwolf20.justdirethings.datagen.recipes.GooSpreadRecipeBuilder;
import com.direwolf20.justdirethings.setup.Registration;

import static com.devdyna.justdynathings.Main.ID;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;

@SuppressWarnings({ "null", "unused" })
public class DataRecipe extends RecipeProvider {

        public DataRecipe(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
                super(output, completableFuture);
        }

        @Override
        protected void buildRecipes(RecipeOutput c) {

                ShapedRecipeBuilder.shaped(MISC, zBlocks.FERRITECORE_CLOCK.get(), 1)
                                .pattern("ABA")
                                .pattern("BCB")
                                .pattern("ABA")
                                .define('A', Registration.FerricoreIngot.get())
                                .define('B', Tags.Items.DUSTS_REDSTONE)
                                .define('C', zItemTags.COPPER_BULBS)
                                .unlockedBy(ID, InventoryChangeTrigger.TriggerInstance
                                                .hasItems(Registration.FerricoreIngot.get()))
                                .group(ID).save(c);

                ShapedRecipeBuilder.shaped(MISC, zBlocks.BLAZING_ANVIL.get(), 1)
                                .pattern("BCB")
                                .pattern("BDB")
                                .pattern("BAB")
                                .define('A', Registration.BlazeGoldBlock.get())
                                .define('B', Registration.BlazegoldIngot.get())
                                .define('C', Items.MAGMA_BLOCK)
                                .define('D', zItemTags.ANVILS)
                                .unlockedBy(ID, InventoryChangeTrigger.TriggerInstance
                                                .hasItems(Registration.BlazegoldIngot.get()))
                                .group(ID).save(c);

                ShapedRecipeBuilder.shaped(MISC, zBlocks.REFORGER.get(), 1)
                                .pattern("ADA")
                                .pattern("BEB")
                                .pattern("ACA")
                                .define('A', Registration.FerricoreIngot.get())
                                .define('B', Tags.Items.GEMS_LAPIS)
                                .define('C', Tags.Items.DUSTS_REDSTONE)
                                .define('D', Tags.Items.GEMS_AMETHYST)
                                .define('E', Registration.Celestigem.get())
                                .unlockedBy(ID, InventoryChangeTrigger.TriggerInstance
                                                .hasItems(Registration.Celestigem.get()))
                                .group(ID).save(c);

                ShapedRecipeBuilder.shaped(MISC, zBlocks.REVITALIZER.get(), 1)
                                .pattern("CDC")
                                .pattern("BAB")
                                .pattern("CBC")
                                .define('A', Registration.BlockSwapperT1.get())
                                .define('B', Tags.Items.DUSTS_REDSTONE)
                                .define('C', Registration.EclipseAlloyIngot.get())
                                .define('D', Registration.TimeCrystal.get())
                                .unlockedBy(ID, InventoryChangeTrigger.TriggerInstance
                                                .hasItems(Registration.TimeCrystal.get()))
                                .group(ID).save(c);

                ShapelessRecipeBuilder.shapeless(MISC, zBlocks.PHASEBOX.get(), 4)
                                .requires(Registration.Celestigem.get())
                                .requires(Tags.Items.GLASS_BLOCKS_TINTED)
                                .requires(Tags.Items.GEMS_LAPIS)
                                .unlockedBy(ID, InventoryChangeTrigger.TriggerInstance
                                                .hasItems(Registration.Celestigem.get()))
                                .group(ID).save(c);

                GooSpreadRecipeBuilder.shapeless(DataGenUtil.getResource("dirt"),
                                Blocks.COARSE_DIRT.defaultBlockState(),
                                Blocks.DIRT.defaultBlockState(), 1, 200).save(c);

                GooSpreadRecipeBuilder.shapeless(DataGenUtil.getResource("clay"),
                                Blocks.MUD.defaultBlockState(),
                                Blocks.CLAY.defaultBlockState(), 1, 200).save(c);

                GooSpreadRecipeBuilder.shapeless(DataGenUtil.getResource("crying_obsidian"),
                                Blocks.OBSIDIAN.defaultBlockState(),
                                Blocks.CRYING_OBSIDIAN.defaultBlockState(), 3, 200).save(c);

                ShapedRecipeBuilder.shaped(MISC, zBlocks.BUDDING_AMETHYST.get(), 1)
                                .pattern("AAA")
                                .pattern("ABA")
                                .pattern("AAA")
                                .define('B', Blocks.AMETHYST_BLOCK.asItem())
                                .define('A', Items.ECHO_SHARD)
                                .unlockedBy(ID, itemInv(Items.ECHO_SHARD)).group(ID).save(c);

                ShapedRecipeBuilder.shaped(MISC, zBlocks.BUDDING_TIME.get(), 1)
                                .pattern("AAA")
                                .pattern("ABA")
                                .pattern("AAA")
                                .define('B', Registration.TimeCrystalBlock_ITEM.get())
                                .define('A', Items.ECHO_SHARD)
                                .unlockedBy(ID, itemInv(Items.ECHO_SHARD)).group(ID).save(c);

                GooSpreadRecipeBuilder.shapeless(DataGenUtil.getResource("chaotic"),
                                Blocks.AMETHYST_BLOCK.defaultBlockState(),
                                zBlocks.RAW_CHAOTIC.get().defaultBlockState(), 5, 4000).save(c);

                GooSpreadRecipeBuilder.shapeless(DataGenUtil.getResource("redstonic"),
                                Blocks.REDSTONE_BLOCK.defaultBlockState(),
                                zBlocks.RAW_REDSTONIC.get().defaultBlockState(), 5, 4000).save(c);

                Set<Block> copperBlocks = Set.of(Blocks.COPPER_BLOCK, Blocks.WEATHERED_COPPER, Blocks.EXPOSED_COPPER,
                                Blocks.OXIDIZED_COPPER, Blocks.WAXED_COPPER_BLOCK, Blocks.WAXED_WEATHERED_COPPER,
                                Blocks.WAXED_EXPOSED_COPPER, Blocks.WAXED_OXIDIZED_COPPER);

                copperBlocks.forEach(copper -> GooSpreadRecipeBuilder
                                .shapeless(DataGenUtil.getResource("coprinium" + copper.getName()),
                                                copper.defaultBlockState(),
                                                zBlocks.RAW_COPRINIUM.get().defaultBlockState(), 5, 4000)
                                .save(c));

                blasting(zItems.RAW_COPRINIUM.get(), zItems.COPRINIUM_INGOT.get(), 0.1F);


        }

        /**
         * @return inventory change criteria trigger
         */
        private Criterion<?> itemInv(Item i) {
                return InventoryChangeTrigger.TriggerInstance.hasItems(i);
        }

        private void blasting(Item input, Item output, float xp, int ticks) {
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), MISC,
                                output, xp, ticks);
                SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), MISC,
                                output, xp, ticks / 2);
        }

        private void blasting(Item input, Item output, float xp){
                blasting(input, output, xp,200);
        }

        private void smoking(Item input, Item output, float xp, int ticks) {
                SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), MISC,
                                output, xp, ticks / 2);
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), MISC,
                                output, xp, ticks);
        }

        private void smoking(Item input, Item output, float xp){
                smoking(input, output, xp,200);
        }

        /*
         * //crafting
         * ShapedRecipeBuilder.shaped(MISC, null, 0)
         * ShapelessRecipeBuilder.shapeless(MISC, null, 0)
         * //cooking
         * SimpleCookingRecipeBuilder.smelting(null, null, null, 0, 0)
         * SimpleCookingRecipeBuilder.campfireCooking(null, null, null, 0, 0)
         * SimpleCookingRecipeBuilder.smoking(null, null, null, 0, 0)
         * SimpleCookingRecipeBuilder.blasting(null, null, null, 0, 0)
         * //stonecutting
         * SingleItemRecipeBuilder.stonecutting(null, null, null);
         * //smithing
         * SmithingTransformRecipeBuilder.smithing(null, null, null, null, null)
         * //JDT
         * FluidDropRecipeBuilder.shapeless(null, null, null, null);
         * GooSpreadRecipeBuilder.shapeless(null, null, null, 0, 0)
         */
}