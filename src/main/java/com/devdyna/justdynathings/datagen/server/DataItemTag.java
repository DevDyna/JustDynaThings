package com.devdyna.justdynathings.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.registry.types.ItemTags;
import com.devdyna.justdynathings.registry.types.Items;
import com.direwolf20.justdirethings.datagen.JustDireItemTags;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import static net.minecraft.world.item.Items.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;

@SuppressWarnings("null")

public class DataItemTag extends ItemTagsProvider {

    public DataItemTag(PackOutput o, CompletableFuture<Provider> p, CompletableFuture<TagLookup<Block>> b) {
        super(o, p, b);
    }

    @Override
    protected void addTags(Provider p) {

        tag(ItemTags.ANVILS).add(ANVIL,CHIPPED_ANVIL,DAMAGED_ANVIL);

        tag(ItemTags.COPPER_BULBS).add(
                Blocks.COPPER_BULB.asItem(),
                Blocks.EXPOSED_COPPER_BULB.asItem(),
                Blocks.WEATHERED_COPPER_BULB.asItem(),
                Blocks.OXIDIZED_COPPER_BULB.asItem(),
                Blocks.WAXED_COPPER_BULB.asItem(),
                Blocks.WAXED_EXPOSED_COPPER_BULB.asItem(),
                Blocks.WAXED_WEATHERED_COPPER_BULB.asItem(),
                Blocks.WAXED_OXIDIZED_COPPER_BULB.asItem());

        tag(Tags.Items.DUSTS).add(Items.CHAOTIC_DUST.get());
        tag(ItemTags.DUSTS_CHAOTIC).add(Items.CHAOTIC_DUST.get());

        tag(Tags.Items.RAW_MATERIALS).add(Items.RAW_COPRINIUM.get());
        tag(ItemTags.RAW_MATERIALS_COPRINIUM).add(Items.RAW_COPRINIUM.get());

        tag(Tags.Items.GEMS).add(Items.REDSTONIC_GEM.get());
        tag(ItemTags.GEMS_REDSTONIC).add(Items.REDSTONIC_GEM.get());

        tag(Tags.Items.INGOTS).add(Items.COPRINIUM_INGOT.get());
        tag(ItemTags.INGOTS_COPRINIUM).add(Items.COPRINIUM_INGOT.get());

        tag(ItemTags.CREATIVE_GOO_WRENCHES)
        .addOptionalTag(Tags.Items.TOOLS_WRENCH)
        .addOptionalTag(JustDireItemTags.WRENCHES);
                

        tag(ItemTags.BLAZINGANVIL_DENY)
                .add(MACE);

        tag(ItemTags.FLAWED_REVITALIZER)
                .add(ECHO_SHARD);

        tag(ItemTags.REFORGER_CATALYST)
                .add(
                        ECHO_SHARD,
                        NETHER_STAR,
                        DIAMOND,
                        NETHERITE_INGOT,
                        NETHERITE_SCRAP,
                        HEART_OF_THE_SEA,
                        HEAVY_CORE,
                        Items.CHAOTIC_DUST.get());

    }

}