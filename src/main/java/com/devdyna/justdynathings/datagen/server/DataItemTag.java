package com.devdyna.justdynathings.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.registry.types.zItemTags;
import com.devdyna.justdynathings.registry.types.zItems;
import com.devdyna.justdynathings.registry.types.zMultiTags;
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

        tag(zMultiTags.ANVILS.item()).add(ANVIL,CHIPPED_ANVIL,DAMAGED_ANVIL);

        tag(zMultiTags.COPPER_BULBS.item()).add(
                Blocks.COPPER_BULB.asItem(),
                Blocks.EXPOSED_COPPER_BULB.asItem(),
                Blocks.WEATHERED_COPPER_BULB.asItem(),
                Blocks.OXIDIZED_COPPER_BULB.asItem(),
                Blocks.WAXED_COPPER_BULB.asItem(),
                Blocks.WAXED_EXPOSED_COPPER_BULB.asItem(),
                Blocks.WAXED_WEATHERED_COPPER_BULB.asItem(),
                Blocks.WAXED_OXIDIZED_COPPER_BULB.asItem());

        tag(Tags.Items.DUSTS).add(zItems.CHAOTIC_DUST.get());
        tag(zItemTags.DUSTS_CHAOTIC).add(zItems.CHAOTIC_DUST.get());

        tag(Tags.Items.RAW_MATERIALS).add(zItems.RAW_COPRINIUM.get());
        tag(zItemTags.RAW_MATERIALS_COPRINIUM).add(zItems.RAW_COPRINIUM.get());

        tag(Tags.Items.GEMS).add(zItems.REDSTONIC_GEM.get());
        tag(zItemTags.GEMS_REDSTONIC).add(zItems.REDSTONIC_GEM.get());

        tag(Tags.Items.INGOTS).add(zItems.COPRINIUM_INGOT.get());
        tag(zItemTags.INGOTS_COPRINIUM).add(zItems.COPRINIUM_INGOT.get());

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
                        HEAVY_CORE,
                        zItems.CHAOTIC_DUST.get());

    }

}