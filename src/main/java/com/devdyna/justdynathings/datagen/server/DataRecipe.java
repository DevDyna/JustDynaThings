package com.devdyna.justdynathings.datagen.server;

import static net.minecraft.data.recipes.RecipeCategory.MISC;

import java.util.concurrent.CompletableFuture;
import static net.minecraft.world.item.Items.*;

import com.devdyna.justdynathings.registry.types.Blocks;
import com.devdyna.justdynathings.registry.types.ItemTags;
import com.direwolf20.justdirethings.datagen.recipes.GooSpreadRecipeBuilder;
import com.direwolf20.justdirethings.setup.Registration;

import static com.devdyna.justdynathings.Main.ID;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.Tags;

@SuppressWarnings("null")
public class DataRecipe extends RecipeProvider {

        public DataRecipe(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
                super(output, completableFuture);
        }

        @Override
        protected void buildRecipes(RecipeOutput c) {

                ShapedRecipeBuilder.shaped(MISC, Blocks.FERRITECORE_CLOCK.get(), 1)
                                .pattern("ABA")
                                .pattern("BCB")
                                .pattern("ABA")
                                .define('A', Registration.FerricoreIngot.get())
                                .define('B', Tags.Items.DUSTS_REDSTONE)
                                .define('C', ItemTags.COPPER_BULBS)
                                .unlockedBy(ID, InventoryChangeTrigger.TriggerInstance
                                                .hasItems(Registration.FerricoreIngot.get()))
                                .group(ID).save(c);

                ShapedRecipeBuilder.shaped(MISC, Blocks.BLAZING_ANVIL.get(), 1)
                                .pattern("ADA")
                                .pattern("BEB")
                                .pattern("ACA")
                                .define('A', Registration.BlazeGoldBlock.get())
                                .define('B', Registration.BlazegoldIngot.get())
                                .define('C', MAGMA_BLOCK)
                                .define('D', ItemTags.ANVILS)
                                .define('E', Registration.GooBlock_Tier2.get())
                                .unlockedBy(ID, InventoryChangeTrigger.TriggerInstance
                                                .hasItems(Registration.BlazegoldIngot.get()))
                                .group(ID).save(c);

                ShapedRecipeBuilder.shaped(MISC, Blocks.REFORGER.get(), 1)
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

                ShapedRecipeBuilder.shaped(MISC, Blocks.REVITALIZER.get(), 1)
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

                ShapelessRecipeBuilder.shapeless(MISC, Blocks.PHASEBOX.get(), 4)
                                .requires(Registration.Celestigem.get())
                                .requires(Tags.Items.GLASS_BLOCKS_TINTED)
                                .requires(Tags.Items.GEMS_LAPIS)
                                .unlockedBy(ID, InventoryChangeTrigger.TriggerInstance
                                                .hasItems(Registration.Celestigem.get()))
                                .group(ID).save(c);

                GooSpreadRecipeBuilder.shapeless(direRecipeID("dirt"),
                                net.minecraft.world.level.block.Blocks.COARSE_DIRT.defaultBlockState(),
                                net.minecraft.world.level.block.Blocks.DIRT.defaultBlockState(), 1, 200);

                GooSpreadRecipeBuilder.shapeless(direRecipeID("clay"),
                                net.minecraft.world.level.block.Blocks.MUD.defaultBlockState(),
                                net.minecraft.world.level.block.Blocks.CLAY.defaultBlockState(), 1, 200);

                GooSpreadRecipeBuilder.shapeless(direRecipeID("crying_obsidian"),
                                net.minecraft.world.level.block.Blocks.OBSIDIAN.defaultBlockState(),
                                net.minecraft.world.level.block.Blocks.CRYING_OBSIDIAN.defaultBlockState(), 3, 200);



        }

        public ResourceLocation direRecipeID(String id) {
                return ResourceLocation.fromNamespaceAndPath(ID, id);
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