package com.devdyna.justdynathings.datagen.server;

import static net.minecraft.data.recipes.RecipeCategory.MISC;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.compat.ae2.initApp;
import com.devdyna.justdynathings.compat.extendedae.initExtend;
import com.devdyna.justdynathings.compat.geore.initGeOre;
import com.devdyna.justdynathings.compat.phasorite.initPhaso;
import com.devdyna.justdynathings.recipetypes.builders.*;
import com.devdyna.justdynathings.registry.builders.AdvancedTimeWand;
import com.devdyna.justdynathings.registry.types.*;
import com.devdyna.justdynathings.utils.DataGenUtil;
import com.devdyna.justdynathings.utils.LogUtil;
import com.direwolf20.justdirethings.JustDireThings;
import com.direwolf20.justdirethings.common.blocks.gooblocks.GooBlock_Base;
import com.direwolf20.justdirethings.common.items.datacomponents.JustDireDataComponents;
import com.direwolf20.justdirethings.common.items.interfaces.Ability;
import com.direwolf20.justdirethings.common.items.interfaces.ToolRecords.AbilityBinding;
import com.direwolf20.justdirethings.datagen.recipes.AbilityRecipeBuilder;
import com.direwolf20.justdirethings.datagen.recipes.FluidDropRecipe;
import com.direwolf20.justdirethings.datagen.recipes.FluidDropRecipeBuilder;
import com.direwolf20.justdirethings.datagen.recipes.GooSpreadRecipeBuilder;
import com.direwolf20.justdirethings.datagen.recipes.GooSpreadRecipeTagBuilder;
import com.direwolf20.justdirethings.setup.Registration;
import com.glodblock.github.extendedae.common.EAESingletons;
import com.shynieke.geore.registry.GeOreRegistry;

import appeng.core.definitions.AEBlocks;
import appeng.datagen.providers.tags.DataComponentTypeTagProvider;

import static com.devdyna.justdynathings.Main.ID;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.client.Minecraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.datafix.fixes.ItemStackComponentRemainderFix;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.crafting.BlockTagIngredient;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.server.command.NeoForgeCommand;

@SuppressWarnings({ "null", "unused" })
public class DataRecipe extends RecipeProvider {

        public DataRecipe(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
                super(output, completableFuture);
        }

        public static List<Block> denyClearBlocks = List.of(zBlocks.PHASEBOX.get());

