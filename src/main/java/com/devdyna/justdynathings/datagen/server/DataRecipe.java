package com.devdyna.justdynathings.datagen.server;

import static com.devdyna.justdynathings.JustDynaThings.MODULE_ID;

import java.util.concurrent.CompletableFuture;

import com.devdyna.cakesticklib.api.utils.x;
import com.devdyna.justdynathings.Constants;
import com.devdyna.justdynathings.init.types.zBlockTags;
import com.devdyna.justdynathings.init.types.zBlocks;
import com.devdyna.justdynathings.init.types.zItemTags;
import com.devdyna.justdynathings.init.types.zItems;
import com.direwolf20.justdirethings.datagen.recipes.GooSpreadRecipeBuilder;
import com.direwolf20.justdirethings.setup.JDTRegistration;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;

public class DataRecipe extends RecipeProvider {

        protected DataRecipe(Provider registries, RecipeOutput output) {
                super(registries, output);
        }

        @Override
        protected void buildRecipes() {

                shaped(RecipeCategory.MISC, zBlocks.FERRICORE_CLOCK.get(), 1)
                                .pattern("ABA")
                                .pattern("BCB")
                                .pattern("ABA")
                                .define('A', JDTRegistration.FerricoreIngot.get())
                                .define('B', Tags.Items.DUSTS_REDSTONE)
                                .define('C', zItemTags.COPPER_BULBS)
                                .unlockedBy(getHasName(JDTRegistration.FerricoreIngot.get()),
                                                has(JDTRegistration.FerricoreIngot.get()))
                                .save(output);

                shaped(RecipeCategory.MISC, zBlocks.STABILIZER.get(), 1)
                                .pattern("CDC")
                                .pattern("BAB")
                                .pattern("CBC")
                                .define('A', JDTRegistration.BlockSwapperT1.get())
                                .define('B', Tags.Items.DUSTS_REDSTONE)
                                .define('C', JDTRegistration.EclipseAlloyIngot.get())
                                .define('D', JDTRegistration.TimeCrystalBlock.get())
                                .unlockedBy(getHasName(JDTRegistration.TimeCrystalBlock.get()),
                                                has(JDTRegistration.TimeCrystalBlock.get()))
                                .save(output);

                shapeless(RecipeCategory.MISC, zBlocks.PHASEBOX.get(), 4)
                                .requires(JDTRegistration.Celestigem.get())
                                .requires(Tags.Items.GLASS_BLOCKS_TINTED)
                                .requires(Tags.Items.GEMS_LAPIS)
                                .unlockedBy(getHasName(JDTRegistration.Celestigem.get()),
                                                has(JDTRegistration.Celestigem.get()))
                                .save(output);

                shaped(RecipeCategory.MISC, zBlocks.BLACKHOLE.get(), 1)
                                .pattern("FBF")
                                .pattern("RKR")
                                .pattern("FBF")
                                .define('F', JDTRegistration.FerricoreIngot.get())
                                .define('K', JDTRegistration.CelestigemBlock_ITEM.get())
                                .define('R', Items.REDSTONE)
                                .define('B', Items.BUCKET)
                                .unlockedBy(getHasName(JDTRegistration.Celestigem.get()), has(
                                                JDTRegistration.Celestigem.get()))
                                .save(output);

                shaped(RecipeCategory.MISC, zBlocks.CREATIVE_GOO.get(), 2)
                                .pattern("ABA")
                                .pattern("BCB")
                                .pattern("ABA")
                                .define('A', JDTRegistration.TimeCrystal.get())
                                .define('B', JDTRegistration.EclipseAlloyIngot.get())
                                .define('C', Items.NETHER_STAR)
                                .unlockedBy(getHasName(JDTRegistration.EclipseAlloyIngot.get()), has(
                                                JDTRegistration.EclipseAlloyIngot.get()))
                                .group(Constants.Goo.Creative)
                                .save(output);

                GooConversion(zBlockTags.T2_SPREAD, JDTRegistration.GooBlock_Tier2.get(), output);
                GooConversion(zBlockTags.T3_SPREAD, JDTRegistration.GooBlock_Tier3.get(), output);
                GooConversion(zBlockTags.T4_SPREAD, JDTRegistration.GooBlock_Tier4.get(), output);

                shapeless(zBlocks.T1_GOO.get().asItem(), output,
                                JDTRegistration.GooBlock_Tier1_ITEM.get(),
                                JDTRegistration.Coal_T1.get(),
                                JDTRegistration.RawFerricore.get(),
                                JDTRegistration.TotemOfDeathRecall.get());

                shapeless(zBlocks.T2_GOO.get().asItem(), output,
                                JDTRegistration.GooBlock_Tier2_ITEM.get(),
                                JDTRegistration.Coal_T2.get(),
                                JDTRegistration.RawBlazegold.get(),
                                JDTRegistration.TotemOfDeathRecall.get());

                shapeless(zBlocks.T3_GOO.get().asItem(), output,
                                JDTRegistration.GooBlock_Tier3_ITEM.get(),
                                JDTRegistration.Coal_T3.get(),
                                JDTRegistration.Celestigem.get(),
                                JDTRegistration.TotemOfDeathRecall.get());

                shapeless(zBlocks.T4_GOO.get().asItem(), output,
                                JDTRegistration.GooBlock_Tier4_ITEM.get(),
                                JDTRegistration.Coal_T4.get(),
                                JDTRegistration.RawEclipseAlloy.get(),
                                JDTRegistration.TotemOfDeathRecall.get());

                AnvilRecipe(zBlocks.FERRICORE_ANVIL.get(), JDTRegistration.FerricoreIngot.get(),
                                JDTRegistration.FerricoreBlock_ITEM.get(), 
                                ItemTags.ANVIL, output);

                AnvilRecipe(zBlocks.BLAZEGOLD_ANVIL.get(), JDTRegistration.BlazegoldIngot.get(),
                                JDTRegistration.BlazeGoldBlock_ITEM.get(), 
                                zBlocks.FERRICORE_ANVIL.get(), output);

                AnvilRecipe(zBlocks.CELESTIGEM_ANVIL.get(), JDTRegistration.Celestigem.get(),
                                JDTRegistration.CelestigemBlock_ITEM.get(), 
                                zBlocks.BLAZEGOLD_ANVIL.get(), output);

                AnvilRecipe(zBlocks.ECLIPSEALLOY_ANVIL.get(), JDTRegistration.EclipseAlloyIngot.get(),
                                JDTRegistration.EclipseAlloyBlock_ITEM.get(),
                               
                                zBlocks.CELESTIGEM_ANVIL.get(), output);

                SolarRecipe(zBlocks.FERRICORE_SOLARGEN.get(), Items.LAPIS_LAZULI,
                                JDTRegistration.Coal_T1.get(), JDTRegistration.FerricoreIngot.get(), null, null,
                                output);

                SolarRecipe(zBlocks.BLAZEGOLD_SOLARGEN.get(), Items.MAGMA_CREAM,
                                JDTRegistration.Coal_T2.get(), JDTRegistration.BlazegoldIngot.get(),
                                JDTRegistration.TEMPLATE_BLAZEGOLD.get(), zBlocks.FERRICORE_SOLARGEN.get().asItem(),
                                output);

                SolarRecipe(zBlocks.CELESTIGEM_SOLARGEN.get(), Items.ENDER_PEARL,
                                JDTRegistration.Coal_T3.get(), JDTRegistration.Celestigem.get(),
                                JDTRegistration.TEMPLATE_CELESTIGEM.get(), zBlocks.BLAZEGOLD_SOLARGEN.get().asItem(),
                                output);

                SolarRecipe(zBlocks.ECLIPSEALLOY_SOLARGEN.get(), Items.SCULK_VEIN,
                                JDTRegistration.Coal_T4.get(), JDTRegistration.EclipseAlloyIngot.get(),
                                JDTRegistration.TEMPLATE_ECLIPSEALLOY.get(), zBlocks.CELESTIGEM_SOLARGEN.get().asItem(),
                                output);

                shaped(RecipeCategory.MISC, zItems.PICKER_STAFF.get(), 1)
                                .pattern(" CE")
                                .pattern(" IC")
                                .pattern("I  ")
                                .define('I', JDTRegistration.BlazegoldIngot.get())
                                .define('C', Items.LAPIS_LAZULI)
                                .define('E', Items.ENDER_EYE)
                                .unlockedBy(getHasName(JDTRegistration.BlazegoldIngot.get()), has(
                                                JDTRegistration.BlazegoldIngot.get()))
                                .group(Constants.Wands.Picker)
                                .save(output);

                shaped(RecipeCategory.MISC, zItems.SWAP_STAFF.get(), 1)
                                .pattern(" CE")
                                .pattern(" IC")
                                .pattern("I  ")
                                .define('I', JDTRegistration.BlazegoldIngot.get())
                                .define('C', Items.REDSTONE)
                                .define('E', Items.ENDER_EYE)
                                .unlockedBy(getHasName(JDTRegistration.BlazegoldIngot.get()), has(
                                                JDTRegistration.BlazegoldIngot.get()))
                                .group(Constants.Wands.Swapper)
                                .save(output);

                zBlocks.zBlockItem.getEntries()
                                .forEach(i -> shapeless(i.get().asItem(), output,
                                                x.rl(MODULE_ID, x.path(i.get()) + "_clear_nbt"),
                                                i.get().asItem()));

                shaped(RecipeCategory.MISC, zBlocks.T2_GOO.get(), 1)
                                .pattern("BRB")
                                .pattern("NGN")
                                .pattern("BRB")
                                .define('B', Items.BLAZE_POWDER)
                                .define('R', Tags.Items.DUSTS_REDSTONE)
                                .define('N', Items.NETHER_WART)
                                .define('G', zBlocks.T1_GOO.get())
                                .unlockedBy(getHasName(zBlocks.T1_GOO.get()), has(
                                                zBlocks.T1_GOO.get()))
                                .group(Constants.GooType + "_upgrade")
                                .save(output, zBlocks.T1_GOO.getId() + "_upgrade");

                shaped(RecipeCategory.MISC, zBlocks.T3_GOO.get(), 1)
                                .pattern("BRB")
                                .pattern("NGN")
                                .pattern("BRB")
                                .define('B', Items.ENDER_PEARL)
                                .define('R', Items.END_STONE)
                                .define('N', Items.DRAGON_BREATH)
                                .define('G', zBlocks.T2_GOO.get())
                                .unlockedBy(getHasName(zBlocks.T2_GOO.get()), has(
                                                zBlocks.T2_GOO.get()))
                                .group(Constants.GooType + "_upgrade")
                                .save(output, zBlocks.T2_GOO.getId() + "_upgrade");

                shaped(RecipeCategory.MISC, zBlocks.T4_GOO.get(), 1)
                                .pattern("BRB")
                                .pattern("NGN")
                                .pattern("BRB")
                                .define('B', Items.SCULK)
                                .define('R', Items.SCULK_SHRIEKER)
                                .define('N', Items.ECHO_SHARD)
                                .define('G', zBlocks.T3_GOO.get())
                                .unlockedBy(getHasName(zBlocks.T3_GOO.get()), has(
                                                zBlocks.T3_GOO.get()))
                                .group(Constants.GooType + "_upgrade")
                                .save(output, zBlocks.T3_GOO.getId() + "_upgrade");

                shaped(RecipeCategory.MISC, zItems.GOO_UPGRADER_T1.get(), 1)
                                .pattern("BRB")
                                .pattern("NGN")
                                .pattern("BRB")
                                .define('B', Items.BLAZE_POWDER)
                                .define('R', Tags.Items.DUSTS_REDSTONE)
                                .define('N', Items.NETHER_WART)
                                .define('G', JDTRegistration.UPGRADE_BASE.get())
                                .unlockedBy(getHasName(JDTRegistration.UPGRADE_BASE.get()),
                                                has(JDTRegistration.UPGRADE_BASE.get()))
                                .group(Constants.GooUpgraders.base)
                                .save(output);

                shaped(RecipeCategory.MISC, zItems.GOO_UPGRADER_T2.get(), 1)
                                .pattern("BRB")
                                .pattern("NGN")
                                .pattern("BRB")
                                .define('B', Items.ENDER_PEARL)
                                .define('R', Items.END_STONE)
                                .define('N', Items.DRAGON_BREATH)
                                .define('G', JDTRegistration.UPGRADE_BASE.get())
                                .unlockedBy(getHasName(JDTRegistration.UPGRADE_BASE.get()),
                                                has(JDTRegistration.UPGRADE_BASE.get()))
                                .group(Constants.GooUpgraders.base)
                                .save(output);

                shaped(RecipeCategory.MISC, zItems.GOO_UPGRADER_T3.get(), 1)
                                .pattern("BRB")
                                .pattern("NGN")
                                .pattern("BRB")
                                .define('B', Items.SCULK)
                                .define('R', Items.SCULK_SHRIEKER)
                                .define('N', Items.ECHO_SHARD)
                                .define('G', JDTRegistration.UPGRADE_BASE.get())
                                .unlockedBy(getHasName(JDTRegistration.UPGRADE_BASE.get()),
                                                has(JDTRegistration.UPGRADE_BASE.get()))
                                .group(Constants.GooUpgraders.base)
                                .save(output);


                shaped(RecipeCategory.MISC, zItems.LIGHT_WAND.get())
                                .pattern("  G")
                                .pattern(" F ")
                                .pattern("F  ")
                                .define('G', Items.GLOWSTONE)
                                .define('F', JDTRegistration.FerricoreIngot.get())
                                .unlockedBy(getHasName(JDTRegistration.FerricoreIngot.get()),
                                                has(
                                                                JDTRegistration.FerricoreIngot.get()))
                                .group(Constants.Wands.Light).save(output);

                shaped(RecipeCategory.MISC, zItems.ADVANCED_LIGHT_WAND.get())
                                .pattern("  C")
                                .pattern(" L ")
                                .pattern("B  ")
                                .define('L', zItems.LIGHT_WAND.get())
                                .define('C', JDTRegistration.Celestigem.get())
                                .define('B', JDTRegistration.BlazegoldIngot.get())
                                .unlockedBy(getHasName(JDTRegistration.Celestigem.get()),
                                                has(
                                                                JDTRegistration.Celestigem.get()))
                                .save(output);

                shaped(RecipeCategory.MISC, zBlocks.TICKER.get())
                                .pattern("ETE")
                                .pattern("TPT")
                                .pattern("ETE")
                                .define('P', JDTRegistration.TimeWand.get())
                                .define('T', Tags.Items.DUSTS_REDSTONE)
                                .define('E', JDTRegistration.EclipseAlloyIngot.get())
                                .unlockedBy(getHasName(JDTRegistration.EclipseAlloyIngot.get()),
                                                has(
                                                                JDTRegistration.EclipseAlloyIngot.get()))
                                .group(Constants.Blocks.Ticker).save(output);





   // var stupefy = new ItemStackTemplate(zItems.STUPEFY_WAND.get(), DataComponentPatch.builder()
                //                 .set((DataComponentType<Boolean>) JustDireDataComponents.COMPONENTS.getEntries()
                //                                 .stream()
                //                                 .filter(e -> e.getId()
                //                                                 .equals(x.rl("stupefy_upgrade_installed",
                //                                                                 JustDireThings.MODID)))
                //                                 .findFirst()
                //                                 .map(DeferredHolder::get)
                //                                 .orElse(null), true)
                //                 .build());

                // shaped(RecipeCategory.MISC, stupefy)
                //                 .pattern(" CE")
                //                 .pattern(" IC")
                //                 .pattern("I  ")
                //                 .define('I', JDTRegistration.BlazegoldIngot.get())
                //                 .define('C', Items.REDSTONE)
                //                 .define('E', Items.QUARTZ)
                //                 .unlockedBy(getHasName(JDTRegistration.BlazegoldIngot.get()), has(
                //                                 JDTRegistration.BlazegoldIngot.get()))
                //                 .group(Constants.Wands.Stupefy).save(output);

                // var time = new ItemStackTemplate(zItems.ADVANCED_TIME_WAND.get(),
                //                 DataComponentPatch.builder()
                //                                 .set(zComponents.MODE.get(), "normal")
                //                                 .build());

                // shaped(RecipeCategory.MISC, time)
                //                 .pattern(" EC")
                //                 .pattern(" WE")
                //                 .pattern("E  ")
                //                 .define('C', JDTRegistration.TimeCrystal.get())
                //                 .define('E', JDTRegistration.EclipseAlloyIngot.get())
                //                 .define('W', JDTRegistration.TimeWand.get())
                //                 .unlockedBy(getHasName(JDTRegistration.EclipseAlloyIngot.get()),
                //                                 has(
                //                                                 JDTRegistration.EclipseAlloyIngot.get()))
                //                 .group(Constants.Wands.AdvancedTime).save(output);

                



        }

