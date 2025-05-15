package com.devdyna.justdynathings.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.registry.types.zItemTags;
import com.devdyna.justdynathings.registry.types.zMultiTags;
import com.direwolf20.justdirethings.datagen.JustDireItemTags;
import com.direwolf20.justdirethings.setup.Registration;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;

@SuppressWarnings("null")

public class DataItemTag extends ItemTagsProvider {

        public DataItemTag(PackOutput o, CompletableFuture<Provider> p, CompletableFuture<TagLookup<Block>> b) {
                super(o, p, b);
        }

        @Override
        protected void addTags(Provider p) {

                tag(zMultiTags.ANVILS.item()).add(Items.ANVIL, Items.CHIPPED_ANVIL, Items.DAMAGED_ANVIL);

                tag(zMultiTags.COPPER_BULBS.item()).add(
                                Items.COPPER_BULB,
                                Items.EXPOSED_COPPER_BULB,
                                Items.WEATHERED_COPPER_BULB,
                                Items.OXIDIZED_COPPER_BULB,
                                Items.WAXED_COPPER_BULB,
                                Items.WAXED_EXPOSED_COPPER_BULB,
                                Items.WAXED_WEATHERED_COPPER_BULB,
                                Items.WAXED_OXIDIZED_COPPER_BULB);

                tag(zMultiTags.AMETHYST_BLOCKS.item()).add(Items.AMETHYST_BLOCK, Items.BUDDING_AMETHYST);

                tag(zItemTags.CREATIVE_GOO_WRENCHES)
                                .addOptionalTag(Tags.Items.TOOLS_WRENCH)
                                .addOptionalTag(JustDireItemTags.WRENCHES);

                tag(zItemTags.BLAZING_ANVIL_DENY)
                                .add(Items.MACE);

                tag(zItemTags.CELESTIGEM_DENY)
                                .add(Items.MACE);

                tag(zItemTags.FERRICORE_ANVIL_ALLOW)
                                .add(
                                                Registration.FerricoreAxe.get(),
                                                Registration.FerricorePickaxe.get(),
                                                Registration.FerricoreShovel.get(),
                                                Registration.FerricoreHoe.get(),
                                                Registration.FerricoreSword.get(),
                                                Registration.FerricoreBow.get(),
                                                Registration.FerricoreHelmet.get(),
                                                Registration.FerricoreChestplate.get(),
                                                Registration.FerricoreLeggings.get(),
                                                Registration.FerricoreBoots.get());

                tag(zItemTags.FERRICORE_ANVIL_REPAIR).add(Items.IRON_INGOT, Registration.FerricoreIngot.get());
                tag(zItemTags.TIME_ANVIL_DENY).add(Items.MACE,Items.TRIDENT,Items.ELYTRA);


                // tag(zItemTags.FLAWED_REVITALIZER)
                // .add(Items.ECHO_SHARD);

                tag(zItemTags.REFORGER_CATALYST)
                                .add(
                                                Items.ECHO_SHARD,
                                                Items.NETHER_STAR,
                                                Items.DIAMOND,
                                                Items.NETHERITE_INGOT,
                                                Items.NETHERITE_SCRAP,
                                                Items.HEART_OF_THE_SEA,
                                                Items.HEAVY_CORE
                                // ,zItems.CHAOTIC_DUST.get()
                                );

                tag(zMultiTags.T2_SPREAD.item()).add(
                                Registration.GooBlock_Tier1_ITEM.get());

                tag(zMultiTags.T3_SPREAD.item()).add(
                                Registration.GooBlock_Tier2_ITEM.get()).addTag(zMultiTags.T2_SPREAD.item());

                tag(zMultiTags.T4_SPREAD.item()).add(
                                Registration.GooBlock_Tier3_ITEM.get()).addTag(zMultiTags.T3_SPREAD.item());

        }

}