        @Override
        protected void buildRecipes(RecipeOutput c) {
                // ---------------------------------------------------------------------------------------//

                ShapedRecipeBuilder.shaped(MISC, zBlocks.FERRICORE_CLOCK.get(), 1)
                                .pattern("ABA")
                                .pattern("BCB")
                                .pattern("ABA")
                                .define('A', Registration.FerricoreIngot.get())
                                .define('B', Tags.Items.DUSTS_REDSTONE)
                                .define('C', zItemTags.COPPER_BULBS)
                                .unlockedBy(ID, has(Registration.FerricoreIngot.get()))
                                .group(Constants.Blocks.FerricoreClock).save(c);

                ShapedRecipeBuilder.shaped(MISC, zBlocks.REFORGER.get(), 1)
                                .pattern("ADA")
                                .pattern("BEB")
                                .pattern("ACA")
                                .define('A', Registration.FerricoreIngot.get())
                                .define('B', Tags.Items.GEMS_LAPIS)
                                .define('C', Tags.Items.DUSTS_REDSTONE)
                                .define('D', Tags.Items.GEMS_AMETHYST)
                                .define('E', Registration.Celestigem.get())
                                .unlockedBy(ID, has(Registration.Celestigem.get()))
                                .group(Constants.Blocks.Reforger).save(c);

                ShapedRecipeBuilder.shaped(MISC, zBlocks.STABILIZER.get(), 1)
                                .pattern("CDC")
                                .pattern("BAB")
                                .pattern("CBC")
                                .define('A', Registration.BlockSwapperT1.get())
                                .define('B', Tags.Items.DUSTS_REDSTONE)
                                .define('C', Registration.EclipseAlloyIngot.get())
                                .define('D', Registration.TimeCrystalBlock.get())
                                .unlockedBy(ID, has(Registration.TimeCrystalBlock.get()))
                                .group(Constants.Blocks.Stabilizer).save(c);

                ShapelessRecipeBuilder.shapeless(MISC, zBlocks.PHASEBOX.get(), 4)
                                .requires(Registration.Celestigem.get())
                                .requires(Tags.Items.GLASS_BLOCKS_TINTED)
                                .requires(Tags.Items.GEMS_LAPIS)
                                .unlockedBy(ID, has(Registration.Celestigem.get()))
                                .group(Constants.Blocks.PhaseBox).save(c);

                GooSpreadRecipeBuilder.shapeless(DataGenUtil.getResource("dirt"),
                                Blocks.COARSE_DIRT.defaultBlockState(),
                                Blocks.DIRT.defaultBlockState(), 1, 200)
                                .unlockedBy(ID, itemInv(Blocks.COARSE_DIRT.asItem())).group("dirt-goo").save(c);

                GooSpreadRecipeBuilder.shapeless(DataGenUtil.getResource("clay"),
                                Blocks.MUD.defaultBlockState(),
                                Blocks.CLAY.defaultBlockState(), 1, 200)
                                .unlockedBy(ID, itemInv(Blocks.MUD.asItem())).group("clay-goo").save(c);

                GooSpreadRecipeBuilder.shapeless(DataGenUtil.getResource("crying_obsidian"),
                                Blocks.OBSIDIAN.defaultBlockState(),
                                Blocks.CRYING_OBSIDIAN.defaultBlockState(), 3, 200)
                                .unlockedBy(ID, itemInv(Blocks.OBSIDIAN.asItem())).group("obsidian-goo")
                                .save(c);

                Budding(zBlocks.ECHOING_BUDDING_AMETHYST.get().asItem(), zItemTags.AMETHYST_BLOCKS, c);

                Budding(zBlocks.ECHOING_BUDDING_TIME.get().asItem(), zItemTags.TIME_BUDDING, c);

                Budding(initApp.CERTUS.block().get().asItem(), zItemTags.AE2_COMPAT, c
                                .withConditions(DataGenUtil.isModLoaded("ae2")));

                Budding(initExtend.ENTRO.block().get().asItem(), zItemTags.EXT_COMPAT, c
                                .withConditions(DataGenUtil.isModLoaded("extendedae")));

                Budding(initPhaso.PHASORITE.block().get().asItem(), zItemTags.PHA_COMPAT, c
                                .withConditions(DataGenUtil.isModLoaded("phasoritenetworks")));

                initGeOre.values().forEach(b -> Budding(b.block().get().asItem(), GeOreRegistry.getGeOres().stream()
                                .filter(g -> g.getName()
                                                .equalsIgnoreCase(b.id().replace(Constants.BuddingType + "_", "")))
                                .findFirst()
                                .orElse(null).getBlock().get().asItem(),
                                c
                                                .withConditions(DataGenUtil.isModLoaded("geore"))));

                ShapedRecipeBuilder.shaped(MISC, zBlocks.BLACKHOLE.get(), 1)
                                .pattern("FBF")
                                .pattern("RKR")
                                .pattern("FBF")
                                .define('F', Registration.FerricoreIngot.get())
                                .define('K', Registration.CelestigemBlock_ITEM.get())
                                .define('R', Items.REDSTONE)
                                .define('B', Items.BUCKET)
                                .unlockedBy(ID, itemInv(Registration.FerricoreIngot.get(),
                                                Registration.Celestigem.get()))
                                .group(Constants.Blocks.BlackHole).save(c);

                ShapedRecipeBuilder.shaped(MISC, zBlocks.THERMOGEN.get(), 1)
                                .pattern(" A ")
                                .pattern("AAA")
                                .pattern("RBR")
                                .define('A', Registration.EclipseAlloyIngot.get())
                                .define('R', Items.REDSTONE)
                                .define('B', Registration.BlazegoldIngot.get())
                                .unlockedBy(ID, itemInv(Registration.EclipseAlloyIngot.get()))
                                .group(Constants.Blocks.ThermoGen).save(c);

                ShapedRecipeBuilder.shaped(MISC, zBlocks.CREATIVE_GOO.get(), 2)
                                .pattern("ABA")
                                .pattern("BCB")
                                .pattern("ABA")
                                .define('A', Registration.TimeCrystal.get())
                                .define('B', Registration.EclipseAlloyIngot.get())
                                .define('C', Items.NETHER_STAR)
                                .unlockedBy(ID, itemInv(Items.NETHER_STAR, Registration.TimeCrystal.get(),
                                                Registration.EclipseAlloyIngot.get()))
                                .group(Constants.Goo.Creative).save(c);

                ShapedRecipeBuilder.shaped(MISC, zBlocks.ENERGIZED_GOO.get(), 1)
                                .pattern("DAD")
                                .pattern("BCB")
                                .pattern("DAD")
                                .define('A', Registration.TimeCrystal.get())
                                .define('B', Registration.EclipseAlloyIngot.get())
                                .define('C', zItemTags.T4_GOO_TYPE)
                                .define('D', Items.REDSTONE_BLOCK)
                                .unlockedBy(ID, itemInv(Registration.TimeCrystal.get(),
                                                Registration.EclipseAlloyIngot.get()))
                                .group(Constants.Goo.Energized).save(c);

                GooConversion(zBlockTags.T2_SPREAD, Registration.GooBlock_Tier2.get(), c);
                GooConversion(zBlockTags.T3_SPREAD, Registration.GooBlock_Tier3.get(), c);
                GooConversion(zBlockTags.T4_SPREAD, Registration.GooBlock_Tier4.get(), c);

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

                AnvilRecipe(zBlocks.FERRICORE_ANVIL.get(), Registration.FerricoreIngot.get(),
                                Registration.FerricoreBlock_ITEM.get(), Registration.TEMPLATE_FERRICORE.get(),
                                ItemTags.ANVIL, c);

                AnvilRecipe(zBlocks.BLAZEGOLD_ANVIL.get(), Registration.BlazegoldIngot.get(),
                                Registration.BlazeGoldBlock_ITEM.get(), Registration.TEMPLATE_BLAZEGOLD.get(),
                                zBlocks.FERRICORE_ANVIL.get(), c);

                AnvilRecipe(zBlocks.CELESTIGEM_ANVIL.get(), Registration.Celestigem.get(),
                                Registration.CelestigemBlock_ITEM.get(), Registration.TEMPLATE_CELESTIGEM.get(),
                                zBlocks.BLAZEGOLD_ANVIL.get(), c);

                AnvilRecipe(zBlocks.ECLIPSEALLOY_ANVIL.get(), Registration.EclipseAlloyIngot.get(),
                                Registration.EclipseAlloyBlock_ITEM.get(), Registration.TEMPLATE_ECLIPSEALLOY.get(),
                                zBlocks.CELESTIGEM_ANVIL.get(), c);

                SolarRecipe(zBlocks.FERRICORE_SOLARGEN.get(), Items.LAPIS_LAZULI,
                                Registration.Coal_T1.get(), Registration.FerricoreIngot.get(), null, null, c);

                SolarRecipe(zBlocks.BLAZEGOLD_SOLARGEN.get(), Items.MAGMA_CREAM,
                                Registration.Coal_T2.get(), Registration.BlazegoldIngot.get(),
                                Registration.TEMPLATE_BLAZEGOLD.get(), zBlocks.FERRICORE_SOLARGEN.get().asItem(), c);

                SolarRecipe(zBlocks.CELESTIGEM_SOLARGEN.get(), Items.ENDER_PEARL,
                                Registration.Coal_T3.get(), Registration.Celestigem.get(),
                                Registration.TEMPLATE_CELESTIGEM.get(), zBlocks.BLAZEGOLD_SOLARGEN.get().asItem(), c);

                SolarRecipe(zBlocks.ECLIPSEALLOY_SOLARGEN.get(), Items.SCULK_VEIN,
                                Registration.Coal_T4.get(), Registration.EclipseAlloyIngot.get(),
                                Registration.TEMPLATE_ECLIPSEALLOY.get(), zBlocks.CELESTIGEM_SOLARGEN.get().asItem(),
                                c);

                ShapedRecipeBuilder.shaped(MISC, zItems.PICKER_STAFF.get(), 1)
                                .pattern(" CE")
                                .pattern(" IC")
                                .pattern("I  ")
                                .define('I', Registration.BlazegoldIngot.get())
                                .define('C', Items.LAPIS_LAZULI)
                                .define('E', Items.ENDER_EYE)
                                .unlockedBy(ID, itemInv(Items.ENDER_EYE, Items.LAPIS_LAZULI,
                                                Registration.BlazegoldIngot.get()))
                                .group(Constants.Wands.Picker).save(c);

                ShapedRecipeBuilder.shaped(MISC, zItems.SWAP_STAFF.get(), 1)
                                .pattern(" CE")
                                .pattern(" IC")
                                .pattern("I  ")
                                .define('I', Registration.BlazegoldIngot.get())
                                .define('C', Items.REDSTONE)
                                .define('E', Items.ENDER_EYE)
                                .unlockedBy(ID, itemInv(Items.ENDER_EYE, Items.REDSTONE,
                                                Registration.BlazegoldIngot.get()))
                                .group(Constants.Wands.Swapper).save(c);

                zBlocks.zBlockItem.getEntries()
                                .forEach(i -> {
                                        if (!denyClearBlocks.contains(i.get()))
                                                shapeless(i.get().asItem(), c,
                                                                ResourceLocation.parse(i.getId() + "_clear_nbt"),
                                                                i.get().asItem());
                                });

                ShapedRecipeBuilder.shaped(MISC, zBlocks.T2_GOO.get(), 1)
                                .pattern("BRB")
                                .pattern("NGN")
                                .pattern("BRB")
                                .define('B', Items.BLAZE_POWDER)
                                .define('R', Tags.Items.DUSTS_REDSTONE)
                                .define('N', Items.NETHER_WART)
                                .define('G', zBlocks.T1_GOO.get())
                                .unlockedBy(ID, itemInv(
                                                zBlocks.T1_GOO.get().asItem()))
                                .group(Constants.GooType + "_upgrade")
                                .save(c, ResourceLocation.parse(zBlocks.T1_GOO.getId() + "_upgrade"));

                ShapedRecipeBuilder.shaped(MISC, zBlocks.T3_GOO.get(), 1)
                                .pattern("BRB")
                                .pattern("NGN")
                                .pattern("BRB")
                                .define('B', Items.ENDER_PEARL)
                                .define('R', Items.END_STONE)
                                .define('N', Items.DRAGON_BREATH)
                                .define('G', zBlocks.T2_GOO.get())
                                .unlockedBy(ID, itemInv(
                                                zBlocks.T2_GOO.get().asItem()))
                                .group(Constants.GooType + "_upgrade")
                                .save(c, ResourceLocation.parse(zBlocks.T2_GOO.getId() + "_upgrade"));

                ShapedRecipeBuilder.shaped(MISC, zBlocks.T4_GOO.get(), 1)
                                .pattern("BRB")
                                .pattern("NGN")
                                .pattern("BRB")
                                .define('B', Items.SCULK)
                                .define('R', Items.SCULK_SHRIEKER)
                                .define('N', Items.ECHO_SHARD)
                                .define('G', zBlocks.T3_GOO.get())
                                .unlockedBy(ID, itemInv(
                                                zBlocks.T3_GOO.get().asItem()))
                                .group(Constants.GooType + "_upgrade")
                                .save(c, ResourceLocation.parse(zBlocks.T3_GOO.getId() + "_upgrade"));

                ShapedRecipeBuilder.shaped(MISC, zItems.GOO_UPGRADER_T1.get(), 1)
                                .pattern("BRB")
                                .pattern("NGN")
                                .pattern("BRB")
                                .define('B', Items.BLAZE_POWDER)
                                .define('R', Tags.Items.DUSTS_REDSTONE)
                                .define('N', Items.NETHER_WART)
                                .define('G', Registration.UPGRADE_BASE.get())
                                .unlockedBy(ID, itemInv(
                                                Items.REDSTONE, Items.NETHER_WART, Items.BLAZE_POWDER,
                                                Registration.UPGRADE_BASE.get()))
                                .group(Constants.GooUpgraders.base)
                                .save(c);

                ShapedRecipeBuilder.shaped(MISC, zItems.GOO_UPGRADER_T2.get(), 1)
                                .pattern("BRB")
                                .pattern("NGN")
                                .pattern("BRB")
                                .define('B', Items.ENDER_PEARL)
                                .define('R', Items.END_STONE)
                                .define('N', Items.DRAGON_BREATH)
                                .define('G', Registration.UPGRADE_BASE.get())
                                .unlockedBy(ID, itemInv(
                                                Items.ENDER_PEARL, Items.END_STONE, Items.DRAGON_BREATH,
                                                Registration.UPGRADE_BASE.get()))
                                .group(Constants.GooUpgraders.base)
                                .save(c);

                ShapedRecipeBuilder.shaped(MISC, zItems.GOO_UPGRADER_T3.get(), 1)
                                .pattern("BRB")
                                .pattern("NGN")
                                .pattern("BRB")
                                .define('B', Items.SCULK)
                                .define('R', Items.SCULK_SHRIEKER)
                                .define('N', Items.ECHO_SHARD)
                                .define('G', Registration.UPGRADE_BASE.get())
                                .unlockedBy(ID, itemInv(
                                                Items.SCULK, Items.SCULK_SHRIEKER, Registration.UPGRADE_BASE.get(),
                                                Items.ECHO_SHARD))
                                .group(Constants.GooUpgraders.base)
                                .save(c);

                ShapedRecipeBuilder.shaped(MISC, zItems.GOO_UPGRADER_T4.get(), 1)
                                .pattern("DAD")
                                .pattern("BCB")
                                .pattern("DAD")
                                .define('A', Registration.TimeCrystal.get())
                                .define('B', Registration.EclipseAlloyIngot.get())
                                .define('C', Registration.UPGRADE_BASE.get())
                                .define('D', Items.REDSTONE_BLOCK)
                                .unlockedBy(ID, itemInv(Registration.UPGRADE_BASE.get(), Registration.TimeCrystal.get(),
                                                Registration.EclipseAlloyIngot.get()))
                                .group(Constants.GooUpgraders.base).save(c);
                // ---------------------------------------------------------------------------------------//

                ReforgerOTMBuilder.of()
                                .input(Blocks.STONE.defaultBlockState())
                                .catalyst(Ingredient.of(Items.DIAMOND))
                                .chanceToUse(95)
                                .output(Tags.Blocks.ORES_IN_GROUND_STONE)
                                .unlockedBy().group(Constants.DataMaps.Reforger.block_to_tag).save(c);

                ReforgerOTMBuilder.of()
                                .input(Blocks.STONE.defaultBlockState())
                                .catalyst(Ingredient.of(Registration.Celestigem.get()))
                                .chanceToUse(50)
                                .output(Tags.Blocks.ORES_IN_GROUND_STONE)
                                .unlockedBy().group(Constants.DataMaps.Reforger.block_to_tag).save(c);

                ReforgerMTOBuilder.of()
                                .input(zBlockTags.COAL_BLOCKS)
                                .catalyst(Ingredient.of(Registration.Coal_T1.get()))
                                .chanceToUse(50)
                                .output(Registration.RawCoal_T1.get().defaultBlockState())
                                .unlockedBy().group(Constants.DataMaps.Reforger.tag_to_block).save(c);

                ReforgerOTOBuilder.of()
                                .input(Registration.RawCoal_T1.get().defaultBlockState())
                                .catalyst(Ingredient.of(Registration.Coal_T2.get()))
                                .chanceToUse(50)
                                .output(Registration.RawCoal_T2.get().defaultBlockState())
                                .unlockedBy().group(Constants.DataMaps.Reforger.block_to_block).save(c);

                ReforgerOTOBuilder.of()
                                .input(Registration.RawCoal_T2.get().defaultBlockState())
                                .catalyst(Ingredient.of(Registration.Coal_T3.get()))
                                .chanceToUse(50)
                                .output(Registration.RawCoal_T3.get().defaultBlockState())
                                .unlockedBy().group(Constants.DataMaps.Reforger.block_to_block).save(c);

                ReforgerOTOBuilder.of()
                                .input(Registration.RawCoal_T3.get().defaultBlockState())
                                .catalyst(Ingredient.of(Registration.Coal_T4.get()))
                                .chanceToUse(50)
                                .output(Registration.RawCoal_T4.get().defaultBlockState())
                                .unlockedBy().group(Constants.DataMaps.Reforger.block_to_block).save(c);

                wands(c);

                ParadoxMixerRecipeBuilder.of()
                                .input(new FluidStack(((LiquidBlock) Blocks.WATER).fluid, 1000))
                                .catalyst(Ingredient.of(Registration.PolymorphicCatalyst.get()))
                                .output(new FluidStack(Registration.POLYMORPHIC_FLUID_BLOCK.get().fluid, 1000))
                                .group(ID)
                                .unlockedBy(ID, has(Registration.PolymorphicCatalyst.get()))
                                .save(c);

                ParadoxMixerRecipeBuilder.of()
                                .input(new FluidStack(Registration.POLYMORPHIC_FLUID_BLOCK.get().fluid, 1000))
                                .catalyst(Ingredient.of(Registration.PortalFluidCatalyst.get()))
                                .output(new FluidStack(Registration.UNSTABLE_PORTAL_FLUID_BLOCK.get().fluid, 1000))
                                .group(ID)
                                .unlockedBy(ID, has(Registration.PortalFluidCatalyst.get()))
                                .save(c);

                ParadoxMixerRecipeBuilder.of()
                                .input(new FluidStack(Registration.POLYMORPHIC_FLUID_BLOCK.get().fluid, 1000))
                                .catalyst(Ingredient.of(Registration.Coal_T2.get()))
                                .output(new FluidStack(Registration.UNREFINED_T2_FLUID_BLOCK.get().fluid, 1000))
                                .group(ID)
                                .unlockedBy(ID, has(Registration.Coal_T2.get()))
                                .save(c);

                ParadoxMixerRecipeBuilder.of()
                                .input(new FluidStack(Registration.REFINED_T2_FLUID_BLOCK.get().fluid, 1000))
                                .catalyst(Ingredient.of(Registration.Coal_T3.get()))
                                .output(new FluidStack(Registration.UNREFINED_T3_FLUID_BLOCK.get().fluid, 1000))
                                .group(ID)
                                .unlockedBy(ID, has(Registration.Coal_T3.get()))
                                .save(c);

                ParadoxMixerRecipeBuilder.of()
                                .input(new FluidStack(Registration.REFINED_T3_FLUID_BLOCK.get().fluid, 1000))
                                .catalyst(Ingredient.of(Registration.Coal_T4.get()))
                                .output(new FluidStack(Registration.UNREFINED_T4_FLUID_BLOCK.get().fluid, 1000))
                                .group(ID)
                                .unlockedBy(ID, has(Registration.Coal_T4.get()))
                                .save(c);

                ParadoxMixerRecipeBuilder.of()
                                .input(new FluidStack(Registration.POLYMORPHIC_FLUID_BLOCK.get().fluid, 1000))
                                .catalyst(Ingredient.of(Registration.TimeCrystal.get()))
                                .output(new FluidStack(Registration.TIME_FLUID_BLOCK.get().fluid, 1000))
                                .unlockedBy().group(ID).save(c);

                ShapedRecipeBuilder.shaped(MISC, zBlocks.PARADOX_MIXER.get())
                                .pattern("ETE")
                                .pattern("TPT")
                                .pattern("ETE")
                                .define('P', Registration.ParadoxMachine.get())
                                .define('T', Registration.EclipseAlloyIngot.get())
                                .define('E', Registration.PORTAL_FLUID_BUCKET.get())
                                .unlockedBy(ID,
                                                has(
                                                                Registration.EclipseAlloyIngot.get()))
                                .group(Constants.Blocks.ParadoxMixer).save(c);

                ShapedRecipeBuilder.shaped(MISC, zBlocks.TICKER.get())
                                .pattern("ETE")
                                .pattern("TPT")
                                .pattern("ETE")
                                .define('P', zItemTags.TIME_WANDS)
                                .define('T', Tags.Items.DUSTS_REDSTONE)
                                .define('E', Registration.EclipseAlloyIngot.get())
                                .unlockedBy(ID,
                                                has(
                                                                Registration.EclipseAlloyIngot.get()))
                                .group(Constants.Blocks.Ticker).save(c);

        }

