package com.devdyna.justdynathings.datagen.server;

import static com.devdyna.justdynathings.Main.ID;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.devdyna.justdynathings.registry.types.zBiomeTags;
import com.devdyna.justdynathings.utils.DataGenUtil;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

@SuppressWarnings("null")

public class DataBiomeTag extends BiomeTagsProvider {

        public DataBiomeTag(PackOutput o, CompletableFuture<Provider> p,
                        @Nullable ExistingFileHelper f) {
                super(o, p, ID, f);
        }

        @Override
        protected void addTags(Provider p) {

                tag(zBiomeTags.FERRICORE_SOLAR_PANEL_BIOME_LIST)
                                .addTag(Tags.Biomes.IS_OVERWORLD)
                                .addTag(Tags.Biomes.IS_VOID)
                                .addOptional(DataGenUtil.getResource("mining", "jamd"))
                                .addOptional(DataGenUtil.getResource("void", "javd"));

                tag(zBiomeTags.BLAZEGOLD_SOLAR_PANEL_BIOME_LIST)
                                .addTag(Tags.Biomes.IS_NETHER)
                                .addOptionalTag(DataGenUtil.getResource("nether", "jamd"));
                // noOp
                tag(zBiomeTags.CELESTIGEM_SOLAR_PANEL_BIOME_LIST).add();
                // noOp
                tag(zBiomeTags.ECLIPSEALLOY_SOLAR_PANEL_BIOME_LIST).add();

                tag(zBiomeTags.SOLAR_PANEL_BIOME_IGNORE_DAYTIME)
                                .addOptional(DataGenUtil.getResource("mining", "jamd"))
                                .addOptional(DataGenUtil.getResource("nether", "jamd"))
                                .addOptional(DataGenUtil.getResource("end", "jamd"))
                                .addOptional(DataGenUtil.getResource("void", "javd"));
        }

}