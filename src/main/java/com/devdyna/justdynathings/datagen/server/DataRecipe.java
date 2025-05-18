package com.devdyna.justdynathings.datagen.server;

import static net.minecraft.data.recipes.RecipeCategory.MISC;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.registry.types.zBlockTags;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zItemTags;
import com.devdyna.justdynathings.registry.types.zItems;
import com.devdyna.justdynathings.registry.types.zMultiTags;
import com.devdyna.justdynathings.utils.DataGenUtil;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;
import com.direwolf20.justdirethings.datagen.recipes.FluidDropRecipeBuilder;
import com.direwolf20.justdirethings.datagen.recipes.GooSpreadRecipeBuilder;
import com.direwolf20.justdirethings.datagen.recipes.GooSpreadRecipeTagBuilder;
import com.direwolf20.justdirethings.setup.Registration;
import com.glodblock.github.extendedae.common.EAESingletons;

import appeng.core.definitions.AEBlocks;

import static com.devdyna.justdynathings.Main.ID;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.client.Minecraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.crafting.BlockTagIngredient;
import xyz.milosworks.phasoritenetworks.init.PNBlocks;

import static com.devdyna.justdynathings.compat.ae2.init.AE2_POWERED;
import static com.devdyna.justdynathings.compat.extendedae.init.EXTENDED_POWERED;
import static com.devdyna.justdynathings.compat.phasorite.init.PHASORITE_POWERED;

@SuppressWarnings({ "null", "unused" })
public class DataRecipe extends RecipeProvider {

        public DataRecipe(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
                super(output, completableFuture);
        }