        @SuppressWarnings("unchecked")
        private void wands(RecipeOutput c) {
                var stupefy = new ItemStack(zItems.STUPEFY_WAND.get());

                stupefy.set((DataComponentType<Boolean>) JustDireDataComponents.COMPONENTS.getEntries().stream()
                                .filter(e -> e.getId()
                                                .equals(DataGenUtil.getResource("stupefy_upgrade_installed",
                                                                JustDireThings.MODID)))
                                .findFirst()
                                .map(DeferredHolder::get)
                                .orElse(null), true);
                ShapedRecipeBuilder.shaped(MISC, stupefy)
                                .pattern(" CE")
                                .pattern(" IC")
                                .pattern("I  ")
                                .define('I', Registration.BlazegoldIngot.get())
                                .define('C', Items.REDSTONE)
                                .define('E', Items.QUARTZ)
                                .unlockedBy(ID, itemInv(Items.ENDER_EYE, Items.REDSTONE,
                                                Registration.BlazegoldIngot.get()))
                                .group(Constants.Wands.Stupefy).save(c);

                var time = new ItemStack(zItems.ADVANCED_TIME_WAND.get());
                time.set(zComponents.MODE, "normal");
                ShapedRecipeBuilder.shaped(MISC, time)
                                .pattern(" EC")
                                .pattern(" WE")
                                .pattern("E  ")
                                .define('C', Registration.TimeCrystal.get())
                                .define('E', Registration.EclipseAlloyIngot.get())
                                .define('W', Registration.TimeWand.get())
                                .unlockedBy(ID,
                                                has(
                                                                Registration.EclipseAlloyIngot.get()))
                                .group(Constants.Wands.AdvancedTime).save(c);

                ShapedRecipeBuilder.shaped(MISC, zItems.LIGHT_WAND.get())
                                .pattern("  G")
                                .pattern(" F ")
                                .pattern("F  ")
                                .define('G', Items.GLOWSTONE)
                                .define('F', Registration.FerricoreIngot.get())
                                .unlockedBy(ID,
                                                has(
                                                                Registration.FerricoreIngot.get()))
                                .group(Constants.Wands.Light).save(c);

                ShapedRecipeBuilder.shaped(MISC, zItems.ADVANCED_LIGHT_WAND.get())
                                .pattern("  C")
                                .pattern(" L ")
                                .pattern("B  ")
                                .define('L', zItems.LIGHT_WAND.get())
                                .define('C', Registration.Celestigem.get())
                                .define('B', Registration.BlazegoldIngot.get())
                                .unlockedBy(ID,
                                                has(
                                                                Registration.Celestigem.get()))
                                .group(Constants.Wands.AdvancedLight).save(c);

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
                ShapelessRecipeBuilder.shapeless(MISC, output, 1)
                                .requires(input)
                                .requires(Items.ECHO_SHARD)
                                .requires(Registration.PolymorphicCatalyst.get())
                                .unlockedBy(ID, itemInv(Items.ECHO_SHARD, Registration.PolymorphicCatalyst.get()))
                                .group(Constants.BuddingType)
                                .save(c);
        }

       
        private void Budding(Item output, Item input, RecipeOutput c) {
                ShapelessRecipeBuilder.shapeless(MISC, output, 1)
                                .requires(input)
                                .requires(Items.ECHO_SHARD)
                                .requires(Registration.PolymorphicCatalyst.get())
                                .unlockedBy(ID, itemInv(Items.ECHO_SHARD, Registration.PolymorphicCatalyst.get()))
                                .group(Constants.BuddingType)
                                .save(c);
        }