        public static final class RecipeRunner extends RecipeProvider.Runner {
                public RecipeRunner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
                        super(output, lookupProvider);
                }

                @Override
                protected RecipeProvider createRecipeProvider(
                                HolderLookup.Provider lookupProvider,
                                RecipeOutput output) {
                        return new DataRecipe(lookupProvider, output);
                }

                @Override
                public String getName() {
                        return "JustDynaThings";
                }
        }

       

        private void GooConversion(TagKey<Block> input, Block goo, RecipeOutput c) {
                int tier = Integer.parseInt(x.path(goo).replace("gooblock_tier", ""));

                GooSpreadRecipeBuilder.shapeless(input, goo.defaultBlockState(), tier, 100)
                                .unlockedBy(getHasName(goo), has(goo.asItem()))
                                .save(c);

        }

        /**
         * group id generic
         */
        private void shapeless(Item output, RecipeOutput c, Item... items) {
                shapeless(output, c, x.rl(output), items);
        }

        /**
         * group id generic
         */
        private void shapeless(Item output, RecipeOutput c, Identifier id, Item... items) {
                var recipe = shapeless(RecipeCategory.MISC, output);
                for (Item item : items)
                        recipe.requires(item);
                recipe.unlockedBy(getHasName(items[0]), has(items[0]))
                                .save(c, ResourceKey.create(Registries.RECIPE, id));
        }

        private void AnvilRecipe(Block b, Item ingot, Item block, Block oldAnvil, RecipeOutput c) {
                shaped(RecipeCategory.MISC, b, 1)
                                .pattern(" I ")
                                .pattern("IAI")
                                .pattern(" B ")
                                .define('I', ingot)
                                .define('B', block)
                                .define('A', oldAnvil)
                                .unlockedBy(getHasName(ingot), has(ingot))
                                .group(Constants.AnvilType).save(output);

        }

        private void AnvilRecipe(Block b, Item ingot, Item block, TagKey<Item> oldAnvil,
                        RecipeOutput c) {
                shaped(RecipeCategory.MISC, b, 1)
                                .pattern(" I ")
                                .pattern("IAI")
                                .pattern(" B ")
                                .define('I', ingot)
                                .define('B', block)
                                .define('A', oldAnvil)
                                .unlockedBy(getHasName(ingot), has(ingot))
                                .group(Constants.AnvilType).save(output);

                
        }

        private void SolarRecipe(Block output, Item catalyst, Item coal, Item ingot, Item template, Item oldSolar,
                        RecipeOutput c) {

                shaped(RecipeCategory.MISC, output, 3)
                                .pattern("LLL")
                                .pattern("FCF")
                                .define('L', catalyst)
                                .define('F', ingot)
                                .define('C', coal)
                                .unlockedBy(getHasName(ingot), has(ingot))
                                .group(Constants.SolarPanelType)
                                .save(c);

        }

}