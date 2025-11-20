package com.devdyna.justdynathings.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.registry.types.zBlockTags;
import com.devdyna.justdynathings.registry.types.zBlocks;
import com.devdyna.justdynathings.utils.DataGenUtil;
import com.direwolf20.justdirethings.datagen.JustDireBlockTags;
import com.direwolf20.justdirethings.setup.Registration;

import static com.devdyna.justdynathings.Main.ID;
import static com.devdyna.justdynathings.registry.types.zBlockTags.*;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

@SuppressWarnings({ "null", "unchecked" })

public class DataBlockTag extends BlockTagsProvider {

        public DataBlockTag(PackOutput o, CompletableFuture<Provider> p, ExistingFileHelper f) {
                super(o, p, ID, f);
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

                zBlocks.zOres.getEntries()
                                .forEach(b -> {
                                        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                                                        .add(b.get());
                                        tag(JustDireBlockTags.PARADOX_ALLOW).add(b.get());
                                        tag(Tags.Blocks.ORES).add(b.get());
                                });

                zBlocks.zGoo.getEntries()
                                .forEach(b -> tag(BlockTags.MINEABLE_WITH_SHOVEL)
                                                .add(b.get()));

                tag(STABILIZER_BELOW).add(
                                Registration.GooBlock_Tier1.get(),
                                Registration.GooBlock_Tier2.get(),
                                Registration.GooBlock_Tier3.get(),
                                Registration.GooBlock_Tier4.get(),
                                zBlocks.PARADOX_MIXER.get());

                tag(zBlockTags.T2_SPREAD).add(
                                Registration.GooBlock_Tier1.get());

                tag(zBlockTags.T3_SPREAD).add(
                                Registration.GooBlock_Tier2.get()).addTag(zBlockTags.T2_SPREAD);

                tag(zBlockTags.T4_SPREAD).add(
                                Registration.GooBlock_Tier3.get()).addTag(zBlockTags.T3_SPREAD);

                tag(zBlockTags.PICKER_DENY)
                                .add(Blocks.PISTON_HEAD, Blocks.MOVING_PISTON, Blocks.BEDROCK,
                                                Blocks.END_PORTAL_FRAME, Blocks.CANDLE_CAKE)
                                .addTags(BlockTags.BEDS,
                                                BlockTags.PORTALS, BlockTags.DOORS,
                                                Tags.Blocks.RELOCATION_NOT_SUPPORTED)
                                .remove(Tags.Blocks.BUDDING_BLOCKS)
                                .addOptionalTag(JustDireBlockTags.SWAPPERDENY.location());

                tag(zBlockTags.SWAPPER_DENY)
                                .add(Blocks.PISTON_HEAD, Blocks.MOVING_PISTON, Blocks.BEDROCK,
                                                Blocks.END_PORTAL_FRAME, Blocks.CANDLE_CAKE)
                                .addTags(BlockTags.BEDS,
                                                BlockTags.PORTALS, BlockTags.DOORS,
                                                Tags.Blocks.RELOCATION_NOT_SUPPORTED)
                                .remove(Tags.Blocks.BUDDING_BLOCKS)
                                .addOptionalTag(JustDireBlockTags.SWAPPERDENY.location());

                tag(zBlockTags.COAL_BLOCKS)
                                .add(Blocks.COAL_BLOCK, Registration.CharcoalBlock.get())
                                .addOptionalTag(JustDireBlockTags.CHARCOAL);

                tag(zBlockTags.T1_GOO_TYPE)
                                .add(Registration.GooBlock_Tier1.get(),
                                                zBlocks.T1_GOO.get());

                tag(zBlockTags.T2_GOO_TYPE)
                                .add(Registration.GooBlock_Tier2.get(),
                                                zBlocks.T2_GOO.get());

                tag(zBlockTags.T3_GOO_TYPE)
                                .add(Registration.GooBlock_Tier3.get(),
                                                zBlocks.T3_GOO.get());

                tag(zBlockTags.T4_GOO_TYPE)
                                .add(Registration.GooBlock_Tier4.get(),
                                                zBlocks.T4_GOO.get());

                tag(zBlockTags.ADVANCED_TIME_DENY).addOptional(JustDireBlockTags.TICK_SPEED_DENY.location());

                tag(zBlockTags.TICKER_DENY).addOptional(JustDireBlockTags.TICK_SPEED_DENY.location());

                tag(BlockTags.REPLACEABLE).add(zBlocks.LIGHT_WAND_BLOCK.get());
                tag(BlockTags.WITHER_IMMUNE).add(zBlocks.LIGHT_WAND_BLOCK.get());
                tag(BlockTags.DRAGON_TRANSPARENT).add(zBlocks.LIGHT_WAND_BLOCK.get());
                tag(BlockTags.ENCHANTMENT_POWER_TRANSMITTER).add(zBlocks.LIGHT_WAND_BLOCK.get());

        }

}