package com.devdyna.justdynathings.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.types.zBlockTags;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.registry.types.zMultiTags;
import com.devdyna.justdynathings.utils.DataGenUtil;
import com.direwolf20.justdirethings.datagen.JustDireBlockTags;
import com.direwolf20.justdirethings.setup.Registration;

import static com.devdyna.justdynathings.registry.types.zBlockTags.*;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

@SuppressWarnings("null")

public class DataBlockTag extends BlockTagsProvider {

        public DataBlockTag(PackOutput o, CompletableFuture<Provider> l, ExistingFileHelper f) {
                super(o, l, Main.ID, f);
        }

        @Override
        protected void addTags(Provider p) {

                // generic blocks
                zBlocks.zBlock.getEntries()
                                .forEach(b -> tag(BlockTags.MINEABLE_WITH_PICKAXE)
                                                .addOptional(DataGenUtil.getResource(b.get())));
                zBlocks.zBlockItem.getEntries()
                                .forEach(b -> tag(BlockTags.MINEABLE_WITH_PICKAXE)
                                                .addOptional(DataGenUtil.getResource(b.get())));

                // ores
                zBlocks.zOres.getEntries()
                                .forEach(b -> tag(BlockTags.MINEABLE_WITH_PICKAXE)
                                                .add(b.get()));

                // goo blocks
                zBlocks.zGoo.getEntries()
                                .forEach(b -> tag(BlockTags.MINEABLE_WITH_SHOVEL)
                                                .add(b.get()));

                zBlocks.zOres.getEntries()
                                .forEach(b -> tag(Tags.Blocks.ORES)
                                                .add(b.get()));

                tag(REVITALIZER_GOO).add(
                                Registration.GooBlock_Tier1.get(),
                                Registration.GooBlock_Tier2.get(),
                                Registration.GooBlock_Tier3.get(),
                                Registration.GooBlock_Tier4.get());

                zBlocks.zOres.getEntries()
                                .forEach(b -> tag(JustDireBlockTags.PARADOX_ALLOW)
                                                .add(b.get()));

                tag(zMultiTags.COPPER_BLOCKS.block()).add(
                                Blocks.COPPER_BLOCK, Blocks.WAXED_COPPER_BLOCK,
                                Blocks.WEATHERED_COPPER, Blocks.WAXED_WEATHERED_COPPER,
                                Blocks.EXPOSED_COPPER, Blocks.WAXED_EXPOSED_COPPER,
                                Blocks.OXIDIZED_COPPER, Blocks.WAXED_OXIDIZED_COPPER);

                tag(zMultiTags.AMETHYST_BLOCKS.block()).add(Blocks.AMETHYST_BLOCK, Blocks.BUDDING_AMETHYST);

                tag(zMultiTags.T2_SPREAD.block()).add(
                                Registration.GooBlock_Tier1.get());

                tag(zMultiTags.T3_SPREAD.block()).add(
                                Registration.GooBlock_Tier2.get()).addTag(zMultiTags.T2_SPREAD.block());

                tag(zMultiTags.T4_SPREAD.block()).add(
                                Registration.GooBlock_Tier3.get()).addTag(zMultiTags.T3_SPREAD.block());

                tag(zBlockTags.PICKER_DENY)
                                // JustDireBlockTags.SWAPPERDENY only work on datagen...
                                .add(Blocks.PISTON_HEAD).add(Blocks.MOVING_PISTON).add(Blocks.BEDROCK)
                                .add(Blocks.END_PORTAL_FRAME).add(Blocks.CANDLE_CAKE).addTag(BlockTags.BEDS)
                                .addTag(BlockTags.PORTALS).addTag(BlockTags.DOORS);

                tag(zBlockTags.SWAPPER_DENY)
                                .add(Blocks.PISTON_HEAD).add(Blocks.MOVING_PISTON).add(Blocks.BEDROCK)
                                .add(Blocks.END_PORTAL_FRAME).add(Blocks.CANDLE_CAKE).addTag(BlockTags.BEDS)
                                .addTag(BlockTags.PORTALS).addTag(BlockTags.DOORS);

                tag(zBlockTags.COAL_BLOCKS)
                                .add(Blocks.COAL_BLOCK)
                                .add(Registration.CharcoalBlock.get())
                                .addOptionalTag(JustDireBlockTags.CHARCOAL);

                tag(zMultiTags.T1_GOO_TYPE.block())
                                .add(Registration.GooBlock_Tier1.get(),
                                                zBlocks.T1_GOO.get());

                tag(zMultiTags.T2_GOO_TYPE.block())
                                .add(Registration.GooBlock_Tier2.get(),
                                                zBlocks.T2_GOO.get());

                tag(zMultiTags.T3_GOO_TYPE.block())
                                .add(Registration.GooBlock_Tier3.get(),
                                                zBlocks.T3_GOO.get());

                tag(zMultiTags.T4_GOO_TYPE.block())
                                .add(Registration.GooBlock_Tier4.get(),
                                                zBlocks.T4_GOO.get());

        }

}