        private void GooConversion(TagKey<Block> input, Block goo, RecipeOutput c) {
                int tier = Integer.parseInt(DataGenUtil.getName(goo).replace("gooblock_tier", ""));
                GooSpreadRecipeTagBuilder.shapeless(DataGenUtil.getResource(goo),
                                new BlockTagIngredient(input), goo.defaultBlockState(), tier, 100 * tier)
                                .unlockedBy(ID, itemInv(goo.asItem())).group("goo-recipes")
                                .save(c);
        }

        /**
         * group id generic
         */
        private void shapeless(Item output, RecipeOutput c, Item... items) {
                shapeless(output, c, ResourceLocation.fromNamespaceAndPath(ID, DataGenUtil.getName(output)), items);
        }

        /**
         * group id generic
         */
        private void shapeless(Item output, RecipeOutput c, ResourceLocation id, Item... items) {
                var recipe = ShapelessRecipeBuilder.shapeless(MISC, output);
                for (Item item : items)
                        recipe.requires(item);
                recipe.unlockedBy(ID, itemInv(items)).group(ID).save(c, id);
        }

        private void AnvilRecipe(Block b, Item ingot, Item block, Item template, Block oldAnvil, RecipeOutput c) {
                ShapedRecipeBuilder.shaped(MISC, b, 1)
                                .pattern(" I ")
                                .pattern("IAI")
                                .pattern(" B ")
                                .define('I', ingot)
                                .define('B', block)
                                .define('A', oldAnvil)
                                .unlockedBy(ID, has(ingot))
                                .group(Constants.AnvilType).save(c);

                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(oldAnvil.asItem()),
                                Ingredient.of(ingot),
                                MISC, b.asItem()).unlocks(ID,
                                                has(ingot))
                                .save(c, ID + ":" + DataGenUtil.getName(b) + "_smithing");
        }

        private void AnvilRecipe(Block b, Item ingot, Item block, Item template, TagKey<Item> oldAnvil,
                        RecipeOutput c) {
                ShapedRecipeBuilder.shaped(MISC, b, 1)
                                .pattern(" I ")
                                .pattern("IAI")
                                .pattern(" B ")
                                .define('I', ingot)
                                .define('B', block)
                                .define('A', oldAnvil)
                                .unlockedBy(ID, has(ingot))
                                .group(Constants.AnvilType).save(c);

                SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(oldAnvil),
                                Ingredient.of(ingot),
                                MISC, b.asItem()).unlocks(ID,
                                                has(ingot))
                                .save(c, ID + ":" + DataGenUtil.getName(b) + "_smithing");
        }

        private void SolarRecipe(Block output, Item catalyst, Item coal, Item ingot, Item template, Item oldSolar,
                        RecipeOutput c) {

                ShapedRecipeBuilder.shaped(MISC, output, 3)
                                .pattern("LLL")
                                .pattern("FCF")
                                .define('L', catalyst)
                                .define('F', ingot)
                                .define('C', coal)
                                .unlockedBy(ID, itemInv(coal, catalyst, ingot))
                                .group(Constants.SolarPanelType).save(c);

                if (oldSolar != null || template != null)
                        SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(oldSolar),
                                        Ingredient.of(coal),
                                        MISC, output.asItem()).unlocks(ID,
                                                        itemInv(coal, catalyst, ingot))
                                        .save(c, ID + ":" + DataGenUtil.getName(output) + "_smithing");
        }

}