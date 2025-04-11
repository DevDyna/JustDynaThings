package com.devdyna.justdynathings.datagen.server;

import java.util.concurrent.CompletableFuture;

import com.devdyna.justdynathings.Main;
import com.devdyna.justdynathings.registry.types.Blocks;
import com.devdyna.justdynathings.utils.DataGenUtil;
import com.direwolf20.justdirethings.datagen.JustDireBlockTags;
import com.direwolf20.justdirethings.setup.Registration;

import static com.devdyna.justdynathings.registry.types.BlockTags.*;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
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

                Blocks.zBlock.getEntries()
                                .forEach(b -> tag(BlockTags.MINEABLE_WITH_PICKAXE)
                                                .addOptional(DataGenUtil.getResource(b.get())));

                Blocks.zOres.getEntries()
                                .forEach(b -> tag(BlockTags.MINEABLE_WITH_PICKAXE)
                                                .add(b.get()));

                Blocks.zOres.getEntries()
                                .forEach(b -> tag(Tags.Blocks.ORES)
                                                .add(b.get()));

                tag(REFORGER_REPLACE).addTag(BlockTags.STONE_ORE_REPLACEABLES);
                tag(REFORGER_RESULT).addTag(Tags.Blocks.ORES_IN_GROUND_STONE);

                tag(REVITALIZER_GOO).add(
                                Registration.GooBlock_Tier1.get(),
                                Registration.GooBlock_Tier2.get(),
                                Registration.GooBlock_Tier3.get(),
                                Registration.GooBlock_Tier4.get()
                );

                tag(TICKER_DENY).addTag(JustDireBlockTags.TICK_SPEED_DENY);

        }

}