        @Override
        protected void buildRecipes(RecipeOutput c) {

                ShapedRecipeBuilder.shaped(MISC, zBlocks.FERRICORE_CLOCK.get(), 1)
                                .pattern("ABA")
                                .pattern("BCB")
                                .pattern("ABA")
                                .define('A', Registration.FerricoreIngot.get())
                                .define('B', Tags.Items.DUSTS_REDSTONE)
                                .define('C', zMultiTags.COPPER_BULBS.item())
                                .unlockedBy(ID, InventoryChangeTrigger.TriggerInstance
                                                .hasItems(Registration.FerricoreIngot.get()))
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
                                                .hasItems(Registration.TimeCrystal.get(),
                                                                Registration.EclipseAlloyIngot.get()))
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
                                Blocks.DIRT.defaultBlockState(), 1, 200)
                                .unlockedBy(ID, itemInv(Blocks.COARSE_DIRT.asItem())).group(ID).save(c);

                GooSpreadRecipeBuilder.shapeless(DataGenUtil.getResource("clay"),
                                Blocks.MUD.defaultBlockState(),
                                Blocks.CLAY.defaultBlockState(), 1, 200)
                                .unlockedBy(ID, itemInv(Blocks.MUD.asItem())).group(ID).save(c);

                GooSpreadRecipeBuilder.shapeless(DataGenUtil.getResource("crying_obsidian"),
                                Blocks.OBSIDIAN.defaultBlockState(),
                                Blocks.CRYING_OBSIDIAN.defaultBlockState(), 3, 200)
                                .unlockedBy(ID, itemInv(Blocks.OBSIDIAN.asItem())).group(ID)
                                .save(c);

                Budding(zBlocks.BUDDING_AMETHYST.get().asItem(), zMultiTags.AMETHYST_BLOCKS.item(), c);
                Budding(zBlocks.BUDDING_TIME.get().asItem(), zItemTags.TIME_BUDDING, c);
                Budding(AE2_POWERED.get().asItem(), zItemTags.AE2_COMPAT, c
                                .withConditions(DataGenUtil.isModLoaded("ae2")));
                Budding(EXTENDED_POWERED.get().asItem(), zItemTags.EXT_COMPAT, c
                                .withConditions(DataGenUtil.isModLoaded("extendedae")));
                Budding(PHASORITE_POWERED.get().asItem(), zItemTags.PHA_COMPAT, c
                                .withConditions(DataGenUtil.isModLoaded("phasoritenetworks")));

                ShapedRecipeBuilder.shaped(MISC, zBlocks.BLACKHOLE.get(), 1)
                                .pattern("FBF")
                                .pattern("RKR")
                                .pattern("FBF")
                                .define('F', Registration.FerricoreIngot.get())
                                .define('K', Items.REDSTONE_BLOCK)
                                .define('R', Items.REDSTONE)
                                .define('B', Items.BUCKET)
                                .unlockedBy(ID, itemInv(Registration.FerricoreIngot.get())).group(ID).save(c);

                ShapedRecipeBuilder.shaped(MISC, zBlocks.THERMOGEN.get(), 1)
                                .pattern(" A ")
                                .pattern("RBR")
                                .pattern("AAA")
                                .define('A', Registration.EclipseAlloyIngot.get())
                                .define('R', Items.REDSTONE)
                                .define('B', Registration.BlazegoldIngot.get())
                                .unlockedBy(ID, itemInv(Registration.EclipseAlloyIngot.get())).group(ID).save(c);

                // ShapedRecipeBuilder.shaped(MISC, zBlocks.SOLARGEN.get(), 2) // TODO recipes
                //                 .pattern("LLL")
                //                 .pattern("FCF")
                //                 .define('L', Items.LAPIS_LAZULI)
                //                 .define('F', Registration.FerricoreIngot.get())
                //                 .define('C', Registration.Coal_T1.get())
                //                 .unlockedBy(ID, itemInv(Registration.Coal_T1.get(), Registration.FerricoreIngot.get()))
                //                 .group(ID).save(c);

                ShapedRecipeBuilder.shaped(MISC, zBlocks.CREATIVE_GOO.get(), 2)
                                .pattern("ABA")
                                .pattern("BCB")
                                .pattern("ABA")
                                .define('A', Registration.TimeCrystal.get())
                                .define('B', Registration.EclipseAlloyIngot.get())
                                .define('C', Items.NETHER_STAR)
                                .unlockedBy(ID, itemInv(Items.NETHER_STAR, Registration.TimeCrystal.get(),
                                                Registration.EclipseAlloyIngot.get()))
                                .group(ID).save(c);

                ShapedRecipeBuilder.shaped(MISC, zBlocks.ENERGIZED_GOO.get(), 1)
                                .pattern("DAD")
                                .pattern("BCB")
                                .pattern("DAD")
                                .define('A', Registration.TimeCrystal.get())
                                .define('B', Registration.EclipseAlloyIngot.get())
                                .define('C', Registration.GooBlock_Tier4_ITEM.get())
                                .define('D', Items.REDSTONE_BLOCK)
                                .unlockedBy(ID, itemInv(Registration.GooBlock_Tier4_ITEM.get())).group(ID).save(c);

                GooConversion(zMultiTags.T2_SPREAD.block(), Registration.GooBlock_Tier2.get(), c);
                GooConversion(zMultiTags.T3_SPREAD.block(), Registration.GooBlock_Tier3.get(), c);
                GooConversion(zMultiTags.T4_SPREAD.block(), Registration.GooBlock_Tier4.get(), c);

                shapeless(zBlocks.T1_GOO.get().asItem(), c,
                                Registration.GooBlock_Tier1_ITEM.get(),
                                Registration.Coal_T1.get(),
                                Registration.RawFerricore.get(),
                                Registration.TotemOfDeathRecall.get());

                shapeless(zBlocks.T2_GOO.get().asItem(), c,
                                Registration.GooBlock_Tier2_ITEM.get(),
                                Registration.Coal_T2.get(),
                                Registration.RawBlazegold.get(),
                                Registration.TotemOfDeathRecall.get());

                shapeless(zBlocks.T3_GOO.get().asItem(), c,
                                Registration.GooBlock_Tier3_ITEM.get(),
                                Registration.Coal_T3.get(),
                                Registration.Celestigem.get(),
                                Registration.TotemOfDeathRecall.get());

                shapeless(zBlocks.T4_GOO.get().asItem(), c,
                                Registration.GooBlock_Tier4_ITEM.get(),
                                Registration.Coal_T4.get(),
                                Registration.RawEclipseAlloy.get(),
                                Registration.TotemOfDeathRecall.get());

                AnvilRecipe(zBlocks.METALLIC_ANVIL.get(), Registration.FerricoreIngot.get(),
                                Registration.FerricoreBlock_ITEM.get(), Registration.TEMPLATE_FERRICORE.get(),
                                zMultiTags.ANVILS.item(), c);

                AnvilRecipe(zBlocks.MAGMATIC_ANVIL.get(), Registration.BlazegoldIngot.get(),
                                Registration.BlazeGoldBlock_ITEM.get(), Registration.TEMPLATE_BLAZEGOLD.get(),
                                zBlocks.METALLIC_ANVIL.get(), c);

                AnvilRecipe(zBlocks.POWERED_ANVIL.get(), Registration.Celestigem.get(),
                                Registration.CelestigemBlock_ITEM.get(), Registration.TEMPLATE_CELESTIGEM.get(),
                                zBlocks.MAGMATIC_ANVIL.get(), c);

                AnvilRecipe(zBlocks.TIME_ANVIL.get(), Registration.EclipseAlloyIngot.get(),
                                Registration.EclipseAlloyBlock_ITEM.get(), Registration.TEMPLATE_ECLIPSEALLOY.get(),
                                zBlocks.POWERED_ANVIL.get(), c);

                // FluidDropRecipeBuilder.shapeless(DataGenUtil.getResource(zBlocks.REDSTONE_JUICE_FLUID.get()),
                // Registration.REFINED_T2_FLUID_BLOCK.get().defaultBlockState(),
                // zBlocks.REDSTONE_JUICE_FLUID.get().defaultBlockState(),
                // Items.REDSTONE).unlockedBy(ID, itemInv(Items.REDSTONE)).group(ID)
                // .save(c);

        }

        /**
         * @return inventory change criteria trigger
         */
        private Criterion<?> itemInv(Item... i) {
                return InventoryChangeTrigger.TriggerInstance.hasItems(i);
        }

        private void blasting(Item input, Item output, float xp, int ticks) {
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), MISC,
                                output, xp, ticks);
                SimpleCookingRecipeBuilder.blasting(Ingredient.of(input), MISC,
                                output, xp, ticks / 2);
        }

        private void blasting(Item input, Item output, float xp) {
                blasting(input, output, xp, 200);
        }

        private void smoking(Item input, Item output, float xp, int ticks) {
                SimpleCookingRecipeBuilder.smoking(Ingredient.of(input), MISC,
                                output, xp, ticks / 2);
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(input), MISC,
                                output, xp, ticks);
        }

        private void smoking(Item input, Item output, float xp) {
                smoking(input, output, xp, 200);
        }

        private void Budding(Item output, TagKey<Item> input, RecipeOutput c) {
                ShapedRecipeBuilder.shaped(MISC, output, 2)
                                .pattern("AAA")
                                .pattern("ABA")
                                .pattern("AAA")
                                .define('B', input)
                                .define('A', Items.ECHO_SHARD)
                                .unlockedBy(ID, itemInv(Items.ECHO_SHARD)).group(ID)
                                .save(c);
        }

        private void Budding(Item output, Item input, RecipeOutput c) {
                ShapedRecipeBuilder.shaped(MISC, output, 2)
                                .pattern("AAA")
                                .pattern("ABA")
                                .pattern("AAA")
                                .define('B', input)
                                .define('A', Items.ECHO_SHARD)
                                .unlockedBy(ID, itemInv(Items.ECHO_SHARD)).group(ID)
                                .save(c);

        }

        private void GooConversion(TagKey<Block> input, Block goo, RecipeOutput c) {
                int tier = Integer.parseInt(DataGenUtil.getName(goo).replace("gooblock_tier", ""));
                GooSpreadRecipeTagBuilder.shapeless(DataGenUtil.getResource(goo),
                                new BlockTagIngredient(input), goo.defaultBlockState(), tier, 100 * tier)
                                .unlockedBy(ID, itemInv(goo.asItem())).group(ID)
                                .save(c);
        }

        private void shapeless(Item output, RecipeOutput c, Item... items) {
                var recipe = ShapelessRecipeBuilder.shapeless(MISC, output);
                for (Item item : items)
                        recipe.requires(item);
                recipe.unlockedBy(ID, itemInv(items)).group(ID).save(c);
        }

        private void AnvilRecipe(Block b, Item ingot, Item block, Item template, Block oldAnvil, RecipeOutput c) {
                ShapedRecipeBuilder.shaped(MISC, b, 1)
                                .pattern(" I ")
                                .pattern("IAI")
                                .pattern(" B ")
                                .define('I', ingot)
                                .define('B', block)
                                .define('A', zMultiTags.ANVILS.item())
                                .unlockedBy(ID, InventoryChangeTrigger.TriggerInstance
                                                .hasItems(ingot))
                                .group(ID).save(c);

                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(oldAnvil.asItem()),
                                Ingredient.of(block),
                                MISC, b.asItem()).unlocks(ID,
                                                InventoryChangeTrigger.TriggerInstance
                                                                .hasItems(ingot))
                                .save(c, DataGenUtil.getPath(b));
        }

        private void AnvilRecipe(Block b, Item ingot, Item block, Item template, TagKey<Item> oldAnvil,
                        RecipeOutput c) {
                ShapedRecipeBuilder.shaped(MISC, b, 1)
                                .pattern(" I ")
                                .pattern("IAI")
                                .pattern(" B ")
                                .define('I', ingot)
                                .define('B', block)
                                .define('A', zMultiTags.ANVILS.item())
                                .unlockedBy(ID, InventoryChangeTrigger.TriggerInstance
                                                .hasItems(ingot))
                                .group(ID).save(c);

                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(oldAnvil),
                                Ingredient.of(block),
                                MISC, b.asItem()).unlocks(ID,
                                                InventoryChangeTrigger.TriggerInstance
                                                                .hasItems(ingot))
                                .save(c, DataGenUtil.getPath(b));
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
         * GooSpreadRecipeTagBuilder.shapeless(null, null, null, 0, 0)
         */
}