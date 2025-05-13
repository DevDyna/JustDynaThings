package com.devdyna.justdynathings.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.registry.types.zItemTags;
import com.devdyna.justdynathings.registry.types.zMultiTags;
import com.direwolf20.justdirethings.datagen.JustDireItemTags;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import static net.minecraft.world.item.Items.*;

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

                tag(zMultiTags.ANVILS.item()).add(ANVIL, CHIPPED_ANVIL, DAMAGED_ANVIL);

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

                tag(zItemTags.BLAZINGANVIL_DENY)
                                .add(MACE);

                tag(zItemTags.FLAWED_REVITALIZER)
                                .add(ECHO_SHARD);

                tag(zItemTags.REFORGER_CATALYST)
                                .add(
                                                ECHO_SHARD,
                                                NETHER_STAR,
                                                DIAMOND,
                                                NETHERITE_INGOT,
                                                NETHERITE_SCRAP,
                                                HEART_OF_THE_SEA,
                                                HEAVY_CORE
                                // ,zItems.CHAOTIC_DUST.get()
                                );

        }

}