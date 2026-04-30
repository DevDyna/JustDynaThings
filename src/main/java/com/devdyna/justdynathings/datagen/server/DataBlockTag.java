package com.devdyna.justdynathings.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.JustDynaThings;
import com.devdyna.justdynathings.init.types.zBlockTags;
import com.devdyna.justdynathings.init.types.zBlocks;
import com.direwolf20.justdirethings.setup.JDTRegistration;
import com.direwolf20.justdirethings.util.ModTags;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

public class DataBlockTag extends BlockTagsProvider {

        public DataBlockTag(PackOutput output, CompletableFuture<Provider> lookupProvider) {
                super(output, lookupProvider, JustDynaThings.MODULE_ID);
        }

        
        @Override
        protected void addTags(Provider p) {

                zBlocks.zBlock.getEntries()
                                .forEach(b -> tag(BlockTags.MINEABLE_WITH_PICKAXE)
                                                .addOptional(b.get()));
                zBlocks.zBlockItem.getEntries()
                                .forEach(b -> tag(BlockTags.MINEABLE_WITH_PICKAXE)
                                                .addOptional(b.get()));

                

                tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(zBlocks.T1_GOO.get(),zBlocks.T2_GOO.get(),zBlocks.T3_GOO.get(),zBlocks.T4_GOO.get());

                tag(zBlockTags.STABILIZER_BELOW).add(
                                JDTRegistration.GooBlock_Tier1.get(),
                                JDTRegistration.GooBlock_Tier2.get(),
                                JDTRegistration.GooBlock_Tier3.get(),
                                JDTRegistration.GooBlock_Tier4.get(),
                                zBlocks.PARADOX_MIXER.get());

                tag(zBlockTags.T2_SPREAD).add(
                                JDTRegistration.GooBlock_Tier1.get());

                tag(zBlockTags.T3_SPREAD).add(
                                JDTRegistration.GooBlock_Tier2.get()).addTag(zBlockTags.T2_SPREAD);

                tag(zBlockTags.T4_SPREAD).add(
                                JDTRegistration.GooBlock_Tier3.get()).addTag(zBlockTags.T3_SPREAD);

                tag(zBlockTags.PICKER_DENY)
                                .add(Blocks.PISTON_HEAD, Blocks.MOVING_PISTON, Blocks.BEDROCK,
                                                Blocks.END_PORTAL_FRAME, Blocks.CANDLE_CAKE)
                                .addTags(BlockTags.BEDS,
                                                BlockTags.PORTALS, BlockTags.DOORS,
                                                Tags.Blocks.RELOCATION_NOT_SUPPORTED)
                                .remove(Tags.Blocks.BUDDING_BLOCKS)
                                .addOptionalTag(ModTags.Blocks.SWAPPERDENY);

                tag(zBlockTags.SWAPPER_DENY)
                                .add(Blocks.PISTON_HEAD, Blocks.MOVING_PISTON, Blocks.BEDROCK,
                                                Blocks.END_PORTAL_FRAME, Blocks.CANDLE_CAKE)
                                .addTags(BlockTags.BEDS,
                                                BlockTags.PORTALS, BlockTags.DOORS,
                                                Tags.Blocks.RELOCATION_NOT_SUPPORTED)
                                .remove(Tags.Blocks.BUDDING_BLOCKS)
                                .addOptionalTag(ModTags.Blocks.SWAPPERDENY);

                tag(zBlockTags.COAL_BLOCKS)
                                .add(Blocks.COAL_BLOCK, JDTRegistration.CharcoalBlock.get())
                                .addOptionalTag(ModTags.Blocks.CHARCOAL);

                tag(zBlockTags.T1_GOO_TYPE)
                                .add(JDTRegistration.GooBlock_Tier1.get(),
                                                zBlocks.T1_GOO.get());

                tag(zBlockTags.T2_GOO_TYPE)
                                .add(JDTRegistration.GooBlock_Tier2.get(),
                                                zBlocks.T2_GOO.get());

                tag(zBlockTags.T3_GOO_TYPE)
                                .add(JDTRegistration.GooBlock_Tier3.get(),
                                                zBlocks.T3_GOO.get());

                tag(zBlockTags.T4_GOO_TYPE)
                                .add(JDTRegistration.GooBlock_Tier4.get(),
                                                zBlocks.T4_GOO.get());

                tag(zBlockTags.ADVANCED_TIME_DENY).addOptionalTag(ModTags.Blocks.TICK_SPEED_DENY);

                tag(zBlockTags.TICKER_DENY).addOptionalTag(ModTags.Blocks.TICK_SPEED_DENY);

                tag(BlockTags.REPLACEABLE).add(zBlocks.LIGHT_WAND_BLOCK.get());
                tag(BlockTags.WITHER_IMMUNE).add(zBlocks.LIGHT_WAND_BLOCK.get());
                tag(BlockTags.DRAGON_TRANSPARENT).add(zBlocks.LIGHT_WAND_BLOCK.get());
                tag(BlockTags.ENCHANTMENT_POWER_TRANSMITTER).add(zBlocks.LIGHT_WAND_BLOCK.get());

        }

}